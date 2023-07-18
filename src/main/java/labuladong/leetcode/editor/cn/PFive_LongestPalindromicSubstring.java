/**
 * <p>Given a string <code>s</code>, return <em>the longest</em> <span data-keyword="palindromic-string"><em>palindromic</em></span> <span data-keyword="substring-nonempty"><em>substring</em></span> in <code>s</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "babad"
 * <strong>Output:</strong> "bab"
 * <strong>Explanation:</strong> "aba" is also a valid answer.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "cbbd"
 * <strong>Output:</strong> "bb"
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 1000</code></li>
 * <li><code>s</code> consist of only digits and English letters.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>
 *
 * <div>👍 6641, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Longest Palindromic Substring
 *
 * @author DY
 * @date 2023-07-18 17:14:49
 */
public class PFive_LongestPalindromicSubstring {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFive_LongestPalindromicSubstring().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                String s1 = palindrome(s, i, i);
                String s2 = palindrome(s, i, i + 1);
                res = res.length() > s1.length() ? res : s1;
                res = res.length() > s2.length() ? res : s2;
            }
            return res;
        }

        private String palindrome(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
            }
            return s.substring(l + 1, r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
