//<p>Design a data structure that supports adding new words and finding if a string matches any previously added string.</p>
//
//<p>Implement the <code>WordDictionary</code> class:</p>
//
//<ul> 
// <li><code>WordDictionary()</code>&nbsp;Initializes the object.</li> 
// <li><code>void addWord(word)</code> Adds <code>word</code> to the data structure, it can be matched later.</li> 
// <li><code>bool search(word)</code>&nbsp;Returns <code>true</code> if there is any string in the data structure that matches <code>word</code>&nbsp;or <code>false</code> otherwise. <code>word</code> may contain dots <code>'.'</code> where dots can be matched with any letter.</li> 
//</ul>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example:</strong></p>
//
//<pre>
//<strong>Input</strong>
//["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//<strong>Output</strong>
//[null,null,null,null,false,true,true,true]
//
//<strong>Explanation</strong>
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= word.length &lt;= 25</code></li> 
// <li><code>word</code> in <code>addWord</code> consists of lowercase English letters.</li> 
// <li><code>word</code> in <code>search</code> consist of <code>'.'</code> or lowercase English letters.</li> 
// <li>There will be at most <code>3</code> dots in <code>word</code> for <code>search</code> queries.</li> 
// <li>At most <code>10<sup>4</sup></code> calls will be made to <code>addWord</code> and <code>search</code>.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 设计 | 字典树 | 字符串</details><br>
//
//<div>👍 464, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Design Add and Search Words Data Structure
 *
 * @author DY
 * @date 2022-10-10 18:51:06
 */
public class P211_DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        //测试代码
        WordDictionary solution = new P211_DesignAddAndSearchWordsDataStructure().new WordDictionary();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {
        private static final int R = 26;

        private final Object PRESENT = new Object();

        private int size = 0;

        private TreeNode root = null;

        class TreeNode {
            private Object value = null;
            private TreeNode[] children = new TreeNode[R];
        }

        public boolean hasKeyWithPattern(String pattern) {
            return hasKeyWithPattern(root, pattern, 0);
        }

        private boolean hasKeyWithPattern(TreeNode node, String pattern, int i) {
            if (node == null) return false;
            if (i == pattern.length()) {
                return node.value != null;
            }
            char ch = pattern.charAt(i);
            if (ch == '.') {
                for (int j = 0; j < R; j++) {
                    if (hasKeyWithPattern(node.children[j], pattern, i + 1)) {
                        return true;
                    }
                }
            } else {
                return hasKeyWithPattern(node.children[findIndex(pattern, i)], pattern, i + 1);
            }
            return false;
        }

        public void put(String key) {
            if (!containKey(key)) {
                size++;
            }
            root = put(root, key, 0);
        }

        private TreeNode put(TreeNode node, String key, int i) {
            if (node == null) {
                node = new TreeNode();
            }
            if (i == key.length()) {
                node.value = PRESENT;
                return node;
            }
            int index = findIndex(key, i);
            node.children[index] = put(node.children[index], key, i + 1);
            return node;
        }

        private boolean containKey(String key) {
            return get(key) != null;
        }

        public Object get(String key) {
            TreeNode node = getNode(root, key);
            if (node == null || node.value == null) {
                return null;
            }
            return node.value;
        }

        private TreeNode getNode(TreeNode node, String key) {
            TreeNode p = node;
            for (int i = 0; i < key.length(); i++) {
                if (p == null) return null;
                int index = findIndex(key, i);
                p = p.children[index];
            }
            return p;
        }

        private int findIndex(String key, int i) {
            return key.charAt(i) - 97;
        }

        public WordDictionary() {

        }

        public void addWord(String word) {
            put(word);
        }

        public boolean search(String word) {
            return hasKeyWithPattern(word);
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