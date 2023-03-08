/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉树</details><br>
 *
 * <div>👍 704, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import org.example.剑指Offer.TreeNode;

/**
 * 树的子结构  LCOF
 *
 * @author DY
 * @date 2023-03-08 12:48:03
 */
public class PJianZhiOffer26_ShuDeZiJieGouLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer26_ShuDeZiJieGouLcof().new Solution();
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
            // 三种情况均可
            // 1.B是否为A的子结构
            // 1.B是否为A左子树的子结构
            // 1.B是否为右左子树的子结构
            return A != null && B != null && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
        }

        /**
         * 判断B是否为A的子结构,其中B子结构的起点为A的根节点
         *
         * @param a
         * @param b
         * @return
         */
        private boolean recur(TreeNode a, TreeNode b) {
            if (b == null) return true;
            if (a == null || a.val != b.val) return false;
            return recur(a.left, b.left) && recur(a.right, b.right);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
