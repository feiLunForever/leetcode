/**
 * <p>Given a string <code>s</code> containing just the characters <code>'('</code>, <code>')'</code>, <code>'{'</code>, <code>'}'</code>, <code>'['</code> and <code>']'</code>, determine if the input string is valid.</p>
 *
 * <p>An input string is valid if:</p>
 *
 * <ol>
 * <li>Open brackets must be closed by the same type of brackets.</li>
 * <li>Open brackets must be closed in the correct order.</li>
 * <li>Every close bracket has a corresponding open bracket of the same type.</li>
 * </ol>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "()"
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "()[]{}"
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "(]"
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>s</code> consists of parentheses only <code>'()[]{}'</code>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>栈 | 字符串</details><br>
 *
 * <div>👍 3988, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Stack;

/**
 * Valid Parentheses
 *
 * @author DY
 * @date 2023-06-29 16:02:18
 */
public class PTwo0_ValidParentheses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PTwo0_ValidParentheses().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if('(' == ch || '[' == ch || '{' == ch) {
					stack.push(ch);
				}else {
					if(!stack.isEmpty() && match(ch) == stack.peek()) {
						stack.pop();
					}else {
						return false;
					}
				}
			}
			return stack.isEmpty();
        }

		private Character match(char ch) {
        	if(ch == ')') return '(';
        	if(ch == ']') return '[';
        	if(ch == '}') return '{';
        	return null;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
