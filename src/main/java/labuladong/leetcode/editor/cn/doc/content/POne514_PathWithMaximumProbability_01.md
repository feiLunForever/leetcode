<p>You are given an undirected weighted graph of&nbsp;<code>n</code>&nbsp;nodes (0-indexed), represented by an edge list where&nbsp;<code>edges[i] = [a, b]</code>&nbsp;is an undirected edge connecting the nodes&nbsp;<code>a</code>&nbsp;and&nbsp;<code>b</code>&nbsp;with a probability of success of traversing that edge&nbsp;<code>succProb[i]</code>.</p>

<p>Given two nodes&nbsp;<code>start</code>&nbsp;and&nbsp;<code>end</code>, find the path with the maximum probability of success to go from&nbsp;<code>start</code>&nbsp;to&nbsp;<code>end</code>&nbsp;and return its success probability.</p>

<p>If there is no path from&nbsp;<code>start</code>&nbsp;to&nbsp;<code>end</code>, <strong>return&nbsp;0</strong>. Your answer will be accepted if it differs from the correct answer by at most <strong>1e-5</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/09/20/1558_ex1.png" style="width: 187px; height: 186px;" /></strong></p>

<pre>
<strong>Input:</strong> n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
<strong>Output:</strong> 0.25000
<strong>Explanation:</strong>&nbsp;There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
</pre>

<p><strong class="example">Example 2:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/09/20/1558_ex2.png" style="width: 189px; height: 186px;" /></strong></p>

<pre>
<strong>Input:</strong> n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
<strong>Output:</strong> 0.30000
</pre>

<p><strong class="example">Example 3:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/09/20/1558_ex3.png" style="width: 215px; height: 191px;" /></strong></p>

<pre>
<strong>Input:</strong> n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
<strong>Output:</strong> 0.00000
<strong>Explanation:</strong>&nbsp;There is no path between 0 and 2.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>2 &lt;= n &lt;= 10^4</code></li> 
 <li><code>0 &lt;= start, end &lt; n</code></li> 
 <li><code>start != end</code></li> 
 <li><code>0 &lt;= a, b &lt; n</code></li> 
 <li><code>a != b</code></li> 
 <li><code>0 &lt;= succProb.length == edges.length &lt;= 2*10^4</code></li> 
 <li><code>0 &lt;= succProb[i] &lt;= 1</code></li> 
 <li>There is at most one edge between every two nodes.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>图 | 数组 | 最短路 | 堆（优先队列）</details><br>

<div>👍 141, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=path-with-maximum-probability" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

虽然这题让计算最大值，但是也可以用 Dijkstra 算法模板，由于 Dijkstra 算法背景知识较多，请看详细题解。

