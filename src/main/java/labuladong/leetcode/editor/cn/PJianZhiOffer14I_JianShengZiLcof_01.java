/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>数学 | 动态规划</details><br>
 *
 * <div>👍 607, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 剪绳子  LCOF
 *
 * @author DY
 * @date 2023-07-27 22:00:59
 */
public class PJianZhiOffer14I_JianShengZiLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer14I_JianShengZiLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cuttingRope(int n) {
            int[] dp = new int[n + 1]; // dp[i] 长度为i的绳子，最大结果
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                for (int j = 2; j < i ; j++) {
                    dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
