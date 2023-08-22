/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>哈希表 | 链表</details><br>
 *
 * <div>👍 773, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制  LCOF
 *
 * @author DY
 * @date 2023-08-22 11:32:40
 */
public class PJianZhiOffer35_FuZaLianBiaoDeFuZhiLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer35_FuZaLianBiaoDeFuZhiLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
    class Solution {
        public Node copyRandomList(Node head) {
        	if(head == null) return null;
        	Map<Node,Node> map = new HashMap<>();
        	Node cur = head;
        	while (cur != null) {
        		map.put(cur,new Node(cur.val));
        		cur = cur.next;
			}
        	cur = head;
        	while (cur != null) {
        		map.get(cur).next = map.get(cur.next);
        		map.get(cur).random = map.get(cur.random);
        		cur = cur.next;
			}
        	return map.get(head);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
