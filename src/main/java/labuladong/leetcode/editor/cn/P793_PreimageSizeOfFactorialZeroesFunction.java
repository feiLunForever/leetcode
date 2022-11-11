//<p>Let <code>f(x)</code> be the number of zeroes at the end of <code>x!</code>. Recall that <code>x! = 1 * 2 * 3 * ... * x</code> and by convention, <code>0! = 1</code>.</p>
//
//<ul> 
// <li>For example, <code>f(3) = 0</code> because <code>3! = 6</code> has no zeroes at the end, while <code>f(11) = 2</code> because <code>11! = 39916800</code> has two zeroes at the end.</li> 
//</ul>
//
//<p>Given an integer <code>k</code>, return the number of non-negative integers <code>x</code> have the property that <code>f(x) = k</code>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> k = 0
//<strong>Output:</strong> 5
//<strong>Explanation:</strong> 0!, 1!, 2!, 3!, and 4! end with k = 0 zeroes.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> k = 5
//<strong>Output:</strong> 0
//<strong>Explanation:</strong> There is no x such that x! ends in k = 5 zeroes.
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> k = 3
//<strong>Output:</strong> 5
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>0 &lt;= k &lt;= 10<sup>9</sup></code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>数学 | 二分查找</details><br>
//
//<div>👍 191, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Preimage Size of Factorial Zeroes Function
 *
 * @author DY
 * @date 2022-11-11 21:36:12
 */
public class P793_PreimageSizeOfFactorialZeroesFunction {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P793_PreimageSizeOfFactorialZeroesFunction().new Solution();
		System.out.println(solution.preimageSizeFZF(5));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int preimageSizeFZF(int k) {
            return (int) (rightBound(k) - leftBound(k) + 1);
        }

        private long leftBound(int target) {
            long left = 0, right = Long.MAX_VALUE;
            while (left < right) {
                long mid = left + (right - left) / 2;
                if (trailingZeroes(mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        private long rightBound(int target) {
            long left = 0, right = Long.MAX_VALUE;
            while (left < right) {
                long mid = left + (right - left) / 2;
                if (trailingZeroes(mid) > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left - 1;
        }

        private long trailingZeroes(long n) {
            long res = 0;
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