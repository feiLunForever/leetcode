<p>You are given an undirected weighted graph of&nbsp;<code>n</code>&nbsp;nodes (0-indexed), represented by an edge list where&nbsp;<code>edges[i] = [a, b]</code>&nbsp;is an undirected edge connecting the nodes&nbsp;<code>a</code>&nbsp;and&nbsp;<code>b</code>&nbsp;with a probability of success of traversing that edge&nbsp;<code>succProb[i]</code>.</p>

<p>Given two nodes&nbsp;<code>start</code>&nbsp;and&nbsp;<code>end</code>, find the path with the maximum probability of success to go from&nbsp;<code>start</code>&nbsp;to&nbsp;<code>end</code>&nbsp;and return its success probability.</p>

<p>If there is no path from&nbsp;<code>start</code>&nbsp;to&nbsp;<code>end</code>, <strong>return&nbsp;0</strong>. Your answer will be accepted if it differs from the correct answer by at most <strong>1e-5</strong>.</p>

<p>&nbsp;</p> 
<p><strong>Example 1:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/09/20/1558_ex1.png" style="width: 187px; height: 186px;" /></strong></p>

<pre>
<strong>Input:</strong> n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
<strong>Output:</strong> 0.25000
<strong>Explanation:</strong>&nbsp;There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
</pre>

<p><strong>Example 2:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/09/20/1558_ex2.png" style="width: 189px; height: 186px;" /></strong></p>

<pre>
<strong>Input:</strong> n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
<strong>Output:</strong> 0.30000
</pre>

<p><strong>Example 3:</strong></p>

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

<details><summary><strong>Related Topics</strong></summary>图 | 最短路 | 堆（优先队列）</details><br>

<div>👍 110, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V1.9，点击这里体验 [刷题全家桶](https://labuladong.gitee.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg)。**



<p><strong><a href="https://labuladong.github.io/article?qno=1514" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

虽然这题让计算最大值，但是也可以用 Dijkstra 算法模板，由于 Dijkstra 算法背景知识较多，请看详细题解。

**详细题解：[Dijkstra 算法模板及应用](https://labuladong.github.io/article/fname.html?fname=dijkstra算法)**

**标签：Dijkstra 算法，[图论算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122000448684457990)，最短路径算法**

## 解法代码

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

**类似题目**：
  - [1631. 最小体力消耗路径 🟠](/problems/path-with-minimum-effort)
  - [743. 网络延迟时间 🟠](/problems/network-delay-time)

</details>
</div>



