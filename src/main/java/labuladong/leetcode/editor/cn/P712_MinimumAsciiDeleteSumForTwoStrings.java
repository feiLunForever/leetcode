//<p>Given two strings <code>s1</code> and&nbsp;<code>s2</code>, return <em>the lowest <strong>ASCII</strong> sum of deleted characters to make two strings equal</em>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> s1 = "sea", s2 = "eat"
//<strong>Output:</strong> 231
//<strong>Explanation:</strong> Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
//Deleting "t" from "eat" adds 116 to the sum.
//At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> s1 = "delete", s2 = "leet"
//<strong>Output:</strong> 403
//<strong>Explanation:</strong> Deleting "dee" from "delete" to turn the string into "let",
//adds 100[d] + 101[e] + 101[e] to the sum.
//Deleting "e" from "leet" adds 101[e] to the sum.
//At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
//If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= s1.length, s2.length &lt;= 1000</code></li> 
// <li><code>s1</code> and <code>s2</code> consist of lowercase English letters.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>
//
//<div>👍 300, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Minimum ASCII Delete Sum for Two Strings
 *
 * @author DY
 * @date 2022-10-22 08:14:16
 */
public class P712_MinimumAsciiDeleteSumForTwoStrings {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P712_MinimumAsciiDeleteSumForTwoStrings().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            int[][] cache = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(cache[i], -1);
            }
            return dp(s1, 0, s2, 0, cache);
        }

        private int dp(String s1, int i, String s2, int j, int[][] cache) {
            if (i == s1.length()) {
                int res = 0;
                for (int k = j; k < s2.length(); k++) {
                    res += s2.charAt(k);
                }
                return res;
            }
            if (j == s2.length()) {
                int res = 0;
                for (int k = i; k < s1.length(); k++) {
                    res += s1.charAt(k);
                }
                return res;
            }
            if (cache[i][j] != -1) return cache[i][j];
            if (s1.charAt(i) == s2.charAt(j)) {
                cache[i][j] = dp(s1, i + 1, s2, j + 1, cache);
            } else {
                cache[i][j] = Math.min(
                        s1.charAt(i) + dp(s1, i + 1, s2, j, cache),
                        s2.charAt(j) + dp(s1, i, s2, j + 1, cache)
                );
            }
            return cache[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}