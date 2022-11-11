//<p>Given a <strong>non-empty</strong>&nbsp;array of integers <code>nums</code>, every element appears <em>twice</em> except for one. Find that single one.</p>
//
//<p>You must&nbsp;implement a solution with a linear runtime complexity and use&nbsp;only constant&nbsp;extra space.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p> 
//<pre><strong>Input:</strong> nums = [2,2,1]
//<strong>Output:</strong> 1
//</pre>
//<p><strong class="example">Example 2:</strong></p> 
//<pre><strong>Input:</strong> nums = [4,1,2,1,2]
//<strong>Output:</strong> 4
//</pre>
//<p><strong class="example">Example 3:</strong></p> 
//<pre><strong>Input:</strong> nums = [1]
//<strong>Output:</strong> 1
//</pre> 
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li> 
// <li><code>-3 * 10<sup>4</sup> &lt;= nums[i] &lt;= 3 * 10<sup>4</sup></code></li> 
// <li>Each element in the array appears twice except for one element which appears only once.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>位运算 | 数组</details><br>
//
//<div>👍 2648, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Single Number
 *
 * @author DY
 * @date 2022-11-11 20:36:11
 */
public class P136_SingleNumber {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P136_SingleNumber().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            for (int num : nums) {
                res ^= num;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}