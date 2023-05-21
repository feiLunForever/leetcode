/**
 * <p>Given the <code>root</code> of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.</p>
 *
 * <p>As a reminder, a <em>binary search tree</em> is a tree that satisfies these constraints:</p>
 *
 * <ul>
 * <li>The left subtree of a node contains only nodes with keys <strong>less than</strong> the node's key.</li>
 * <li>The right subtree of a node contains only nodes with keys <strong>greater than</strong> the node's key.</li>
 * <li>Both the left and right subtrees must also be binary search trees.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2019/05/02/tree.png" style="width: 500px; height: 341px;" />
 * <pre>
 * <strong>Input:</strong> root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * <strong>Output:</strong> [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [0,null,1]
 * <strong>Output:</strong> [1,null,1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
 * <li><code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
 * <li>All the values in the tree are <strong>unique</strong>.</li>
 * <li><code>root</code> is guaranteed to be a valid binary search tree.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Note:</strong> This question is the same as 1038: <a href="https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/" target="_blank">https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/</a></p>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉搜索树 | 二叉树</details><br>
 *
 * <div>👍 895, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

/**
 * Convert BST to Greater Tree
 *
 * @author DY
 * @date 2023-05-21 22:35:06
 */
public class PFive38_ConvertBstToGreaterTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFive38_ConvertBstToGreaterTree().new Solution();
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
        private int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            traverse(root);
            return root;
        }

        private void traverse(TreeNode root) {
            if (root == null) return;
            traverse(root.right);
            sum += root.val;
            root.val = sum;
            traverse(root.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
