<p>Given <code>n</code> pairs of parentheses, write a function to <em>generate all combinations of well-formed parentheses</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> ["((()))","(()())","(())()","()(())","()()()"]
</pre>
<p><strong class="example">Example 2:</strong></p> 
<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> ["()"]
</pre> 
<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 8</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划 | 回溯</details><br>

<div>👍 3262, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=generate-parentheses" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 306 页。

本题可以改写为：

现在有 `2n` 个位置，每个位置可以放置字符 `(` 或者 `)`，组成的所有括号组合中，有多少个是合法的？

这就是典型的回溯算法提醒，暴力穷举就行了。

不过为了减少不必要的穷举，我们要知道合法括号串有以下性质：

**1、一个「合法」括号组合的左括号数量一定等于右括号数量，这个很好理解**。

**2、对于一个「合法」的括号字符串组合 `p`，必然对于任何 ` 0 <= i < len(p)` 都有：子串 `p[0..i]` 中左括号的数量都大于或等于右括号的数量**。

因为从左往右算的话，肯定是左括号多嘛，到最后左右括号数量相等，说明这个括号组合是合法的。

用 `left` 记录还可以使用多少个左括号，用 `right` 记录还可以使用多少个右括号，就可以直接套用 [回溯算法套路框架](https://labuladong.github.io/article/fname.html?fname=回溯算法详解修订版) 了。

**详细题解：[回溯算法最佳实践：括号生成](https://labuladong.github.io/article/fname.html?fname=合法括号生成)**

**标签：[回溯算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">cpp🟢</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">java🤖</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item active" data-tab-group="default"><div class="highlight">

```cpp
class Solution {
    public:
    vector<string> generateParenthesis(int n) {
        if (n == 0) return {};
        // 记录所有合法的括号组合
        vector<string> res;
        // 回溯过程中的路径
        string track;
        // 可用的左括号和右括号数量初始化为 n
        backtrack(n, n, track, res);
        return res;
    }

    // 可用的左括号数量为 left 个，可用的右括号数量为 rgiht 个
    void backtrack(int left, int right, 
                string& track, vector<string>& res) {
        // 若左括号剩下的多，说明不合法
        if (right < left) return;
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) return;
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.push_back(track);
            return;
        }
        
        // 尝试放一个左括号
        track.push_back('('); // 选择
        backtrack(left - 1, right, track, res);
        track.pop_back(); // 撤消选择

        // 尝试放一个右括号
        track.push_back(')'); // 选择
        backtrack(left, right - 1, track, res);
        track.pop_back(); // 撤消选择
    }
}
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0:
            return []
        # 记录所有合法的括号组合
        res = []
        # 回溯过程中的路径
        track = ''
        # 可用的左括号和右括号数量初始化为 n
        self.backtrack(n, n, track, res)
        return res

    # 可用的左括号数量为 left 个，可用的右括号数量为 right 个
    def backtrack(self, left, right, track, res):
        # 若左括号剩下的多，说明不合法
        if right < left:
            return
        # 数量小于 0 肯定是不合法的
        if left < 0 or right < 0:
            return
        # 当所有括号都恰好用完时，得到一个合法的括号组合
        if left == 0 and right == 0:
            res.append(track)
            return

        # 尝试放一个左括号
        track += '('  # 选择
        self.backtrack(left - 1, right, track, res)
        track = track[:-1]  # 撤消选择

        # 尝试放一个右括号
        track += ')'  # 选择
        self.backtrack(left, right - 1, track, res)
        track = track[:-1]  # 撤消选择
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
// 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        // 记录所有合法的括号组合
        List<String> res = new ArrayList<>();
        // 回溯过程中的路径
        StringBuilder track = new StringBuilder();
        // 可用的左括号和右括号数量初始化为 n
        backtrack(n, n, track, res);
        return res;
    }

    // 可用的左括号数量为 left 个，可用的右括号数量为 right 个
    void backtrack(int left, int right, 
                StringBuilder track, List<String> res) {
        // 若左括号剩下的多，说明不合法
        if (right < left) return;
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) return;
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }
        
        // 尝试放一个左括号
        track.append('('); // 选择
        backtrack(left - 1, right, track, res);
        track.deleteCharAt(track.length() - 1); // 撤消选择

        // 尝试放一个右括号
        track.append(')'); // 选择
        backtrack(left, right - 1, track, res);
        track.deleteCharAt(track.length() - 1); // 撤消选择
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func generateParenthesis(n int) []string {
    if n == 0 {
        return []string{}
    }
    // 记录所有合法的括号组合
    res := []string{}
    // 回溯过程中的路径
    var track string
    // 可用的左括号和右括号数量初始化为 n
    backtrack(n, n, &track, &res)
    return res
}

// 可用的左括号数量为 left 个，可用的右括号数量为 right 个
func backtrack(left int, right int, track *string, res *[]string) {
    // 若左括号剩下的多，说明不合法
    if right < left {
        return
    }
    // 数量小于 0 肯定是不合法的
    if left < 0 || right < 0 {
        return
    }
    // 当所有括号都恰好用完时，得到一个合法的括号组合
    if left == 0 && right == 0 {
        *res = append(*res, *track)
        return
    }

    // 尝试放一个左括号
    *track += "(" // 选择
    backtrack(left-1, right, track, res)
    *track = (*track)[:len(*track)-1] // 撤消选择

    // 尝试放一个右括号
    *track += ")" // 选择
    backtrack(left, right-1, track, res)
    *track = (*track)[:len(*track)-1] // 撤消选择
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var generateParenthesis = function(n) {
    if (n === 0) return [];
    // 记录所有合法的括号组合
    var res = [];
    // 回溯过程中的路径
    var track = "";
    // 可用的左括号和右括号数量初始化为 n
    backtrack(n, n, track, res);
    return res;
};

// 可用的左括号数量为 left 个，可用的右括号数量为 right 个
function backtrack(left, right, track, res) {
    // 若左括号剩下的多，说明不合法
    if (right < left) return;
    // 数量小于 0 肯定是不合法的
    if (left < 0 || right < 0) return;
    // 当所有括号都恰好用完时，得到一个合法的括号组合
    if (left === 0 && right === 0) {
        res.push(track);
        return;
    }

    // 尝试放一个左括号
    track += '('; // 选择
    backtrack(left - 1, right, track, res);
    track = track.slice(0, -1); // 撤消选择

    // 尝试放一个右括号
    track += ')'; // 选择
    backtrack(left, right - 1, track, res);
    track = track.slice(0, -1); // 撤消选择
}
```

</div></div>
</div></div>

<details open><summary><strong>👉 算法可视化 👈</strong></summary><div class="resizable aspect-ratio-container" style="height: 70vh;">
    <iframe src="https://labuladong.github.io/algo-visualize/" width="100%"
    height="100%" scrolling="auto" frameborder="0"
    style="overflow: auto;" id="iframe_generate-parentheses"></iframe>
</div>
<div id="data_generate-parentheses" data="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"></div></details><hr /><br />

**类似题目**：
  - [剑指 Offer II 085. 生成匹配的括号 🟠](/problems/IDBivT)

</details>
</div>



