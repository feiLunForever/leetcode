//<p>Given an input string <code>s</code>&nbsp;and a pattern <code>p</code>, implement regular expression matching with support for <code>'.'</code> and <code>'*'</code> where:</p>
//
//<ul> 
// <li><code>'.'</code> Matches any single character.​​​​</li> 
// <li><code>'*'</code> Matches zero or more of the preceding element.</li> 
//</ul>
//
//<p>The matching should cover the <strong>entire</strong> input string (not partial).</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = "aa", p = "a"
//<strong>Output:</strong> false
//<strong>Explanation:</strong> "a" does not match the entire string "aa".
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = "aa", p = "a*"
//<strong>Output:</strong> true
//<strong>Explanation:</strong> '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = "ab", p = ".*"
//<strong>Output:</strong> true
//<strong>Explanation:</strong> ".*" means "zero or more (*) of any character (.)".
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= s.length&nbsp;&lt;= 20</code></li> 
// <li><code>1 &lt;= p.length&nbsp;&lt;= 30</code></li> 
// <li><code>s</code> contains only lowercase English letters.</li> 
// <li><code>p</code> contains only lowercase English letters, <code>'.'</code>, and&nbsp;<code>'*'</code>.</li> 
// <li>It is guaranteed for each appearance of the character <code>'*'</code>, there will be a previous valid character to match.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>递归 | 字符串 | 动态规划</details><br>
//
//<div>👍 3279, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Regular Expression Matching
 *
 * @author DY
 * @date 2022-10-26 16:44:46
 */
public class P10_RegularExpressionMatching {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P10_RegularExpressionMatching().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            int[][] dp = new int[s.length()][p.length()];
            return dp(s, 0, p, 0, dp);
        }

        private boolean dp(String s, int i, String p, int j, int[][] dp) {
            int m = s.length(), n = p.length();
            if (j == n) return i == m;
            if (i == m) {
				if ((n - j) % 2 == 1) {
					return false;
				}
                for (; j + 1 < n; j += 2) {
                    if (p.charAt(j + 1) != '*') {
                        return false;
                    }
                }
                return true;
            }
            if (dp[i][j] != 0) {
                return dp[i][j] == 1;
            }
            boolean res = false;
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                if (j < n - 1 && p.charAt(j + 1) == '*') {
                    res = dp(s, i, p, j + 2, dp) || dp(s, i + 1, p, j, dp);
                } else {
                    res = dp(s, i + 1, p, j + 1, dp);
                }
            } else {
                if (j < n - 1 && p.charAt(j + 1) == '*') {
                    res = dp(s, i, p, j + 2, dp);
                } else {
                    res = false;
                }
            }
            dp[i][j] = res ? 1 : -1;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}