**详细题解：[Dijkstra 算法模板及应用](https://labuladong.github.io/article/fname.html?fname=dijkstra算法)**

**标签：Dijkstra 算法，[图论算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122000448684457990)，最短路径算法**

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

#include <bits/stdc++.h>
using namespace std;

// struct 不再需要声明，直接在结构体内进行定义
class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
        vector<vector<pair<double, int>>> graph(n);
        for (int i = 0; i < edges.size(); i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double weight = succProb[i];
            // 无向图其实就是双向图
            graph[from].push_back(make_pair(weight, to));
            graph[to].push_back(make_pair(weight, from));
        }
        return dijkstra(start, end, graph);
    }

    struct State {
        int id;
        double distFromStart;
        State(int id, double distFromStart) : id(id), distFromStart(distFromStart) {}
        bool operator < (const State& rhs) const {
            return distFromStart < rhs.distFromStart;
        }
    };

    double dijkstra(int start, int end, vector<vector<pair<double, int>>>& graph) {
        int V = graph.size();
        vector<double> distTo(V, -1);
        distTo[start] = 1;
        priority_queue<State> pq;
        pq.push(State(start, 1));
        while (!pq.empty()) {
            State curState = pq.top();
            pq.pop();
            int curNodeID = curState.id;
            double curDistFromStart = curState.distFromStart;
            if (curNodeID == end) {
                return curDistFromStart;
            }
            if (curDistFromStart < distTo[curNodeID]) {
                continue;
            }
            for (auto neighbor : graph[curNodeID]) {
                int nextNodeID = neighbor.second;
                double distToNextNode = distTo[curNodeID] * neighbor.first;
                if (distTo[nextNodeID] < distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    pq.push(State(nextNodeID, distToNextNode));
                }
            }
        }
        return 0.0;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

import heapq
from typing import List


class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start: int, end: int) -> float:
        graph = [[] for _ in range(n)]
        for i in range(len(edges)):
            from_, to = edges[i][0], edges[i][1]
            weight = succProb[i]
            graph[from_].append((to, weight))
            graph[to].append((from_, weight))

        return self.dijkstra(start, end, graph)

    class State:
        def __init__(self, id_, distFromStart):
            self.id = id_
            self.distFromStart = distFromStart

        def __lt__(self, other):
            return self.distFromStart > other.distFromStart

    def dijkstra(self, start, end, graph):
        V = len(graph)
        # 记录最短路径的权重，你可以理解为 dp table
        # 定义：distTo[i] 的值就是节点 start 到达节点 i 的最短路径权重
        distTo = [-1] * V
        # dp table 初始化为正无穷
        distTo[start] = 1

        # 优先级队列，distFromStart 较小的排在前面
        pq = []
        # 从起点 start 开始进行 BFS
        heapq.heappush(pq, self.State(start, 1))

        while pq:
            curState = heapq.heappop(pq)
            curNodeID = curState.id
            curDistFromStart = curState.distFromStart

            # 在这里加一个判断就行了，其他代码不用改
            if curNodeID == end:
                return curDistFromStart

            if curDistFromStart < distTo[curNodeID]:
                # 已经有一条更短的路径到达 curNode 节点了
                continue
            # 将 curNode 的相邻节点装入队列
            for neighbor in graph[curNodeID]:
                nextNodeID = neighbor[0]
                # 看看从 curNode 达到 nextNode 的距离是否会更短
                distToNextNode = distTo[curNodeID] * neighbor[1]
                if distTo[nextNodeID] < distToNextNode:
                    # 更新 dp table
                    distTo[nextNodeID] = distToNextNode
                    # 将这个节点以及距离放入队列
                    heapq.heappush(pq, self.State(nextNodeID, distToNextNode))
        return 0.0
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        // 构造无向图
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double weight = succProb[i];
            // 无向图其实就是双向图
            graph[from].add(new double[]{(double)to, weight});
            graph[to].add(new double[]{(double)from, weight});
        }
        
        
        return dijkstra(start, end, graph);
    }
    
    class State {
        // 图节点的 id
        int id;
        // 从 start 节点到当前节点的距离
        double distFromStart;

        State(int id, double distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }
    
    double dijkstra(int start, int end, List<double[]>[] graph) {
        // 图中节点的个数
        int V = graph.length;
        // 记录最短路径的权重，你可以理解为 dp table
        // 定义：distTo[i] 的值就是节点 start 到达节点 i 的最短路径权重
        double[] distTo = new double[V];
        // dp table 初始化为正无穷
        Arrays.fill(distTo, -1);
        // base case，start 到 start 的最短距离就是 0
        distTo[start] = 1;

        // 优先级队列，distFromStart 较小的排在前面
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.distFromStart, a.distFromStart);
        });
        // 从起点 start 开始进行 BFS
        pq.offer(new State(start, 1));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            double curDistFromStart = curState.distFromStart;

            // 在这里加一个判断就行了，其他代码不用改
            if (curNodeID == end) {
                return curDistFromStart;
            }
            
            if (curDistFromStart < distTo[curNodeID]) {
                // 已经有一条更短的路径到达 curNode 节点了
                continue;
            }
            // 将 curNode 的相邻节点装入队列
            for (double[] neighbor : graph[curNodeID]) {
                int nextNodeID = (int)neighbor[0];
                // 看看从 curNode 达到 nextNode 的距离是否会更短
                double distToNextNode = distTo[curNodeID] * neighbor[1];
                if (distTo[nextNodeID] < distToNextNode) {
                    // 更新 dp table
                    distTo[nextNodeID] = distToNextNode;
                    // 将这个节点以及距离放入队列
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return 0.0;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

type State struct {
    id   int
    dist float64
}

func maxProbability(n int, edges [][]int, succProb []float64, start int, end int) float64 {
    graph := make([][]State, n)
    for i := 0; i < n; i++ {
        graph[i] = make([]State, 0)
    }

    // 构造无向图
    for i := 0; i < len(edges); i++ {
        from := edges[i][0]
        to := edges[i][1]
        weight := succProb[i]
        // 无向图其实就是双向图
        graph[from] = append(graph[from], State{to, weight})
        graph[to] = append(graph[to], State{from, weight})
    }

    return dijkstra(start, end, graph)
}

func dijkstra(start int, end int, graph [][]State) float64 {
    // 图中节点的个数
    V := len(graph)
    // 记录最短路径的权重，你可以理解为 dp table
    // 定义：distTo[i] 的值就是节点 start 到达节点 i 的最短路径权重
    distTo := make([]float64, V)
    // dp table 初始化为正无穷
    for i := 0; i < V; i++ {
        distTo[i] = -1
    }
    // base case，start 到 start 的最短距离就是 0
    distTo[start] = 1

    // 优先级队列，distFromStart 较小的排在前面
    pq := make(PriorityQueue, 0)
    heap.Init(&pq)
    //从起点 start 开始进行 BFS
    heap.Push(&pq, &State{id: start, dist: 1})

    for pq.Len() > 0 {
        curState := heap.Pop(&pq).(*State)
        curNodeID := curState.id
        curDistFromStart := curState.dist

        // 在这里加一个判断就行了，其他代码不用改
        if curNodeID == end {
            return curDistFromStart
        }

        if curDistFromStart < distTo[curNodeID] {
            // 已经有一条更短的路径到达 curNode 节点了
            continue
        }
        // 将 curNode 的相邻节点装入队列
        for _, neighbor := range graph[curNodeID] {
            nextNodeID := neighbor.id
            // 看看从 curNode 达到 nextNode 的距离是否会更短
            distToNextNode := distTo[curNodeID] * neighbor.dist
            if distTo[nextNodeID] < distToNextNode {
                // 更新 dp table
                distTo[nextNodeID] = distToNextNode
                // 将这个节点以及距离放入队列
                heap.Push(&pq, &State{nextNodeID, distToNextNode})
            }
        }
    }
    return 0.0
}

// 优先级队列数据结构，用于实现 BFS 广度优先搜索
type PriorityQueue []*State

func (pq PriorityQueue) Len() int {
    return len(pq)
}

func (pq PriorityQueue) Less(i, j int) bool {
    return pq[i].dist > pq[j].dist
}

func (pq PriorityQueue) Swap(i, j int) {
    pq[i], pq[j] = pq[j], pq[i]
}

func (pq *PriorityQueue) Push(x interface{}) {
    item := x.(*State)
    *pq = append(*pq, item)
}

func (pq *PriorityQueue) Pop() interface{} {
    old := *pq
    n := len(old)
    item := old[n-1]
    *pq = old[0 : n-1]
    return item
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码不保证正确性，仅供参考。如有疑惑，可以参照我写的 java 代码对比查看。

/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number[]} succProb
 * @param {number} start
 * @param {number} end
 * @return {number}
 */
var maxProbability = function(n, edges, succProb, start, end) {
    const graph = [];
    for (let i = 0; i < n; i++) {
        graph[i] = [];
    }
    // 构造无向图
    for (let i = 0; i < edges.length; i++) {
        const from = edges[i][0];
        const to = edges[i][1];
        const weight = succProb[i];
        // 无向图其实就是双向图
        graph[from].push([to, weight]);
        graph[to].push([from, weight]);
    }


    return dijkstra(start, end, graph);
};

class State {
    // 图节点的 id
    constructor(id, distFromStart) {
        this.id = id;
        // 从 start 节点到当前节点的距离
        this.distFromStart = distFromStart;
    }
}

function dijkstra(start, end, graph) {
    // 图中节点的个数
    const V = graph.length;
    // 记录最短路径的权重，你可以理解为 dp table
    // 定义：distTo[i] 的值就是节点 start 到达节点 i 的最短路径权重
    const distTo = new Array(V).fill(-1);
    // dp table 初始化为正无穷
    distTo[start] = 1;

    // 优先级队列，distFromStart 较小的排在前面
    const pq = new PriorityQueue((a, b) => {
        return b.distFromStart - a.distFromStart;
    });
    // 从起点 start 开始进行 BFS
    pq.offer(new State(start, 1));

    while (!pq.isEmpty()) {
        const curState = pq.poll();
        const curNodeID = curState.id;
        const curDistFromStart = curState.distFromStart;

        // 在这里加一个判断就行了，其他代码不用改
        if (curNodeID === end) {
            return curDistFromStart;
        }

        if (curDistFromStart < distTo[curNodeID]) {
            // 已经有一条更短的路径到达 curNode 节点了
            continue;
        }
        // 将 curNode 的相邻节点装入队列
        for (const neighbor of graph[curNodeID]) {
            const nextNodeID = neighbor[0];
            // 看看从 curNode 达到 nextNode 的距离是否会更短
            const distToNextNode = distTo[curNodeID] * neighbor[1];
            if (distTo[nextNodeID] < distToNextNode) {
                // 更新 dp table
                distTo[nextNodeID] = distToNextNode;
                // 将这个节点以及距离放入队列
                pq.offer(new State(nextNodeID, distToNextNode));
            }
        }
    }
    return 0.0;
}

class PriorityQueue {
    constructor(compare) {
        this.queue = [];
        this.compare = compare;
    }

    offer(val) {
        this.queue.push(val);
        this.queue.sort(this.compare);
    }

    poll() {
        return this.queue.shift();
    }

    isEmpty() {
        return this.queue.length === 0;
    }
}
```

</div></div>
</div></div>

**类似题目**：
  - [1631. 最小体力消耗路径 🟠](/problems/path-with-minimum-effort)
  - [743. 网络延迟时间 🟠](/problems/network-delay-time)

</details>
</div>



