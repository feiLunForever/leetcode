/**
 * <p>A <a href="https://en.wikipedia.org/wiki/Trie" target="_blank"><strong>trie</strong></a> (pronounced as "try") or <strong>prefix tree</strong> is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.</p>
 *
 * <p>Implement the Trie class:</p>
 *
 * <ul>
 * <li><code>Trie()</code> Initializes the trie object.</li>
 * <li><code>void insert(String word)</code> Inserts the string <code>word</code> into the trie.</li>
 * <li><code>boolean search(String word)</code> Returns <code>true</code> if the string <code>word</code> is in the trie (i.e., was inserted before), and <code>false</code> otherwise.</li>
 * <li><code>boolean startsWith(String prefix)</code> Returns <code>true</code> if there is a previously inserted string <code>word</code> that has the prefix <code>prefix</code>, and <code>false</code> otherwise.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * <strong>Output</strong>
 * [null, null, true, false, true, null, true]
 *
 * <strong>Explanation</strong>
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= word.length, prefix.length &lt;= 2000</code></li>
 * <li><code>word</code> and <code>prefix</code> consist only of lowercase English letters.</li>
 * <li>At most <code>3 * 10<sup>4</sup></code> calls <strong>in total</strong> will be made to <code>insert</code>, <code>search</code>, and <code>startsWith</code>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>设计 | 字典树 | 哈希表 | 字符串</details><br>
 *
 * <div>👍 1513, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Implement Trie (Prefix Tree)
 *
 * @author DY
 * @date 2023-08-21 15:43:52
 */
public class PTwo08_ImplementTriePrefixTree_01 {
    public static void main(String[] args) {
        //测试代码
        Trie solution = new PTwo08_ImplementTriePrefixTree_01().new Trie();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Trie {

        private final Object V = new Object();

        private int size;

        private TreeNode root = null;

        class TreeNode {
            private Object value = null;
            private TreeNode[] children = new TreeNode[26];
        }

        public Trie() {

        }

        public void insert(String word) {
            if(!search(word)) {
                ++size;
            }
            root = put(root,word,0);
        }

        private TreeNode put(TreeNode node, String word, int i) {
            if(node == null) {
                node = new TreeNode();
            }
            if(i == word.length()) {
                node.value = V;
                return node;
            }
            char ch = word.charAt(i);
            node.children[ch - 97] = put(node.children[ch - 97], word, i + 1);
            return node;
        }

        public boolean search(String word) {
            TreeNode node = getNode(root, word);
            return node != null && node.value != null;
        }

        private TreeNode getNode(TreeNode node, String word) {
            TreeNode p = node;
            for (int i = 0; i < word.length(); i++) {
                if(p == null) return null;
                char ch = word.charAt(i);
                p = p.children[ch - 97];
            }
            return p;
        }

        public boolean startsWith(String prefix) {
            return getNode(root, prefix) != null;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
