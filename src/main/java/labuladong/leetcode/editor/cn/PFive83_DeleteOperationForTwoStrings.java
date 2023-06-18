/**
 * Given two strings word1 and word2, return the minimum number of steps required
 * to make word1 and word2 the same.
 * <p>
 * In one step, you can delete exactly one character in either string.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: word1 = "sea", word2 = "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make
 * "eat" to "ea".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: word1 = "leetcode", word2 = "etco"
 * Output: 4
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= word1.length, word2.length <= 500
 * word1 and word2 consist of only lowercase English letters.
 * <p>
 * <p>
 * Related Topics字符串 | 动态规划
 * <p>
 * 👍 591, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Delete Operation for Two Strings
 *
 * @author DY
 * @date 2023-06-18 09:04:35
 */
public class PFive83_DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFive83_DeleteOperationForTwoStrings().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] memo = new int[word1.length()][word2.length()];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            int lcs = dp(word1, 0, word2, 0, memo);
            return word1.length() - lcs + word2.length() - lcs;
        }

        private int dp(String s1, int i, String s2, int j, int[][] memo) {
            if (i == s1.length() || j == s2.length()) return 0;
            if (memo[i][j] != -1) return memo[i][j];
            if (s1.charAt(i) == s2.charAt(j)) {
                memo[i][j] = dp(s1, i + 1, s2, j + 1, memo) + 1;
            } else {
                memo[i][j] = Math.max(
                        dp(s1, i + 1, s2, j, memo),
                        dp(s1, i, s2, j + 1, memo)
                );
            }
            return memo[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
