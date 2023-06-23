/**
 * You are given an integer array nums. You are initially positioned at the
 * array's first index, and each element in the array represents your maximum jump length
 * at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump
 * length is 0, which makes it impossible to reach the last index.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * 0 <= nums[i] <= 10⁵
 * <p>
 * <p>
 * Related Topics贪心 | 数组 | 动态规划
 * <p>
 * 👍 2361, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

/**
 * Jump Game
 *
 * @author DY
 * @date 2023-06-23 23:15:39
 */
public class PFive5_JumpGame {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFive5_JumpGame().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int res = 0;
            for (int i = 0; i < n - 1; i++) {
                res = Math.max(res, i + nums[i]);
                if (res <= i) return false;
            }
            return res >= n - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
