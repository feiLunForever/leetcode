<p>Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.</p>

<p>According to the <a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor" target="_blank">definition of LCA on Wikipedia</a>: &ldquo;The lowest common ancestor is defined between two nodes <code>p</code> and <code>q</code> as the lowest node in <code>T</code> that has both <code>p</code> and <code>q</code> as descendants (where we allow <b>a node to be a descendant of itself</b>).&rdquo;</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" />
<pre>
<strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
<strong>Output:</strong> 3
<strong>Explanation:</strong> The LCA of nodes 5 and 1 is 3.
</pre>

<p><strong>Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" />
<pre>
<strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
<strong>Output:</strong> 5
<strong>Explanation:</strong> The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
</pre>

<p><strong>Example 3:</strong></p>

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

<div>👍 1955, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V1.9，[第 11 期刷题打卡挑战（9/19 开始）](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 开始报名。**



<p><strong><a href="https://labuladong.github.io/article?qno=236" target="_blank">⭐️labuladong 题解</a></strong></p>
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

**类似题目**：
  - [1644. 二叉树的最近公共祖先 II 🟠](/problems/lowest-common-ancestor-of-a-binary-tree-ii)
  - [1650. 二叉树的最近公共祖先 III 🟠](/problems/lowest-common-ancestor-of-a-binary-tree-iii)
  - [1676. 二叉树的最近公共祖先 IV 🟠](/problems/lowest-common-ancestor-of-a-binary-tree-iv)
  - [235. 二叉搜索树的最近公共祖先 🟢](/problems/lowest-common-ancestor-of-a-binary-search-tree)
  - [剑指 Offer 68 - I. 二叉搜索树的最近公共祖先 🟢](/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof)
  - [剑指 Offer 68 - II. 二叉树的最近公共祖先 🟢](/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof)

</details>
</div>



