/**
 * <p>Given two strings <code>s</code> and <code>t</code> of lengths <code>m</code> and <code>n</code> respectively, return <em>the <strong>minimum window</strong></em> <span data-keyword="substring-nonempty"><strong><em>substring</em></strong></span><em> of </em><code>s</code><em> such that every character in </em><code>t</code><em> (<strong>including duplicates</strong>) is included in the window</em>. If there is no such substring, return <em>the empty string </em><code>""</code>.</p>
 *
 * <p>The testcases will be generated such that the answer is <strong>unique</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "ADOBECODEBANC", t = "ABC"
 * <strong>Output:</strong> "BANC"
 * <strong>Explanation:</strong> The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "a", t = "a"
 * <strong>Output:</strong> "a"
 * <strong>Explanation:</strong> The entire string s is the minimum window.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "a", t = "aa"
 * <strong>Output:</strong> ""
 * <strong>Explanation:</strong> Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>m == s.length</code></li>
 * <li><code>n == t.length</code></li>
 * <li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
 * <li><code>s</code> and <code>t</code> consist of uppercase and lowercase English letters.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> Could you find an algorithm that runs in <code>O(m + n)</code> time?</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>
 *
 * <div>👍 2593, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Window Substring
 *
 * @author DY
 * @date 2023-08-08 13:51:29
 */
public class PSeven6_MinimumWindowSubstring_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSeven6_MinimumWindowSubstring_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> need = new HashMap<>(); // 记录每个字符需要的次数
            for (int i = 0; i < t.length(); i++) {
                need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
            }
            Map<Character, Integer> window = new HashMap<>(); // 记录窗口中每个字符出现的次数
            int l = 0, r = 0;
            int match = 0; // 记录每个匹配的字符个数
            int len = Integer.MAX_VALUE; // 记录匹配字符串的长度
            int start = 0;
            while (r < s.length()) {
                char ch = s.charAt(r++);
                window.put(ch, window.getOrDefault(ch, 0) + 1); // 将该字符放入窗口中
                if (need.containsKey(ch) && need.get(ch).equals(window.get(ch))) {
                    ++match;
                }
                while (match == need.size()) { // 当窗口完全包含目标字符时，调整窗口
                    if (r - l < len) { // 更新结果
                        len = r - l;
                        start = l;
                    }
                    char remove = s.charAt(l++); // 收缩窗口
                    if (need.containsKey(remove)) {
                        if (need.get(remove).equals(window.get(remove))) { // 只有该字符出现的次数一致时，才能代表之前match加过1
                            --match;
                        }
                        window.put(remove, window.getOrDefault(remove, 0) - 1);
                    }
                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
