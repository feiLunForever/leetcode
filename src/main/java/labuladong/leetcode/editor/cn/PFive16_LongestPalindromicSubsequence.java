/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 * <p>
 * A subsequence is a sequence that can be derived from another sequence by
 * deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 * <p>
 * <p>
 * Related Topics字符串 | 动态规划
 * <p>
 * 👍 1048, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

/**
 * Longest Palindromic Subsequence
 *
 * @author DY
 * @date 2023-06-18 14:28:00
 */
public class PFive16_LongestPalindromicSubsequence {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFive16_LongestPalindromicSubsequence().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            int[][] dp = new int[n][n]; // 在子串 s[i..j] 中，最长回文子序列的长度为 dp[i][j]
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(
                                dp[i + 1][j],
                                dp[i][j - 1]
                        );
                    }
                }
            }

            return dp[0][n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
