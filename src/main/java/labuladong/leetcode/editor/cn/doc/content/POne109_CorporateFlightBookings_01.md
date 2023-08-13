<p>There are <code>n</code> flights that are labeled from <code>1</code> to <code>n</code>.</p>

<p>You are given an array of flight bookings <code>bookings</code>, where <code>bookings[i] = [first<sub>i</sub>, last<sub>i</sub>, seats<sub>i</sub>]</code> represents a booking for flights <code>first<sub>i</sub></code> through <code>last<sub>i</sub></code> (<strong>inclusive</strong>) with <code>seats<sub>i</sub></code> seats reserved for <strong>each flight</strong> in the range.</p>

<p>Return <em>an array </em><code>answer</code><em> of length </em><code>n</code><em>, where </em><code>answer[i]</code><em> is the total number of seats reserved for flight </em><code>i</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
<strong>Output:</strong> [10,55,45,25,25]
<strong>Explanation:</strong>
Flight labels:        1   2   3   4   5
Booking 1 reserved:  10  10
Booking 2 reserved:      20  20
Booking 3 reserved:      25  25  25  25
Total seats:         10  55  45  25  25
Hence, answer = [10,55,45,25,25]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> bookings = [[1,2,10],[2,2,15]], n = 2
<strong>Output:</strong> [10,25]
<strong>Explanation:</strong>
Flight labels:        1   2
Booking 1 reserved:  10  10
Booking 2 reserved:      15
Total seats:         10  25
Hence, answer = [10,25]

</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= bookings.length &lt;= 2 * 10<sup>4</sup></code></li> 
 <li><code>bookings[i].length == 3</code></li> 
 <li><code>1 &lt;= first<sub>i</sub> &lt;= last<sub>i</sub> &lt;= n</code></li> 
 <li><code>1 &lt;= seats<sub>i</sub> &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 前缀和</details><br>

<div>👍 475, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=corporate-flight-bookings" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题考察差分数组技巧，差分数组技巧适用于频繁对数组区间进行增减的场景。

核心原理：

1、构造差分数组：

```java
int[] diff = new int[nums.length];
// 构造差分数组
diff[0] = nums[0];
for (int i = 1; i < nums.length; i++) {
    diff[i] = nums[i] - nums[i - 1];
}
```

