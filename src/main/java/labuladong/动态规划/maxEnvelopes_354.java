package labuladong.动态规划;

import java.util.Arrays;
import java.util.Comparator;

public class maxEnvelopes_354 {
    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = envelopes[i][1];
        }
        return LIS(nums);
    }

    private static int LIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] envelopes = new int[][]{{1, 1}, {1, 1}, {1, 1}, {1, 1}};
        int i = maxEnvelopes(envelopes);
        System.out.println(i);
    }
}
