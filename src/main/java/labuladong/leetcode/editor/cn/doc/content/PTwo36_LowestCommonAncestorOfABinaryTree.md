<p>Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.</p>

<p>According to the <a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor" target="_blank">definition of LCA on Wikipedia</a>: “The lowest common ancestor is defined between two nodes <code>p</code> and <code>q</code> as the lowest node in <code>T</code> that has both <code>p</code> and <code>q</code> as descendants (where we allow <b>a node to be a descendant of itself</b>).”</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" /> 
<pre>
<strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
<strong>Output:</strong> 3
<strong>Explanation:</strong> The LCA of nodes 5 and 1 is 3.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" /> 
<pre>
<strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
<strong>Output:</strong> 5
<strong>Explanation:</strong> The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [1,2], p = 1, q = 2
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[2, 10<sup>5</sup>]</code>.</li> 
 <li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li> 
 <li>All <code>Node.val</code> are <strong>unique</strong>.</li> 
 <li><code>p != q</code></li> 
 <li><code>p</code> and <code>q</code> will exist in the tree.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉树</details><br>

<div>👍 2290, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=lowest-common-ancestor-of-a-binary-tree" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

经典问题了，先给出递归函数的定义：给该函数输入三个参数 `root`，`p`，`q`，它会返回一个节点：

情况 1，如果 `p` 和 `q` 都在以 `root` 为根的树中，函数返回的即使 `p` 和 `q` 的最近公共祖先节点。

情况 2，那如果 `p` 和 `q` 都不在以 `root` 为根的树中怎么办呢？函数理所当然地返回 `null` 呗。

情况 3，那如果 `p` 和 `q` 只有一个存在于 `root` 为根的树中呢？函数就会返回那个节点。

根据这个定义，分情况讨论：

情况 1，如果 `p` 和 `q` 都在以 `root` 为根的树中，那么 `left` 和 `right` 一定分别是 `p` 和 `q`（从 base case 看出来的）。

情况 2，如果 `p` 和 `q` 都不在以 `root` 为根的树中，直接返回 `null`。

情况 3，如果 `p` 和 `q` 只有一个存在于 `root` 为根的树中，函数返回该节点。

**详细题解：[Git原理之最近公共祖先](https://labuladong.github.io/article/fname.html?fname=公共祖先)**

**标签：[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)**

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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        // base case
        if (root == nullptr) return nullptr;
        if (root == p || root == q) return root;

        TreeNode* left = lowestCommonAncestor(root->left, p, q);
        TreeNode* right = lowestCommonAncestor(root->right, p, q);
        // 情况 1
        if (left != nullptr && right != nullptr) {
            return root;
        }
        // 情况 2
        if (left == nullptr && right == nullptr) {
            return nullptr;
        }
        // 情况 3
        return left == nullptr ? right : left;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # base case
        if not root:
            return None
        if root == p or root == q:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        # 情况 1
        if left and right:
            return root
        # 情况 2
        if not left and not right:
            return None
        # 情况 3
        return right if not left else left
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 情况 1
        if (left != null && right != null) {
            return root;
        }
        // 情况 2
        if (left == null && right == null) {
            return null;
        }
        // 情况 3
        return left == null ? right : left;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
    // base case
    if root == nil {
        return nil
    }
    if root == p || root == q {
        return root
    }

    left := lowestCommonAncestor(root.Left, p, q)
    right := lowestCommonAncestor(root.Right, p, q)
    // 情况 1
    if left != nil && right != nil {
        return root
    }
    // 情况 2
    if left == nil && right == nil {
        return nil
    }
    // 情况 3
    if left == nil {
        return right
    }
    return left
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var lowestCommonAncestor = function(root, p, q) {
    // base case
    if (root === null) return null;
    if (root === p || root === q) return root;

    var left = lowestCommonAncestor(root.left, p, q);
    var right = lowestCommonAncestor(root.right, p, q);
    // 情况 1
    if (left !== null && right !== null) {
        return root;
    }
    // 情况 2
    if (left === null && right === null) {
        return null;
    }
    // 情况 3
    return left === null ? right : left;
};
```

</div></div>
</div></div>

<details open><summary><strong>👉 算法可视化 👈</strong></summary><div class="resizable aspect-ratio-container" style="height: 70vh;">
    <iframe src="https://labuladong.github.io/algo-visualize/" width="100%"
    height="100%" scrolling="auto" frameborder="0"
    style="overflow: auto;" id="iframe_lowest-common-ancestor-of-a-binary-tree"></iframe>
</div>
<div id="data_lowest-common-ancestor-of-a-binary-tree" data="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"></div></details><hr /><br />

**类似题目**：
  - [1644. 二叉树的最近公共祖先 II 🟠](/problems/lowest-common-ancestor-of-a-binary-tree-ii)
  - [1650. 二叉树的最近公共祖先 III 🟠](/problems/lowest-common-ancestor-of-a-binary-tree-iii)
  - [1676. 二叉树的最近公共祖先 IV 🟠](/problems/lowest-common-ancestor-of-a-binary-tree-iv)
  - [235. 二叉搜索树的最近公共祖先 🟠](/problems/lowest-common-ancestor-of-a-binary-search-tree)
  - [剑指 Offer 68 - I. 二叉搜索树的最近公共祖先 🟢](/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof)
  - [剑指 Offer 68 - II. 二叉树的最近公共祖先 🟢](/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof)

</details>
</div>



