//<p>You are given an integer array <code>nums</code>. Two players are playing a game with this array: player 1 and player 2.</p>
//
//<p>Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of <code>0</code>. At each turn, the player takes one of the numbers from either end of the array (i.e., <code>nums[0]</code> or <code>nums[nums.length - 1]</code>) which reduces the size of the array by <code>1</code>. The player adds the chosen number to their score. The game ends when there are no more elements in the array.</p>
//
//<p>Return <code>true</code> if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, and you should also return <code>true</code>. You may assume that both players are playing optimally.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,5,2]
//<strong>Output:</strong> false
//<strong>Explanation:</strong> Initially, player 1 can choose between 1 and 2. 
//If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
//So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
//Hence, player 1 will never be the winner and you need to return false.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,5,233,7]
//<strong>Output:</strong> true
//<strong>Explanation:</strong> Player 1 first chooses 1. Then player 2 has to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
//Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 20</code></li> 
// <li><code>0 &lt;= nums[i] &lt;= 10<sup>7</sup></code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>递归 | 数组 | 数学 | 动态规划 | 博弈</details><br>
//
//<div>👍 585, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Predict the Winner
 *
 * @author DY
 * @date 2022-11-01 22:11:17
 */
public class P486_PredictTheWinner {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P486_PredictTheWinner().new Solution();
		System.out.println(solution.PredictTheWinner(new int[]{1, 5, 2}));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean PredictTheWinner(int[] nums) {
            int n = nums.length;
            int[][][] dp = new int[n][n][2]; // 初始化 dp 数组

            for (int i = 0; i < n; i++) { // base case
                dp[i][i][0] = nums[i];
                dp[i][i][1] = 0;
            }

            for (int i = n - 2; i >= 0; i--) {  // 倒着遍历数组
                for (int j = i + 1; j < n; j++) {
                    int left = nums[i] + dp[i + 1][j][1];  // 先手选择最左边或最右边的分数
                    int right = nums[j] + dp[i][j - 1][1];
					// 先手肯定会选择更大的结果，后手的选择随之改变
                    if (left > right) {
                        dp[i][j][0] = left;
                        dp[i][j][1] = dp[i + 1][j][0];
                    } else {
                        dp[i][j][0] = right;
                        dp[i][j][1] = dp[i][j - 1][0];
                    }

                }
            }
            return dp[0][n - 1][0] - dp[0][n - 1][1] >= 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}