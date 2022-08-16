//<p>Given a string <code>s</code>, find the length of the <strong>longest substring</strong> without repeating characters.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = &quot;abcabcbb&quot;
//<strong>Output:</strong> 3
//<strong>Explanation:</strong> The answer is &quot;abc&quot;, with the length of 3.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = &quot;bbbbb&quot;
//<strong>Output:</strong> 1
//<strong>Explanation:</strong> The answer is &quot;b&quot;, with the length of 1.
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = &quot;pwwkew&quot;
//<strong>Output:</strong> 3
//<strong>Explanation:</strong> The answer is &quot;wke&quot;, with the length of 3.
//Notice that the answer must be a substring, &quot;pwke&quot; is a subsequence and not a substring.
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
//	<li><code>s</code> consists of English letters, digits, symbols and spaces.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>
//
//<div>👍 8003, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.HashMap;

/**
 * Longest Substring Without Repeating Characters
 *
 * @author DY
 * @date 2022-08-16 10:36:24
 */
public class P3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
		System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> windows = new HashMap<>();
            int left = 0, right = 0;
            int max = 0;
            while (right < s.length()) {
                char ch = s.charAt(right);
                right++;
                windows.put(ch, windows.getOrDefault(ch, 0) + 1);
                while (windows.get(ch) > 1) {
                    Character remove = s.charAt(left);
                    left++;
                    windows.put(remove, windows.get(remove) - 1);
                }
                max = Math.max(max, right - left);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}