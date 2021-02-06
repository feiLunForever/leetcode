package org.example.剑指Offer;

public class missingNumber_53_II {
    public static int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (j + i) >>> 1;
            if (nums[mid] == mid) i = mid + 1;
            else j = mid - 1;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3};
        System.out.println(missingNumber(nums));
    }
}
