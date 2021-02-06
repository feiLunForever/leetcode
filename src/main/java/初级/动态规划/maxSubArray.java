package 初级.动态规划;

public class maxSubArray {

    public static int maxSubArray(int[] nums) {
        int pre = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 如果之前的和加上自己都没有自己大，那就舍弃掉，取自己
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

}
