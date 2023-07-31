English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>数学 | 动态规划 | 概率与统计</details><br>

<div>👍 567, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 最后一天报名！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题有意思，是经典的动态规划题目，状态转移的关系很明显，我来带你分析一下：

现在有 `n` 个骰子，扔出点数 `point` 的概率是多少？

首先，一个骰子能扔出的点数是 1~6，那么 `n` 个骰子扔出点数 `point` 的概率就可以通过 `n - 1` 个骰子扔出点数 `point-1, point-2,... point-6` 的概率分别乘以 1/6 再相加得到。

如果定义一个 `dp(n, point)` 函数表示用 n 个骰子抛出 point 点数的概率，那么这个状态转移关系如下：

```java
dp(n, point) = sum{dp(n-1, point-k) where 1 <= k <= 6}
```

明确了状态转移关系，就可以写出自顶向下的递归解法和自底向上的迭代解法了，我都写出来供你参考。

**标签：[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

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

// 自底向上的迭代解法
class Solution {
public:
    vector<double> dicesProbability(int n) {
        // n 个骰子可能扔出的结果的最大值和最小值
        int min = n, max = n * 6;
        // 定义：用 n 个骰子，凑出 point 的点数的概率是 dp[n][point]
        vector<vector<double>> dp(n + 1, vector<double>(max + 1));
        // base case，一个骰子扔出点数 1~6 的概率是 1/6
        for (int j = 1; j <= 6; j++) {
            dp[1][j] = 1.0 / 6;
        }
        // 状态转移
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k <= 0) {
                        break;
                    }
                    // i 个骰子扔出点数 j 的概率
                    // 可以通过 i - 1 个骰子认出点数 j - k 的概率推倒出来
                    dp[i][j] += dp[i - 1][j - k] * 1.0 / 6.0;
                }
            }
        }

        vector<double> res(max - min + 1);
        for (int i = 0; i < res.size(); i++) {
            res[i] = dp[n][min + i];
        }
        return res;
    }
};

// 自顶向下的递归解法
class Solution2 {
public:
    vector<double> dicesProbability(int n) {
        // n 个骰子可能扔出的结果的最大值和最小值
        int min = n, max = n * 6;
        memo = vector<vector<double>>(n + 1, vector<double>(max + 1, 0));

        vector<double> res(max - min + 1);
        for (int i = 0; i < res.size(); i++) {
            res[i] = dp(n, min + i);
        }
        return res;
    }

private:
    // 备忘录
    vector<vector<double>> memo;

