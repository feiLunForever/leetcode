<p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <em>the</em> <code>k<sup>th</sup></code> <em>largest element in the array</em>.</p>

<p>Note that it is the <code>k<sup>th</sup></code> largest element in the sorted order, not the <code>k<sup>th</sup></code> distinct element.</p>

<p>You must solve it in <code>O(n)</code> time complexity.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<pre><strong>Input:</strong> nums = [3,2,1,5,6,4], k = 2
<strong>Output:</strong> 5
</pre>
<p><strong class="example">Example 2:</strong></p> 
<pre><strong>Input:</strong> nums = [3,2,3,1,2,4,5,5,6], k = 4
<strong>Output:</strong> 4
</pre> 
<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= k &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 分治 | 快速选择 | 排序 | 堆（优先队列）</details><br>

<div>👍 2179, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=kth-largest-element-in-an-array" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

二叉堆的解法比较简单，实际写算法题的时候，推荐大家写这种解法。

可以把小顶堆 `pq` 理解成一个筛子，较大的元素会沉淀下去，较小的元素会浮上来；当堆大小超过 `k` 的时候，我们就删掉堆顶的元素，因为这些元素比较小，而我们想要的是前 `k` 个最大元素嘛。

当 `nums` 中的所有元素都过了一遍之后，筛子里面留下的就是最大的 `k` 个元素，而堆顶元素是堆中最小的元素，也就是「第 `k` 个最大的元素」。

二叉堆插入和删除的时间复杂度和堆中的元素个数有关，在这里我们堆的大小不会超过 `k`，所以插入和删除元素的复杂度是 `O(logK)`，再套一层 for 循环，总的时间复杂度就是 `O(NlogK)`。

当然，这道题可以有效率更高的解法叫「快速选择算法」，只需要 `O(N)` 的时间复杂度。

快速选择算法不用借助二叉堆结构，而是稍微改造了快速排序的算法思路，有兴趣的读者可以看详细题解。

