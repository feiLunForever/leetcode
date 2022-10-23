//<p>Given a <strong>non-empty</strong> array <code>nums</code> containing <strong>only positive integers</strong>, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,5,11,5]
//<strong>Output:</strong> true
//<strong>Explanation:</strong> The array can be partitioned as [1, 5, 5] and [11].
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,2,3,5]
//<strong>Output:</strong> false
//<strong>Explanation:</strong> The array cannot be partitioned into equal sum subsets.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 200</code></li> 
// <li><code>1 &lt;= nums[i] &lt;= 100</code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>
//
//<div>👍 1535, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Partition Equal Subset Sum
 *
 * @author DY
 * @date 2022-10-23 12:46:10
 */
public class P416_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P416_PartitionEqualSubsetSum().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) return false;
            sum /= 2;
            boolean[][] dp = new boolean[nums.length + 1][sum + 1];
            for (int i = 0; i <= nums.length; i++) {
                dp[i][0] = true;
            }
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 1; j <= sum; j++) {
                    if (j - nums[i - 1] < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
            return dp[nums.length][sum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}