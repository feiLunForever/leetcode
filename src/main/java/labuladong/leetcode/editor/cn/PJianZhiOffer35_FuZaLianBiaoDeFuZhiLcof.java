/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>哈希表 | 链表</details><br>
 *
 * <div>👍 693, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 复杂链表的复制  LCOF
 *
 * @author DY
 * @date 2023-03-14 12:27:05
 */
public class PJianZhiOffer35_FuZaLianBiaoDeFuZhiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer35_FuZaLianBiaoDeFuZhiLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
// Definition for a Node.


    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            for (Node p = head; p != null; p = p.next.next) { // 将每个节点复制一份
                Node temp = new Node(p.val);
                temp.next = p.next;
                p.next = temp;
            }
            for (Node p = head; p != null; p = p.next.next) { // 连接 random
                if (p.random != null) {
                    p.next.random = p.random.next;
                }
            }
            Node root = head.next;
            Node pre = head, cur = head.next;
            while (cur.next != null) { // 拆分链表
                pre.next = pre.next.next;
                cur.next = cur.next.next;
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = null; // 最后一个原始节点还连接着new node，断开
            return root;
        }


		/*public Node copyRandomList(Node head) {
			if (head == null) return null;
			Map<Node, Node> mapping = new HashMap<>();
			for (Node p = head; p != null; p = p.next) {
				mapping.put(p, new Node(p.val));
			}
			for (Node p = head; p != null; p = p.next) {
				if (p.next != null) {
					mapping.get(p).next = mapping.get(p.next);
				}
				if (p.random != null) {
					mapping.get(p).random = mapping.get(p.random);
				}
			}
			return mapping.get(head);
		}*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
