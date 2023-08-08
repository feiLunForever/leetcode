/**
 * <p>Given two strings <code>s</code> and <code>p</code>, return <em>an array of all the start indices of </em><code>p</code><em>'s anagrams in </em><code>s</code>. You may return the answer in <strong>any order</strong>.</p>
 *
 * <p>An <strong>Anagram</strong> is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "cbaebabacd", p = "abc"
 * <strong>Output:</strong> [0,6]
 * <strong>Explanation:</strong>
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "abab", p = "ab"
 * <strong>Output:</strong> [0,1,2]
 * <strong>Explanation:</strong>
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length, p.length &lt;= 3 * 10<sup>4</sup></code></li>
 * <li><code>s</code> and <code>p</code> consist of lowercase English letters.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>
 *
 * <div>👍 1238, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Find All Anagrams in a String
 *
 * @author DY
 * @date 2023-08-08 14:28:05
 */
public class PFour38_FindAllAnagramsInAString_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFour38_FindAllAnagramsInAString_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            Map<Character, Integer> need = new HashMap<>();
            for (int i = 0; i < p.length(); i++) {
                need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
            }
            Map<Character, Integer> window = new HashMap<>();
            int l = 0, r = 0;
            int match = 0;
            List<Integer> res = new LinkedList<>();
            while (r < s.length()) {
                char ch = s.charAt(r++);
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (need.containsKey(ch) && need.get(ch).equals(window.get(ch))) {
                    ++match;
                }
                while (r - l >= p.length()) {
                    if (match == need.size()) {
                        res.add(l);
                    }
                    char remove = s.charAt(l++);
                    if (need.containsKey(remove) && need.get(remove).equals(window.get(remove))) {
                        --match;
                    }
                    window.put(remove, window.getOrDefault(remove, 0) - 1);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
