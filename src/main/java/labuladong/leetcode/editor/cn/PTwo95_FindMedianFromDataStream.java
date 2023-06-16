/**
 * <p>The <strong>median</strong> is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.</p>
 *
 * <ul>
 * <li>For example, for <code>arr = [2,3,4]</code>, the median is <code>3</code>.</li>
 * <li>For example, for <code>arr = [2,3]</code>, the median is <code>(2 + 3) / 2 = 2.5</code>.</li>
 * </ul>
 *
 * <p>Implement the MedianFinder class:</p>
 *
 * <ul>
 * <li><code>MedianFinder()</code> initializes the <code>MedianFinder</code> object.</li>
 * <li><code>void addNum(int num)</code> adds the integer <code>num</code> from the data stream to the data structure.</li>
 * <li><code>double findMedian()</code> returns the median of all elements so far. Answers within <code>10<sup>-5</sup></code> of the actual answer will be accepted.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * <strong>Output</strong>
 * [null, null, null, 1.5, null, 2.0]
 *
 * <strong>Explanation</strong>
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>-10<sup>5</sup> &lt;= num &lt;= 10<sup>5</sup></code></li>
 * <li>There will be at least one element in the data structure before calling <code>findMedian</code>.</li>
 * <li>At most <code>5 * 10<sup>4</sup></code> calls will be made to <code>addNum</code> and <code>findMedian</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong></p>
 *
 * <ul>
 * <li>If all integer numbers from the stream are in the range <code>[0, 100]</code>, how would you optimize your solution?</li>
 * <li>If <code>99%</code> of all integer numbers from the stream are in the range <code>[0, 100]</code>, how would you optimize your solution?</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>设计 | 双指针 | 数据流 | 排序 | 堆（优先队列）</details><br>
 *
 * <div>👍 837, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * Find Median from Data Stream
 *
 * @author DY
 * @date 2023-06-16 15:36:20
 */
public class PTwo95_FindMedianFromDataStream {
    public static void main(String[] args) {
        //测试代码
        MedianFinder solution = new PTwo95_FindMedianFromDataStream().new MedianFinder();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        private final PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> b - a);
        private final PriorityQueue<Integer> big = new PriorityQueue<>();

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (small.size() >= big.size()) {
                small.offer(num);
                big.offer(small.poll());
            } else {
                big.offer(num);
                small.offer(big.poll());
            }
        }

        public double findMedian() {
            if (small.size() < big.size()) {
                return big.peek();
            } else if (small.size() > big.size()) {
                return small.peek();
            }
            return (small.peek() + big.peek()) / 2.0;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
