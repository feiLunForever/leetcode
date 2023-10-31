/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉树</details><br>
 *
 * <div>👍 802, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import org.example.剑指Offer.TreeNode;

/**
 * 子结构判断
 *
 * @author DY
 * @date 2023-10-31 11:36:58
 */
public class PLCR143_ShuDeZiJieGouLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PLCR143_ShuDeZiJieGouLcof_01().new Solution();
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
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) return false;
            return isSubRootStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean isSubRootStructure(TreeNode a, TreeNode b) {
            if (b == null) return true;
            if (a == null || a.val != b.val) return false;
            return isSubRootStructure(a.left, b.left) && isSubRootStructure(a.right, b.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
