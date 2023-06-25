/**
 * <p>Given an integer array <code>nums</code> with possible <strong>duplicates</strong>, randomly output the index of a given <code>target</code> number. You can assume that the given target number must exist in the array.</p>
 *
 * <p>Implement the <code>Solution</code> class:</p>
 *
 * <ul>
 * <li><code>Solution(int[] nums)</code> Initializes the object with the array <code>nums</code>.</li>
 * <li><code>int pick(int target)</code> Picks a random index <code>i</code> from <code>nums</code> where <code>nums[i] == target</code>. If there are multiple valid i's, then each index should have an equal probability of returning.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * ["Solution", "pick", "pick", "pick"]
 * [[[1, 2, 3, 3, 3]], [3], [1], [3]]
 * <strong>Output</strong>
 * [null, 4, 0, 2]
 *
 * <strong>Explanation</strong>
 * Solution solution = new Solution([1, 2, 3, 3, 3]);
 * solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(1); // It should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
 * <li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
 * <li><code>target</code> is an integer from <code>nums</code>.</li>
 * <li>At most <code>10<sup>4</sup></code> calls will be made to <code>pick</code>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>水塘抽样 | 哈希表 | 数学 | 随机化</details><br>
 *
 * <div>👍 267, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Random;

/**
 * Random Pick Index
 *
 * @author DY
 * @date 2023-06-25 12:38:57
 */
public class PThree98_RandomPickIndex {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PThree98_RandomPickIndex().new Solution(null);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final int[] nums;
        private final Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            this.random = new Random();
        }

        public int pick(int target) {
            int count = 0, res = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] != target) continue;
                ++count;
                if(0 == random.nextInt(count)) {
                    res = i;
                }
            }
            return res;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
