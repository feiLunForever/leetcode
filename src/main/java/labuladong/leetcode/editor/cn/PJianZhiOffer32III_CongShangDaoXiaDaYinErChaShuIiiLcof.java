/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>树 | 广度优先搜索 | 二叉树</details><br>
 *
 * <div>👍 282, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import org.example.剑指Offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 从上到下打印二叉树 III LCOF
 *
 * @author DY
 * @date 2023-03-13 12:23:25
 */
public class PJianZhiOffer32III_CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer32III_CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        solution.levelOrder(node1);
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            LinkedList<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int sz = q.size();
                LinkedList<Integer> temp = new LinkedList<>();
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.pop();
                    if ((res.size() & 1) == 0) {
                        temp.addLast(cur.val);
                    } else {
                        temp.addFirst(cur.val);
                    }
                    if (cur.left != null) q.offer(cur.left);
                    if (cur.right != null) q.offer(cur.right);
                }
                res.add(temp);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
