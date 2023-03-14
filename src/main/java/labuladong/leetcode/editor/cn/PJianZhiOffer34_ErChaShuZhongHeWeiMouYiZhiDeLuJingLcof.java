/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 回溯 | 二叉树</details><br>
 *
 * <div>👍 406, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import org.example.剑指Offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径 LCOF
 *
 * @author DY
 * @date 2023-03-13 17:42:55
 */
public class PJianZhiOffer34_ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer34_ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
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
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) return res;
            dfs(root, target, new LinkedList<>(), res);
            return res;
        }

        private void dfs(TreeNode root, int target, LinkedList<Integer> trace, List<List<Integer>> res) {
            if (root == null) return;
            trace.add(root.val);
            if (root.left == null && root.right == null && target - root.val == 0) {
                res.add(new ArrayList<>(trace));
            } else {
                dfs(root.left, target - root.val, trace, res);
                dfs(root.right, target - root.val, trace, res);
            }
            trace.removeLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
