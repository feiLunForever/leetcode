/**
 * <p>You are given a <strong>perfect binary tree</strong> where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:</p>
 *
 * <pre>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * </pre>
 *
 * <p>Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to <code>NULL</code>.</p>
 *
 * <p>Initially, all next pointers are set to <code>NULL</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2019/02/14/116_sample.png" style="width: 500px; height: 171px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,3,4,5,6,7]
 * <strong>Output:</strong> [1,#,2,3,#,4,5,6,7,#]
 * <strong>Explanation: </strong>Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = []
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[0, 2<sup>12</sup> - 1]</code>.</li>
 * <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow-up:</strong></p>
 *
 * <ul>
 * <li>You may only use constant extra space.</li>
 * <li>The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 链表 | 二叉树</details><br>
 *
 * <div>👍 975, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Populating Next Right Pointers in Each Node
 *
 * @author DY
 * @date 2023-04-03 22:15:12
 */
public class POne16_PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne16_PopulatingNextRightPointersInEachNode().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
// Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    class Solution {
        public Node connect(Node root) {
        	if(root == null) return null;
            traverse(root.left, root.right);
            return root;
        }

        private void traverse(Node left, Node right) {
            if (left == null || right == null) return;
			left.next = right; // 将传入的两个节点穿起来
            traverse(left.left,left.right); // 连接相同父节点的两个子节点
            traverse(right.left,right.right);
            traverse(left.right,right.left); // 连接跨越父节点的两个子节点
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
