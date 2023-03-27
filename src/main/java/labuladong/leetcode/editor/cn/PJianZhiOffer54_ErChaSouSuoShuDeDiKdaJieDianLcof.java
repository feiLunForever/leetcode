/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉搜索树 | 二叉树</details><br>
 *
 * <div>👍 373, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import org.example.剑指Offer.TreeNode;

/**
 * 二叉搜索树的第k大节点  LCOF
 *
 * @author DY
 * @date 2023-03-27 12:07:31
 */
public class PJianZhiOffer54_ErChaSouSuoShuDeDiKdaJieDianLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer54_ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
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

        private int topK;
        private int k;

        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return topK;
        }

        private void dfs(TreeNode root) {
            if (root == null || k == 0) {
                return;
            }
            dfs(root.right);
            if(--k == 0) topK = root.val;
            dfs(root.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
