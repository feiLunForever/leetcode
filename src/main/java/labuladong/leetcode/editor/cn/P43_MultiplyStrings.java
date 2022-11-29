//<p>Given two non-negative integers <code>num1</code> and <code>num2</code> represented as strings, return the product of <code>num1</code> and <code>num2</code>, also represented as a string.</p>
//
//<p><strong>Note:</strong>&nbsp;You must not use any built-in BigInteger library or convert the inputs to integer directly.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p> 
//<pre><strong>Input:</strong> num1 = "2", num2 = "3"
//<strong>Output:</strong> "6"
//</pre>
//<p><strong class="example">Example 2:</strong></p> 
//<pre><strong>Input:</strong> num1 = "123", num2 = "456"
//<strong>Output:</strong> "56088"
//</pre> 
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= num1.length, num2.length &lt;= 200</code></li> 
// <li><code>num1</code> and <code>num2</code> consist of digits only.</li> 
// <li>Both <code>num1</code> and <code>num2</code>&nbsp;do not contain any leading zero, except the number <code>0</code> itself.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>数学 | 字符串 | 模拟</details><br>
//
//<div>👍 1104, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Multiply Strings
 *
 * @author DY
 * @date 2022-11-29 17:32:01
 */
public class P43_MultiplyStrings {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P43_MultiplyStrings().new Solution();
        System.out.println(solution.multiply("2", "3"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            int n = num1.length(), m = num2.length();
            int[] res = new int[m + n];

            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); // 乘积
                    int p1 = i + j, p2 = i + j + 1; // 个位数，十位数索引位置
                    mul += res[p2]; // 加上尾数
                    res[p2] = mul % 10;
                    res[p1] += mul / 10;
                }
            }
            int i = 0;
            while (i < res.length && res[i] == 0) { // 去除前面为0的字符
                ++i;
            }
            StringBuilder sb = new StringBuilder();
            for (; i < res.length; i++) {
                sb.append((char) (res[i] + '0'));
            }
            return sb.length() > 0 ? sb.toString() : "0";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}