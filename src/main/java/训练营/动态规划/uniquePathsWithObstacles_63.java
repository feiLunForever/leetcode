package 训练营.动态规划;

import java.util.HashMap;

public class uniquePathsWithObstacles_63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        return dfs(new HashMap<String, Integer>(), obstacleGrid, 0, 0);
    }

    private static int dfs(HashMap<String, Integer> cache, int[][] obstacleGrid, int x, int y) {
        if (cache.containsKey(x + "_" + y)) { // 如果缓存中存在，则直接返回（之前走过这条路了）
            return cache.get(x + "_" + y);
        }
        if (x >= obstacleGrid.length || y >= obstacleGrid[0].length || obstacleGrid[x][y] == 1) {
            return 0; // 出边界，或者是障碍物
        }
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            return 1; // 到达终点
        }
        // 继续往右(i,j+1)、往下(i+1,j)递归调用
        int res = dfs(cache, obstacleGrid, x + 1, y) + dfs(cache, obstacleGrid, x, y + 1);
        cache.put(x + "_" + y, res);
        return res;
    }

    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int x = obstacleGrid.length, y = obstacleGrid[0].length;
        int dp[][] = new int[x][y];

        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1; //(0,0)这个格子可能有障碍物

        //处理第一列
        for (int i = 1; i < x && obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1; i++) dp[i][0] = 1;
        // 处理第一行
        for (int i = 1; i < y && obstacleGrid[0][i] == 0 && dp[0][i - 1] == 1; i++) dp[0][i] = 1;

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (obstacleGrid[i][j] == 1) { // 当前格子是障碍物
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; //路径总数来自于上方(dp[i-1][j])和左方(dp[i][j-1])
                }
            }
        }
        return dp[x - 1][y - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles1(new int[][]{{1, 0}}));
    }

}
