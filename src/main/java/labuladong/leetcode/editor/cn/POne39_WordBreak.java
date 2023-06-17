/**
 * <p>Given a string <code>s</code> and a dictionary of strings <code>wordDict</code>, return <code>true</code> if <code>s</code> can be segmented into a space-separated sequence of one or more dictionary words.</p>
 *
 * <p><strong>Note</strong> that the same word in the dictionary may be reused multiple times in the segmentation.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "leetcode", wordDict = ["leet","code"]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> Return true because "leetcode" can be segmented as "leet code".
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "applepenapple", wordDict = ["apple","pen"]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 300</code></li>
 * <li><code>1 &lt;= wordDict.length &lt;= 1000</code></li>
 * <li><code>1 &lt;= wordDict[i].length &lt;= 20</code></li>
 * <li><code>s</code> and <code>wordDict[i]</code> consist of only lowercase English letters.</li>
 * <li>All the strings of <code>wordDict</code> are <strong>unique</strong>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>字典树 | 记忆化搜索 | 数组 | 哈希表 | 字符串 | 动态规划</details><br>
 *
 * <div>👍 2165, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;

/**
 * Word Break
 *
 * @author DY
 * @date 2023-06-17 14:43:25
 */
public class POne39_WordBreak {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne39_WordBreak().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Boolean[] memo = new Boolean[s.length()];
            return dp(s, 0, new HashSet<>(wordDict), memo);
        }

        /**
         * s[i..] 能否被拼出
         *
         * @param s
         * @param i
         * @param wordDict
         * @param memo
         * @return
         */
        private boolean dp(String s, int i, HashSet<String> wordDict, Boolean[] memo) {
            if (i == s.length()) return true;
            if (memo[i] != null) return memo[i];

            for (int len = 1; i + len <= s.length(); len++) { // 遍历 s[i...]所有的前缀
                String prefix = s.substring(i, i + len);
                if (wordDict.contains(prefix)) {
                    if (dp(s, i + len, wordDict, memo)) { // 如果 s[i+len...]匹配成功
                        memo[i] = true;
                        return true;
                    }
                }
            }
            memo[i] = false; // s[i..] 无法被拼出
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
