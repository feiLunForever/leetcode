/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>递归 | 字符串 | 动态规划</details><br>
 *
 * <div>👍 510, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/7uUsXJpFJ8wzuMMxBmS7NQ' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 正则表达式匹配 LCOF
 *
 * @author DY
 * @date 2023-03-06 18:56:32
 */
public class PJianZhiOffer19_ZhengZeBiaoDaShiPiPeiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer19_ZhengZeBiaoDaShiPiPeiLcof().new Solution();
        System.out.println(solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("aa", "a*"));
        System.out.println(solution.isMatch("ab", ".*"));
        System.out.println(solution.isMatch("aab", "c*a*b"));
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length(), n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1]; // dp[i][j] 代表 s[i..] 和 p[j..] 是否匹配
            dp[m][n] = true; // 空串匹配
            // s串匹配 空串，dp[0-m][0] 都为false
            for (int i = n - 2; i >= 0; i--) { // 空串匹配 p[j..]，主要看 p[j..] 是否是 x*z*y*.. 形式
                dp[m][i] = p.charAt(i + 1) == '*' && dp[m][i + 2];
            }
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') { // 分两种情况，当 s[i] == p[j] 时
                        if (j + 1 < n && p.charAt(j + 1) == '*') { // p串下一位是*，有两种情况
                            dp[i][j] = dp[i][j + 2] // 匹配0次，p串后退2步（a*）
                                    || dp[i + 1][j]; // 匹配多长，s串直接后退一步
                        } else {
                            dp[i][j] = dp[i + 1][j + 1]; // p串下一位是正常字符，则各种后退一步
                        }
                    } else { // 当 s[i] != p[j] 时
                        if (j + 1 < n && p.charAt(j + 1) == '*') { // p串下一位是*，则只能匹配0次
                            dp[i][j] = dp[i][j + 2];
                        } else {
                            dp[i][j] = false;
                        }
                    }
                }
            }
            return dp[0][0];
        }








        /*public boolean isMatch(String s, String p) {
            int m = s.length(), n = p.length();
            boolean[][] memo = new boolean[m][n];
            return dfs(s, 0, p, 0, memo);
        }*/

        private boolean dfs(String s, int i, String p, int j, boolean[][] memo) {
            // bad case
            if (j == p.length()) return i == s.length(); // p字符串匹配完的时候，查看s字符串是否匹配完
            if (i == s.length()) { // 当s字符串匹配完的时候，有两种情况，情况一，两个字符串都匹配完，情况二，p: a; s: ab*c*
                if (((p.length() - j) & 1) == 1) return false;// 一定是字符和 * 成对儿出现
                for (int k = j; k < p.length(); k += 2) {
                    if (p.charAt(k + 1) != '*') return false;
                }
                return true;
            }
            if (memo[i][j]) return true;
            boolean res;
            // 一共两种情况，p[j] 与 s[i] 匹配，p[j] 与 s[i] 不匹配
            if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') { // 当p[j] 与 s[i] 匹配时，有两种情况
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') { // 当p[j+1] == '*' 时，有两种情况
                    res = dfs(s, i, p, j + 2, memo) // p[j] 匹配0次
                            || dfs(s, i + 1, p, j, memo); // p[j] 匹配多次
                } else { // p[j] 匹配1次
                    res = dfs(s, i + 1, p, j + 1, memo);
                }

            } else { // p[j] 与 s[i] 不匹配
                // p[j] 只能匹配0次, 且p[j+1] = *
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    res = dfs(s, i, p, j + 2, memo);
                } else {
                    res = false;
                }
            }
            memo[i][j] = res;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
