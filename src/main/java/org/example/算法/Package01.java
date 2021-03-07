package org.example.算法;

/**
 * 01背包问题
 */
public class Package01 {

    public static int getMaxValue(int[] weights, int[] values, int bagWeight) {
        // 初始化二维数组dp
        // dp[i][j] 代表从0-i个物品中选,放入到容量为j的背包中，最大价值为多少。
        int[][] dp = new int[weights.length][bagWeight + 1];
        // 初始化
        for (int j = bagWeight; j >= weights[0]; j--) {
            dp[0][j] = dp[0][j - weights[0]] + values[0];
        }

        for (int i = 1; i < weights.length; i++) { // 遍历物品
            for (int j = 0; j <= bagWeight; j++) { // 遍历背包容量
                if (j < weights[i])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
            }
        }
        return dp[weights.length - 1][bagWeight];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1, 3, 4};
        int[] values = new int[]{15, 20, 30};
        int bagWeight = 4;
        System.out.println(getMaxValue2(weights, values, bagWeight));
    }

    public static int getMaxValue2(int[] weights, int[] values, int bagWeight) {
        // 初始化数组dp
        // dp[i] 代表容量为i的背包中，最大价值为多少。
        int[] dp = new int[bagWeight + 1];

        for (int i = 0; i < weights.length; i++) { // 遍历物品
            for (int j = bagWeight; j >= weights[i]; j--) { // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        return dp[bagWeight];
    }

}