![](https://labuladong.github.io/pictures/差分数组/2.jpeg)

2、还原原始数组：

```java
int[] res = new int[diff.length];
// 根据差分数组构造结果数组
res[0] = diff[0];
for (int i = 1; i < diff.length; i++) {
    res[i] = res[i - 1] + diff[i];
}
```

2、进行区间增减，如果你想对区间 `nums[i..j]` 的元素全部加 3，那么只需要让 `diff[i] += 3`，然后再让 `diff[j+1] -= 3` 即可：

![](https://labuladong.github.io/pictures/差分数组/3.jpeg)

本题就相当于给你输入一个长度为 `n` 的数组 `nums`，其中所有元素都是 0，然后让你进行一系列区间加减操作，可以套用差分数组技巧。

**详细题解：[小而美的算法技巧：差分数组](https://labuladong.github.io/article/fname.html?fname=差分技巧)**

**标签：差分数组，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    vector<int> corpFlightBookings(vector<vector<int>>& bookings, int n) {
        // nums 初始化为全 0
        vector<int> nums(n);
        // 构造差分解法
        Difference df(nums);

        for (auto& booking : bookings) {
            // 注意转成数组索引要减一哦
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            // 对区间 nums[i..j] 增加 val
            df.increment(i, j, val);
        }
        // 返回最终的结果数组
        return df.result();
    }

private:
    class Difference {
        // 差分数组
        vector<int> diff;

    public:
        Difference(vector<int>& nums) {
            assert(nums.size() > 0);
            diff = vector<int>(nums.size());
            // 构造差分数组
            diff[0] = nums[0];
            for (int i = 1; i < nums.size(); i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        /* 给闭区间 [i, j] 增加 val（可以是负数）*/
        void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.size()) {
                diff[j + 1] -= val;
            }
        }

        vector<int> result() {
            vector<int> res(diff.size());
            // 根据差分数组构造结果数组
            res[0] = diff[0];
            for (int i = 1; i < diff.size(); i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    };
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        # nums 初始化为全 0
        nums = [0] * n
        # 构造差分解法
        df = Difference(nums)

        for booking in bookings:
            # 注意转成数组索引要减一哦
            i, j, val = booking[0] - 1, booking[1] - 1, booking[2]
            # 对区间 nums[i..j] 增加 val
            df.increment(i, j, val)
        # 返回最终的结果数组
        return df.result()

    class Difference:
        # 差分数组
        def __init__(self, nums: List[int]):
            assert len(nums) > 0
            self.diff = [0] * len(nums)
            # 构造差分数组
            self.diff[0] = nums[0]
            for i in range(1, len(nums)):
                self.diff[i] = nums[i] - nums[i - 1]

        # 给闭区间 [i, j] 增加 val（可以是负数）
        def increment(self, i: int, j: int, val: int) -> None:
            self.diff[i] += val
            if j + 1 < len(self.diff):
                self.diff[j + 1] -= val

        def result(self) -> List[int]:
            res = [0] * len(self.diff)
            # 根据差分数组构造结果数组
            res[0] = self.diff[0]
            for i in range(1, len(self.diff)):
                res[i] = res[i - 1] + self.diff[i]
            return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // nums 初始化为全 0
        int[] nums = new int[n];
        // 构造差分解法
        Difference df = new Difference(nums);

        for (int[] booking : bookings) {
            // 注意转成数组索引要减一哦
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            // 对区间 nums[i..j] 增加 val
            df.increment(i, j, val);
        }
        // 返回最终的结果数组
        return df.result();
    }

    class Difference {
        // 差分数组
        private int[] diff;

        public Difference(int[] nums) {
            assert nums.length > 0;
            diff = new int[nums.length];
            // 构造差分数组
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        /* 给闭区间 [i, j] 增加 val（可以是负数）*/
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            // 根据差分数组构造结果数组
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }

}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func corpFlightBookings(bookings [][]int, n int) []int {
    // nums 初始化为全 0
    nums := make([]int, n)
    // 构造差分解法
    df := Difference{nums}

    for _, booking := range bookings {
        // 注意转成数组索引要减一哦
        i := booking[0] - 1
        j := booking[1] - 1
        val := booking[2]
        // 对区间 nums[i..j] 增加 val
        df.increment(i, j, val)
    }
    // 返回最终的结果数组
    return df.result()
}

type Difference struct {
    // 差分数组
    diff []int
}

func (df *Difference) increment(i, j, val int) {
    df.diff[i] += val
    if j+1 < len(df.diff) {
        df.diff[j+1] -= val
    }
}

func (df *Difference) result() []int {
    res := make([]int, len(df.diff))
    // 根据差分数组构造结果数组
    res[0] = df.diff[0]
    for i := 1; i < len(df.diff); i++ {
        res[i] = res[i-1] + df.diff[i]
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var corpFlightBookings = function(bookings, n) {
    // nums 初始化为全 0
    let nums = new Array(n).fill(0);
    // 构造差分解法
    let df = new Difference(nums);

    for (let booking of bookings) {
        // 注意转成数组索引要减一哦
        let i = booking[0] - 1;
        let j = booking[1] - 1;
        let val = booking[2];
        // 对区间 nums[i..j] 增加 val
        df.increment(i, j, val);
    }
    // 返回最终的结果数组
    return df.result();
}

class Difference {
    // 差分数组
    constructor(nums) {
        if (nums.length <= 0) {
            throw new Error('nums array should not be empty');
        }
        this.diff = new Array(nums.length).fill(0);
        // 构造差分数组
        this.diff[0] = nums[0];
        for (let i = 1; i < nums.length; i++) {
            this.diff[i] = nums[i] - nums[i - 1];
        }
    }

    /* 给闭区间 [i, j] 增加 val（可以是负数）*/
    increment(i, j, val) {
        this.diff[i] += val;
        if (j + 1 < this.diff.length) {
            this.diff[j + 1] -= val;
        }
    }

    result() {
        let res = new Array(this.diff.length).fill(0);
        // 根据差分数组构造结果数组
        res[0] = this.diff[0];
        for (let i = 1; i < this.diff.length; i++) {
            res[i] = res[i - 1] + this.diff[i];
        }
        return res;
    }
}
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_corporate-flight-bookings" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_corporate-flight-bookings"></div></div>
</details><hr /><br />

**类似题目**：
  - [1094. 拼车 🟠](/problems/car-pooling)
  - [370. 区间加法 🟠](/problems/range-addition)

</details>
</div>



