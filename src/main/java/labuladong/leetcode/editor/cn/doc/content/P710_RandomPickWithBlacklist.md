<p>You are given an integer <code>n</code> and an array of <strong>unique</strong> integers <code>blacklist</code>. Design an algorithm to pick a random integer in the range <code>[0, n - 1]</code> that is <strong>not</strong> in <code>blacklist</code>. Any integer that is in the mentioned range and not in <code>blacklist</code> should be <strong>equally likely</strong> to be returned.</p>

<p>Optimize your algorithm such that it minimizes the number of calls to the <strong>built-in</strong> random function of your language.</p>

<p>Implement the <code>Solution</code> class:</p>

<ul>
	<li><code>Solution(int n, int[] blacklist)</code> Initializes the object with the integer <code>n</code> and the blacklisted integers <code>blacklist</code>.</li>
	<li><code>int pick()</code> Returns a random integer in the range <code>[0, n - 1]</code> and not in <code>blacklist</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;Solution&quot;, &quot;pick&quot;, &quot;pick&quot;, &quot;pick&quot;, &quot;pick&quot;, &quot;pick&quot;, &quot;pick&quot;, &quot;pick&quot;]
[[7, [2, 3, 5]], [], [], [], [], [], [], []]
<strong>Output</strong>
[null, 0, 4, 1, 6, 1, 0, 4]

<strong>Explanation</strong>
Solution solution = new Solution(7, [2, 3, 5]);
solution.pick(); // return 0, any integer from [0,1,4,6] should be ok. Note that for every call of pick,
                 // 0, 1, 4, and 6 must be equally likely to be returned (i.e., with probability 1/4).
solution.pick(); // return 4
solution.pick(); // return 1
solution.pick(); // return 6
solution.pick(); // return 1
solution.pick(); // return 0
solution.pick(); // return 4
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>9</sup></code></li>
	<li><code>0 &lt;= blacklist.length &lt;= min(10<sup>5</sup>, n - 1)</code></li>
	<li><code>0 &lt;= blacklist[i] &lt; n</code></li>
	<li>All the values of <code>blacklist</code> are <strong>unique</strong>.</li>
	<li>At most <code>2 * 10<sup>4</sup></code> calls will be made to <code>pick</code>.</li>
</ul>
<details><summary><strong>Related Topics</strong></summary>哈希表 | 数学 | 二分查找 | 排序 | 随机化</details><br>

<div>👍 210, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.8](https://aep.h5.xeknow.com/s/1XJHEO) 持续更新中。**



<p><strong><a href="https://labuladong.github.io/article?qno=710" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

本题考察如下两点：

1、如果想高效地，等概率地随机获取元素，就要使用数组作为底层容器。

2、如果既要保持数组元素的紧凑性，又想从数组中间删除元素，那么可以把待删除元素换到最后，然后 `pop` 掉末尾的元素，这样时间复杂度就是 O(1) 了。当然，这样做的代价是我们需要额外的哈希表记录值到索引的映射。

**详细题解：[常数时间删除/查找数组中的任意元素](https://labuladong.github.io/article/fname.html?fname=随机集合)**

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[随机算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

## 解法代码

```cpp
class Solution {
public:
    int sz;
    unordered_map<int, int> mapping;

    Solution(int N, vector<int>& blacklist) {
        sz = N - blacklist.size();
        for (int b : blacklist) {
            mapping[b] = 666;
        }

        int last = N - 1;
        for (int b : blacklist) {
            // 如果 b 已经在区间 [sz, N)
            // 可以直接忽略
            if (b >= sz) {
                continue;
            }
            while (mapping.count(last)) {
                last--;
            }
            mapping[b] = last;
            last--;
        }
    }

    int pick() {
        // 随机选取一个索引
        int index = rand() % sz;
        // 这个索引命中了黑名单，
        // 需要被映射到其他位置
        if (mapping.count(index)) {
            return mapping[index];
        }
        // 若没命中黑名单，则直接返回
        return index;
    }
};
```

**类似题目**：
  - [380. O(1) 时间插入、删除和获取随机元素 🟠](/problems/insert-delete-getrandom-o1)
  - [剑指 Offer II 030. 插入、删除和随机访问都是 O(1) 的容器 🟠](/problems/FortPu)

</details>
</div>



