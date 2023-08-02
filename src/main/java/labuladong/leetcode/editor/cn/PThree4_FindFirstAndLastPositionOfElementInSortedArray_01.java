/**
 * <p>Given an array of integers <code>nums</code> sorted in non-decreasing order, find the starting and ending position of a given <code>target</code> value.</p>
 *
 * <p>If <code>target</code> is not found in the array, return <code>[-1, -1]</code>.</p>
 *
 * <p>You must&nbsp;write an algorithm with&nbsp;<code>O(log n)</code> runtime complexity.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 8
 * <strong>Output:</strong> [3,4]
 * </pre>
 * <p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 6
 * <strong>Output:</strong> [-1,-1]
 * </pre>
 * <p><strong class="example">Example 3:</strong></p>
 * <pre><strong>Input:</strong> nums = [], target = 0
 * <strong>Output:</strong> [-1,-1]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>-10<sup>9</sup>&nbsp;&lt;= nums[i]&nbsp;&lt;= 10<sup>9</sup></code></li>
 * <li><code>nums</code> is a non-decreasing array.</li>
 * <li><code>-10<sup>9</sup>&nbsp;&lt;= target&nbsp;&lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>
 *
 * <div>👍 2399, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Find First and Last Position of Element in Sorted Array
 *
 * @author DY
 * @date 2023-08-02 20:37:41
 */
public class PThree4_FindFirstAndLastPositionOfElementInSortedArray_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PThree4_FindFirstAndLastPositionOfElementInSortedArray_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) return new int[]{-1, -1};
            return new int[]{leftBound(nums, target), rightBound(nums, target)};
        }

        private int rightBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            if (nums[left] > target || nums[right] < target) return -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return nums[right] == target ? right : -1;
        }

        private int leftBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            if (nums[left] > target || nums[right] < target) return -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    right = mid - 1;
                }
            }
            return nums[left] == target ? left : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
