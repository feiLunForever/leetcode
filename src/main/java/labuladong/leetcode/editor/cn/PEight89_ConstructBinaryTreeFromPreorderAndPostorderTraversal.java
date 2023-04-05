/**
 * <p>Given two integer arrays, <code>preorder</code> and <code>postorder</code> where <code>preorder</code> is the preorder traversal of a binary tree of <strong>distinct</strong> values and <code>postorder</code> is the postorder traversal of the same tree, reconstruct and return <em>the binary tree</em>.</p>
 *
 * <p>If there exist multiple answers, you can <strong>return any</strong> of them.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/07/24/lc-prepost.jpg" style="width: 304px; height: 265px;" />
 * <pre>
 * <strong>Input:</strong> preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 * <strong>Output:</strong> [1,2,3,4,5,6,7]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> preorder = [1], postorder = [1]
 * <strong>Output:</strong> [1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= preorder.length &lt;= 30</code></li>
 * <li><code>1 &lt;= preorder[i] &lt;= preorder.length</code></li>
 * <li>All the values of <code>preorder</code> are <strong>unique</strong>.</li>
 * <li><code>postorder.length == preorder.length</code></li>
 * <li><code>1 &lt;= postorder[i] &lt;= postorder.length</code></li>
 * <li>All the values of <code>postorder</code> are <strong>unique</strong>.</li>
 * <li>It is guaranteed that <code>preorder</code> and <code>postorder</code> are the preorder traversal and postorder traversal of the same binary tree.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 数组 | 哈希表 | 分治 | 二叉树</details><br>
 *
 * <div>👍 306, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Construct Binary Tree from Preorder and Postorder Traversal
 *
 * @author DY
 * @date 2023-04-05 17:00:33
 */
public class PEight89_ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PEight89_ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
        solution.constructFromPrePost(new int[]{1,2,4,5,3,6,7},new int[]{4,5,2,6,7,3,1});
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
            Map<Integer, Integer> postIndex = new HashMap<>(preorder.length);
            for (int i = 0; i < postorder.length; i++) {
                postIndex.put(postorder[i], i);
            }
            return buildTree(preorder, 0, preorder.length - 1, postIndex, 0, postorder.length - 1);
        }

        private TreeNode buildTree(int[] preorder, int preStart, int preEnd, Map<Integer, Integer> postIndex, int postStart, int postEnd) {
            if (preStart > preEnd) return null;
			if (preStart == preEnd) { // 防止后面preorder[preStart + 1]数组越界
				return new TreeNode(preorder[preStart]);
			}
            int rootVal = preorder[preStart];
            int leftRootIndex = postIndex.get(preorder[preStart + 1]);
            TreeNode root = new TreeNode(rootVal);
            int leftSize = leftRootIndex - postStart + 1;
            root.left = buildTree(preorder, preStart + 1, preStart + leftSize, postIndex, postStart, leftRootIndex);
            root.right = buildTree(preorder, preStart + leftSize + 1, preEnd, postIndex, leftRootIndex + 1, postEnd - 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
