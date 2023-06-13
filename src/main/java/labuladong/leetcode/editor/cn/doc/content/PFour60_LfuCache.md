<p>Design and implement a data structure for a <a href="https://en.wikipedia.org/wiki/Least_frequently_used" target="_blank">Least Frequently Used (LFU)</a> cache.</p>

<p>Implement the <code>LFUCache</code> class:</p>

<ul> 
 <li><code>LFUCache(int capacity)</code> Initializes the object with the <code>capacity</code> of the data structure.</li> 
 <li><code>int get(int key)</code> Gets the value of the <code>key</code> if the <code>key</code> exists in the cache. Otherwise, returns <code>-1</code>.</li> 
 <li><code>void put(int key, int value)</code> Update the value of the <code>key</code> if present, or inserts the <code>key</code> if not already present. When the cache reaches its <code>capacity</code>, it should invalidate and remove the <strong>least frequently used</strong> key before inserting a new item. For this problem, when there is a <strong>tie</strong> (i.e., two or more keys with the same frequency), the <strong>least recently used</strong> <code>key</code> would be invalidated.</li> 
</ul>

<p>To determine the least frequently used key, a <strong>use counter</strong> is maintained for each key in the cache. The key with the smallest <strong>use counter</strong> is the least frequently used key.</p>

<p>When a key is first inserted into the cache, its <strong>use counter</strong> is set to <code>1</code> (due to the <code>put</code> operation). The <strong>use counter</strong> for a key in the cache is incremented either a <code>get</code> or <code>put</code> operation is called on it.</p>

<p>The functions&nbsp;<code data-stringify-type="code">get</code>&nbsp;and&nbsp;<code data-stringify-type="code">put</code>&nbsp;must each run in <code>O(1)</code> average time complexity.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
<strong>Output</strong>
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

<strong>Explanation</strong>
// cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
LFUCache lfu = new LFUCache(2);
lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lfu.get(1);      // return 1
                 // cache=[1,2], cnt(2)=1, cnt(1)=2
lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
&nbsp;                // cache=[3,1], cnt(3)=1, cnt(1)=2
lfu.get(2);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
lfu.get(1);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,4], cnt(4)=1, cnt(3)=3
lfu.get(4);      // return 4
                 // cache=[4,3], cnt(4)=2, cnt(3)=3
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= capacity&nbsp;&lt;= 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= key &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;= value &lt;= 10<sup>9</sup></code></li> 
 <li>At most <code>2 * 10<sup>5</sup></code>&nbsp;calls will be made to <code>get</code> and <code>put</code>.</li> 
</ul>

<p>&nbsp;</p> 
<span style="display: none;">&nbsp;</span>

<details><summary><strong>Related Topics</strong></summary>设计 | 哈希表 | 链表 | 双向链表</details><br>

<div>👍 658, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=lfu-cache" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 227 页。

总结下题目的要求：

1、调用 `get(key)` 方法时，要返回该 `key` 对应的 `val`。

2、只要用 `get` 或者 `put` 方法访问一次某个 `key`，该 `key` 的 `freq` 就要加一。

3、如果在容量满了的时候进行插入，则需要将 `freq` 最小的 `key` 删除，如果最小的 `freq` 对应多个 `key`，则删除其中最旧的那一个。

具体思路略微复杂，请查看详细题解。

