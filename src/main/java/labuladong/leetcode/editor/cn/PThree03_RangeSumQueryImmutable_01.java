/**
 * <p>Given an integer array <code>nums</code>, handle multiple queries of the following type:</p>
 *
 * <ol>
 * <li>Calculate the <strong>sum</strong> of the elements of <code>nums</code> between indices <code>left</code> and <code>right</code> <strong>inclusive</strong> where <code>left &lt;= right</code>.</li>
 * </ol>
 *
 * <p>Implement the <code>NumArray</code> class:</p>
 *
 * <ul>
 * <li><code>NumArray(int[] nums)</code> Initializes the object with the integer array <code>nums</code>.</li>
 * <li><code>int sumRange(int left, int right)</code> Returns the <strong>sum</strong> of the elements of <code>nums</code> between indices <code>left</code> and <code>right</code> <strong>inclusive</strong> (i.e. <code>nums[left] + nums[left + 1] + ... + nums[right]</code>).</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * <strong>Output</strong>
 * [null, 1, -1, -3]
 *
 * <strong>Explanation</strong>
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
 * numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
 * numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
 * <li><code>0 &lt;= left &lt;= right &lt; nums.length</code></li>
 * <li>At most <code>10<sup>4</sup></code> calls will be made to <code>sumRange</code>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>设计 | 数组 | 前缀和</details><br>
 *
 * <div>👍 567, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Range Sum Query - Immutable
 *
 * @author DY
 * @date 2023-08-11 15:43:05
 */
public class PThree03_RangeSumQueryImmutable_01 {
    public static void main(String[] args) {
        //测试代码
        NumArray solution = new PThree03_RangeSumQueryImmutable_01().new NumArray(null);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {

        private final int[] preSum;

        public NumArray(int[] nums) {
            preSum = new int[nums.length + 1];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
