//<p>Given an integer array <code>nums</code>, move all <code>0</code>'s to the end of it while maintaining the relative order of the non-zero elements.</p>
//
//<p><strong>Note</strong> that you must do this in-place without making a copy of the array.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p> 
//<pre><strong>Input:</strong> nums = [0,1,0,3,12]
//<strong>Output:</strong> [1,3,12,0,0]
//</pre>
//<p><strong class="example">Example 2:</strong></p> 
//<pre><strong>Input:</strong> nums = [0]
//<strong>Output:</strong> [0]
//</pre> 
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
// <li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li> 
//</ul>
//
//<p>&nbsp;</p> 
//<strong>Follow up:</strong> Could you minimize the total number of operations done?
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>
//
//<div>👍 1817, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Move Zeroes
 *
 * @author DY
 * @date 2022-12-11 14:39:09
 */
public class P283_MoveZeroes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P283_MoveZeroes().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int slow = 0, fast = 0;  // nums[0...slow] 不为0
            while (fast < nums.length) {
                if (nums[fast] != 0) {
                    if (slow != fast) {
                        nums[slow] = nums[fast];
                    }
                    ++slow;
                }
                ++fast;
            }
            while (slow < nums.length) {
                nums[slow++] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}