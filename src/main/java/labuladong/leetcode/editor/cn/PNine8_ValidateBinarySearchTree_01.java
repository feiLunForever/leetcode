/**
 * <p>Given the <code>root</code> of a binary tree, <em>determine if it is a valid binary search tree (BST)</em>.</p>
 *
 * <p>A <strong>valid BST</strong> is defined as follows:</p>
 *
 * <ul>
 * <li>The left <span data-keyword="subtree">subtree</span> of a node contains only nodes with keys <strong>less than</strong> the node's key.</li>
 * <li>The right subtree of a node contains only nodes with keys <strong>greater than</strong> the node's key.</li>
 * <li>Both the left and right subtrees must also be binary search trees.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/12/01/tree1.jpg" style="width: 302px; height: 182px;" />
 * <pre>
 * <strong>Input:</strong> root = [2,1,3]
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/12/01/tree2.jpg" style="width: 422px; height: 292px;" />
 * <pre>
 * <strong>Input:</strong> root = [5,1,4,null,null,3,6]
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> The root node's value is 5 but its right child's value is 4.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
 * <li><code>-2<sup>31</sup> &lt;= Node.val &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉搜索树 | 二叉树</details><br>
 *
 * <div>👍 2195, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

/**
 * Validate Binary Search Tree
 *
 * @author DY
 * @date 2023-10-27 11:27:22
 */
public class PNine8_ValidateBinarySearchTree_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PNine8_ValidateBinarySearchTree_01().new Solution();
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
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
            if (root == null) return true;
            if (min != null && root.val <= min.val) return false;
            if (max != null && root.val >= max.val) return false;

            return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
