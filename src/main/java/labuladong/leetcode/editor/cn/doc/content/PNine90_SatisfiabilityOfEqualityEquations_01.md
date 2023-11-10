<p>You are given an array of strings <code>equations</code> that represent relationships between variables where each string <code>equations[i]</code> is of length <code>4</code> and takes one of two different forms: <code>"x<sub>i</sub>==y<sub>i</sub>"</code> or <code>"x<sub>i</sub>!=y<sub>i</sub>"</code>.Here, <code>x<sub>i</sub></code> and <code>y<sub>i</sub></code> are lowercase letters (not necessarily different) that represent one-letter variable names.</p>

<p>Return <code>true</code><em> if it is possible to assign integers to variable names so as to satisfy all the given equations, or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> equations = ["a==b","b!=a"]
<strong>Output:</strong> false
<strong>Explanation:</strong> If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
There is no way to assign the variables to satisfy both equations.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> equations = ["b==a","a==b"]
<strong>Output:</strong> true
<strong>Explanation:</strong> We could assign a = 1 and b = 1 to satisfy both equations.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= equations.length &lt;= 500</code></li> 
 <li><code>equations[i].length == 4</code></li> 
 <li><code>equations[i][0]</code> is a lowercase letter.</li> 
 <li><code>equations[i][1]</code> is either <code>'='</code> or <code>'!'</code>.</li> 
 <li><code>equations[i][2]</code> is <code>'='</code>.</li> 
 <li><code>equations[i][3]</code> is a lowercase letter.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>并查集 | 图 | 数组 | 字符串</details><br>

<div>👍 313, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=satisfiability-of-equality-equations" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 396 页。

