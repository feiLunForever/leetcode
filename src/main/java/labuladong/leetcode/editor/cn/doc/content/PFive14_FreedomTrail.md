<p>In the video game Fallout 4, the quest <strong>"Road to Freedom"</strong> requires players to reach a metal dial called the <strong>"Freedom Trail Ring"</strong> and use the dial to spell a specific keyword to open the door.</p>

<p>Given a string <code>ring</code> that represents the code engraved on the outer ring and another string <code>key</code> that represents the keyword that needs to be spelled, return <em>the minimum number of steps to spell all the characters in the keyword</em>.</p>

<p>Initially, the first character of the ring is aligned at the <code>"12:00"</code> direction. You should spell all the characters in <code>key</code> one by one by rotating <code>ring</code> clockwise or anticlockwise to make each character of the string key aligned at the <code>"12:00"</code> direction and then by pressing the center button.</p>

<p>At the stage of rotating the ring to spell the key character <code>key[i]</code>:</p>

<ol> 
 <li>You can rotate the ring clockwise or anticlockwise by one place, which counts as <strong>one step</strong>. The final purpose of the rotation is to align one of <code>ring</code>'s characters at the <code>"12:00"</code> direction, where this character must equal <code>key[i]</code>.</li> 
 <li>If the character <code>key[i]</code> has been aligned at the <code>"12:00"</code> direction, press the center button to spell, which also counts as <strong>one step</strong>. After the pressing, you could begin to spell the next character in the key (next stage). Otherwise, you have finished all the spelling.</li> 
</ol>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img src="https://assets.leetcode.com/uploads/2018/10/22/ring.jpg" style="width: 450px; height: 450px;" /> 
<pre>
<strong>Input:</strong> ring = "godding", key = "gd"
<strong>Output:</strong> 4
<strong>Explanation:</strong>
For the first key character 'g', since it is already in place, we just need 1 step to spell this character. 
For the second key character 'd', we need to rotate the ring "godding" anticlockwise by two steps to make it become "ddinggo".
Also, we need 1 more step for spelling.
So the final output is 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> ring = "godding", key = "godding"
<strong>Output:</strong> 13
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= ring.length, key.length &lt;= 100</code></li> 
 <li><code>ring</code> and <code>key</code> consist of only lower case English letters.</li> 
 <li>It is guaranteed that <code>key</code> could always be spelled by rotating <code>ring</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 字符串 | 动态规划</details><br>

<div>👍 269, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=freedom-trail" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

`dp` 函数的定义如下：**当圆盘指针指向 `ring[i]` 时，输入字符串 `key[j..]` 至少需要 `dp(ring, i, key, j)` 次操作**。

根据这个定义，题目其实就是想计算 `dp(ring, 0, key, 0)` 的值，base case 就是 `dp(ring, i, key, len(key)) = 0`。

