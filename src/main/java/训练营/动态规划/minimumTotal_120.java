package 训练营.动态规划;

import java.util.List;

public class minimumTotal_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1]; // dp[i][j] 代表（i,j） 到底端最小路径和
        for (int i = n - 1; i >= 0; i--) { // 从最后一行开始递推
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
