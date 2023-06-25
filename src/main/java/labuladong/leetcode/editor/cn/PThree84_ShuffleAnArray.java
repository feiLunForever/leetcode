/**
 * <p>Given an integer array <code>nums</code>, design an algorithm to randomly shuffle the array. All permutations of the array should be <strong>equally likely</strong> as a result of the shuffling.</p>
 *
 * <p>Implement the <code>Solution</code> class:</p>
 *
 * <ul>
 * <li><code>Solution(int[] nums)</code> Initializes the object with the integer array <code>nums</code>.</li>
 * <li><code>int[] reset()</code> Resets the array to its original configuration and returns it.</li>
 * <li><code>int[] shuffle()</code> Returns a random shuffling of the array.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * <strong>Output</strong>
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * <strong>Explanation</strong>
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
 * // Any permutation of [1,2,3] must be equally likely to be returned.
 * // Example: return [3, 1, 2]
 * solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
 * solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
 *
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 50</code></li>
 * <li><code>-10<sup>6</sup> &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
 * <li>All the elements of <code>nums</code> are <strong>unique</strong>.</li>
 * <li>At most <code>10<sup>4</sup></code> calls <strong>in total</strong> will be made to <code>reset</code> and <code>shuffle</code>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 数学 | 随机化</details><br>
 *
 * <div>👍 338, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

/**
 * Shuffle an Array
 *
 * @author DY
 * @date 2023-06-25 12:08:31
 */
public class PThree84_ShuffleAnArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PThree84_ShuffleAnArray().new Solution(null);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final Random random = new Random();

        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int n = nums.length;
            int[] newArray = Arrays.copyOf(nums, n);
            for (int i = 0; i < n; i++) {
                int r = i + random.nextInt(n - i); // 生成一个 [i, n-1] 区间内的随机数
                swap(newArray, i, r);
            }
            return newArray;
        }

        private void swap(int[] newArray, int i, int j) {
            int temp = newArray[i];
            newArray[i] = newArray[j];
            newArray[j] = temp;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
