/**
 * <p>Given the <code>root</code> of a binary tree, flatten the tree into a "linked list":</p>
 *
 * <ul>
 * <li>The "linked list" should use the same <code>TreeNode</code> class where the <code>right</code> child pointer points to the next node in the list and the <code>left</code> child pointer is always <code>null</code>.</li>
 * <li>The "linked list" should be in the same order as a <a href="https://en.wikipedia.org/wiki/Tree_traversal#Pre-order,_NLR" target="_blank"><strong>pre-order</strong><strong> traversal</strong></a> of the binary tree.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/14/flaten.jpg" style="width: 500px; height: 226px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,5,3,4,null,6]
 * <strong>Output:</strong> [1,null,2,null,3,null,4,null,5,null,6]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = []
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [0]
 * <strong>Output:</strong> [0]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[0, 2000]</code>.</li>
 * <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong> Can you flatten the tree in-place (with
 * <code>O(1)</code> extra space)?
 *
 * <details><summary><strong>Related Topics</strong></summary>栈 | 树 | 深度优先搜索 | 链表 | 二叉树</details><br>
 *
 * <div>👍 1560, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

/**
 * Flatten Binary Tree to Linked List
 *
 * @author DY
 * @date 2023-10-08 17:43:08
 */
public class POne14_FlattenBinaryTreeToLinkedList_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne14_FlattenBinaryTreeToLinkedList_01().new Solution();
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
        public void flatten(TreeNode root) {
            if (root == null) return;
            flatten(root.left); // 递归拉平左子树
            flatten(root.right); // 递归拉平右子树

            // 后序遍历位置
            TreeNode left = root.left;
            TreeNode right = root.right;

            // 1.左子树覆盖右子树
            root.left = null;
            root.right = left;
            // 2.将原来的右子树，连接到当前右子树最右节点
            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            p.right = right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
