//<p>Given an integer <code>n</code>, return <em>all the structurally unique <strong>BST&#39;</strong>s (binary search trees), which has exactly </em><code>n</code><em> nodes of unique values from</em> <code>1</code> <em>to</em> <code>n</code>. Return the answer in <strong>any order</strong>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg" style="width: 600px; height: 148px;" />
//<pre>
//<strong>Input:</strong> n = 3
//<strong>Output:</strong> [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> n = 1
//<strong>Output:</strong> [[1]]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= n &lt;= 8</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>树 | 二叉搜索树 | 动态规划 | 回溯 | 二叉树</details><br>
//
//<div>👍 1299, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Unique Binary Search Trees II
 *
 * @author DY
 * @date 2022-09-08 18:13:34
 */
public class P95_UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P95_UniqueBinarySearchTreesIi().new Solution();
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
        public List<TreeNode> generateTrees(int n) {
            Map<String, List<TreeNode>> cache = new HashMap<>(n);
            return generateTrees(1, n, cache);
        }

        private List<TreeNode> generateTrees(int start, int end, Map<String, List<TreeNode>> cache) {
            List<TreeNode> res = new LinkedList<>();
            if (start > end) {
                res.add(null);
                return res;
            }
            if (cache.containsKey(start + "_" + end)) return cache.get(start + "_" + end);
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftTrees = generateTrees(start, i - 1, cache);
                List<TreeNode> rightTrees = generateTrees(i + 1, end, cache);
                for (TreeNode leftNode : leftTrees) {
                    for (TreeNode rightNode : rightTrees) {
                        TreeNode root = new TreeNode(i, leftNode, rightNode);
                        res.add(root);
                    }
                }
                cache.put(start + "_" + end, res);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}