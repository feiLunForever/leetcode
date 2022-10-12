<p>The <strong>median</strong> is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.</p>

<ul> 
 <li>For example, for <code>arr = [2,3,4]</code>, the median is <code>3</code>.</li> 
 <li>For example, for <code>arr = [2,3]</code>, the median is <code>(2 + 3) / 2 = 2.5</code>.</li> 
</ul>

<p>Implement the MedianFinder class:</p>

<ul> 
 <li><code>MedianFinder()</code> initializes the <code>MedianFinder</code> object.</li> 
 <li><code>void addNum(int num)</code> adds the integer <code>num</code> from the data stream to the data structure.</li> 
 <li><code>double findMedian()</code> returns the median of all elements so far. Answers within <code>10<sup>-5</sup></code> of the actual answer will be accepted.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
<strong>Output</strong>
[null, null, null, 1.5, null, 2.0]

<strong>Explanation</strong>
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>-10<sup>5</sup> &lt;= num &lt;= 10<sup>5</sup></code></li> 
 <li>There will be at least one element in the data structure before calling <code>findMedian</code>.</li> 
 <li>At most <code>5 * 10<sup>4</sup></code> calls will be made to <code>addNum</code> and <code>findMedian</code>.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow up:</strong></p>

<ul> 
 <li>If all integer numbers from the stream are in the range <code>[0, 100]</code>, how would you optimize your solution?</li> 
 <li>If <code>99%</code> of all integer numbers from the stream are in the range <code>[0, 100]</code>, how would you optimize your solution?</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>设计 | 双指针 | 数据流 | 排序 | 堆（优先队列）</details><br>

<div>👍 762, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0，第 12 期刷题打卡 [开始报名](https://aep.xet.tech/s/XhcRc)，点击这里体验 [刷题全家桶](https://labuladong.gitee.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg)。**



<p><strong><a href="https://labuladong.github.io/article?qno=295" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

本题的核心思路是使用两个优先级队列。

![](https://labuladong.github.io/algo/images/中位数/1.jpeg)


小的倒三角就是个大顶堆，梯形就是个小顶堆，中位数可以通过它们的堆顶元素算出来：

![](https://labuladong.github.io/algo/images/中位数/2.jpeg)

**详细题解：[一道求中位数的算法题把我整不会了](https://labuladong.github.io/article/fname.html?fname=数据流中位数)**

**标签：二叉堆，[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

## 解法代码

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

    public double findMedian() {/**<extend up -100>

![](https://labuladong.github.io/algo/images/中位数/2.jpeg)
*/
        // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if (large.size() < small.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        // 如果元素一样多，两个堆堆顶元素的平均数是中位数
        return (large.peek() + small.peek()) / 2.0;/**<extend up -100>

![](https://labuladong.github.io/algo/images/中位数/1.jpeg)
*/
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

**类似题目**：
  - [剑指 Offer 41. 数据流中的中位数 🔴](/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/)

</details>
</div>



