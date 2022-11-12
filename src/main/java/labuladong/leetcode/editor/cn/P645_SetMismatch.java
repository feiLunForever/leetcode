//<p>You have a set of integers <code>s</code>, which originally contains all the numbers from <code>1</code> to <code>n</code>. Unfortunately, due to some error, one of the numbers in <code>s</code> got duplicated to another number in the set, which results in <strong>repetition of one</strong> number and <strong>loss of another</strong> number.</p>
//
//<p>You are given an integer array <code>nums</code> representing the data status of this set after the error.</p>
//
//<p>Find the number that occurs twice and the number that is missing and return <em>them in the form of an array</em>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p> 
//<pre><strong>Input:</strong> nums = [1,2,2,4]
//<strong>Output:</strong> [2,3]
//</pre>
//<p><strong class="example">Example 2:</strong></p> 
//<pre><strong>Input:</strong> nums = [1,1]
//<strong>Output:</strong> [1,2]
//</pre> 
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
// <li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>位运算 | 数组 | 哈希表 | 排序</details><br>
//
//<div>👍 299, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Set Mismatch
 *
 * @author DY
 * @date 2022-11-12 17:40:18
 */
public class P645_SetMismatch {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P645_SetMismatch().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findErrorNums(int[] nums) {
            int dump = -1;
            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] < 0) {
                    dump = Math.abs(nums[i]);
                } else {
                    nums[index] *= -1;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return new int[]{dump, i + 1};
                }
            }
            return new int[]{dump, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}