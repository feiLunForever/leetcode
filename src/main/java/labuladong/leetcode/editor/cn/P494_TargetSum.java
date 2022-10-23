//<p>You are given an integer array <code>nums</code> and an integer <code>target</code>.</p>
//
//<p>You want to build an <strong>expression</strong> out of nums by adding one of the symbols <code>'+'</code> and <code>'-'</code> before each integer in nums and then concatenate all the integers.</p>
//
//<ul> 
// <li>For example, if <code>nums = [2, 1]</code>, you can add a <code>'+'</code> before <code>2</code> and a <code>'-'</code> before <code>1</code> and concatenate them to build the expression <code>"+2-1"</code>.</li> 
//</ul>
//
//<p>Return the number of different <strong>expressions</strong> that you can build, which evaluates to <code>target</code>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,1,1,1,1], target = 3
//<strong>Output:</strong> 5
//<strong>Explanation:</strong> There are 5 ways to assign symbols to make the sum of nums be target 3.
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1], target = 1
//<strong>Output:</strong> 1
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 20</code></li> 
// <li><code>0 &lt;= nums[i] &lt;= 1000</code></li> 
// <li><code>0 &lt;= sum(nums[i]) &lt;= 1000</code></li> 
// <li><code>-1000 &lt;= target &lt;= 1000</code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划 | 回溯</details><br>
//
//<div>👍 1412, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.HashMap;

/**
 * Target Sum
 *
 * @author DY
 * @date 2022-10-23 14:20:31
 */
public class P494_TargetSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P494_TargetSum().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if ((sum + target) % 2 == 1 || sum < Math.abs(target)) {
                return 0;
            }
            return subsets(nums, (sum + target) / 2);
        }

        private int subsets(int[] nums, int sum) {
            int n = nums.length;
            int[][] dp = new int[n + 1][sum + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= sum; j++) {
                    if (j < nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
            return dp[n][sum];
        }


        public int findTargetSumWays1(int[] nums, int target) {
            if (nums.length == 0) return 0;
            return dp(nums, 0, target, new HashMap<String, Integer>());
        }

        private int dp(int[] nums, int i, int remain, HashMap<String, Integer> dp) {
            if (i == nums.length) {
                if (remain == 0) return 1;
                return 0;
            }
            String key = i + "@" + remain;
            if (dp.containsKey(key)) return dp.get(key);
            int result = dp(nums, i + 1, remain - nums[i], dp) + dp(nums, i + 1, remain + nums[i], dp);
            dp.put(key, result);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
