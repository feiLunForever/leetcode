//<p>Given an integer array <code>nums</code>, handle multiple queries of the following type:</p>
//
//<ol>
//	<li>Calculate the <strong>sum</strong> of the elements of <code>nums</code> between indices <code>left</code> and <code>right</code> <strong>inclusive</strong> where <code>left &lt;= right</code>.</li>
//</ol>
//
//<p>Implement the <code>NumArray</code> class:</p>
//
//<ul>
//	<li><code>NumArray(int[] nums)</code> Initializes the object with the integer array <code>nums</code>.</li>
//	<li><code>int sumRange(int left, int right)</code> Returns the <strong>sum</strong> of the elements of <code>nums</code> between indices <code>left</code> and <code>right</code> <strong>inclusive</strong> (i.e. <code>nums[left] + nums[left + 1] + ... + nums[right]</code>).</li>
//</ul>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input</strong>
//[&quot;NumArray&quot;, &quot;sumRange&quot;, &quot;sumRange&quot;, &quot;sumRange&quot;]
//[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//<strong>Output</strong>
//[null, 1, -1, -3]
//
//<strong>Explanation</strong>
//NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
//numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
//numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
//	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
//	<li><code>0 &lt;= left &lt;= right &lt; nums.length</code></li>
//	<li>At most <code>10<sup>4</sup></code> calls will be made to <code>sumRange</code>.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>设计 | 数组 | 前缀和</details><br>
//
//<div>👍 493, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Range Sum Query - Immutable
 *
 * @author DY
 * @date 2022-08-25 09:40:44
 */
public class P303_RangeSumQueryImmutable {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray array = new NumArray(nums);
        System.out.println(array.sumRange(2, 5));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    static class NumArray {
        private int[] nums; //[a,b)
        private int[] cache;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.cache = new int[nums.length + 1];
            // cache[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                cache[i] = cache[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return cache[right + 1] - cache[left];
        }

    }


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}