/**
 * <p>Given an integer array <code>nums</code> and an integer <code>val</code>, remove all occurrences of <code>val</code> in <code>nums</code> <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a>. The order of the elements may be changed. Then return <em>the number of elements in </em><code>nums</code><em> which are not equal to </em><code>val</code>.</p>
 *
 * <p>Consider the number of elements in <code>nums</code> which are not equal to <code>val</code> be <code>k</code>, to get accepted, you need to do the following things:</p>
 *
 * <ul>
 * <li>Change the array <code>nums</code> such that the first <code>k</code> elements of <code>nums</code> contain the elements which are not equal to <code>val</code>. The remaining elements of <code>nums</code> are not important as well as the size of <code>nums</code>.</li>
 * <li>Return <code>k</code>.</li>
 * </ul>
 *
 * <p><strong>Custom Judge:</strong></p>
 *
 * <p>The judge will test your solution with the following code:</p>
 *
 * <pre>
 * int[] nums = [...]; // Input array
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 * // It is sorted with no values equaling val.
 *
 * int k = removeElement(nums, val); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i &lt; actualLength; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * </pre>
 *
 * <p>If all assertions pass, then your solution will be <strong>accepted</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [3,2,2,3], val = 3
 * <strong>Output:</strong> 2, nums = [2,2,_,_]
 * <strong>Explanation:</strong> Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [0,1,2,2,3,0,4,2], val = 2
 * <strong>Output:</strong> 5, nums = [0,1,4,0,3,_,_,_]
 * <strong>Explanation:</strong> Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= nums.length &lt;= 100</code></li>
 * <li><code>0 &lt;= nums[i] &lt;= 50</code></li>
 * <li><code>0 &lt;= val &lt;= 100</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>
 *
 * <div>👍 1946, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Remove Element
 *
 * @author DY
 * @date 2023-09-04 18:53:33
 */
public class PTwo7_RemoveElement_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PTwo7_RemoveElement_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[fast] == val) {
                    ++fast;
                } else {
                    nums[slow++] = nums[fast++];
                }
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
