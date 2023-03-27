/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉树</details><br>
 *
 * <div>👍 344, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import org.example.剑指Offer.TreeNode;

/**
 * 平衡二叉树 LCOF
 *
 * @author DY
 * @date 2023-03-27 17:54:34
 */
public class PJianZhiOffer55II_PingHengErChaShuLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer55II_PingHengErChaShuLcof().new Solution();
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
