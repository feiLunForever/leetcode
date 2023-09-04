<p>Given the <code>head</code> of a sorted linked list, <em>delete all duplicates such that each element appears only once</em>. Return <em>the linked list <strong>sorted</strong> as well</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list1.jpg" style="width: 302px; height: 242px;" /> 
<pre>
<strong>Input:</strong> head = [1,1,2]
<strong>Output:</strong> [1,2]
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list2.jpg" style="width: 542px; height: 222px;" /> 
<pre>
<strong>Input:</strong> head = [1,1,2,3,3]
<strong>Output:</strong> [1,2,3]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the list is in the range <code>[0, 300]</code>.</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
 <li>The list is guaranteed to be <strong>sorted</strong> in ascending order.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>链表</details><br>

<div>👍 1033, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=remove-duplicates-from-sorted-list" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[数组双指针技巧汇总](https://www.bilibili.com/video/BV1iG411W7Wm)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 371 页。

思路和 [26. 删除有序数组中的重复项](/problems/remove-duplicates-from-sorted-array) 完全一样，唯一的区别是把数组赋值操作变成操作指针而已。

![](https://labuladong.github.io/pictures/数组去重/2.gif)

**详细题解：[双指针技巧秒杀七道数组题目](https://labuladong.github.io/article/fname.html?fname=双指针技巧)**

**标签：[链表](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
    ListNode* deleteDuplicates(ListNode* head) {  // 删除链表中重复的元素
        if (head == NULL) return NULL;  // 如果链表为空，直接返回NULL
        ListNode *slow = head, *fast = head;  // 定义快慢指针，初始都指向头结点
        while (fast != NULL) {  // 只要快指针没有遍历完整个链表
            if (fast->val != slow->val) {  // 快慢指针值不同
                slow->next = fast;  // 慢指针连接新节点
                slow = slow->next;  // 慢指针向后移动一位
            }
            fast = fast->next;  // 快指针向后移动一位
        }
        slow->next = NULL;  // 断开与后面重复元素的连接
        return head;  // 返回头结点
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if head == None:
            return None
        slow = head
        fast = head
        while fast != None:
            if fast.val != slow.val:
                # nums[slow] = nums[fast];
                slow.next = fast
                # slow++;
                slow = slow.next
            # fast++
            fast = fast.next
        # 断开与后面重复元素的连接
        slow.next = None
        return head
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                // nums[slow] = nums[fast];
                slow.next = fast;
                // slow++;
                slow = slow.next;
            }
            // fast++
            fast = fast.next;
        }
        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func deleteDuplicates(head *ListNode) *ListNode {
    if head == nil {
        return nil
    }

    slow, fast := head, head
    for fast != nil {
        if fast.Val != slow.Val {
            // nums[slow] = nums[fast];
            slow.Next = fast
            // slow++;
            slow = slow.Next
        }
        // fast++
        fast = fast.Next
    }
    // 断开与后面重复元素的连接
    slow.Next = nil
    return head
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
  if (head === null) return null;
  var slow = head;
  var fast = head;
  while (fast !== null) {
    if (fast.val !== slow.val) {
      // nums[slow] = nums[fast];
      slow.next = fast;
      // slow++;
      slow = slow.next;
    }
    // fast++
    fast = fast.next;
  }
  // 断开与后面重复元素的连接
  slow.next = null;
  return head;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_remove-duplicates-from-sorted-list" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-duplicates-from-sorted-list"></div></div>
</details><hr /><br />

**类似题目**：
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [26. 删除有序数组中的重复项 🟢](/problems/remove-duplicates-from-sorted-array)
  - [27. 移除元素 🟢](/problems/remove-element)
  - [283. 移动零 🟢](/problems/move-zeroes)
  - [344. 反转字符串 🟢](/problems/reverse-string)
  - [5. 最长回文子串 🟠](/problems/longest-palindromic-substring)
  - [82. 删除排序链表中的重复元素 II 🟠](/problems/remove-duplicates-from-sorted-list-ii)
  - [剑指 Offer 57. 和为s的两个数字 🟢](/problems/he-wei-sde-liang-ge-shu-zi-lcof)
  - [剑指 Offer II 006. 排序数组中两个数字之和 🟢](/problems/kLl5u1)

</details>
</div>



