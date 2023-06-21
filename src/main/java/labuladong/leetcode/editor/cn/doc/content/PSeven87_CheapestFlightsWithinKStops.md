<p>There are <code>n</code> cities connected by some number of flights. You are given an array <code>flights</code> where <code>flights[i] = [from<sub>i</sub>, to<sub>i</sub>, price<sub>i</sub>]</code> indicates that there is a flight from city <code>from<sub>i</sub></code> to city <code>to<sub>i</sub></code> with cost <code>price<sub>i</sub></code>.</p>

<p>You are also given three integers <code>src</code>, <code>dst</code>, and <code>k</code>, return <em><strong>the cheapest price</strong> from </em><code>src</code><em> to </em><code>dst</code><em> with at most </em><code>k</code><em> stops. </em>If there is no such route, return<em> </em><code>-1</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2022/03/18/cheapest-flights-within-k-stops-3drawio.png" style="width: 332px; height: 392px;" /> 
<pre>
<strong>Input:</strong> n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
<strong>Output:</strong> 700
<strong>Explanation:</strong>
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2022/03/18/cheapest-flights-within-k-stops-1drawio.png" style="width: 332px; height: 242px;" /> 
<pre>
<strong>Input:</strong> n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
<strong>Output:</strong> 200
<strong>Explanation:</strong>
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2022/03/18/cheapest-flights-within-k-stops-2drawio.png" style="width: 332px; height: 242px;" /> 
<pre>
<strong>Input:</strong> n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
<strong>Output:</strong> 500
<strong>Explanation:</strong>
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 100</code></li> 
 <li><code>0 &lt;= flights.length &lt;= (n * (n - 1) / 2)</code></li> 
 <li><code>flights[i].length == 3</code></li> 
 <li><code>0 &lt;= from<sub>i</sub>, to<sub>i</sub> &lt; n</code></li> 
 <li><code>from<sub>i</sub> != to<sub>i</sub></code></li> 
 <li><code>1 &lt;= price<sub>i</sub> &lt;= 10<sup>4</sup></code></li> 
 <li>There will not be any multiple flights between two cities.</li> 
 <li><code>0 &lt;= src, dst, k &lt; n</code></li> 
 <li><code>src != dst</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 动态规划 | 最短路 | 堆（优先队列）</details><br>

<div>👍 585, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=cheapest-flights-within-k-stops" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

`dp` 函数的定义：**从起点 `src` 出发，`k` 步之内（一步就是一条边）到达节点 `s` 的最小路径权重为 `dp(s, k)`**。

这样，题目想求的最小机票开销就可以用 `dp(dst, K+1)` 来表示。

状态转移方程：

```java
dp(dst, k) = min(
    dp(s1, k - 1) + w1,
    dp(s2, k - 1) + w2
)
```

