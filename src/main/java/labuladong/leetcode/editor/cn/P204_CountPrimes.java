//<p>Given an integer <code>n</code>, return <em>the number of prime numbers that are strictly less than</em> <code>n</code>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> n = 10
//<strong>Output:</strong> 4
//<strong>Explanation:</strong> There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> n = 0
//<strong>Output:</strong> 0
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> n = 1
//<strong>Output:</strong> 0
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>0 &lt;= n &lt;= 5 * 10<sup>6</sup></code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 数学 | 枚举 | 数论</details><br>
//
//<div>👍 972, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Count Primes
 *
 * @author DY
 * @date 2022-11-12 17:23:14
 */
public class P204_CountPrimes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P204_CountPrimes().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            boolean[] isPrime = new boolean[n];
            Arrays.fill(isPrime, true);
            for (int i = 2; i * i < n; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime[i]) {
                    ++count;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}