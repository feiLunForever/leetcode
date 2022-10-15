//<p>You are given an array of integers&nbsp;<code>nums</code>, there is a sliding window of size <code>k</code> which is moving from the very left of the array to the very right. You can only see the <code>k</code> numbers in the window. Each time the sliding window moves right by one position.</p>
//
//<p>Return <em>the max sliding window</em>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,3,-1,-3,5,3,6,7], k = 3
//<strong>Output:</strong> [3,3,5,5,6,7]
//<strong>Explanation:</strong> 
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       <strong>3</strong>
// 1 [3  -1  -3] 5  3  6  7       <strong>3</strong>
// 1  3 [-1  -3  5] 3  6  7      <strong> 5</strong>
// 1  3  -1 [-3  5  3] 6  7       <strong>5</strong>
// 1  3  -1  -3 [5  3  6] 7       <strong>6</strong>
// 1  3  -1  -3  5 [3  6  7]      <strong>7</strong>
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1], k = 1
//<strong>Output:</strong> [1]
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
// <li><code>1 &lt;= k &lt;= nums.length</code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>队列 | 数组 | 滑动窗口 | 单调队列 | 堆（优先队列）</details><br>
//
//<div>👍 1913, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * Sliding Window Maximum
 *
 * @author DY
 * @date 2022-10-15 13:27:54
 */
public class P239_SlidingWindowMaximum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P239_SlidingWindowMaximum().new Solution();
        System.out.println(solution.maxSlidingWindow(new int[]{7, 2, 4}, 2));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // MonotonicQueue
        class MonotonicQueue {

            private final LinkedList<Integer> queue;

            MonotonicQueue(int capacity) {
                this.queue = new LinkedList<>();
            }

            public void put(int value) {
                while (!queue.isEmpty() && queue.getLast() < value) {
                    queue.removeLast();
                }
                queue.addLast(value);
            }

            public int max() {
                return queue.getFirst();
            }

            public void remove(int value) {
                if (value == queue.getFirst()) {
                    queue.removeFirst();
                }
            }
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            MonotonicQueue window = new MonotonicQueue(k);
            int[] res = new int[nums.length - k + 1];
            int i = 0, j = 0;
            for (; i < k - 1; i++) {
                window.put(nums[i]);
            }
            for (; i < nums.length; i++) {
                window.put(nums[i]);
                res[j++] = window.max();
                window.remove(nums[i - k + 1]);
            }
            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}