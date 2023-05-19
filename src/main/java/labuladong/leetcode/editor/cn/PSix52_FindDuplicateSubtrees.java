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
 * <div>👍 681, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
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
 * @date 2023-05-19 14:42:46
 */
public class PSix52_FindDuplicateSubtrees {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSix52_FindDuplicateSubtrees().new Solution();
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
            Map<String, Integer> freqData = new HashMap<>(); // 记录序列化结果对应的频率
            List<TreeNode> res = new LinkedList<>();
            dfs(root, freqData, res);
            return res;
        }

        private String dfs(TreeNode root, Map<String, Integer> freqData, List<TreeNode> res) {
            if (root == null) return "#";
            String leftSeq = dfs(root.left, freqData, res); // 左子树的序列化结果
            String rightSeq = dfs(root.right, freqData, res); // 右子树的序列化结果
            String sequence = leftSeq + "," + rightSeq + "," + root.val;
            int freq = freqData.getOrDefault(sequence, 0);
            if (freq == 1) {
                res.add(root);
            }
            freqData.put(sequence, freq + 1); // 更新频率
			return sequence;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
