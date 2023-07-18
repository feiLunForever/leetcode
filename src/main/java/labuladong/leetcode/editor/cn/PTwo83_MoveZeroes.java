/**
 * <p>Given an integer array <code>nums</code>, move all <code>0</code>'s to the end of it while maintaining the relative order of the non-zero elements.</p>
 *
 * <p><strong>Note</strong> that you must do this in-place without making a copy of the array.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [0,1,0,3,12]
 * <strong>Output:</strong> [1,3,12,0,0]
 * </pre>
 * <p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = [0]
 * <strong>Output:</strong> [0]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong> Could you minimize the total number of operations done?
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>
 *
 * <div>👍 2065, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Move Zeroes
 *
 * @author DY
 * @date 2023-07-18 17:02:59
 */
public class PTwo83_MoveZeroes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PTwo83_MoveZeroes().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int slow = 0, fast = 0;
            int n = nums.length;
            while (fast < n) {
                if (nums[fast] == 0) {
                    ++fast;
                } else {
                    nums[slow++] = nums[fast++];
                }
            }
            while (slow < n) {
                nums[slow++] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
