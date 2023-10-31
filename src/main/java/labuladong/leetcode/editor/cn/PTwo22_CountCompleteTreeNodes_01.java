/**
 * <p>Given the <code>root</code> of a <strong>complete</strong> binary tree, return the number of the nodes in the tree.</p>
 *
 * <p>According to <strong><a href="http://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees" target="_blank">Wikipedia</a></strong>, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between <code>1</code> and <code>2<sup>h</sup></code> nodes inclusive at the last level <code>h</code>.</p>
 *
 * <p>Design an algorithm that runs in less than&nbsp;<code data-stringify-type="code">O(n)</code>&nbsp;time complexity.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/14/complete.jpg" style="width: 372px; height: 302px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,3,4,5,6]
 * <strong>Output:</strong> 6
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = []
 * <strong>Output:</strong> 0
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [1]
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[0, 5 * 10<sup>4</sup>]</code>.</li>
 * <li><code>0 &lt;= Node.val &lt;= 5 * 10<sup>4</sup></code></li>
 * <li>The tree is guaranteed to be <strong>complete</strong>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>位运算 | 树 | 二分查找 | 二叉树</details><br>
 *
 * <div>👍 1046, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

/**
 * Count Complete Tree Nodes
 *
 * @author DY
 * @date 2023-10-31 10:53:58
 */
public class PTwo22_CountCompleteTreeNodes_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PTwo22_CountCompleteTreeNodes_01().new Solution();
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
        public int countNodes(TreeNode root) {
            int hl = 0, hr = 0;
            TreeNode l = root, r = root;
            while (l != null) {
                l = l.left;
                ++hl;
            }
            while (r != null) {
                r = r.right;
                ++hr;
            }
            if (hl == hr) {
                return (int) (Math.pow(2, hl) - 1);
            }
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
