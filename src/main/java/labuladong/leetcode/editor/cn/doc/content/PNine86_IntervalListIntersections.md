<p>You are given two lists of closed intervals, <code>firstList</code> and <code>secondList</code>, where <code>firstList[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> and <code>secondList[j] = [start<sub>j</sub>, end<sub>j</sub>]</code>. Each list of intervals is pairwise <strong>disjoint</strong> and in <strong>sorted order</strong>.</p>

<p>Return <em>the intersection of these two interval lists</em>.</p>

<p>A <strong>closed interval</strong> <code>[a, b]</code> (with <code>a &lt;= b</code>) denotes the set of real numbers <code>x</code> with <code>a &lt;= x &lt;= b</code>.</p>

<p>The <strong>intersection</strong> of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of <code>[1, 3]</code> and <code>[2, 4]</code> is <code>[2, 3]</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/01/30/interval1.png" style="width: 700px; height: 194px;" /> 
<pre>
<strong>Input:</strong> firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
<strong>Output:</strong> [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> firstList = [[1,3],[5,9]], secondList = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>0 &lt;= firstList.length, secondList.length &lt;= 1000</code></li> 
 <li><code>firstList.length + secondList.length &gt;= 1</code></li> 
 <li><code>0 &lt;= start<sub>i</sub> &lt; end<sub>i</sub> &lt;= 10<sup>9</sup></code></li> 
 <li><code>end<sub>i</sub> &lt; start<sub>i+1</sub></code></li> 
 <li><code>0 &lt;= start<sub>j</sub> &lt; end<sub>j</sub> &lt;= 10<sup>9</sup> </code></li> 
 <li><code>end<sub>j</sub> &lt; start<sub>j+1</sub></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>

<div>👍 385, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=interval-list-intersections" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

我们用 `[a1, a2]` 和 `[b1, b2]` 表示在 `A` 和 `B` 中的两个区间，如果这两个区间有交集，需满足 `b2 >= a1 && a2 >= b1`，分下面四种情况：

![](https://labuladong.github.io/pictures/intersection/2.jpg)

根据上图可以发现规律，假设交集区间是 `[c1, c2]`，那么 `c1 = max(a1, b1), c2 = min(a2, b2)`：

![](https://labuladong.github.io/pictures/intersection/3.jpg)

这一点就是寻找交集的核心。

**详细题解：[一个方法解决三道区间问题](https://labuladong.github.io/article/fname.html?fname=区间问题合集)**

**标签：[区间问题](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122021012031569922)，[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    vector<vector<int>> intervalIntersection(vector<vector<int>>& A, vector<vector<int>>& B) {
        vector<vector<int>> res;
        int i = 0, j = 0;
        while (i < A.size() && j < B.size()) {
            int a1 = A[i][0], a2 = A[i][1];
            int b1 = B[j][0], b2 = B[j][1];

            if (b2 >= a1 && a2 >= b1) {
                res.push_back({
                    max(a1, b1), min(a2, b2)
                });
            }
            if (b2 < a2) {
                j++;
            } else {
                i++;
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
    def intervalIntersection(self, A: List[List[int]], B: List[List[int]]) -> List[List[int]]:
        res = []
        i, j = 0, 0
        while i < len(A) and j < len(B):
            a1, a2 = A[i][0], A[i][1]
            b1, b2 = B[j][0], B[j][1]

            if b2 >= a1 and a2 >= b1:
                res.append([max(a1, b1), min(a2, b2)])

            if b2 < a2:
                j += 1
            else:
                i += 1

        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new LinkedList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int a1 = A[i][0], a2 = A[i][1];
            int b1 = B[j][0], b2 = B[j][1];

            if (b2 >= a1 && a2 >= b1) {
                res.add(new int[]{
                        Math.max(a1, b1), Math.min(a2, b2)
                });
            }
            if (b2 < a2) {
                j++;
            } else {
                i++;
            }
        }
        return res.toArray(new int[0][0]);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func intervalIntersection(A [][]int, B [][]int) [][]int {
    res := [][]int{}
    i, j := 0, 0
    for i < len(A) && j < len(B) {
        a1, a2 := A[i][0], A[i][1]
        b1, b2 := B[j][0], B[j][1]

        if b2 >= a1 && a2 >= b1 {
            res = append(res, []int{
                max(a1, b1), min(a2, b2),
            })
        }
        if b2 < a2 {
            j++
        } else {
            i++
        }
    }
    return res
}

func max(x, y int) int {
    if x > y {
        return x
    }
    return y
}

func min(x, y int) int {
    if x < y {
        return x
    }
    return y
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var intervalIntersection = function(A, B) {
    const res = [];
    let i = 0, j = 0;
    while (i < A.length && j < B.length) {
        const a1 = A[i][0], a2 = A[i][1];
        const b1 = B[j][0], b2 = B[j][1];

        if (b2 >= a1 && a2 >= b1) {
            res.push([
                Math.max(a1, b1), Math.min(a2, b2)
            ]);
        }
        if (b2 < a2) {
            j++;
        } else {
            i++;
        }
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_interval-list-intersections" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_interval-list-intersections"></div></div>
</details><hr /><br />

**类似题目**：
  - [1288. 删除被覆盖区间 🟠](/problems/remove-covered-intervals)
  - [56. 合并区间 🟠](/problems/merge-intervals)
  - [剑指 Offer II 074. 合并区间 🟠](/problems/SsGoHC)

</details>
</div>



