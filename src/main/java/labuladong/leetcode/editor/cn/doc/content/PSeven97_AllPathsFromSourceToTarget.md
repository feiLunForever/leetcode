<p>Given a directed acyclic graph (<strong>DAG</strong>) of <code>n</code> nodes labeled from <code>0</code> to <code>n - 1</code>, find all possible paths from node <code>0</code> to node <code>n - 1</code> and return them in <strong>any order</strong>.</p>

<p>The graph is given as follows: <code>graph[i]</code> is a list of all nodes you can visit from node <code>i</code> (i.e., there is a directed edge from node <code>i</code> to node <code>graph[i][j]</code>).</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/28/all_1.jpg" style="width: 242px; height: 242px;" /> 
<pre>
<strong>Input:</strong> graph = [[1,2],[3],[3],[]]
<strong>Output:</strong> [[0,1,3],[0,2,3]]
<strong>Explanation:</strong> There are two paths: 0 -&gt; 1 -&gt; 3 and 0 -&gt; 2 -&gt; 3.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/28/all_2.jpg" style="width: 423px; height: 301px;" /> 
<pre>
<strong>Input:</strong> graph = [[4,3,1],[3,2,4],[3],[4],[]]
<strong>Output:</strong> [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>n == graph.length</code></li> 
 <li><code>2 &lt;= n &lt;= 15</code></li> 
 <li><code>0 &lt;= graph[i][j] &lt; n</code></li> 
 <li><code>graph[i][j] != i</code> (i.e., there will be no self-loops).</li> 
 <li>All the elements of <code>graph[i]</code> are <strong>unique</strong>.</li> 
 <li>The input graph is <strong>guaranteed</strong> to be a <strong>DAG</strong>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 回溯</details><br>

<div>👍 405, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=all-paths-from-source-to-target" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[图论基础及遍历算法](https://www.bilibili.com/video/BV19G41187cL)

解法很简单，以 `0` 为起点遍历图，同时记录遍历过的路径，当遍历到终点时将路径记录下来即可。

既然输入的图是无环的，我们就不需要 `visited` 数组辅助了，可以直接套用 [图的遍历框架](https://labuladong.github.io/article/fname.html?fname=图)。

**详细题解：[图论基础及遍历算法](https://labuladong.github.io/article/fname.html?fname=图)**

**标签：[图论算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122000448684457990)，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)**

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
    // 记录所有路径
    vector<vector<int>> res;

public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        deque<int> path;
        traverse(graph, 0, path);
        return res;
    }

    /* 图的遍历框架 */
    void traverse(vector<vector<int>>& graph, int s, deque<int>& path) {

        // 添加节点 s 到路径
        path.push_back(s);

        int n = graph.size();
        if (s == n - 1) {
            // 到达终点
            res.push_back(vector<int>(path.begin(), path.end()));
            path.pop_back();
            return;
        }

        // 递归每个相邻节点
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }

        // 从路径移出节点 s
        path.pop_back();
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

from typing import List

class Solution:
    def __init__(self):
        # 记录所有路径
        self.res = []

    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        path = []
        self.traverse(graph, 0, path)
        return self.res

    """ 图的遍历框架 """
    def traverse(self, graph: List[List[int]], s: int, path: List[int]) -> None:
        # 添加节点 s 到路径
        path.append(s)

        n = len(graph)
        if s == n - 1:
            # 到达终点
            self.res.append(path[:])
            path.pop()
            return

        # 递归每个相邻节点
        for v in graph[s]:
            self.traverse(graph, v, path)

        # 从路径移出节点 s
        path.pop()
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 记录所有路径
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    /* 图的遍历框架 */
    void traverse(int[][] graph, int s, LinkedList<Integer> path) {

        // 添加节点 s 到路径
        path.addLast(s);

        int n = graph.length;
        if (s == n - 1) {
            // 到达终点
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }

        // 递归每个相邻节点
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }

        // 从路径移出节点 s
        path.removeLast();
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func allPathsSourceTarget(graph [][]int) [][]int {
    res := [][]int{}
    path := []int{}
    
    var traverse func(graph [][]int, s int, path []int)
    traverse = func(graph [][]int, s int, path []int) {
        // 添加节点 s 到路径
        path = append(path, s)

        n := len(graph)
        if s == n - 1 {
            // 到达终点
            tmp := make([]int, len(path))
            copy(tmp, path)
            res = append(res, tmp)
            path = path[:len(path) - 1]
            return
        }

        // 递归每个相邻节点
        for _, v := range graph[s] {
            traverse(graph, v, path)
        }

        // 从路径移出节点 s
        path = path[:len(path) - 1]
    }
    
    traverse(graph, 0, path)
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var allPathsSourceTarget = function(graph) {
    // 记录所有路径
    var res = [];

    var traverse = function(graph, s, path) {
        // 添加节点 s 到路径
        path.push(s);

        var n = graph.length;
        if (s === n - 1) {
            // 到达终点
            res.push(path.slice());
            path.pop();
            return;
        }

        // 递归每个相邻节点
        for (var i = 0; i < graph[s].length; i++) {
            traverse(graph, graph[s][i], path);
        }

        // 从路径移出节点 s
        path.pop();
    };

    var path = [];
    traverse(graph, 0, path);

    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_all-paths-from-source-to-target" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_all-paths-from-source-to-target"></div></div>
</details><hr /><br />

**类似题目**：
  - [剑指 Offer II 110. 所有路径 🟠](/problems/bP4bmD)

</details>
</div>



