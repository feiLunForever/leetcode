<p>English description is not available for the problem. Please switch to Chinese.</p>

<details><summary><strong>Related Topics</strong></summary>队列 | 滑动窗口 | 单调队列 | 堆（优先队列）</details><br>

<div>👍 559, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=hua-dong-chuang-kou-de-zui-da-zhi-lcof" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [239. 滑动窗口最大值](/problems/sliding-window-maximum) 相同。

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 271 页。

使用一个队列充当不断滑动的窗口，每次滑动记录其中的最大值：

![](https://labuladong.github.io/pictures/单调队列/1.png)

如何在 `O(1)` 时间计算最大值，只需要一个特殊的数据结构「单调队列」，`push` 方法依然在队尾添加元素，但是要把前面比自己小的元素都删掉，直到遇到更大的元素才停止删除。

![](https://labuladong.github.io/pictures/单调队列/3.png)

使用单调队列数据结构就能完成本题。

**详细题解：[单调队列结构解决滑动窗口问题](https://labuladong.github.io/article/fname.html?fname=单调队列)**

**标签：[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[滑动窗口](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[队列](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121993002939219969)**

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
    /* 单调队列的实现 */
    class MonotonicQueue {
        deque<int> q;
    public:
        void push(int n) {
            // 将小于 n 的元素全部删除
            while (!q.empty() && q.back() < n) {/**<extend down -300>![](https://labuladong.github.io/pictures/单调队列/3.png) */
                q.pop_back();
            }
            // 然后将 n 加入尾部
            q.push_back(n);
        }

        int max() {
            return q.front();
        }

        void pop(int n) {
            if (n == q.front()) {
                q.pop_front();
            }
        }
    };

public:
    /* 解题函数的实现 */
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        MonotonicQueue window;
        vector<int> res;

        for (int i = 0; i < nums.size(); i++) {
            if (i < k - 1) {
                //先填满窗口的前 k - 1
                window.push(nums[i]);
            } else {/**<extend up -150>![](https://labuladong.github.io/pictures/单调队列/1.png) */
                // 窗口向前滑动，加入新数字
                window.push(nums[i]);
                // 记录当前窗口的最大值
                res.push_back(window.max());
                // 移出旧数字
                window.pop(nums[i - k + 1]);
            }
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    # 单调队列的实现
    class MonotonicQueue:
        def __init__(self):
            self.q = []
        def push(self, n: int) -> None:
            # 将小于 n 的元素全部删除
            while self.q and self.q[-1] < n: # <extend down -300>![](https://labuladong.github.io/pictures/单调队列/3.png) #
                self.q.pop()
            # 然后将 n 加入尾部
            self.q.append(n)

        def max(self) -> int:
            return self.q[0]

        def pop(self, n: int) -> None:
            if n == self.q[0]:
                self.q.pop(0)

    # 解题函数的实现
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        window = self.MonotonicQueue()
        res = []

        for i in range(len(nums)):
            if i < k - 1:
                # 先填满窗口的前 k - 1
                window.push(nums[i])
            else: # <extend up -150>![](https://labuladong.github.io/pictures/单调队列/1.png) #
                # 窗口向前滑动，加入新数字
                window.push(nums[i])
                # 记录当前窗口的最大值
                res.append(window.max())
                # 移出旧数字
                window.pop(nums[i - k + 1])
        
        # 需要转成 int[] 数组再返回
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    /* 单调队列的实现 */
    class MonotonicQueue {
        LinkedList<Integer> q = new LinkedList<>();
        public void push(int n) {
            // 将小于 n 的元素全部删除
            while (!q.isEmpty() && q.getLast() < n) {/**<extend down -300>![](https://labuladong.github.io/pictures/单调队列/3.png) */
                q.pollLast();
            }
            // 然后将 n 加入尾部
            q.addLast(n);
        }

        public int max() {
            return q.getFirst();
        }

        public void pop(int n) {
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }
    }

    /* 解题函数的实现 */
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //先填满窗口的前 k - 1
                window.push(nums[i]);
            } else {/**<extend up -150>![](https://labuladong.github.io/pictures/单调队列/1.png) */
                // 窗口向前滑动，加入新数字
                window.push(nums[i]);
                // 记录当前窗口的最大值
                res.add(window.max());
                // 移出旧数字
                window.pop(nums[i - k + 1]);
            }
        }
        // 需要转成 int[] 数组再返回
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

type MonotonicQueue struct {
    q []int
}

func (mq *MonotonicQueue) push(n int) {
    // 将小于 n 的元素全部删除
    for len(mq.q) > 0 && mq.q[len(mq.q)-1] < n {
        mq.q = mq.q[:len(mq.q)-1]
    }
    // 然后将 n 加入尾部
    mq.q = append(mq.q, n)
}

func (mq *MonotonicQueue) max() int {
    return mq.q[0]
}

func (mq *MonotonicQueue) pop(n int) {
    if n == mq.q[0] {
        mq.q = mq.q[1:]
    }
}

func maxSlidingWindow(nums []int, k int) []int {
    window := &MonotonicQueue{}
    res := []int{}

    for i := 0; i < len(nums); i++ {
        if i < k-1 {
            // 先填满窗口的前 k - 1
            window.push(nums[i])
        } else {
            // 窗口向前滑动，加入新数字
            window.push(nums[i])
            // 记录当前窗口的最大值
            res = append(res, window.max())
            // 移出旧数字
            window.pop(nums[i-k+1])
        }
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

var Solution = function() {
    /* 单调队列的实现 */
    class MonotonicQueue {
        constructor() {
            this.q = [];
        }
        push(n) {
            // 将小于 n 的元素全部删除
            while (this.q.length > 0 && this.q[this.q.length - 1] < n) {/**<extend down -300>![](https://labuladong.github.io/pictures/单调队列/3.png) */
                this.q.pop();
            }
            // 然后将 n 加入尾部
            this.q.push(n);
        }
        max() {
            return this.q[0];
        }
        pop(n) {
            if (n === this.q[0]) {
                this.q.shift();
            }
        }
    }

    /* 解题函数的实现 */
    this.maxSlidingWindow = function(nums, k) {
        const window = new MonotonicQueue();
        const res = [];

        for (let i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                // 先填满窗口的前 k - 1
                window.push(nums[i]);
            } else {/**<extend up -150>![](https://labuladong.github.io/pictures/单调队列/1.png) */
                // 窗口向前滑动，加入新数字
                window.push(nums[i]);
                // 记录当前窗口的最大值
                res.push(window.max());
                // 移出旧数字
                window.pop(nums[i - k + 1]);
            }
        }
        // 需要转成 int[] 数组再返回
        return res;
    }
}
```

</div></div>
</div></div>

**类似题目**：
  - [剑指 Offer 59 - I. 滑动窗口的最大值 🔴](/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof)
  - [剑指 Offer 59 - II. 队列的最大值 🟠](/problems/dui-lie-de-zui-da-zhi-lcof)

</details>
</div>



