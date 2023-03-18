/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>数组 | 分治 | 动态规划</details><br>
 *
 * <div>👍 669, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 连续子数组的最大和  LCOF
 *
 * @author DY
 * @date 2023-03-17 18:59:00
 */
public class PJianZhiOffer42_LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer42_LianXuZiShuZuDeZuiDaHeLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int dp_0 = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int dp_1 = Math.max(nums[i], nums[i] + dp_0);
                dp_0 = dp_1;
                max = Math.max(max, dp_1);
            }
            return max;
        }

        public int maxSubArray1(int[] nums) {
            int[] dp = new int[nums.length]; // dp[i] dp[0..i] 连续子数组最大和
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
