//<p>You are given an integer array <code>nums</code>. You are initially positioned at the array's <strong>first index</strong>, and each element in the array represents your maximum jump length at that position.</p>
//
//<p>Return <code>true</code><em> if you can reach the last index, or </em><code>false</code><em> otherwise</em>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [2,3,1,1,4]
//<strong>Output:</strong> true
//<strong>Explanation:</strong> Jump 1 step from index 0 to 1, then 3 steps to the last index.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [3,2,1,0,4]
//<strong>Output:</strong> false
//<strong>Explanation:</strong> You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
// <li><code>0 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 动态规划</details><br>
//
//<div>👍 2071, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Jump Game
 *
 * @author DY
 * @date 2022-11-02 16:44:21
 */
public class P55_JumpGame {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P55_JumpGame().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int fasted = 0;
            for (int i = 0; i < n - 1; i++) {
                fasted = Math.max(fasted, i + nums[i]);
                if (fasted <= i) {
                    return false;
                }
            }
            return fasted >= n - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}