//<p>You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are <strong>arranged in a circle.</strong> That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and&nbsp;<b>it will automatically contact the police if two adjacent houses were broken into on the same night</b>.</p>
//
//<p>Given an integer array <code>nums</code> representing the amount of money of each house, return <em>the maximum amount of money you can rob tonight <strong>without alerting the police</strong></em>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [2,3,2]
//<strong>Output:</strong> 3
//<strong>Explanation:</strong> You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,2,3,1]
//<strong>Output:</strong> 4
//<strong>Explanation:</strong> Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,2,3]
//<strong>Output:</strong> 3
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
//	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>
//
//<div>👍 1131, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * House Robber II
 *
 * @author DY
 * @date 2022-08-17 14:29:01
 */
public class P213_HouseRobberIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P213_HouseRobberIi().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int rob(int[] nums) {
            if (nums.length == 1) return nums[0];
            return Math.max(dp(nums, 0, nums.length - 2), dp(nums, 1, nums.length - 1));
        }

        private int dp(int[] nums, int start, int end) {
            int n = nums.length;
            int[] dp = new int[n + 2];

            for (int i = end; i >= start; i--) {
                dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
            }
            return dp[start];
        }

        /*public int rob(int[] nums) {
            if (nums.length == 1) return nums[0];
            return Math.max(dp(nums, 0, nums.length - 2), dp(nums, 1, nums.length - 1));
        }

        private int dp(int[] nums, int start, int end) {
            int[] dp = new int[nums.length + 2]; // dp[i] = x : 从第i个店铺开始抢劫，最大获取x金额

            for (int i = end; i >= start; i--) {
                dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
            }
            return dp[start];
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}