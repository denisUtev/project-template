package edu.hw6.Task3;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {

    default AbstractFilter and(AbstractFilter newFilter) {
        return (a) -> accept(a) && newFilter.accept(a);
    }

    static AbstractFilter largerThan(int n) {
        return (path) -> path.toFile().length() > n;
    }

    static AbstractFilter magicNumber(int... nums) {
        return (path) -> {
            try (InputStream stream = new FileInputStream(path.toFile())) {
                for (int num : nums) {
                    if (num != stream.read()) {
                        return false;
                    }
                }
            }
            return true;
        };
    }

    static AbstractFilter globMatches(String glob) {
        return (path) -> {
            String match = getMatchFromGlob(glob);
            Pattern pattern = Pattern.compile(match);
            Matcher matcher = pattern.matcher(path.toFile().getName());
            return matcher.find();
        };
    }

    static String getMatchFromGlob(String glob) {
        return glob.replaceAll("\\*", ".*")
            .replaceAll("\\[!", "[^")
            .replaceAll("\\?", ".?");
    }

    static AbstractFilter regexContains(String match) {
        return (path) -> {
            Pattern pattern = Pattern.compile(match);
            Matcher matcher = pattern.matcher(path.toFile().getName());
            return matcher.find();
        };
    }

}
