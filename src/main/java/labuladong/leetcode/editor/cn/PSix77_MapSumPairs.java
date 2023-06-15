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
 * <div>👍 235, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * Map Sum Pairs
 *
 * @author DY
 * @date 2023-06-15 16:57:35
 */
public class PSix77_MapSumPairs {
    public static void main(String[] args) {
        //测试代码
        MapSum solution = new PSix77_MapSumPairs().new MapSum();
        solution.insert("apple",3);
        System.out.println(solution.sum("ap"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class MapSum {

        private TrieNode root = null;

        class TrieNode {
            private Integer value = null;
            private final TrieNode[] children = new TrieNode[26];
        }

        public MapSum() {

        }

        public void insert(String key, int val) {
            root = put(root, key, val, 0);
        }

        private TrieNode put(TrieNode node, String key, int val, int i) {
            if (node == null) {
                node = new TrieNode();
            }
            if (i == key.length()) {
                node.value = val;
                return node;
            }
            char ch = key.charAt(i);
            node.children[ch - 97] = put(node.children[ch - 97], key, val, i + 1);
            return node;
        }

        public int sum(String prefix) {
            List<String> list = keysWithPrefix(prefix);
            int res = 0;
            for (String it : list) {
                Integer value = get(it);
                if (value != null) {
                    res += value;
                }
            }
            return res;
        }

        private List<String> keysWithPrefix(String prefix) {
            List<String> res = new LinkedList<>();
            TrieNode node = getNode(root, prefix); // 先找到该node
            if (node == null) return res;
            traverse(node, new StringBuilder(prefix), res);
            return res;
        }

        private void traverse(TrieNode node, StringBuilder path, List<String> res) {
            if (node == null) return;
            if (node.value != null) {
                res.add(path.toString());
            }
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    path.append((char) ('a' + i));
                    traverse(node.children[i], path, res);
                    path.deleteCharAt(path.length() - 1);
                }
            }
        }

        private Integer get(String key) {
            TrieNode node = getNode(root, key);
            if (node != null && node.value != null) {
                return node.value;
            }
            return null;
        }

        private TrieNode getNode(TrieNode node, String key) {
            TrieNode p = node;
            for (int i = 0; i < key.length(); i++) {
                if (p == null) return null;
                char ch = key.charAt(i);
                p = p.children[ch - 97];
            }
            return p;
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
