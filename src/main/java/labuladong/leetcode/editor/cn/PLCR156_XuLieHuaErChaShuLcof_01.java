/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 设计 | 字符串 | 二叉树</details><br>
 *
 * <div>👍 432, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import org.example.剑指Offer.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 序列化与反序列化二叉树
 *
 * @author DY
 * @date 2023-11-06 16:41:38
 */
public class PLCR156_XuLieHuaErChaShuLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Codec solution = new PLCR156_XuLieHuaErChaShuLcof_01().new Codec();
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
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#").append(",");
                return;
            }
            serialize(root.left, sb);
            serialize(root.right, sb);
            sb.append(root.val).append(",");
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserialize(nodes);
        }

        private TreeNode deserialize(LinkedList<String> nodes) {
            if (nodes.isEmpty()) return null;
            String rootVal = nodes.removeLast();
            if (rootVal.equals("#")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(rootVal));

            root.right = deserialize(nodes);
            root.left = deserialize(nodes);

            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
