/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>
 *
 * <div>👍 588, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 把数字翻译成字符串 LCOF
 *
 * @author DY
 * @date 2023-07-31 10:38:22
 */
public class PJianZhiOffer46_BaShuZiFanYiChengZiFuChuanLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer46_BaShuZiFanYiChengZiFuChuanLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            String target = num + "";
            int[] dp = new int[target.length() + 1]; // dp[i] => [0..i-1] 解码数量
            dp[0] = dp[1] = 1;
            for (int i = 2; i <= target.length(); i++) {
                char cur = target.charAt(i - 1);
                char pre = target.charAt(i - 2);
                if (cur >= '0' && cur <= '9') { // s[i] 单独成字母
                    dp[i] += dp[i - 1];
                }
                if (pre == '1' || (pre == '2' && cur <= '5')) { //  s[i]和s[i-1]成字母
                    dp[i] += dp[i - 2];
                }
            }
            return dp[target.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