**详细题解：[动态规划帮我通关了《辐射4》](https://labuladong.github.io/article/fname.html?fname=转盘)**

**标签：[二维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

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
    // 字符 -> 索引列表
    unordered_map<char, vector<int>> charToIndex;
    // 备忘录
    vector<vector<int>> memo;

    /* 主函数 */
    int findRotateSteps(string ring, string key) {
        int m = ring.size();
        int n = key.size();
        // 备忘录全部初始化为 0
        memo.resize(m, vector<int>(n, 0));
        // 记录圆环上字符到索引的映射
        for (int i = 0; i < ring.size(); i++) {
            charToIndex[ring[i]].push_back(i);
        }
        // 圆盘指针最初指向 12 点钟方向，
        // 从第一个字符开始输入 key
        return dp(ring, 0, key, 0);
    }

    // 计算圆盘指针在 ring[i]，输入 key[j..] 的最少操作数
    int dp(string& ring, int i, string& key, int j) {
        // base case 完成输入
        if (j == key.size()) return 0;
        // 查找备忘录，避免重叠子问题
        if (memo[i][j] != 0) return memo[i][j];

        int n = ring.size();
        // 做选择
        int res = INT_MAX;
        // ring 上可能有多个字符 key[j]
        for (int k : charToIndex[key[j]]) {
            // 拨动指针的次数
            int delta = abs(k - i);
            // 选择顺时针还是逆时针
            delta = min(delta, n - delta);
            // 将指针拨到 ring[k]，继续输入 key[j+1..]
            int subProblem = dp(ring, k, key, j + 1);
            // 选择「整体」操作次数最少的
            // 加一是因为按动按钮也是一次操作
            res = min(res, 1 + delta + subProblem);
        }
        // 将结果存入备忘录
        memo[i][j] = res;
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def __init__(self):
        # 字符 -> 索引列表
        self.charToIndex = {}
        # 备忘录
        self.memo = []

    # 主函数
    def findRotateSteps(self, ring: str, key: str) -> int:
        m = len(ring)
        n = len(key)
        # 备忘录全部初始化为 0
        self.memo = [[0] * n for _ in range(m)]
        # 记录圆环上字符到索引的映射
        for i in range(m):
            char = ring[i]
            if char in self.charToIndex:
                self.charToIndex[char].append(i)
            else:
                self.charToIndex[char] = [i]
        # 圆盘指针最初指向 12 点钟方向，
        # 从第一个字符开始输入 key
        return self.dp(ring, 0, key, 0)

    # 计算圆盘指针在 ring[i]，输入 key[j..] 的最少操作数
    def dp(self, ring: str, i: int, key: str, j: int) -> int:
        # base case 完成输入
        if j == len(key):
            return 0
        # 查找备忘录，避免重叠子问题
        if self.memo[i][j] != 0:
            return self.memo[i][j]

        n = len(ring)
        # 做选择
        res = float('inf')
        # ring 上可能有多个字符 key[j]
        for k in self.charToIndex[key[j]]:
            # 拨动指针的次数
            delta = abs(k - i)
            # 选择顺时针还是逆时针
            delta = min(delta, n - delta)
            # 将指针拨到 ring[k]，继续输入 key[j+1..]
            subProblem = self.dp(ring, k, key, j + 1)
            # 选择「整体」操作次数最少的
            # 加一是因为按动按钮也是一次操作
            res = min(res, 1 + delta + subProblem)

        # 将结果存入备忘录
        self.memo[i][j] = res
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
// 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    // 字符 -> 索引列表
    Map<Character, List<Integer>> charToIndex = new HashMap<>();
    // 备忘录
    int[][] memo;

    /* 主函数 */
    public int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        // 备忘录全部初始化为 0
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, 0);
        }
        // 记录圆环上字符到索引的映射
        for (int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            List<Integer> list = charToIndex.getOrDefault(c, new ArrayList<>());
            list.add(i);
            charToIndex.put(c, list);
        }
        // 圆盘指针最初指向 12 点钟方向，
        // 从第一个字符开始输入 key
        return dp(ring, 0, key, 0);
    }

    // 计算圆盘指针在 ring[i]，输入 key[j..] 的最少操作数
    private int dp(String ring, int i, String key, int j) {
        // base case 完成输入
        if (j == key.length()) return 0;
        // 查找备忘录，避免重叠子问题
        if (memo[i][j] != 0) return memo[i][j];

        int n = ring.length();
        // 做选择
        int res = Integer.MAX_VALUE;
        char c = key.charAt(j);
        // ring 上可能有多个字符 key[j]
        for (int k : charToIndex.getOrDefault(c, new ArrayList<>())) {
            // 拨动指针的次数
            int delta = Math.abs(k - i);
            // 选择顺时针还是逆时针
            delta = Math.min(delta, n - delta);
            // 将指针拨到 ring[k]，继续输入 key[j+1..]
            int subProblem = dp(ring, k, key, j + 1);
            // 选择「整体」操作次数最少的
            // 加一是因为按动按钮也是一次操作
            res = Math.min(res, 1 + delta + subProblem);
        }
        // 将结果存入备忘录
        memo[i][j] = res;
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 计算两个数相减的绝对值
func abs(a, b int) int {
    if a > b {
        return b - a + 2*b
    } else {
        return a - b + 2*b
    }
}

// 返回两个数的最小值
func min(a, b int) int {
    if a < b {
        return a
    } else {
        return b
    }
}

/* 主函数 */
func findRotateSteps(ring string, key string) int {
    m := len(ring)
    n := len(key)
    // 备忘录全部初始化为 0
    memo := make([][]int, m)
    for i := range memo {
        memo[i] = make([]int, n)
    }
    // 记录圆环上字符到索引的映射
    charToIndex := make(map[byte][]int)
    for i := range ring {
        charToIndex[ring[i]] = append(charToIndex[ring[i]], i)
    }
    // 圆盘指针最初指向 12 点钟方向，
    // 从第一个字符开始输入 key
    return dp(ring, 0, key, 0, charToIndex, memo)
}

// 计算圆盘指针在 ring[i]，输入 key[j..] 的最少操作数
func dp(ring string, i int, key string, j int, charToIndex map[byte][]int, memo [][]int) int {
    // base case 完成输入
    if j == len(key) {
        return 0
    }
    // 查找备忘录，避免重叠子问题
    if memo[i][j] != 0 {
        return memo[i][j]
    }

    n := len(ring)
    // 做选择
    res := math.MaxInt32
    // ring 上可能有多个字符 key[j]
    for _, k := range charToIndex[key[j]] {
        // 拨动指针的次数
        delta := abs(k-i, n)
        // 选择顺时针还是逆时针
        delta = min(delta, n-delta)
        // 将指针拨到 ring[k]，继续输入 key[j+1..]
        subProblem := dp(ring, k, key, j+1, charToIndex, memo)
        // 选择「整体」操作次数最少的
        // 加一是因为按动按钮也是一次操作
        res = min(res, 1+delta+subProblem)
    }
    // 将结果存入备忘录
    memo[i][j] = res
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var findRotateSteps = function(ring, key) {
    // 字符 -> 索引列表
    const charToIndex = {};
    // 备忘录
    const memo = [];

    /* 记录圆环上字符到索引的映射 */
    for (let i = 0; i < ring.length; i++) {
        const char = ring.charAt(i);
        if (charToIndex[char] === undefined) {
            charToIndex[char] = [];
        }
        charToIndex[char].push(i);
    }

    /* 计算圆盘指针在 ring[i]，输入 key[j..] 的最少操作数 */
    function dp(i, j) {
        // base case 完成输入
        if (j === key.length) {
            return 0;
        }
        // 查找备忘录，避免重叠子问题
        if (memo[i] !== undefined && memo[i][j] !== undefined) {
            return memo[i][j];
        }

        const n = ring.length;
        // 做选择
        let res = Infinity;
        // ring 上可能有多个字符 key[j]
        for (let k of charToIndex[key.charAt(j)]) {
            // 拨动指针的次数
            let delta = Math.abs(k - i);
            // 选择顺时针还是逆时针
            delta = Math.min(delta, n - delta);
            // 将指针拨到 ring[k]，继续输入 key[j+1..]
            const subProblem = dp(k, j + 1);
            // 选择「整体」操作次数最少的
            // 加一是因为按动按钮也是一次操作
            res = Math.min(res, 1 + delta + subProblem);
        }
        // 将结果存入备忘录
        if (memo[i] === undefined) {
            memo[i] = [];
        }
        memo[i][j] = res;
        return res;
    }

    return dp(0, 0);
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_freedom-trail" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_freedom-trail"></div></div>
</details><hr /><br />

</details>
</div>



