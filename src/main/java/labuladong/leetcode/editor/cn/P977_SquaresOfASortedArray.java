//<p>Given an integer array <code>nums</code> sorted in <strong>non-decreasing</strong> order, return <em>an array of <strong>the squares of each number</strong> sorted in non-decreasing order</em>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [-4,-1,0,3,10]
//<strong>Output:</strong> [0,1,9,16,100]
//<strong>Explanation:</strong> After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [-7,-3,2,3,11]
//<strong>Output:</strong> [4,9,9,49,121]
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code><span>1 &lt;= nums.length &lt;= </span>10<sup>4</sup></code></li> 
// <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
// <li><code>nums</code> is sorted in <strong>non-decreasing</strong> order.</li> 
//</ul>
//
//<p>&nbsp;</p> 
//<strong>Follow up:</strong> Squaring each element and sorting the new array is very trivial, could you find an 
//<code>O(n)</code> solution using a different approach?
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 排序</details><br>
//
//<div>👍 682, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Squares of a Sorted Array
 *
 * @author DY
 * @date 2022-12-19 20:11:08
 */
public class P977_SquaresOfASortedArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P977_SquaresOfASortedArray().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int left = 0, right = nums.length - 1;
            int index = right;
            int[] res = new int[nums.length];
            while (left <= right) {
                if (nums[left] * nums[left] < nums[right] * nums[right]) {
                    res[index--] = nums[right] * nums[right];
                    --right;
                } else {
                    res[index--] = nums[left] * nums[left];
                    ++left;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}