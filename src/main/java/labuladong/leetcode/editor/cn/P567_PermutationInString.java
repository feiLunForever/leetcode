//<p>Given two strings <code>s1</code> and <code>s2</code>, return <code>true</code><em> if </em><code>s2</code><em> contains a permutation of </em><code>s1</code><em>, or </em><code>false</code><em> otherwise</em>.</p>
//
//<p>In other words, return <code>true</code> if one of <code>s1</code>&#39;s permutations is the substring of <code>s2</code>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> s1 = &quot;ab&quot;, s2 = &quot;eidbaooo&quot;
//<strong>Output:</strong> true
//<strong>Explanation:</strong> s2 contains one permutation of s1 (&quot;ba&quot;).
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> s1 = &quot;ab&quot;, s2 = &quot;eidboaoo&quot;
//<strong>Output:</strong> false
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= s1.length, s2.length &lt;= 10<sup>4</sup></code></li>
//	<li><code>s1</code> and <code>s2</code> consist of lowercase English letters.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>哈希表 | 双指针 | 字符串 | 滑动窗口</details><br>
//
//<div>👍 740, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.HashMap;

/**
 * Permutation in String
 *
 * @author DY
 * @date 2022-08-15 16:54:13
 */
public class P567_PermutationInString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P567_PermutationInString().new Solution();
		System.out.println(solution.checkInclusion("abcdxabcde", "abcdxabcde"));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            HashMap<Character, Integer> need = new HashMap<>(s1.length());
            for (Character ch : s1.toCharArray()) {
                need.put(ch, need.getOrDefault(ch, 0) + 1);
            }
            HashMap<Character, Integer> windows = new HashMap<>();
            int left = 0, right = 0;
            int valid = 0;
            while (right < s2.length()) {
                char ch = s2.charAt(right);
                right++;
                windows.put(ch, windows.getOrDefault(ch, 0) + 1);
                if (need.containsKey(ch) && need.get(ch).equals(windows.get(ch))) {
                    valid++;
                }
                while (right - left >= s1.length()) {
                    if (valid == need.size()) {
                        return true;
                    }
                    Character remove = s2.charAt(left);
                    left++;
                    if (need.containsKey(remove)) {
                        if (need.get(remove).equals(windows.get(remove))) {
                            valid--;
                        }
                        windows.put(remove, windows.get(remove) - 1);
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}