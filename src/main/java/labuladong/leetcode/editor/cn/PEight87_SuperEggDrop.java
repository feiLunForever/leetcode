/**
 * You are given k identical eggs and you have access to a building with n floors
 * labeled from 1 to n.
 * <p>
 * You know that there exists a floor f where 0 <= f <= n such that any egg
 * dropped at a floor higher than f will break, and any egg dropped at or below floor f
 * will not break.
 * <p>
 * Each move, you may take an unbroken egg and drop it from any floor x (where 1 <
 * = x <= n). If the egg breaks, you can no longer use it. However, if the egg
 * does not break, you may reuse it in future moves.
 * <p>
 * Return the minimum number of moves that you need to determine with certainty
 * what the value of f is.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: k = 1, n = 2
 * Output: 2
 * Explanation:
 * Drop the egg from floor 1. If it breaks, we know that f = 0.
 * Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1.
 * If it does not break, then we know f = 2.
 * Hence, we need at minimum 2 moves to determine with certainty what the value of
 * f is.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: k = 2, n = 6
 * Output: 3
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: k = 3, n = 14
 * Output: 4
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= k <= 100
 * 1 <= n <= 10⁴
 * <p>
 * <p>
 * Related Topics数学 | 二分查找 | 动态规划
 * <p>
 * 👍 941, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

/**
 * Super Egg Drop
 *
 * @author DY
 * @date 2023-06-23 14:12:26
 */
public class PEight87_SuperEggDrop {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PEight87_SuperEggDrop().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int superEggDrop(int k, int n) {
            Integer[][] memo = new Integer[k + 1][n + 1];
            return dp(k, n, memo);
        }

        private int dp(int k, int n, Integer[][] memo) {
            if (k == 1) return n;
            if (n == 0) return 0;
            if (memo[k][n] != null) return memo[k][n];

            int res = Integer.MAX_VALUE;
            /*for (int i = 1; i <= n; i++) {
                res = Math.min(
                        res,
                        Math.max(dp(k, n - i, memo), dp(k - 1, i - 1, memo)) + 1
                );
            }*/
            int l = 1, r = n;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int broken = dp(k - 1, mid - 1, memo);
                int unBroken = dp(k, n - mid, memo);
                if (broken > unBroken) {
                    r = mid - 1;
                    res = Math.min(res, broken + 1);
                } else {
                    l = mid + 1;
                    res = Math.min(res, unBroken + 1);
                }
            }
            memo[k][n] = res;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
