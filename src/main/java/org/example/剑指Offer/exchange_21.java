package org.example.剑指Offer;

public class exchange_21 {
    public static int[] exchange(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] % 2 == 1) {
                start++;
            }
            if (nums[end] % 2 == 0) {
                end--;
            }
            if (nums[start] % 2 == 0 && nums[end] % 2 == 1 && start < end) {
                int temp = nums[start];
                nums[start++] = nums[end];
                nums[end--] = temp;
            }
        }
        return nums;
    }
    public int[] exchange1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 当找到一个偶数时，就跳出循环。
            // (这里有个求奇偶数的小技巧，就是当一个数是奇数时，它的二进制表示的最后一位肯定是1
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }
            // 当找到一个奇数时，就跳出循环
            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            // 如果两个指针还没有碰到一起时，说明找到了需要交换的位置
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        int[] exchange = exchange(nums);
        System.out.println();
    }
}
