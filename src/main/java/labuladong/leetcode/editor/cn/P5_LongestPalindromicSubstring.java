//<p>Given a string <code>s</code>, return <em>the longest palindromic substring</em> in <code>s</code>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = &quot;babad&quot;
//<strong>Output:</strong> &quot;bab&quot;
//<strong>Explanation:</strong> &quot;aba&quot; is also a valid answer.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = &quot;cbbd&quot;
//<strong>Output:</strong> &quot;bb&quot;
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
//	<li><code>s</code> consist of only digits and English letters.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>
//
//<div>👍 5547, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Longest Palindromic Substring
 *
 * @author DY
 * @date 2022-08-08 14:16:27
 */
public class P5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
//		System.out.println(solution.longestPalindrome("abbcdefg"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String rs = "";
            for (int i = 0; i < s.length(); i++) {
                String s1 = palindrome(s, i, i); // 寻找以 s[i] 为中心的最长回文子串
                String s2 = palindrome(s, i, i + 1); // 以 s[i],s[i+1] 为中心的最长回文子串
                rs = rs.length() > s1.length() ? rs : s1;
                rs = rs.length() > s2.length() ? rs : s2;
            }
            return rs;
        }

        /**
         * 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
         *
         * @param s
         * @param l
         * @param r
         * @return
         */
        private String palindrome(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                // 双指针，向两边展开
                l--;
                r++;
            }
            return s.substring(l + 1, r); // 返回以 s[l] 和 s[r] 为中心的最长回文串
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}