/**
 * <p>Given an integer array <code>nums</code>, find the <span data-keyword="subarray-nonempty">subarray</span> with the largest sum, and return <em>its sum</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [-2,1,-3,4,-1,2,1,-5,4]
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> The subarray [4,-1,2,1] has the largest sum 6.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The subarray [1] has the largest sum 1.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [5,4,-1,7,8]
 * <strong>Output:</strong> 23
 * <strong>Explanation:</strong> The subarray [5,4,-1,7,8] has the largest sum 23.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> If you have figured out the <code>O(n)</code> solution, try coding another solution using the <strong>divide and conquer</strong> approach, which is more subtle.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 分治 | 动态规划</details><br>
 *
 * <div>👍 6115, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Maximum Subarray
 *
 * @author DY
 * @date 2023-06-17 18:17:52
 */
public class PFive3_MaximumSubarray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFive3_MaximumSubarray().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
		public int maxSubArray(int[] nums) {
			int n = nums.length;
			if (n == 0) return 0;
//			int[] dp = new int[n]; // dp[i] => 以nums[i]结尾的「最大子数组和」
			int dp_0 = nums[0]; // 只有自己
			int max = nums[0];
			for (int i = 1; i < n; i++) {
				int dp_1 = Math.max(nums[i], dp_0 + nums[i]);
				dp_0 = dp_1;
				max = Math.max(max, dp_1);
			}
			return max;
		}

        public int maxSubArray1(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            int[] dp = new int[n]; // dp[i] => 以nums[i]结尾的「最大子数组和」
            dp[0] = nums[0]; // 只有自己
            int max = nums[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
