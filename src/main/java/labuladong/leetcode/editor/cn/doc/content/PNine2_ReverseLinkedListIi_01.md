<p>Given the <code>head</code> of a singly linked list and two integers <code>left</code> and <code>right</code> where <code>left &lt;= right</code>, reverse the nodes of the list from position <code>left</code> to position <code>right</code>, and return <em>the reversed list</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev2ex2.jpg" style="width: 542px; height: 222px;" /> 
<pre>
<strong>Input:</strong> head = [1,2,3,4,5], left = 2, right = 4
<strong>Output:</strong> [1,4,3,2,5]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> head = [5], left = 1, right = 1
<strong>Output:</strong> [5]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the list is <code>n</code>.</li> 
 <li><code>1 &lt;= n &lt;= 500</code></li> 
 <li><code>-500 &lt;= Node.val &lt;= 500</code></li> 
 <li><code>1 &lt;= left &lt;= right &lt;= n</code></li> 
</ul>

<p>&nbsp;</p> 
<strong>Follow up:</strong> Could you do it in one pass?

<details><summary><strong>Related Topics</strong></summary>链表</details><br>

<div>👍 1625, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=reverse-linked-list-ii" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 283 页。

迭代解法很简单，用一个 for 循环即可，但这道题经常用来考察递归思维，让你用纯递归的形式来解决，这里就给出递归解法的思路。

要想真正理解递归操作链表的代码思路，需要从递归翻转整条链表的算法开始，推导出递归翻转前 `N` 个节点的算法，最后改写出递归翻转区间内的节点的解法代码。

关键点还是要明确递归函数的定义，由于内容和图比较多，这里就不写了，请看详细题解。

**详细题解：[递归魔法：反转单链表](https://labuladong.github.io/article/fname.html?fname=递归反转链表的一部分)**

**标签：[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，递归，[链表](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head->next = reverseBetween(head->next, m - 1, n - 1);
        return head;
    }

private:
    ListNode* successor = nullptr; // 后驱节点
    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode* reverseN(ListNode* head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head->next;
            return head;
        }
        // 以 head->next 为起点，需要反转前 n - 1 个节点
        ListNode* last = reverseN(head->next, n - 1);

        head->next->next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head->next = successor;
        return last;/**<extend up -90>![](https://labuladong.github.io/pictures/反转链表/7.jpg) */
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        # base case
        if m == 1:
            return self.reverseN(head, n)
        # 前进到反转的起点触发 base case
        head.next = self.reverseBetween(head.next, m - 1, n - 1)
        return head

    successor = None # 后驱节点
    # 反转以 head 为起点的 n 个节点，返回新的头结点
    def reverseN(self, head: ListNode, n: int) -> ListNode:
        if n == 1:
            # 记录第 n + 1 个节点
            self.successor = head.next
            return head
        # 以 head.next 为起点，需要反转前 n - 1 个节点
        last = self.reverseN(head.next, n - 1)

        head.next.next = head
        # 让反转之后的 head 节点和后面的节点连起来
        head.next = self.successor
        return last # <extend up -90>![](https://labuladong.github.io/pictures/反转链表/7.jpg) #
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    ListNode successor = null; // 后驱节点
    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;/**<extend up -90>![](https://labuladong.github.io/pictures/反转链表/7.jpg) */
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 
func reverseBetween(head *ListNode, m int, n int) *ListNode {
    var successor *ListNode // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    var reverseN func(head *ListNode, n int) (*ListNode)
    reverseN = func(head *ListNode, n int) (*ListNode) {
        if n == 1 {
            // 记录第 n + 1 个节点
            successor = head.Next
            return head
        }
        // 以 head.Next 为起点，需要反转前 n - 1 个节点
        last := reverseN(head.Next, n - 1)

        head.Next.Next = head
        // 让反转之后的 head 节点和后面的节点连起来
        head.Next = successor
        return last
    }

    // base case
    if m == 1 {
        return reverseN(head, n)
    }
    // 前进到反转的起点触发 base case
    head.Next = reverseBetween(head.Next, m - 1, n - 1)
    return head
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var reverseBetween = function(head, m, n) {
    let successor = null;
    // 反转以 head 为起点的 n 个节点，返回新的头结点
    const reverseN = function(head, n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        const last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;/**<extend up -90>![](https://labuladong.github.io/pictures/反转链表/7.jpg) */
    };
    // base case
    if (m == 1) {
        return reverseN(head, n);
    }
    // 前进到反转的起点触发 base case
    head.next = reverseBetween(head.next, m - 1, n - 1);
    return head;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_reverse-linked-list-ii" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_reverse-linked-list-ii"></div></div>
</details><hr /><br />

**类似题目**：
  - [206. 反转链表 🟢](/problems/reverse-linked-list)
  - [剑指 Offer 24. 反转链表 🟢](/problems/fan-zhuan-lian-biao-lcof)
  - [剑指 Offer II 024. 反转链表 🟢](/problems/UHnkqh)

</details>
</div>



