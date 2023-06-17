/**
 * <p>Given a string <code>s</code> and a dictionary of strings <code>wordDict</code>, add spaces in <code>s</code> to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in <strong>any order</strong>.</p>
 *
 * <p><strong>Note</strong> that the same word in the dictionary may be reused multiple times in the segmentation.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * <strong>Output:</strong> ["cats and dog","cat sand dog"]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * <strong>Output:</strong> ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * <strong>Explanation:</strong> Note that you are allowed to reuse a dictionary word.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 20</code></li>
 * <li><code>1 &lt;= wordDict.length &lt;= 1000</code></li>
 * <li><code>1 &lt;= wordDict[i].length &lt;= 10</code></li>
 * <li><code>s</code> and <code>wordDict[i]</code> consist of only lowercase English letters.</li>
 * <li>All the strings of <code>wordDict</code> are <strong>unique</strong>.</li>
 * <li>Input is generated in a way that the length of the answer doesn't exceed&nbsp;10<sup>5</sup>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>字典树 | 记忆化搜索 | 数组 | 哈希表 | 字符串 | 动态规划 | 回溯</details><br>
 *
 * <div>👍 694, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Word Break II
 *
 * @author DY
 * @date 2023-06-17 14:52:27
 */
public class POne40_WordBreakIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne40_WordBreakIi().new Solution();

        System.out.println(solution.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            List<String>[] memo = new LinkedList[s.length()];
            return dp(s, 0, new HashSet<>(wordDict), memo);
        }

        /**
         * 返回用 wordDict 构成 s[i..] 的所有可能
         *
         * @param s
         * @param i
         * @param wordDict
         * @param memo
         * @return
         */
        private List<String> dp(String s, int i, HashSet<String> wordDict, List<String>[] memo) {
            List<String> res = new LinkedList<>();
            if (i == s.length()) {
                res.add("");
                return res;
            }
            if (memo[i] != null) return memo[i];

            for (int len = 1; len + i <= s.length(); len++) { // 遍历 s[i..] 的所有前缀
                String prefix = s.substring(i, i + len);
                if (wordDict.contains(prefix)) {
                    List<String> subProblem = dp(s, i + len, wordDict, memo);
                    for (String sub : subProblem) {
                        if (sub.isEmpty()) { // 防止多余的空格
                            res.add(prefix);
                        } else {
                            res.add(prefix + " " + sub);
                        }
                    }
                }
            }
            memo[i] = res;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
