//<p>Given <code>n</code> pairs of parentheses, write a function to <em>generate all combinations of well-formed parentheses</em>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p> 
//<pre><strong>Input:</strong> n = 3
//<strong>Output:</strong> ["((()))","(()())","(())()","()(())","()()()"]
//</pre>
//<p><strong class="example">Example 2:</strong></p> 
//<pre><strong>Input:</strong> n = 1
//<strong>Output:</strong> ["()"]
//</pre> 
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= n &lt;= 8</code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划 | 回溯</details><br>
//
//<div>👍 2950, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 *
 * @author DY
 * @date 2022-11-11 17:11:28
 */
public class P22_GenerateParentheses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P22_GenerateParentheses().new Solution();
		System.out.println(solution.generateParenthesis(3));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            dfs(n, n, new StringBuilder(), res);
            return res;
        }

        private void dfs(int left, int right, StringBuilder trace, List<String> res) {
            if (left > right) return; // 左括号一定 <= 右括号
            if (left < 0 || right < 0) return;
            if (left == 0 && right == 0) {
                res.add(trace.toString());
            }
            // 选择左括号
            trace.append("(");
            dfs(left - 1, right, trace, res);
            trace.deleteCharAt(trace.length() - 1);
            // 选择右括号
            trace.append(")");
            dfs(left, right - 1, trace, res);
            trace.deleteCharAt(trace.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}