本题是前文 [Union Find 并查集算法](https://labuladong.github.io/article/fname.html?fname=UnionFind算法详解) 的应用。

解题核心思想是，**将 `equations` 中的算式根据 `==` 和 `!=` 分成两部分，先处理 `==` 算式，使得他们通过相等关系各自勾结成门派（连通分量）；然后处理 `!=` 算式，检查不等关系是否破坏了相等关系的连通性**。

**详细题解：[并查集（Union-Find）算法](https://labuladong.github.io/article/fname.html?fname=UnionFind算法详解)**

**标签：并查集算法**

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
// 本代码不保证正确性，仅供参考。如有疑惑，可以参照我写的 java 代码对比查看。

class Solution {
public:
    bool equationsPossible(vector<string>& equations) {
        // 26 个英文字母
        UF uf(26);
        // 先让相等的字母形成连通分量
        for (string eq : equations) {
            if (eq[1] == '=') {
                char x = eq[0];
                char y = eq[3];
                uf.union_(x - 'a', y - 'a');
            }
        }
        // 检查不等关系是否打破相等关系的连通性
        for (string eq : equations) {
            if (eq[1] == '!') {
                char x = eq[0];
                char y = eq[3];
                // 如果相等关系成立，就是逻辑冲突
                if (uf.connected(x - 'a', y - 'a'))
                    return false;
            }
        }
        return true;
    }
};

class UF {
public:
    // 记录连通分量个数
    int count;
    // 存储若干棵树
    vector<int> parent;
    // 记录树的“重量”
    vector<int> size;

    UF(int n) {
        this->count = n;
        parent.resize(n);
        size.resize(n);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /* 将 p 和 q 连通 */
    void union_(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;

        // 小树接到大树下面，较平衡
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    /* 判断 p 和 q 是否互相连通 */
    bool connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        // 处于同一棵树上的节点，相互连通
        return rootP == rootQ;
    }

    /* 返回节点 x 的根节点 */
    int find(int x) {
        while (parent[x] != x) {
            // 进行路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    int getCount() {
        return count;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
        uf = UF(26) #26个字母
        # 先让相等的字母形成连通分量
        for eq in equations:
            if eq[1] == "=":
                x = ord(eq[0]) - ord('a')
                y = ord(eq[3]) - ord('a')
                uf.union(x, y)

        # 检查不等关系是否打破相等关系的连通性
        for eq in equations:
            if eq[1] == "!":
                x = ord(eq[0]) - ord('a')
                y = ord(eq[3]) - ord('a')
                # 如果相等关系成立，就是逻辑冲突
                if uf.connected(x, y):
                    return False
        return True

class UF:
    # 记录连通分量个数
    def __init__(self, n):
        self.count = n
        # 存储若干棵树
        self.parent = [i for i in range(n)]
        # 记录树的“重量”
        self.size = [1] * n

    # 将 p 和 q 连通
    def union(self, p, q):
        rootP = self.find(p)
        rootQ = self.find(q)
        if rootP == rootQ:
            return

        # 小树接到大树下面，较平衡
        if self.size[rootP] > self.size[rootQ]:
            self.parent[rootQ] = rootP
            self.size[rootP] += self.size[rootQ]
        else:
            self.parent[rootP] = rootQ
            self.size[rootQ] += self.size[rootP]
        self.count -= 1

    # 判断 p 和 q 是否互相连通
    def connected(self, p, q):
        rootP = self.find(p)
        rootQ = self.find(q)
        # 处于同一棵树上的节点，相互连通
        return rootP == rootQ

    # 返回节点 x 的根节点
    def find(self, x):
        while self.parent[x] != x:
            # 进行路径压缩
            self.parent[x] = self.parent[self.parent[x]]
            x = self.parent[x]
        return x

    def count(self):
        return self.count
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean equationsPossible(String[] equations) {
        // 26 个英文字母
        UF uf = new UF(26);
        // 先让相等的字母形成连通分量
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }
        // 检查不等关系是否打破相等关系的连通性
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                // 如果相等关系成立，就是逻辑冲突
                if (uf.connected(x - 'a', y - 'a'))
                    return false;
            }
        }
        return true;
    }
}

class UF {
    // 记录连通分量个数
    private int count;
    // 存储若干棵树
    private int[] parent;
    // 记录树的“重量”
    private int[] size;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /* 将 p 和 q 连通 */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;

        // 小树接到大树下面，较平衡
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    /* 判断 p 和 q 是否互相连通 */
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        // 处于同一棵树上的节点，相互连通
        return rootP == rootQ;
    }

    /* 返回节点 x 的根节点 */
    private int find(int x) {
        while (parent[x] != x) {
            // 进行路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int count() {
        return count;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

type UF struct {
    // 记录连通分量个数
    Count int
    // 存储若干棵树
    Parent []int
    // 记录树的“重量”
    Size []int
}

func NewUF(n int) *UF {
    u := UF{}
    u.Count = n
    u.Parent = make([]int, n)
    u.Size = make([]int, n)
    for i := 0; i < n; i++ {
        u.Parent[i] = i
        u.Size[i] = 1
    }
    return &u
}

/* 将 p 和 q 连通 */
func (u *UF) Union(p, q int) {
    rootP := u.find(p)
    rootQ := u.find(q)
    if rootP == rootQ {
        return
    }

    // 小树接到大树下面，较平衡
    if u.Size[rootP] > u.Size[rootQ] {
        u.Parent[rootQ] = rootP
        u.Size[rootP] += u.Size[rootQ]
    } else {
        u.Parent[rootP] = rootQ
        u.Size[rootQ] += u.Size[rootP]
    }
    u.Count--
}

/* 判断 p 和 q 是否互相连通 */
func (u *UF) Connected(p, q int) bool {
    rootP := u.find(p)
    rootQ := u.find(q)
    // 处于同一棵树上的节点，相互连通
    return rootP == rootQ
}

/* 返回节点 x 的根节点 */
func (u *UF) find(x int) int {
    for u.Parent[x] != x {
        // 进行路径压缩
        u.Parent[x] = u.Parent[u.Parent[x]]
        x = u.Parent[x]
    }
    return x
}

func equationsPossible(equations []string) bool {
    // 26 个英文字母
    uf := NewUF(26)
    // 先让相等的字母形成连通分量
    for _, eq := range equations {
        if eq[1] == '=' {
            x := eq[0]
            y := eq[3]
            uf.Union(int(x-'a'), int(y-'a'))
        }
    }
    // 检查不等关系是否打破相等关系的连通性
    for _, eq := range equations {
        if eq[1] == '!' {
            x := eq[0]
            y := eq[3]
            // 如果相等关系成立，就是逻辑冲突
            if uf.Connected(int(x-'a'), int(y-'a')) {
                return false
            }
        }
    }
    return true
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var equationsPossible = function(equations) {
    // 26 个英文字母
  let uf = new ufFunc(26);
  // 先让相等的字母形成连通分量
  for (let i = 0 ; i <equations.length; i++) {
    let eq = equations[i];
    if (eq.charAt(1) == '=') {
      let x = eq.charAt(0);
      let y = eq.charAt(3);
      uf.union(x.charCodeAt()-97, y.charCodeAt()-97);
    }
  }
  // 检查不等关系是否打破相等关系的连通性
  for (let i = 0 ; i <equations.length; i++) {
    let eq = equations[i];
    if (eq.charAt(1) == '!') {
      let x = eq.charAt(0);
      let y = eq.charAt(3);
      // 如果相等关系成立，就是逻辑冲突
      if (uf.connected(x.charCodeAt()-97, y.charCodeAt()-97))
        return false;
      }
  }
  return true;
 }

class ufFunc {
  // 记录连通分量个数
  constructor(n) {
    this.count = n;
    // 存储若干棵树
    this.parent = [];
    // 记录树的“重量”
    this.size = [];
    for (let i = 0; i < n; i++) {
      this.parent.push(i);
      this.size.push(1);
    }
  }

  /* 将 p 和 q 连通 */
  union(p, q) {
    let rootP = this.find(p);
    let rootQ = this.find(q);
    if (rootP == rootQ)
      return;

    // 小树接到大树下面，较平衡
    if (this.size[rootP] > this.size[rootQ]) {
      this.parent[rootQ] = rootP;
      this.size[rootP] += this.size[rootQ];
    } else {
      this.parent[rootP] = rootQ;
      this.size[rootQ] += this.size[rootP];
    }
    this.count--;
  }

  /* 判断 p 和 q 是否互相连通 */
  connected(p, q) {
    let rootP = this.find(p);
    let rootQ = this.find(q);
    // 处于同一棵树上的节点，相互连通
    return rootP == rootQ;
  }

  /* 返回节点 x 的根节点 */
  find(x) {
    while (this.parent[x] != x) {
      // 进行路径压缩
      this.parent[x] = this.parent[this.parent[x]];
      x = this.parent[x];
    }
    return x;
  }

  count() {
      return this.count;
  }
}
```

</div></div>
</div></div>

**类似题目**：
  - [130. 被围绕的区域 🟠](/problems/surrounded-regions)
  - [323. 无向图中连通分量的数目 🟠](/problems/number-of-connected-components-in-an-undirected-graph)

</details>
</div>



