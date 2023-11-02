/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 二叉树</details><br>
 *
 * <div>👍 476, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import org.example.剑指Offer.TreeNode;

/**
 * 判断对称二叉树
 *
 * @author DY
 * @date 2023-11-02 11:19:33
 */
public class PLCR145_DuiChengDeErChaShuLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PLCR145_DuiChengDeErChaShuLcof_01().new Solution();
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
        public boolean checkSymmetricTree(TreeNode root) {
            if (root == null) return true;
            return checkSymmetricTree(root.left, root.right);
        }

        private boolean checkSymmetricTree(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null || left.val != right.val) return false;
            return checkSymmetricTree(left.left, right.right) && checkSymmetricTree(left.right, right.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
