//<p>Given the <code>root</code> of a binary tree, flatten the tree into a &quot;linked list&quot;:</p>
//
//<ul>
//	<li>The &quot;linked list&quot; should use the same <code>TreeNode</code> class where the <code>right</code> child pointer points to the next node in the list and the <code>left</code> child pointer is always <code>null</code>.</li>
//	<li>The &quot;linked list&quot; should be in the same order as a <a href="https://en.wikipedia.org/wiki/Tree_traversal#Pre-order,_NLR" target="_blank"><strong>pre-order</strong><strong> traversal</strong></a> of the binary tree.</li>
//</ul>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/01/14/flaten.jpg" style="width: 500px; height: 226px;" />
//<pre>
//<strong>Input:</strong> root = [1,2,5,3,4,null,6]
//<strong>Output:</strong> [1,null,2,null,3,null,4,null,5,null,6]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> root = []
//<strong>Output:</strong> []
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> root = [0]
//<strong>Output:</strong> [0]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li>The number of nodes in the tree is in the range <code>[0, 2000]</code>.</li>
//	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
//</ul>
//
//<p>&nbsp;</p>
//<strong>Follow up:</strong> Can you flatten the tree in-place (with <code>O(1)</code> extra space)?<details><summary><strong>Related Topics</strong></summary>栈 | 树 | 深度优先搜索 | 链表 | 二叉树</details><br>
//
//<div>👍 1288, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

/**
 * Flatten Binary Tree to Linked List
 *
 * @author DY
 * @date 2022-09-01 22:45:54
 */
public class P114_FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P114_FlattenBinaryTreeToLinkedList().new Solution();
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

		}

        public void flatten1(TreeNode root) {
            if (root == null) return;
            flatten1(root.left);
            flatten1(root.right); // 找到最左非叶子节点
            TreeNode left = root.left; // 左子树
            TreeNode right = root.right; // 右子树
            // 将左子树放到右子树中
            root.left = null;
            root.right = left;
            // 将右子树放到现右子树的末端
            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            p.right = right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}