![](https://labuladong.github.io/pictures/旅行最短路径/4.jpeg)

**详细题解：[旅游省钱大法：加权最短路径](https://labuladong.github.io/article/fname.html?fname=旅行最短路径)**

**标签：[二维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)，[图论算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122000448684457990)，最短路径算法**

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
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution {
    unordered_map<int, vector<vector<int>>> indegree;
    int src, dst;
    // 备忘录
    vector<vector<int>> memo;

public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int K) {
        // 将中转站个数转化成边的条数
        K++;
        this->src = src;
        this->dst = dst;
        // 初始化备忘录，全部填一个特殊值
        memo = vector<vector<int>>(n, vector<int>(K + 1, -888));

        for (auto &f : flights) {
            int from = f[0];
            int to = f[1];
            int price = f[2];
            // 记录谁指向该节点，以及之间的权重
            indegree[to].push_back(vector<int>{from, price});
        }

        return dp(dst, K);
    }

    // 定义：从 src 出发，k 步之内到达 s 的最短路径权重
    int dp(int s, int k) {
        // base case
        if (s == src) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }
        // 查备忘录，防止冗余计算
        if (memo[s][k] != -888) {
            return memo[s][k];
        }

        // 初始化为最大值，方便等会取最小值
        int res = INT_MAX;
        if (indegree.count(s)) {
            // 当 s 有入度节点时，分解为子问题
            auto &v = indegree[s];
            for (auto &p : v) {
                int from = p[0];
                int price = p[1];
                // 从 src 到达相邻的入度节点所需的最短路径权重
                int subProblem = dp(from, k - 1);/**<extend up -300>![](https://labuladong.github.io/pictures/旅行最短路径/4.jpeg) */
                // 跳过无解的情况
                if (subProblem != -1) {
                    res = min(res, subProblem + price);
                }
            }
        }
        // 存入备忘录
        memo[s][k] = res == INT_MAX ? -1 : res;
        return memo[s][k];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, K: int) -> int:
        # 将中转站个数转化成边的条数
        K += 1
        # 初始化备忘录，全部填一个特殊值
        memo = [[-888] * (K + 1) for _ in range(n)]
        # 定义入度字典
        indegree = {}
        for f in flights:
            from_, to, price = f
            # 记录谁指向该节点，以及之间的权重
            if to not in indegree:
                indegree[to] = []
            indegree[to].append([from_, price])

        # 定义：从 src 出发，k 步之内到达 s 的最短路径权重
        def dp(s: int, k: int) -> int:
            # base case
            if s == src:
                return 0
            if k == 0:
                return -1
            # 查备忘录，防止冗余计算
            if memo[s][k] != -888:
                return memo[s][k]

            # 初始化为最大值，方便等会取最小值
            res = float('inf')
            if s in indegree:
                # 当 s 有入度节点时，分解为子问题
                for v in indegree[s]:
                    from_, price = v
                    # 从 src 到达相邻的入度节点所需的最短路径权重
                    sub_problem = dp(from_, k - 1)
                    # 跳过无解的情况
                    if sub_problem != -1:
                        res = min(res, sub_problem + price)

            # 存入备忘录
            memo[s][k] = -1 if res == float('inf') else res
            return memo[s][k]

        return dp(dst, K)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    HashMap<Integer, List<int[]>> indegree;
    int src, dst;
    // 备忘录
    int[][] memo;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // 将中转站个数转化成边的条数
        K++;
        this.src = src;
        this.dst = dst;
        // 初始化备忘录，全部填一个特殊值
        memo = new int[n][K + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -888);
        }

        indegree = new HashMap<>();
        for (int[] f : flights) {
            int from = f[0];
            int to = f[1];
            int price = f[2];
            // 记录谁指向该节点，以及之间的权重
            indegree.putIfAbsent(to, new LinkedList<>());
            indegree.get(to).add(new int[]{from, price});
        }

        return dp(dst, K);
    }

    // 定义：从 src 出发，k 步之内到达 s 的最短路径权重
    int dp(int s, int k) {
        // base case
        if (s == src) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }
        // 查备忘录，防止冗余计算
        if (memo[s][k] != -888) {
            return memo[s][k];
        }

        // 初始化为最大值，方便等会取最小值
        int res = Integer.MAX_VALUE;
        if (indegree.containsKey(s)) {
            // 当 s 有入度节点时，分解为子问题
            for (int[] v : indegree.get(s)) {
                int from = v[0];
                int price = v[1];
                // 从 src 到达相邻的入度节点所需的最短路径权重
                int subProblem = dp(from, k - 1);/**<extend up -300>![](https://labuladong.github.io/pictures/旅行最短路径/4.jpeg) */
                // 跳过无解的情况
                if (subProblem != -1) {
                    res = Math.min(res, subProblem + price);
                }
            }
        }
        // 存入备忘录
        memo[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[s][k];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func findCheapestPrice(n int, flights [][]int, src int, dst int, K int) int {
    // 将中转站个数转化成边的条数
    K++
    // 初始化备忘录，全部填一个特殊值
    memo := make([][]int, n)
    for i := range memo {
        memo[i] = make([]int, K+1)
        for j := range memo[i] {
            memo[i][j] = -888
        }
    }

    indegree := make(map[int][][]int)
    for _, f := range flights {
        from, to, price := f[0], f[1], f[2]
        // 记录谁指向该节点，以及之间的权重
        indegree[to] = append(indegree[to], []int{from, price})
    }

    return dp(dst, K, src, memo, indegree)
}

// 定义：从 src 出发，k 步之内到达 s 的最短路径权重
func dp(s int, k int, src int, memo [][]int, indegree map[int][][]int) int {
    // base case
    if s == src {
        return 0
    }
    if k == 0 {
        return -1
    }
    // 查备忘录，防止冗余计算
    if memo[s][k] != -888 {
        return memo[s][k]
    }

    // 初始化为最大值，方便等会取最小值
    res := math.MaxInt32
    if v, ok := indegree[s]; ok {
        // 当 s 有入度节点时，分解为子问题
        for _, edge := range v {
            from, price := edge[0], edge[1]
            // 从 src 到达相邻的入度节点所需的最短路径权重
            subProblem := dp(from, k-1, src, memo, indegree)
            // 跳过无解的情况
            if subProblem != -1 {
                res = min(res, subProblem+price)
            }
        }
    }
    // 存入备忘录
    if res == math.MaxInt32 {
        memo[s][k] = -1
    } else {
        memo[s][k] = res
    }
    return memo[s][k]
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

var findCheapestPrice = function(n, flights, src, dst, K) {
    // 将中转站个数转化成边的条数
    K++;
    // 定义备忘录
    const memo = Array.from({ length: n }, () => Array(K + 1).fill(-888));
    // 初始化起点和终点
    const [source, target] = [src, dst];

    // 构建入度字典
    const indegree = new Map();
    for (const [from, to, price] of flights) {
        indegree.set(to, (indegree.get(to) || []).concat([[from, price]]));
    }

    function dp(s, k) {
        // base case
        if (s === source) {
            return 0;
        }
        if (k === 0) {
            return -1;
        }
        // 查备忘录，防止冗余计算
        if (memo[s][k] !== -888) {
            return memo[s][k];
        }

        // 初始化为最大值，方便等会取最小值
        let res = Infinity;
        if (indegree.has(s)) {
            // 当 s 有入度节点时，分解为子问题
            for (const [from, price] of indegree.get(s)) {
                // 从 src 到达相邻的入度节点所需的最短路径权重
                const subProblem = dp(from, k - 1);/**<extend up -300>![](https://labuladong.github.io/pictures/旅行最短路径/4.jpeg) */
                // 跳过无解的情况
                if (subProblem !== -1) {
                    res = Math.min(res, subProblem + price);
                }
            }
        }
        // 存入备忘录
        memo[s][k] = res === Infinity ? -1 : res;
        return memo[s][k];
    }

    return dp(target, K);
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_cheapest-flights-within-k-stops" data="iwGAbnVsbAM="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_cheapest-flights-within-k-stops"></div></div>
</details><hr /><br />

</details>
</div>



