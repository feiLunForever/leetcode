<p>Design a data structure that follows the constraints of a <strong><a href="https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU" target="_blank">Least Recently Used (LRU) cache</a></strong>.</p>

<p>Implement the <code>LRUCache</code> class:</p>

<ul> 
 <li><code>LRUCache(int capacity)</code> Initialize the LRU cache with <strong>positive</strong> size <code>capacity</code>.</li> 
 <li><code>int get(int key)</code> Return the value of the <code>key</code> if the key exists, otherwise return <code>-1</code>.</li> 
 <li><code>void put(int key, int value)</code> Update the value of the <code>key</code> if the <code>key</code> exists. Otherwise, add the <code>key-value</code> pair to the cache. If the number of keys exceeds the <code>capacity</code> from this operation, <strong>evict</strong> the least recently used key.</li> 
</ul>

<p>The functions <code>get</code> and <code>put</code> must each run in <code>O(1)</code> average time complexity.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
<strong>Output</strong>
[null, null, null, 1, null, -1, null, -1, 3, 4]

<strong>Explanation</strong>
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= capacity &lt;= 3000</code></li> 
 <li><code>0 &lt;= key &lt;= 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= value &lt;= 10<sup>5</sup></code></li> 
 <li>At most <code>2 * 10<sup>5</sup></code> calls will be made to <code>get</code> and <code>put</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>设计 | 哈希表 | 链表 | 双向链表</details><br>

<div>👍 2717, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=lru-cache" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 216 页。

要让 `put` 和 `get` 方法的时间复杂度为 `O(1)`，我们可以总结出 `cache` 这个数据结构必要的条件：

1、显然 `cache` 中的元素必须有时序，以区分最近使用的和久未使用的数据，当容量满了之后要删除最久未使用的那个元素腾位置。

2、我们要在 `cache` 中快速找某个 `key` 是否已存在并得到对应的 `val`；

3、每次访问 `cache` 中的某个 `key`，需要将这个元素变为最近使用的，也就是说 `cache` 要支持在任意位置快速插入和删除元素。

哈希表查找快，但是数据无固定顺序；链表有顺序之分，插入删除快，但是查找慢，所以结合二者的长处，可以形成一种新的数据结构：哈希链表 `LinkedHashMap`：

![](https://labuladong.github.io/pictures/LRU算法/4.jpg)

至于 `put` 和 `get` 的具体逻辑，可以画出这样一个流程图：

![](https://labuladong.github.io/pictures/LRU算法/put.jpg)

根据上述逻辑写代码即可。

**详细题解：[算法就像搭乐高：带你手撸 LRU 算法](https://labuladong.github.io/article/fname.html?fname=LRU算法)**

**标签：[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[设计](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121998148662362112)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class LRUCache {
private:
    int cap;
    unordered_map<int, int> cache;

public:
    LRUCache(int capacity) {
        this->cap = capacity;
    }

    int get(int key) {
        if (cache.find(key) == cache.end()) {
            return -1;
        }
        // 将 key 变为最近使用
        makeRecently(key);
        return cache[key];
    }

    void put(int key, int val) {
        if (cache.find(key) != cache.end()) {
            // 修改 key 的值
            cache[key] = val;
            // 将 key 变为最近使用
            makeRecently(key);
            return;
        }

        if (cache.size() >= this->cap) {
            // 链表头部就是最久未使用的 key
            int oldestKey = cache.begin()->first;
            cache.erase(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache[key] = val;
    }

private:
    void makeRecently(int key) {
        int val = cache[key];
        // 删除 key，重新插入到队尾
        cache.erase(key);
        cache[key] = val;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class LRUCache:
    def __init__(self, capacity: int):
        self.cap = capacity
        self.cache = collections.OrderedDict()

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        # 将 key 变为最近使用
        self.cache.move_to_end(key)
        return self.cache[key]

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            # 修改 key 的值
            self.cache[key] = value
            # 将 key 变为最近使用
            self.cache.move_to_end(key)
            return

        if len(self.cache) >= self.cap:
            # 链表头部就是最久未使用的 key
            self.cache.popitem(last=False)
        # 将新的 key 添加链表尾部
        self.cache[key] = value
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class LRUCache {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 将 key 变为最近使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            // 修改 key 的值
            cache.put(key, val);
            // 将 key 变为最近使用
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.cap) {
            // 链表头部就是最久未使用的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache.put(key, val);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        // 删除 key，重新插入到队尾
        cache.remove(key);
        cache.put(key, val);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

type LRUCache struct {
    cap  int
    cache map[int]int
    list  *list.List
}

func Constructor(capacity int) LRUCache {
    return LRUCache{
        cap:   capacity,
        cache: make(map[int]int),
        list:  list.New(),
    }
}

func (this *LRUCache) Get(key int) int {
    if val, ok := this.cache[key]; ok {
        // 将 key 移动到链表尾部表示最近访问
        this.makeRecently(key)
        return val
    }
    return -1
}

func (this *LRUCache) Put(key int, value int) {
    if _, ok := this.cache[key]; ok {
        // 修改 key 的值，将 key 移动到链表尾部表示最近访问
        this.cache[key] = value
        this.makeRecently(key)
        return
    }

    if len(this.cache) >= this.cap {
        // 链表头部就是最久未使用的 key
        this.removeOldest()
    }
    // 将新的 key-value 添加链表尾部
    this.cache[key] = value
    this.list.PushBack(key)
}

func (this *LRUCache) makeRecently(key int) {
    // 将 key 移动到链表尾部表示最近访问
    for e := this.list.Front(); e != nil; e = e.Next() {
        if e.Value.(int) == key {
            this.list.MoveToBack(e)
            break
        }
    }
}

func (this *LRUCache) removeOldest() {
    // 删除链表头部表示最久未使用的 key
    e := this.list.Front()
    delete(this.cache, e.Value.(int))
    this.list.Remove(e)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
    this.cap = capacity;
    this.cache = new Map();
};

/**
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
    if (!this.cache.has(key)) {
        return -1;
    }
    // 将 key 变为最近使用
    this.makeRecently(key);
    return this.cache.get(key);
};

/**
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
    if (this.cache.has(key)) {
        // 修改 key 的值
        this.cache.set(key, value);
        // 将 key 变为最近使用
        this.makeRecently(key);
        return;
    }

    if (this.cache.size >= this.cap) {
        // 链表头部就是最久未使用的 key
        const oldestKey = this.cache.keys().next().value;
        this.cache.delete(oldestKey);
    }
    // 将新的 key 添加链表尾部
    this.cache.set(key, value);
};

/**
 * @param {number} key
 * @return {void}
 */
LRUCache.prototype.makeRecently = function(key) {
    const val = this.cache.get(key);
    // 删除 key，重新插入到队尾
    this.cache.delete(key);
    this.cache.set(key, val);
};
```

</div></div>
</div></div>

**类似题目**：
  - [剑指 Offer II 031. 最近最少使用缓存 🟠](/problems/OrIXps)

</details>
</div>



