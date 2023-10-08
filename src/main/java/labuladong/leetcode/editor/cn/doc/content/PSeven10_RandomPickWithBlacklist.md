<p>You are given an integer <code>n</code> and an array of <strong>unique</strong> integers <code>blacklist</code>. Design an algorithm to pick a random integer in the range <code>[0, n - 1]</code> that is <strong>not</strong> in <code>blacklist</code>. Any integer that is in the mentioned range and not in <code>blacklist</code> should be <strong>equally likely</strong> to be returned.</p>

<p>Optimize your algorithm such that it minimizes the number of calls to the <strong>built-in</strong> random function of your language.</p>

<p>Implement the <code>Solution</code> class:</p>

<ul> 
 <li><code>Solution(int n, int[] blacklist)</code> Initializes the object with the integer <code>n</code> and the blacklisted integers <code>blacklist</code>.</li> 
 <li><code>int pick()</code> Returns a random integer in the range <code>[0, n - 1]</code> and not in <code>blacklist</code>.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
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

<details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 数学 | 二分查找 | 排序 | 随机化</details><br>

<div>👍 232, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=random-pick-with-blacklist" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

本题考察如下两点：

1、如果想高效地，等概率地随机获取元素，就要使用数组作为底层容器。

2、如果既要保持数组元素的紧凑性，又想从数组中间删除元素，那么可以把待删除元素换到最后，然后 `pop` 掉末尾的元素，这样时间复杂度就是 O(1) 了。当然，这样做的代价是我们需要额外的哈希表记录值到索引的映射。

**详细题解：[常数时间删除/查找数组中的任意元素](https://labuladong.github.io/article/fname.html?fname=随机集合)**

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[随机算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">cpp🟢</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">java🤖</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item active" data-tab-group="default"><div class="highlight">

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

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def __init__(self, N: int, blacklist: List[int]):
        # 需要返回的数字范围为[0, sz)
        self.sz = N - len(blacklist)
        # 将黑名单中的数字映射到666，即避免选中
        self.mapping = {}
        for b in blacklist:
            self.mapping[b] = 666
        
        # 对于黑名单中的数字，如果其在[0, sz)范围内，
        # 且不在mapping中，对其进行重新映射
        last = N - 1
        for b in blacklist:
            if b >= self.sz:
                continue
            # 在映射中查找不在黑名单中，且小于N的最大的数last
            while last in self.mapping:
                last -= 1
            # 将b映射到last
            self.mapping[b] = last
            last -= 1

    def pick(self) -> int:
        # 随机选择一个数字
        index = random.randint(0, self.sz-1)
        # 如果所选数字在映射中，返回其映射值
        if index in self.mapping:
            return self.mapping[index]
        # 如果所选数字不在映射中，直接返回
        return index
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
// 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    int sz;
    Map<Integer, Integer> mapping;

    public Solution(int N, int[] blacklist) {
        sz = N - blacklist.length;
        mapping = new HashMap<>();

        for (int b : blacklist) {
            mapping.put(b, 666); // 标记黑名单
        }

        int last = N - 1;
        for (int b : blacklist) {
            // 如果 b 已经在区间 [sz, N)，可以直接忽略
            if (b >= sz) {
                continue;
            }
            while (mapping.containsKey(last)) { // 找到可以映射的位置
                last--;
            }
            mapping.put(b, last); // 映射
            last--;
        }
    }

    public int pick() {
        // 随机选取一个索引
        int index = (int)(Math.random() * sz);
        // 这个索引命中了黑名单，需要被映射到其他位置
        if (mapping.containsKey(index)) {
            return mapping.get(index);
        }
        // 若没命中黑名单，则直接返回
        return index;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

type Solution struct {
    sz      int
    mapping map[int]int
}

// 构造函数，初始化黑名单映射表
// N: [0, N) 中的数字
// blacklist: 黑名单中的数字
func Constructor(N int, blacklist []int) Solution {
    s := Solution{}
    s.sz = N - len(blacklist)
    s.mapping = make(map[int]int)

    for _, b := range blacklist {
        s.mapping[b] = 666
    }

    last := N - 1
    for _, b := range blacklist {
        // 已经在区间 [sz, N) 的数字可以直接忽略
        if b >= s.sz {
            continue
        }
        // 找到可以映射到b的值
        for _, ok := s.mapping[last]; ok; _, ok = s.mapping[last] {
            last--
        }
        s.mapping[b] = last
        last--
    }

    return s
}

// 从集合中随机选择一个不在黑名单中的数字
func (this *Solution) Pick() int {
    index := rand.Intn(this.sz)
    if val, ok := this.mapping[index]; ok {
        return val
    }
    return index
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number} N
 * @param {number[]} blacklist
 */
var Solution = function(N, blacklist) {
   // 求出白名单的长度 
   this.sz = N - blacklist.length;
   // 创建一个字典，用于快速查找黑名单中的元素
   this.mapping = {};
   // 将所有黑名单中的元素标记为 666
   blacklist.forEach((b) => {
      this.mapping[b] = 666;
   });
   // 遍历黑名单中的元素，为之给定一个新的位置
   let last = N - 1;
   // 注意遍历的顺序，需要将最后的黑名单尽量映射到白名单前面的位置
   blacklist.forEach((b) => {
      // 如果该黑名单元素已经在白名单的范围内了，则不需要进行映射
      if (b >= this.sz) {
         return;
      }
      // 找到还未被映射的最大的位置
      while (this.mapping.hasOwnProperty(last)) {
         last--;
      }
      // 为当前黑名单元素 b 指定一个新的位置
      this.mapping[b] = last;
      last--;
   });
};

/**
 * @return {number}
 */
Solution.prototype.pick = function() {
   // 随机选取一个索引值
   let index = Math.floor(Math.random() * this.sz);
   // 如果该索引位是黑名单中的元素，则将其映射到新的位置上
   if (this.mapping.hasOwnProperty(index)) {
      return this.mapping[index];
   }
   // 否则直接返回该索引值
   return index;
};
```

</div></div>
</div></div>

**类似题目**：
  - [380. O(1) 时间插入、删除和获取随机元素 🟠](/problems/insert-delete-getrandom-o1)
  - [剑指 Offer II 030. 插入、删除和随机访问都是 O(1) 的容器 🟠](/problems/FortPu)

</details>
</div>



