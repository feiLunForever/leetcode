/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>哈希表 | 数学 | 动态规划 | 堆（优先队列）</details><br>
 *
 * <div>👍 436, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 丑数 LCOF
 *
 * @author DY
 * @date 2023-03-22 19:03:16
 */
public class PJianZhiOffer49_ChouShuLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer49_ChouShuLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n]; // dp[i] 代表 第i个丑数
            dp[0] = 1;
            int p2 = 0, p3 = 0, p5 = 0; // 代表2,3,5 对应的队列
            for (int i = 1; i < n; i++) {
                dp[i] = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
                if(dp[i] == dp[p2] * 2) ++p2;
                if(dp[i] == dp[p3] * 3) ++p3;
                if(dp[i] == dp[p5] * 5) ++p5;
            }
            return dp[n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
