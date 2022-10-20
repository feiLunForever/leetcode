//<p>Given two strings <code>word1</code> and <code>word2</code>, return <em>the minimum number of <strong>steps</strong> required to make</em> <code>word1</code> <em>and</em> <code>word2</code> <em>the same</em>.</p>
//
//<p>In one <strong>step</strong>, you can delete exactly one character in either string.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> word1 = "sea", word2 = "eat"
//<strong>Output:</strong> 2
//<strong>Explanation:</strong> You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> word1 = "leetcode", word2 = "etco"
//<strong>Output:</strong> 4
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= word1.length, word2.length &lt;= 500</code></li> 
// <li><code>word1</code> and <code>word2</code> consist of only lowercase English letters.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>
//
//<div>👍 503, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Delete Operation for Two Strings
 *
 * @author DY
 * @date 2022-10-20 09:45:08
 */
public class P583_DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P583_DeleteOperationForTwoStrings().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int lcs = longestCommonSubsequence(word1, word2);
            return word1.length() - lcs + word2.length() - lcs;
        }

        private int longestCommonSubsequence(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int[][] cache = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(cache[i], -1);
            }
            return dp(word1, 0, word2, 0, cache);
        }

        private int dp(String word1, int i, String word2, int j, int[][] cache) {
            if (i == word1.length() || j == word2.length()) return 0;
            if (cache[i][j] != -1) return cache[i][j];
            if (word1.charAt(i) == word2.charAt(j)) {
                cache[i][j] = 1 + dp(word1, i + 1, word2, j + 1, cache);
            } else {
                cache[i][j] = Math.max(dp(word1, i + 1, word2, j, cache),
                        dp(word1, i, word2, j + 1, cache));
            }
            return cache[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}