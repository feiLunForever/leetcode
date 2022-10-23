<p>Given a <code>m x n</code> <code>grid</code> filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.</p>

<p><strong>Note:</strong> You can only move either down or right at any point in time.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/05/minpath.jpg" style="width: 242px; height: 242px;" /> 
<pre>
<strong>Input:</strong> grid = [[1,3,1],[1,5,1],[4,2,1]]
<strong>Output:</strong> 7
<strong>Explanation:</strong> Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> grid = [[1,2,3],[4,5,6]]
<strong>Output:</strong> 12
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>m == grid.length</code></li> 
 <li><code>n == grid[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 200</code></li> 
 <li><code>0 &lt;= grid[i][j] &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划 | 矩阵</details><br>

<div>👍 1377, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0；[第 12 期刷题打卡](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 最后一天报名；点击这里体验 [刷题全家桶](https://labuladong.gitee.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg)。**



<p><strong><a href="https://labuladong.github.io/article?qno=64" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

一般来说，让你在二维矩阵中求最优化问题（最大值或者最小值），肯定需要递归 + 备忘录，也就是动态规划技巧。

`dp` 函数的定义：**从左上角位置 `(0, 0)` 走到位置 `(i, j)` 的最小路径和为 `dp(grid, i, j)`**。

这样，`dp(grid, i, j)` 的值由 `dp(grid, i - 1, j)` 和 `dp(grid, i, j - 1)` 的值转移而来：

```java
dp(grid, i, j) = Math.min(
    dp(grid, i - 1, j),
    dp(grid, i, j - 1)
) + grid[i][j];
```

**详细题解：[动态规划之最小路径和](https://labuladong.github.io/article/fname.html?fname=最小路径和)**

**标签：[二维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，二维矩阵，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

## 解法代码

```java
class Solution {
    int[][] memo;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 构造备忘录，初始值全部设为 -1
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        return dp(grid, m - 1, n - 1);
    }

    int dp(int[][] grid, int i, int j) {
        // base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        // 避免重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 将计算结果记入备忘录
        memo[i][j] = Math.min(
                dp(grid, i - 1, j),
                dp(grid, i, j - 1)
        ) + grid[i][j];

        return memo[i][j];
    }
}
```

**类似题目**：
  - [剑指 Offer 47. 礼物的最大价值 🟠](/problems/li-wu-de-zui-da-jie-zhi-lcof)
  - [剑指 Offer II 099. 最小路径之和 🟠](/problems/0i0mDW)

</details>
</div>



