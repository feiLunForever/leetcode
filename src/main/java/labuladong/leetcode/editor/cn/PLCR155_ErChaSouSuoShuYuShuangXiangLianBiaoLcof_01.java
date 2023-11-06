/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>栈 | 树 | 深度优先搜索 | 二叉搜索树 | 链表 | 二叉树 | 双向链表</details><br>
 *
 * <div>👍 734, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import dto.One15.Node;

/**
 * 将二叉搜索树转化为排序的双向链表
 *
 * @author DY
 * @date 2023-11-06 16:16:34
 */
public class PLCR155_ErChaSouSuoShuYuShuangXiangLianBiaoLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PLCR155_ErChaSouSuoShuYuShuangXiangLianBiaoLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
    class Solution {
        Node pre, head;

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
            // 前序位置
            if (pre == null) {
                head = cur;
            } else {
                pre.right = cur;
                cur.left = pre;
            }
            pre = cur;
            dfs(cur.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
