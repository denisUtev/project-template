package hw1;

public class Task5 {

    private static final int MIN_DESCENDANT = 11;
    public static boolean isPalindromeDescendant(int num){
        int lastDescendant = num;
        int descendant = num;
        int step = 0;
        while (descendant >= MIN_DESCENDANT){
            if(isPalindrom(descendant))
                return true;
            descendant = 0;
            step = 0;
            while(lastDescendant > 0){
                descendant += (int) (Math.pow(10, step) * (lastDescendant % 10 + (lastDescendant % 100) / 10));
                lastDescendant /= 100;
                step++;
            }
            lastDescendant = descendant;
        }
        return false;
    }

    private static boolean isPalindrom(int num){
        int reversedNum = 0;
        int a = num;
        while(a > 0){
            reversedNum = reversedNum * 10 + a % 10;
            a /= 10;
        }
        return reversedNum == num;
    }
}
