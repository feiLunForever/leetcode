package 面试整理.数组;

/**
 * 滑动窗口
 */
public class minSubArrayLen_209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = -1; // nums[l,r] 为当前滑动的窗口
        int sum = 0;
        int res = nums.length + 1;
        while (l < nums.length) {
            if (sum < target && ++r < nums.length) { // 当前的和＜目标值，则需要 窗口右边界向右滑动一位
                sum += nums[r];
            } else {
                sum -= nums[l++];  // 当前的和>目标值，则需要 窗口左边界向右滑动一位
            }
            if (sum >= target)
                res = Math.min(res, r - l + 1);
        }
        if (res == nums.length + 1)
            return 0;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 4};
        int res = minSubArrayLen(4, nums);
        System.out.println(res);
    }
}
