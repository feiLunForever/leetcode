/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>栈 | 设计</details><br>
 *
 * <div>👍 456, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Stack;

/**
 * 包含min函数的栈 LCOF
 *
 * @author DY
 * @date 2023-03-10 12:15:58
 */
public class PJianZhiOffer30_BaoHanMinhanShuDeZhanLcof {
    public static void main(String[] args) {
        //测试代码
        MinStack solution = new PJianZhiOffer30_BaoHanMinhanShuDeZhanLcof().new MinStack();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        private final Stack<Integer> data;

        private final Stack<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            if (min.isEmpty() || x <= min.peek()) {
                min.push(x);
            }
            data.push(x);
        }

        public void pop() {
            if (data.pop().equals(min.peek())) {
                min.pop();
            }
        }

        public int top() {
            return data.peek();
        }

        public int min() {
            return min.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
