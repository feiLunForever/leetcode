/**
 * <p>Let <code>f(x)</code> be the number of zeroes at the end of <code>x!</code>. Recall that <code>x! = 1 * 2 * 3 * ... * x</code> and by convention, <code>0! = 1</code>.</p>
 *
 * <ul>
 * <li>For example, <code>f(3) = 0</code> because <code>3! = 6</code> has no zeroes at the end, while <code>f(11) = 2</code> because <code>11! = 39916800</code> has two zeroes at the end.</li>
 * </ul>
 *
 * <p>Given an integer <code>k</code>, return the number of non-negative integers <code>x</code> have the property that <code>f(x) = k</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> k = 0
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> 0!, 1!, 2!, 3!, and 4! end with k = 0 zeroes.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> k = 5
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> There is no x such that x! ends in k = 5 zeroes.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> k = 3
 * <strong>Output:</strong> 5
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= k &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数学 | 二分查找</details><br>
 *
 * <div>👍 206, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Preimage Size of Factorial Zeroes Function
 *
 * @author DY
 * @date 2023-06-25 14:36:49
 */
public class PSeven93_PreimageSizeOfFactorialZeroesFunction {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSeven93_PreimageSizeOfFactorialZeroesFunction().new Solution();
		System.out.println(solution.preimageSizeFZF(1000000000));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int preimageSizeFZF(int k) {
            return (int) (rightBound(k) - leftBound(k) + 1);
        }

        private long leftBound(int target) {
            long left = 0, right = Long.MAX_VALUE;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                long zeros = countZeros(mid);
                if (zeros < target) {
                    left = mid + 1;
                } else if (zeros > target) {
                    right = mid - 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        private long rightBound(int target) {
			long left = 0, right = Long.MAX_VALUE;
			while (left <= right) {
				long mid = left + (right - left) / 2;
				long zeros = countZeros(mid);
				if (zeros < target) {
					left = mid + 1;
				} else if (zeros > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			return right;
        }

        private long countZeros(long n) {
            long res = 0;
            for (long d = n; d / 5 > 0; d = d / 5) {
                res += d / 5;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
