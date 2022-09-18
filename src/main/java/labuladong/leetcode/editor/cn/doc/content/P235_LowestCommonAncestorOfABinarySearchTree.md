<p>Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.</p>

<p>According to the <a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor" target="_blank">definition of LCA on Wikipedia</a>: &ldquo;The lowest common ancestor is defined between two nodes <code>p</code> and <code>q</code> as the lowest node in <code>T</code> that has both <code>p</code> and <code>q</code> as descendants (where we allow <strong>a node to be a descendant of itself</strong>).&rdquo;</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarysearchtree_improved.png" style="width: 200px; height: 190px;" />
<pre>
<strong>Input:</strong> root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
<strong>Output:</strong> 6
<strong>Explanation:</strong> The LCA of nodes 2 and 8 is 6.
</pre>

<p><strong>Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarysearchtree_improved.png" style="width: 200px; height: 190px;" />
<pre>
<strong>Input:</strong> root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
<strong>Output:</strong> 2
<strong>Explanation:</strong> The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
</pre>

<p><strong>Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [2,1], p = 2, q = 1
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[2, 10<sup>5</sup>]</code>.</li>
	<li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li>
	<li>All <code>Node.val</code> are <strong>unique</strong>.</li>
	<li><code>p != q</code></li>
	<li><code>p</code> and <code>q</code> will exist in the BST.</li>
</ul>
<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉搜索树 | 二叉树</details><br>

<div>👍 931, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V1.9，第 11 期刷题打卡挑战即将开始，[点这里报名](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q)。**



<p><strong><a href="https://labuladong.github.io/article?qno=235" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

比较经典的是 [236. 二叉树的最近公共祖先](https://appktavsiei5995.pc.xiaoe-tech.com/detail/i_62987959e4b01a4852072fa5/1) 讲了那道题的解法。

如果在 BST 中寻找最近公共祖先，反而容易很多，主要利用 BST 左小右大（左子树所有节点都比当前节点小，右子树所有节点都比当前节点大）的特点即可。

1、如果 `p` 和 `q` 都比当前节点小，那么显然 `p` 和 `q` 都在左子树，那么 LCA 在左子树。

2、如果 `p` 和 `q` 都比当前节点大，那么显然 `p` 和 `q` 都在右子树，那么 LCA 在右子树。

3、一旦发现 `p` 和 `q` 在当前节点的两侧，说明当前节点就是 LCA。

**详细题解：[Git原理之最近公共祖先](https://appktavsiei5995.pc.xiaoe-tech.com/detail/i_62987959e4b01a4852072fa5/1)**

**标签：[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)**

## 解法代码

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val > q.val) {
            // 保证 p.val <= q.val，便于后续情况讨论
            return lowestCommonAncestor(root, q, p);
        }
        if (root.val >= p.val && root.val <= q.val) {
            // p <= root <= q
            // 即 p 和 q 分别在 root 的左右子树，那么 root 就是 LCA
            return root;
        }
        if (root.val > q.val) {
            // p 和 q 都在 root 的左子树，那么 LCA 在左子树
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // p 和 q 都在 root 的右子树，那么 LCA 在右子树
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
```

**类似题目**：
  - [1644. 二叉树的最近公共祖先 II 🟠](/problems/lowest-common-ancestor-of-a-binary-tree-ii)
  - [1650. 二叉树的最近公共祖先 III 🟠](/problems/lowest-common-ancestor-of-a-binary-tree-iii)
  - [1676. 二叉树的最近公共祖先 IV 🟠](/problems/lowest-common-ancestor-of-a-binary-tree-iv)
  - [236. 二叉树的最近公共祖先 🟠](/problems/lowest-common-ancestor-of-a-binary-tree)
  - [剑指 Offer 68 - I. 二叉搜索树的最近公共祖先 🟢](/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof)
  - [剑指 Offer 68 - II. 二叉树的最近公共祖先 🟢](/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof)

</details>
</div>



