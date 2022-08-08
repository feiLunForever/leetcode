//<p>Given the <code>root</code> of a binary tree, return <em>the length of the <strong>diameter</strong> of the tree</em>.</p>
//
//<p>The <strong>diameter</strong> of a binary tree is the <strong>length</strong> of the longest path between any two nodes in a tree. This path may or may not pass through the <code>root</code>.</p>
//
//<p>The <strong>length</strong> of a path between two nodes is represented by the number of edges between them.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/03/06/diamtree.jpg" style="width: 292px; height: 302px;" />
//<pre>
//<strong>Input:</strong> root = [1,2,3,4,5]
//<strong>Output:</strong> 3
//<strong>Explanation:</strong> 3 is the length of the path [4,2,1,3] or [5,2,1,3].
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> root = [1,2]
//<strong>Output:</strong> 1
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
//	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉树</details><br>
//
//<div>👍 1120, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

/**
 * Diameter of Binary Tree
 *
 * @author DY
 * @date 2022-08-08 16:00:32
 */
public class P543_DiameterOfBinaryTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P543_DiameterOfBinaryTree().new Solution();
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
        private int maxDiameter;

        public int diameterOfBinaryTree(TreeNode root) {
            maxDepth(root);
            return maxDiameter;
        }

        private int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int leftMaxDepth = maxDepth(root.left);
            int rightMaxDepth = maxDepth(root.right);
            int tempMaxDiameter = leftMaxDepth + rightMaxDepth;
            maxDiameter = Math.max(maxDiameter, tempMaxDiameter);

            return 1 + Math.max(leftMaxDepth, rightMaxDepth);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}