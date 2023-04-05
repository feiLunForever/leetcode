/**
 * <p>Given two integer arrays <code>inorder</code> and <code>postorder</code> where <code>inorder</code> is the inorder traversal of a binary tree and <code>postorder</code> is the postorder traversal of the same tree, construct and return <em>the binary tree</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" style="width: 277px; height: 302px;" />
 * <pre>
 * <strong>Input:</strong> inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * <strong>Output:</strong> [3,9,20,null,null,15,7]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> inorder = [-1], postorder = [-1]
 * <strong>Output:</strong> [-1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= inorder.length &lt;= 3000</code></li>
 * <li><code>postorder.length == inorder.length</code></li>
 * <li><code>-3000 &lt;= inorder[i], postorder[i] &lt;= 3000</code></li>
 * <li><code>inorder</code> and <code>postorder</code> consist of <strong>unique</strong> values.</li>
 * <li>Each value of <code>postorder</code> also appears in <code>inorder</code>.</li>
 * <li><code>inorder</code> is <strong>guaranteed</strong> to be the inorder traversal of the tree.</li>
 * <li><code>postorder</code> is <strong>guaranteed</strong> to be the postorder traversal of the tree.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 数组 | 哈希表 | 分治 | 二叉树</details><br>
 *
 * <div>👍 983, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 *
 * @author DY
 * @date 2023-04-05 15:43:02
 */
public class POne06_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne06_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer, Integer> inOrderIndex = new HashMap<>(inorder.length);
            for (int i = 0; i < inorder.length; i++) {
                inOrderIndex.put(inorder[i], i);
            }
            return buildTree(postorder, 0, postorder.length - 1, inOrderIndex, 0, inorder.length - 1);
        }

        private TreeNode buildTree(int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inOrderIndex, int inStart, int inEnd) {
            if (postStart > postEnd) return null;
            int rootVal = postorder[postEnd];
            int rootIndex = inOrderIndex.get(rootVal);
            TreeNode root = new TreeNode(rootVal);
            root.left = buildTree(postorder, postStart, postStart + rootIndex - inStart - 1, inOrderIndex, inStart, rootIndex - 1);
            root.right = buildTree(postorder, postStart + rootIndex - inStart, postEnd - 1, inOrderIndex, rootIndex + 1, inEnd);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
