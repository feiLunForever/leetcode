//<p>Given the <code>root</code> of a binary tree, <em>determine if it is a valid binary search tree (BST)</em>.</p>
//
//<p>A <strong>valid BST</strong> is defined as follows:</p>
//
//<ul>
//	<li>The left subtree of a node contains only nodes with keys <strong>less than</strong> the node&#39;s key.</li>
//	<li>The right subtree of a node contains only nodes with keys <strong>greater than</strong> the node&#39;s key.</li>
//	<li>Both the left and right subtrees must also be binary search trees.</li>
//</ul>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/12/01/tree1.jpg" style="width: 302px; height: 182px;" />
//<pre>
//<strong>Input:</strong> root = [2,1,3]
//<strong>Output:</strong> true
//</pre>
//
//<p><strong>Example 2:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/12/01/tree2.jpg" style="width: 422px; height: 292px;" />
//<pre>
//<strong>Input:</strong> root = [5,1,4,null,null,3,6]
//<strong>Output:</strong> false
//<strong>Explanation:</strong> The root node&#39;s value is 5 but its right child&#39;s value is 4.
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
//	<li><code>-2<sup>31</sup> &lt;= Node.val &lt;= 2<sup>31</sup> - 1</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉搜索树 | 二叉树</details><br>
//
//<div>👍 1745, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

/**
 * Validate Binary Search Tree
 *
 * @author DY
 * @date 2022-09-08 16:09:08
 */
public class P98_ValidateBinarySearchTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P98_ValidateBinarySearchTree().new Solution();
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
        Integer preVal;

        public boolean isValidBST(TreeNode root) {
            return traverse(root);
        }

        private boolean traverse(TreeNode root) {
            if (root == null) return true;
            if (!traverse(root.left)) {
                return false;
            }
            // TODO: 2022/9/8
            if (preVal == null || root.val > preVal) {
                preVal = root.val;
            } else {
                return false;
            }
			return traverse(root.right);
		}
    }
//leetcode submit region end(Prohibit modification and deletion)

}