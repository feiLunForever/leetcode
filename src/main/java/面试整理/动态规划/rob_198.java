package 面试整理.动态规划;

public class rob_198 {
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int rob = rob(new int[]{1, 2, 3, 1});
        System.out.println(rob);
    }
}
