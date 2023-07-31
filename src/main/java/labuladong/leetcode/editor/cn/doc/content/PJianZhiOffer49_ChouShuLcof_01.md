English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>哈希表 | 数学 | 动态规划 | 堆（优先队列）</details><br>

<div>👍 486, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 最后一天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=chou-shu-lcof" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [264. 丑数 II](/problems/ugly-number-ii) 相同。

这道题很精妙，你看着它好像是道数学题，实际上它却是一个合并多个有序链表的问题，同时用到了筛选素数的思路。

建议你先做一下 [链表双指针技巧汇总](https://labuladong.github.io/article/fname.html?fname=链表技巧) 中讲到的 [21. 合并两个有序链表（简单）](/problems/merge-two-sorted-lists)，然后再做一下 [如何高效寻找素数](https://labuladong.github.io/article/fname.html?fname=打印素数) 中讲的 [204. 计数质数（简单）](/problems/count-primes)，这样的话就能比较容易理解这道题的思路了。

**类似 [如何高效寻找素数](https://labuladong.github.io/article/fname.html?fname=打印素数) 的思路：如果一个数 `x` 是丑数，那么 `x * 2, x * 3, x * 5` 都一定是丑数**。

我们把所有丑数想象成一个从小到大排序的链表，就是这个样子：

```java
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 8 -> ...
```

然后，我们可以把丑数分为三类：2 的倍数、3 的倍数、5 的倍数（按照题目的意思，1 算作特殊的丑数，放在开头），这三类丑数就好像三条有序链表，如下：

能被 2 整除的丑数：

```java
1 -> 1*2 -> 2*2 -> 3*2 -> 4*2 -> 5*2 -> 6*2 -> 8*2 ->...
```

能被 3 整除的丑数：

```java
1 -> 1*3 -> 2*3 -> 3*3 -> 4*3 -> 5*3 -> 6*3 -> 8*3 ->...
```

能被 5 整除的丑数：

```java
1 -> 1*5 -> 2*5 -> 3*5 -> 4*5 -> 5*5 -> 6*5 -> 8*5 ->...
```

我们其实就是想把这三条「有序链表」合并在一起并去重，合并的结果就是丑数的序列。然后求合并后的这条有序链表中第 `n` 个元素是什么。所以这里就和 [链表双指针技巧汇总](https://labuladong.github.io/article/fname.html?fname=链表技巧) 中讲到的合并 `k` 条有序链表的思路基本一样了。

具体思路看注释吧，你也可以对照我在 [21. 合并两个有序链表（简单）](/problems/merge-two-sorted-lists) 中给出的思路代码来看本题的思路代码，就能轻松看懂本题的解法代码了。

**详细题解：[丑数系列算法详解](https://labuladong.github.io/article/fname.html?fname=丑数)**

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
    int nthUglyNumber(int n) {
        // 可以理解为三个指向有序链表头结点的指针
        int p2 = 1, p3 = 1, p5 = 1;
        // 可以理解为三个有序链表的头节点的值
        int product2 = 1, product3 = 1, product5 = 1;
        // 可以理解为最终合并的有序链表（结果链表）
        int ugly[n + 1];
        // 可以理解为结果链表上的指针
        int p = 1;

        // 开始合并三个有序链表
        while (p <= n) {
            // 取三个链表的最小结点
            int minVal = min({product2, product3, product5});
            // 接到结果链表上
            ugly[p] = minVal;
            p++;
            // 前进对应有序链表上的指针
            if (minVal == product2) {
                product2 = 2 * ugly[p2];
                p2++;
            }
            if (minVal == product3) {
                product3 = 3 * ugly[p3];
                p3++;
            }
            if (minVal == product5) {
                product5 = 5 * ugly[p5];
                p5++;
            }
        }
        // 返回第 n 个丑数
        return ugly[n];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        # 可以理解为三个指向有序链表头结点的指针
        p2, p3, p5 = 1, 1, 1
        # 可以理解为三个有序链表的头节点的值
        product2, product3, product5 = 1, 1, 1
        # 可以理解为最终合并的有序链表（结果链表）
        ugly = [0] * (n+1)
        # 可以理解为结果链表上的指针
        p = 1

        # 开始合并三个有序链表
        while p <= n:
            # 取三个链表的最小结点
            min_val = min(product2, product3, product5)
            # 接到结果链表上
            ugly[p] = min_val
            p += 1
            # 前进对应有序链表上的指针
            if min_val == product2:
                product2 = 2 * ugly[p2]
                p2 += 1
            if min_val == product3:
                product3 = 3 * ugly[p3]
                p3 += 1
            if min_val == product5:
                product5 = 5 * ugly[p5]
                p5 += 1

        # 返回第 n 个丑数
        return ugly[n]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int nthUglyNumber(int n) {
        // 可以理解为三个指向有序链表头结点的指针
        int p2 = 1, p3 = 1, p5 = 1;
        // 可以理解为三个有序链表的头节点的值
        int product2 = 1, product3 = 1, product5 = 1;
        // 可以理解为最终合并的有序链表（结果链表）
        int[] ugly = new int[n + 1];
        // 可以理解为结果链表上的指针
        int p = 1;

        // 开始合并三个有序链表
        while (p <= n) {
            // 取三个链表的最小结点
            int min = Math.min(Math.min(product2, product3), product5);
            // 接到结果链表上
            ugly[p] = min;
            p++;
            // 前进对应有序链表上的指针
            if (min == product2) {
                product2 = 2 * ugly[p2];
                p2++;
            }
            if (min == product3) {
                product3 = 3 * ugly[p3];
                p3++;
            }
            if (min == product5) {
                product5 = 5 * ugly[p5];
                p5++;
            }
        }
        // 返回第 n 个丑数
        return ugly[n];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func nthUglyNumber(n int) int {
    // 可以理解为三个指向有序链表头结点的指针
    p2, p3, p5 := 1, 1, 1
    // 可以理解为三个有序链表的头节点的值
    product2, product3, product5 := 1, 1, 1
    // 可以理解为最终合并的有序链表（结果链表）
    ugly := make([]int, n+1)
    // 可以理解为结果链表上的指针
    p := 1

    // 开始合并三个有序链表
    for p <= n {
        // 取三个链表的最小结点
        min := min(min(product2, product3), product5)
        // 接到结果链表上
        ugly[p] = min
        p++
        // 前进对应有序链表上的指针
        if min == product2 {
            product2 = 2 * ugly[p2]
            p2++
        }
        if min == product3 {
            product3 = 3 * ugly[p3]
            p3++
        }
        if min == product5 {
            product5 = 5 * ugly[p5]
            p5++
        }
    }
    // 返回第 n 个丑数
    return ugly[n]
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

var nthUglyNumber = function(n) {
    // 可以理解为三个指向有序链表头结点的指针
    let p2 = 1, p3 = 1, p5 = 1;
    // 可以理解为三个有序链表的头节点的值
    let product2 = 1, product3 = 1, product5 = 1;
    // 可以理解为最终合并的有序链表（结果链表）
    let ugly = new Array(n+1);
    // 可以理解为结果链表上的指针
    let p = 1;

    // 开始合并三个有序链表
    while (p <= n) {
        // 取三个链表的最小结点
        let min = Math.min(Math.min(product2, product3), product5);
        // 接到结果链表上
        ugly[p] = min;
        p++;
        // 前进对应有序链表上的指针
        if (min === product2) {
            product2 = 2 * ugly[p2];
            p2++;
        }
        if (min === product3) {
            product3 = 3 * ugly[p3];
            p3++;
        }
        if (min === product5) {
            product5 = 5 * ugly[p5];
            p5++;
        }
    }
    // 返回第 n 个丑数
    return ugly[n];
};
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_ugly-number-ii" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_ugly-number-ii"></div></div>
</details><hr /><br />

**类似题目**：
  - [1201. 丑数 III 🟠](/problems/ugly-number-iii)
  - [263. 丑数 🟢](/problems/ugly-number)
  - [313. 超级丑数 🟠](/problems/super-ugly-number)
  - [剑指 Offer 49. 丑数 🟠](/problems/chou-shu-lcof)

</details>
</div>



