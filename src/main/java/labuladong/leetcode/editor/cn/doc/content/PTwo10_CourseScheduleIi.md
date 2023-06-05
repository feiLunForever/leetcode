<p>There are a total of <code>numCourses</code> courses you have to take, labeled from <code>0</code> to <code>numCourses - 1</code>. You are given an array <code>prerequisites</code> where <code>prerequisites[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that you <strong>must</strong> take course <code>b<sub>i</sub></code> first if you want to take course <code>a<sub>i</sub></code>.</p>

<ul> 
 <li>For example, the pair <code>[0, 1]</code>, indicates that to take course <code>0</code> you have to first take course <code>1</code>.</li> 
</ul>

<p>Return <em>the ordering of courses you should take to finish all courses</em>. If there are many valid answers, return <strong>any</strong> of them. If it is impossible to finish all courses, return <strong>an empty array</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> numCourses = 2, prerequisites = [[1,0]]
<strong>Output:</strong> [0,1]
<strong>Explanation:</strong> There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
<strong>Output:</strong> [0,2,1,3]
<strong>Explanation:</strong> There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> numCourses = 1, prerequisites = []
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= numCourses &lt;= 2000</code></li> 
 <li><code>0 &lt;= prerequisites.length &lt;= numCourses * (numCourses - 1)</code></li> 
 <li><code>prerequisites[i].length == 2</code></li> 
 <li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; numCourses</code></li> 
 <li><code>a<sub>i</sub> != b<sub>i</sub></code></li> 
 <li>All the pairs <code>[a<sub>i</sub>, b<sub>i</sub>]</code> are <strong>distinct</strong>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 拓扑排序</details><br>

<div>👍 778, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=course-schedule-ii" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[拓扑排序详解及应用](https://www.bilibili.com/video/BV1kW4y1y7Ew)

直观地说，拓扑排序就是让你把一幅无环图「拉平」，而且这个「拉平」的图里面，所有箭头方向都是一致的：

![](https://labuladong.github.io/pictures/拓扑排序/top.jpg)

在进行拓扑排序之前，首先要确保图中无环，这就依赖 [207. 课程表](/problems/course-schedule) 中讲的环检测算法。

拓扑排序可以使用 DFS 算法，图的后序遍历结果进行反转就是拓扑排序结果。

另外，也可以用 BFS 算法借助每个节点的入度进行拓扑排序，这里就用 BFS 算法来解决。

DFS 解法和算法执行过程详解请看详细题解。

**详细题解：[环检测及拓扑排序算法](https://labuladong.github.io/article/fname.html?fname=拓扑排序)**

**标签：[图论算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122000448684457990)，拓扑排序，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)**

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
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        // 建图，和环检测算法相同
        vector<vector<int>> graph(numCourses);
        // 计算入度，和环检测算法相同
        vector<int> indegree(numCourses, 0);
        for (auto& edge : prerequisites) {
            int from = edge[1], to = edge[0];
            graph[from].push_back(to);
            indegree[to]++;
        }

        // 根据入度初始化队列中的节点，和环检测算法相同
        queue<int> q;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }

        // 记录拓扑排序结果
        vector<int> res;
        // 开始执行 BFS 算法
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            // 弹出节点的顺序即为拓扑排序结果
            res.push_back(cur);
            for (int next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.push(next);
                }
            }
        }

        if (res.size() != numCourses) {
            // 存在环，拓扑排序不存在
            return {};
        }

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
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        # 建图，和环检测算法相同
        graph = self.buildGraph(numCourses, prerequisites)
        # 计算入度，和环检测算法相同
        indegree = [0] * numCourses
        for edge in prerequisites:
            from_course, to_course = edge[1], edge[0]
            indegree[to_course] += 1

        # 根据入度初始化队列中的节点，和环检测算法相同
        q = []
        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)

        # 记录拓扑排序结果
        res = []
        # 记录遍历节点的顺序（索引）
        count = 0
        # 开始执行 BFS 算法
        while q:
            cur = q.pop(0)
            # 弹出节点的顺序即为拓扑排序结果
            res.append(cur)
            count += 1
            for next_course in graph[cur]:
                indegree[next_course] -= 1
                if indegree[next_course] == 0:
                    q.append(next_course)

        if count != numCourses:
            # 存在环，拓扑排序不存在
            return []

        return res

    # 建图函数
    def buildGraph(self, numCourses: int, prerequisites: List[List[int]]) -> List[List[int]]:
        # 图中共有 numCourses 个节点
        graph = [[] for _ in range(numCourses)]
        for edge in prerequisites:
            from_course, to_course = edge[1], edge[0]
            # 修完课程 from 才能修课程 to
            # 在图中添加一条从 from 指向 to 的有向边
            graph[from_course].append(to_course)
        return graph
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 主函数
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 建图，和环检测算法相同
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        // 计算入度，和环检测算法相同
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            indegree[to]++;
        }

        // 根据入度初始化队列中的节点，和环检测算法相同
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);/**<extend up -200>![](https://labuladong.github.io/pictures/拓扑排序/6.jpeg) */
            }
        }

        // 记录拓扑排序结果
        int[] res = new int[numCourses];
        // 记录遍历节点的顺序（索引）
        int count = 0;
        // 开始执行 BFS 算法
        while (!q.isEmpty()) {
            int cur = q.poll();
            // 弹出节点的顺序即为拓扑排序结果
            res[count] = cur;
            count++;
            for (int next : graph[cur]) {/**<extend up -200>![](https://labuladong.github.io/pictures/拓扑排序/7.jpeg) */
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        if (count != numCourses) {
            // 存在环，拓扑排序不存在
            return new int[]{};
        }
        
        return res;
    }

    // 建图函数
    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        // 图中共有 numCourses 个节点
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            // 修完课程 from 才能修课程 to
            // 在图中添加一条从 from 指向 to 的有向边
            graph[from].add(to);
        }
        return graph;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

