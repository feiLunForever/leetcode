/**
 * <p>You are given an integer array <code>nums</code> and an integer <code>target</code>.</p>
 *
 * <p>You want to build an <strong>expression</strong> out of nums by adding one of the symbols <code>'+'</code> and <code>'-'</code> before each integer in nums and then concatenate all the integers.</p>
 *
 * <ul>
 * <li>For example, if <code>nums = [2, 1]</code>, you can add a <code>'+'</code> before <code>2</code> and a <code>'-'</code> before <code>1</code> and concatenate them to build the expression <code>"+2-1"</code>.</li>
 * </ul>
 *
 * <p>Return the number of different <strong>expressions</strong> that you can build, which evaluates to <code>target</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,1,1,1,1], target = 3
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1], target = 1
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 20</code></li>
 * <li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
 * <li><code>0 &lt;= sum(nums[i]) &lt;= 1000</code></li>
 * <li><code>-1000 &lt;= target &lt;= 1000</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 动态规划 | 回溯</details><br>
 *
 * <div>👍 1649, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Target Sum
 *
 * @author DY
 * @date 2023-06-19 15:58:32
 */
public class PFour94_TargetSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFour94_TargetSum().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            if (nums.length == 0) return 0;
            Map<String, Integer> memo = new HashMap<>();
            return dp(nums, 0, target, memo);
        }

        private int dp(int[] nums, int i, int remain, Map<String, Integer> memo) {
            if (i == nums.length) {
                return remain == 0 ? 1 : 0;
            }
            String key = i + "_" + remain;
            if (memo.containsKey(key)) return memo.get(key);
            int result = dp(nums, i + 1, remain - nums[i], memo)
                    + dp(nums, i + 1, remain + nums[i], memo);
            memo.put(key, result);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
