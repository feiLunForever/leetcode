//<p>The thief has found himself a new place for his thievery again. There is only one entrance to this area, called <code>root</code>.</p>
//
//<p>Besides the <code>root</code>, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if <strong>two directly-linked houses were broken into on the same night</strong>.</p>
//
//<p>Given the <code>root</code> of the binary tree, return <em>the maximum amount of money the thief can rob <strong>without alerting the police</strong></em>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/03/10/rob1-tree.jpg" style="width: 277px; height: 293px;" />
//<pre>
//<strong>Input:</strong> root = [3,2,3,null,3,null,1]
//<strong>Output:</strong> 7
//<strong>Explanation:</strong> Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/03/10/rob2-tree.jpg" style="width: 357px; height: 293px;" />
//<pre>
//<strong>Input:</strong> root = [3,4,5,1,3,null,1]
//<strong>Output:</strong> 9
//<strong>Explanation:</strong> Maximum amount of money the thief can rob = 4 + 5 = 9.
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
//	<li><code>0 &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 动态规划 | 二叉树</details><br>
//
//<div>👍 1400, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

/**
 * House Robber III
 *
 * @author DY
 * @date 2022-08-17 17:01:30
 */
public class P337_HouseRobberIii {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P337_HouseRobberIii().new Solution();
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
        public int rob(TreeNode root) {
            int[] res = dp(root); // res[0] 不抢root，res[1] 抢root
            return Math.max(res[0], res[1]);
        }

        private int[] dp(TreeNode root) {
            if (root == null) return new int[]{0, 0};
			int[] left = dp(root.left);
			int[] right = dp(root.right);
			// root不抢,可能去抢左右子节点
            int noRot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            // 这把抢
            int rot = root.val + left[0] + right[0];
            return new int[]{noRot, rot};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}