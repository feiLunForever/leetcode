package 面试整理.栈和队列;

/**
 * 动态规划
 */
public class numSquares_279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 每次都将当前数字先更新为最大的结果，即 dp[i]=i，比如 i=4
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
