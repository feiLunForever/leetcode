package labuladong.template;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(left_bound(new int[]{1, 2, 2, 2, 3}, 2));
        System.out.println(right_bound(new int[]{1, 2, 2, 2, 3, 3, 3, 3}, 2));
    }

    public static int binary_search(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int left_bound(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) { // 当前 < target，所以直接上调左边界
                left = mid + 1;
            } else if (nums[mid] > target) { // 当前 > target，所以直接下调左边界
                right = mid - 1;
            } else if (nums[mid] == target) { // 当前 = target，不确定mid就是最左边界，锁定左边界，下调右边界
                right = mid - 1;
            }
        }
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }

    public static int right_bound(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) { // 当前 = target，不确定mid就是最右边界，锁定右边界，上调左边界
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 判断一下 nums[left] 是不是 target
        return nums[right] == target ? right : -1;
    }

}
