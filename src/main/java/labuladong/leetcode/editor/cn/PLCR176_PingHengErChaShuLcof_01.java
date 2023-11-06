/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉树</details><br>
 *
 * <div>👍 386, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import org.example.剑指Offer.TreeNode;

/**
 * 判断是否为平衡二叉树
 *
 * @author DY
 * @date 2023-11-06 17:01:55
 */
public class PLCR176_PingHengErChaShuLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PLCR176_PingHengErChaShuLcof_01().new Solution();
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
        public boolean isBalanced(TreeNode root) {
            return dfs(root) != -1;
        }

        private int dfs(TreeNode root) {
            if (root == null) return 0;
            int left = dfs(root.left);
            if (left == -1) return -1;
            int right = dfs(root.right);
            if (right == -1) return -1;
            return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
