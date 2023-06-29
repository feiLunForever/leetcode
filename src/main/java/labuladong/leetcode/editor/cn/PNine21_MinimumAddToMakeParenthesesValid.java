/**
 * <p>A parentheses string is valid if and only if:</p>
 *
 * <ul>
 * <li>It is the empty string,</li>
 * <li>It can be written as <code>AB</code> (<code>A</code> concatenated with <code>B</code>), where <code>A</code> and <code>B</code> are valid strings, or</li>
 * <li>It can be written as <code>(A)</code>, where <code>A</code> is a valid string.</li>
 * </ul>
 *
 * <p>You are given a parentheses string <code>s</code>. In one move, you can insert a parenthesis at any position of the string.</p>
 *
 * <ul>
 * <li>For example, if <code>s = "()))"</code>, you can insert an opening parenthesis to be <code>"(<strong>(</strong>)))"</code> or a closing parenthesis to be <code>"())<strong>)</strong>)"</code>.</li>
 * </ul>
 *
 * <p>Return <em>the minimum number of moves required to make </em><code>s</code><em> valid</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "())"
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "((("
 * <strong>Output:</strong> 3
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 1000</code></li>
 * <li><code>s[i]</code> is either <code>'('</code> or <code>')'</code>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>栈 | 贪心 | 字符串</details><br>
 *
 * <div>👍 244, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Minimum Add to Make Parentheses Valid
 *
 * @author DY
 * @date 2023-06-29 16:26:32
 */
public class PNine21_MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PNine21_MinimumAddToMakeParenthesesValid().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minAddToMakeValid(String s) {
            int needRight = 0;
            int left = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    ++needRight;
                } else if (s.charAt(i) == ')') {
                    --needRight;
                    if (needRight < 0) {
                        needRight = 0;
                        ++left;
                    }
                }
            }
            return left + needRight;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
