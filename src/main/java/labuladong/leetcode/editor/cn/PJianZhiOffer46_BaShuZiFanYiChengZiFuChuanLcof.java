/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>
 *
 * <div>👍 549, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 把数字翻译成字符串 LCOF
 *
 * @author DY
 * @date 2023-03-21 12:11:52
 */
public class PJianZhiOffer46_BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer46_BaShuZiFanYiChengZiFuChuanLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            if (num <= 0) return 1;
            String str = num + "";
            int[] dp = new int[str.length() + 1]; // dp[i] 代表前i个字符解码数量[0...i-1]
            dp[0] = dp[1] = 1; // 空串和单字符都是1种
            for (int i = 2; i <= str.length(); i++) {
                char cur = str.charAt(i - 1), pre = str.charAt(i - 2);
                if (cur >= '0' && cur <= '9') { // s[i]可以单独作为字母
                    dp[i] += dp[i - 1];
                }
                if (pre == '1' || pre == '2' && cur <= '5') { // s[i]和s[i-1]可以作为字母
                    dp[i] += dp[i - 2];
                }
            }
            return dp[str.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
