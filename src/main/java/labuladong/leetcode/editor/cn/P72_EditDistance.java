//<p>Given two strings <code>word1</code> and <code>word2</code>, return <em>the minimum number of operations required to convert <code>word1</code> to <code>word2</code></em>.</p>
//
//<p>You have the following three operations permitted on a word:</p>
//
//<ul> 
// <li>Insert a character</li> 
// <li>Delete a character</li> 
// <li>Replace a character</li> 
//</ul>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> word1 = "horse", word2 = "ros"
//<strong>Output:</strong> 3
//<strong>Explanation:</strong> 
//horse -&gt; rorse (replace 'h' with 'r')
//rorse -&gt; rose (remove 'r')
//rose -&gt; ros (remove 'e')
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> word1 = "intention", word2 = "execution"
//<strong>Output:</strong> 5
//<strong>Explanation:</strong> 
//intention -&gt; inention (remove 't')
//inention -&gt; enention (replace 'i' with 'e')
//enention -&gt; exention (replace 'n' with 'x')
//exention -&gt; exection (replace 'n' with 'c')
//exection -&gt; execution (insert 'u')
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>0 &lt;= word1.length, word2.length &lt;= 500</code></li> 
// <li><code>word1</code> and <code>word2</code> consist of lowercase English letters.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>
//
//<div>👍 2651, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Edit Distance
 *
 * @author DY
 * @date 2022-10-17 22:21:21
 */
public class P72_EditDistance {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P72_EditDistance().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int[][] cache = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(cache[i], -1);
            }
            return dp(word1, m - 1, word2, n - 1, cache);
        }

        private int dp(String word1, int i, String word2, int j, int[][] cache) {
            if (i == -1) return j + 1;
            if (j == -1) return i + 1;
            if (cache[i][j] != -1) return cache[i][j];
            if (word1.charAt(i) == word2.charAt(j)) {
                cache[i][j] = dp(word1, i - 1, word2, j - 1, cache); // 什么都不做
            } else {
                cache[i][j] = Math.min(Math.min(
                        dp(word1, i, word2, j - 1, cache) + 1, // 插入
                        dp(word1, i - 1, word2, j, cache) + 1) // 删除
                        , dp(word1, i - 1, word2, j - 1, cache) + 1); // 替换
            }
            return cache[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}