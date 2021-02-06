package 初级.动态规划;

public class rob {

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        if (length == 1)
            return nums[0];
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int pre = second;
            second = Math.max(second, first + nums[i]);
            first = pre;
        }
        return second;
    }

}
