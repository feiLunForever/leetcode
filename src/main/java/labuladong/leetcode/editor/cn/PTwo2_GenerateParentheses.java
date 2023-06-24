/**
 * Given n pairs of parentheses, write a function to generate all combinations of
 * well-formed parentheses.
 * <p>
 * <p>
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= n <= 8
 * <p>
 * <p>
 * Related Topics字符串 | 动态规划 | 回溯
 * <p>
 * 👍 3262, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * Generate Parentheses
 *
 * @author DY
 * @date 2023-06-24 20:35:21
 */
public class PTwo2_GenerateParentheses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PTwo2_GenerateParentheses().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            StringBuilder trace = new StringBuilder();
            List<String> res = new LinkedList<>();
            backTrack(n, n, trace, res);
            return res;
        }

        private void backTrack(int left, int right, StringBuilder trace, List<String> res) {
			if (left < 0 || right < 0) return;
			if (left > right) return; // 左括号剩的多，不合法
            if (left == 0 && right == 0) {
                res.add(trace.toString());
                return;
            }
            trace.append('('); // 尝试左括号
            backTrack(left - 1, right, trace, res);
            trace.deleteCharAt(trace.length() - 1); // 撤销

            trace.append(')'); // 尝试右括号
            backTrack(left, right - 1, trace, res);
            trace.deleteCharAt(trace.length() - 1); // 撤销
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
