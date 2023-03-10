English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>栈 | 设计</details><br>

<div>👍 456, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。[第 18 期每日打卡](https://aep.xet.tech/s/2PLO1n) 开始报名。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [155. 最小栈](/problems/min-stack) 相同。

根据我们之前亲自动手实现的栈，我们知道栈是一种操作受限的数据结构，只能从栈顶插入或弹出元素，所以对于标准的栈来说，如果想实现本题的 `getMin` 方法，只能老老实实把所有元素弹出来然后找最小值。

不过我们可以用「空间换时间」的思路来避免这种低效率的操作，用一个额外的栈 `minStk` 来记录栈中每个元素下面（到栈底）的最小元素是多少，这样就能快速得到整个栈中的最小元素了。

![](https://labuladong.gitee.io/pictures/短题解/155.jpeg)

当然，我们还可以做一些优化，减少 `minStk` 中存储的元素个数，我把原始解法和优化解法都写出来了，供参考。

**标签：[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[栈](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121993002939219969)，[设计](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121998148662362112)**

## 解法代码

```java
// 原始思路
class MinStack1 {
    // 记录栈中的所有元素
    Stack<Integer> stk = new Stack<>();
    // 阶段性记录栈中的最小元素
    Stack<Integer> minStk = new Stack<>();

    public void push(int val) {
        stk.push(val);
        // 维护 minStk 栈顶为全栈最小元素
        if (minStk.isEmpty() || val <= minStk.peek()) {
            // 新插入的这个元素就是全栈最小的
            minStk.push(val);
        } else {
            // 插入的这个元素比较大
            minStk.push(minStk.peek());
        }
    }
    
    public void pop() {
        stk.pop();
        minStk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        // minStk 栈顶为全栈最小元素
        return minStk.peek();
    }
}
// 优化版
class MinStack {
    // 记录栈中的所有元素
    Stack<Integer> stk = new Stack<>();
    // 阶段性记录栈中的最小元素
    Stack<Integer> minStk = new Stack<>();

    public void push(int val) {
        stk.push(val);
        // 维护 minStk 栈顶为全栈最小元素
        if (minStk.isEmpty() || val <= minStk.peek()) {
            // 新插入的这个元素就是全栈最小的
            minStk.push(val);
        }
    }

    public void pop() {
        // 注意 Java 的语言特性，比较 Integer 相等要用 equals 方法
        if (stk.peek().equals(minStk.peek())) {
            // 弹出的元素是全栈最小的
            minStk.pop();
        }
        stk.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        // minStk 栈顶为全栈最小元素
        return minStk.peek();
    }
}
```

**类似题目**：
  - [剑指 Offer 30. 包含min函数的栈 🟢](/problems/bao-han-minhan-shu-de-zhan-lcof)

</details>
</div>



