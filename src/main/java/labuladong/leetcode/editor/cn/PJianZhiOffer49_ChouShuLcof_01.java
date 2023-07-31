/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>哈希表 | 数学 | 动态规划 | 堆（优先队列）</details><br>
 *
 * <div>👍 486, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 丑数 LCOF
 *
 * @author DY
 * @date 2023-07-31 11:11:14
 */
public class PJianZhiOffer49_ChouShuLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer49_ChouShuLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n];
            int a = 0, b = 0, c = 0;
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                int n2 = 2 * dp[a];
                int n3 = 3 * dp[b];
                int n5 = 5 * dp[c];
                dp[i] = Math.min(Math.min(n2, n3), n5);
                if (n2 == dp[i]) ++a;
                if (n3 == dp[i]) ++b;
                if (n5 == dp[i]) ++c;
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
