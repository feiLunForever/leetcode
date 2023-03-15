/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 设计 | 字符串 | 二叉树</details><br>
 *
 * <div>👍 381, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import org.example.剑指Offer.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 序列化二叉树  LCOF
 *
 * @author DY
 * @date 2023-03-15 12:17:13
 */
public class PJianZhiOffer37_XuLieHuaErChaShuLcof {
    public static void main(String[] args) {
        //测试代码
        Codec solution = new PJianZhiOffer37_XuLieHuaErChaShuLcof().new Codec();
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
        private static final String SEP = ",";
        private static final String NULL = "#";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preOrder(root, sb);
            return sb.toString();
        }

        private void preOrder(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }
            sb.append(root.val).append(SEP);
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(SEP)));
            return deserialize(nodes);
        }

        private TreeNode deserialize(LinkedList<String> nodes) {
            if (nodes.isEmpty()) return null;
            String root = nodes.removeFirst(); // 前序遍历，最左节点是根节点
            if (root.equals(NULL)) return null;
            TreeNode node = new TreeNode(Integer.parseInt(root));
            node.left = deserialize(nodes);
            node.right = deserialize(nodes);
            return node;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
