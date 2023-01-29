//<p>Given a circular integer array <code>nums</code> (i.e., the next element of <code>nums[nums.length - 1]</code> is <code>nums[0]</code>), return <em>the <strong>next greater number</strong> for every element in</em> <code>nums</code>.</p>
//
//<p>The <strong>next greater number</strong> of a number <code>x</code> is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return <code>-1</code> for this number.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,2,1]
//<strong>Output:</strong> [2,-1,2]
//Explanation: The first 1's next greater number is 2; 
//The number 2 can't find next greater number. 
//The second 1's next greater number needs to search circularly, which is also 2.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,2,3,4,3]
//<strong>Output:</strong> [2,3,4,-1,4]
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
// <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 单调栈</details><br>
//
//<div>👍 718, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Stack;

/**
 * Next Greater Element II
 *
 * @author DY
 * @date 2022-10-13 09:44:29
 */
public class P503_NextGreaterElementIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P503_NextGreaterElementIi().new Solution();
        System.out.println(solution.nextGreaterElements(new int[]{1, 2, 1}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            Stack<Integer> stack = new Stack<>();
            for (int i = 2 * n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                    stack.pop();
                }
                res[i % n] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums[i % n]);
            }
            return res;
        }

        /*public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[n];
            for (int i = 2 * n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && nums[i % n] >= stack.peek()) {
                    stack.pop();
                }
                res[i % n] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums[i % n]);
            }
            return res;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}