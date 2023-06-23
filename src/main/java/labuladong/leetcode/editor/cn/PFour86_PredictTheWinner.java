/**
 * You are given an integer array nums. Two players are playing a game with this
 * array: player 1 and player 2.
 * <p>
 * Player 1 and player 2 take turns, with player 1 starting first. Both players
 * start the game with a score of 0. At each turn, the player takes one of the
 * numbers from either end of the array (i.e., nums[0] or nums[nums.length - 1]) which
 * reduces the size of the array by 1. The player adds the chosen number to their
 * score. The game ends when there are no more elements in the array.
 * <p>
 * Return true if Player 1 can win the game. If the scores of both players are
 * equal, then player 1 is still the winner, and you should also return true. You may
 * assume that both players are playing optimally.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [1,5,2]
 * Output: false
 * Explanation: Initially, player 1 can choose between 1 and 2.
 * If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player
 * 2 chooses 5, then player 1 will be left with 1 (or 2).
 * So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
 * Hence, player 1 will never be the winner and you need to return false.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [1,5,233,7]
 * Output: true
 * Explanation: Player 1 first chooses 1. Then player 2 has to choose between 5
 * and 7. No matter which number player 2 choose, player 1 can choose 233.
 * Finally, player 1 has more score (234) than player 2 (12), so you need to
 * return True representing player1 can win.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 10⁷
 * <p>
 * <p>
 * Related Topics递归 | 数组 | 数学 | 动态规划 | 博弈
 * <p>
 * 👍 636, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

/**
 * Predict the Winner
 *
 * @author DY
 * @date 2023-06-23 16:28:15
 */
public class PFour86_PredictTheWinner {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFour86_PredictTheWinner().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean PredictTheWinner(int[] nums) {
            int n = nums.length;
            int[][][] dp = new int[n][n][2]; // dp[i][j][0] -> (i,j) 中先手最大值，dp[i][j][1] -> (i,j) 中后手最大值
            for (int i = 0; i < n; i++) {
                dp[i][i][0] = nums[i];
                dp[i][i][1] = 0;
            }
            for (int i = n - 2; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    int left = nums[i] + dp[i + 1][j][1];
                    int right = nums[j] + dp[i][j - 1][1];
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
