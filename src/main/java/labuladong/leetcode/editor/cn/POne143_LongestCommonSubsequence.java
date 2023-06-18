/**
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative order of
 * the remaining characters.
 * <p>
 * <p>
 * For example, "ace" is a subsequence of "abcde".
 * <p>
 * <p>
 * A common subsequence of two strings is a subsequence that is common to both
 * strings.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 * <p>
 * <p>
 * Related Topics字符串 | 动态规划
 * <p>
 * 👍 1342, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Longest Common Subsequence
 *
 * @author DY
 * @date 2023-06-18 08:50:17
 */
public class POne143_LongestCommonSubsequence {
	public static void main(String[] args) {
		//测试代码
		Solution solution = new POne143_LongestCommonSubsequence().new Solution();
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int longestCommonSubsequence(String text1, String text2) {
			int[][] memo = new int[text1.length()][text2.length()];
			for (int[] row : memo) {
				Arrays.fill(row, -1); // -1相当于没有计算
			}
			return dp(text1, 0, text2, 0, memo);
		}

		/**
		 * s1[i..] 和 s2[j..] 最长公共子序列
		 *
		 * @param s1
		 * @param i
		 * @param s2
		 * @param j
		 * @param memo
		 * @return
		 */
		private int dp(String s1, int i, String s2, int j, int[][] memo) {
			if (i == s1.length() || j == s2.length()) return 0;
			if (memo[i][j] != -1) return memo[i][j];
			if (s1.charAt(i) == s2.charAt(j)) { // 两个字符相等，那必然都在序列中
				memo[i][j] = dp(s1, i + 1, s2, j + 1, memo) + 1;
			} else {
				memo[i][j] = Math.max( // s1[i] 和 s2[j] 至少有一个不在 lcs 中
						dp(s1, i + 1, s2, j, memo),
						dp(s1, i, s2, j + 1, memo)
				);
			}
			return memo[i][j];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
