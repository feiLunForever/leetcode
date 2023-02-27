//<p>You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and <b>it will automatically contact the police if two adjacent houses were broken into on the same night</b>.</p>
//
//<p>Given an integer array <code>nums</code> representing the amount of money of each house, return <em>the maximum amount of money you can rob tonight <b>without alerting the police</b></em>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,2,3,1]
//<strong>Output:</strong> 4
//<strong>Explanation:</strong> Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [2,7,9,3,1]
//<strong>Output:</strong> 12
//<strong>Explanation:</strong> Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
//	<li><code>0 &lt;= nums[i] &lt;= 400</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>
//
//<div>👍 2258, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * House Robber
 *
 * @author DY
 * @date 2022-08-17 09:55:05
 */
public class P198_HouseRobber {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P198_HouseRobber().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n + 2]; // dp[i] = x,从第i间房开始抢，最多x钱
            for (int i = n - 1; i >= 0; i--) {
                dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
            }
            return dp[0];
        }

        /*public int rob(int[] nums) {
            int[] dp = new int[nums.length + 2]; // dp[i] = x,从第i间房开始抢，最多x钱

            for (int i = nums.length - 1; i >= 0; i--) {
                // 不抢，去下一家看看
                // 抢，去下下家看看
                dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
            }
            return dp[0];
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}