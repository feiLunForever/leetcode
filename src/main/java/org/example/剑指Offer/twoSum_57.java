package org.example.剑指Offer;

public class twoSum_57 {
    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] < target)
                i++;
            else if (nums[i] + nums[j] > target)
                j--;
            else
                return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,26,30,31,47,60};
        int[] ints = twoSum(arr, 40);
        System.out.println();
    }
}
