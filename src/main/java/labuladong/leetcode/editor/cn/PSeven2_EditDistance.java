/**
 * <p>Given two strings <code>word1</code> and <code>word2</code>, return <em>the minimum number of operations required to convert <code>word1</code> to <code>word2</code></em>.</p>
 *
 * <p>You have the following three operations permitted on a word:</p>
 *
 * <ul>
 * <li>Insert a character</li>
 * <li>Delete a character</li>
 * <li>Replace a character</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> word1 = "horse", word2 = "ros"
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong>
 * horse -&gt; rorse (replace 'h' with 'r')
 * rorse -&gt; rose (remove 'r')
 * rose -&gt; ros (remove 'e')
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> word1 = "intention", word2 = "execution"
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong>
 * intention -&gt; inention (remove 't')
 * inention -&gt; enention (replace 'i' with 'e')
 * enention -&gt; exention (replace 'n' with 'x')
 * exention -&gt; exection (replace 'n' with 'c')
 * exection -&gt; execution (insert 'u')
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= word1.length, word2.length &lt;= 500</code></li>
 * <li><code>word1</code> and <code>word2</code> consist of lowercase English letters.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>
 *
 * <div>👍 3003, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Edit Distance
 *
 * @author DY
 * @date 2023-06-17 17:49:31
 */
public class PSeven2_EditDistance {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSeven2_EditDistance().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int[][] memo = new int[m][n];
            for (int[] row : memo) {
                Arrays.fill(row, -1); // -1 代表未计算
            }
            return dp(word1, m - 1, word2, n - 1, memo);
        }

        /**
         * 返回 s1[0..i] 和 s2[0..j-1] 最小编辑距离
         *
         * @param s1
         * @param i
         * @param s2
         * @param j
         * @param memo
         * @return
         */
        private int dp(String s1, int i, String s2, int j, int[][] memo) {
            if (i == -1) return j + 1; // s1 串结束，直接取剩余s2的长度
            if (j == -1) return i + 1; // s2 串结束，直接取剩余s1的长度
            if (memo[i][j] != -1) return memo[i][j];
            if (s1.charAt(i) == s2.charAt(j)) { // s1[i] == s2[j] ，i和j各自-1，往前走
                memo[i][j] = dp(s1, i - 1, s2, j - 1, memo);
            } else {
                memo[i][j] = min(
                        dp(s1, i, s2, j - 1, memo) + 1, // 插入
                        dp(s1, i - 1, s2, j, memo) + 1, // 删除
                        dp(s1, i - 1, s2, j - 1, memo) + 1 // 替换
                );
            }
            return memo[i][j];
        }

        private int min(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
