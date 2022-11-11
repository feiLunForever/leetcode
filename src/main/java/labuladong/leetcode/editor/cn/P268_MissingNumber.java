//<p>Given an array <code>nums</code> containing <code>n</code> distinct numbers in the range <code>[0, n]</code>, return <em>the only number in the range that is missing from the array.</em></p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [3,0,1]
//<strong>Output:</strong> 2
//<strong>Explanation:</strong> n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [0,1]
//<strong>Output:</strong> 2
//<strong>Explanation:</strong> n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [9,6,4,2,3,5,7,0,1]
//<strong>Output:</strong> 8
//<strong>Explanation:</strong> n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>n == nums.length</code></li> 
// <li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li> 
// <li><code>0 &lt;= nums[i] &lt;= n</code></li> 
// <li>All the numbers of <code>nums</code> are <strong>unique</strong>.</li> 
//</ul>
//
//<p>&nbsp;</p> 
//<p><strong>Follow up:</strong> Could you implement a solution using only <code>O(1)</code> extra space complexity and <code>O(n)</code> runtime complexity?</p>
//
//<details><summary><strong>Related Topics</strong></summary>位运算 | 数组 | 哈希表 | 数学 | 二分查找 | 排序</details><br>
//
//<div>👍 665, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Missing Number
 *
 * @author DY
 * @date 2022-11-11 20:42:52
 */
public class P268_MissingNumber {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P268_MissingNumber().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length, res = 0;
            res ^= n;
            for (int i = 0; i < n; i++) {
                res ^= (i ^ nums[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}