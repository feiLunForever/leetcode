/**
 * <p>Given the <code>root</code> of a binary search tree, and an integer <code>k</code>, return <em>the</em> <code>k<sup>th</sup></code> <em>smallest value (<strong>1-indexed</strong>) of all the values of the nodes in the tree</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/28/kthtree1.jpg" style="width: 212px; height: 301px;" />
 * <pre>
 * <strong>Input:</strong> root = [3,1,4,null,2], k = 1
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/28/kthtree2.jpg" style="width: 382px; height: 302px;" />
 * <pre>
 * <strong>Input:</strong> root = [5,3,6,2,4,null,null,1], k = 3
 * <strong>Output:</strong> 3
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is <code>n</code>.</li>
 * <li><code>1 &lt;= k &lt;= n &lt;= 10<sup>4</sup></code></li>
 * <li><code>0 &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉搜索树 | 二叉树</details><br>
 *
 * <div>👍 789, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

/**
 * Kth Smallest Element in a BST
 *
 * @author DY
 * @date 2023-10-26 15:30:31
 */
public class PTwo30_KthSmallestElementInABst_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PTwo30_KthSmallestElementInABst_01().new Solution();
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
        private Integer res;
        private int rank;

        public int kthSmallest(TreeNode root, int k) {
            traverse(root, k);

            return res;
        }

        private void traverse(TreeNode root, int k) {
            if (res != null || root == null) return;

            traverse(root.left, k);

            // 中序位置
            ++rank;
            if (rank == k) {
                res = root.val;
                return;
            }

            traverse(root.right, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
