<p>Given an integer <code>n</code>, return <em>all the structurally unique <strong>BST'</strong>s (binary search trees), which has exactly </em><code>n</code><em> nodes of unique values from</em> <code>1</code> <em>to</em> <code>n</code>. Return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg" style="width: 600px; height: 148px;" /> 
<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> [[1]]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 8</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 二叉搜索树 | 动态规划 | 回溯 | 二叉树</details><br>

<div>👍 1427, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=unique-binary-search-trees-ii" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

类似 [96. 不同的二叉搜索树](/problems/unique-binary-search-trees)，这题的思路也是类似的，想要构造出所有合法 BST，分以下三步：

1、穷举 `root` 节点的所有可能。

2、递归构造出左右子树的所有合法 BST。

3、给 `root` 节点穷举所有左右子树的组合。

**详细题解：[东哥带你刷二叉搜索树（构造篇）](https://labuladong.github.io/article/fname.html?fname=BST3)**

**标签：[二叉搜索树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121995456690946054)，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)**

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
    /* 主函数 */
    vector<TreeNode*> generateTrees(int n) {
        if (n == 0) return vector<TreeNode*>({});
        // 构造闭区间 [1, n] 组成的 BST
        return build(1, n);
    }

    /* 构造闭区间 [lo, hi] 组成的 BST */
    vector<TreeNode*> build(int lo, int hi) {
        vector<TreeNode*> res;
        // base case
        if (lo > hi) {
            res.push_back(nullptr);
            return res;
        }

        // 1、穷举 root 节点的所有可能。
        for (int i = lo; i <= hi; i++) {
            // 2、递归构造出左右子树的所有合法 BST。
            vector<TreeNode*> leftTree = build(lo, i - 1);
            vector<TreeNode*> rightTree = build(i + 1, hi);
            // 3、给 root 节点穷举所有左右子树的组合。
            for (auto left : leftTree) {
                for (auto right : rightTree) {
                    // i 作为根节点 root 的值
                    TreeNode* root = new TreeNode(i);
                    root->left = left;
                    root->right = right;
                    res.push_back(root);
                }
            }
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        if n == 0: # 如果节点数量为 0，则返回一个空列表
            return [] 
        return self.build(1, n) # 构造闭区间 [1, n] 的 BST

    def build(self, lo: int, hi: int) -> List[TreeNode]:
        res = []
        # 当 lo > hi 时，不存在节点，将 None 存入结果列表中，并返回
        if lo > hi: 
            res.append(None)
            return res

        # 1、穷举 root 节点的所有可能。
        for i in range(lo, hi + 1): 
            # 2、递归构造出左右子树的所有合法 BST。
            leftTree = self.build(lo, i - 1)
            rightTree = self.build(i + 1, hi)
            # 3、给 root 节点穷举所有左右子树的组合。
            for left in leftTree:
                for right in rightTree:
                    # i 作为根节点 root 的值
                    root = TreeNode(i)
                    root.left = left
                    root.right = right
                    res.append(root)

        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    /* 主函数 */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        // 构造闭区间 [1, n] 组成的 BST
        return build(1, n);
    }

    /* 构造闭区间 [lo, hi] 组成的 BST */
    List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();
        // base case
        if (lo > hi) {
            res.add(null);
            return res;
        }

        // 1、穷举 root 节点的所有可能。
        for (int i = lo; i <= hi; i++) {
            // 2、递归构造出左右子树的所有合法 BST。
            List<TreeNode> leftTree = build(lo, i - 1);
            List<TreeNode> rightTree = build(i + 1, hi);
            // 3、给 root 节点穷举所有左右子树的组合。
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    // i 作为根节点 root 的值
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/* 主函数 */
func generateTrees(n int) []*TreeNode {
    if n == 0 { return []*TreeNode{} }
    // 构造闭区间 [1, n] 组成的 BST
    return build(1, n)
}

/* 构造闭区间 [lo, hi] 组成的 BST */
func build(lo, hi int) []*TreeNode {
    res := []*TreeNode{}
    // base case
    if lo > hi {
        res = append(res, nil)
        return res
    }

    // 1、穷举 root 节点的所有可能。
    for i := lo; i <= hi; i++ {
        // 2、递归构造出左右子树的所有合法 BST。
        leftTree := build(lo, i-1)
        rightTree := build(i+1, hi)
        // 3、给 root 节点穷举所有左右子树的组合。
        for _, left := range leftTree {
            for _, right := range rightTree {
                // i 作为根节点 root 的值
                root := &TreeNode{Val: i}
                root.Left = left
                root.Right = right
                res = append(res, root)
            }
        }
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var generateTrees = function(n) {
  if (n == 0) return new Array();
  // 构造闭区间 [1, n] 组成的 BST
  return build(1, n);
}

var build = function(lo, hi) {
  // 存储 BST 的结果集
  var res = new Array();
  // base case
  if (lo > hi) {
    // 注意：这里必须添加 null，否则在下面无法递归左右子树
    res.push(null);
    return res;
  }
  // 1、穷举 root 节点的所有可能
  for (var i = lo; i <= hi; i++) {
    // 2、递归构造出左右子树的所有合法 BST
    var leftTree = build(lo, i - 1);
    var rightTree = build(i + 1, hi);
    // 3、给 root 节点穷举所有左右子树的组合
    for (var j = 0; j < leftTree.length; j++) {
      for (var k = 0; k < rightTree.length; k++) {
        // i 作为根节点 root 的值
        var root = new TreeNode(i);
        root.left = leftTree[j];
        root.right = rightTree[k];
        res.push(root);
      }
    }
  }
  return res;
};
```

</div></div>
</div></div>

**类似题目**：
  - [96. 不同的二叉搜索树 🟠](/problems/unique-binary-search-trees)

</details>
</div>



