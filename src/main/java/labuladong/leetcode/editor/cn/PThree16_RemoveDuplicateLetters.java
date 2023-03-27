/**
 * <p>Given a string <code>s</code>, remove duplicate letters so that every letter appears once and only once. You must make sure your result is <span data-keyword="lexicographically-smaller-string"><strong>the smallest in lexicographical order</strong></span> among all possible results.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "bcabc"
 * <strong>Output:</strong> "abc"
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "cbacdcbc"
 * <strong>Output:</strong> "acdb"
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>s</code> consists of lowercase English letters.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Note:</strong> This question is the same as 1081: <a href="https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/" target="_blank">https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/</a></p>
 *
 * <details><summary><strong>Related Topics</strong></summary>栈 | 贪心 | 字符串 | 单调栈</details><br>
 *
 * <div>👍 910, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Stack;

/**
 * Remove Duplicate Letters
 *
 * @author DY
 * @date 2023-03-27 21:49:05
 */
public class PThree16_RemoveDuplicateLetters {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PThree16_RemoveDuplicateLetters().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            Stack<Character> stack = new Stack<>();
            int[] count = new int[256];
            boolean[] inStack = new boolean[256];
            for (int i = 0; i < s.length(); i++) {
                ++count[s.charAt(i)];
            }
            for (int i = 0; i < s.length(); i++) {
                Character ch = s.charAt(i);
                --count[ch];
                if (inStack[ch]) continue;
                while (!stack.isEmpty() && stack.peek() > ch) {
                    if (count[stack.peek()] == 0) break; // 若之后不存在栈顶元素了，则停止 pop
                    inStack[stack.pop()] = false; // 若之后还有，则可以 pop
                }
                stack.push(ch);
                inStack[ch] = true;
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
