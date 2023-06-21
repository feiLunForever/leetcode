/**
 * <p>Given an input string <code>s</code>&nbsp;and a pattern <code>p</code>, implement regular expression matching with support for <code>'.'</code> and <code>'*'</code> where:</p>
 *
 * <ul>
 * <li><code>'.'</code> Matches any single character.​​​​</li>
 * <li><code>'*'</code> Matches zero or more of the preceding element.</li>
 * </ul>
 *
 * <p>The matching should cover the <strong>entire</strong> input string (not partial).</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "aa", p = "a"
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> "a" does not match the entire string "aa".
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "aa", p = "a*"
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "ab", p = ".*"
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> ".*" means "zero or more (*) of any character (.)".
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length&nbsp;&lt;= 20</code></li>
 * <li><code>1 &lt;= p.length&nbsp;&lt;= 20</code></li>
 * <li><code>s</code> contains only lowercase English letters.</li>
 * <li><code>p</code> contains only lowercase English letters, <code>'.'</code>, and&nbsp;<code>'*'</code>.</li>
 * <li>It is guaranteed for each appearance of the character <code>'*'</code>, there will be a previous valid character to match.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>递归 | 字符串 | 动态规划</details><br>
 *
 * <div>👍 3621, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Regular Expression Matching
 *
 * @author DY
 * @date 2023-06-21 15:59:06
 */
public class POne0_RegularExpressionMatching {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne0_RegularExpressionMatching().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length(), n = p.length();
            Boolean[][] memo = new Boolean[m][n];
            return dp(s, 0, p, 0, memo);
        }

        private boolean dp(String s, int i, String p, int j, Boolean[][] memo) {
            int m = s.length(), n = p.length();
            if (j == n) return i == m;
            if (i == m) {
				if ((n - j) % 2 == 1) {
					return false;
				}
                for (; j + 1 < n; j += 2) { // 检查是否为 x*y*z* 这种形式
                    if (p.charAt(j + 1) != '*') return false;
                }
                return true;
            }
            if (memo[i][j] != null) return memo[i][j];
            boolean res;
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') { // s[i]匹配p[j]
                if (j + 1 < n && p.charAt(j + 1) == '*') { // p[j+1] 为 *
                    res = dp(s, i, p, j + 2, memo) // 匹配0次 或者 多次
                            || dp(s, i + 1, p, j, memo);
                } else {
                    res = dp(s, i + 1, p, j + 1, memo); // 匹配一次
                }
            } else {
                if (j + 1 < n && p.charAt(j + 1) == '*') { // p[j+1] 为 *
                    res = dp(s, i, p, j + 2, memo); // 只能匹配0次
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
