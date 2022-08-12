//<p>Given an array of integers <code>nums</code> which is sorted in ascending order, and an integer <code>target</code>, write a function to search <code>target</code> in <code>nums</code>. If <code>target</code> exists, then return its index. Otherwise, return <code>-1</code>.</p>
//
//<p>You must write an algorithm with <code>O(log n)</code> runtime complexity.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [-1,0,3,5,9,12], target = 9
//<strong>Output:</strong> 4
//<strong>Explanation:</strong> 9 exists in nums and its index is 4
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [-1,0,3,5,9,12], target = 2
//<strong>Output:</strong> -1
//<strong>Explanation:</strong> 2 does not exist in nums so return -1
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
//	<li><code>-10<sup>4</sup> &lt; nums[i], target &lt; 10<sup>4</sup></code></li>
//	<li>All the integers in <code>nums</code> are <strong>unique</strong>.</li>
//	<li><code>nums</code> is sorted in ascending order.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>
//
//<div>👍 936, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Binary Search
 *
 * @author DY
 * @date 2022-08-12 16:46:42
 */
public class P704_BinarySearch {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P704_BinarySearch().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}