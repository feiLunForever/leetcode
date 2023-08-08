/**
 * <p>Given a string <code>s</code>, find the length of the <strong>longest</strong> <span data-keyword="substring-nonempty"><strong>substring</strong></span> without repeating characters.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "abcabcbb"
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The answer is "abc", with the length of 3.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "bbbbb"
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The answer is "b", with the length of 1.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "pwwkew"
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
 * <li><code>s</code> consists of English letters, digits, symbols and spaces.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>
 *
 * <div>👍 9449, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters
 *
 * @author DY
 * @date 2023-08-08 15:23:19
 */
public class PThree_LongestSubstringWithoutRepeatingCharacters_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PThree_LongestSubstringWithoutRepeatingCharacters_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> window = new HashMap<>();
            int l = 0, r = 0;
            int res = 0;
            while (r < s.length()) {
                char ch = s.charAt(r++);
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                while (window.get(ch) > 1) {
                    char remove = s.charAt(l++);
                    window.put(remove, window.get(remove) - 1);
                }
                res = Math.max(res, r - l);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
