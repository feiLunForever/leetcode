//<p>Given a binary tree, find its minimum depth.</p>
//
//<p>The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.</p>
//
//<p><strong>Note:</strong>&nbsp;A leaf is a node with no children.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/10/12/ex_depth.jpg" style="width: 432px; height: 302px;" />
//<pre>
//<strong>Input:</strong> root = [3,9,20,null,null,15,7]
//<strong>Output:</strong> 2
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> root = [2,null,3,null,4,null,5,null,6]
//<strong>Output:</strong> 5
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>5</sup>]</code>.</li>
//	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 二叉树</details><br>
//
//<div>👍 817, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Minimum Depth of Binary Tree
 *
 * @author DY
 * @date 2022-08-11 19:17:41
 */
public class P111_MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P111_MinimumDepthOfBinaryTree().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            return bfs(root);
        }

        private int bfs(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int depth = 1; // root 本身就是一层，depth 初始化为 1
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    if (cur.left == null && cur.right == null) { // 判断是否到达终点
                        return depth;
                    }
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
                ++depth;
            }
            return depth;
        }

        /*public int minDepth(TreeNode root) {
			if (root == null) return 0;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            return bfs(queue, 1);
        }

        private int bfs(LinkedList<TreeNode> queue, int depth) {

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.removeFirst();
                    if (treeNode.right == null && treeNode.left == null) {
                        return depth;
                    }
                    if (treeNode.left != null) {
                        queue.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.add(treeNode.right);
                    }
                }
                depth++;
            }
            return depth;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}