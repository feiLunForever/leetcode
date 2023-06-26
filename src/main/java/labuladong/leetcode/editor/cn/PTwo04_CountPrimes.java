/**
 * <p>Given an integer <code>n</code>, return <em>the number of prime numbers that are strictly less than</em> <code>n</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 10
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 0
 * <strong>Output:</strong> 0
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 1
 * <strong>Output:</strong> 0
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= n &lt;= 5 * 10<sup>6</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 数学 | 枚举 | 数论</details><br>
 *
 * <div>👍 1068, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Count Primes
 *
 * @author DY
 * @date 2023-06-26 16:15:17
 */
public class PTwo04_CountPrimes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PTwo04_CountPrimes().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            int res = 0;
            boolean[] primes = new boolean[n];
            Arrays.fill(primes, true);
            for (int i = 2; i * i < n; i++) {
                if (primes[i]) {
                    for (int j = i * i; j < n; j += i) {
                        primes[j] = false;
                    }
                }
            }
            for (int i = 2; i < n; i++) {
                if (primes[i]) ++res;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
