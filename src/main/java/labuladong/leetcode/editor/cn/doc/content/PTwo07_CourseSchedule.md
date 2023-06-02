<p>There are a total of <code>numCourses</code> courses you have to take, labeled from <code>0</code> to <code>numCourses - 1</code>. You are given an array <code>prerequisites</code> where <code>prerequisites[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that you <strong>must</strong> take course <code>b<sub>i</sub></code> first if you want to take course <code>a<sub>i</sub></code>.</p>

<ul> 
 <li>For example, the pair <code>[0, 1]</code>, indicates that to take course <code>0</code> you have to first take course <code>1</code>.</li> 
</ul>

<p>Return <code>true</code> if you can finish all courses. Otherwise, return <code>false</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> numCourses = 2, prerequisites = [[1,0]]
<strong>Output:</strong> true
<strong>Explanation:</strong> There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> numCourses = 2, prerequisites = [[1,0],[0,1]]
<strong>Output:</strong> false
<strong>Explanation:</strong> There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= numCourses &lt;= 2000</code></li> 
 <li><code>0 &lt;= prerequisites.length &lt;= 5000</code></li> 
 <li><code>prerequisites[i].length == 2</code></li> 
 <li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; numCourses</code></li> 
 <li>All the pairs prerequisites[i] are <strong>unique</strong>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 拓扑排序</details><br>

<div>👍 1613, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=course-schedule" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[拓扑排序详解及应用](https://www.bilibili.com/video/BV1kW4y1y7Ew)

只要会遍历图结构，就可以判断环了。

利用布尔数组 `onPath`，如果遍历过程中发现下一个即将遍历的节点已经被标记为 true，说明遇到了环（可以联想贪吃蛇咬到自己的场景）。

我给出 DFS 遍历的解法，其实本题也可以用 BFS 算法解决，稍微有些技巧，可以看详细题解。

**详细题解：[环检测及拓扑排序算法](https://labuladong.github.io/article/fname.html?fname=拓扑排序)**

**标签：[图论算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122000448684457990)，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，环检测**

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
    // 记录一次 traverse 递归经过的节点
    vector<bool> onPath;
    // 记录遍历过的节点，防止走回头路
    vector<bool> visited;
    // 记录图中是否有环
    bool hasCycle = false;

public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> graph = buildGraph(numCourses, prerequisites);

        visited.resize(numCourses, false);
        onPath.resize(numCourses, false);

        for (int i = 0; i < numCourses; i++) {
            // 遍历图中的所有节点
            traverse(graph, i);
        }
        // 只要没有循环依赖可以完成所有课程
        return !hasCycle;
    }

    void traverse(vector<vector<int>>& graph, int s) {
        if (onPath[s]) {
            // 出现环
            hasCycle = true;/**<extend up -150>![](https://labuladong.github.io/pictures/拓扑排序/4.jpeg) */
        }

        if (visited[s] || hasCycle) {
            // 如果已经找到了环，也不用再遍历了
            return;
        }
        // 前序遍历代码位置
        visited[s] = true;
        onPath[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        // 后序遍历代码位置
        onPath[s] = false;
    }

    vector<vector<int>> buildGraph(int numCourses, vector<vector<int>>& prerequisites) {
        // 图中共有 numCourses 个节点
        vector<vector<int>> graph(numCourses);
        for (auto edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            // 修完课程 from 才能修课程 to
            // 在图中添加一条从 from 指向 to 的有向边
            graph[from].push_back(to);
        }
        return graph;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # 记录一次 traverse 递归经过的节点
        onPath = [False] * numCourses
        # 记录遍历过的节点，防止走回头路
        visited = [False] * numCourses
        # 记录图中是否有环
        hasCycle = [False]

        graph = self.buildGraph(numCourses, prerequisites)

        def traverse(s):
            if onPath[s]:
                # 出现环
                hasCycle[0] = True # <extend up -150>![](https://labuladong.github.io/pictures/拓扑排序/4.jpeg) #
            if visited[s] or hasCycle[0]:
                # 如果已经找到了环，也不用再遍历了
                return
            # 前序遍历代码位置
            visited[s] = True
            onPath[s] = True
            for t in graph[s]:
                traverse(t)
            # 后序遍历代码位置
            onPath[s] = False
        
        for i in range(numCourses):
            # 遍历图中的所有节点
            traverse(i)
        
        # 只要没有循环依赖可以完成所有课程
        return not hasCycle[0]
    
    def buildGraph(self, numCourses, prerequisites):
        # 图中共有 numCourses 个节点
        graph = [[] for _ in range(numCourses)]
        for from_, to in prerequisites:
            # 修完课程 from_ 才能修课程 to
            # 在图中添加一条从 from_ 指向 to 的有向边
            graph[from_].append(to)
        return graph
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 记录一次 traverse 递归经过的节点
    boolean[] onPath;
    // 记录遍历过的节点，防止走回头路
    boolean[] visited;
    // 记录图中是否有环
    boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            // 遍历图中的所有节点
            traverse(graph, i);
        }
        // 只要没有循环依赖可以完成所有课程
        return !hasCycle;
    }

    void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            // 出现环
            hasCycle = true;/**<extend up -150>![](https://labuladong.github.io/pictures/拓扑排序/4.jpeg) */
        }

        if (visited[s] || hasCycle) {
            // 如果已经找到了环，也不用再遍历了
            return;
        }
        // 前序遍历代码位置
        visited[s] = true;
        onPath[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        // 后序遍历代码位置
        onPath[s] = false;
    }

    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        // 图中共有 numCourses 个节点
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
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
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func canFinish(numCourses int, prerequisites [][]int) bool {
    // 记录一次 traverse 递归经过的节点
    onPath := make([]bool, numCourses)
    // 记录遍历过的节点，防止走回头路
    visited := make([]bool, numCourses)
    // 记录图中是否有环
    hasCycle := false

    graph := buildGraph(numCourses, prerequisites)

    for i := 0; i < numCourses; i++ {
        // 遍历图中的所有节点
        traverse(graph, i, &hasCycle, visited, onPath)
    }
    // 只要没有循环依赖可以完成所有课程
    return !hasCycle
}

