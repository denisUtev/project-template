package edu.hw1;

public final class Task3 {

    private Task3() {
    }

    public static boolean isNestable(int[] a1, int[] a2) {
        return min(a1) > min(a2) && max(a1) < max(a2);
    }

    private static int min(int[] nums) {
        int minNum = nums[0];
        for (int num : nums) {
            minNum = Math.min(minNum, num);
        }
        return minNum;
    }

    private static int max(int[] nums) {
        int maxNum = nums[0];
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        return maxNum;
    }
}
