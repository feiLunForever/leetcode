/**
 * <p>Given an integer array <code>nums</code>, return <code>true</code> <em>if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or </em><code>false</code><em> otherwise</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,5,11,5]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> The array can be partitioned as [1, 5, 5] and [11].
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,2,3,5]
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> The array cannot be partitioned into equal sum subsets.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 200</code></li>
 * <li><code>1 &lt;= nums[i] &lt;= 100</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>
 *
 * <div>👍 1785, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Partition Equal Subset Sum
 *
 * @author DY
 * @date 2023-06-19 14:23:20
 */
public class PFour16_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFour16_PartitionEqualSubsetSum().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 == 1) return false; // 和为奇数，则不可能被平等划分
            sum /= 2;
            boolean[][] dp = new boolean[n + 1][sum + 1]; // dp[i][j] -> 对于前 i 个物品（i 从 1 开始计数），当前背包的容量为 j 时，若 x 为 true，则说明可以恰好将背包装满，若 x 为 false，则说明不能恰好将背包装满。
            for (int i = 0; i <= n; i++) {
                dp[i][0] = true; // 背包容量为0，默认填满
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= sum; j++) {
                    if (j - nums[i - 1] < 0) { // 当前背包容量已不够
                        dp[i][j] = dp[i - 1][j]; // 不能装入第 i 个物品
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]; // 装入或不装入背包
                    }
                }
            }
            return dp[n][sum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
