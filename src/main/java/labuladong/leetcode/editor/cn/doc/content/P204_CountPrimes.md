<p>Given an integer <code>n</code>, return <em>the number of prime numbers that are strictly less than</em> <code>n</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 10
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 0
<strong>Output:</strong> 0
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>0 &lt;= n &lt;= 5 * 10<sup>6</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 数学 | 枚举 | 数论</details><br>

<div>👍 972, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0；[第 13 期刷题打卡](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 最后几天报名！**



<p><strong><a href="https://labuladong.github.io/article?qno=204" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 351 页。

筛数法是常见的计算素数的算法。

因为判断一个数字是否是素数的时间成本较高，所以我们不要一个个判断每个数字是否是素数，而是用排除法，把所有非素数都排除，剩下的就是素数。

**详细题解：[如何高效寻找素数](https://labuladong.github.io/article/fname.html?fname=打印素数)**

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

## 解法代码

```java
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++)
            if (isPrime[i])
                for (int j = i * i; j < n; j += i)
                    isPrime[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrime[i]) count++;

        return count;
    }
}
```

**类似题目**：
  - [264. 丑数 II 🟠](/problems/ugly-number-ii)

</details>
</div>



