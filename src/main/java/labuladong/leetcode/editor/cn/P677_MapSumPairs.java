//<p>Design a map that allows you to do the following:</p>
//
//<ul> 
// <li>Maps a string key to a given value.</li> 
// <li>Returns the sum of the values that have a key with a prefix equal to a given string.</li> 
//</ul>
//
//<p>Implement the <code>MapSum</code> class:</p>
//
//<ul> 
// <li><code>MapSum()</code> Initializes the <code>MapSum</code> object.</li> 
// <li><code>void insert(String key, int val)</code> Inserts the <code>key-val</code> pair into the map. If the <code>key</code> already existed, the original <code>key-value</code> pair will be overridden to the new one.</li> 
// <li><code>int sum(string prefix)</code> Returns the sum of all the pairs' value whose <code>key</code> starts with the <code>prefix</code>.</li> 
//</ul>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input</strong>
//["MapSum", "insert", "sum", "insert", "sum"]
//[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
//<strong>Output</strong>
//[null, null, 3, null, 5]
//
//<strong>Explanation</strong>
//MapSum mapSum = new MapSum();
//mapSum.insert("apple", 3);  
//mapSum.sum("ap");           // return 3 (<u>ap</u>ple = 3)
//mapSum.insert("app", 2);    
//mapSum.sum("ap");           // return 5 (<u>ap</u>ple + <u>ap</u>p = 3 + 2 = 5)
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= key.length, prefix.length &lt;= 50</code></li> 
// <li><code>key</code> and <code>prefix</code> consist of only lowercase English letters.</li> 
// <li><code>1 &lt;= val &lt;= 1000</code></li> 
// <li>At most <code>50</code> calls will be made to <code>insert</code> and <code>sum</code>.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>设计 | 字典树 | 哈希表 | 字符串</details><br>
//
//<div>👍 221, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * Map Sum Pairs
 *
 * @author DY
 * @date 2022-10-11 19:04:10
 */
public class P677_MapSumPairs {
    public static void main(String[] args) {
        //测试代码
        MapSum solution = new P677_MapSumPairs().new MapSum();
        solution.insert("apple", 3);
        System.out.println(solution.sum("ap"));
        solution.insert("app", 2);
        System.out.println(solution.sum("ap"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class MapSum {

        private final Trie<Integer> trie;

        public MapSum() {
            trie = new Trie<>();
        }

        public void insert(String key, int val) {
            trie.put(key, val);
        }

        public int sum(String prefix) {
            List<String> list = trie.keysWithPrefix(prefix);
            int res = 0;
            for (String key : list) {
                Integer value = trie.get(key);
                if (value != null) {
                    res += value;
                }
            }
            return res;
        }

        class Trie<V> {
            private static final int R = 26;

            private int size = 0;

            private TreeNode<V> root = null;

            class TreeNode<V> {
                private V value = null;

                private TreeNode<V>[] children = new TreeNode[R];
            }

            public void put(String key, V value) {
                if (!containsKey(key)) {
                    size++;
                }
                root = put(root, key, value, 0);
            }

            private TreeNode<V> put(TreeNode<V> node, String key, V value, int i) {
                if (node == null) {
                    node = new TreeNode<>();
                }
                if (i == key.length()) {
                    node.value = value;
                    return node;
                }
                int index = findIndex(key, i);
                node.children[index] = put(node.children[index], key, value, i + 1);
                return node;
            }

            public V get(String key) {
                TreeNode<V> node = getNode(root, key);
                if (node == null || node.value == null) {
                    return null;
                }
                return node.value;
            }

            public List<String> keysWithPrefix(String prefix) {
                List<String> res = new LinkedList<>();
                TreeNode<V> node = getNode(root, prefix);
                if (node == null) {
                    return res;
                }
                traverse(node, new StringBuilder(prefix), res);
                return res;
            }

            private void traverse(TreeNode<V> node, StringBuilder path, List<String> res) {
                if (node == null) return;
                if (node.value != null) {
                    res.add(path.toString());
                }
                for (int i = 0; i < R; i++) {
                    path.append((char) ('a' + i));
                    if (node.children[i] != null) {
                        traverse(node.children[i], path, res);
                    }
                    path.deleteCharAt(path.length() - 1);
                }
            }

            private boolean containsKey(String key) {
                return get(key) != null;
            }

            private TreeNode<V> getNode(TreeNode<V> node, String key) {
                TreeNode<V> p = node;
                for (int i = 0; i < key.length(); i++) {
                    if (p == null) return null;
                    p = p.children[findIndex(key, i)];
                }
                return p;
            }

            private int findIndex(String key, int i) {
                return key.charAt(i) - 97;
            }
        }
    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}