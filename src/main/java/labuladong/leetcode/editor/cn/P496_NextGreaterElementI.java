//<p>The <strong>next greater element</strong> of some element <code>x</code> in an array is the <strong>first greater</strong> element that is <strong>to the right</strong> of <code>x</code> in the same array.</p>
//
//<p>You are given two <strong>distinct 0-indexed</strong> integer arrays <code>nums1</code> and <code>nums2</code>, where <code>nums1</code> is a subset of <code>nums2</code>.</p>
//
//<p>For each <code>0 &lt;= i &lt; nums1.length</code>, find the index <code>j</code> such that <code>nums1[i] == nums2[j]</code> and determine the <strong>next greater element</strong> of <code>nums2[j]</code> in <code>nums2</code>. If there is no next greater element, then the answer for this query is <code>-1</code>.</p>
//
//<p>Return <em>an array </em><code>ans</code><em> of length </em><code>nums1.length</code><em> such that </em><code>ans[i]</code><em> is the <strong>next greater element</strong> as described above.</em></p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums1 = [4,1,2], nums2 = [1,3,4,2]
//<strong>Output:</strong> [-1,3,-1]
//<strong>Explanation:</strong> The next greater element for each value of nums1 is as follows:
//- 4 is underlined in nums2 = [1,3,<u>4</u>,2]. There is no next greater element, so the answer is -1.
//- 1 is underlined in nums2 = [<u>1</u>,3,4,2]. The next greater element is 3.
//- 2 is underlined in nums2 = [1,3,4,<u>2</u>]. There is no next greater element, so the answer is -1.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums1 = [2,4], nums2 = [1,2,3,4]
//<strong>Output:</strong> [3,-1]
//<strong>Explanation:</strong> The next greater element for each value of nums1 is as follows:
//- 2 is underlined in nums2 = [1,<u>2</u>,3,4]. The next greater element is 3.
//- 4 is underlined in nums2 = [1,2,3,<u>4</u>]. There is no next greater element, so the answer is -1.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums1.length &lt;= nums2.length &lt;= 1000</code></li> 
// <li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>4</sup></code></li> 
// <li>All integers in <code>nums1</code> and <code>nums2</code> are <strong>unique</strong>.</li> 
// <li>All the integers of <code>nums1</code> also appear in <code>nums2</code>.</li> 
//</ul>
//
//<p>&nbsp;</p> 
//<strong>Follow up:</strong> Could you find an 
//<code>O(nums1.length + nums2.length)</code> solution?
//
//<details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 哈希表 | 单调栈</details><br>
//
//<div>👍 854, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Next Greater Element I
 *
 * @author DY
 * @date 2022-10-12 21:38:03
 */
public class P496_NextGreaterElementI {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P496_NextGreaterElementI().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> num2Greater = nextGreaterElement(nums2);
            int n = nums1.length;
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = num2Greater.get(nums1[i]);
            }
            return res;
        }

        private Map<Integer, Integer> nextGreaterElement(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>(n);
            Stack<Integer> stack = new Stack<>();
            for (int i = n - 1; i >= 0; i--) { // 从后往前遍历
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop(); // 去掉小的元素
                }
                map.put(nums[i], stack.isEmpty() ? -1 : stack.peek());
                stack.push(nums[i]);
            }
            return map;
        }

        /*public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] greaterElement = nextGreaterElement(nums2);
            int[] res = new int[nums1.length];
            Map<Integer, Integer> nums2Greater = new HashMap<>(nums2.length);
            for (int i = 0; i < nums2.length; i++) {
                nums2Greater.put(nums2[i], greaterElement[i]);
            }
            for (int i = 0; i < nums1.length; i++) {
                res[i] = nums2Greater.get(nums1[i]);
            }
            return res;
        }

        public int[] nextGreaterElement(int[] nums) {
            int n = nums.length;
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[n];
            for (int i = n - 1; i >= 0; i--) { // 倒着往栈里面放
                while (!stack.isEmpty() && nums[i] >= stack.peek()) { // 淘汰矮个子
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums[i]);
            }
            return res;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}