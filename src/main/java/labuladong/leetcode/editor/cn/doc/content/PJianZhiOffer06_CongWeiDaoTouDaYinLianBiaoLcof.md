<p>English description is not available for the problem. Please switch to Chinese.</p>

<details><summary><strong>Related Topics</strong></summary>栈 | 递归 | 链表 | 双指针</details><br>

<div>👍 383, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/7uUsXJpFJ8wzuMMxBmS7NQ' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 17 期刷题打卡挑战](https://aep.xet.tech/s/2jPp5X) 最后一天报名！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题解法很多，比如我们可以借助「[栈](https://labuladong.github.io/article/fname.html?fname=二叉树总结) 和 [递归链表](https://appktavsiei5995.pc.xiaoe-tech.com/detail/p_626554bae4b0cedf38a9371e/6) 中讲到的后序遍历技巧来写代码。

递归函数本质上就是让操作系统帮我们维护了递归栈，和栈的解法效率上完全相同，但是这样写代码有助于我们深入理解递归的思维。

**标签：[栈](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121993002939219969)，[链表](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

## 解法代码

```java
// 用「遍历」的思路写递归解法
class Solution {
    public int[] reversePrint(ListNode head) {
        traverse(head);
        return res;
    }

    // 记录链表长度
    int len = 0;
    // 结果数组
    int[] res;
    // 结果数组中的指针
    int p = 0;

    // 递归遍历单链表
    void traverse(ListNode head) {
        if (head == null) {
            // 到达链表尾部，此时知道了链表的总长度
            // 创建结果数组
            res = new int[len];
            return;
        }
        len++;
        traverse(head.next);
        // 后序位置，可以倒序操作链表
        res[p] = head.val;
        p++;
    }



    // 用「分解问题」的思路写递归解法
    // 因为 Java 的 int[] 数组不支持 add 相关的操作，所以我们把返回值修改成 List
    // 定义：输入一个单链表，返回该链表翻转的值，示例 1->2->3
    List<Integer> reversePrint2(ListNode head) {
        // base case
        if (head == null) {
            return new LinkedList<>();
        }

        // 把子链表翻转的结果算出来，示例 [3,2]
        List<Integer> subProblem = reversePrint2(head.next);
        // 把 head 的值接到子链表的翻转结果的尾部，示例 [3,2,1]
        subProblem.add(head.val);
        return subProblem;
    }
}

```

</details>
</div>



