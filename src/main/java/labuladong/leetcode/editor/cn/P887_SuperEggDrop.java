//<p>You are given <code>k</code> identical eggs and you have access to a building with <code>n</code> floors labeled from <code>1</code> to <code>n</code>.</p>
//
//<p>You know that there exists a floor <code>f</code> where <code>0 &lt;= f &lt;= n</code> such that any egg dropped at a floor <strong>higher</strong> than <code>f</code> will <strong>break</strong>, and any egg dropped <strong>at or below</strong> floor <code>f</code> will <strong>not break</strong>.</p>
//
//<p>Each move, you may take an unbroken egg and drop it from any floor <code>x</code> (where <code>1 &lt;= x &lt;= n</code>). If the egg breaks, you can no longer use it. However, if the egg does not break, you may <strong>reuse</strong> it in future moves.</p>
//
//<p>Return <em>the <strong>minimum number of moves</strong> that you need to determine <strong>with certainty</strong> what the value of </em><code>f</code> is.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> k = 1, n = 2
//<strong>Output:</strong> 2
//<strong>Explanation: </strong>
//Drop the egg from floor 1. If it breaks, we know that f = 0.
//Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1.
//If it does not break, then we know f = 2.
//Hence, we need at minimum 2 moves to determine with certainty what the value of f is.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> k = 2, n = 6
//<strong>Output:</strong> 3
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> k = 3, n = 14
//<strong>Output:</strong> 4
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= k &lt;= 100</code></li> 
// <li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>数学 | 二分查找 | 动态规划</details><br>
//
//<div>👍 886, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Super Egg Drop
 *
 * @author DY
 * @date 2022-10-27 09:50:11
 */
public class P887_SuperEggDrop {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P887_SuperEggDrop().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int superEggDrop(int k, int n) {
            int[][] cache = new int[k + 1][n + 1];
            for (int[] row : cache) {
                Arrays.fill(row, -9999);
            }
            return dp(k, n, cache);
        }

        private int dp(int k, int n, int[][] cache) {
            if (k == 1) return n;
            if (n == 0) return 0;
            if (cache[k][n] != -9999) {
                return cache[k][n];
            }
            int res = Integer.MAX_VALUE;
//            for (int i = 1; i <= n; i++) {
//                res = Math.min(
//                        res, Math.max(
//                                dp(k - 1, i - 1, cache),
//                                dp(k, n - i, cache)
//                        ) + 1
//                );
//            }
            int l = 1, r = n;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int broken = dp(k - 1, mid - 1, cache);
                int un_broken = dp(k, n - mid, cache);
                if (broken > un_broken) {
                    r = mid - 1;
                    res = Math.min(res, broken + 1);
                } else {
                    l = mid + 1;
                    res = Math.min(res, un_broken + 1);
                }

            }
            cache[k][n] = res;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}