//<p>Given the <code>root</code> of a binary tree, return <em>its maximum depth</em>.</p>
//
//<p>A binary tree&#39;s <strong>maximum depth</strong>&nbsp;is the number of nodes along the longest path from the root node down to the farthest leaf node.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/tmp-tree.jpg" style="width: 400px; height: 277px;" />
//<pre>
//<strong>Input:</strong> root = [3,9,20,null,null,15,7]
//<strong>Output:</strong> 3
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> root = [1,null,2]
//<strong>Output:</strong> 2
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
//	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 二叉树</details><br>
//
//<div>👍 1325, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

/**
 * Maximum Depth of Binary Tree
 * @author DY
 * @date 2022-08-08 15:47:29
 */
public class P104_MaximumDepthOfBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P104_MaximumDepthOfBinaryTree().new Solution();
	 }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	private int res; //记录最大深度
	private int depth; //当前节点的深度
    public int maxDepth(TreeNode root) {
		traverse(root);
		return res;
    }

	private void traverse(TreeNode root) {
    	if(root ==null) return;

    	depth++; // 前序位置
    	if(root.left == null && root.right == null){ // 叶子节点
    		res = Math.max(res,depth);
		}
    	traverse(root.left);
    	traverse(root.right);
    	depth--; // 后序位置，即离开此节点
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}