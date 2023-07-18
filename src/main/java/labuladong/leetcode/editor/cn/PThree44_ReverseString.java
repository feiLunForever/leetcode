/**
 * <p>Write a function that reverses a string. The input string is given as an array of characters <code>s</code>.</p>
 *
 * <p>You must do this by modifying the input array <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a> with <code>O(1)</code> extra memory.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> s = ["h","e","l","l","o"]
 * <strong>Output:</strong> ["o","l","l","e","h"]
 * </pre>
 * <p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> s = ["H","a","n","n","a","h"]
 * <strong>Output:</strong> ["h","a","n","n","a","H"]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>s[i]</code> is a <a href="https://en.wikipedia.org/wiki/ASCII#Printable_characters" target="_blank">printable ascii character</a>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>双指针 | 字符串</details><br>
 *
 * <div>👍 782, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Reverse String
 *
 * @author DY
 * @date 2023-07-18 17:12:49
 */
public class PThree44_ReverseString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PThree44_ReverseString().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
			int left = 0, right = s.length - 1;
			while (left < right) {
				char ch = s[left];
				s[left] = s[right];
				s[right] = ch;
				++left;
				--right;
			}
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
