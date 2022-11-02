//<p>You are given a <strong>0-indexed</strong> array of integers <code>nums</code> of length <code>n</code>. You are initially positioned at <code>nums[0]</code>.</p>
//
//<p>Each element <code>nums[i]</code> represents the maximum length of a forward jump from index <code>i</code>. In other words, if you are at <code>nums[i]</code>, you can jump to any <code>nums[i + j]</code> where:</p>
//
//<ul> 
// <li><code>0 &lt;= j &lt;= nums[i]</code> and</li> 
// <li><code>i + j &lt; n</code></li> 
//</ul>
//
//<p>Return <em>the minimum number of jumps to reach </em><code>nums[n - 1]</code>. The test cases are generated such that you can reach <code>nums[n - 1]</code>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [2,3,1,1,4]
//<strong>Output:</strong> 2
//<strong>Explanation:</strong> The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [2,3,0,1,4]
//<strong>Output:</strong> 2
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
// <li><code>0 &lt;= nums[i] &lt;= 1000</code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 动态规划</details><br>
//
//<div>👍 1856, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Jump Game II
 *
 * @author DY
 * @date 2022-11-02 16:58:07
 */
public class P45_JumpGameIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P45_JumpGameIi().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            int n = nums.length;
            int jump = 0;
            int end = 0;
            int fasted = 0;
            for (int i = 0; i < n - 1; i++) {
                fasted = Math.max(fasted, i + nums[i]);
                if (end == i) {
                    jump++;
                    end = fasted;
                }
            }
            return jump;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}