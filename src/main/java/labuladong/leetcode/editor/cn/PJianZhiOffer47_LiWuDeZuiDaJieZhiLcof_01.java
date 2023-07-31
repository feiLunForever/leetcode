/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>数组 | 动态规划 | 矩阵</details><br>
 *
 * <div>👍 509, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 礼物的最大价值 LCOF
 *
 * @author DY
 * @date 2023-07-31 10:48:37
 */
public class PJianZhiOffer47_LiWuDeZuiDaJieZhiLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer47_LiWuDeZuiDaJieZhiLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValue(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] dp = new int[m][n]; // dp[i][j] => dp[0][0] -> dp[i][j] 最大值
            dp[0][0] = grid[0][0];
            for (int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];
            for (int j = 1; j < n; j++) dp[0][j] = dp[0][j - 1] + grid[0][j];
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[m-1][n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
