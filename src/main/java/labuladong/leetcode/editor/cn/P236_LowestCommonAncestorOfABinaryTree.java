//<p>Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.</p>
//
//<p>According to the <a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor" target="_blank">definition of LCA on Wikipedia</a>: &ldquo;The lowest common ancestor is defined between two nodes <code>p</code> and <code>q</code> as the lowest node in <code>T</code> that has both <code>p</code> and <code>q</code> as descendants (where we allow <b>a node to be a descendant of itself</b>).&rdquo;</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" />
//<pre>
//<strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//<strong>Output:</strong> 3
//<strong>Explanation:</strong> The LCA of nodes 5 and 1 is 3.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" />
//<pre>
//<strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//<strong>Output:</strong> 5
//<strong>Explanation:</strong> The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> root = [1,2], p = 1, q = 2
//<strong>Output:</strong> 1
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li>The number of nodes in the tree is in the range <code>[2, 10<sup>5</sup>]</code>.</li>
//	<li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li>
//	<li>All <code>Node.val</code> are <strong>unique</strong>.</li>
//	<li><code>p != q</code></li>
//	<li><code>p</code> and <code>q</code> will exist in the tree.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉树</details><br>
//
//<div>👍 1955, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

/**
 * Lowest Common Ancestor of a Binary Tree
 *
 * @author DY
 * @date 2022-09-13 16:40:35
 */
public class P236_LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P236_LowestCommonAncestorOfABinaryTree().new Solution();
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
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return find(root, p.val, q.val);
        }

        private TreeNode find(TreeNode root, int target1, int target2) {
            if (root == null) return null;
            if (root.val == target1 || root.val == target2) return root;
            TreeNode left = find(root.left, target1, target2);
            TreeNode right = find(root.right, target1, target2);
            if (left != null && right != null) return root;
            return left == null ? right : left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}