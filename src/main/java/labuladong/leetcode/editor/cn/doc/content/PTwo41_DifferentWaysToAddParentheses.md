<p>Given a string <code>expression</code> of numbers and operators, return <em>all possible results from computing all the different possible ways to group numbers and operators</em>. You may return the answer in <strong>any order</strong>.</p>

<p>The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed <code>10<sup>4</sup></code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> expression = "2-1-1"
<strong>Output:</strong> [0,2]
<strong>Explanation:</strong>
((2-1)-1) = 0 
(2-(1-1)) = 2
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> expression = "2*3-4*5"
<strong>Output:</strong> [-34,-14,-10,-10,10]
<strong>Explanation:</strong>
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= expression.length &lt;= 20</code></li> 
 <li><code>expression</code> consists of digits and the operator <code>'+'</code>, <code>'-'</code>, and <code>'*'</code>.</li> 
 <li>All the integer values in the input expression are in the range <code>[0, 99]</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>递归 | 记忆化搜索 | 数学 | 字符串 | 动态规划</details><br>

<div>👍 822, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=different-ways-to-add-parentheses" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

对于运算表达式相关的问题，一般都会涉及括号以及优先级的问题，常用的技巧是分治算法，明确递归函数的定义，让递归函数去处理括号。

这题就要用分治思想解决，分而治之，先分后治：

1、明确函数定义，`diffWaysToCompute` 函数可以计算出输入算式的所有组合结果。

2、分，给某一个运算符左右加括号，将一个表达式分解成两个子表达式。

3、治，用 `diffWaysToCompute` 递归计算左右两个子表达式的所有结果。

4、用子表达式（子问题）的结果推导原表达式（原问题）的结果。

**详细题解：[分治算法详解：运算优先级](https://labuladong.github.io/article/fname.html?fname=分治算法)**

**标签：分治算法，递归**

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
    unordered_map<string, vector<int>> memo;
public:
    vector<int> diffWaysToCompute(string input) {
        // 避免重复计算
        if (memo.count(input)) {
            return memo[input];
        }
        vector<int> res;
        for (int i = 0; i < input.length(); i++) {
            char c = input[i];
            // 扫描算式 input 中的运算符
            if (c == '-' || c == '*' || c == '+') {
                /******分******/
                // 以运算符为中心，分割成两个字符串，分别递归计算
                vector<int> left = diffWaysToCompute(input.substr(0, i));
                vector<int> right = diffWaysToCompute(input.substr(i + 1));
                /******治******/
                // 通过子问题的结果，合成原问题的结果
                for (int a : left)
                    for (int b : right)
                        if (c == '+')
                            res.push_back(a + b);
                        else if (c == '-')
                            res.push_back(a - b);
                        else if (c == '*')
                            res.push_back(a * b);
            }
        }
        // base case
        // 如果 res 为空，说明算式是一个数字，没有运算符
        if (res.empty()) {
            res.push_back(stoi(input));
        }
        // 将结果添加进备忘录
        memo[input] = res;
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
    def __init__(self):
        self.memo = {}

    def diffWaysToCompute(self, input: str) -> List[int]:
        # 避免重复计算
        if input in self.memo:
            return self.memo[input]
        res = []
        for i in range(len(input)):
            c = input[i]
            # 扫描算式 input 中的运算符
            if c in ['-', '*', '+']:
                # 以运算符为中心，分割成两个字符串，分别递归计算
                left = self.diffWaysToCompute(input[:i])
                right = self.diffWaysToCompute(input[i+1:])
                # 通过子问题的结果，合成原问题的结果
                for a in left:
                    for b in right:
                        if c == '+':
                            res.append(a + b)
                        elif c == '-':
                            res.append(a - b)
                        elif c == '*':
                            res.append(a * b)
        # base case
        # 如果 res 为空，说明算式是一个数字，没有运算符
        if not res:
            res.append(int(input))
        # 将结果添加进备忘录
        self.memo[input] = res
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    HashMap<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        // 避免重复计算
        if (memo.containsKey(input)) {
            return memo.get(input);
        }
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // 扫描算式 input 中的运算符
            if (c == '-' || c == '*' || c == '+') {
                /******分******/
                // 以运算符为中心，分割成两个字符串，分别递归计算
                List<Integer>
                        left = diffWaysToCompute(input.substring(0, i));
                List<Integer>
                        right = diffWaysToCompute(input.substring(i + 1));
                /******治******/
                // 通过子问题的结果，合成原问题的结果
                for (int a : left)
                    for (int b : right)
                        if (c == '+')
                            res.add(a + b);
                        else if (c == '-')
                            res.add(a - b);
                        else if (c == '*')
                            res.add(a * b);
            }
        }
        // base case
        // 如果 res 为空，说明算式是一个数字，没有运算符
        if (res.isEmpty()) {
            res.add(Integer.parseInt(input));
        }
        // 将结果添加进备忘录
        memo.put(input, res);
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func diffWaysToCompute(input string) []int {
    memo := make(map[string][]int)
    return compute(input, memo)
}

func compute(input string, memo map[string][]int) []int {
    // 避免重复计算
    if val, ok := memo[input]; ok {
        return val
    }
    res := make([]int, 0)
    for i := 0; i < len(input); i++ {
        c := input[i]
        // 扫描算式 input 中的运算符
        if c == '-' || c == '*' || c == '+' {
            /******分******/
            // 以运算符为中心，分割成两个字符串，分别递归计算
            left := compute(input[0:i], memo)
            right := compute(input[i+1:], memo)
            /******治******/
            // 通过子问题的结果，合成原问题的结果
            for _, a := range left {
                for _, b := range right {
                    if c == '+' {
                        res = append(res, a+b)
                    } else if c == '-' {
                        res = append(res, a-b)
                    } else if c == '*' {
                        res = append(res, a*b)
                    }
                }
            }
        }
    }
    // base case
    // 如果 res 为空，说明算式是一个数字，没有运算符
    if len(res) == 0 {
        n, _ := strconv.Atoi(input)
        res = append(res, n)
    }
    // 将结果添加进备忘录
    memo[input] = res
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var diffWaysToCompute = function(input) {
    let memo = new Map();
    const compute = (input) => {
        if (memo.has(input)) {
            return memo.get(input);
        }
        let res = [];
        for (let i = 0; i < input.length; i++) {
            let c = input.charAt(i);
            // 扫描算式 input 中的运算符
            if (c == '-' || c == '*' || c == '+') {
                /******分******/
                // 以运算符为中心，分割成两个字符串，分别递归计算
                let left = compute(input.substring(0, i));
                let right = compute(input.substring(i + 1));
                /******治******/
                // 通过子问题的结果，合成原问题的结果
                for (let a of left) {
                    for (let b of right) {
                        if (c == '+') {
                            res.push(a + b);
                        } else if (c == '-') {
                            res.push(a - b);
                        } else if (c == '*') {
                            res.push(a * b);
                        }
                    }
                }
            }
        }
        // base case
        // 如果 res 为空，说明算式是一个数字，没有运算符
        if (res.length == 0) {
            res.push(parseInt(input));
        }
        // 将结果添加进备忘录
        memo.set(input, res);
        return res;
    };
    return compute(input);
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_different-ways-to-add-parentheses" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_different-ways-to-add-parentheses"></div></div>
</details><hr /><br />

</details>
</div>



