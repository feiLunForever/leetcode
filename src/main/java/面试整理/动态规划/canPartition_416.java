package 面试整理.动态规划;

public class canPartition_416 {
    /**
     * 转换成01背包
     * 背包的容量为总和SUM/2
     *
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        int target = (sum & 1) == 0 ? sum >>> 1 : -1;
        if (target == -1)
            return false;
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }

    public static void main(String[] args) {
        boolean b = canPartition(new int[]{1, 5, 11, 5});
        System.out.println(b);
    }

}
