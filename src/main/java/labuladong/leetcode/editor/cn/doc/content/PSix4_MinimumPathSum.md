<p>Given a <code>m x n</code> <code>grid</code> filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.</p>

<p><strong>Note:</strong> You can only move either down or right at any point in time.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/05/minpath.jpg" style="width: 242px; height: 242px;" /> 
<pre>
<strong>Input:</strong> grid = [[1,3,1],[1,5,1],[4,2,1]]
<strong>Output:</strong> 7
<strong>Explanation:</strong> Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> grid = [[1,2,3],[4,5,6]]
<strong>Output:</strong> 12
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>m == grid.length</code></li> 
 <li><code>n == grid[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 200</code></li> 
 <li><code>0 &lt;= grid[i][j] &lt;= 200</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划 | 矩阵</details><br>

<div>👍 1518, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=minimum-path-sum" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

一般来说，让你在二维矩阵中求最优化问题（最大值或者最小值），肯定需要递归 + 备忘录，也就是动态规划技巧。

`dp` 函数的定义：**从左上角位置 `(0, 0)` 走到位置 `(i, j)` 的最小路径和为 `dp(grid, i, j)`**。

这样，`dp(grid, i, j)` 的值由 `dp(grid, i - 1, j)` 和 `dp(grid, i, j - 1)` 的值转移而来：

```java
dp(grid, i, j) = Math.min(
    dp(grid, i - 1, j),
    dp(grid, i, j - 1)
) + grid[i][j];
```

**详细题解：[动态规划之最小路径和](https://labuladong.github.io/article/fname.html?fname=最小路径和)**

**标签：[二维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，二维矩阵，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

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
private:
    int memo[205][205];

public:
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        memset(memo, -1, sizeof memo);

        return dp(grid, m - 1, n - 1);
    }

    int dp(vector<vector<int>>& grid, int i, int j) {
        // base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return INT_MAX;
        }

        // 避免重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 将计算结果记入备忘录
        memo[i][j] = min(
            dp(grid, i - 1, j),
            dp(grid, i, j - 1)
        ) + grid[i][j];

        return memo[i][j];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        # 构造备忘录，初始值全部设为 -1
        memo = [[-1 for _ in range(n)] for _ in range(m)]

        return self.dp(grid, m - 1, n - 1, memo)

    def dp(self, grid: List[List[int]], i: int, j: int, memo: List[List[int]]) -> int:
        # base case
        if i == 0 and j == 0:
            return grid[0][0]
        if i < 0 or j < 0:
            return float("inf")
        # 避免重复计算
        if memo[i][j] != -1:
            return memo[i][j]
        # 将计算结果记入备忘录
        memo[i][j] = min(
            self.dp(grid, i - 1, j, memo),
            self.dp(grid, i, j - 1, memo)
        ) + grid[i][j]

        return memo[i][j]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    int[][] memo;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 构造备忘录，初始值全部设为 -1
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        return dp(grid, m - 1, n - 1);
    }

    int dp(int[][] grid, int i, int j) {
        // base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        // 避免重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 将计算结果记入备忘录
        memo[i][j] = Math.min(
                dp(grid, i - 1, j),
                dp(grid, i, j - 1)
        ) + grid[i][j];

        return memo[i][j];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

import "math"

func minPathSum(grid [][]int) int {
    m, n := len(grid), len(grid[0])
    // 构造备忘录，初始值全部设为 -1
    memo := make([][]int, m)
    for i := range memo {
        memo[i] = make([]int, n)
        for j := range memo[i] {
            memo[i][j] = -1
        }
    }

    var dp func(i, j int) int
    dp = func(i, j int) int {
        // base case
        if i == 0 && j == 0 {
            return grid[0][0]
        }
        if i < 0 || j < 0 {
            return int(math.MaxInt64)
        }
        // 避免重复计算
        if memo[i][j] != -1 {
            return memo[i][j]
        }
        // 将计算结果记入备忘录
        memo[i][j] = min(
            dp(i-1, j), 
            dp(i, j-1),
        ) + grid[i][j]

        return memo[i][j]
    }
    return dp(m-1, n-1)
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var minPathSum = function(grid) {
    const m = grid.length;
    const n = grid[0].length;
    // 构造备忘录，初始值全部设为 -1
    const memo = new Array(m);
    for (let i = 0; i < m; i++) {
        memo[i] = new Array(n).fill(-1);
    }

    return dp(grid, m - 1, n - 1);

    function dp(grid, i, j) {
        if (i === 0 && j === 0) {
            // base case
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            // 越界
            return Infinity;
        }
        // 避免重复计算
        if (memo[i][j] !== -1) {
            return memo[i][j];
        }
        // 将计算结果记入备忘录
        memo[i][j] = Math.min(
            dp(grid, i - 1, j),
            dp(grid, i, j - 1)
        ) + grid[i][j];

        return memo[i][j];
    }
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_minimum-path-sum" data="G/7nIxHCxgFQD3vfgnFsBY8jcEfaiCSUc19ArQ5sx2v4JHp7Om70FbWFn47eGUb2XsV4ifFMgTxCkyPS55f+fKt6V0mOpBWnYx8ACVaAz0B/Jlku8u4/bivVd5dwTWmsIbbPaQJCa66TPZ/S8JK2AAWl/zsxtWy5nDDLHmeNs3EUl+ctOjE1L+T6YuTEtluC/f9f+99v3zFJZhstTdPrSDIN6c2R2ajOG0SbSWTuvYh50vQWiU4lJFqB0CJQX8t6Y9h3kjb0sbgQPPeuZZzbkQXoXMp4KESE+3relOyOPDMeOQc47d6Z72b35Ak4+MGyxYTE4RAKJUciMSQYkktGrPCkVk82p5BIHIKgTrx5tOaEV7/ArCsHZV1UPmvDD0afToMcSqBCZqrhq21Iun45VaoMceDf75c7d9od/TPQsAnOC12CIAZbXuYw0RbRTKz8kd387hLv0N+9/DQyJrJSv/tXGLil8fG7iw5pSVN9K75+rGLq+S/+GyH08XcfNInqSRGrTHG1n+mqf1+MQpszvdFPMsaggWnx7FS+u/nyr30qWBac8991G4Le0nK0yr/Qwn6lbHNehg9v9duKOkCkcrVvYtEr6BgY+7v6S8YKK8g5QXKwFzPWURtrSaivOvvzOZ984v0v3755Fghew7NoSCe5//2OL96O5cjQ2T+ZX6XZ9u6WIXWuJK/dE/5wrZSRzGRa0VSu36WJRExco1Hfs/FcpCqqb5Eja+zf/Sxp1Uoidax6yU43Qjh//h7cscrXuxY2/YbqqptRxsmmzfubYTls3vpg1LG1P5+pYFUMfH8VA/k7KT82ivXGyCfqq6BrWJK2z9x6n9unzFABeOOi29j+Sd/lBk/DXazhziuv5kzQfHBpJwJusqJiz57c8JhvQ8S3zC6hlShv/lOp44UxiH/zD/2vCQXnaikia0PnNCzK6HEUMZbj60+OdEZz5BPkEsXk5Vc/fWryL/nm3bc/l4l0qeH7xHk5z2JCV9uJo6+8UAZCMiBvGJsGCxmLGOQyZjGRq+0mahS8UAZCMiBzGJsEixiLGOQyJnzuLQK3P8f+U6oNdT46kNik+/KDlhYJb5iR7x22RcG7eMqiPf9xtJ9VdbEQQxvzB16Eth4zLGM+Oqs8I41uE+uRuzYOz/93AgSvlImeXdd4jRGxV9sV4Bf7SMOmHYffndV/fmIimQVQJHhtq6qjdasXWU3YJwW5dWkcqzD804Inqslormss/klgu+HGuOPKiidqkDFE+yY/2pRjWksY1uDnJF06Q1Jhwvbf7W0bqPZdmPjajbDv2Ty8wzY7GyVi7S4o+Iaw7zC2zqpy+gkUhg50WMnaAQd4n2uYGIdbzxIGbizgqDBbYsrH5FB4l4OghxoCVf5hKAkM1bObEwTvF9ODzZKYEWxs8YD3uYYNcbjlLGOe22g8N6rflpiyG/En4V0Ogh5quECqi6EcMLTHwIRYt2pPtXnuJmWML4OQTDEI7iN96VUhk7K7/75J+519PaO3qKznOWQ5W9go5Xf+Py00G3zSMZ/YfHszGDmZvGR6YkXJ9Hqy+r9nvdb0HIEbQfYhtCYPY9fyG+zTg6GnRCyYHoiiM5HqtyWmRFjWwrscBD3UcC1WlgzlgKEDFrvJpCYtrIfeDWU9c219Bz2NAXVr6Qhiah1Aie77SpNXS2HEhpaPWo933UpfQ+vas/5aaUX6Hs6x4D0m2bSLILnAtpMr/6xrnI9iuGeh1/hu3utnHtDuS8yY8wwT43K7M6XMhLPOKUvf+clgGOtWcqZZaxHk65nsqlrgIn3FyLaaHRGK2LSu+Y4J51frwjnrvWZcV2yb5aVFes4FlSz0Gt/Ne/02PbT7Ep1XLRi4xqncSoVnFaINCtlj1W6lwndlbIqkA6VejLHp/dCqIWttfQf503mvN1rm9T4M40FX/I71AZTg+yourc4TZYGheoaX/Q4ybfUFp0BhIhVmS0wZN6wD73IQ9FDDc3MDhmLA0FMvdrDrrK66zVQ2q+LuqDgHhNvFZGyboVxZThXhuGj1YmxF74epSt7a+g7yp/NaRbHMq71ZoHjKnwsMoATfl+rkNGWBoYP1KooDUHAmUGG2xJS7xCTxLgdBDzWoj9UylAKGDvu7Wu7mIy3oqaF3Q9WTt7a+g/LxL8cG4+DzKX1Kuf4LPmZmIYTW5GHMLbBmnx4M7b9LsvP+8wOR5nrSwnroM5rUo92LiGNeu2NxrFhoGwsLOVCkE7w7Zrv1nVXpNUkOQiqMjMxlJdpZIUyikDrQ6jW+m/f6TXho9yU6V3XYsWrBcZJbyfBdhbCBIT1WdisZ3pXRFEkHSr3Gd/Ne38YC7b5E564FA3ss2uXeyqyDwUXIGakhJvxUxqFIOlDqxdiG3g/HKcpbW99B/gSfZd640ZAr/7hiAZTg+yI1mqcsMHTOMpAc9BJOYcIHFWZLTNkKJIF3OQh6qKGF4D1DMWDoUDeBKqgJ9GLglmHrMeO402MyxdqBVi/GZno/TAny1tZ3kD/BvcyzGw258ufcAijB9/XFrTOKAkOH6/NoOAAFZwEVZltMCSH4hXc9CDqoITVuB0M5YOhgzUo8FmCtVkjHnR6TKNYOtHoxNtH7YUqQt7a+g/wJrqWeGuqNh1z5824BlOD7aiJXTVlg6BAKaa4nLayHPqdJPdrl0+sa6oWQRZx2qRO8N+QcqJ20HSv25g9GSddplgeFVA16Wuhz2qKKdl+i86kOO55acJzGrWR4VSHWwJA7VutWMvxWxqVIOlDqNb6b9/pmKmj3JTrfWnCBWJd7Q70OjIuQHitz7qmpMkVSDXpi6P0Q/MfLxMmqq2bo2UBwVcoLDe+Brb1eJ8qdtjqMyKv4vmpPxSqvUdLZyaMnk+9KV9I25+7wsCpglpN564Z/h8m0P9lI5krW0uZExruDm62stKMGBw2fo6+btWY9TLpr1sSpAwlsdonAJFcLxpgU/qgKKGM27u2hvlf00DxBkp/+7torVqNEU8oG/+00EBrHI1FcBwFuXbwOWN18HbB2eAb/vhNenRiNzqLhI4EukuQ2jrFc6R9//kwf63lJCz+4gSDR7i+vGsMKUf195i14DNTuptn0sVSn3ULd9EVlPWzvrfswlLyGo9s14aZJdFJ4HPpxFkXFGGdCHDO43qI+ORTTJJyTUAuHGk0Kzh1RTgWFaOUzYSyDK8a+qmsBF31oieSKj4yVFCj3+SjfPOaEIZvwmjCen/BhHJp+462vk43wNBaWKaIoiM+5Pls1JEu0uJxeYO6jc4zPSpKUT8UrfpCUxGvCeIZhqg0YH8UgKSLEE6MKAvic67O/xTYjyykVXE1lHkqVXZxM6GcT3c0tSTkdwVxkchUn7qUPRzWpW97Wo50SvFhPUjhd6PWS2hmkP+JzbinlYsY3cM1CMA3bmqbwHkvJbuQB7qCWBvhMGMvgklJz+99zWdfNQQjBi992hZemSzYe4Elf/fRWEMDn3JC71OueVoHTjJahZ21WXos82c3lTBLgsgafCWMZXDTNDOeh6ZZzSOKlVoOCPzA97Xd+/JgThmzwOscqjs7rZZTrtDLMKsrOSR+ugIagq1dajMNhWcATZNpph86abIRB4BT+3lcUxOfc374upoIHl4++9qFQHI1nKya7GbIrLdYs+EwYy+AiX5JYwRVWWcay3VILUcWkcD8oL4mSFD7nhtzVfe91FQpCZBnajfvEZqTJbij2jeg1Cz4TxjK4smc6/sziGOvT4bOjKraqSQrXIss9vtQyWQuvc8O+6hrrV3HNNFRz3Rh9tMUt+aZsfsHacNkLHaPLpea2Y1fTQHREMoseHcO2BZkin8SxnwNbA1p8a7+98E1/lK1fTIWynB8nQE4j3+IToxikpHFMbEtthwUHnCsHfi1PV6BCbzx3HzaIehmwdHtYUEmRPs/BmRcUQ2TQtKF5BcMcxJIFYkEKOizNv+iD931ZZwi11sqdA9AKwKnw0tdrdbTzAo++REv8qBWkslK2I2JYcEJkTgqG5hmMAcF34AxvqIalbPukhgWXmp4012gegYZwyXS1Iy1huc65lKsdsaP4pqbmPh3reATBrTILp0g5YXWwc8g/Mc/23gakg/VSn1HkDCYN8RW//PjFEV8rqKUwJZpGooYgRXK3ooBxMOaLee6fbbW5Pr/4vyDkRuyDkSDn+ESZZz1LIVEqxK2/sI9QDE47fgSVpwk1B78lWjglZK3Q1GAwYcctqAQj1amhs3H0eyGYUuQakn+2OtM4wM286XZsGNpDruhi8bqkJvpAJ3/qVmjpNl8cMY2mQ6rdlgqeaD4xY2554lXm6I+4T/qgbAAtt/7AT2hB1aYoqTs8eLBTXQQjrUF3J0/oo/+e3XDvXzgVe/bd7cPDyBcNP/6+TJvhlO+unsqDnGosau12yI8YkYnO/PKAfgX85ccv7IshmL0yHXIWBAJJ1MQJyXYrJAGiy8lbulS8wsMI7FGXaQapvukH8bpcR+MRVVFO713QE0/83LFcbKXiI3EEtjE9BS1asQrv3HazTvJXE6MKWqUQ9gPFn8ApXZD9v6FL59zulpWUfm0i/bXa2Pxyp7F5i0sW+LICaWyrJgGlIkJVGmNCg0lF1KiIB5VGetAYThEtKSpQbw39Py1K/qxCJzpqhKQmgYlC/5ouxCjQUEQRASgk54lgAKr5F0J7oeoPaOCF6Do7IoejqndNpOZC154uqM6o4NyOKggXum9N5N1SFRcVawuNtJDNZn+SS1FVtBAjC91zuqBLovJjofoVstGEAIjqfIW8Vih5E0obIqgVWtp8LEoXKmgVulVN5KlSFQoVmwqNp6j2z94n9yCqTiGmFLrNdkFXQeWTQrUoqrETAgaqUxTyQKFETCgFqCBQ1MKLKv9EhRytdxfV66IWHVMqy0WdOACbP2zFontjwCrAsnLd8JG43aqV2cwCanbjE+HeDRHeDVHeDdHeDR/lpUIf0rZDAbaQth0e09rX7JNWLvVNJG07VFBLX5NPWiXUNZGkLeS08jX3pD2lnidSLVvIauFraubqB18q3iNn8h5VMKEKsmR07fUxea1Wr1fBnLWlaAm9kSUj8CzQhUCvNOq17q5wLD3dSigjUEqJXtGS96RON5QWaJ7evG4lr7UalFCbssSq8uqUvE4pTUL1asdrUPKcsXpyQlkZynD4U0rgSZaMQAsK8Upz83KqkVBbsmR14PUkeR1rQ0I1BLql9q4ayeulAtxQRoYfhzTdseHkldR5G0oJVKvcrgDJa5Wa21BW4LVARwLPsmSEL0PsJh/L+7cPP3DxB9+ZGpYL/5vm05Uy5qIgADi2geuQJDEe4JYwoZtexSze/KFp4qjIDZp94P64v+7H7KI0a+CpyvNnruXbjgu6PdBPVGLCka3ZKeQe68ln+cJY/cq+3SbSYn59zKXR3rzMOt5sI/nkJt+t271cu77sjReTub18zYfTNQjosF9sJ+vGGs6uSvbHXaAfA6lgf2iHPF9nFdO5oX81kuezSUq9lBLvwzBHyWdv1uSj7aMeG97a7KrXssgr6bsfcG3qdOYm/+x74o69OO+GP2qPL+ZmeygWY6PhM/0fsp7jkefQ7UcOsZJ9pfflvrJBWWWqdsIS7qbjyhQubA7bK1r9hOhIuq4uLluwr+tlLYsLVBd79b6UoS4MjjmbK5oyn6qNawey1lqRvjfmW18+rr9izNbgarC5hrxxer/N63CyiwaX052NlwOqm7WeT81/+nWiKm59Ag=="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_minimum-path-sum"></div></div>
</details><hr /><br />

**类似题目**：
  - [剑指 Offer 47. 礼物的最大价值 🟠](/problems/li-wu-de-zui-da-jie-zhi-lcof)
  - [剑指 Offer II 099. 最小路径之和 🟠](/problems/0i0mDW)

</details>
</div>



