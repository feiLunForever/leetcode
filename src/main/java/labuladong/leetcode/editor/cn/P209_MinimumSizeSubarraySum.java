//<p>Given an array of positive integers <code>nums</code> and a positive integer <code>target</code>, return <em>the <strong>minimal length</strong> of a </em><span data-keyword="subarray-nonempty"><em>subarray</em></span><em> whose sum is greater than or equal to</em> <code>target</code>. If there is no such subarray, return <code>0</code> instead.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> target = 7, nums = [2,3,1,2,4,3]
//<strong>Output:</strong> 2
//<strong>Explanation:</strong> The subarray [4,3] has the minimal length under the problem constraint.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> target = 4, nums = [1,4,4]
//<strong>Output:</strong> 1
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> target = 11, nums = [1,1,1,1,1,1,1,1]
//<strong>Output:</strong> 0
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= target &lt;= 10<sup>9</sup></code></li> 
// <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
//</ul>
//
//<p>&nbsp;</p> 
//<strong>Follow up:</strong> If you have figured out the 
//<code>O(n)</code> solution, try coding another solution of which the time complexity is 
//<code>O(n log(n))</code>.
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 前缀和 | 滑动窗口</details><br>
//
//<div>👍 1489, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Minimum Size Subarray Sum
 *
 * @author DY
 * @date 2022-12-20 15:43:28
 */
public class P209_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P209_MinimumSizeSubarraySum().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0, right = 0;
            int rs = Integer.MAX_VALUE;
            int sum = 0;
            for (; right < nums.length; right++) {
                sum += nums[right];
                while (sum >= target) {
                    rs = Math.min(rs, right - left + 1);
                    sum -= nums[left++];
                }
            }
            return rs == Integer.MAX_VALUE ? 0 : rs;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}