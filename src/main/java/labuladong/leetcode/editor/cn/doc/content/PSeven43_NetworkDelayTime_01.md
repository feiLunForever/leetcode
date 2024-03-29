<p>You are given a network of <code>n</code> nodes, labeled from <code>1</code> to <code>n</code>. You are also given <code>times</code>, a list of travel times as directed edges <code>times[i] = (u<sub>i</sub>, v<sub>i</sub>, w<sub>i</sub>)</code>, where <code>u<sub>i</sub></code> is the source node, <code>v<sub>i</sub></code> is the target node, and <code>w<sub>i</sub></code> is the time it takes for a signal to travel from source to target.</p>

<p>We will send a signal from a given node <code>k</code>. Return <em>the <strong>minimum</strong> time it takes for all the</em> <code>n</code> <em>nodes to receive the signal</em>. If it is impossible for all the <code>n</code> nodes to receive the signal, return <code>-1</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2019/05/23/931_example_1.png" style="width: 217px; height: 239px;" /> 
<pre>
<strong>Input:</strong> times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> times = [[1,2,1]], n = 2, k = 1
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> times = [[1,2,1]], n = 2, k = 2
<strong>Output:</strong> -1
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= k &lt;= n &lt;= 100</code></li> 
 <li><code>1 &lt;= times.length &lt;= 6000</code></li> 
 <li><code>times[i].length == 3</code></li> 
 <li><code>1 &lt;= u<sub>i</sub>, v<sub>i</sub> &lt;= n</code></li> 
 <li><code>u<sub>i</sub> != v<sub>i</sub></code></li> 
 <li><code>0 &lt;= w<sub>i</sub> &lt;= 100</code></li> 
 <li>All the pairs <code>(u<sub>i</sub>, v<sub>i</sub>)</code> are <strong>unique</strong>. (i.e., no multiple edges.)</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 最短路 | 堆（优先队列）</details><br>

<div>👍 701, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=network-delay-time" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

典型的 Dijkstra 算法应用场景，把延迟看做边的权重，最小延迟就是最小权重路径。

Dijkstra 算法模板的背景知识较多，请看详细题解。

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

class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        // 节点编号是从 1 开始的，所以要一个大小为 n + 1 的邻接表
        vector<vector<pair<int, int>>> graph(n + 1);
        for (int i = 1; i <= n; i++) {
            graph[i] = vector<pair<int, int>>();
        }
        // 构造图
        for (auto& edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            // from -> List<(to, weight)>
            // 邻接表存储图结构，同时存储权重信息
            graph[from].emplace_back(to, weight);
        }
        // 启动 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
        vector<int> distTo = dijkstra(k, graph, n);

        // 找到最长的那一条最短路径
        int res = 0;
        for (int i = 1; i < distTo.size(); i++) {
            if (distTo[i] == INT_MAX) {
                // 有节点不可达，返回 -1
                return -1;
            }
            res = max(res, distTo[i]);
        }
        return res;
    }

