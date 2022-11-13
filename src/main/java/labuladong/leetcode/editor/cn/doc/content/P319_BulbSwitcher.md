<p>There are <code>n</code> bulbs that are initially off. You first turn on all the bulbs, then&nbsp;you turn off every second bulb.</p>

<p>On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the <code>i<sup>th</sup></code> round, you toggle every <code>i</code> bulb. For the <code>n<sup>th</sup></code> round, you only toggle the last bulb.</p>

<p>Return <em>the number of bulbs that are on after <code>n</code> rounds</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/05/bulb.jpg" style="width: 421px; height: 321px;" /> 
<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> 1
<strong>Explanation:</strong> At first, the three bulbs are [off, off, off].
After the first round, the three bulbs are [on, on, on].
After the second round, the three bulbs are [on, off, on].
After the third round, the three bulbs are [on, off, off]. 
So you should return 1 because there is only one bulb is on.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 0
<strong>Output:</strong> 0
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>0 &lt;= n &lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>脑筋急转弯 | 数学</details><br>

<div>👍 338, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0；[第 13 期刷题打卡](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 最后几天报名！**



<p><strong><a href="https://labuladong.github.io/article?qno=319" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 414 页。

因为电灯一开始都是关闭的，所以某一盏灯最后如果是点亮的，必然要被按奇数次开关。

我们假设只有 16 盏灯，对于第十六盏灯会被按几次？

被按的次数就是 16 不同因子的个数，因为 `16 = 1*16 = 2*8 = 4*4`，其中因子 4 重复出现，所以第 16 盏灯会被按 5 次，奇数次。

一个正整数 `n` 的不同因子有几个？就是 `n` 的平方根向下取整，也就是这个问题的答案。

**详细题解：[一行代码就能解决的算法题](https://labuladong.github.io/article/fname.html?fname=一行代码解决的智力题)**

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

## 解法代码

```java
class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
```

**类似题目**：
  - [292. Nim 游戏 🟢](/problems/nim-game)
  - [877. 石子游戏 🟠](/problems/stone-game)

</details>
</div>



