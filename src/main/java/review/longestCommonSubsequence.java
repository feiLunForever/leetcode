package review;

public class longestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        // dp[x][y] 代表 x序列和y序列最大公共子序列
        int x = text1.length(), y = text2.length();
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[x][y];
    }
}
