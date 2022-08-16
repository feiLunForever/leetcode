//<p>Given two strings <code>s</code> and <code>p</code>, return <em>an array of all the start indices of </em><code>p</code><em>&#39;s anagrams in </em><code>s</code>. You may return the answer in <strong>any order</strong>.</p>
//
//<p>An <strong>Anagram</strong> is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = &quot;cbaebabacd&quot;, p = &quot;abc&quot;
//<strong>Output:</strong> [0,6]
//<strong>Explanation:</strong>
//The substring with start index = 0 is &quot;cba&quot;, which is an anagram of &quot;abc&quot;.
//The substring with start index = 6 is &quot;bac&quot;, which is an anagram of &quot;abc&quot;.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> s = &quot;abab&quot;, p = &quot;ab&quot;
//<strong>Output:</strong> [0,1,2]
//<strong>Explanation:</strong>
//The substring with start index = 0 is &quot;ab&quot;, which is an anagram of &quot;ab&quot;.
//The substring with start index = 1 is &quot;ba&quot;, which is an anagram of &quot;ab&quot;.
//The substring with start index = 2 is &quot;ab&quot;, which is an anagram of &quot;ab&quot;.
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= s.length, p.length &lt;= 3 * 10<sup>4</sup></code></li>
//	<li><code>s</code> and <code>p</code> consist of lowercase English letters.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>
//
//<div>👍 974, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Find All Anagrams in a String
 *
 * @author DY
 * @date 2022-08-15 19:05:23
 */
public class P438_FindAllAnagramsInAString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P438_FindAllAnagramsInAString().new Solution();
		System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            HashMap<Character, Integer> need = new HashMap<>(p.length());
            HashMap<Character, Integer> windows = new HashMap<>();
            for (Character ch : p.toCharArray()) {
                need.put(ch, need.getOrDefault(ch, 0) + 1);
            }
            int left = 0, right = 0;
            int valid = 0;
            List<Integer> res = new LinkedList<>();
            while (right < s.length()) {
                char ch = s.charAt(right);
                right++;
                windows.put(ch, windows.getOrDefault(ch, 0) + 1);
                if (need.containsKey(ch) && need.get(ch).equals(windows.get(ch))) {
                    valid++;
                }
                while (right - left > need.size()) {
                    if (valid == need.size()) {
                        res.add(left);
                    }
                    Character remove = s.charAt(left);
                    left++;
                    if(need.containsKey(remove)){
                        if (need.get(remove).equals(windows.get(remove))) {
                            valid--;
                        }
                        windows.put(remove, windows.get(remove) - 1);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}