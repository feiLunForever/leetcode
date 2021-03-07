package 面试整理.动态规划;

public class lengthOfLIS_300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length]; //代表以dp[i] 为结尾的最长子序列
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1; //初始化为1，标识当前以自己为节点的情况下，最长子序列长度为1
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}
