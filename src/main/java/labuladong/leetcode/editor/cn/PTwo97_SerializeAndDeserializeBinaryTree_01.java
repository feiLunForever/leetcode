/**
 * <p>Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.</p>
 *
 * <p>Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.</p>
 *
 * <p><strong>Clarification:</strong> The input/output format is the same as <a href="https://support.leetcode.com/hc/en-us/articles/360011883654-What-does-1-null-2-3-mean-in-binary-tree-representation-" target="_blank">how LeetCode serializes a binary tree</a>. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/serdeser.jpg" style="width: 442px; height: 324px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,3,null,null,4,5]
 * <strong>Output:</strong> [1,2,3,null,null,4,5]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = []
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
 * <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 设计 | 字符串 | 二叉树</details><br>
 *
 * <div>👍 1176, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Serialize and Deserialize Binary Tree
 *
 * @author DY
 * @date 2023-10-26 15:14:08
 */
public class PTwo97_SerializeAndDeserializeBinaryTree_01 {
    public static void main(String[] args) {
        //测试代码
        Codec solution = new PTwo97_SerializeAndDeserializeBinaryTree_01().new Codec();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "#";
            String left = serialize(root.left);
            String right = serialize(root.right);

            return left + "," + right + "," + root.val;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserialize(nodes);
        }

        private TreeNode deserialize(LinkedList<String> nodes) {
            if(nodes.isEmpty()) return null;
            String last = nodes.removeLast();
            if("#".equals(last)) return null;
            TreeNode root = new TreeNode(Integer.parseInt(last));

            root.right = deserialize(nodes);
            root.left = deserialize(nodes);

            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
