/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 数组 | 哈希表 | 分治 | 二叉树</details><br>
 *
 * <div>👍 1007, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/7uUsXJpFJ8wzuMMxBmS7NQ' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import org.example.剑指Offer.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树 LCOF
 *
 * @author DY
 * @date 2023-03-01 21:49:00
 */
public class PJianZhiOffer07_ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer07_ZhongJianErChaShuLcof().new Solution();
        solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inOrderIndex = new HashMap<>(inorder.length); // 记录中序遍历对应的索引值
            for (int i = 0; i < inorder.length; i++) {
                inOrderIndex.put(inorder[i], i);
            }
            return rebuild(preorder, inOrderIndex, 0, 0, inorder.length - 1);
        }

        private TreeNode rebuild(int[] preorder, Map<Integer, Integer> inOrderIndex, int preRootIndex, int inLeft, int inRight) {
            if (inLeft > inRight) return null;
            int root = preorder[preRootIndex]; // 根节点
            int inRootIndex = inOrderIndex.get(root); // 根节点在中序遍历的位置
            TreeNode rootNode = new TreeNode(root);
            rootNode.left = rebuild(preorder, inOrderIndex, preRootIndex + 1, inLeft, inRootIndex - 1);
            rootNode.right = rebuild(preorder, inOrderIndex, preRootIndex + (inRootIndex - inLeft) + 1, inRootIndex + 1, inRight);
            return rootNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}