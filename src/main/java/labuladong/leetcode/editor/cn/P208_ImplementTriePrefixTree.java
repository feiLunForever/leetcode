//<p>A <a href="https://en.wikipedia.org/wiki/Trie" target="_blank"><strong>trie</strong></a> (pronounced as "try") or <strong>prefix tree</strong> is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.</p>
//
//<p>Implement the Trie class:</p>
//
//<ul> 
// <li><code>Trie()</code> Initializes the trie object.</li> 
// <li><code>void insert(String word)</code> Inserts the string <code>word</code> into the trie.</li> 
// <li><code>boolean search(String word)</code> Returns <code>true</code> if the string <code>word</code> is in the trie (i.e., was inserted before), and <code>false</code> otherwise.</li> 
// <li><code>boolean startsWith(String prefix)</code> Returns <code>true</code> if there is a previously inserted string <code>word</code> that has the prefix <code>prefix</code>, and <code>false</code> otherwise.</li> 
//</ul>
//
//<p>&nbsp;</p> 
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input</strong>
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//<strong>Output</strong>
//[null, null, true, false, true, null, true]
//
//<strong>Explanation</strong>
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // return True
//trie.search("app");     // return False
//trie.startsWith("app"); // return True
//trie.insert("app");
//trie.search("app");     // return True
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= word.length, prefix.length &lt;= 2000</code></li> 
// <li><code>word</code> and <code>prefix</code> consist only of lowercase English letters.</li> 
// <li>At most <code>3 * 10<sup>4</sup></code> calls <strong>in total</strong> will be made to <code>insert</code>, <code>search</code>, and <code>startsWith</code>.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>设计 | 字典树 | 哈希表 | 字符串</details><br>
//
//<div>👍 1319, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Implement Trie (Prefix Tree)
 *
 * @author DY
 * @date 2022-10-10 16:28:11
 */
public class P208_ImplementTriePrefixTree {
    public static void main(String[] args) {
        //测试代码
        Trie trie = new P208_ImplementTriePrefixTree().new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        private static final int R = 26;

        private int size = 0;

        private TrieNode root = null;

        private final Object PRESENT = new Object();

        private class TrieNode {
            private Object value = null;
            private final TrieNode[] children = new TrieNode[R];
        }

        public Trie() {

        }

        public void insert(String word) {
            if (!containsKey(word)) {
                size++;
            }
            root = put(root, word, 0);
        }

        private TrieNode put(TrieNode node, String word, int i) {
            if (node == null) {
                node = new TrieNode();
            }
            if (i == word.length()) {
                node.value = PRESENT;
                return node;
            }
            int index = findIndex(word, i);
            node.children[index] = put(node.children[index], word, i + 1);
            return node;
        }

        private int findIndex(String word, int i) {
            return word.charAt(i) - 97;
        }

        public boolean search(String word) {
            return containsKey(word);
        }

        public boolean startsWith(String prefix) {
            return getNode(prefix) != null;
        }

        private boolean containsKey(String word) {
            return get(word) != null;
        }

        private Object get(String word) {
            TrieNode node = getNode(word);
            if (node == null || node.value == null) {
                return null;
            }
            return node.value;
        }

        private TrieNode getNode(String word) {
            TrieNode p = root;
            for(int i = 0; i < word.length();i++){
                int index = findIndex(word, i);
                if (p == null) return null;
                p = p.children[index];
            }
            return p;
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