func traverse(graph []LinkedList, s int, hasCycle *bool, visited, onPath []bool) {
    if onPath[s] {
        // 出现环
        *hasCycle = true/**<extend up -150>![](https://labuladong.github.io/pictures/拓扑排序/4.jpeg) */
    }

    if visited[s] || *hasCycle {
        // 如果已经找到了环，也不用再遍历了
        return
    }
    // 前序遍历代码位置
    visited[s] = true
    onPath[s] = true
    for _, t := range graph[s].list {
        traverse(graph, t, hasCycle, visited, onPath)
    }
    // 后序遍历代码位置
    onPath[s] = false
}

type LinkedList struct {
    list []int
}

func buildGraph(numCourses int, prerequisites [][]int) []LinkedList {
    // 图中共有 numCourses 个节点
    graph := make([]LinkedList, numCourses)
    for i := 0; i < numCourses; i++ {
        graph[i] = LinkedList{list: []int{}}
    }
    for _, edge := range prerequisites {
        from := edge[1]
        to := edge[0]
        // 修完课程 from 才能修课程 to
        // 在图中添加一条从 from 指向 to 的有向边
        graph[from].list = append(graph[from].list, to)
    }
    return graph
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var canFinish = function(numCourses, prerequisites) {
    // 记录一次 traverse 递归经过的节点
    const onPath = new Array(numCourses).fill(false);
    // 记录遍历过的节点，防止走回头路
    const visited = new Array(numCourses).fill(false);
    // 记录图中是否有环
    let hasCycle = false;

    const graph = buildGraph(numCourses, prerequisites);

    for (let i = 0; i < numCourses; i++) {
        // 遍历图中的所有节点
        traverse(graph, i);
    }

    // 只要没有循环依赖可以完成所有课程
    return !hasCycle;

    function traverse(graph, s) {
        if (onPath[s]) {
            // 出现环
            hasCycle = true;/**<extend up -150>![](https://labuladong.github.io/pictures/拓扑排序/4.jpeg) */
            return;
        }

        if (visited[s] || hasCycle) {
            // 如果已经找到了环，也不用再遍历了
            return;
        }
        // 前序遍历代码位置
        visited[s] = true;
        onPath[s] = true;
        for (let t of graph[s]) {
            traverse(graph, t);
        }
        // 后序遍历代码位置
        onPath[s] = false;
    }

    function buildGraph(numCourses, prerequisites) {
        // 图中共有 numCourses 个节点
        const graph = new Array(numCourses).map(() => []);
        for (let edge of prerequisites) {
            const from = edge[1];
            const to = edge[0];
            // 修完课程 from 才能修课程 to
            // 在图中添加一条从 from 指向 to 的有向边
            graph[from].push(to);
        }
        return graph;
    }
};
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_course-schedule" data="iwGAbnVsbAM="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_course-schedule"></div></div>
</details><hr /><br />

**类似题目**：
  - [210. 课程表 II 🟠](/problems/course-schedule-ii)
  - [剑指 Offer II 113. 课程顺序 🟠](/problems/QA2IGt)

</details>
</div>



