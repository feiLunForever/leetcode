<p>Let <code>f(x)</code> be the number of zeroes at the end of <code>x!</code>. Recall that <code>x! = 1 * 2 * 3 * ... * x</code> and by convention, <code>0! = 1</code>.</p>

<ul> 
 <li>For example, <code>f(3) = 0</code> because <code>3! = 6</code> has no zeroes at the end, while <code>f(11) = 2</code> because <code>11! = 39916800</code> has two zeroes at the end.</li> 
</ul>

<p>Given an integer <code>k</code>, return the number of non-negative integers <code>x</code> have the property that <code>f(x) = k</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> k = 0
<strong>Output:</strong> 5
<strong>Explanation:</strong> 0!, 1!, 2!, 3!, and 4! end with k = 0 zeroes.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> k = 5
<strong>Output:</strong> 0
<strong>Explanation:</strong> There is no x such that x! ends in k = 5 zeroes.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> k = 3
<strong>Output:</strong> 5
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>0 &lt;= k &lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数学 | 二分查找</details><br>

<div>👍 206, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=preimage-size-of-factorial-zeroes-function" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题需要复用 [172. 阶乘后的零](/problems/factorial-trailing-zeroes) 这道题的解法函数 `trailingZeroes`。

搜索有多少个 `n` 满足 `trailingZeroes(n) == K`，其实就是在问，满足条件的 `n` 最小是多少，最大是多少，最大值和最小值一减，就可以算出来有多少个 `n` 满足条件了，对吧？那不就是 [二分查找](https://labuladong.github.io/article/fname.html?fname=二分查找详解) 中「搜索左侧边界」和「搜索右侧边界」这两个事儿嘛？

观察题目给出的数据取值范围，`n` 可以在区间 `[0, LONG_MAX]` 中取值，寻找满足 `trailingZeroes(n) == K` 的左侧边界和右侧边界，相减即是答案。

**详细题解：[讲两道常考的阶乘算法题](https://labuladong.github.io/article/fname.html?fname=阶乘题目)**

**标签：[二分搜索](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

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
    int preimageSizeFZF(int K) {
        // 左边界和右边界之差 + 1 就是答案
        return (int)(right_bound(K) - left_bound(K) + 1);
    }

    // 逻辑不变，数据类型全部改成 long
    long trailingZeroes(long n) {
        long res = 0;
        for (long d = n; d / 5 > 0; d = d / 5) {
            res += d / 5;
        }
        return res;
    }

    /* 搜索 trailingZeroes(n) == K 的左侧边界 */
    long left_bound(int target) {
        long lo = 0, hi = LONG_MAX;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /* 搜索 trailingZeroes(n) == K 的右侧边界 */
    long right_bound(int target) {
        long lo = 0, hi = LONG_MAX;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo - 1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution:
    def preimageSizeFZF(self, K: int) -> int:
        # 左边界和右边界之差 + 1 就是答案
        return int(self.right_bound(K) - self.left_bound(K) + 1)

    # 逻辑不变，数据类型全部改成 long
    def trailingZeroes(self, n: int) -> int:
        res = 0
        for d in range(n, 0, -1):
            while d % 5 == 0:
                res += 1 
                d //= 5
        return res
        
    """ 搜索 trailingZeroes(n) == K 的左侧边界 """
    def left_bound(self, target: int) -> int:
        lo, hi = 0, float('inf')
        while lo < hi:
            mid = lo + (hi - lo) // 2
            if self.trailingZeroes(mid) < target:
                lo = mid + 1
            elif self.trailingZeroes(mid) > target:
                hi = mid 
            else:
                hi = mid
                
        return lo
        
    
    """ 搜索 trailingZeroes(n) == K 的右侧边界 """
    def right_bound(self, target: int) -> int:
        lo, hi = 0, float('inf')
        while lo < hi:
            mid = lo + (hi - lo) // 2
            if self.trailingZeroes(mid) < target:
                lo = mid + 1
            elif self.trailingZeroes(mid) > target:
                hi = mid
            else:
                lo = mid + 1
                
        return lo - 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int preimageSizeFZF(int K) {
        // 左边界和右边界之差 + 1 就是答案
        return (int)(right_bound(K) - left_bound(K) + 1);
    }

    // 逻辑不变，数据类型全部改成 long
    long trailingZeroes(long n) {
        long res = 0;
        for (long d = n; d / 5 > 0; d = d / 5) {
            res += d / 5;
        }
        return res;
    }

    /* 搜索 trailingZeroes(n) == K 的左侧边界 */
    long left_bound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /* 搜索 trailingZeroes(n) == K 的右侧边界 */
    long right_bound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo - 1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

import "math"

func preimageSizeFZF(K int) int {
    // 左边界和右边界之差 + 1 就是答案
    return int(right_bound(K) - left_bound(K) + 1)
}

// 逻辑不变，数据类型全部改成 int64
func trailingZeroes(n int64) int64 {
    var res int64 = 0
    for d := n; d / 5 > 0; d = d / 5 {
        res += d / 5
    }
    return res
}

/* 搜索 trailingZeroes(n) == K 的左侧边界 */
func left_bound(target int) int64 {
    var lo, hi int64 = 0, math.MaxInt64
    for lo < hi {
        mid := lo + (hi - lo) / 2
        if trailingZeroes(mid) < int64(target) {
            lo = mid + 1
        } else if trailingZeroes(mid) > int64(target) {
            hi = mid
        } else {
            hi = mid
        }
    }
    return lo
}

/* 搜索 trailingZeroes(n) == K 的右侧边界 */
func right_bound(target int) int64 {
    var lo, hi int64 = 0, math.MaxInt64
    for lo < hi {
        mid := lo + (hi - lo) / 2
        if trailingZeroes(mid) < int64(target) {
            lo = mid + 1
        } else if trailingZeroes(mid) > int64(target) {
            hi = mid
        } else {
            lo = mid + 1
        }
    }

    return lo - 1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var preimageSizeFZF = function (K) {
  // 左边界和右边界之差 + 1 就是答案
  return right_bound(K) - left_bound(K) + 1;
};

// 逻辑不变，数据类型全部改成 long
var trailingZeroes = function (n) {
  var res = 0;
  for (var d = n; Math.floor(d / 5) > 0; d = Math.floor(d / 5)) {
    res += Math.floor(d / 5);
  }
  return res;
};

/* 搜索 trailingZeroes(n) == K 的左侧边界 */
var left_bound = function (target) {
  var lo = 0,
    hi = Number.MAX_VALUE;
  while (lo < hi) {
    var mid = lo + Math.floor((hi - lo) / 2);
    if (trailingZeroes(mid) < target) {
      lo = mid + 1;
    } else if (trailingZeroes(mid) > target) {
      hi = mid;
    } else {
      hi = mid;
    }
  }
  return lo;
};

/* 搜索 trailingZeroes(n) == K 的右侧边界 */
var right_bound = function (target) {
  var lo = 0,
    hi = Number.MAX_VALUE;
  while (lo < hi) {
    var mid = lo + Math.floor((hi - lo) / 2);
    if (trailingZeroes(mid) < target) {
      lo = mid + 1;
    } else if (trailingZeroes(mid) > target) {
      hi = mid;
    } else {
      lo = mid + 1;
    }
  }

  return lo - 1;
};
```

</div></div>
</div></div>

**类似题目**：
  - [172. 阶乘后的零 🟠](/problems/factorial-trailing-zeroes)

</details>
</div>



