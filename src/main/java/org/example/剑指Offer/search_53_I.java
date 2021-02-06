package org.example.剑指Offer;

public class search_53_I {
    public static int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] >= target) {
                j = mid - 1;
            }
        }
        int sum = 0;
        for (; i <= nums.length - 1; i++) {
            if (nums[i] == target) {
                sum++;
            } else {
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        System.out.println(search(arr, 1));
    }
}
