/**
 * <p>Write a function that takes&nbsp;the binary representation of an unsigned integer and returns the number of '1' bits it has (also known as the <a href="http://en.wikipedia.org/wiki/Hamming_weight" target="_blank">Hamming weight</a>).</p>
 *
 * <p><strong>Note:</strong></p>
 *
 * <ul>
 * <li>Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.</li>
 * <li>In Java, the compiler represents the signed integers using <a href="https://en.wikipedia.org/wiki/Two%27s_complement" target="_blank">2's complement notation</a>. Therefore, in <strong class="example">Example 3</strong>, the input represents the signed integer. <code>-3</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 00000000000000000000000000001011
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The input binary string <strong>00000000000000000000000000001011</strong> has a total of three '1' bits.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 00000000000000000000000010000000
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The input binary string <strong>00000000000000000000000010000000</strong> has a total of one '1' bit.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 11111111111111111111111111111101
 * <strong>Output:</strong> 31
 * <strong>Explanation:</strong> The input binary string <strong>11111111111111111111111111111101</strong> has a total of thirty one '1' bits.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The input must be a <strong>binary string</strong> of length <code>32</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong> If this function is called many times, how would you optimize it?
 *
 * <details><summary><strong>Related Topics</strong></summary>位运算 | 分治</details><br>
 *
 * <div>👍 589, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Number of 1 Bits
 *
 * @author DY
 * @date 2023-06-25 13:45:03
 */
public class POne91_NumberOf1Bits {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne91_NumberOf1Bits().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;
            while (n != 0) {
                n = (n & n - 1);
                ++res;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
