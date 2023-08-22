<p>Given the <code>head</code> of a singly linked list, reverse the list, and return <em>the reversed list</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg" style="width: 542px; height: 222px;" /> 
<pre>
<strong>Input:</strong> head = [1,2,3,4,5]
<strong>Output:</strong> [5,4,3,2,1]
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg" style="width: 182px; height: 222px;" /> 
<pre>
<strong>Input:</strong> head = [1,2]
<strong>Output:</strong> [2,1]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> head = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the list is the range <code>[0, 5000]</code>.</li> 
 <li><code>-5000 &lt;= Node.val &lt;= 5000</code></li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow up:</strong> A linked list can be reversed either iteratively or recursively. Could you implement both?</p>

<details><summary><strong>Related Topics</strong></summary>递归 | 链表</details><br>

<div>👍 3299, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=reverse-linked-list" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

递归实现反转链表常常用来考察递归思想，我这里就用纯递归来翻转链表。

**对于递归算法，最重要的就是明确递归函数的定义**。具体来说，我们的 `reverse` 函数定义是这样的：

**输入一个节点 `head`，将「以 `head` 为起点」的链表反转，并返回反转之后的头结点**。

明白了函数的定义，再来看这个问题。比如说我们想反转这个链表：

![](https://labuladong.github.io/pictures/反转链表/1.jpg)

那么输入 `reverse(head)` 后，会在这里进行递归：

```java
ListNode last = reverse(head.next);
```

不要跳进递归（你的脑袋能压几个栈呀？），而是要根据刚才的函数定义，来弄清楚这段代码会产生什么结果：

![](https://labuladong.github.io/pictures/反转链表/2.jpg)

这个 `reverse(head.next)` 执行完成后，整个链表就成了这样：

![](https://labuladong.github.io/pictures/反转链表/3.jpg)

并且根据函数定义，`reverse` 函数会返回反转之后的头结点，我们用变量 `last` 接收了。

现在再来看下面的代码：

```java
head.next.next = head;
```

![](https://labuladong.github.io/pictures/反转链表/4.jpg)

接下来：

```java
head.next = null;
return last;
```

![](https://labuladong.github.io/pictures/反转链表/5.jpg)

神不神奇，这样整个链表就反转过来了！

**详细题解：[递归魔法：反转单链表](https://labuladong.github.io/article/fname.html?fname=递归反转链表的一部分)**

**标签：单链表**

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

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head == NULL || head->next == NULL) {
            return head;
        }
        ListNode* last = reverseList(head->next);/**<extend up -200>![](https://labuladong.github.io/pictures/反转链表/3.jpg) */
        head->next->next = head;/**<extend up -200>![](https://labuladong.github.io/pictures/反转链表/4.jpg) */
        head->next = NULL;/**<extend up -200>![](https://labuladong.github.io/pictures/反转链表/5.jpg) */
        return last;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        last = self.reverseList(head.next) # <extend up -200>![](https://labuladong.github.io/pictures/反转链表/3.jpg) #
        head.next.next = head # <extend up -200>![](https://labuladong.github.io/pictures/反转链表/4.jpg) #
        head.next = None # <extend up -200>![](https://labuladong.github.io/pictures/反转链表/5.jpg) #
        return last
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);/**<extend up -200>![](https://labuladong.github.io/pictures/反转链表/3.jpg) */
        head.next.next = head;/**<extend up -200>![](https://labuladong.github.io/pictures/反转链表/4.jpg) */
        head.next = null;/**<extend up -200>![](https://labuladong.github.io/pictures/反转链表/5.jpg) */
        return last;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func reverseList(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
        return head
    }
    last := reverseList(head.Next)
    /* <extend up - 200>
    ![](https://labuladong.github.io/pictures/反转链表/3.jpg)
    */
    head.Next.Next = head
    /* <extend up - 200>
    ![](https://labuladong.github.io/pictures/反转链表/4.jpg)
    */
    head.Next = nil
    /* <extend up - 200>
    ![](https://labuladong.github.io/pictures/反转链表/5.jpg)
    */
    return last
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
    if (head === null || head.next === null) {
        return head;
    }
    var last = reverseList(head.next);/**<extend up -200>![](https://labuladong.github.io/pictures/反转链表/3.jpg) */
    head.next.next = head;/**<extend up -200>![](https://labuladong.github.io/pictures/反转链表/4.jpg) */
    head.next = null;/**<extend up -200>![](https://labuladong.github.io/pictures/反转链表/5.jpg) */
    return last;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_reverse-linked-list" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_reverse-linked-list"></div></div>
</details><hr /><br />

**类似题目**：
  - [92. 反转链表 II 🟠](/problems/reverse-linked-list-ii)
  - [剑指 Offer 24. 反转链表 🟢](/problems/fan-zhuan-lian-biao-lcof)
  - [剑指 Offer II 024. 反转链表 🟢](/problems/UHnkqh)

</details>
</div>



