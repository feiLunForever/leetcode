/**
 * <p>Design a data structure that supports adding new words and finding if a string matches any previously added string.</p>
 *
 * <p>Implement the <code>WordDictionary</code> class:</p>
 *
 * <ul>
 * <li><code>WordDictionary()</code>&nbsp;Initializes the object.</li>
 * <li><code>void addWord(word)</code> Adds <code>word</code> to the data structure, it can be matched later.</li>
 * <li><code>bool search(word)</code>&nbsp;Returns <code>true</code> if there is any string in the data structure that matches <code>word</code>&nbsp;or <code>false</code> otherwise. <code>word</code> may contain dots <code>'.'</code> where dots can be matched with any letter.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * <strong>Output</strong>
 * [null,null,null,null,false,true,true,true]
 *
 * <strong>Explanation</strong>
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= word.length &lt;= 25</code></li>
 * <li><code>word</code> in <code>addWord</code> consists of lowercase English letters.</li>
 * <li><code>word</code> in <code>search</code> consist of <code>'.'</code> or lowercase English letters.</li>
 * <li>There will be at most <code>2</code> dots in <code>word</code> for <code>search</code> queries.</li>
 * <li>At most <code>10<sup>4</sup></code> calls will be made to <code>addWord</code> and <code>search</code>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 设计 | 字典树 | 字符串</details><br>
 *
 * <div>👍 517, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Design Add and Search Words Data Structure
 *
 * @author DY
 * @date 2023-08-21 16:36:04
 */
public class PTwo11_DesignAddAndSearchWordsDataStructure_01 {
    public static void main(String[] args) {
        //测试代码
        WordDictionary solution = new PTwo11_DesignAddAndSearchWordsDataStructure_01().new WordDictionary();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {

        private Trie trie;

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

            private boolean hasKeyWithPattern(String pattern) {
                return hasKeyWithPattern(pattern, root, 0);
            }

            private boolean hasKeyWithPattern(String pattern, TreeNode node, int i) {
                if (node == null) return false;
                if (i == pattern.length()) return node.value != null;
                char ch = pattern.charAt(i);
                if (ch == '.') {
                    for (int j = 0; j < 26; j++) {
                        if (hasKeyWithPattern(pattern, node.children[j], i + 1)) {
                            return true;
                        }
                    }
                } else {
                    return hasKeyWithPattern(pattern, node.children[ch - 97], i + 1);
                }
                return false;
            }
        }

        public WordDictionary() {
            trie = new Trie();
        }

        public void addWord(String word) {
            trie.put(word);
        }

        public boolean search(String word) {
            return trie.hasKeyWithPattern(word);
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
