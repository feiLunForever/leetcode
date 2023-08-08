/**
 * <p>Given two strings <code>s1</code> and <code>s2</code>, return <code>true</code><em> if </em><code>s2</code><em> contains a permutation of </em><code>s1</code><em>, or </em><code>false</code><em> otherwise</em>.</p>
 *
 * <p>In other words, return <code>true</code> if one of <code>s1</code>'s permutations is the substring of <code>s2</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s1 = "ab", s2 = "eidbaooo"
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> s2 contains one permutation of s1 ("ba").
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s1 = "ab", s2 = "eidboaoo"
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s1.length, s2.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>s1</code> and <code>s2</code> consist of lowercase English letters.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>哈希表 | 双指针 | 字符串 | 滑动窗口</details><br>
 *
 * <div>👍 944, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Permutation in String
 *
 * @author DY
 * @date 2023-08-08 14:14:52
 */
public class PFive67_PermutationInString_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFive67_PermutationInString_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, Integer> need = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
            }
            Map<Character, Integer> window = new HashMap<>();
            int l = 0, r = 0;
            int match = 0;
            while (r < s2.length()) {
                char ch = s2.charAt(r++);
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (need.containsKey(ch) && need.get(ch).equals(window.get(ch))) {
                    ++match;
                }
                while (r - l >= s1.length()) {
                    if (match == need.size()) return true;
                    char remove = s2.charAt(l++);
                    if (need.containsKey(remove) && need.get(remove).equals(window.get(remove))) {
                        --match;
                    }
                    window.put(remove, window.getOrDefault(remove, 0) - 1);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
