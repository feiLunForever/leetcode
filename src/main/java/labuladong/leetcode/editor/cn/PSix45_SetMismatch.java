/**
 * <p>You have a set of integers <code>s</code>, which originally contains all the numbers from <code>1</code> to <code>n</code>. Unfortunately, due to some error, one of the numbers in <code>s</code> got duplicated to another number in the set, which results in <strong>repetition of one</strong> number and <strong>loss of another</strong> number.</p>
 *
 * <p>You are given an integer array <code>nums</code> representing the data status of this set after the error.</p>
 *
 * <p>Find the number that occurs twice and the number that is missing and return <em>them in the form of an array</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [1,2,2,4]
 * <strong>Output:</strong> [2,3]
 * </pre>
 * <p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = [1,1]
 * <strong>Output:</strong> [1,2]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>位运算 | 数组 | 哈希表 | 排序</details><br>
 *
 * <div>👍 332, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Set Mismatch
 *
 * @author DY
 * @date 2023-06-26 16:49:31
 */
public class PSix45_SetMismatch {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSix45_SetMismatch().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findErrorNums(int[] nums) {
            int n = nums.length, dum = -1, missing = -1;
            for (int i = 0; i < n; i++) {
                int index = Math.abs(nums[i]) - 1; // 元素是从1开始的
                if (nums[index] < 0)
                    dum = Math.abs(nums[i]);
                else
                    nums[index] *= -1;
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    missing = i + 1;
                }
            }
            return new int[]{dum, missing};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
