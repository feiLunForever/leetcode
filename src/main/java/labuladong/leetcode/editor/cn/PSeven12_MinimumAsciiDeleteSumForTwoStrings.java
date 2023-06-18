/**
 * Given two strings s1 and s2, return the lowest ASCII sum of deleted characters
 * to make two strings equal.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s1 = "sea", s2 = "eat"
 * Output: 231
 * Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the
 * sum.
 * Deleting "t" from "eat" adds 116 to the sum.
 * At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum
 * possible to achieve this.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s1 = "delete", s2 = "leet"
 * Output: 403
 * Explanation: Deleting "dee" from "delete" to turn the string into "let",
 * adds 100[d] + 101[e] + 101[e] to the sum.
 * Deleting "e" from "leet" adds 101[e] to the sum.
 * At the end, both strings are equal to "let", and the answer is 100+101+101+101 =
 * 403.
 * If instead we turned both strings into "lee" or "eet", we would get answers of 4
 * 33 or 417, which are higher.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s1.length, s2.length <= 1000
 * s1 and s2 consist of lowercase English letters.
 * <p>
 * <p>
 * Related Topics字符串 | 动态规划
 * <p>
 * 👍 329, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Minimum ASCII Delete Sum for Two Strings
 *
 * @author DY
 * @date 2023-06-18 09:38:08
 */
public class PSeven12_MinimumAsciiDeleteSumForTwoStrings {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSeven12_MinimumAsciiDeleteSumForTwoStrings().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            int[][] memo = new int[s1.length()][s2.length()];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return dp(s1, 0, s2, 0, memo);
        }

        private int dp(String s1, int i, String s2, int j, int[][] memo) {
            int res = 0;
            if (i == s1.length()) {
                for (; j < s2.length(); j++) { // 如果 s1 到头了，那么 s2 剩下的都得删除
                    res += s2.charAt(j);
                }
                return res;
            }
            if (j == s2.length()) {
                for (; i < s1.length(); i++) { // 如果 s2 到头了，那么 s1 剩下的都得删除
                    res += s1.charAt(i);
                }
                return res;
            }
            if (memo[i][j] != -1) return memo[i][j];
            if (s1.charAt(i) == s2.charAt(j)) {
                memo[i][j] = dp(s1, i + 1, s2, j + 1, memo); // s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
            } else {
                memo[i][j] = Math.min(
                        s1.charAt(i) + dp(s1, i + 1, s2, j, memo), // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
                        s2.charAt(j) + dp(s1, i, s2, j + 1, memo)
                );
            }
            return memo[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
