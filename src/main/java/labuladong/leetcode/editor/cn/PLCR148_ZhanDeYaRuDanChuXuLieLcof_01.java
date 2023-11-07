/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 模拟</details><br>
 *
 * <div>👍 486, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Stack;

/**
 * 验证图书取出顺序
 *
 * @author DY
 * @date 2023-11-07 15:58:30
 */
public class PLCR148_ZhanDeYaRuDanChuXuLieLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PLCR148_ZhanDeYaRuDanChuXuLieLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validateBookSequences(int[] putIn, int[] takeOut) {
            Stack<Integer> stack = new Stack<>();
            int i = 0;
            for (int in : putIn) {
                stack.push(in);
                while (!stack.isEmpty() && stack.peek().equals(takeOut[i])) {
                    stack.pop();
                    ++i;
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
