//<p>Given an array of integers <code>nums</code> sorted in non-decreasing order, find the starting and ending position of a given <code>target</code> value.</p>
//
//<p>If <code>target</code> is not found in the array, return <code>[-1, -1]</code>.</p>
//
//<p>You must&nbsp;write an algorithm with&nbsp;<code>O(log n)</code> runtime complexity.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 8
//<strong>Output:</strong> [3,4]
//</pre><p><strong>Example 2:</strong></p>
//<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 6
//<strong>Output:</strong> [-1,-1]
//</pre><p><strong>Example 3:</strong></p>
//<pre><strong>Input:</strong> nums = [], target = 0
//<strong>Output:</strong> [-1,-1]
//</pre>
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>0 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
//	<li><code>-10<sup>9</sup>&nbsp;&lt;= nums[i]&nbsp;&lt;= 10<sup>9</sup></code></li>
//	<li><code>nums</code> is a non-decreasing array.</li>
//	<li><code>-10<sup>9</sup>&nbsp;&lt;= target&nbsp;&lt;= 10<sup>9</sup></code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>
//
//<div>👍 1849, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Find First and Last Position of Element in Sorted Array
 *
 * @author DY
 * @date 2022-08-12 17:53:21
 */
public class P34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            return new int[]{leftBound(nums, target), rightBound(nums, target)};
        }

        private int leftBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    right = mid - 1;
                }
            }
            if (left >= nums.length || nums[left] != target) {
                return -1;
            }
            return left;
        }

        private int rightBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    left = mid + 1;
                }
            }
            if (right < 0 || nums[right] != target) {
                return -1;
            }
            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}