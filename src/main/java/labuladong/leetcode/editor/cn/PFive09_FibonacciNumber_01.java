/**
 * <p>The <b>Fibonacci numbers</b>, commonly denoted <code>F(n)</code> form a sequence, called the <b>Fibonacci sequence</b>, such that each number is the sum of the two preceding ones, starting from <code>0</code> and <code>1</code>. That is,</p>
 *
 * <pre>
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n &gt; 1.
 * </pre>
 *
 * <p>Given <code>n</code>, calculate <code>F(n)</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 2
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> F(2) = F(1) + F(0) = 1 + 0 = 1.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 3
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> F(3) = F(2) + F(1) = 1 + 1 = 2.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 4
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> F(4) = F(3) + F(2) = 2 + 1 = 3.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= n &lt;= 30</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>递归 | 记忆化搜索 | 数学 | 动态规划</details><br>
 *
 * <div>👍 667, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Fibonacci Number
 *
 * @author DY
 * @date 2023-07-23 16:08:48
 */
public class PFive09_FibonacciNumber_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFive09_FibonacciNumber_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            if (n == 0) return 0;
//            int[] dp = new int[n + 1];
            int dp_0 = 0;
            int dp_1 = 1;
			int dp_i = 1;
            for (int i = 2; i <= n; i++) {
                dp_i = dp_0 + dp_1;
                dp_0 = dp_1;
                dp_1 = dp_i;
            }
            return dp_i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