**详细题解：[快速排序详解及应用](https://labuladong.github.io/article/fname.html?fname=快速排序)**

**标签：二叉堆，快速选择算法，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    int findKthLargest(vector<int>& nums, int k) {
        // 小顶堆，堆顶是最小元素
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int e : nums) {
            // 每个元素都要过一遍二叉堆
            pq.push(e);
            // 堆中元素多于 k 个时，删除堆顶元素
            if (pq.size() > k) {
                pq.pop();
            }
        }
        // pq 中剩下的是 nums 中 k 个最大元素，
        // 堆顶是最小的那个，即第 k 个最大元素
        return pq.top();
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

import heapq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # 小顶堆，堆顶是最小元素
        pq = []
        for e in nums:
            # 每个元素都要过一遍二叉堆
            heapq.heappush(pq, e)
            # 堆中元素多于 k 个时，删除堆顶元素
            if len(pq) > k:
                heapq.heappop(pq)
        # pq 中剩下的是 nums 中 k 个最大元素，
        # 堆顶是最小的那个，即第 k 个最大元素
        return pq[0]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 小顶堆，堆顶是最小元素
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int e : nums) {
            // 每个元素都要过一遍二叉堆
            pq.offer(e);
            // 堆中元素多于 k 个时，删除堆顶元素
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // pq 中剩下的是 nums 中 k 个最大元素，
        // 堆顶是最小的那个，即第 k 个最大元素
        return pq.peek();
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

func findKthLargest(nums []int, k int) int {
    // 小顶堆，堆顶是最小元素
    pq := priorityQueue{}
    for _, e := range nums {
        // 每个元素都要过一遍二叉堆
        pq.offer(e)
        // 堆中元素多于 k 个时，删除堆顶元素
        if pq.size() > k {
            pq.poll()
        }
    }
    // pq 中剩下的是 nums 中 k 个最大元素，
    // 堆顶是最小的那个，即第 k 个最大元素
    return pq.peek()
}

type priorityQueue []int

func (pq *priorityQueue) Len() int { return len(*pq) }

func (pq *priorityQueue) Less(i, j int) bool { return (*pq)[i] < (*pq)[j] }

func (pq *priorityQueue) Swap(i, j int) { (*pq)[i], (*pq)[j] = (*pq)[j], (*pq)[i] }

func (pq *priorityQueue) Push(x interface{}) { *pq = append(*pq, x.(int)) }

func (pq *priorityQueue) Pop() interface{} {
    old := *pq
    n := len(old)
    x := old[n-1]
    *pq = old[0 : n-1]
    return x
}

func (pq *priorityQueue) offer(e int) { heap.Push(pq, e) }

func (pq *priorityQueue) poll() int { return heap.Pop(pq).(int) }

func (pq *priorityQueue) peek() int { return (*pq)[0] }
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

var findKthLargest = function(nums, k) {
    // 小顶堆，堆顶是最小元素
    let pq = new PriorityQueue();
    for (let e of nums) {
        // 每个元素都要过一遍二叉堆
        pq.offer(e);
        // 堆中元素多于 k 个时，删除堆顶元素
        if (pq.size() > k) {
            pq.poll();
        }
    }
    // pq 中剩下的是 nums 中 k 个最大元素，
    // 堆顶是最小的那个，即第 k 个最大元素
    return pq.peek();
};

// JavaScript 的 PriorityQueue 实现可能不太一样，这里只是一个简单实现作为例子
class PriorityQueue {
    constructor() {
        this.data = [];
    }
    offer(val) {
        this.data.push(val);
        this.bubbleUp(this.size() - 1);
    }
    poll() {
        if (this.size() === 0) {
            return undefined;
        }
        const result = this.data[0];
        const last = this.data.pop();
        if (this.size() !== 0) {
            this.data[0] = last;
            this.bubbleDown(0);
        }
        return result;
    }
    peek() {
        return this.size() === 0 ? undefined : this.data[0];
    }
    size() {
        return this.data.length;
    }
    bubbleUp(index) {
        while (index > 0) {
            const parentIndex = Math.floor((index - 1) / 2);
            if (this.data[index] >= this.data[parentIndex]) {
                break;
            }
            this.swap(index, parentIndex);
            index = parentIndex;
        }
    }
    bubbleDown(index) {
        while (STATUS_PASSED_TEST) {
            const leftChildIndex = index * 2 + 1;
            const rightChildIndex = index * 2 + 2;
            let smallestChildIndex = index;
            if (leftChildIndex < this.size() && this.data[leftChildIndex] < this.data[smallestChildIndex]) {
                smallestChildIndex = leftChildIndex;
            }
            if (rightChildIndex < this.size() && this.data[rightChildIndex] < this.data[smallestChildIndex]) {
                smallestChildIndex = rightChildIndex;
            }
            if (smallestChildIndex === index) {
                break;
            }
            this.swap(index, smallestChildIndex);
            index = smallestChildIndex;
        }
    }
    swap(i, j) {
        [this.data[i], this.data[j]] = [this.data[j], this.data[i]];
    }
}
```

</div></div>
</div></div>

**类似题目**：
  - [347. 前 K 个高频元素 🟠](/problems/top-k-frequent-elements)
  - [703. 数据流中的第 K 大元素 🟢](/problems/kth-largest-element-in-a-stream)
  - [912. 排序数组 🟠](/problems/sort-an-array)
  - [剑指 Offer 40. 最小的k个数 🟢](/problems/zui-xiao-de-kge-shu-lcof)
  - [剑指 Offer II 059. 数据流的第 K 大数值 🟢](/problems/jBjn9C)
  - [剑指 Offer II 060. 出现频率最高的 k 个数字 🟠](/problems/g5c51o)
  - [剑指 Offer II 076. 数组中的第 k 大的数字 🟠](/problems/xx4gT2)

</details>
</div>



