English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>设计 | 双指针 | 数据流 | 排序 | 堆（优先队列）</details><br>

<div>👍 419, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。[第 18 期每日打卡](https://aep.xet.tech/s/2PLO1n) 开始报名。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=shu-ju-liu-zhong-de-zhong-wei-shu-lcof" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [295. 数据流的中位数](/problems/find-median-from-data-stream) 相同。

本题的核心思路是使用两个优先级队列。

![](https://labuladong.github.io/pictures/中位数/1.jpeg)


小的倒三角就是个大顶堆，梯形就是个小顶堆，中位数可以通过它们的堆顶元素算出来：

![](https://labuladong.github.io/pictures/中位数/2.jpeg)

**详细题解：[一道求中位数的算法题把我整不会了](https://labuladong.github.io/article/fname.html?fname=数据流中位数)**

**标签：二叉堆，[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

## 解法代码

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
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class MedianFinder {
private:
    priority_queue<int, vector<int>, greater<int>> large; // 小顶堆
    priority_queue<int, vector<int>, less<int>> small; // 大顶堆
public:
    MedianFinder() {}/**<extend up -100>![](https://labuladong.github.io/pictures/中位数/2.jpeg) */
    double findMedian() {
        if(large.size() < small.size()) {
            return small.top();
        } else if(large.size() > small.size()) {
            return large.top();
        }
        return (large.top() + small.top()) / 2.0; //如果元素一样多，中位数就是两个堆顶元素平均数/**<extend up -100>![](https://labuladong.github.io/pictures/中位数/1.jpeg) */
    }
    
    void addNum(int num) {
        if(small.size() >= large.size()) {
            small.push(num);
            large.push(small.top());
            small.pop();
        } else {
            large.push(num);
            small.push(large.top());
            large.pop();
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

from queue import PriorityQueue

class MedianFinder:
    def __init__(self):
        # 小顶堆
        self.large = PriorityQueue()
        # 大顶堆
        self.small = PriorityQueue(lambda a,b : b-a)

    def findMedian(self) -> float: # <extend up -100>![](https://labuladong.github.io/pictures/中位数/2.jpeg) #
        # 如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if self.large.qsize() < self.small.qsize():
            return self.small.queue[0]
        elif self.large.qsize() > self.small.qsize():
            return self.large.queue[0]
        # 如果元素一样多，两个堆堆顶元素的平均数是中位数
        return (self.large.queue[0] + self.small.queue[0]) / 2.0 # <extend up -100>![](https://labuladong.github.io/pictures/中位数/1.jpeg) #

    def addNum(self, num: int) -> None:
        if self.small.qsize() >= self.large.qsize():
            self.small.put(num)
            self.large.put(self.small.get())
        else:
            self.large.put(num)
            self.small.put(self.large.get())
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class MedianFinder {
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;

    public MedianFinder() {
        // 小顶堆
        large = new PriorityQueue<>();
        // 大顶堆
        small = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
    }

    public double findMedian() {/**<extend up -100>![](https://labuladong.github.io/pictures/中位数/2.jpeg) */
        // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if (large.size() < small.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        // 如果元素一样多，两个堆堆顶元素的平均数是中位数
        return (large.peek() + small.peek()) / 2.0;/**<extend up -100>![](https://labuladong.github.io/pictures/中位数/1.jpeg) */
    }

    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    var carry int
    var result *ListNode
    var head *ListNode
    for l1 != nil || l2 != nil || carry != 0 {
        sum := 0
        if l1 != nil {
            sum += l1.Val
            l1 = l1.Next
        }
        if l2 != nil {
            sum += l2.Val
            l2 = l2.Next
        }
        sum += carry
        carry = sum / 10
        node := &ListNode{Val: sum % 10} // 求和的处理
        if result == nil {
            result = node
            head = node
        } else {
            result.Next = node
            result = result.Next
        }
    }
    return head
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

/**
 * 现有一个按非递减顺序排序的整数数组 nums。
 * 请你删除重复出现的元素，使每个元素只出现一次。
 * 返回删除后数组的新长度。
 * 不要使用额外的数组空间，必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 
 * 返回 新长度5, 并且原数组 nums 的前五个元素为 0、1、2、3 和 4。
 * 
 * 你不需要考虑数组中超出新长度后面的元素。
 */

/**
 * 思路很简单，因为数组已经是非递减排列的了，意思就是数组中之后会出现比当前下标的值还小的值都会在之前出现，所以我们可以考虑双指针法。
 * 既然想到了双指针，那么要开一个变量储存数组中不重复的个数，这个变量命名为NonDuplicate即可。开始的时候它的值是1，因为第一个数一定是不重复的。
 * 随后，我们遍历数组，比较i和i+1位置的值：
 *  if(nums[i]!==nums[i+1])，则说明num[i+1]是不重复的，此时就将nums[j]赋值为nums[i+1], 非重复数的个数NonDuplicate++
 * 最后再把nums数组中前NonDuplicate个数赋值为nums中各个元素，最后NonDuplicate就是数组中不重复的个数。
 * 时间复杂度：O(n)，因为数组只遍历了一次。
 * 空间复杂度：O(1)，没有利用额外的空间
 */

var removeDuplicates = function(nums) {
    let NonDuplicate =1;
    let n = nums.length;
    let j=0;
    for(let i=0; i<n-1; i++){
        if(nums[i]!==nums[i+1]){
            nums[j] = nums[i+1];
            NonDuplicate++;
            j++;
        }else{
            continue;
        }
    }
    for (;j<n;j++){
        nums.pop();
    }
    return NonDuplicate;
};
```

</div></div>
</div></div>

**类似题目**：
  - [剑指 Offer 41. 数据流中的中位数 🔴](/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/)

</details>
</div>



