<p>Given the <code>root</code>&nbsp;of a binary tree, return all <strong>duplicate subtrees</strong>.</p>

<p>For each kind of duplicate subtrees, you only need to return the root node of any <b>one</b> of them.</p>

<p>Two trees are <strong>duplicate</strong> if they have the <strong>same structure</strong> with the <strong>same node values</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/16/e1.jpg" style="width: 450px; height: 354px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3,4,null,2,4,null,null,4]
<strong>Output:</strong> [[2,4],[4]]
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/16/e2.jpg" style="width: 321px; height: 201px;" /> 
<pre>
<strong>Input:</strong> root = [2,1,1]
<strong>Output:</strong> [[1]]
</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/16/e33.jpg" style="width: 450px; height: 303px;" /> 
<pre>
<strong>Input:</strong> root = [2,2,2,3,null,3,null]
<strong>Output:</strong> [[2,3],[3]]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of the nodes in the tree will be in the range <code>[1, 5000]</code></li> 
 <li><code>-200 &lt;= Node.val &lt;= 200</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 哈希表 | 二叉树</details><br>

<div>👍 681, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=find-duplicate-subtrees" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

比如说，你站在图中这个节点 2 上：

![](https://labuladong.github.io/pictures/二叉树3/4.png)

如果你想知道以自己为根的子树是不是重复的，是否应该被加入结果列表中，你需要知道什么信息？

**你需要知道以下两点**：

**1、以我为根的这棵二叉树（子树）长啥样**？

**2、以其他节点为根的子树都长啥样**？

这就叫知己知彼嘛，我得知道自己长啥样，还得知道别人长啥样，然后才能知道有没有人跟我重复，对不对？

我怎么知道自己以我为根的二叉树长啥样？前文 [序列化和反序列化二叉树](https://labuladong.github.io/article/fname.html?fname=二叉树的序列化) 其实写过了，二叉树的前序/中序/后序遍历结果可以描述二叉树的结构。

我咋知道其他子树长啥样？每个节点都把以自己为根的子树的样子存到一个外部的数据结构里即可。

按照这个思路看代码就不难理解了。

**详细题解：[东哥带你刷二叉树（后序篇）](https://labuladong.github.io/article/fname.html?fname=二叉树系列3)**

**标签：[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)**

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

#include <unordered_map>
#include <vector>
using namespace std;

class Solution {
    // 记录所有子树以及出现的次数
    unordered_map<string, int> memo;
    // 记录重复的子树根节点
    vector<TreeNode*> res;

public:
    /* 主函数 */
    vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
        traverse(root);
        return res;
    }

    string traverse(TreeNode* root) {
        if (root == nullptr) {
            return "#";
        }

        string left = traverse(root->left);
        string right = traverse(root->right);

        string subTree = left + "," + right + "," + to_string(root->val);

        int freq = memo[subTree];
        // 多次重复也只会被加入结果集一次
        if (freq == 1) {
            res.push_back(root);
        }
        // 给子树对应的出现次数加一
        memo[subTree] = freq + 1;
        return subTree;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def findDuplicateSubtrees(self, root: TreeNode) -> List[TreeNode]:
        memo = {}
        res = []

        def traverse(root):
            if not root:
                return "#"

            left = traverse(root.left)
            right = traverse(root.right)

            subTree = left + "," + right + "," + str(root.val)

            freq = memo.get(subTree, 0)
            # 多次重复也只会被加入结果集一次
            if freq == 1:
                res.append(root)
            # 给子树对应的出现次数加一
            memo[subTree] = freq + 1
            return subTree

        traverse(root)
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 记录所有子树以及出现的次数
    HashMap<String, Integer> memo = new HashMap<>();
    // 记录重复的子树根节点
    LinkedList<TreeNode> res = new LinkedList<>();

    /* 主函数 */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;

        int freq = memo.getOrDefault(subTree, 0);
        // 多次重复也只会被加入结果集一次
        if (freq == 1) {
            res.add(root);
        }
        // 给子树对应的出现次数加一
        memo.put(subTree, freq + 1);
        return subTree;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

import (
    "strconv"
)

// TreeNode Definition for a binary tree node.

// findDuplicateSubtrees 记录所有子树以及出现的次数
func findDuplicateSubtrees(root *TreeNode) []*TreeNode {
    memo := make(map[string]int)
    res := []*TreeNode{}

    traverse(root, memo, &res)

    return res
}

// traverse 深度优先遍历
func traverse(root *TreeNode, memo map[string]int, res *[]*TreeNode) string {
    if root == nil {
        return "#"
    }

    left := traverse(root.Left, memo, res)
    right := traverse(root.Right, memo, res)

    subTree := left + "," + right + "," + strconv.Itoa(root.Val)

    freq := memo[subTree]
    // 多次重复也只会被加入结果集一次
    if freq == 1 {
        *res = append(*res, root)
    }
    // 给子树对应的出现次数加一
    memo[subTree]++
    return subTree
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var findDuplicateSubtrees = function(root) {
    // 记录所有子树以及出现的次数
    const memo = new Map();
    // 记录重复的子树根节点
    const res = [];

    /* 主函数 */
    const traverse = function(root) {
        if (root == null) {
            return "#";
        }

        const left = traverse(root.left);
        const right = traverse(root.right);

        const subTree = left + "," + right + "," + root.val;

        const freq = memo.get(subTree) || 0;
        // 多次重复也只会被加入结果集一次
        if (freq === 1) {
            res.push(root);
        }
        // 给子树对应的出现次数加一
        memo.set(subTree, freq + 1);
        return subTree;
    };

    traverse(root);
    return res;
};
```

</div></div>
</div></div>

</details>
</div>



