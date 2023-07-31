/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>递归 | 字符串 | 动态规划</details><br>
 *
 * <div>👍 550, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 正则表达式匹配 LCOF
 *
 * @author DY
 * @date 2023-07-31 19:18:23
 */
public class PJianZhiOffer19_ZhengZeBiaoDaShiPiPeiLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer19_ZhengZeBiaoDaShiPiPeiLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            boolean[][] memo = new boolean[s.length()][p.length()];
            return dfs(s, 0, p, 0, memo);
        }

        private boolean dfs(String s, int i, String p, int j, boolean[][] memo) {
            if (j == p.length()) return i == s.length();
            if (i == s.length()) {
                if (((p.length() - j) & 1) == 1) return false;
                for (int k = j; k < p.length(); k += 2) {
                    if (p.charAt(k + 1) != '*') return false;
                }
                return true;
            }
            if (memo[i][j]) return true;
            boolean res;
            if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') { // 匹配
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    res = dfs(s, i + 1, p, j, memo) // 匹配多次
                            || dfs(s, i, p, j + 2, memo); // 匹配0次
                } else {
                    res = dfs(s, i + 1, p, j + 1, memo); // 匹配1次
                }
            } else {
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    res = dfs(s, i, p, j + 2, memo); // 匹配0次
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
