/**
 * <p>Given two non-negative integers <code>num1</code> and <code>num2</code> represented as strings, return the product of <code>num1</code> and <code>num2</code>, also represented as a string.</p>
 *
 * <p><strong>Note:</strong>&nbsp;You must not use any built-in BigInteger library or convert the inputs to integer directly.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> num1 = "2", num2 = "3"
 * <strong>Output:</strong> "6"
 * </pre>
 * <p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> num1 = "123", num2 = "456"
 * <strong>Output:</strong> "56088"
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= num1.length, num2.length &lt;= 200</code></li>
 * <li><code>num1</code> and <code>num2</code> consist of digits only.</li>
 * <li>Both <code>num1</code> and <code>num2</code>&nbsp;do not contain any leading zero, except the number <code>0</code> itself.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数学 | 字符串 | 模拟</details><br>
 *
 * <div>👍 1223, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Multiply Strings
 *
 * @author DY
 * @date 2023-06-28 15:45:17
 */
public class PFour3_MultiplyStrings {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFour3_MultiplyStrings().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            int m = num1.length(), n = num2.length();
            int[] num = new int[m + n];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    int p1 = i + j, p2 = i + j + 1;
                    int sum = num[p2] + mul;
                    num[p2] = sum % 10;
                    num[p1] += sum / 10;
                }
            }
            int i = 0;
            while (i < m + n && num[i] == 0) {
                ++i;
            }
            StringBuilder sb = new StringBuilder();
            for (; i < m + n; i++) {
                sb.append(num[i]);
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
