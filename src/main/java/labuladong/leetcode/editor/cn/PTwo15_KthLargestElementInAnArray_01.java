/**
 * <p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <em>the</em> <code>k<sup>th</sup></code> <em>largest element in the array</em>.</p>
 *
 * <p>Note that it is the <code>k<sup>th</sup></code> largest element in the sorted order, not the <code>k<sup>th</sup></code> distinct element.</p>
 *
 * <p>Can you solve it without sorting?</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [3,2,1,5,6,4], k = 2
 * <strong>Output:</strong> 5
 * </pre>
 * <p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = [3,2,3,1,2,4,5,5,6], k = 4
 * <strong>Output:</strong> 4
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= k &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 分治 | 快速选择 | 排序 | 堆（优先队列）</details><br>
 *
 * <div>👍 2356, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Random;

/**
 * Kth Largest Element in an Array
 *
 * @author DY
 * @date 2023-11-29 15:31:12
 */
public class PTwo15_KthLargestElementInAnArray_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PTwo15_KthLargestElementInAnArray_01().new Solution();
		System.out.println(solution.findKthLargest(new int[]{3,2,1,5,6,4},2));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int l = 0, r = nums.length - 1;
            int topK = nums.length - k;
            shuffle(nums);
            while (l <= r) {
                int p = partition(nums, l, r);
                if (p < topK) {
                    l = p + 1;
                } else if (p > topK) {
                    r = p - 1;
                } else {
                    return nums[p];
                }
            }
            return -1;
        }

        private int partition(int[] nums, int l, int r) {
            int pivot = nums[l];
            int i = l + 1, j = r;
            while (i <= j) {
                while (i < r && nums[i] <= pivot) { // 从前往后找比pivot大的
                    ++i;
                }
                while (j > l && nums[j] > pivot) { // 从后往前找比pivot小的
                    --j;
                }
                if (i >= j) break;
                swap(nums, i, j);
            }
            swap(nums, l, j);
            return j;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

		// 洗牌算法，将输入的数组随机打乱
		private void shuffle(int[] nums) {
			Random rand = new Random();
			int n = nums.length;
			for (int i = 0 ; i < n; i++) {
				// 生成 [i, n - 1] 的随机数
				int r = i + rand.nextInt(n - i);
				swap(nums, i, r);
			}
		}
    }
//leetcode submit region end(Prohibit modification and deletion)

}
