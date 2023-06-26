<p>Given an integer <code>n</code>, return <em>the number of prime numbers that are strictly less than</em> <code>n</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 10
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 0
<strong>Output:</strong> 0
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>0 &lt;= n &lt;= 5 * 10<sup>6</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 数学 | 枚举 | 数论</details><br>

<div>👍 1068, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=count-primes" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 351 页。

筛数法是常见的计算素数的算法。

因为判断一个数字是否是素数的时间成本较高，所以我们不要一个个判断每个数字是否是素数，而是用排除法，把所有非素数都排除，剩下的就是素数。

**详细题解：[如何高效寻找素数](https://labuladong.github.io/article/fname.html?fname=打印素数)**

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

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
    int countPrimes(int n) {
        vector<bool> isPrime(n, true); // vector instead of array
        for (int i = 2; i * i < n; i++)
            if (isPrime[i])
                for (int j = i * i; j < n; j += i)
                    isPrime[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrime[i]) count++;

        return count;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def countPrimes(self, n: int) -> int:
        isPrime = [True]*n
        for i in range(2, int(n**0.5)+1):
            if isPrime[i]:
                for j in range(i*i, n, i):
                    isPrime[j] = False

        count = 0
        for i in range(2, n):
            if isPrime[i]:
                count += 1

        return count
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++)
            if (isPrime[i])
                for (int j = i * i; j < n; j += i)
                    isPrime[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrime[i]) count++;

        return count;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func countPrimes(n int) int {
    // create boolean array with default value true
    isPrime := make([]bool, n)
    for i := range isPrime {
        isPrime[i] = true
    }

    // loop through all numbers up to the square root of n
    for i := 2; i*i < n; i++ {
        if isPrime[i] {
            // loop through multiples of i and mark them as not prime
            for j := i * i; j < n; j += i {
                isPrime[j] = false
            }
        }
    }

    // count number of primes
    count := 0
    for i := 2; i < n; i++ {
        if isPrime[i] {
            count++
        }
    }

    return count
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number} n
 * @return {number}
 */
var countPrimes = function(n) {
    const isPrime = new Array(n).fill(true);
    for (let i = 2; i * i < n; i++) {
        if (isPrime[i]) {
            for (let j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
    }
    let count = 0;
    for (let i = 2; i < n; i++) {
        if (isPrime[i]) count++;
    }
    return count;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_count-primes" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_count-primes"></div></div>
</details><hr /><br />

**类似题目**：
  - [264. 丑数 II 🟠](/problems/ugly-number-ii)
  - [剑指 Offer 49. 丑数 🟠](/problems/chou-shu-lcof)

</details>
</div>