private:
    // 输入一个起点 start，计算从 start 到其他节点的最短距离
    vector<int> dijkstra(int start, vector<vector<pair<int, int>>>& graph, int n) {
        // 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
        vector<int> distTo(n + 1, INT_MAX);
        // base case，start 到 start 的最短距离就是 0
        distTo[start] = 0;

        // 优先级队列，distFromStart 较小的排在前面
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        // 从起点 start 开始进行 BFS
        pq.emplace(0, start);

        while (!pq.empty()) {
            auto [curDistFromStart, curNodeID] = pq.top();
            pq.pop();

            if (curDistFromStart > distTo[curNodeID]) {
                continue;
            }

            // 将 curNode 的相邻节点装入队列
            for (auto& [nextNodeID, weight] : graph[curNodeID]) {
                int distToNextNode = distTo[curNodeID] + weight;
                // 更新 dp table
                if (distTo[nextNodeID] > distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    pq.emplace(distToNextNode, nextNodeID);
                }
            }
        }
        return distTo;
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
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        # 节点编号是从 1 开始的，所以要一个大小为 n + 1 的邻接表
        graph = [[] for _ in range(n+1)]
        for edge in times:
            from_node, to_node, weight = edge[0], edge[1], edge[2]
            # from -> List<(to, weight)>
            # 邻接表存储图结构，同时存储权重信息
            graph[from_node].append((to_node, weight))
        # 启动 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
        dist_to = self.dijkstra(k, graph)

        # 找到最长的那一条最短路径
        res = 0
        for i in range(1, len(dist_to)):
            if dist_to[i] == float('inf'):
                # 有节点不可达，返回 -1
                return -1
            res = max(res, dist_to[i])
        return res

    class State:
        # 图节点的 id
        def __init__(self, id: int, dist_from_start: int):
            self.id = id
            # 从 start 节点到当前节点的距离
            self.dist_from_start = dist_from_start

        def __lt__(self, other):
            return self.dist_from_start < other.dist_from_start

    # 输入一个起点 start，计算从 start 到其他节点的最短距离
    def dijkstra(self, start: int, graph: List[List[int]]) -> List[int]:
        # 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
        dist_to = [float('inf')] * len(graph)
        # base case，start 到 start 的最短距离就是 0
        dist_to[start] = 0

        # 优先级队列，distFromStart 较小的排在前面
        pq = [Solution.State(start, 0)]
        # 从起点 start 开始进行 BFS
        heapq.heapify(pq)

        while pq:
            cur_state = heapq.heappop(pq)
            cur_node_id = cur_state.id
            cur_dist_from_start = cur_state.dist_from_start

            if cur_dist_from_start > dist_to[cur_node_id]:
                continue

            # 将 cur_node 的相邻节点装入队列
            for neighbor in graph[cur_node_id]:
                next_node_id, dist_to_next_node = neighbor[0], dist_to[cur_node_id] + neighbor[1]
                # 更新 dp table
                if dist_to[next_node_id] > dist_to_next_node:
                    dist_to[next_node_id] = dist_to_next_node
                    heapq.heappush(pq, Solution.State(next_node_id, dist_to_next_node))
        return dist_to
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 节点编号是从 1 开始的，所以要一个大小为 n + 1 的邻接表
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        // 构造图
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            // from -> List<(to, weight)>
            // 邻接表存储图结构，同时存储权重信息
            graph[from].add(new int[]{to, weight});
        }
        // 启动 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
        int[] distTo = dijkstra(k, graph);

        // 找到最长的那一条最短路径
        int res = 0;
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i] == Integer.MAX_VALUE) {
                // 有节点不可达，返回 -1
                return -1;
            }
            res = Math.max(res, distTo[i]);
        }
        return res;
    }

    class State {
        // 图节点的 id
        int id;
        // 从 start 节点到当前节点的距离
        int distFromStart;

        State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    // 输入一个起点 start，计算从 start 到其他节点的最短距离
    int[] dijkstra(int start, List<int[]>[] graph) {
        // 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case，start 到 start 的最短距离就是 0
        distTo[start] = 0;

        // 优先级队列，distFromStart 较小的排在前面
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });
        // 从起点 start 开始进行 BFS
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            int curDistFromStart = curState.distFromStart;

            if (curDistFromStart > distTo[curNodeID]) {
                continue;
            }

            // 将 curNode 的相邻节点装入队列
            for (int[] neighbor : graph[curNodeID]) {
                int nextNodeID = neighbor[0];
                int distToNextNode = distTo[curNodeID] + neighbor[1];
                // 更新 dp table
                if (distTo[nextNodeID] > distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return distTo;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

import (
	"container/heap"
	"math"
)

func networkDelayTime(times [][]int, n int, k int) int {
	// 节点编号是从 1 开始的，所以要一个大小为 n + 1 的邻接表
	graph := make([][][]int, n+1)
	for i := 1; i <= n; i++ {
		graph[i] = make([][]int, 0)
	}

	// 构造图
	for _, edge := range times {
		from := edge[0]
		to := edge[1]
		weight := edge[2]
		// from -> [ [to, weight], ... ]
		// 邻接表存储图结构，同时存储权重信息
		graph[from] = append(graph[from], []int{to, weight})
	}

	// 启动 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
	distTo := dijkstra(k, graph)

	// 找到最长的那一条最短路径
	res := 0
	for i := 1; i < len(distTo); i++ {
		if distTo[i] == math.MaxInt32 {
			// 有节点不可达，返回 -1
			return -1
		}
		res = max(res, distTo[i])
	}
	return res
}

type State struct {
	// 图节点的 id
	id int
	// 从 start 节点到当前节点的距离
	distFromStart int
}

type PriorityQueue []*State

func (pq PriorityQueue) Len() int { return len(pq) }
func (pq PriorityQueue) Less(i, j int) bool {
	return pq[i].distFromStart < pq[j].distFromStart
}
func (pq PriorityQueue) Swap(i, j int) { pq[i], pq[j] = pq[j], pq[i] }

func (pq *PriorityQueue) Push(x interface{}) {
	item := x.(*State)
	*pq = append(*pq, item)
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	old[n-1] = nil       // avoid memory leak
	*pq = old[0 : n-1]
	return item
}

// 输入一个起点 start，计算从 start 到其他节点的最短距离
func dijkstra(start int, graph [][][]int) []int {
	// 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
	distTo := make([]int, len(graph))
	for i := 1; i < len(graph); i++ {
		distTo[i] = math.MaxInt32
	}
	// base case，start 到 start 的最短距离就是 0
	distTo[start] = 0

	// 优先级队列，distFromStart 较小的排在前面
	pq := make(PriorityQueue, 0)
	heap.Init(&pq)
	// 从起点 start 开始进行 BFS
	heap.Push(&pq, &State{id: start, distFromStart: 0})

	for pq.Len() > 0 {
		curState := heap.Pop(&pq).(*State)
		curNodeID := curState.id
		curDistFromStart := curState.distFromStart

		if curDistFromStart > distTo[curNodeID] {
			continue
		}

		// 将 curNode 的相邻节点装入队列
		for _, neighbor := range graph[curNodeID] {
			nextNodeID := neighbor[0]
			distToNextNode := distTo[curNodeID] + neighbor[1]
			// 更新 dp table
			if distTo[nextNodeID] > distToNextNode {
				distTo[nextNodeID] = distToNextNode
				heap.Push(&pq, &State{id: nextNodeID, distFromStart: distToNextNode})
			}
		}
	}
	return distTo
}

func max(a, b int) int {
	if a > b {
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

var networkDelayTime = function(times, n, k) {
    // 节点编号是从 1 开始的，所以要一个大小为 n + 1 的邻接表
    let graph = new Array(n + 1);
    for (let i = 1; i <= n; i++) {
        graph[i] = [];
    }
    // 构造图
    for (let edge of times) {
        let from = edge[0];
        let to = edge[1];
        let weight = edge[2];
        // from -> List<(to, weight)>
        // 邻接表存储图结构，同时存储权重信息
        graph[from].push([to, weight]);
    }
    // 启动 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
    let distTo = dijkstra(k, graph);

    // 找到最长的那一条最短路径
    let res = 0;
    for (let i = 1; i < distTo.length; i++) {
        if (distTo[i] === Infinity) {
            // 有节点不可达，返回 -1
            return -1;
        }
        res = Math.max(res, distTo[i]);
    }
    return res;
};

class State {
    // 图节点的 id
    constructor(id, distFromStart) {
        this.id = id;
        // 从 start 节点到当前节点的距离
        this.distFromStart = distFromStart;
    }
}

// 输入一个起点 start，计算从 start 到其他节点的最短距离
function dijkstra(start, graph) {
    // 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
    let distTo = new Array(graph.length).fill(Infinity);
    // base case，start 到 start 的最短距离就是 0
    distTo[start] = 0;

    // 优先级队列，distFromStart 较小的排在前面
    let pq = [];
    // 从起点 start 开始进行 BFS
    pq.push(new State(start, 0));
    pq.sort((a, b) => {
        return a.distFromStart - b.distFromStart;
    });

    while (pq.length > 0) {
        let curState = pq.shift();
        let curNodeID = curState.id;
        let curDistFromStart = curState.distFromStart;

        if (curDistFromStart > distTo[curNodeID]) {
            continue;
        }

        // 将 curNode 的相邻节点装入队列
        for (let neighbor of graph[curNodeID]) {
            let nextNodeID = neighbor[0];
            let distToNextNode = distTo[curNodeID] + neighbor[1];
            // 更新 dp table
            if (distTo[nextNodeID] > distToNextNode) {
                distTo[nextNodeID] = distToNextNode;
                pq.push(new State(nextNodeID, distToNextNode));
                pq.sort((a, b) => {
                    return a.distFromStart - b.distFromStart;
                });
            }
        }
    }
    return distTo;
}
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_network-delay-time" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_network-delay-time"></div></div>
</details><hr /><br />

**类似题目**：
  - [1514. 概率最大的路径 🟠](/problems/path-with-maximum-probability)
  - [1631. 最小体力消耗路径 🟠](/problems/path-with-minimum-effort)

</details>
</div>



