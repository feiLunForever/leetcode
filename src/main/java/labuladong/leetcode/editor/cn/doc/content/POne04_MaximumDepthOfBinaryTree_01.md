<p>Given the <code>root</code> of a binary tree, return <em>its maximum depth</em>.</p>

<p>A binary tree's <strong>maximum depth</strong>&nbsp;is the number of nodes along the longest path from the root node down to the farthest leaf node.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/tmp-tree.jpg" style="width: 400px; height: 277px;" /> 
<pre>
<strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> 3
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [1,null,2]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 二叉树</details><br>

<div>👍 1640, 👎 0<span style='float: right;'></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 开始报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=maximum-depth-of-binary-tree" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[二叉树/递归的框架思维（纲领篇）](https://www.bilibili.com/video/BV1nG411x77H)

[我的刷题经验总结](https://labuladong.github.io/article/fname.html?fname=算法心得) 说过，二叉树问题虽然简单，但是暗含了动态规划和回溯算法等高级算法的思想。

下面提供两种思路的解法代码。

**详细题解：[东哥带你刷二叉树（纲领篇）](https://labuladong.github.io/article/fname.html?fname=二叉树总结)**

**标签：[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)，[回溯算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)**

## 解法代码

```java
/***** 解法一，回溯算法思路 *****/
class Solution {

    int depth = 0;
    int res = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    // 遍历二叉树
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序遍历位置
        depth++;
        // 遍历的过程中记录最大深度
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        depth--;
    }
}

/***** 解法二，动态规划思路 *****/
class Solution2 {
    // 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 根据左右子树的最大深度推出原二叉树的最大深度
        return 1 + Math.max(leftMax, rightMax);
    }
}
```

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_mydata-maxdepth1" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_mydata-maxdepth1"></div></div>
</details><hr /><br />

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_mydata-maxdepth2" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_mydata-maxdepth2"></div></div>
</details><hr /><br />

**类似题目**：
  - [1376. 通知所有员工所需的时间 🟠](/problems/time-needed-to-inform-all-employees)
  - [144. 二叉树的前序遍历 🟢](/problems/binary-tree-preorder-traversal)
  - [543. 二叉树的直径 🟢](/problems/diameter-of-binary-tree)
  - [559. N 叉树的最大深度 🟢](/problems/maximum-depth-of-n-ary-tree)
  - [865. 具有所有最深节点的最小子树 🟠](/problems/smallest-subtree-with-all-the-deepest-nodes)
  - [剑指 Offer 55 - I. 二叉树的深度 🟢](/problems/er-cha-shu-de-shen-du-lcof)

</details>
</div>









