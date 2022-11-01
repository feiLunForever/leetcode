//<p>You are given <code>n</code> balloons, indexed from <code>0</code> to <code>n - 1</code>. Each balloon is painted with a number on it represented by an array <code>nums</code>. You are asked to burst all the balloons.</p>
//
//<p>If you burst the <code>i<sup>th</sup></code> balloon, you will get <code>nums[i - 1] * nums[i] * nums[i + 1]</code> coins. If <code>i - 1</code> or <code>i + 1</code> goes out of bounds of the array, then treat it as if there is a balloon with a <code>1</code> painted on it.</p>
//
//<p>Return <em>the maximum coins you can collect by bursting the balloons wisely</em>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [3,1,5,8]
//<strong>Output:</strong> 167
//<strong>Explanation:</strong>
//nums = [3,1,5,8] --&gt; [3,5,8] --&gt; [3,8] --&gt; [8] --&gt; []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,5]
//<strong>Output:</strong> 10
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>n == nums.length</code></li> 
// <li><code>1 &lt;= n &lt;= 300</code></li> 
// <li><code>0 &lt;= nums[i] &lt;= 100</code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>
//
//<div>👍 1125, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Burst Balloons
 *
 * @author DY
 * @date 2022-11-01 12:38:57
 */
public class P312_BurstBalloons {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P312_BurstBalloons().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxCoins(int[] nums) {
            int n = nums.length;
            int[] orders = new int[n + 2];
            for (int i = 0; i < n; i++) {
                orders[i + 1] = nums[i];
            }
            orders[0] = orders[n + 1] = 1;
            int[][] dp = new int[n + 2][n + 2]; // dp[i][j] 代表 (i,j)中最大金额
            dp(orders, dp);
            return dp[0][n + 1];
        }

        private void dp(int[] orders, int[][] dp) {
            for (int i = orders.length - 2; i >= 0; i--) { // 从下到上
                for (int j = i + 1; j < orders.length; j++) {
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.max(
                                dp[i][j],
                                dp[i][k] + dp[k][j] + orders[k] * orders[i] * orders[j]
                        );
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}