/**
 * <p>Given an integer <code>n</code>, return <em>all the structurally unique <strong>BST'</strong>s (binary search trees), which has exactly </em><code>n</code><em> nodes of unique values from</em> <code>1</code> <em>to</em> <code>n</code>. Return the answer in <strong>any order</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg" style="width: 600px; height: 148px;" />
 * <pre>
 * <strong>Input:</strong> n = 3
 * <strong>Output:</strong> [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 1
 * <strong>Output:</strong> [[1]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 8</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 二叉搜索树 | 动态规划 | 回溯 | 二叉树</details><br>
 *
 * <div>👍 1427, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Unique Binary Search Trees II
 *
 * @author DY
 * @date 2023-05-23 17:31:04
 */
public class PNine5_UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PNine5_UniqueBinarySearchTreesIi().new Solution();
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
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) return new ArrayList<>();
            return dfs(1, n);
        }

        private List<TreeNode> dfs(int l, int r) {
            List<TreeNode> res = new LinkedList<>();
            if (l > r) {
                res.add(null);
                return res;
            }
            for (int i = l; i <= r; i++) {
                List<TreeNode> left = dfs(l, i - 1);
                List<TreeNode> right = dfs(i + 1, r);
                for (TreeNode ln : left) {
                    for (TreeNode rn : right) {
                        TreeNode root = new TreeNode(i, ln, rn);
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
