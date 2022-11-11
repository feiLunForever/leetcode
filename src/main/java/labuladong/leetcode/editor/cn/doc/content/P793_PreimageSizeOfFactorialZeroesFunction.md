<p>Let <code>f(x)</code> be the number of zeroes at the end of <code>x!</code>. Recall that <code>x! = 1 * 2 * 3 * ... * x</code> and by convention, <code>0! = 1</code>.</p>

<ul> 
 <li>For example, <code>f(3) = 0</code> because <code>3! = 6</code> has no zeroes at the end, while <code>f(11) = 2</code> because <code>11! = 39916800</code> has two zeroes at the end.</li> 
</ul>

<p>Given an integer <code>k</code>, return the number of non-negative integers <code>x</code> have the property that <code>f(x) = k</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> k = 0
<strong>Output:</strong> 5
<strong>Explanation:</strong> 0!, 1!, 2!, 3!, and 4! end with k = 0 zeroes.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> k = 5
<strong>Output:</strong> 0
<strong>Explanation:</strong> There is no x such that x! ends in k = 5 zeroes.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> k = 3
<strong>Output:</strong> 5
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>0 &lt;= k &lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数学 | 二分查找</details><br>

<div>👍 191, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0；[第 13 期刷题打卡](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 最后几天报名！**



<p><strong><a href="https://labuladong.github.io/article?qno=793" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题需要复用 [阶乘后的零](#172) 这道题的解法函数 `trailingZeroes`。

搜索有多少个 `n` 满足 `trailingZeroes(https://labuladong.github.io/article/fname.html?fname=二分查找详解) 中「搜索左侧边界」和「搜索右侧边界」这两个事儿嘛？

观察题目给出的数据取值范围，`n` 可以在区间 `[0, LONG_MAX]` 中取值，寻找满足 `trailingZeroes(n) == K` 的左侧边界和右侧边界，相减即是答案。

**详细题解：[讲两道常考的阶乘算法题](https://labuladong.github.io/article/fname.html?fname=阶乘题目)**

**标签：[二分搜索](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

## 解法代码

```java
class Solution {
    public int preimageSizeFZF(int K) {
        // 左边界和右边界之差 + 1 就是答案
        return (int)(right_bound(K) - left_bound(K) + 1);
    }

    // 逻辑不变，数据类型全部改成 long
    long trailingZeroes(long n) {
        long res = 0;
        for (long d = n; d / 5 > 0; d = d / 5) {
            res += d / 5;
        }
        return res;
    }

    /* 搜索 trailingZeroes(n) == K 的左侧边界 */
    long left_bound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /* 搜索 trailingZeroes(n) == K 的右侧边界 */
    long right_bound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo - 1;
    }
}
```

**类似题目**：
  - [172. 阶乘后的零 🟠](/problems/factorial-trailing-zeroes)

</details>
</div>



