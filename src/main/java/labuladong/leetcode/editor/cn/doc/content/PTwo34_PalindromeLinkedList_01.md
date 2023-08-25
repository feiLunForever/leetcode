<p>Given the <code>head</code> of a singly linked list, return <code>true</code><em> if it is a </em><span data-keyword="palindrome-sequence"><em>palindrome</em></span><em> or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg" style="width: 422px; height: 62px;" /> 
<pre>
<strong>Input:</strong> head = [1,2,2,1]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg" style="width: 182px; height: 62px;" /> 
<pre>
<strong>Input:</strong> head = [1,2]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the list is in the range <code>[1, 10<sup>5</sup>]</code>.</li> 
 <li><code>0 &lt;= Node.val &lt;= 9</code></li> 
</ul>

<p>&nbsp;</p> 
<strong>Follow up:</strong> Could you do it in 
<code>O(n)</code> time and 
<code>O(1)</code> space?

<details><summary><strong>Related Topics</strong></summary>栈 | 递归 | 链表 | 双指针</details><br>

<div>👍 1760, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=palindrome-linked-list" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 277 页。

这道题的关键在于，单链表无法倒着遍历，无法使用双指针技巧。

那么最简单的办法就是，把原始链表反转存入一条新的链表，然后比较这两条链表是否相同。

更聪明一些的办法是借助双指针算法：

**1、先通过 [双指针技巧](https://labuladong.github.io/article/fname.html?fname=链表技巧) 中的快慢指针来找到链表的中点**：

![](https://labuladong.github.io/pictures/回文链表/1.jpg)

**2、如果 `fast` 指针没有指向 `null`，说明链表长度为奇数，`slow` 还要再前进一步**：

![](https://labuladong.github.io/pictures/回文链表/2.jpg)

**3、从 `slow` 开始反转后面的链表，现在就可以开始比较回文串了**：

![](https://labuladong.github.io/pictures/回文链表/3.jpg)

**详细题解：[如何判断回文链表](https://labuladong.github.io/article/fname.html?fname=判断回文链表)**

**标签：回文问题，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[链表](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
    bool isPalindrome(ListNode* head) {
        ListNode *slow, *fast;   // Define two pointers
        slow = fast = head;      // Initialize the pointers
        while (fast != nullptr && fast->next != nullptr) {  // Loop until fast pointer reaches the end
            slow = slow->next;   // Move slow pointer one step
            fast = fast->next->next;   // Move fast pointer two step
        }

        if (fast != nullptr)    // If fast pointer is not nullptr
            slow = slow->next;  // Move the slow pointer one step

        ListNode *left = head;  // Initialize left pointer to head
        ListNode *right = reverse(slow);   // Reverse the right half of the list and make the right pointer point to the new head
        while (right != nullptr) {        // Loop until right pointer is nullptr
            if (left->val != right->val)  // If the values of left and right pointers are not equal
                return false;            // Return false
            left = left->next;           // Move the left pointer one step
            right = right->next;         // Move the right pointer one step
        }

        return true;   // Return true if all elements in the list are equal to their corresponding elements in the reversed list
    }

    ListNode* reverse(ListNode* head) {
        ListNode *pre = nullptr, *cur = head;   // Define two pointers
        while (cur != nullptr) {   // Loop until the last node of the list is reached
            ListNode *next = cur->next;    // Store the next pointer temporarily
            cur->next = pre;               // Reverse the pointer
            pre = cur;                     // Move the pre pointer one step
            cur = next;                    // Move the cur pointer one step forward
        }
        return pre;            // Return the new head
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        if fast:
            slow = slow.next

        left = head
        right = self.reverse(slow)
        while right:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next
            
        return True
    
    def reverse(self, head: ListNode) -> ListNode:
        pre, cur = None, head
        while cur:
            next_node = cur.next
            cur.next = pre
            pre = cur
            cur = next_node
            
        return pre
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null)
            slow = slow.next;

        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func isPalindrome(head *ListNode) bool {
    slow, fast := head, head
    for fast != nil && fast.Next != nil {
        slow = slow.Next
        fast = fast.Next.Next
    }

    if fast != nil {
        slow = slow.Next
    }

    left, right := head, reverse(slow)
    for right != nil {
        if left.Val != right.Val {
            return false
        }
        left = left.Next
        right = right.Next
    }

    return true
}

func reverse(head *ListNode) *ListNode {
    var pre, cur *ListNode
    cur = head
    for cur != nil {
        next := cur.Next
        cur.Next = pre
        pre = cur
        cur = next
    }
    return pre
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var isPalindrome = function(head) {
  let [slow, fast] = [head, head];
  while (fast !== null && fast.next !== null) {
    slow = slow.next;
    fast = fast.next.next;
  }

  if (fast !== null)
    slow = slow.next;

  let left = head;
  let right = reverse(slow);
  while (right !== null) {
    if (left.val !== right.val)
      return false;
    left = left.next;
    right = right.next;
  }

  return true;
};

function reverse(head) {
  let [pre, cur] = [null, head];
  while (cur !== null) {
    let next = cur.next;
    cur.next = pre;
    pre = cur;
    cur = next;
  }
  return pre;
}
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_palindrome-linked-list" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_palindrome-linked-list"></div></div>
</details><hr /><br />

**类似题目**：
  - [剑指 Offer II 027. 回文链表 🟢](/problems/aMhZSa)

</details>
</div>



