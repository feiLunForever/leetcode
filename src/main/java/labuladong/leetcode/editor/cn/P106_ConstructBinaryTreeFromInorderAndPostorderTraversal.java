//<p>Given two integer arrays <code>inorder</code> and <code>postorder</code> where <code>inorder</code> is the inorder traversal of a binary tree and <code>postorder</code> is the postorder traversal of the same tree, construct and return <em>the binary tree</em>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" style="width: 277px; height: 302px;" />
//<pre>
//<strong>Input:</strong> inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//<strong>Output:</strong> [3,9,20,null,null,15,7]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> inorder = [-1], postorder = [-1]
//<strong>Output:</strong> [-1]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= inorder.length &lt;= 3000</code></li>
//	<li><code>postorder.length == inorder.length</code></li>
//	<li><code>-3000 &lt;= inorder[i], postorder[i] &lt;= 3000</code></li>
//	<li><code>inorder</code> and <code>postorder</code> consist of <strong>unique</strong> values.</li>
//	<li>Each value of <code>postorder</code> also appears in <code>inorder</code>.</li>
//	<li><code>inorder</code> is <strong>guaranteed</strong> to be the inorder traversal of the tree.</li>
//	<li><code>postorder</code> is <strong>guaranteed</strong> to be the postorder traversal of the tree.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>树 | 数组 | 哈希表 | 分治 | 二叉树</details><br>
//
//<div>👍 828, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 *
 * @author DY
 * @date 2022-09-05 22:01:12
 */
public class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
            Map<Integer, Integer> cache = new HashMap<>(inorder.length);
            for (int i = 0; i < inorder.length; i++) {
                cache.put(inorder[i], i);
            }
            return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, cache);
        }

        private TreeNode build(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> cache) {
            if (inStart > inEnd) return null;
            int rootVal = postorder[postEnd];
            int rootIndex = cache.get(rootVal);
            int leftSize = rootIndex - inStart;
            TreeNode root = new TreeNode(rootVal);
            root.left = build(postorder, postStart, postStart + leftSize - 1, inorder, inStart, rootIndex - 1, cache);
            root.right = build(postorder, postStart + leftSize, postEnd - 1, inorder, rootIndex + 1, inEnd, cache);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}