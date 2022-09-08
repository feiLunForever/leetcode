//<p>Given the <code>root</code>&nbsp;of a binary tree, return all <strong>duplicate subtrees</strong>.</p>
//
//<p>For each kind of duplicate subtrees, you only need to return the root node of any <b>one</b> of them.</p>
//
//<p>Two trees are <strong>duplicate</strong> if they have the <strong>same structure</strong> with the <strong>same node values</strong>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/08/16/e1.jpg" style="width: 450px; height: 354px;" />
//<pre>
//<strong>Input:</strong> root = [1,2,3,4,null,2,4,null,null,4]
//<strong>Output:</strong> [[2,4],[4]]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/08/16/e2.jpg" style="width: 321px; height: 201px;" />
//<pre>
//<strong>Input:</strong> root = [2,1,1]
//<strong>Output:</strong> [[1]]
//</pre>
//
//<p><strong>Example 3:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/08/16/e33.jpg" style="width: 450px; height: 303px;" />
//<pre>
//<strong>Input:</strong> root = [2,2,2,3,null,3,null]
//<strong>Output:</strong> [[2,3],[3]]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li>The number of the nodes in the tree will be in the range <code>[1, 10^4]</code></li>
//	<li><code>-200 &lt;= Node.val &lt;= 200</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 哈希表 | 二叉树</details><br>
//
//<div>👍 625, 👎 0</div>
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
 * Find Duplicate Subtrees
 *
 * @author DY
 * @date 2022-09-08 15:09:44
 */
public class P652_FindDuplicateSubtrees {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P652_FindDuplicateSubtrees().new Solution();
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
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> res = new LinkedList<>();
            Map<String, Integer> cache = new HashMap<>();
            serialize(root, cache, res);
            return res;
        }

        private String serialize(TreeNode root, Map<String, Integer> cache, List<TreeNode> res) {
            if (root == null) return "#";
            String left = serialize(root.left, cache, res);
            String right = serialize(root.right, cache, res);
            String myself = left + "," + right + "," + root.val;
            int count = cache.getOrDefault(myself, 0);
			if (count == 1) {
				res.add(root);
			}
            cache.put(myself, count + 1);
            return myself;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}