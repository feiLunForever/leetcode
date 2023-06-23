/**
 * You are given a 0-indexed array of integers nums of length n. You are initially
 * positioned at nums[0].
 * <p>
 * Each element nums[i] represents the maximum length of a forward jump from
 * index i. In other words, if you are at nums[i], you can jump to any nums[i + j]
 * where:
 * <p>
 * <p>
 * 0 <= j <= nums[i] and
 * i + j < n
 * <p>
 * <p>
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are
 * generated such that you can reach nums[n - 1].
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1
 * step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * 0 <= nums[i] <= 1000
 * It's guaranteed that you can reach nums[n - 1].
 * <p>
 * <p>
 * Related Topics贪心 | 数组 | 动态规划
 * <p>
 * 👍 2141, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

/**
 * Jump Game II
 *
 * @author DY
 * @date 2023-06-23 23:24:49
 */
public class PFour5_JumpGameIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFour5_JumpGameIi().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            int n = nums.length;
            int jumps = 0;
            int end = 0, nextEnd = 0;
            for (int i = 0; i < n - 1; i++) {
                nextEnd = Math.max(nextEnd, i + nums[i]);
                if (end == i) {
                    ++jumps;
                    end = nextEnd;
                }
            }
            return jumps;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
