/**
 * <p>Design a map that allows you to do the following:</p>
 *
 * <ul>
 * <li>Maps a string key to a given value.</li>
 * <li>Returns the sum of the values that have a key with a prefix equal to a given string.</li>
 * </ul>
 *
 * <p>Implement the <code>MapSum</code> class:</p>
 *
 * <ul>
 * <li><code>MapSum()</code> Initializes the <code>MapSum</code> object.</li>
 * <li><code>void insert(String key, int val)</code> Inserts the <code>key-val</code> pair into the map. If the <code>key</code> already existed, the original <code>key-value</code> pair will be overridden to the new one.</li>
 * <li><code>int sum(string prefix)</code> Returns the sum of all the pairs' value whose <code>key</code> starts with the <code>prefix</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * <strong>Output</strong>
 * [null, null, 3, null, 5]
 *
 * <strong>Explanation</strong>
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (<u>ap</u>ple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (<u>ap</u>ple + <u>ap</u>p = 3 + 2 = 5)
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= key.length, prefix.length &lt;= 50</code></li>
 * <li><code>key</code> and <code>prefix</code> consist of only lowercase English letters.</li>
 * <li><code>1 &lt;= val &lt;= 1000</code></li>
 * <li>At most <code>50</code> calls will be made to <code>insert</code> and <code>sum</code>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>设计 | 字典树 | 哈希表 | 字符串</details><br>
 *
 * <div>👍 241, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * Map Sum Pairs
 *
 * @author DY
 * @date 2023-08-21 16:48:31
 */
public class PSix77_MapSumPairs_01 {
    public static void main(String[] args) {
        //测试代码
        MapSum solution = new PSix77_MapSumPairs_01().new MapSum();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class MapSum {

        private Trie trie;

        class Trie {
            private int size;
            private TreeNode root = null;

            class TreeNode {
                private Integer value = null;
                private TreeNode[] children = new TreeNode[26];
            }

            public void put(String key, int val) {
                root = put(root, key, 0, val);
            }

            public int sum(String prefix) {
                List<String> keys = keysWithPrefix(prefix);
                int res = 0;
                for (String key : keys) {
                    Integer value = get(key);
                    if (value != null) {
                        res += value;
                    }
                }
                return res;
            }

            private Integer get(String key) {
                TreeNode node = getNode(root, key);
                if (node != null && node.value != null) {
                    return node.value;
                }
                return null;
            }

            private TreeNode put(TreeNode node, String key, int i, int val) {
                if (node == null) {
                    node = new TreeNode();
                }
                if (i == key.length()) {
                    node.value = val;
                    return node;
                }
                char ch = key.charAt(i);
                node.children[ch - 97] = put(node.children[ch - 97], key, i + 1, val);
                return node;
            }

            private List<String> keysWithPrefix(String prefix) {
                List<String> res = new LinkedList<>();
                TreeNode node = getNode(root, prefix);
                if (node == null) return res;
                traverse(node, new StringBuilder(prefix), res);
                return res;
            }

            private TreeNode getNode(TreeNode node, String prefix) {
                TreeNode p = node;
                for (int i = 0; i < prefix.length(); i++) {
                    if (p == null) return null;
                    char ch = prefix.charAt(i);
                    p = p.children[ch - 97];
                }
                return p;
            }

            private void traverse(TreeNode node, StringBuilder trace, List<String> res) {
                if (node == null) return;
                if (node.value != null) {
                    res.add(trace.toString());
                }
                for (int i = 0; i < 26; i++) {
                    if (node.children[i] != null) {
                        trace.append((char) ('a' + i));
                        traverse(node.children[i], trace, res);
                        trace.deleteCharAt(trace.length() - 1);
                    }
                }
            }
        }

        public MapSum() {
            trie = new Trie();
        }

        public void insert(String key, int val) {
            trie.put(key, val);
        }

        public int sum(String prefix) {
            return trie.sum(prefix);
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
