/**
 * <p>You are given the <code>root</code> of a binary search tree (BST) and an integer <code>val</code>.</p>
 *
 * <p>Find the node in the BST that the node's value equals <code>val</code> and return the subtree rooted with that node. If such a node does not exist, return <code>null</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/12/tree1.jpg" style="width: 422px; height: 302px;" />
 * <pre>
 * <strong>Input:</strong> root = [4,2,7,1,3], val = 2
 * <strong>Output:</strong> [2,1,3]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/12/tree2.jpg" style="width: 422px; height: 302px;" />
 * <pre>
 * <strong>Input:</strong> root = [4,2,7,1,3], val = 5
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[1, 5000]</code>.</li>
 * <li><code>1 &lt;= Node.val &lt;= 10<sup>7</sup></code></li>
 * <li><code>root</code> is a binary search tree.</li>
 * <li><code>1 &lt;= val &lt;= 10<sup>7</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 二叉搜索树 | 二叉树</details><br>
 *
 * <div>👍 398, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

/**
 * Search in a Binary Search Tree
 *
 * @author DY
 * @date 2023-05-22 17:10:19
 */
public class PSeven00_SearchInABinarySearchTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSeven00_SearchInABinarySearchTree().new Solution();
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
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) return null;
            if (root.val == val) return root;
            if (root.val < val) return searchBST(root.right, val);
            return searchBST(root.left, val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
