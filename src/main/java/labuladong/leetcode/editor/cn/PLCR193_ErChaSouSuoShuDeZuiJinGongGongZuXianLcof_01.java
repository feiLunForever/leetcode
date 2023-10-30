/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉搜索树 | 二叉树</details><br>
 *
 * <div>👍 339, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import org.example.剑指Offer.TreeNode;

/**
 * 求二叉搜索树的最近公共祖先
 *
 * @author DY
 * @date 2023-10-30 19:42:37
 */
public class PLCR193_ErChaSouSuoShuDeZuiJinGongGongZuXianLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PLCR193_ErChaSouSuoShuDeZuiJinGongGongZuXianLcof_01().new Solution();
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
            if (root == null) return null;
            if (p.val < q.val) return find(root, p.val, q.val);
            return find(root, q.val, p.val);
        }

        private TreeNode find(TreeNode root, int min, int max) {
            if (root == null) return null;
            if (root.val < min) {
                return find(root.right, min, max);
            } else if (root.val > max) {
                return find(root.left, min, max);
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
