/**
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with
 * a number on it represented by an array nums. You are asked to burst all the
 * balloons.
 * <p>
 * If you burst the iᵗʰ balloon, you will get nums[i - 1] * nums[i] * nums[i + 1]
 * coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if
 * there is a balloon with a 1 painted on it.
 * <p>
 * Return the maximum coins you can collect by bursting the balloons wisely.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [3,1,5,8]
 * Output: 167
 * Explanation:
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [1,5]
 * Output: 10
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * 0 <= nums[i] <= 100
 * <p>
 * <p>
 * Related Topics数组 | 动态规划
 * <p>
 * 👍 1246, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

/**
 * Burst Balloons
 *
 * @author DY
 * @date 2023-06-23 15:44:32
 */
public class PThree12_BurstBalloons {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PThree12_BurstBalloons().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxCoins(int[] nums) {
            int n = nums.length;
            int[] points = new int[n + 2];
            for (int i = 0; i < n; i++) {
                points[i + 1] = nums[i];
            }
            points[0] = points[n + 1] = 1;
            int[][] dp = new int[n + 2][n + 2]; // dp[i][j] -> i,j 之间最大值

            for (int i = n; i >= 0; i--) {
                for (int j = i + 1; j <= n + 1; j++) {
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.max(
                                dp[i][j],
                                dp[i][k] + dp[k][j] + points[i] * points[j] * points[k]
                        );
                    }
                }
            }
            return dp[0][n + 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
