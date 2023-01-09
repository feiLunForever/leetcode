//<p>You are given two integer arrays <code>nums1</code> and <code>nums2</code> both of the same length. The <strong>advantage</strong> of <code>nums1</code> with respect to <code>nums2</code> is the number of indices <code>i</code> for which <code>nums1[i] &gt; nums2[i]</code>.</p>
//
//<p>Return <em>any permutation of </em><code>nums1</code><em> that maximizes its <strong>advantage</strong> with respect to </em><code>nums2</code>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<pre><strong>Input:</strong> nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//<strong>Output:</strong> [2,11,7,15]
//</pre><p><strong>Example 2:</strong></p>
//<pre><strong>Input:</strong> nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//<strong>Output:</strong> [24,32,8,12]
//</pre>
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums1.length &lt;= 10<sup>5</sup></code></li>
//	<li><code>nums2.length == nums1.length</code></li>
//	<li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>9</sup></code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 排序</details><br>
//
//<div>👍 199, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Advantage Shuffle
 *
 * @author DY
 * @date 2022-08-31 19:02:04
 */
public class P870_AdvantageShuffle {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P870_AdvantageShuffle().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] advantageCount(int[] nums1, int[] nums2) {
            int n = nums1.length;
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
            for (int i = 0; i < n; i++) { // nums2 降序
                queue.offer(new int[]{i, nums2[i]});
            }
            Arrays.sort(nums1); // nums1 升序
            int left = 0, right = n - 1;
            int[] res = new int[n];
            while (!queue.isEmpty()) {
                int[] items = queue.poll();
                int index = items[0];
                int value = items[1]; // value 是 nums2 中的最大值，i 是对应索引
                if (nums1[right] > value) { // 如果 nums1[right] 能胜过 value，那就自己上
                    res[index] = nums1[right];
                    --right;
                } else { // 否则用最小值混一下，养精蓄锐
                    res[index] = nums1[left];
                    ++left;
                }
            }
            return res;
        }


        /*public int[] advantageCount(int[] nums1, int[] nums2) {
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((int[] a, int[] b) -> b[1] - a[1]);
            for (int i = 0; i < nums2.length; i++) {
                priorityQueue.add(new int[]{i, nums2[i]});
            }
            Arrays.sort(nums1);
            int left = 0, right = nums1.length - 1;
            int[] res = new int[nums1.length];
            while (!priorityQueue.isEmpty()) {
                int[] target = priorityQueue.poll();
                if (nums1[right] > target[1]) {
                    res[target[0]] = nums1[right];
                    right--;
                } else {
                    res[target[0]] = nums1[left];
                    left++;
                }
            }
            return res;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}