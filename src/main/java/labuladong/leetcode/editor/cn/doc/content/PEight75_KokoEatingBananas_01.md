<p>Koko loves to eat bananas. There are <code>n</code> piles of bananas, the <code>i<sup>th</sup></code> pile has <code>piles[i]</code> bananas. The guards have gone and will come back in <code>h</code> hours.</p>

<p>Koko can decide her bananas-per-hour eating speed of <code>k</code>. Each hour, she chooses some pile of bananas and eats <code>k</code> bananas from that pile. If the pile has less than <code>k</code> bananas, she eats all of them instead and will not eat any more bananas during this hour.</p>

<p>Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.</p>

<p>Return <em>the minimum integer</em> <code>k</code> <em>such that she can eat all the bananas within</em> <code>h</code> <em>hours</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> piles = [3,6,7,11], h = 8
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> piles = [30,11,23,4,20], h = 5
<strong>Output:</strong> 30
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> piles = [30,11,23,4,20], h = 6
<strong>Output:</strong> 23
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= piles.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>piles.length &lt;= h &lt;= 10<sup>9</sup></code></li> 
 <li><code>1 &lt;= piles[i] &lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>

<div>👍 522, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 最后一天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=koko-eating-bananas" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 360 页。

正如 [二分搜索思路运用篇](https://labuladong.github.io/article/fname.html?fname=二分运用) 所说，二分搜索的套路比较固定，如果遇到一个算法问题，能够确定 `x, f(x), target` 分别是什么，并写出单调函数 `f` 的代码，那么就可以运用二分搜索的思路求解。

这题珂珂吃香蕉的速度 `K` 就是自变量 `x`，吃完所有香蕉所需的时间就是单调函数 `f(x)`，`target` 就是吃香蕉的时间限制 `H`。我们需要调整 `x`，使得 `f(x)` 尽可能接近 `target`，也就是说，我们需要找到最小的 `x`，使得 `f(x) <= target`。

它们的关系如下图：

![](https://labuladong.github.io/pictures/二分运用/4.jpeg)

关于本题二分搜索的具体思路见详细题解。

**详细题解：[二分搜索怎么用？我又总结了套路](https://labuladong.github.io/article/fname.html?fname=二分运用)**

**标签：[二分搜索](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    int minEatingSpeed(vector<int>& piles, int H) {
        int left = 1;
        int right = 1000000000 + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) <= H) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 定义：速度为 x 时，需要 f(x) 小时吃完所有香蕉
    // f(x) 随着 x 的增加单调递减
    int f(vector<int>& piles, int x) {
        int hours = 0;
        for (int i = 0; i < piles.size(); i++) {
            hours += piles[i] / x;
            if (piles[i] % x > 0) {
                hours++;
            }
        }
        return hours;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def minEatingSpeed(self, piles: List[int], H: int) -> int:
        left = 1
        right = 1000000000 + 1

        while left < right:
            mid = left + (right - left) // 2
            if self.f(piles, mid) <= H:
                right = mid
            else:
                left = mid + 1
        return left

    # 定义：速度为 x 时，需要 f(x) 小时吃完所有香蕉
    # f(x) 随着 x 的增加单调递减
    def f(self, piles: List[int], x: int) -> int:
        hours = 0
        for i in range(len(piles)):
            hours += piles[i] // x
            if piles[i] % x > 0:
                hours += 1
        return hours
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = 1000000000 + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) <= H) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 定义：速度为 x 时，需要 f(x) 小时吃完所有香蕉
    // f(x) 随着 x 的增加单调递减
    int f(int[] piles, int x) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / x;
            if (piles[i] % x > 0) {
                hours++;
            }
        }
        return hours;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func minEatingSpeed(piles []int, H int) int {
	left, right := 1, 1000000000+1

	for left < right {
		mid := left + (right-left)/2
		if f(piles, mid) <= H {
			right = mid
		} else {
			left = mid + 1
		}
	}

	return left
}

// 定义：速度为 x 时，需要 f(x) 小时吃完所有香蕉
// f(x) 随着 x 的增加单调递减
func f(piles []int, x int) int {
	hours := 0
	for i := 0; i < len(piles); i++ {
		hours += piles[i] / x
		if piles[i]%x > 0 {
			hours++
		}
	}
	return hours
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var minEatingSpeed = function(piles, H) {
    let left = 1;
    let right = 1000000000 + 1;

    while (left < right) {
        let mid = left + Math.floor((right - left) / 2);
        if (f(piles, mid) <= H) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;
};

// 定义：速度为 x 时，需要 f(x) 小时吃完所有香蕉
// f(x) 随着 x 的增加单调递减
var f = function(piles, x) {
    let hours = 0;
    for (let i = 0; i < piles.length; i++) {
        hours += Math.floor(piles[i] / x);
        if (piles[i] % x > 0) {
            hours++;
        }
    }
    return hours;
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_koko-eating-bananas" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_koko-eating-bananas"></div></div>
</details><hr /><br />

**类似题目**：
  - [1011. 在 D 天内送达包裹的能力 🟠](/problems/capacity-to-ship-packages-within-d-days)
  - [410. 分割数组的最大值 🔴](/problems/split-array-largest-sum)
  - [剑指 Offer II 073. 狒狒吃香蕉 🟠](/problems/nZZqjQ)

</details>
</div>



