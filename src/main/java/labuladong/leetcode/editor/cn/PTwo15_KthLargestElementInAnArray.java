/**
 * <p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <em>the</em> <code>k<sup>th</sup></code> <em>largest element in the array</em>.</p>
 *
 * <p>Note that it is the <code>k<sup>th</sup></code> largest element in the sorted order, not the <code>k<sup>th</sup></code> distinct element.</p>
 *
 * <p>You must solve it in <code>O(n)</code> time complexity.</p>
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
 * <div>👍 2179, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Kth Largest Element in an Array
 *
 * @author DY
 * @date 2023-05-26 16:43:41
 */
public class PTwo15_KthLargestElementInAnArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PTwo15_KthLargestElementInAnArray().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int l = 0, r = nums.length - 1;
            k = nums.length - k; // 转化成「排名第 k 的元素」
            while (l <= r) {
                int p = partition(nums, l, r);
                if (p < k) {
                    l = p + 1;
                } else if (p > k) {
                    r = p - 1;
                } else {
                    return nums[p];
                }
            }
            return -1;
        }

        // 对 nums[l..r] 进行切分
        private int partition(int[] nums, int l, int r) {
            // 关于区间的边界控制需格外小心，稍有不慎就会出错
            // 我这里把 i, j 定义为开区间，同时定义：
            // [lo, i) <= pivot；(j, hi] > pivot
            int pivot = nums[l];
            int i = l + 1, j = r;
            while (i <= j) { // 当 i > j 时结束循环，以保证区间 [lo, hi] 都被覆盖
                while (i < r && nums[i] <= pivot) { // 从前往后找，比pivot大的
                    ++i;
                }
                while (j > l && nums[j] > pivot) { // 从后往前找，比pivot小的
                    --j;
                }
				// 此时 [l, i] <= pivot && [j, r] > pivot
                if (i >= j) break;

                swap(nums, i, j);

            }
            // 最后将 pivot 放到合适的位置，即 pivot 左边元素较小，右边元素较大
            swap(nums, l, j);
            return j;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
