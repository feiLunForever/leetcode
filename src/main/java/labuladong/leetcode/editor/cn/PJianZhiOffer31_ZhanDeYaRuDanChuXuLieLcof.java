/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 模拟</details><br>
 *
 * <div>👍 421, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Stack;

/**
 * 栈的压入、弹出序列 LCOF
 *
 * @author DY
 * @date 2023-03-10 12:37:25
 */
public class PJianZhiOffer31_ZhanDeYaRuDanChuXuLieLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer31_ZhanDeYaRuDanChuXuLieLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int i = 0;
            for (int push : pushed) {
                stack.push(push);
                while (!stack.isEmpty() && stack.peek().equals(popped[i])) {
                    stack.pop();
                    ++i;
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
