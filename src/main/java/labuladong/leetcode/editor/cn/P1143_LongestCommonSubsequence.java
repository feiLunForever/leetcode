//<p>Given two strings <code>text1</code> and <code>text2</code>, return <em>the length of their longest <strong>common subsequence</strong>. </em>If there is no <strong>common subsequence</strong>, return <code>0</code>.</p>
//
//<p>A <strong>subsequence</strong> of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.</p>
//
//<ul> 
// <li>For example, <code>"ace"</code> is a subsequence of <code>"abcde"</code>.</li> 
//</ul>
//
//<p>A <strong>common subsequence</strong> of two strings is a subsequence that is common to both strings.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> text1 = "abcde", text2 = "ace" 
//<strong>Output:</strong> 3  
//<strong>Explanation:</strong> The longest common subsequence is "ace" and its length is 3.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> text1 = "abc", text2 = "abc"
//<strong>Output:</strong> 3
//<strong>Explanation:</strong> The longest common subsequence is "abc" and its length is 3.
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> text1 = "abc", text2 = "def"
//<strong>Output:</strong> 0
//<strong>Explanation:</strong> There is no such common subsequence, so the result is 0.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= text1.length, text2.length &lt;= 1000</code></li> 
// <li><code>text1</code> and <code>text2</code> consist of only lowercase English characters.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>
//
//<div>👍 1148, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Longest Common Subsequence
 *
 * @author DY
 * @date 2022-10-20 09:37:01
 */
public class P1143_LongestCommonSubsequence {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1143_LongestCommonSubsequence().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length(), n = text2.length();
            int[][] cache = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(cache[i], -1);
            }
            return dp(text1, 0, text2, 0, cache);
        }

        private int dp(String text1, int i, String text2, int j, int[][] cache) {
            if (i == text1.length() || j == text2.length()) return 0;
            if (cache[i][j] != -1) return cache[i][j];
            if (text1.charAt(i) == text2.charAt(j)) {
                cache[i][j] = 1 + dp(text1, i + 1, text2, j + 1, cache);
            } else {
                cache[i][j] = Math.max(dp(text1, i + 1, text2, j, cache),
                        dp(text1, i, text2, j + 1, cache));
            }
            return cache[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}