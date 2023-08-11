/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>设计 | 队列 | 单调队列</details><br>
 *
 * <div>👍 501, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * 队列的最大值 LCOF
 *
 * @author DY
 * @date 2023-08-11 15:30:52
 */
public class PJianZhiOffer59II_DuiLieDeZuiDaZhiLcof_01 {
    public static void main(String[] args) {
        //测试代码
        MaxQueue solution = new PJianZhiOffer59II_DuiLieDeZuiDaZhiLcof_01().new MaxQueue();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class MaxQueue {

        private final LinkedList<Integer> q = new LinkedList<>();
        private final LinkedList<Integer> maxQ = new LinkedList<>();

        public MaxQueue() {

        }

        public int max_value() {
            return maxQ.isEmpty() ? -1 : maxQ.peekFirst();
        }

        public void push_back(int value) {
            q.offer(value);
            while (!maxQ.isEmpty() && maxQ.peekLast() < value) {
                maxQ.removeLast();
            }
            maxQ.offer(value);
        }

        public int pop_front() {
            if (!q.isEmpty()) {
                if (q.peekFirst().equals(maxQ.peekFirst())) {
                    maxQ.removeFirst();
                }
                return q.removeFirst();
            }
            return -1;
        }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
