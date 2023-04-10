/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>设计 | 队列 | 单调队列</details><br>
 *
 * <div>👍 458, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * 队列的最大值 LCOF
 *
 * @author DY
 * @date 2023-04-10 17:48:38
 */
public class PMianShiTi59II_DuiLieDeZuiDaZhiLcof {
    public static void main(String[] args) {
        //测试代码
        MaxQueue solution = new PMianShiTi59II_DuiLieDeZuiDaZhiLcof().new MaxQueue();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class MaxQueue {

        private final LinkedList<Integer> queue;
        private final LinkedList<Integer> maxQueue; // 单调队列

        public MaxQueue() {
            queue = new LinkedList<>();
            maxQueue = new LinkedList<>();
        }

        public int max_value() {
            return maxQueue.isEmpty() ? -1 : maxQueue.peekFirst();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) { // 后面进来的值，会把之前的值压扁
                maxQueue.removeLast();
            }
            maxQueue.offer(value);
        }

        public int pop_front() {
            if(queue.isEmpty()) return -1;
            if (queue.peekFirst().equals(maxQueue.peekFirst())) {
                maxQueue.removeFirst();
            }
            return queue.removeFirst();
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
