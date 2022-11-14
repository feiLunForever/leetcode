//<p>Given a string <code>expression</code> of numbers and operators, return <em>all possible results from computing all the different possible ways to group numbers and operators</em>. You may return the answer in <strong>any order</strong>.</p>
//
//<p>The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed <code>10<sup>4</sup></code>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> expression = "2-1-1"
//<strong>Output:</strong> [0,2]
//<strong>Explanation:</strong>
//((2-1)-1) = 0 
//(2-(1-1)) = 2
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> expression = "2*3-4*5"
//<strong>Output:</strong> [-34,-14,-10,-10,10]
//<strong>Explanation:</strong>
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= expression.length &lt;= 20</code></li> 
// <li><code>expression</code> consists of digits and the operator <code>'+'</code>, <code>'-'</code>, and <code>'*'</code>.</li> 
// <li>All the integer values in the input expression are in the range <code>[0, 99]</code>.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>递归 | 记忆化搜索 | 数学 | 字符串 | 动态规划</details><br>
//
//<div>👍 766, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Different Ways to Add Parentheses
 *
 * @author DY
 * @date 2022-11-14 13:54:56
 */
public class P241_DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P241_DifferentWaysToAddParentheses().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<String, List<Integer>> memo = new HashMap<>();

        public List<Integer> diffWaysToCompute(String expression) {
            if (memo.containsKey(expression)) {
                return memo.get(expression);
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                if (ch == '-' || ch == '+' || ch == '*') {
                    List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                    for (int l : left) {
                        for (int r : right) {
                            if (ch == '-') {
                                res.add(l - r);
                            }
                            if (ch == '+') {
                                res.add(l + r);
                            }
                            if (ch == '*') {
                                res.add(l * r);
                            }
                        }
                    }
                }
            }
            if (res.isEmpty()) {
                res.add(Integer.parseInt(expression));
            }
            memo.put(expression, res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}