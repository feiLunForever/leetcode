<p>You are given the <code>root</code> of a binary search tree (BST) and an integer <code>val</code>.</p>

<p>Find the node in the BST that the node&#39;s value equals <code>val</code> and return the subtree rooted with that node. If such a node does not exist, return <code>null</code>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/12/tree1.jpg" style="width: 422px; height: 302px;" />
<pre>
<strong>Input:</strong> root = [4,2,7,1,3], val = 2
<strong>Output:</strong> [2,1,3]
</pre>

<p><strong>Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/12/tree2.jpg" style="width: 422px; height: 302px;" />
<pre>
<strong>Input:</strong> root = [4,2,7,1,3], val = 5
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 5000]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>7</sup></code></li>
	<li><code>root</code> is a binary search tree.</li>
	<li><code>1 &lt;= val &lt;= 10<sup>7</sup></code></li>
</ul>
<details><summary><strong>Related Topics</strong></summary>树 | 二叉搜索树 | 二叉树</details><br>

<div>👍 319, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V1.9，[第 11 期刷题打卡挑战（9/19 开始）](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 开始报名。**



<p><strong><a href="https://labuladong.github.io/article?qno=700" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 235 页。

利用 BST 左小右大的特性，可以避免搜索整棵二叉树去寻找元素，从而提升效率。

**详细题解：[东哥带你刷二叉搜索树（基操篇）](https://labuladong.github.io/article/fname.html?fname=BST2)**

**标签：[二叉搜索树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121995456690946054)，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)**

## 解法代码

```java
class Solution {
    public TreeNode searchBST(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        // 去左子树搜索
        if (root.val > target) {
            return searchBST(root.left, target);
        }
        // 去右子树搜索
        if (root.val < target) {
            return searchBST(root.right, target);
        }
        return root;
    }
}
```

**类似题目**：
  - [270. 最接近的二叉搜索树值 🟢](/problems/closest-binary-search-tree-value)
  - [285. 二叉搜索树中的中序后继 🟠](/problems/inorder-successor-in-bst)
  - [450. 删除二叉搜索树中的节点 🟠](/problems/delete-node-in-a-bst)
  - [701. 二叉搜索树中的插入操作 🟠](/problems/insert-into-a-binary-search-tree)
  - [98. 验证二叉搜索树 🟠](/problems/validate-binary-search-tree)
  - [剑指 Offer II 053. 二叉搜索树中的中序后继 🟠](/problems/P5rCT8)

</details>
</div>