**详细题解：[算法就像搭乐高：带你手撸 LFU 算法](https://labuladong.github.io/article/fname.html?fname=LFU)**

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

class LFUCache {
    // key 到 val 的映射，我们后文称为 KV 表
    unordered_map<int, int> keyToVal;
    // key 到 freq 的映射，我们后文称为 KF 表
    unordered_map<int, int> keyToFreq;
    // freq 到 key 列表的映射，我们后文称为 FK 表
    unordered_map<int, unordered_set<int>> freqToKeys;
    // 记录最小的频次
    int minFreq;
    // 记录 LFU 缓存的最大容量
    int cap;
public:
    LFUCache(int capacity) {
        keyToVal.clear();
        keyToFreq.clear();
        freqToKeys.clear();
        this->cap = capacity;
        this->minFreq = 0;
    }

    int get(int key) {
        if (!keyToVal.count(key)) {
            return -1;
        }
        // 增加 key 对应的 freq
        increaseFreq(key);
        return keyToVal[key];
    }

    void put(int key, int val) {
        if (this->cap <= 0) return;

        /* 若 key 已存在，修改对应的 val 即可 */
        if (keyToVal.count(key)) {
            keyToVal[key] = val;
            // key 对应的 freq 加一
            increaseFreq(key);
            return;
        }

        /* key 不存在，需要插入 */
        /* 容量已满的话需要淘汰一个 freq 最小的 key */
        if (this->cap <= keyToVal.size()) {
            removeMinFreqKey();
        }

        /* 插入 key 和 val，对应的 freq 为 1 */
        // 插入 KV 表
        keyToVal[key] = val;
        // 插入 KF 表
        keyToFreq[key] = 1;
        // 插入 FK 表
        freqToKeys[1].insert(key);
        // 插入新 key 后最小的 freq 肯定是 1
        this->minFreq = 1;
    }

private:
    void increaseFreq(int key) {
        int freq = keyToFreq[key];
        /* 更新 KF 表 */
        keyToFreq[key] = freq + 1;
        /* 更新 FK 表 */
        // 将 key 从 freq 对应的列表中删除
        freqToKeys[freq].erase(key);
        // 将 key 加入 freq + 1 对应的列表中
        freqToKeys[freq + 1].insert(key);
        // 如果 freq 对应的列表空了，移除这个 freq
        if (freqToKeys[freq].empty()) {
            freqToKeys.erase(freq);
            // 如果这个 freq 恰好是 minFreq，更新 minFreq
            if (freq == this->minFreq) {
                this->minFreq++;
            }
        }
    }

    void removeMinFreqKey() {
        // freq 最小的 key 列表
        unordered_set<int> keyList = freqToKeys[this->minFreq];
        // 其中最先被插入的那个 key 就是该被淘汰的 key
        int deletedKey = *keyList.begin();
        /* 更新 FK 表 */
        keyList.erase(deletedKey);
        if (keyList.empty()) {
            freqToKeys.erase(this->minFreq);
            // 问：这里需要更新 minFreq 的值吗？
        }
        /* 更新 KV 表 */
        keyToVal.erase(deletedKey);
        /* 更新 KF 表 */
        keyToFreq.erase(deletedKey);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class LFUCache:

    def __init__(self, capacity: int):
        # key 到 val 的映射，我们后文称为 KV 表
        self.keyToVal = {}
        # key 到 freq 的映射，我们后文称为 KF 表
        self.keyToFreq = {}
        # freq 到 key 列表的映射，我们后文称为 FK 表
        self.freqToKeys = {}
        # 记录最小的频次
        self.minFreq = 0
        # 记录 LFU 缓存的最大容量
        self.cap = capacity

    def get(self, key: int) -> int:
        if key not in self.keyToVal:
            return -1
        # 增加 key 对应的 freq
        self.__increaseFreq(key)
        return self.keyToVal[key]

    def put(self, key: int, val: int) -> None:
        if self.cap <= 0:
            return

        # 若 key 已存在，修改对应的 val 即可
        if key in self.keyToVal:
            self.keyToVal[key] = val
            # key 对应的 freq 加一
            self.__increaseFreq(key)
            return

        # key 不存在，需要插入
        # 容量已满的话需要淘汰一个 freq 最小的 key
        if self.cap <= len(self.keyToVal):
            self.__removeMinFreqKey()

        # 插入 key 和 val，对应的 freq 为 1
        # 插入 KV 表
        self.keyToVal[key] = val
        # 插入 KF 表
        self.keyToFreq[key] = 1
        # 插入 FK 表
        self.freqToKeys.setdefault(1, set())
        self.freqToKeys[1].add(key)
        # 插入新 key 后最小的 freq 肯定是 1
        self.minFreq = 1

    def __increaseFreq(self, key: int):
        freq = self.keyToFreq[key]
        # 更新 KF 表
        self.keyToFreq[key] = freq + 1
        # 更新 FK 表
        # 将 key 从 freq 对应的列表中删除
        self.freqToKeys[freq].remove(key)
        # 将 key 加入 freq + 1 对应的列表中
        self.freqToKeys.setdefault(freq + 1, set())
        self.freqToKeys[freq + 1].add(key)
        # 如果 freq 对应的列表空了，移除这个 freq
        if not self.freqToKeys[freq]:
            del self.freqToKeys[freq]
            # 如果这个 freq 恰好是 minFreq，更新 minFreq
            if freq == self.minFreq:
                self.minFreq += 1

    def __removeMinFreqKey(self):
        # freq 最小的 key 列表
        keyList = self.freqToKeys[self.minFreq]
        # 其中最先被插入的那个 key 就是该被淘汰的 key
        deletedKey = keyList.pop()
        # 更新 FK 表
        if not keyList:
            del self.freqToKeys[self.minFreq]
        # 更新 KV 表
        del self.keyToVal[deletedKey]
        # 更新 KF 表
        del self.keyToFreq[deletedKey]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class LFUCache {

    // key 到 val 的映射，我们后文称为 KV 表
    HashMap<Integer, Integer> keyToVal;
    // key 到 freq 的映射，我们后文称为 KF 表
    HashMap<Integer, Integer> keyToFreq;
    // freq 到 key 列表的映射，我们后文称为 FK 表
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    // 记录最小的频次
    int minFreq;
    // 记录 LFU 缓存的最大容量
    int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        // 增加 key 对应的 freq
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int val) {
        if (this.cap <= 0) return;

        /* 若 key 已存在，修改对应的 val 即可 */
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, val);
            // key 对应的 freq 加一
            increaseFreq(key);
            return;
        }

        /* key 不存在，需要插入 */
        /* 容量已满的话需要淘汰一个 freq 最小的 key */
        if (this.cap <= keyToVal.size()) {
            removeMinFreqKey();
        }

        /* 插入 key 和 val，对应的 freq 为 1 */
        // 插入 KV 表
        keyToVal.put(key, val);
        // 插入 KF 表
        keyToFreq.put(key, 1);
        // 插入 FK 表
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        // 插入新 key 后最小的 freq 肯定是 1
        this.minFreq = 1;
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        /* 更新 KF 表 */
        keyToFreq.put(key, freq + 1);
        /* 更新 FK 表 */
        // 将 key 从 freq 对应的列表中删除
        freqToKeys.get(freq).remove(key);
        // 将 key 加入 freq + 1 对应的列表中
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        // 如果 freq 对应的列表空了，移除这个 freq
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            // 如果这个 freq 恰好是 minFreq，更新 minFreq
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }

    private void removeMinFreqKey() {
        // freq 最小的 key 列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        // 其中最先被插入的那个 key 就是该被淘汰的 key
        int deletedKey = keyList.iterator().next();
        /* 更新 FK 表 */
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
            // 问：这里需要更新 minFreq 的值吗？
        }
        /* 更新 KV 表 */
        keyToVal.remove(deletedKey);
        /* 更新 KF 表 */
        keyToFreq.remove(deletedKey);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

type LFUCache struct {
    // key 到 val 的映射，我们后文称为 KV 表
    keyToVal map[int]int
    // key 到 freq 的映射，我们后文称为 KF 表
    keyToFreq map[int]int
    // freq 到 key 列表的映射，我们后文称为 FK 表
    freqToKeys map[int]*linkedHashSet
    // 记录最小的频次
    minFreq int
    // 记录 LFU 缓存的最大容量
    cap int
}

func Constructor(capacity int) LFUCache {
    return LFUCache{
        keyToVal:   make(map[int]int),
        keyToFreq:  make(map[int]int),
        freqToKeys: make(map[int]*linkedHashSet),
        cap:        capacity,
        minFreq:    0,
    }
}

func (this *LFUCache) Get(key int) int {
    if _, ok := this.keyToVal[key]; !ok {
        return -1
    }
    // 增加 key 对应的 freq
    this.increaseFreq(key)
    return this.keyToVal[key]
}

func (this *LFUCache) Put(key int, val int) {
    if this.cap <= 0 {
        return
    }

    /* 若 key 已存在，修改对应的 val 即可 */
    if _, ok := this.keyToVal[key]; ok {
        this.keyToVal[key] = val
        // key 对应的 freq 加一
        this.increaseFreq(key)
        return
    }

    /* key 不存在，需要插入 */
    /* 容量已满的话需要淘汰一个 freq 最小的 key */
    if this.cap <= len(this.keyToVal) {
        this.removeMinFreqKey()
    }

    /* 插入 key 和 val，对应的 freq 为 1 */
    // 插入 KV 表
    this.keyToVal[key] = val
    // 插入 KF 表
    this.keyToFreq[key] = 1
    // 插入 FK 表
    this.freqToKeys[1].add(key)
    // 插入新 key 后最小的 freq 肯定是 1
    this.minFreq = 1
}

func (this *LFUCache) increaseFreq(key int) {
    freq := this.keyToFreq[key]
    /* 更新 KF 表 */
    this.keyToFreq[key] = freq + 1
    /* 更新 FK 表 */
    // 将 key 从 freq 对应的列表中删除
    this.freqToKeys[freq].remove(key)
    // 将 key 加入 freq + 1 对应的列表中
    if this.freqToKeys[freq+1] == nil {
        this.freqToKeys[freq+1] = newLinkedHashSet()
    }
    this.freqToKeys[freq+1].add(key)
    // 如果 freq 对应的列表空了，移除这个 freq
    if this.freqToKeys[freq].size() == 0 {
        delete(this.freqToKeys, freq)
        // 如果这个 freq 恰好是 minFreq，更新 minFreq
        if freq == this.minFreq {
            this.minFreq++
        }
    }
}

func (this *LFUCache) removeMinFreqKey() {
    // freq 最小的 key 列表
    keyList := this.freqToKeys[this.minFreq]
    // 其中最先被插入的那个 key 就是该被淘汰的 key
    deletedKey := keyList.iterator().next()
    /* 更新 FK 表 */
    keyList.remove(deletedKey)
    if keyList.size() == 0 {
        delete(this.freqToKeys, this.minFreq)
        // 问：这里需要更新 minFreq 的值吗？
    }
    /* 更新 KV 表 */
    delete(this.keyToVal, deletedKey)
    /* 更新 KF 表 */
    delete(this.keyToFreq, deletedKey)
}

// 封装一个链表
type linkedHashSet struct {
    m    map[int]*node
    head *node
    tail *node
}

func newLinkedHashSet() *linkedHashSet {
    head := &node{}
    tail := &node{}
    head.next = tail
    tail.prev = head
    return &linkedHashSet{
        m:    make(map[int]*node),
        head: head,
        tail: tail,
    }
}

func (this *linkedHashSet) size() int {
    return len(this.m)
}

func (this *linkedHashSet) add(key int) {
    if _, ok := this.m[key]; ok {
        return
    }
    n := &node{key: key}
    last := this.tail.prev
    last.next = n
    n.prev = last
    n.next = this.tail
    this.tail.prev = n
    this.m[key] = n
}

func (this *linkedHashSet) remove(key int) {
    if n, ok := this.m[key]; ok {
        n.prev.next = n.next
        n.next.prev = n.prev
        delete(this.m, key)
    }
}

func (this *linkedHashSet) iterator() *keyIterator {
    return &keyIterator{this.head.next}
}

type node struct {
    key  int
    prev *node
    next *node
}

type keyIterator struct {
    n *node
}

func (this *keyIterator) hasNext() bool {
    return this.n.next != nil
}

func (this *keyIterator) next() int {
    this.n = this.n.next
    return this.n.key
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
var LFUCache = function(capacity) {
    // key 到 val 的映射，我们后文称为 KV 表
    this.keyToVal = new Map();
    // key 到 freq 的映射，我们后文称为 KF 表
    this.keyToFreq = new Map();
    // freq 到 key 列表的映射，我们后文称为 FK 表
    this.freqToKeys = new Map();
    // 记录最小的频次
    this.minFreq = 0;
    // 记录 LFU 缓存的最大容量
    this.cap = capacity;
};

/** 
 * @param {number} key
 * @return {number}
 */
LFUCache.prototype.get = function(key) {
    if (!this.keyToVal.has(key)) {
        return -1;
    }
    // 增加 key 对应的 freq
    this.increaseFreq(key);
    return this.keyToVal.get(key);
};

/** 
 * @param {number} key 
 * @param {number} val
 * @return {void}
 */
LFUCache.prototype.put = function(key, val) {
    if (this.cap <= 0) return;

    /* 若 key 已存在，修改对应的 val 即可 */
    if (this.keyToVal.has(key)) {
        this.keyToVal.set(key, val);
        // key 对应的 freq 加一
        this.increaseFreq(key);
        return;
    }

    /* key 不存在，需要插入 */
    /* 容量已满的话需要淘汰一个 freq 最小的 key */
    if (this.cap <= this.keyToVal.size) {
        this.removeMinFreqKey();
    }

    /* 插入 key 和 val，对应的 freq 为 1 */
    // 插入 KV 表
    this.keyToVal.set(key, val);
    // 插入 KF 表
    this.keyToFreq.set(key, 1);
    // 插入 FK 表
    if (!this.freqToKeys.has(1)) {
        this.freqToKeys.set(1, new Set());
    }
    this.freqToKeys.get(1).add(key);
    // 插入新 key 后最小的 freq 肯定是 1
    this.minFreq = 1;
};

/**
 * @param {number} key
 * @return {void}
 */
LFUCache.prototype.increaseFreq = function(key) {
    let freq = this.keyToFreq.get(key);
    /* 更新 KF 表 */
    this.keyToFreq.set(key, freq + 1);
    /* 更新 FK 表 */
    // 将 key 从 freq 对应的列表中删除
    this.freqToKeys.get(freq).delete(key);
    // 将 key 加入 freq + 1 对应的列表中
    if (!this.freqToKeys.has(freq + 1)) {
        this.freqToKeys.set(freq + 1, new Set());
    }
    this.freqToKeys.get(freq + 1).add(key);
    // 如果 freq 对应的列表空了，移除这个 freq
    if (this.freqToKeys.get(freq).size === 0) {
        this.freqToKeys.delete(freq);
        // 如果这个 freq 恰好是 minFreq，更新 minFreq
        if (freq === this.minFreq) {
            this.minFreq++;
        }
    }
}

/**
 * @return {void}
 */
LFUCache.prototype.removeMinFreqKey = function() {
    // freq 最小的 key 列表
    let keyList = this.freqToKeys.get(this.minFreq);
    // 其中最先被插入的那个 key 就是该被淘汰的 key
    let deletedKey = keyList.values().next().value;
    /* 更新 FK 表 */
    keyList.delete(deletedKey);
    if (keyList.size === 0) {
        this.freqToKeys.delete(this.minFreq);
        // 问：这里需要更新 minFreq 的值吗？
    }
    /* 更新 KV 表 */
    this.keyToVal.delete(deletedKey);
    /* 更新 KF 表 */
    this.keyToFreq.delete(deletedKey);
};
```

</div></div>
</div></div>

</details>
</div>



