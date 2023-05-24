/**
 * <p>Given an array of integers <code>nums</code>, sort the array in ascending order and return it.</p>
 *
 * <p>You must solve the problem <strong>without using any built-in</strong> functions in <code>O(nlog(n))</code> time complexity and with the smallest space complexity possible.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [5,2,3,1]
 * <strong>Output:</strong> [1,2,3,5]
 * <strong>Explanation:</strong> After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [5,1,1,2,0,0]
 * <strong>Output:</strong> [0,0,1,1,2,5]
 * <strong>Explanation:</strong> Note that the values of nums are not necessairly unique.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 5 * 10<sup>4</sup></code></li>
 * <li><code>-5 * 10<sup>4</sup> &lt;= nums[i] &lt;= 5 * 10<sup>4</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 分治 | 桶排序 | 计数排序 | 基数排序 | 排序 | 堆（优先队列） | 归并排序</details><br>
 *
 * <div>👍 843, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Sort an Array
 *
 * @author DY
 * @date 2023-05-24 16:01:53
 */
public class PNine12_SortAnArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PNine12_SortAnArray().new Solution();
		System.out.println(Arrays.toString(solution.sortArray(new int[]{5,2,3,1})));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] temp;

        public int[] sortArray(int[] nums) {
            temp = new int[nums.length];
            sort(nums, 0, nums.length - 1);
            return nums;
        }

        private void sort(int[] nums, int l, int r) {
            if (l == r) return;
            int mid = l + (r - l) / 2;
            sort(nums, l, mid);
            sort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }

        private void merge(int[] nums, int l, int mid, int r) {
            for (int i = l; i <= r; i++) {
                temp[i] = nums[i];
            }
            int i = l, j = mid + 1;
            for (int k = l; k <= r; k++) {
                if (i == mid + 1) { // 左边数组全部merge完了
                    nums[k] = temp[j++];
                } else if (j == r + 1) { // 右边数组全部merge完了
                    nums[k] = temp[i++];
                } else if (temp[i] < temp[j]) {
                    nums[k] = temp[i++];
                } else {
                    nums[k] = temp[j++];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
