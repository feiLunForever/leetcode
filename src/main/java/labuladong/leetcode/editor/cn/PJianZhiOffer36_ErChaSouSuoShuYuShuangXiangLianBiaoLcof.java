/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>栈 | 树 | 深度优先搜索 | 二叉搜索树 | 链表 | 二叉树 | 双向链表</details><br>
 *
 * <div>👍 658, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 二叉搜索树与双向链表  LCOF
 *
 * @author DY
 * @date 2023-03-14 17:40:23
 */
public class PJianZhiOffer36_ErChaSouSuoShuYuShuangXiangLianBiaoLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer36_ErChaSouSuoShuYuShuangXiangLianBiaoLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
// Definition for a Node.

    class Solution {
        private Node head, pre;

        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }

        private void dfs(Node cur) {
            if (cur == null) return;
            dfs(cur.left);
            if (pre == null) { // 已经走到最左叶子节点了，记录下head
                head = cur;
            } else {
                pre.right = cur; // 上一个节点的右子树 ==》 当前节点 (左子树)
                cur.left = pre; // 当前节点的左子树 ==》 上一个节点（右子树）
            }
            pre = cur; // 更新当前节点为上一个节点
            dfs(cur.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