    // 定义：用 n 个骰子，抛出 point 点数的概率
    double dp(int n, int point) {
        // base case
        if (point <= 0) {
            return 0;
        }
        if (n == 1) {
            if (point > 6) {
                return 0;
            }
            return 1.0 / 6;
        }
        // 通过备忘录避免冗余计算
        if (memo[n][point] != 0) {
            return memo[n][point];
        }
        // 进行状态转移
        double prob = 0;
        for (int i = 1; i <= 6; i++) {
            prob += dp(n - 1, point - i) * 1.0 / 6;
        }
        // 结果存入备忘录
        memo[n][point] = prob;
        return prob;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

# 自底向上的迭代解法
class Solution:
    def dicesProbability(self, n: int) -> List[float]:
        # n 个骰子可能扔出的结果的最大值和最小值
        min_num = n
        max_num = n * 6
        # 定义：用 n 个骰子，凑出 point 的点数的概率是 dp[n][point]
        dp = [[0.0] * (max_num + 1) for _ in range(n + 1)]
        # base case，一个骰子扔出点数 1~6 的概率是 1/6
        for j in range(1, 7):
            dp[1][j] = 1 / 6.0
        # 状态转移
        for i in range(2, n + 1):
            for j in range(i, i * 6 + 1):
                for k in range(1, 7):
                    if j - k <= 0:
                        break
                    # i 个骰子扔出点数 j 的概率
                    # 可以通过 i - 1 个骰子认出点数 j - k 的概率推倒出来
                    dp[i][j] += dp[i - 1][j - k] * 1 / 6.0
        res = [dp[n][i] for i in range(min_num, max_num + 1)]
        return res

# 自顶向下的递归解法
class Solution2:
    def dicesProbability(self, n: int) -> List[float]:
        # n 个骰子可能扔出的结果的最大值和最小值
        min_num = n
        max_num = n * 6
        self.memo = [[0.0] * (max_num + 1) for _ in range(n + 1)]
        res = [self.dp(n, min_num + i) for i in range(max_num - min_num + 1)]
        return res

    # 备忘录
    memo = [[]]

    # 定义：用 n 个骰子，抛出 point 点数的概率
    def dp(self, n: int, point: int) -> float:
        # base case
        if point <= 0:
            return 0
        if n == 1:
            if point > 6:
                return 0
            return 1 / 6.0
        # 通过备忘录避免冗余计算
        if self.memo[n][point] != 0:
            return self.memo[n][point]
        # 进行状态转移
        prob = 0
        for i in range(1, 7):
            prob += self.dp(n - 1, point - i) * 1 / 6
        # 结果存入备忘录
        self.memo[n][point] = prob
        return prob
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
// 自底向上的迭代解法
class Solution {
    public double[] dicesProbability(int n) {
        // n 个骰子可能扔出的结果的最大值和最小值
        int min = n, max = n * 6;
        // 定义：用 n 个骰子，凑出 point 的点数的概率是 dp[n][point]
        double[][] dp = new double[n + 1][max + 1];
        // base case，一个骰子扔出点数 1~6 的概率是 1/6
        for (int j = 1; j <= 6; j++) {
            dp[1][j] = 1 / 6.0;
        }
        // 状态转移
        for (int i = 2; i <= n; i++) {
            for (int j = i * 1; j <= i * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k <= 0) {
                        break;
                    }
                    // i 个骰子扔出点数 j 的概率
                    // 可以通过 i - 1 个骰子认出点数 j - k 的概率推倒出来
                    dp[i][j] += dp[i - 1][j - k] * 1 / 6.0;
                }
            }
        }

        double[] res = new double[max - min + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[n][min + i];
        }
        return res;
    }
}

// 自顶向下的递归解法
class Solution2 {
    public double[] dicesProbability(int n) {
        // n 个骰子可能扔出的结果的最大值和最小值
        int min = n, max = n * 6;
        memo = new double[n + 1][max + 1];

        double[] res = new double[max - min + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = dp(n, min + i);
        }
        return res;
    }

    // 备忘录
    double[][] memo;

