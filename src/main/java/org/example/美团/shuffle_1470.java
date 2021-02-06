package org.example.美团;

public class shuffle_1470 {
    public static int[] shuffle(int[] nums, int n) {
        int[] results = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            results[index++] = nums[i];
            results[index++] = nums[i+n];
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,4,3,2,1};
        int[] shuffle = shuffle(nums, 4);
        System.out.println();
    }
}
