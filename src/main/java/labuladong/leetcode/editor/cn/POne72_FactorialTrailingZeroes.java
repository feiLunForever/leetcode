/**
 * <p>Given an integer <code>n</code>, return <em>the number of trailing zeroes in </em><code>n!</code>.</p>
 *
 * <p>Note that <code>n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 3
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> 3! = 6, no trailing zero.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 5
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> 5! = 120, one trailing zero.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 0
 * <strong>Output:</strong> 0
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= n &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> Could you write a solution that works in logarithmic time complexity?</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数学</details><br>
 *
 * <div>👍 766, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Factorial Trailing Zeroes
 *
 * @author DY
 * @date 2023-06-25 14:06:27
 */
public class POne72_FactorialTrailingZeroes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne72_FactorialTrailingZeroes().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            int res = 0;
            for (int d = n; d / 5 > 0; d = d / 5) {
                res += d / 5;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
