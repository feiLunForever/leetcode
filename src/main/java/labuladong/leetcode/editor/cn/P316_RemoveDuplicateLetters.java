//<p>Given a string <code>s</code>, remove duplicate letters so that every letter appears once and only once. You must make sure your result is <strong>the smallest in lexicographical order</strong> among all possible results.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = &quot;bcabc&quot;
//<strong>Output:</strong> &quot;abc&quot;
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = &quot;cbacdcbc&quot;
//<strong>Output:</strong> &quot;acdb&quot;
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
//	<li><code>s</code> consists of lowercase English letters.</li>
//</ul>
//
//<p>&nbsp;</p>
//<p><strong>Note:</strong> This question is the same as 1081: <a href="https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/" target="_blank">https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/</a></p>
//<details><summary><strong>Related Topics</strong></summary>栈 | 贪心 | 字符串 | 单调栈</details><br>
//
//<div>👍 801, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * Remove Duplicate Letters
 *
 * @author DY
 * @date 2022-09-01 15:51:21
 */
public class P316_RemoveDuplicateLetters {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P316_RemoveDuplicateLetters().new Solution();
        System.out.println(solution.removeDuplicateLetters("ecbacba"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            LinkedList<Character> stack = new LinkedList<>();
            int[] count = new int[256]; // 用于统计字母出现的字数
            boolean[] inStack = new boolean[256]; // 统计是否放入栈中
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)]++;
            }
            for (Character ch : s.toCharArray()) {
                count[ch]--; // 每遍历过一个字符，都将对应的计数减一
                if (inStack[ch]) continue;
                // 栈顶元素比当前元素大，且后面还有栈顶的重复元素，需要将栈顶弹出
                while (!stack.isEmpty() && stack.peek() > ch && count[stack.peek()] > 0) {
                    inStack[stack.pop()] = false; // 出栈，并标记
                }
                stack.offerFirst(ch);
                inStack[ch] = true;
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pollLast());
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}