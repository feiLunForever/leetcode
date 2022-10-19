//<p>Given an integer array <code>nums</code>, find the contiguous subarray (containing at least one number) which has the largest sum and return <em>its sum</em>.</p>
//
//<p>A <strong>subarray</strong> is a <strong>contiguous</strong> part of an array.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [-2,1,-3,4,-1,2,1,-5,4]
//<strong>Output:</strong> 6
//<strong>Explanation:</strong> [4,-1,2,1] has the largest sum = 6.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1]
//<strong>Output:</strong> 1
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [5,4,-1,7,8]
//<strong>Output:</strong> 23
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
//</ul>
//
//<p>&nbsp;</p> 
//<p><strong>Follow up:</strong> If you have figured out the <code>O(n)</code> solution, try coding another solution using the <strong>divide and conquer</strong> approach, which is more subtle.</p>
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 分治 | 动态规划</details><br>
//
//<div>👍 5375, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Maximum Subarray
 *
 * @author DY
 * @date 2022-10-19 09:43:41
 */
public class P53_MaximumSubarray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P53_MaximumSubarray().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            int max = nums[0];
//			int[] dp = new int[n]; // dp[i] 代表 nums[i] 为结尾的「最大子数组和」
            int dp_0 = nums[0];
            for (int i = 1; i < n; i++) {
                int dp_1 = Math.max(nums[i], nums[i] + dp_0);
                dp_0 = dp_1;
                max = Math.max(dp_1, max);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}