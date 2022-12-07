//<p>Given <code>n</code> non-negative integers representing an elevation map where the width of each bar is <code>1</code>, compute how much water it can trap after raining.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p> 
//<img src="https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png" style="width: 412px; height: 161px;" /> 
//<pre>
//<strong>Input:</strong> height = [0,1,0,2,1,0,1,3,2,1,2,1]
//<strong>Output:</strong> 6
//<strong>Explanation:</strong> The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> height = [4,2,0,3,2,5]
//<strong>Output:</strong> 9
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>n == height.length</code></li> 
// <li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li> 
// <li><code>0 &lt;= height[i] &lt;= 10<sup>5</sup></code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 双指针 | 动态规划 | 单调栈</details><br>
//
//<div>👍 3975, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Trapping Rain Water
 *
 * @author DY
 * @date 2022-12-07 11:08:16
 */
public class P42_TrappingRainWater {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P42_TrappingRainWater().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int res = 0;
            int lMax = 0, rMax = 0; // 记录左右边界最大值
            int left = 0, right = height.length - 1;
            while (left < right) {
                lMax = Math.max(lMax, height[left]);
                rMax = Math.max(rMax, height[right]);

                if (lMax < rMax) { // 能确定 height[left] 雨量
                    res += lMax - height[left];
                    left++;
                } else {
                    res += rMax - height[right];
                    right--;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}