func findOrder(numCourses int, prerequisites [][]int) []int {
    // 建图，和环检测算法相同
    graph := buildGraph(numCourses, prerequisites)
    // 计算入度，和环检测算法相同
    indegree := make([]int, numCourses)
    for _, edge := range prerequisites {
        _, to := edge[1], edge[0]
        from, to := edge[1], edge[0]
        _, to := edge[1], edge[0]
        from, to := edge[1], edge[0]
        _, to := edge[1], edge[0]
        from, to := edge[1], edge[0]
        _, to := edge[1], edge[0]
        from, to := edge[1], edge[0]
        _, to := edge[1], edge[0]
        from, to := edge[1], edge[0]
        _, to := edge[1], edge[0]
        from, to := edge[1], edge[0]
        _, to := edge[1], edge[0]
        from, to := edge[1], edge[0]
        _, to := edge[1], edge[0]
        from, to := edge[1], edge[0]
        _, to := edge[1], edge[0]
        from, to := edge[1], edge[0]
        _, to := edge[1], edge[0]
        indegree[to]++
    }

    // 根据入度初始化队列中的节点，和环检测算法相同
    q := make([]int, 0)
    for i := 0; i < numCourses; i++ {
        if indegree[i] == 0 {
            q = append(q, i)
        }
    }

    // 记录拓扑排序结果
    res := make([]int, numCourses)
    // 记录遍历节点的顺序（索引）
    count := 0
    // 开始执行 BFS 算法
    for len(q) > 0 {
        cur := q[0]
        q = q[1:]
        // 弹出节点的顺序即为拓扑排序结果
        res[count] = cur
        count++
        for _, next := range graph[cur] {
            indegree[next]--
            if indegree[next] == 0 {
                q = append(q, next)
            }
        }
    }

    if count != numCourses {
        // 存在环，拓扑排序不存在
        return []int{}
    }

    return res
}

// 建图函数
func buildGraph(numCourses int, prerequisites [][]int) []([]int) {
    // 图中共有 numCourses 个节点
    graph := make([]([]int), numCourses)
    for i := 0; i < numCourses; i++ {
        graph[i] = make([]int, 0)
    }
    for _, edge := range prerequisites {
        from, to := edge[1], edge[0]
        // 修完课程 from 才能修课程 to
        // 在图中添加一条从 from 指向 to 的有向边
        graph[from] = append(graph[from], to)
    }
    return graph
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var findOrder = function(numCourses, prerequisites) {
    // 建图，和环检测算法相同
    const graph = buildGraph(numCourses, prerequisites);
    // 计算入度，和环检测算法相同
    const indegree = new Array(numCourses).fill(0);
    for (const [from, to] of prerequisites) {
        indegree[to]++;
    }

    // 根据入度初始化队列中的节点，和环检测算法相同
    const q = [];
    for (let i = 0; i < numCourses; i++) {
        if (indegree[i] === 0) {
            q.push(i);/**<extend up -200>![](https://labuladong.github.io/pictures/拓扑排序/6.jpeg) */
        }
    }

    // 记录拓扑排序结果
    const res = new Array(numCourses);
    // 记录遍历节点的顺序（索引）
    let count = 0;
    // 开始执行 BFS 算法
    while (q.length > 0) {
        const cur = q.shift();
        // 弹出节点的顺序即为拓扑排序结果
        res[count] = cur;
        count++;
        for (const next of graph[cur]) {/**<extend up -200>![](https://labuladong.github.io/pictures/拓扑排序/7.jpeg) */
            indegree[next]--;
            if (indegree[next] === 0) {
                q.push(next);
            }
        }
    }

    if (count !== numCourses) {
        // 存在环，拓扑排序不存在
        return [];
    }

    return res;
}

// 建图函数
function buildGraph(numCourses, prerequisites) {
    // 图中共有 numCourses 个节点
    const graph = new Array(numCourses).fill().map(() => []);
    for (const [from, to] of prerequisites) {
        // 修完课程 from 才能修课程 to
        // 在图中添加一条从 from 指向 to 的有向边
        graph[from].push(to);
    }
    return graph;
}
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_course-schedule-ii" data="iwGAbnVsbAM="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_course-schedule-ii"></div></div>
</details><hr /><br />

**类似题目**：
  - [207. 课程表 🟠](/problems/course-schedule)
  - [剑指 Offer II 113. 课程顺序 🟠](/problems/QA2IGt)

</details>
</div>





