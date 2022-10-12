//<p>The <strong>median</strong> is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.</p>
//
//<ul> 
// <li>For example, for <code>arr = [2,3,4]</code>, the median is <code>3</code>.</li> 
// <li>For example, for <code>arr = [2,3]</code>, the median is <code>(2 + 3) / 2 = 2.5</code>.</li> 
//</ul>
//
//<p>Implement the MedianFinder class:</p>
//
//<ul> 
// <li><code>MedianFinder()</code> initializes the <code>MedianFinder</code> object.</li> 
// <li><code>void addNum(int num)</code> adds the integer <code>num</code> from the data stream to the data structure.</li> 
// <li><code>double findMedian()</code> returns the median of all elements so far. Answers within <code>10<sup>-5</sup></code> of the actual answer will be accepted.</li> 
//</ul>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input</strong>
//["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
//<strong>Output</strong>
//[null, null, null, 1.5, null, 2.0]
//
//<strong>Explanation</strong>
//MedianFinder medianFinder = new MedianFinder();
//medianFinder.addNum(1);    // arr = [1]
//medianFinder.addNum(2);    // arr = [1, 2]
//medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
//medianFinder.addNum(3);    // arr[1, 2, 3]
//medianFinder.findMedian(); // return 2.0
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>-10<sup>5</sup> &lt;= num &lt;= 10<sup>5</sup></code></li> 
// <li>There will be at least one element in the data structure before calling <code>findMedian</code>.</li> 
// <li>At most <code>5 * 10<sup>4</sup></code> calls will be made to <code>addNum</code> and <code>findMedian</code>.</li> 
//</ul>
//
//<p>&nbsp;</p> 
//<p><strong>Follow up:</strong></p>
//
//<ul> 
// <li>If all integer numbers from the stream are in the range <code>[0, 100]</code>, how would you optimize your solution?</li> 
// <li>If <code>99%</code> of all integer numbers from the stream are in the range <code>[0, 100]</code>, how would you optimize your solution?</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>设计 | 双指针 | 数据流 | 排序 | 堆（优先队列）</details><br>
//
//<div>👍 762, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * Find Median from Data Stream
 *
 * @author DY
 * @date 2022-10-12 09:31:41
 */
public class P295_FindMedianFromDataStream {
    public static void main(String[] args) {
        //测试代码
        MedianFinder solution = new P295_FindMedianFromDataStream().new MedianFinder();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        private final PriorityQueue<Integer> small;
        private final PriorityQueue<Integer> large;

        public MedianFinder() {
            small = new PriorityQueue<>();
            large = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (small.size() >= large.size()) {
                small.offer(num);
                large.offer(small.poll());
            } else {
                large.offer(num);
                small.offer(large.poll());
            }
        }

        public double findMedian() {
            if (small.size() > large.size()) {
                return small.peek();
            } else if (small.size() < large.size()) {
                return large.peek();
            }
            return (small.peek() + large.peek()) / 2.0;
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