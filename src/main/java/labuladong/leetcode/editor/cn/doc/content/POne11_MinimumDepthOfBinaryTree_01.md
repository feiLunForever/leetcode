<p>Given a binary tree, find its minimum depth.</p>

<p>The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.</p>

<p><strong>Note:</strong>&nbsp;A leaf is a node with no children.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/12/ex_depth.jpg" style="width: 432px; height: 302px;" /> 
<pre>
<strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [2,null,3,null,4,null,5,null,6]
<strong>Output:</strong> 5
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[0, 10<sup>5</sup>]</code>.</li> 
 <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 二叉树</details><br>

<div>👍 1042, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 最后一天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=minimum-depth-of-binary-tree" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[BFS 算法核心框架套路](https://www.bilibili.com/video/BV1oT411u7Vn)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 53 页。

基本的二叉树层序遍历方法，值得一提的是，BFS 算法框架就是二叉树层序遍历代码的衍生。

BFS 算法和 DFS（回溯）算法的一大区别就是，BFS 第一次搜索到的结果是最优的，这个得益于 BFS 算法的搜索逻辑，可见详细题解。

**详细题解：[BFS 算法解题套路框架](https://labuladong.github.io/article/fname.html?fname=BFS框架)**

**标签：[BFS 算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)，[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)**

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
    int minDepth(TreeNode* root) {
        if (root == NULL) return 0;
        queue<TreeNode*> q;
        q.push(root);
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.empty()) {
            /* 层数 step */
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode* cur = q.front();
                q.pop();
                /* 判断是否到达终点 */
                if (cur->left == NULL && cur->right == NULL)
                    return depth;
                /* 将 cur 的相邻节点加入队列 */
                if (cur->left != NULL)
                    q.push(cur->left);
                if (cur->right != NULL)
                    q.push(cur->right);
            }
            /* 这里增加步数 */
            depth++;
        }
        return depth;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        q = collections.deque([root])
        # root 本身就是一层，depth 初始化为 1
        depth = 1
        while q:
            # extend down -200>
            # ![](https://labuladong.github.io/pictures/dijkstra/1.jpeg)
            sz = len(q)
            ## 遍历当前层的节点
            for i in range(sz):
                cur = q.popleft()
                ## 判断是否到达叶子结点
                if not cur.left and not cur.right:
                    return depth
                ## 将下一层节点加入队列
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
            ## 这里增加步数
            depth += 1
        return depth
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()) {/**<extend down -200>![](https://labuladong.github.io/pictures/dijkstra/1.jpeg) */
            int sz = q.size();
            /* 遍历当前层的节点 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 判断是否到达叶子结点 */
                if (cur.left == null && cur.right == null)
                    return depth;
                /* 将下一层节点加入队列 */
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            /* 这里增加步数 */
            depth++;
        }
        return depth;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * Definition for TreeNode.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func minDepth(root *TreeNode) int {
    if root == nil {
        return 0
    }
    q := []*TreeNode{root}
    // root 本身就是一层，depth 初始化为 1
    depth := 1

    for len(q) != 0 {/**<extend down -200>![](https://labuladong.github.io/pictures/dijkstra/1.jpeg) */
        sz := len(q)
        /* 遍历当前层的节点 */
        for i := 0; i < sz; i++ {
            cur := q[0]
            q = q[1:]
            /* 判断是否到达叶子结点 */
            if cur.Left == nil && cur.Right == nil {
                return depth
            }
            /* 将下一层节点加入队列 */
            if cur.Left != nil {
                q = append(q, cur.Left)
            }
            if cur.Right != nil {
                q = append(q, cur.Right)
            }
        }
        /* 这里增加步数 */
        depth++
    }
    return depth
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {TreeNode} root
 * @return {number}
 */
var minDepth = function(root) {
    if (root === null) return 0;
    var q = [];
    q.push(root);
    //root本身就是一层，depth初始化为 1
    var depth = 1;

    while (q.length !== 0) {/**<extend down -200>![](https://labuladong.github.io/pictures/dijkstra/1.jpeg) */
        var sz = q.length;
        /* 遍历当前层的节点 */
        for (var i = 0; i < sz; i++) {

            var cur = q.shift();
            /* 判断是否到达叶子结点 */
            if (!cur.left && !cur.right) {
                return depth;
            }
            /* 将下一层节点加入队列 
            */
           if (cur.left !== null) {
             q.push(cur.left);
            }
            if (cur.right !== null) {
              q.push(cur.right);
             }
            
        }
        /* 这里增加步数 */
        depth++;
    }
    return depth;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_minimum-depth-of-binary-tree" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_minimum-depth-of-binary-tree"></div></div>
</details><hr /><br />

**类似题目**：
  - [542. 01 矩阵 🟠](/problems/01-matrix)
  - [752. 打开转盘锁 🟠](/problems/open-the-lock)
  - [剑指 Offer II 109. 开密码锁 🟠](/problems/zlDJc7)

</details>
</div>



