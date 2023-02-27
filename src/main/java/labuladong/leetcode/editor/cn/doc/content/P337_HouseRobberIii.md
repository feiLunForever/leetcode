<p>The thief has found himself a new place for his thievery again. There is only one entrance to this area, called <code>root</code>.</p>

<p>Besides the <code>root</code>, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if <strong>two directly-linked houses were broken into on the same night</strong>.</p>

<p>Given the <code>root</code> of the binary tree, return <em>the maximum amount of money the thief can rob <strong>without alerting the police</strong></em>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/10/rob1-tree.jpg" style="width: 277px; height: 293px;" />
<pre>
<strong>Input:</strong> root = [3,2,3,null,3,null,1]
<strong>Output:</strong> 7
<strong>Explanation:</strong> Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
</pre>

<p><strong>Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/10/rob2-tree.jpg" style="width: 357px; height: 293px;" />
<pre>
<strong>Input:</strong> root = [3,4,5,1,3,null,1]
<strong>Output:</strong> 9
<strong>Explanation:</strong> Maximum amount of money the thief can rob = 4 + 5 = 9.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
</ul>
<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 动态规划 | 二叉树</details><br>

<div>👍 1400, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 17 期刷题打卡挑战](https://aep.xet.tech/s/2jPp5X) 最后一天报名！**



<p><strong><a href="https://labuladong.github.io/article?qno=337" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 201 页。

这题 [打家劫舍 I](#198) 和 [打家劫舍 II](#213) 的思路完全一样，稍微改写一下就出来了。

**详细题解：[一个方法团灭 LeetCode 打家劫舍问题](https://labuladong.github.io/article/fname.html?fname=抢房子)**

**标签：[一维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122007027366395905)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

## 解法代码

```java
class Solution {
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        // 利用备忘录消除重叠子问题
        if (memo.containsKey(root))
            return memo.get(root);
        // 抢，然后去下下家
        int do_it = root.val
                + (root.left == null ?
                0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ?
                0 : rob(root.right.left) + rob(root.right.right));
        // 不抢，然后去下家
        int not_do = rob(root.left) + rob(root.right);

        int res = Math.max(do_it, not_do);
        memo.put(root, res);
        return res;
    }
}
```

**类似题目**：
  - [198. 打家劫舍 🟠](/problems/house-robber)
  - [213. 打家劫舍 II 🟠](/problems/house-robber-ii)
  - [剑指 Offer II 089. 房屋偷盗 🟠](/problems/Gu0c2T)
  - [剑指 Offer II 090. 环形房屋偷盗 🟠](/problems/PzWKhm)

</details>
</div>





