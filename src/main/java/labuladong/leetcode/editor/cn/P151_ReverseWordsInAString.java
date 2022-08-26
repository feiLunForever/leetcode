//<p>Given an input string <code>s</code>, reverse the order of the <strong>words</strong>.</p>
//
//<p>A <strong>word</strong> is defined as a sequence of non-space characters. The <strong>words</strong> in <code>s</code> will be separated by at least one space.</p>
//
//<p>Return <em>a string of the words in reverse order concatenated by a single space.</em></p>
//
//<p><b>Note</b> that <code>s</code> may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = &quot;the sky is blue&quot;
//<strong>Output:</strong> &quot;blue is sky the&quot;
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = &quot;  hello world  &quot;
//<strong>Output:</strong> &quot;world hello&quot;
//<strong>Explanation:</strong> Your reversed string should not contain leading or trailing spaces.
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = &quot;a good   example&quot;
//<strong>Output:</strong> &quot;example good a&quot;
//<strong>Explanation:</strong> You need to reduce multiple spaces between two words to a single space in the reversed string.
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
//	<li><code>s</code> contains English letters (upper-case and lower-case), digits, and spaces <code>&#39; &#39;</code>.</li>
//	<li>There is <strong>at least one</strong> word in <code>s</code>.</li>
//</ul>
//
//<p>&nbsp;</p>
//<p><b data-stringify-type="bold">Follow-up:&nbsp;</b>If the string data type is mutable in your language, can&nbsp;you solve it&nbsp;<b data-stringify-type="bold">in-place</b>&nbsp;with&nbsp;<code data-stringify-type="code">O(1)</code>&nbsp;extra space?</p>
//<details><summary><strong>Related Topics</strong></summary>双指针 | 字符串</details><br>
//
//<div>👍 635, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Reverse Words in a String
 *
 * @author DY
 * @date 2022-08-26 14:59:34
 */
public class P151_ReverseWordsInAString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P151_ReverseWordsInAString().new Solution();
        System.out.println(solution.reverseWords("F R  I   E    N     D      S      "));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            // 清洗并翻转每个字母
            StringBuilder sb = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c != ' ') { // 单词直接加
                    sb.append(c);
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') { // 去掉首空格和中间多余空格
                    sb.append(' ');
                }
            }
            if (sb.charAt(sb.length() - 1) == ' ') { // 去掉尾空格
                sb.deleteCharAt(sb.length() - 1);
            }
            char[] chars = sb.toString().toCharArray();
            int start;
            for (int i = 0; i < chars.length; i++) {
                start = i;
                while (i < chars.length && chars[i] != ' ') i++;
                reverse(chars, start, i - 1);
            }
            return new String(chars);
        }


        private void reverse(char[] charArray, int left, int right) {
            while (left < right) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}