<p>Implement the <code>RandomizedSet</code> class:</p>

<ul>
	<li><code>RandomizedSet()</code> Initializes the <code>RandomizedSet</code> object.</li>
	<li><code>bool insert(int val)</code> Inserts an item <code>val</code> into the set if not present. Returns <code>true</code> if the item was not present, <code>false</code> otherwise.</li>
	<li><code>bool remove(int val)</code> Removes an item <code>val</code> from the set if present. Returns <code>true</code> if the item was present, <code>false</code> otherwise.</li>
	<li><code>int getRandom()</code> Returns a random element from the current set of elements (it&#39;s guaranteed that at least one element exists when this method is called). Each element must have the <b>same probability</b> of being returned.</li>
</ul>

<p>You must implement the functions of the class such that each function works in&nbsp;<strong>average</strong>&nbsp;<code>O(1)</code>&nbsp;time complexity.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;RandomizedSet&quot;, &quot;insert&quot;, &quot;remove&quot;, &quot;insert&quot;, &quot;getRandom&quot;, &quot;remove&quot;, &quot;insert&quot;, &quot;getRandom&quot;]
[[], [1], [2], [2], [], [1], [2], []]
<strong>Output</strong>
[null, true, false, true, 2, true, false, 2]

<strong>Explanation</strong>
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= val &lt;= 2<sup>31</sup> - 1</code></li>
	<li>At most <code>2 *&nbsp;</code><code>10<sup>5</sup></code> calls will be made to <code>insert</code>, <code>remove</code>, and <code>getRandom</code>.</li>
	<li>There will be <strong>at least one</strong> element in the data structure when <code>getRandom</code> is called.</li>
</ul>
<details><summary><strong>Related Topics</strong></summary>设计 | 数组 | 哈希表 | 数学 | 随机化</details><br>

<div>👍 591, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.github.io/article?qno=380" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

对于一个标准的 `HashSet`，你能否在 `O(1)` 的时间内实现 `getRandom` 函数？

其实是不能的，因为根据刚才说到的底层实现，元素是被哈希函数「分散」到整个数组里面的，更别说还有拉链法等等解决哈希冲突的机制，基本做不到 `O(1)` 时间等概率随机获取元素。

换句话说，对于 `getRandom` 方法，如果想「等概率」且「在 `O(1)` 的时间」取出元素，一定要满足：

底层用数组实现，且数组必须是紧凑的，这样我们就可以直接生成随机数作为索引，选取随机元素。

但如果用数组存储元素的话，常规的插入，删除的时间复杂度又不可能是 `O(1)`。

然而，对数组尾部进行插入和删除操作不会涉及数据搬移，时间复杂度是 `O(1)`。

所以，如果我们想在 `O(1)` 的时间删除数组中的某一个元素 `val`，可以先把这个元素交换到数组的尾部，然后再 `pop` 掉。

**详细题解：[常数时间删除/查找数组中的任意元素](https://labuladong.github.io/article/fname.html?fname=随机集合)**

**标签：哈希表，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[设计](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121998148662362112)，[随机算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

## 解法代码

```cpp
class RandomizedSet {
    public:
    // 存储元素的值
    vector<int> nums;
    // 记录每个元素对应在 nums 中的索引
    unordered_map<int,int> valToIndex;

    bool insert(int val) {
        // 若 val 已存在，不用再插入
        if (valToIndex.count(val)) {
            return false;
        }
        // 若 val 不存在，插入到 nums 尾部，
        // 并记录 val 对应的索引值
        valToIndex[val] = nums.size();
        nums.push_back(val);
        return true;
    }

    bool remove(int val) {
        // 若 val 不存在，不用再删除
        if (!valToIndex.count(val)) {
            return false;
        }
        // 先拿到 val 的索引
        int index = valToIndex[val];
        // 将最后一个元素对应的索引修改为 index
        valToIndex[nums.back()] = index;
        // 交换 val 和最后一个元素
        swap(nums[index], nums.back());
        // 在数组中删除元素 val
        nums.pop_back();
        // 删除元素 val 对应的索引
        valToIndex.erase(val);
        return true;
    }

    int getRandom() {
        // 随机获取 nums 中的一个元素
        return nums[rand() % nums.size()];
    }
};
```

**类似题目**：
  - [519. 随机翻转矩阵 🟠](/problems/random-flip-matrix)
  - [710. 黑名单中的随机数 🔴](/problems/random-pick-with-blacklist)
  - [剑指 Offer II 030. 插入、删除和随机访问都是 O(1) 的容器 🟠](/problems/FortPu)

</details>
</div>





