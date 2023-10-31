/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 数组 | 哈希表 | 分治 | 二叉树</details><br>
 *
 * <div>👍 1128, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import org.example.剑指Offer.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 推理二叉树
 *
 * @author DY
 * @date 2023-10-31 11:10:18
 */
public class PLCR124_ZhongJianErChaShuLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PLCR124_ZhongJianErChaShuLcof_01().new Solution();
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
        public TreeNode deduceTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inorderIndex = new HashMap<>(inorder.length);
            for (int i = 0; i < inorder.length; i++) {
                inorderIndex.put(inorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1, inorderIndex, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int preStart, int preEnd, Map<Integer, Integer> inorderIndex, int inStart, int inEnd) {
            if (preStart > preEnd || inStart > inEnd) return null;
            int rootVal = preorder[preStart];
            int index = inorderIndex.get(rootVal);
            int leftSize = index - inStart;

            TreeNode root = new TreeNode(rootVal);
            root.left = build(preorder, preStart + 1, preStart + leftSize, inorderIndex, inStart, index - 1);
            root.right = build(preorder, preStart + leftSize + 1, preEnd, inorderIndex, index + 1, inEnd);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
