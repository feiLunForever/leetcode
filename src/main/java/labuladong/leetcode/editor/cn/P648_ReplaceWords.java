//<p>In English, we have a concept called <strong>root</strong>, which can be followed by some other word to form another longer word - let's call this word <strong>successor</strong>. For example, when the <strong>root</strong> <code>"an"</code> is followed by the <strong>successor</strong> word <code>"other"</code>, we can form a new word <code>"another"</code>.</p>
//
//<p>Given a <code>dictionary</code> consisting of many <strong>roots</strong> and a <code>sentence</code> consisting of words separated by spaces, replace all the <strong>successors</strong> in the sentence with the <strong>root</strong> forming it. If a <strong>successor</strong> can be replaced by more than one <strong>root</strong>, replace it with the <strong>root</strong> that has <strong>the shortest length</strong>.</p>
//
//<p>Return <em>the <code>sentence</code></em> after the replacement.</p>
//
//<p>&nbsp;</p> 
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
//<strong>Output:</strong> "the cat was rat by the bat"
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
//<strong>Output:</strong> "a a b c"
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= dictionary.length &lt;= 1000</code></li> 
// <li><code>1 &lt;= dictionary[i].length &lt;= 100</code></li> 
// <li><code>dictionary[i]</code> consists of only lower-case letters.</li> 
// <li><code>1 &lt;= sentence.length &lt;= 10<sup>6</sup></code></li> 
// <li><code>sentence</code> consists of only lower-case letters and spaces.</li> 
// <li>The number of words in <code>sentence</code> is in the range <code>[1, 1000]</code></li> 
// <li>The length of each word in <code>sentence</code> is in the range <code>[1, 1000]</code></li> 
// <li>Every two consecutive words in <code>sentence</code> will be separated by exactly one space.</li> 
// <li><code>sentence</code> does not have leading or trailing spaces.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>字典树 | 数组 | 哈希表 | 字符串</details><br>
//
//<div>👍 260, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.List;

/**
 * Replace Words
 *
 * @author DY
 * @date 2022-10-10 17:37:46
 */
public class P648_ReplaceWords {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P648_ReplaceWords().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceWords(List<String> dictionary, String sentence) {
            Trie trie = new Trie();
            for (String dict : dictionary) {
                trie.put(dict);
            }
            StringBuilder sb = new StringBuilder();
            String[] words = sentence.split(" ");
            for (String word : words) {
                String prefix = trie.shortestPrefixOf(word);
                if (prefix != null && !prefix.isEmpty()) {
                    sb.append(prefix);
                } else {
                    sb.append(word);
                }
                sb.append(" ");
            }
            return sb.substring(0, sb.length() - 1);
        }

        class Trie {
            private final Object PRESENT = new Object();

            private static final int R = 26;

            private int size = 0;

            private TrieNode root = null;

            class TrieNode {
                private Object value = null;
                private TrieNode[] children = new TrieNode[R];
            }

            public void put(String key) {
                if (!containsKey(key)) {
                    size++;
                }
                root = put(root, key, 0);
            }

            private TrieNode put(TrieNode node, String key, int i) {
                if (node == null) {
                    node = new TrieNode();
                }
                if (i == key.length()) {
                    node.value = PRESENT;
                    return node;
                }
                int index = findIndex(key, i);
                node.children[index] = put(node.children[index], key, i + 1);
                return node;
            }

            public String shortestPrefixOf(String query) {
                TrieNode p = root;
                for (int i = 0; i < query.length(); i++) {
                    if (p == null) return null;
                    if (p.value != null) {
                        return query.substring(0, i);
                    }
                    p = p.children[findIndex(query, i)];
                }
                if (p != null && p.value != null) {
                    return query;
                }
                return "";
            }

            private TrieNode getNode(TrieNode node, String word) {
                TrieNode p = node;
                for (int i = 0; i < word.length(); i++) {
                    if (p == null) return null;
                    int index = findIndex(word, i);
                    p = p.children[index];
                }
                return p;
            }

            private boolean containsKey(String key) {
                return get(key) != null;
            }

            public Object get(String key) {
                TrieNode node = getNode(root, key);
                if (node == null || node.value == null) {
                    return null;
                }
                return node.value;
            }

            private int findIndex(String word, int i) {
                return word.charAt(i) - 97;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}