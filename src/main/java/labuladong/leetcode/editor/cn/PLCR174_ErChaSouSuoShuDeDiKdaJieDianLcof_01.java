/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉搜索树 | 二叉树</details><br>
 *
 * <div>👍 412, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import org.example.剑指Offer.TreeNode;

/**
 * 寻找二叉搜索树中的目标节点
 *
 * @author DY
 * @date 2023-11-06 16:56:00
 */
public class PLCR174_ErChaSouSuoShuDeDiKdaJieDianLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PLCR174_ErChaSouSuoShuDeDiKdaJieDianLcof_01().new Solution();
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
        private int k = -1, topK = -1;

        public int findTargetNode(TreeNode root, int cnt) {
            this.k = cnt;
            dfs(root);
            return topK;
        }

        private void dfs(TreeNode root) {
            if (root == null || k == 0) return;
            dfs(root.right);
            // 反中序位置（降序）
            if (--k == 0) topK = root.val;
            dfs(root.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
