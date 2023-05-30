<p>Given the <code>root</code> of a <strong>complete</strong> binary tree, return the number of the nodes in the tree.</p>

<p>According to <strong><a href="http://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees" target="_blank">Wikipedia</a></strong>, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between <code>1</code> and <code>2<sup>h</sup></code> nodes inclusive at the last level <code>h</code>.</p>

<p>Design an algorithm that runs in less than&nbsp;<code data-stringify-type="code">O(n)</code>&nbsp;time complexity.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/14/complete.jpg" style="width: 372px; height: 302px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3,4,5,6]
<strong>Output:</strong> 6
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = []
<strong>Output:</strong> 0
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [1]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[0, 5 * 10<sup>4</sup>]</code>.</li> 
 <li><code>0 &lt;= Node.val &lt;= 5 * 10<sup>4</sup></code></li> 
 <li>The tree is guaranteed to be <strong>complete</strong>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二分查找 | 二叉树</details><br>

<div>👍 947, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=count-complete-tree-nodes" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 243 页。

一棵完全二叉树的两棵子树，至少有一棵是满二叉树：

![](https://labuladong.github.io/pictures/complete_tree/1.jpg)

计算满二叉树的节点个数不用一个个节点去数，可以直接通过树高算出来，这也是这道题提高效率的关键点。

**详细题解：[如何计算完全二叉树的节点数](https://labuladong.github.io/article/fname.html?fname=完全二叉树节点数)**

**标签：[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)**

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

class Solution {
public:
    int countNodes(TreeNode* root) {
        TreeNode* l = root;
        TreeNode* r = root;
        // 记录左、右子树的高度
        int hl = 0, hr = 0;
        while (l != nullptr) {
            l = l->left;
            hl++;
        }
        while (r != nullptr) {
            r = r->right;
            hr++;
        }
        // 如果左右子树的高度相同，则是一棵满二叉树
        if (hl == hr) {
            return pow(2, hl) - 1;
        }
        // 如果左右高度不同，则按照普通二叉树的逻辑计算
        return 1 + countNodes(root->left) + countNodes(root->right);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        l, r = root, root
        hl, hr = 0, 0
        # 记录左、右子树的高度
        while l:
            l = l.left
            hl += 1
        while r:
            r = r.right
            hr += 1
        # 如果左右子树的高度相同，则是一棵满二叉树
        if hl == hr:
            return 2 ** hl - 1
        # 如果左右高度不同，则按照普通二叉树的逻辑计算
        return 1 + self.countNodes(root.left) + self.countNodes(root.right)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        // 记录左、右子树的高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        // 如果左右子树的高度相同，则是一棵满二叉树
        if (hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        }
        // 如果左右高度不同，则按照普通二叉树的逻辑计算
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func countNodes(root *TreeNode) int {
    // 记录左、右子树的高度
    hl, hr := 0, 0
    l, r := root, root
    for l != nil {
        l = l.Left
        hl++
    }
    for r != nil {
        r = r.Right
        hr++
    }
    // 如果左右子树的高度相同，则是一棵满二叉树
    if hl == hr {
        return int(math.Pow(2, float64(hl))) - 1
    }
    // 如果左右高度不同，则按照普通二叉树的逻辑计算
    return 1 + countNodes(root.Left) + countNodes(root.Right)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var countNodes = function(root) {
    let l = root, r = root;
    // 记录左、右子树的高度
    let hl = 0, hr = 0;

    while (l !== null) {
        l = l.left;
        hl++;
    }

    while (r !== null) {
        r = r.right;
        hr++;
    }

    // 如果左右子树的高度相同，则是一棵满二叉树
    if (hl === hr) {
        return Math.pow(2, hl) - 1;
    }

    // 如果左右高度不同，则按照普通二叉树的逻辑计算
    return 1 + countNodes(root.left) + countNodes(root.right);
};
```

</div></div>
</div></div>

<details open><summary><strong>👉 算法可视化 👈</strong></summary><div class="resizable aspect-ratio-container" style="height: 70vh;">
    <iframe src="https://labuladong.github.io/algo-visualize/" width="100%"
    height="100%" scrolling="auto" frameborder="0"
    style="overflow: auto;" id="iframe_count-complete-tree-nodes"></iframe>
</div>
<div id="data_count-complete-tree-nodes" data="G/NMERWjxURRqiZRFMHGAai2SGiRYB4Sb7dgWLBJkg5S4q+jPHIOzz5G4o59zTXtzIuHiC/JaZKmDbdiIdzHBimrKXksh76+2V4V2iI5Qmo+EUEDnprBNth6Q6Fa7c7jfqcc1Mr2jYvUHskhKcSvX0MLnPBNXaNa3ihThvHAwjW7+/NC15SAXPPuQqzKeGXhIlSl63iC+H5N51QArcY3p8LChoXC9ZHuMECt0HU1Rn1qeXxlZaDEpnlyXUBe1TJGwUu79n64/unqKhGwNn8CV8fgf6HsjvyG9WerGVHmd7zwBANvZBiy3NAwVui78SGMloX9jX88AdG/4ako1LWJ2KjsvZbnxWpgy2f9I7N2XTCwtPQLtWn/CxX7fU+KicA1jkJrbEinhkjVsaDYelD9xh5QLl7/VJd8NWpQs4wTaBaFTJlk9sU+8ZzaK3P+g7UGrbTAqf9BJigWMVDc58pL7Uv8Ocdf3h6s9qK4YnsY0gsvgLe/OGRyrIsiV6h5ut33wnkq6lNrOuebjFRKHOuZFZ9ZBxnl0GmZ7TqOUDzDzof1zO7O82ldYQYtOgvMZth54Z7Jp16V2OyfThgemqW6x2EbvLjYEMkRxS3GjRSpZVcF6PtOjj6P4+u2JGI+XrcpK9BySR4S02romSwFXiXaJqgXu71PNmW/8Obo7efIRs8OMGqrRWatlGbZX8CaCdtc+w79ZlGYZNR+HvG4WtIoE4404Ztl4mUP4EvJHjea9PJC/qU2v2+Jm3d1aLuW/i1Xp5V2D77NLggkwgh0VjVT2gCnzh3J9wkIc1sVPNeIYacmFbUHcKZmjxtNenEynwjJb2gUF6HbIw3bvxJbhIcjL9jbwhgVoQu41QVwjNiihAf3x+8AE3OJffB/xVhcwpG9QkW5LdIMi8FZJ3jf+Ft9phkUmcPFySV6vMjLJ3KRz+v/aP6+FxYC/hj7QJ7xqV7wLb+hF8nIqyb5LFlRsogQowjb2/IYFaELuNUFcIyspux+eFzMVJWEI3uFinpzgFWuhP+ukZiie4AZja1BRegCbnUBHCM2qRZ+B5BWseW2MMb6Pnl5X4ZJnPL0PouEPERgaz2e9ehxqkcPzqM3xk6a0QukttDKyNP7MkgtxpQdUURksMkLtBl7ccnL+zInFY7TjXrk3AYGUKPvpNNu+LGNjXq0XOHlhUO59NAd2oI3/w8HtCtiLNRiElIx3Upbya4Oz/B+eA+H4ccPxvTxoQUMzQ5+vQx2AYqGRUtYtOUGjjQRZVjg6TOKZAP2dWAKuvO6gNgHjSlI5yVD7FLDFGhyYWR4QKFswOZjpoCTEdXNoGBA0Hnae7DsCP24hxEBkaesBmROHrK2ZhpGt5xlUXiJIJYqwtpi5SdYThyzvMTD5+7NSpMKwyhkdWcPgqwabTyS1bTSMpY7pJZcEuKlRjgrcVUbsvpqnoCsbjWskpVm4+gkW1tr9ry9tr8MPIQ+PWvHWJXGTw1I+Yz5HDevp+chjti3p6fPN2zQNsCvli1qo/vfyrcWeiHhFNvyohLYHy7vBumzZLT5Cszie40LhKQC9n+jhxePqW2Hvob71ZhruAhyArCVMytt/F/74SWKVGW5vg9MUsfBO1NRgpUgn0ZwwQTwwhPX0WQ9PHUsTfKSAsTPUEQ4VMY8JvPF/daylbEYRXRzIRPwkmOfshs9MnSMcGdUOQlGaYzRGoxFwVp6GxV1+1fgxUgZguk1QS99iq5CNU5CGNFeSqGqcZLwRzduR9OzkgCXx7ApQOJHkj/BCC8Jf069lLcHoaZ0VVkQCaOc1ji+z5ePL3oZQIlUIRiACIEzgyrkGSpa6mzGv6iXWbxwRlt1CU93ANWN0QxX+54voV6KGiWc3WjbeAE+pYqKuL0QPpSGaJVLgY/eQU62nQOjpcZ8ESlOyLOZWi1O3C9XLNZsDryXCQ6opffbDrIsszWRHy2NhL37YQqZSGf0n3yvYdp40ctRg5KqWUelhQA6Jgdbur2RFVqug8ScJrYiJfmh2ycLkJwUBdVxRLQuRZWSABLaRREBk9ms2W10JTVDIZj2g04Qt3E4eRyqlKYSTOOpmx+nSoXIdZGP7EYTK+2dxupm7JePL8ArCcPsFVQvIZzYNJNhpK1wy7MNiafTkCk1ES6aBStJwtvW21WFSsVaBZWdA4hgpZPeGy6Om4ICe8EAe+G9TfGDDEISBHE3mESUiMRNukmdM+VlXlNVunUo6AsnPhDDDnyzyuIl3UACiu02/Wo1atcN1AzhsFmI4fYD+t+brkur+5/PbalN8KbdCnWdAiR2GtDKKUCKpwBNzWWHdOZboJAZFsIM9C4BWcuwemUgUhloUQaSk2FlyUBAMtCJDOQgw6qPgbgjoOEYlmqg9mlJ2X4imesy9dTiCTldno7Z9ZjSFGIcihwrHG4cYJbxdsI3RInfkNOwQM7CnIgGFsgZmBMxw5yoByyQE1ggZ2FOBIY5ERcskLMwJxoMC+QMzImEYU40AhbIaZhzgKAHDvBV7p/KoItkqyAqPKvOT4tYxcSvnTddi93D79+167ou29XlbusB+cTnN+KNANvX1nTE/3e2Bgxh0snMk+w14SihKj8cxajzYxVeufOPSMXZ3D3b2tJqggjo2lxVfhAszTcAJ31eXr6r9Sdy03JuSbBH1cLbKZ0jgS4krn/Kyp8npr4I/yEuKuO5dbqtLm/pwftX+lUgpALQNPlbtrZ6ilEQrK9fK/6Jq3PbC7Q6nxe7lY5sPB4ub2+Qizt0gYVDNcaX4O5ni1uNHHjfTbrlemCFb3nd1iLI8q1qcYifik/LNUi/Kjtoc6AY/s4m099Y9FGs+oLi36JzweYtthgEAVrVi0PlOWRbeH4EtRdPzwE="></div></details><hr /><br />

</details>
</div>



