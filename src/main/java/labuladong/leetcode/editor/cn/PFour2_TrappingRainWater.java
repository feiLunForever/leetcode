/**
 * <p>Given <code>n</code> non-negative integers representing an elevation map where the width of each bar is <code>1</code>, compute how much water it can trap after raining.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img src="https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png" style="width: 412px; height: 161px;" />
 * <pre>
 * <strong>Input:</strong> height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> height = [4,2,0,3,2,5]
 * <strong>Output:</strong> 9
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>n == height.length</code></li>
 * <li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li>
 * <li><code>0 &lt;= height[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 双指针 | 动态规划 | 单调栈</details><br>
 *
 * <div>👍 4414, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Trapping Rain Water
 *
 * @author DY
 * @date 2023-06-29 14:27:36
 */
public class PFour2_TrappingRainWater {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFour2_TrappingRainWater().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            int res = 0;
            while (left < right) {
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if (leftMax < rightMax) {
                    res += leftMax - height[left];
                    ++left;
                } else {
                    res += rightMax - height[right];
                    --right;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
