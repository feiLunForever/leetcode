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
 * <div>👍 507, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Design Add and Search Words Data Structure
 *
 * @author DY
 * @date 2023-06-15 16:12:26
 */
public class PTwo11_DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        //测试代码
        WordDictionary solution = new PTwo11_DesignAddAndSearchWordsDataStructure().new WordDictionary();
        solution.addWord("at");
        solution.addWord("and");
        solution.addWord("an");
        solution.addWord("add");
        System.out.println(solution.search("a"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {

        private TrieNode root = null;
        private final Object V = new Object();

        class TrieNode {
            private Object value = null;
            private final TrieNode[] children = new TrieNode[26];
        }

        public WordDictionary() {

        }

        public void addWord(String word) {
            root = put(root, word, V, 0);
        }

        private TrieNode put(TrieNode node, String key, Object v, int i) {
            if (node == null) {
                node = new TrieNode();
            }
            if (i == key.length()) {
                node.value = v;
                return node;
            }
            char ch = key.charAt(i);
            node.children[ch - 97] = put(node.children[ch - 97], key, v, i + 1);
            return node;
        }

        public boolean search(String word) {
            return hasKeyWithPattern(root, word, 0);
        }

        /**
         * 从 node 节点开始匹配 pattern[i..]，返回是否成功匹配
         *
         * @param node
         * @param key
         * @param i
         * @return
         */
        private boolean hasKeyWithPattern(TrieNode node, String key, int i) {
            if (node == null) return false;
            if (i == key.length()) return node.value != null;
            char ch = key.charAt(i);
            if (ch == '.') {
                for (int j = 0; j < 26; j++) {
                    if (hasKeyWithPattern(node.children[j], key, i + 1)) {
                        return true;
                    }
                }
            } else {
                return hasKeyWithPattern(node.children[ch - 97], key, i + 1);
            }
            return false;
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
