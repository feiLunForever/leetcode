/**
 * <p>Given a string <code>s</code> representing a valid expression, implement a basic calculator to evaluate it, and return <em>the result of the evaluation</em>.</p>
 *
 * <p><strong>Note:</strong> You are <strong>not</strong> allowed to use any built-in function which evaluates strings as mathematical expressions, such as <code>eval()</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "1 + 1"
 * <strong>Output:</strong> 2
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = " 2-1 + 2 "
 * <strong>Output:</strong> 3
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "(1+(4+5+2)-3)+(6+8)"
 * <strong>Output:</strong> 23
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 3 * 10<sup>5</sup></code></li>
 * <li><code>s</code> consists of digits, <code>'+'</code>, <code>'-'</code>, <code>'('</code>, <code>')'</code>, and <code>' '</code>.</li>
 * <li><code>s</code> represents a valid expression.</li>
 * <li><code>'+'</code> is <strong>not</strong> used as a unary operation (i.e., <code>"+1"</code> and <code>"+(2 + 3)"</code> is invalid).</li>
 * <li><code>'-'</code> could be used as a unary operation (i.e., <code>"-1"</code> and <code>"-(2 + 3)"</code> is valid).</li>
 * <li>There will be no two consecutive operators in the input.</li>
 * <li>Every number and running calculation will fit in a signed 32-bit integer.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>栈 | 递归 | 数学 | 字符串</details><br>
 *
 * <div>👍 917, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Stack;

/**
 * Basic Calculator
 *
 * @author DY
 * @date 2023-06-28 16:40:03
 */
public class PTwo24_BasicCalculator {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PTwo24_BasicCalculator().new Solution();
		System.out.println(solution.calculate(" 2-1 + 2 "));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
    	private int i = 0;
        public int calculate(String s) {
            return helper(s);
        }

        private int helper(String s) {
            int num = 0;
            char sign = '+';
            Stack<Integer> stack = new Stack<>();
            for (; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    num = num * 10 + (c - '0');
                }
                if (c == '(') {
                	++i;
                    num = helper(s);
                }
                if ((!(c >= '0' && c <= '9') && c != ' ') || i == s.length() - 1) {
                    if (sign == '+') {
                        stack.push(num);
                    } else if (sign == '-') {
                        stack.push(-num);
                    } else if (sign == '*') {
                        stack.push(stack.pop() * num);
                    } else if (sign == '/') {
                        stack.push(stack.pop() / num);
                    }
                    num = 0;
                    sign = c;
                }
                if (c == ')') {
                    break;
                }
            }
            int res = 0;
            while (!stack.isEmpty()) {
                res += stack.pop();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
