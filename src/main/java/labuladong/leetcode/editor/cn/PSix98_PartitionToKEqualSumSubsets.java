/**
 * Given an integer array nums and an integer k, return true if it is possible to
 * divide this array into k non-empty subsets whose sums are all equal.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [4,3,2,3,5,2,1], k = 4
 * Output: true
 * Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3
 * ) with equal sums.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= k <= nums.length <= 16
 * 1 <= nums[i] <= 10⁴
 * The frequency of each element is in the range [1, 4].
 * <p>
 * <p>
 * Related Topics位运算 | 记忆化搜索 | 数组 | 动态规划 | 回溯 | 状态压缩
 * <p>
 * 👍 945, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Partition to K Equal Sum Subsets
 *
 * @author DY
 * @date 2023-06-24 14:23:30
 */
public class PSix98_PartitionToKEqualSumSubsets {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSix98_PartitionToKEqualSumSubsets().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % k != 0) return false;
            sum /= k;
            int used = 0; // 使用位图技巧
            Map<Integer, Boolean> memo = new HashMap<>();
            return backTrack(k, 0, nums, 0, sum, used, memo);
        }

        /**
         * @param k      k号桶
         * @param curSum 当前桶的和
         * @param nums
         * @param start
         * @param sum
         * @param used
         * @param memo
         * @return
         */
        private boolean backTrack(int k, int curSum, int[] nums, int start, int sum, int used, Map<Integer, Boolean> memo) {
            if(k == 0) return true;
            if(curSum == sum) {
                boolean res = backTrack(k - 1, 0, nums, 0, sum, used, memo);
                memo.put(used,res);
                return res;
            }
            if(memo.containsKey(used)) {
                return memo.get(used);
            }
            for (int i = start; i < nums.length; i++) {
                if(((used >> i) & 1) == 1) { // 判断第i位是否为1
                    continue; // nums[i] 已经被装入别的桶中
                }
                if(nums[i] + curSum > sum) {
                    continue;
                }
                used |= (1 << i); // 将第i位设为1
                curSum += nums[i];
                if(backTrack(k, curSum, nums, i + 1, sum, used, memo)) { // 递归穷举下一个数字是否装入当前桶
                    return true;
                }
                // 撤销选择
                used ^= (1 << i); // 异或将第i位设为0
                curSum -= nums[i];
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
