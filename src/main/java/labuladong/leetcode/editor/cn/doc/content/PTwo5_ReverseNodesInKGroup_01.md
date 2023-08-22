<p>Given the <code>head</code> of a linked list, reverse the nodes of the list <code>k</code> at a time, and return <em>the modified list</em>.</p>

<p><code>k</code> is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of <code>k</code> then left-out nodes, in the end, should remain as it is.</p>

<p>You may not alter the values in the list's nodes, only nodes themselves may be changed.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg" style="width: 542px; height: 222px;" /> 
<pre>
<strong>Input:</strong> head = [1,2,3,4,5], k = 2
<strong>Output:</strong> [2,1,4,3,5]
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex2.jpg" style="width: 542px; height: 222px;" /> 
<pre>
<strong>Input:</strong> head = [1,2,3,4,5], k = 3
<strong>Output:</strong> [3,2,1,4,5]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the list is <code>n</code>.</li> 
 <li><code>1 &lt;= k &lt;= n &lt;= 5000</code></li> 
 <li><code>0 &lt;= Node.val &lt;= 1000</code></li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow-up:</strong> Can you solve the problem in <code>O(1)</code> extra memory space?</p>

<details><summary><strong>Related Topics</strong></summary>递归 | 链表</details><br>

<div>👍 2131, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=reverse-nodes-in-k-group" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 289 页。

输入 `head`，`reverseKGroup` 函数能够把以 `head` 为头的这条链表进行翻转。

我们要充分利用这个递归函数的定义，把原问题分解成规模更小的子问题进行求解。

**1、先反转以 `head` 开头的 `k` 个元素**。

![](https://labuladong.github.io/pictures/kgroup/3.jpg)

**2、将第 `k + 1` 个元素作为 `head` 递归调用 `reverseKGroup` 函数**。

![](https://labuladong.github.io/pictures/kgroup/4.jpg)

**3、将上述两个过程的结果连接起来**。

![](https://labuladong.github.io/pictures/kgroup/5.jpg)

最后函数递归完成之后就是这个结果，完全符合题意：

![](https://labuladong.github.io/pictures/kgroup/7.jpg)

**详细题解：[如何 K 个一组反转链表](https://labuladong.github.io/article/fname.html?fname=k个一组反转链表)**

**标签：[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[链表](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
         if(head == NULL) return NULL;
    	//区间[a,b)包含k个待反转元素
    	ListNode *a, *b;
    	a = b = head;
    	for (int i = 0; i < k; i++) {
    		//不足k个，直接返回
    		if (b == NULL) return head;
    		b = b->next;
    	}
    	//反转前k个元素
    	ListNode *newHead = reverse(a, b);
    	//递归反转后续链表并连接起来
    	a->next = reverseKGroup(b, k);
    	return newHead;
    }
    ListNode *reverse(ListNode *a, ListNode *b) {
    	ListNode *pre, *cur, *nxt;
    	cur = a; pre = NULL;
    	while (cur != b) {
    		nxt = cur->next;
    		cur->next = pre;
    		pre = cur;
    		cur = nxt;
    	}
    	return pre;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        if not head:
            return None
        # 区间 [a, b) 包含 k 个待反转元素
        a = b = head
        for i in range(k):
            # 不足 k 个，不需要反转，base case
            if not b:
                return head
            b = b.next
        # 反转前 k 个元素
        newHead = self.reverse(a, b)
        # 递归反转后续链表并连接起来
        a.next = self.reverseKGroup(b, k) # <extend up -90>![](https://labuladong.github.io/pictures/kgroup/6.jpg) #
        return newHead

    """ 反转区间 [a, b) 的元素，注意是左闭右开 """
    def reverse(self, a: ListNode, b: ListNode) -> ListNode: # <extend up -300>![](https://labuladong.github.io/pictures/kgroup/8.gif) #
        pre, cur, nxt = None, a, a
        # while 终止的条件改一下就行了
        while cur != b:
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        # 返回反转后的头结点
        return pre
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);/**<extend up -90>![](https://labuladong.github.io/pictures/kgroup/6.jpg) */
        return newHead;
    }

    /* 反转区间 [a, b) 的元素，注意是左闭右开 */
    ListNode reverse(ListNode a, ListNode b) {/**<extend up -300>![](https://labuladong.github.io/pictures/kgroup/8.gif) */
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 给出一个链表和一个数k，比如1->2->3->4->5->6，k=2，那么你需要返回的结果是2->1->4->3->6->5。
func reverseKGroup(head *ListNode, k int) *ListNode {
    if head == nil {
        return nil
    }
    
    a, b := head, head
    // 找到需要翻转的区间 [a, b)
    for i := 0; i < k; i++ {
        if b == nil {
            return head
        }
        b = b.Next
    }

    // 反转区间内的链表
    newHead := reverse(a, b)
    // 递归将后续链表的区间也翻转，然后再将它链接到新的区间内
    a.Next = reverseKGroup(b, k)/**<extend up -90>![](https://labuladong.github.io/pictures/kgroup/6.jpg) */

    return newHead
}

// 翻转区间 [a, b)，包头不包尾
func reverse(a, b *ListNode) *ListNode {
    // 初始化三个指针
    pre, cur, nxt := (*ListNode)(nil), a, a

    // 循环将当前节点指向前一个节点，然后将前一个节点和当前节点往后移动
    for cur != b {
        nxt = cur.Next
        cur.Next = pre
        pre, cur = cur, nxt
    }

    // 返回新的头结点
    return pre
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function(head, k) {
    if (!head) return null;
    // 区间 [a, b) 包含 k 个待反转元素
    let a = head, b = head;
    for (let i = 0; i < k; i++) {
        // 不足 k 个，不需要反转，base case
        if (!b) return head;
        b = b.next;
    }
    // 反转前 k 个元素
    let newHead = reverse(a, b);
    // 递归反转后续链表并连接起来
    a.next = reverseKGroup(b, k);/**<extend up -90>![](https://labuladong.github.io/pictures/kgroup/6.jpg) */
    return newHead;
};

/* 反转区间 [a, b) 的元素，注意是左闭右开 */
var reverse = function(a, b) {/**<extend up -300>![](https://labuladong.github.io/pictures/kgroup/8.gif) */
    let pre = null, cur = a, nxt = a;
    // while 终止的条件改一下就行了
    while (cur !== b) {
        nxt = cur.next;
        cur.next = pre;
        pre = cur;
        cur = nxt;
    }
    // 返回反转后的头结点
    return pre;
};
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_reverse-nodes-in-k-group" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_reverse-nodes-in-k-group"></div></div>
</details><hr /><br />

**类似题目**：
  - [24. 两两交换链表中的节点 🟠](/problems/swap-nodes-in-pairs)

</details>
</div>