    // 定义：用 n 个骰子，抛出 point 点数的概率
    double dp(int n, int point) {
        // base case
        if (point <= 0) {
            return 0;
        }
        if (n == 1) {
            if (point > 6) {
                return 0;
            }
            return 1 / 6.0;
        }
        // 通过备忘录避免冗余计算
        if (memo[n][point] != 0) {
            return memo[n][point];
        }
        // 进行状态转移
        double prob = 0;
        for (int i = 1; i <= 6; i++) {
            prob += dp(n - 1, point - i) * 1 / 6;
        }
        // 结果存入备忘录
        memo[n][point] = prob;
        return prob;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 自底向上的迭代解法
func dicesProbability(n int) []float64 {
	// n 个骰子可能扔出的结果的最大值和最小值
	min := n
	max := n * 6
	// 定义：用 n 个骰子，凑出 point 的点数的概率是 dp[n][point]
	dp := make([][]float64, n+1)
	for i := range dp {
		dp[i] = make([]float64, max+1)
	}
	// base case，一个骰子扔出点数 1~6 的概率是 1/6
	for j := 1; j <= 6; j++ {
		dp[1][j] = 1 / 6.0
	}
	// 状态转移
	for i := 2; i <= n; i++ {
		for j := i * 1; j <= i*6; j++ {
			for k := 1; k <= 6; k++ {
				if j-k <= 0 {
					break
				}
				// i 个骰子扔出点数 j 的概率
				// 可以通过 i - 1 个骰子认出点数 j - k 的概率推倒出来
				dp[i][j] += dp[i-1][j-k] * 1 / 6.0
			}
		}
	}

	res := make([]float64, max-min+1)
	for i := 0; i < len(res); i++ {
		res[i] = dp[n][min+i]
	}
	return res
}

// 自顶向下的递归解法
func dicesProbability2(n int) []float64 {
	// n 个骰子可能扔出的结果的最大值和最小值
	min := n
	max := n * 6
	memo := make([][]float64, n+1)
	for i := range memo {
		memo[i] = make([]float64, max+1)
	}

	res := make([]float64, max-min+1)
	for i := 0; i < len(res); i++ {
		res[i] = dp2(n, min+i, memo)
	}
	return res
}

// 定义：用 n 个骰子，抛出 point 点数的概率
func dp2(n, point int, memo [][]float64) float64 {
	// base case
	if point <= 0 {
		return 0
	}
	if n == 1 {
		if point > 6 {
			return 0
		}
		return 1 / 6.0
	}
	// 通过备忘录避免冗余计算
	if memo[n][point] != 0 {
		return memo[n][point]
	}
	// 进行状态转移
	prob := 0.0
	for i := 1; i <= 6; i++ {
		prob += dp2(n-1, point-i, memo) * 1 / 6
	}
	// 结果存入备忘录
	memo[n][point] = prob
	return prob
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

var dicesProbability = function(n) {
    // n 个骰子可能扔出的结果的最大值和最小值
    var min = n, max = n * 6;
    // 定义：用 n 个骰子，凑出 point 的点数的概率是 dp[n][point]
    var dp = new Array(n + 1).fill(null).map(() => new Array(max + 1).fill(0));
    // base case，一个骰子扔出点数 1~6 的概率是 1/6，填充第一行
    for (let j = 1; j <= 6; j++) {
        dp[1][j] = 1 / 6.0;
    }
    // 状态转移
    for (let i = 2; i <= n; i++) {
        for (let j = i; j <= i * 6; j++) {
            for (let k = 1; k <= 6; k++) {
                if (j - k < i - 1 || j - k > (i - 1) * 6) {
                    // 走到了边界，后面的数都不能满足
                    break;
                }
                // i 个骰子扔出点数 j 的概率
                // 可以通过 i - 1 个骰子认出点数 j - k 的概率推倒出来
                dp[i][j] += dp[i - 1][j - k] / 6.0;
            }
        }
    }

    var res = new Array(max - min + 1);
    for (let i = 0; i < res.length; i++) {
        res[i] = dp[n][min + i];
    }
    return res;
};

// 自顶向下的递归解法
var dicesProbability2 = function(n) {
    // n 个骰子可能扔出的结果的最大值和最小值
    var min = n, max = n * 6;
    // 定义：用 n 个骰子，抛出 point 点数的概率
    var memo = new Array(n + 1).fill(null).map(() => new Array(max + 1).fill(0));

    var dp = function(n, point) {
        // base case
        if (point <= 0) {
            return 0;
        }
        if (n === 1) {
            if (point > 6) {
                return 0;
            }
            return 1 / 6.0;
        }
        // 通过备忘录避免冗余计算
        if (memo[n][point] !== 0) {
            return memo[n][point];
        }
        // 进行状态转移
        var prob = 0;
        for (let i = 1; i <= 6; i++) {
            prob += dp(n - 1, point - i) * 1 / 6.0;
        }
        // 结果存入备忘录
        memo[n][point] = prob;
        return prob;
    }

    var res = new Array(max - min + 1);
    for (let i = 0; i < res.length; i++) {
        res[i] = dp(n, min + i);
    }
    return res;
};
```

</div></div>
</div></div>

</details>
</div>



