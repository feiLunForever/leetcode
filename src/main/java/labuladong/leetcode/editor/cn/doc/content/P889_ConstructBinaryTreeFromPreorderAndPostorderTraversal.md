<p>Given two integer arrays, <code>preorder</code> and <code>postorder</code> where <code>preorder</code> is the preorder traversal of a binary tree of <strong>distinct</strong> values and <code>postorder</code> is the postorder traversal of the same tree, reconstruct and return <em>the binary tree</em>.</p>

<p>If there exist multiple answers, you can <strong>return any</strong> of them.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/24/lc-prepost.jpg" style="width: 304px; height: 265px;" />
<pre>
<strong>Input:</strong> preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
<strong>Output:</strong> [1,2,3,4,5,6,7]
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> preorder = [1], postorder = [1]
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= preorder.length &lt;= 30</code></li>
	<li><code>1 &lt;= preorder[i] &lt;= preorder.length</code></li>
	<li>All the values of <code>preorder</code> are <strong>unique</strong>.</li>
	<li><code>postorder.length == preorder.length</code></li>
	<li><code>1 &lt;= postorder[i] &lt;= postorder.length</code></li>
	<li>All the values of <code>postorder</code> are <strong>unique</strong>.</li>
	<li>It is guaranteed that <code>preorder</code> and <code>postorder</code> are the preorder traversal and postorder traversal of the same binary tree.</li>
</ul>
<details><summary><strong>Related Topics</strong></summary>树 | 数组 | 哈希表 | 分治 | 二叉树</details><br>

<div>👍 273, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.8](https://aep.h5.xeknow.com/s/1XJHEO) 持续更新中，[第 11 期刷题打卡挑战](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 开始报名。**



<p><strong><a href="https://labuladong.github.io/article?qno=889" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

做这道题之前，建议你先看一下 [东哥手把手帮你刷通二叉树|第二期](https://labuladong.github.io/article/fname.html?fname=二叉树系列2)，做一下 [105. 从前序与中序遍历序列构造二叉树（中等）](#105) 和 [106. 从中序与后序遍历序列构造二叉树（中等）](/problems/construct-binary-tree-from-inorder-and-postorder-traversal) 这两道题。

这道题让用后序遍历和前序遍历结果还原二叉树，和前两道题有一个本质的区别：

**通过前序中序，或者后序中序遍历结果可以确定一棵原始二叉树，但是通过前序后序遍历结果无法确定原始二叉树**。题目也说了，如果有多种结果，你可以返回任意一种。

为什么呢？我们说过，构建二叉树的套路很简单，先找到根节点，然后找到并递归构造左右子树即可。

前两道题，可以通过前序或者后序遍历结果找到根节点，然后根据中序遍历结果确定左右子树。

这道题，你可以确定根节点，但是无法确切的知道左右子树有哪些节点。

举个例子，下面这两棵树结构不同，但是它们的前序遍历和后序遍历结果是相同的：

![](https://labuladong.github.io/algo/images/二叉树系列2/7.png)

不过话说回来，用后序遍历和前序遍历结果还原二叉树，解法逻辑上和前两道题差别不大，也是通过控制左右子树的索引来构建：

**1、首先把前序遍历结果的第一个元素或者后序遍历结果的最后一个元素确定为根节点的值**。

**2、然后把前序遍历结果的第二个元素作为左子树的根节点的值**。

**3、在后序遍历结果中寻找左子树根节点的值，从而确定了左子树的索引边界，进而确定右子树的索引边界，递归构造左右子树即可**。

![](https://labuladong.github.io/algo/images/二叉树系列2/8.jpeg)

**详细题解：[东哥带你刷二叉树（构造篇）](https://labuladong.github.io/article/fname.html?fname=二叉树系列2)**

**标签：[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)**

## 解法代码

```java
class Solution {
    // 存储 postorder 中值到索引的映射
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                    postorder, 0, postorder.length - 1);
    }

    // 定义：根据 preorder[preStart..preEnd] 和 postorder[postStart..postEnd]
    // 构建二叉树，并返回根节点。
    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // root.left 的值是前序遍历第二个元素
        // 通过前序和后序遍历构造二叉树的关键在于通过左子树的根节点
        // 确定 preorder 和 postorder 中左右子树的元素区间
        int leftRootVal = preorder[preStart + 1];
        // leftRootVal 在后序遍历数组中的索引
        int index = valToIndex.get(leftRootVal);
        // 左子树的元素个数
        int leftSize = index - postStart + 1;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);/**<extend up -200>

![](https://labuladong.github.io/algo/images/二叉树系列2/8.jpeg)
*/
        // 递归构造左右子树
        // 根据左子树的根节点索引和元素个数推导左右子树的索引边界
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                postorder, index + 1, postEnd - 1);

        return root;
    }
}
```

**类似题目**：
  - [105. 从前序与中序遍历序列构造二叉树 🟠](/problems/construct-binary-tree-from-preorder-and-inorder-traversal)
  - [106. 从中序与后序遍历序列构造二叉树 🟠](/problems/construct-binary-tree-from-inorder-and-postorder-traversal)
  - [654. 最大二叉树 🟠](/problems/maximum-binary-tree)
  - [剑指 Offer 07. 重建二叉树 🟠](/problems/zhong-jian-er-cha-shu-lcof/)

</details>
</div>



