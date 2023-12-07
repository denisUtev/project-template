package edu.hw6.Task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {

    private Path dataBaseFile;
    private HashMap<String, String> diskMap = new HashMap<>();

    public DiskMap(Path path) {
        dataBaseFile = path;
        if (dataBaseFile.toFile().exists() && dataBaseFile.toFile().isFile()) {
            loadData();
        }
    }

    public DiskMap(String path) {
        this(Path.of(path));
    }

    private void loadData() {
        diskMap = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dataBaseFile.toFile()));
            while (reader.ready()) {
                String[] entry = reader.readLine().split(":");
                diskMap.put(entry[0], entry[1]);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("MultipleStringLiterals")
    private void saveData() {
        try (PrintWriter writer = new PrintWriter(dataBaseFile.toFile())) {
            for (var entry : diskMap.entrySet()) {
                writer.println(String.format("%s:%s", entry.getKey(), entry.getValue()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void changePathFile(String path) {
        dataBaseFile = Path.of(path);
    }

    public void changePathFile(Path path) {
        dataBaseFile = path;
    }

    @Override
    public int size() {
        return diskMap.size();
    }

    @Override
    public boolean isEmpty() {
        return diskMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return diskMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return diskMap.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return diskMap.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        if (!diskMap.containsKey(key)) {
            try (FileOutputStream writer = new FileOutputStream(dataBaseFile.toFile(), true)) {
                writer.write(key.getBytes());
                writer.write(':');
                writer.write(value.getBytes());
                writer.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return diskMap.put(key, value);
        }

        String val = diskMap.put(key, value);
        saveData();

        return val;
    }

    @Override
    public String remove(Object key) {
        String value = diskMap.get(key);
        diskMap.remove(key);
        try (PrintWriter writer = new PrintWriter(dataBaseFile.toFile())) {
            for (var entry : diskMap.entrySet()) {
                writer.println(String.format("%s:%s", entry.getKey(), entry.getValue()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return value;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        boolean isHasIntersection = m.entrySet().stream().anyMatch(a -> diskMap.containsKey(a.getKey()));
        if (!isHasIntersection) {
            try (FileOutputStream writer = new FileOutputStream(dataBaseFile.toFile(), true)) {
                for (var entry : m.entrySet()) {
                    writer.write(entry.getKey().getBytes());
                    writer.write(':');
                    writer.write(entry.getValue().getBytes());
                    writer.write('\n');
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            diskMap.putAll(m);
        } else {
            diskMap.putAll(m);
            saveData();
        }
    }

    @Override
    public void clear() {
        try {
            Files.delete(dataBaseFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        diskMap.clear();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return diskMap.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return diskMap.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return diskMap.entrySet();
    }
}
