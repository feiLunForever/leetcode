package 面试整理.动态规划;

public class integerBreak_343 {
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        return breakInteger(n, dp);
    }

    private static int breakInteger(int n, int[] dp) {
        if (dp[n] != 0)
            return dp[n];
        int res = -1;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * breakInteger(n - i, dp)));
        }
        dp[n] = res;
        return dp[n];
    }

    public static void main(String[] args) {
        int i = integerBreak(10);
        System.out.println(i);
    }
}
