//<p>Given an integer <code>n</code>, return <em>the number of trailing zeroes in </em><code>n!</code>.</p>
//
//<p>Note that <code>n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1</code>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> n = 3
//<strong>Output:</strong> 0
//<strong>Explanation:</strong> 3! = 6, no trailing zero.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> n = 5
//<strong>Output:</strong> 1
//<strong>Explanation:</strong> 5! = 120, one trailing zero.
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> n = 0
//<strong>Output:</strong> 0
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>0 &lt;= n &lt;= 10<sup>4</sup></code></li> 
//</ul>
//
//<p>&nbsp;</p> 
//<p><strong>Follow up:</strong> Could you write a solution that works in logarithmic time complexity?</p>
//
//<details><summary><strong>Related Topics</strong></summary>数学</details><br>
//
//<div>👍 734, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Factorial Trailing Zeroes
 *
 * @author DY
 * @date 2022-11-11 21:28:13
 */
public class P172_FactorialTrailingZeroes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P172_FactorialTrailingZeroes().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            int res = 0;
            long divisor = 5;
            while (divisor <= n) {
                res += n / divisor;
                divisor *= 5;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}