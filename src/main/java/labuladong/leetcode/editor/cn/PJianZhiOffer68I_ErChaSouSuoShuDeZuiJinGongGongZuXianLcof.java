/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉搜索树 | 二叉树</details><br>
 *
 * <div>👍 300, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import org.example.剑指Offer.TreeNode;

/**
 * 二叉搜索树的最近公共祖先 LCOF
 *
 * @author DY
 * @date 2023-04-06 18:12:03
 */
public class PJianZhiOffer68I_ErChaSouSuoShuDeZuiJinGongGongZuXianLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer68I_ErChaSouSuoShuDeZuiJinGongGongZuXianLcof().new Solution();
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
            return find(root, p.val, q.val);
        }

        private TreeNode find(TreeNode root, int p1, int p2) {
            if (root == null) return null;
            if (root.val == p1 || root.val == p2) { // 一定会存在，所以找到一个节点，就可以返回
                return root;
            }
            TreeNode left = find(root.left, p1, p2);
            TreeNode right = find(root.right, p1, p2);
            if (left != null && right != null) {
                return root;
            }
            return left == null ? right : left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
