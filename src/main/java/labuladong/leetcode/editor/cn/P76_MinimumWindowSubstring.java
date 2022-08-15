//<p>Given two strings <code>s</code> and <code>t</code> of lengths <code>m</code> and <code>n</code> respectively, return <em>the <strong>minimum window substring</strong> of </em><code>s</code><em> such that every character in </em><code>t</code><em> (<strong>including duplicates</strong>) is included in the window. If there is no such substring</em><em>, return the empty string </em><code>&quot;&quot;</code><em>.</em></p>
//
//<p>The testcases will be generated such that the answer is <strong>unique</strong>.</p>
//
//<p>A <strong>substring</strong> is a contiguous sequence of characters within the string.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = &quot;ADOBECODEBANC&quot;, t = &quot;ABC&quot;
//<strong>Output:</strong> &quot;BANC&quot;
//<strong>Explanation:</strong> The minimum window substring &quot;BANC&quot; includes &#39;A&#39;, &#39;B&#39;, and &#39;C&#39; from string t.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = &quot;a&quot;, t = &quot;a&quot;
//<strong>Output:</strong> &quot;a&quot;
//<strong>Explanation:</strong> The entire string s is the minimum window.
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = &quot;a&quot;, t = &quot;aa&quot;
//<strong>Output:</strong> &quot;&quot;
//<strong>Explanation:</strong> Both &#39;a&#39;s from t must be included in the window.
//Since the largest window of s only has one &#39;a&#39;, return empty string.
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>m == s.length</code></li>
//	<li><code>n == t.length</code></li>
//	<li><code>1 &lt;= m, n&nbsp;&lt;= 10<sup>5</sup></code></li>
//	<li><code>s</code> and <code>t</code> consist of uppercase and lowercase English letters.</li>
//</ul>
//
//<p>&nbsp;</p>
//<strong>Follow up:</strong> Could you find an algorithm that runs in <code>O(m + n)</code> time?<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>
//
//<div>👍 2068, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.HashMap;

/**
 * Minimum Window Substring
 *
 * @author DY
 * @date 2022-08-15 15:11:44
 */
public class P76_MinimumWindowSubstring {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P76_MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(solution.minWindow("a", "aa"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> need = new HashMap<>(t.length());
            for (Character ch : t.toCharArray()) {
                need.put(ch, need.getOrDefault(ch, 0) + 1);
            }
            HashMap<Character, Integer> windows = new HashMap<>();
            int left = 0, right = 0;
            int valid = 0;
            int start = 0, length = Integer.MAX_VALUE;
            while (right < s.length()) {
                char ch = s.charAt(right);
                right++;
                windows.put(ch, windows.getOrDefault(ch, 0) + 1);
                if (need.containsKey(ch) && need.get(ch).equals(windows.get(ch))) {
                    valid++;
                }
                while (valid == need.size()) {
                    if (right - left < length) {
                        length = right - left;
                        start = left;
                    }
                    char removeCh = s.charAt(left);
                    left++;
                    if (need.containsKey(removeCh)) {
                        if (need.get(removeCh).equals(windows.get(removeCh))) {
							valid--;
						}
						windows.put(removeCh, windows.get(removeCh) - 1);
					}
                }
            }

            return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}