/**
 * <p>You are given an integer array <code>nums</code> with no duplicates. A <strong>maximum binary tree</strong> can be built recursively from <code>nums</code> using the following algorithm:</p>
 *
 * <ol>
 * <li>Create a root node whose value is the maximum value in <code>nums</code>.</li>
 * <li>Recursively build the left subtree on the <strong>subarray prefix</strong> to the <strong>left</strong> of the maximum value.</li>
 * <li>Recursively build the right subtree on the <strong>subarray suffix</strong> to the <strong>right</strong> of the maximum value.</li>
 * </ol>
 *
 * <p>Return <em>the <strong>maximum binary tree</strong> built from </em><code>nums</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/tree1.jpg" style="width: 302px; height: 421px;" />
 * <pre>
 * <strong>Input:</strong> nums = [3,2,1,6,0,5]
 * <strong>Output:</strong> [6,3,5,null,2,0,null,null,1]
 * <strong>Explanation:</strong> The recursive calls are as follow:
 * - The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5].
 * - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1].
 * - Empty array, so no child.
 * - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
 * - Empty array, so no child.
 * - Only one element, so child is a node with value 1.
 * - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
 * - Only one element, so child is a node with value 0.
 * - Empty array, so no child.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/tree2.jpg" style="width: 182px; height: 301px;" />
 * <pre>
 * <strong>Input:</strong> nums = [3,2,1]
 * <strong>Output:</strong> [3,null,2,null,1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 1000</code></li>
 * <li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
 * <li>All integers in <code>nums</code> are <strong>unique</strong>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>栈 | 树 | 数组 | 分治 | 二叉树 | 单调栈</details><br>
 *
 * <div>👍 661, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

/**
 * Maximum Binary Tree
 *
 * @author DY
 * @date 2023-04-05 13:49:44
 */
public class PSix54_MaximumBinaryTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSix54_MaximumBinaryTree().new Solution();
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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return build(nums, 0, nums.length - 1);
        }

        private TreeNode build(int[] nums, int left, int right) {
            if (left > right) return null;
            int max = Integer.MIN_VALUE;
            int index = -1;
            for (int i = left; i <= right; i++) {
                if (nums[i] > max) {
                    index = i;
                    max = nums[i];
                }
            }
            TreeNode root = new TreeNode(max);
            root.left = build(nums, left, index - 1);
            root.right = build(nums, index + 1, right);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
