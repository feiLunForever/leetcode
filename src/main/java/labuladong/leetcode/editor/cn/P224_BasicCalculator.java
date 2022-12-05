//<p>Given a string <code>s</code> representing a valid expression, implement a basic calculator to evaluate it, and return <em>the result of the evaluation</em>.</p>
//
//<p><strong>Note:</strong> You are <strong>not</strong> allowed to use any built-in function which evaluates strings as mathematical expressions, such as <code>eval()</code>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = "1 + 1"
//<strong>Output:</strong> 2
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = " 2-1 + 2 "
//<strong>Output:</strong> 3
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = "(1+(4+5+2)-3)+(6+8)"
//<strong>Output:</strong> 23
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= s.length &lt;= 3 * 10<sup>5</sup></code></li> 
// <li><code>s</code> consists of digits, <code>'+'</code>, <code>'-'</code>, <code>'('</code>, <code>')'</code>, and <code>' '</code>.</li> 
// <li><code>s</code> represents a valid expression.</li> 
// <li><code>'+'</code> is <strong>not</strong> used as a unary operation (i.e., <code>"+1"</code> and <code>"+(2 + 3)"</code> is invalid).</li> 
// <li><code>'-'</code> could be used as a unary operation (i.e., <code>"-1"</code> and <code>"-(2 + 3)"</code> is valid).</li> 
// <li>There will be no two consecutive operators in the input.</li> 
// <li>Every number and running calculation will fit in a signed 32-bit integer.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>栈 | 递归 | 数学 | 字符串</details><br>
//
//<div>👍 858, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * Basic Calculator
 *
 * @author DY
 * @date 2022-12-05 16:14:18
 */
public class P224_BasicCalculator {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P224_BasicCalculator().new Solution();
        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int index = 0;

        public int calculate(String s) {
            return cal(s);
        }

        private int cal(String s) {
            int num = 0;
            int sum = 0;
            char opera = '+'; // 操作符
            LinkedList<Integer> stack = new LinkedList<Integer>();
            while (index < s.length()) {
                char ch = s.charAt(index++);
                if (Character.isDigit(ch)) {    // 如果是数字类型
                    num = (num * 10) + (ch - '0');
                }
                if (ch == '(') { // 左括号，递归
                    num = cal(s);
                }
                if ((ch != ' ' && !(Character.isDigit(ch))) || index == s.length()) { // 如果不是数字类型，则把上面的数字处理后放入栈中

                    switch (opera) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            stack.push(stack.pop() * num);
                            break;
                        case '/':
                            stack.push(stack.pop() / num);
                            break;
                    }
                    // 重新归0,操作符设置为c;
                    opera = ch;
                    num = 0;
                }
                if (ch == ')') { // 右括号，返回
                    break;
                }
            }
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}