<p>English description is not available for the problem. Please switch to Chinese.</p>

<details><summary><strong>Related Topics</strong></summary>栈 | 递归 | 链表 | 双指针</details><br>

<div>👍 456, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题解法很多，比如我们可以借助「[栈](https://appktavsiei5995.pc.xiaoe-tech.com/detail/p_6265457ce4b09dda125f9bc2/6)」这种先进后出的结构来得到链表的倒序遍历结果，但是本文使用 [东哥手把手带你刷二叉树（纲领篇）](https://labuladong.github.io/article/fname.html?fname=二叉树总结) 和 [递归链表](https://appktavsiei5995.pc.xiaoe-tech.com/detail/p_626554bae4b0cedf38a9371e/6) 中讲到的后序遍历技巧来写代码。

递归函数本质上就是让操作系统帮我们维护了递归栈，和栈的解法效率上完全相同，但是这样写代码有助于我们深入理解递归的思维。

**标签：[栈](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121993002939219969)，[链表](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
    vector<int> reversePrint(ListNode* head) {
        traverse(head);
        return res;
    }

    // 记录链表长度
    int len = 0;
    // 结果数组
    vector<int> res;
    // 结果数组中的指针
    int p = 0;

    // 递归遍历单链表
    void traverse(ListNode* head) {
        if (head == nullptr) {
            // 到达链表尾部，此时知道了链表的总长度
            // 创建结果数组
            res.resize(len);
            return;
        }
        len++;
        traverse(head->next);
        // 后序位置，可以倒序操作链表
        res[p] = head->val;
        p++;
    }

    // 用「分解问题」的思路写递归解法
    // 因为 C++ 的 vector 可以支持 push_back 操作，所以我们不需要改变返回值类型
    vector<int> reversePrint2(ListNode* head) {
        // base case
        if (head == nullptr) {
            return {};
        }

        // 把子链表翻转的结果算出来，示例 [3,2]
        vector<int> subProblem = reversePrint2(head->next);
        // 把 head 的值接到子链表的翻转结果的尾部，示例 [3,2,1]
        subProblem.push_back(head->val);
        return subProblem;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def reversePrint(self, head: ListNode) -> List[int]:
        # 用「遍历」的思路写递归解法
        def traverse(head):
            nonlocal len_, res, p
            if not head:
                res = [0] * len_
                return
            len_ += 1
            traverse(head.next)
            res[p] = head.val
            p += 1
        
        len_ = 0
        res = []
        p = 0
        traverse(head)
        return res

    def reversePrint2(self, head: ListNode) -> List[int]:
        # 用「分解问题」的思路写递归解法
        def sub_problem(head):
            if not head:
                return []
            sub_res = sub_problem(head.next)
            sub_res.append(head.val)
            return sub_res
        
        return sub_problem(head)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

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

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

/*
用「遍历」的思路写递归解法
*/

func reversePrint(head *ListNode) []int {
    var res []int
    var len int

    // 递归遍历单链表
    var traverse func(*ListNode)
    traverse = func(head *ListNode) {
        if head == nil {
            // 到达链表尾部，此时知道了链表的总长度
            // 创建结果数组
            res = make([]int, len)
            return
        }
        len++
        traverse(head.Next)
        // 后序位置，可以倒序操作链表
        res[len-p-1] = head.Val
        p++
    }

    traverse(head)
    return res
}

/*
用「分解问题」的思路写递归解法
因为 Go 不支持泛型，所以我们把返回值修改成 []int
定义：输入一个单链表，返回该链表翻转的值，示例 1->2->3
*/
func reversePrint2(head *ListNode) []int {
    // base case
    if head == nil {
        return []int{}
    }

    // 把子链表翻转的结果算出来，示例 [3,2]
    subProblem := reversePrint2(head.Next)
    // 把 head 的值接到子链表的翻转结果的尾部，示例 [3,2,1]
    return append(subProblem, head.Val)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * 用「遍历」的思路写递归解法
 */

var reversePrint = function(head) {
  let len = 0; // 记录链表长度
  let res = []; // 结果数组
  let p = 0; // 结果数组中的指针

  // 递归遍历单链表
  const traverse = (head) => {
    if (!head) {
      // 到达链表尾部，此时知道了链表的总长度
      // 创建结果数组
      res = new Array(len);
      return;
    }
    len++;
    traverse(head.next);
    // 后序位置，可以倒序操作链表
    res[p] = head.val;
    p++;
  };

  traverse(head);
  return res;
};


/**
 * 用「分解问题」的思路写递归解法
 * 因为 Java 的 int[] 数组不支持 add 相关的操作，所以我们把返回值修改成 List
 * 定义：输入一个单链表，返回该链表翻转的值，示例 1->2->3
 */
var reversePrint2 = function(head) {
  // base case
  if (!head) {
    return new LinkedList();
  }

  // 把子链表翻转的结果算出来，示例 [3,2]
  let subProblem = reversePrint2(head.next);
  // 把 head 的值接到子链表的翻转结果的尾部，示例 [3,2,1]
  subProblem.push(head.val);
  return subProblem;
};
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_cong-wei-dao-tou-da-yin-lian-biao-lcof" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_cong-wei-dao-tou-da-yin-lian-biao-lcof"></div></div>
</details><hr /><br />

</details>
</div>



