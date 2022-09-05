//<p>You are given an integer array <code>nums</code> with no duplicates. A <strong>maximum binary tree</strong> can be built recursively from <code>nums</code> using the following algorithm:</p>
//
//<ol>
//	<li>Create a root node whose value is the maximum value in <code>nums</code>.</li>
//	<li>Recursively build the left subtree on the <strong>subarray prefix</strong> to the <strong>left</strong> of the maximum value.</li>
//	<li>Recursively build the right subtree on the <strong>subarray suffix</strong> to the <strong>right</strong> of the maximum value.</li>
//</ol>
//
//<p>Return <em>the <strong>maximum binary tree</strong> built from </em><code>nums</code>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/tree1.jpg" style="width: 302px; height: 421px;" />
//<pre>
//<strong>Input:</strong> nums = [3,2,1,6,0,5]
//<strong>Output:</strong> [6,3,5,null,2,0,null,null,1]
//<strong>Explanation:</strong> The recursive calls are as follow:
//- The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5].
//    - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1].
//        - Empty array, so no child.
//        - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
//            - Empty array, so no child.
//            - Only one element, so child is a node with value 1.
//    - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
//        - Only one element, so child is a node with value 0.
//        - Empty array, so no child.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/tree2.jpg" style="width: 182px; height: 301px;" />
//<pre>
//<strong>Input:</strong> nums = [3,2,1]
//<strong>Output:</strong> [3,null,2,null,1]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
//	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
//	<li>All integers in <code>nums</code> are <strong>unique</strong>.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>栈 | 树 | 数组 | 分治 | 二叉树 | 单调栈</details><br>
//
//<div>👍 564, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import labuladong.TreeNode;

/**
 * Maximum Binary Tree
 *
 * @author DY
 * @date 2022-09-05 18:54:27
 */
public class P654_MaximumBinaryTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P654_MaximumBinaryTree().new Solution();
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

        private TreeNode build(int[] nums, int start, int end) {
            if (start > end) return null;
            int index = 0, max = Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                if (max < nums[i]) {
                    max = nums[i];
                    index = i;
                }
            }
            TreeNode root = new TreeNode(max);
            root.left = build(nums, start, index - 1);
            root.right = build(nums, index + 1, end);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}