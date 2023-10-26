/**
 * <p>Given the <code>root</code>&nbsp;of a binary tree, return all <strong>duplicate subtrees</strong>.</p>
 *
 * <p>For each kind of duplicate subtrees, you only need to return the root node of any <b>one</b> of them.</p>
 *
 * <p>Two trees are <strong>duplicate</strong> if they have the <strong>same structure</strong> with the <strong>same node values</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/08/16/e1.jpg" style="width: 450px; height: 354px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,3,4,null,2,4,null,null,4]
 * <strong>Output:</strong> [[2,4],[4]]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/08/16/e2.jpg" style="width: 321px; height: 201px;" />
 * <pre>
 * <strong>Input:</strong> root = [2,1,1]
 * <strong>Output:</strong> [[1]]
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/08/16/e33.jpg" style="width: 450px; height: 303px;" />
 * <pre>
 * <strong>Input:</strong> root = [2,2,2,3,null,3,null]
 * <strong>Output:</strong> [[2,3],[3]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of the nodes in the tree will be in the range <code>[1, 5000]</code></li>
 * <li><code>-200 &lt;= Node.val &lt;= 200</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 哈希表 | 二叉树</details><br>
 *
 * <div>👍 712, 👎 0<span style='float: right;'></span></div>
 */

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
 * @date 2023-10-26 14:57:03
 */
public class PSix52_FindDuplicateSubtrees_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSix52_FindDuplicateSubtrees_01().new Solution();
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
            Map<String, Integer> subTrees = new HashMap<>();
            List<TreeNode> res = new LinkedList<>();
            serialize(root, subTrees, res);
            return res;
        }

        private String serialize(TreeNode root, Map<String, Integer> subTrees, List<TreeNode> res) {
            if (root == null) return "#";

            String left = serialize(root.left, subTrees, res);
            String right = serialize(root.right, subTrees, res);

            String item = left + "," + right + "," + root.val;

            int freq = subTrees.getOrDefault(item, 0);
            if (freq == 1) {
                res.add(root);
            }
            subTrees.put(item, freq + 1);
            return item;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
