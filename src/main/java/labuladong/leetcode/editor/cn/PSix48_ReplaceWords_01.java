/**
 * <p>In English, we have a concept called <strong>root</strong>, which can be followed by some other word to form another longer word - let's call this word <strong>successor</strong>. For example, when the <strong>root</strong> <code>"an"</code> is followed by the <strong>successor</strong> word <code>"other"</code>, we can form a new word <code>"another"</code>.</p>
 *
 * <p>Given a <code>dictionary</code> consisting of many <strong>roots</strong> and a <code>sentence</code> consisting of words separated by spaces, replace all the <strong>successors</strong> in the sentence with the <strong>root</strong> forming it. If a <strong>successor</strong> can be replaced by more than one <strong>root</strong>, replace it with the <strong>root</strong> that has <strong>the shortest length</strong>.</p>
 *
 * <p>Return <em>the <code>sentence</code></em> after the replacement.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * <strong>Output:</strong> "the cat was rat by the bat"
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * <strong>Output:</strong> "a a b c"
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= dictionary.length &lt;= 1000</code></li>
 * <li><code>1 &lt;= dictionary[i].length &lt;= 100</code></li>
 * <li><code>dictionary[i]</code> consists of only lower-case letters.</li>
 * <li><code>1 &lt;= sentence.length &lt;= 10<sup>6</sup></code></li>
 * <li><code>sentence</code> consists of only lower-case letters and spaces.</li>
 * <li>The number of words in <code>sentence</code> is in the range <code>[1, 1000]</code></li>
 * <li>The length of each word in <code>sentence</code> is in the range <code>[1, 1000]</code></li>
 * <li>Every two consecutive words in <code>sentence</code> will be separated by exactly one space.</li>
 * <li><code>sentence</code> does not have leading or trailing spaces.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>字典树 | 数组 | 哈希表 | 字符串</details><br>
 *
 * <div>👍 297, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.List;

/**
 * Replace Words
 *
 * @author DY
 * @date 2023-08-21 15:55:22
 */
public class PSix48_ReplaceWords_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSix48_ReplaceWords_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Trie {
            private final Object V = new Object();
            private int size;
            private TreeNode root = null;

            class TreeNode {
                private Object value = null;
                private TreeNode[] children = new TreeNode[26];
            }

            public void put(String key) {
                root = put(root, key, 0);
            }

            public String shortestPrefixOf(String key) {
                TreeNode p = root;
                for (int i = 0; i < key.length(); i++) {
                    if (p == null) return null;
                    if (p.value != null) {
                        return key.substring(0, i);
                    }
                    char ch = key.charAt(i);
                    p = p.children[ch - 97];
                }
                if (p != null && p.value != null) {
                    return key;
                }
                return null;
            }

            private TreeNode put(TreeNode node, String key, int i) {
                if (node == null) {
                    node = new TreeNode();
                }
                if (i == key.length()) {
                    node.value = V;
                    return node;
                }
                char ch = key.charAt(i);
                node.children[ch - 97] = put(node.children[ch - 97], key, i + 1);
                return node;
            }
        }

        public String replaceWords(List<String> dictionary, String sentence) {
            Trie trie = new Trie();
            for (String dict : dictionary) {
                trie.put(dict);
            }
            String[] words = sentence.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                String prefix = trie.shortestPrefixOf(word);
                if (prefix != null) {
                    sb.append(prefix);
                } else {
                    sb.append(word);
                }
                sb.append(" ");
            }
            return sb.substring(0, sb.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
