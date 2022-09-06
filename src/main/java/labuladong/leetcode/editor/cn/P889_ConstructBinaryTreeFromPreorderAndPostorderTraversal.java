//<p>Given two integer arrays, <code>preorder</code> and <code>postorder</code> where <code>preorder</code> is the preorder traversal of a binary tree of <strong>distinct</strong> values and <code>postorder</code> is the postorder traversal of the same tree, reconstruct and return <em>the binary tree</em>.</p>
//
//<p>If there exist multiple answers, you can <strong>return any</strong> of them.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/07/24/lc-prepost.jpg" style="width: 304px; height: 265px;" />
//<pre>
//<strong>Input:</strong> preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//<strong>Output:</strong> [1,2,3,4,5,6,7]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> preorder = [1], postorder = [1]
//<strong>Output:</strong> [1]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= preorder.length &lt;= 30</code></li>
//	<li><code>1 &lt;= preorder[i] &lt;= preorder.length</code></li>
//	<li>All the values of <code>preorder</code> are <strong>unique</strong>.</li>
//	<li><code>postorder.length == preorder.length</code></li>
//	<li><code>1 &lt;= postorder[i] &lt;= postorder.length</code></li>
//	<li>All the values of <code>postorder</code> are <strong>unique</strong>.</li>
//	<li>It is guaranteed that <code>preorder</code> and <code>postorder</code> are the preorder traversal and postorder traversal of the same binary tree.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>树 | 数组 | 哈希表 | 分治 | 二叉树</details><br>
//
//<div>👍 273, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Construct Binary Tree from Preorder and Postorder Traversal
 *
 * @author DY
 * @date 2022-09-06 09:52:32
 */
public class P889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P889_ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
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
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            Map<Integer, Integer> cache = new HashMap<>(postorder.length);
            for (int i = 0; i < postorder.length; i++) {
                cache.put(postorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1, cache);

        }

        private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> cache) {
            if (preStart > preEnd) return null;
			if (preStart == preEnd) {
				return new TreeNode(preorder[preStart]);
			}
            int rootVal = preorder[preStart];
            int leftRootVal = preorder[preStart + 1];
            int leftRootIndex = cache.get(leftRootVal);
            int leftSize = leftRootIndex - postStart + 1;
            TreeNode root = new TreeNode(rootVal);
            root.left = build(preorder, preStart + 1, preStart + leftSize, postorder, postStart, leftRootIndex, cache);
            root.right = build(preorder, preStart + leftSize + 1, preEnd, postorder, leftRootIndex + 1, postEnd - 1, cache);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}