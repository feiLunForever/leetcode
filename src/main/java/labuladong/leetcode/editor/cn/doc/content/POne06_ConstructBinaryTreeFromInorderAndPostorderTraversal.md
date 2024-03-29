<p>Given two integer arrays <code>inorder</code> and <code>postorder</code> where <code>inorder</code> is the inorder traversal of a binary tree and <code>postorder</code> is the postorder traversal of the same tree, construct and return <em>the binary tree</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" style="width: 277px; height: 302px;" /> 
<pre>
<strong>Input:</strong> inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
<strong>Output:</strong> [3,9,20,null,null,15,7]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> inorder = [-1], postorder = [-1]
<strong>Output:</strong> [-1]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= inorder.length &lt;= 3000</code></li> 
 <li><code>postorder.length == inorder.length</code></li> 
 <li><code>-3000 &lt;= inorder[i], postorder[i] &lt;= 3000</code></li> 
 <li><code>inorder</code> and <code>postorder</code> consist of <strong>unique</strong> values.</li> 
 <li>Each value of <code>postorder</code> also appears in <code>inorder</code>.</li> 
 <li><code>inorder</code> is <strong>guaranteed</strong> to be the inorder traversal of the tree.</li> 
 <li><code>postorder</code> is <strong>guaranteed</strong> to be the postorder traversal of the tree.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 数组 | 哈希表 | 分治 | 二叉树</details><br>

<div>👍 983, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=construct-binary-tree-from-inorder-and-postorder-traversal" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

**构造二叉树，第一件事一定是找根节点，然后想办法构造左右子树**。

二叉树的后序和中序遍历结果的特点如下：

![](https://labuladong.github.io/pictures/二叉树系列2/5.jpeg)

后序遍历结果最后一个就是根节点的值，然后再根据中序遍历结果确定左右子树的节点。

![](https://labuladong.github.io/pictures/二叉树系列2/6.jpeg)

结合这个图看代码辅助理解。

**详细题解：[东哥带你刷二叉树（构造篇）](https://labuladong.github.io/article/fname.html?fname=二叉树系列2)**

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
private:
    // 存储 inorder 中值到索引的映射
    unordered_map<int, int> valToIndex;

public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        for (int i = 0; i < inorder.size(); i++) {
            valToIndex[inorder[i]] = i;
        }
        return build(inorder, 0, inorder.size() - 1,
                     postorder, 0, postorder.size() - 1);
    }

    /*
       定义：
       中序遍历数组为 inorder[inStart..inEnd]，
       后序遍历数组为 postorder[postStart..postEnd]，
       构造这个二叉树并返回该二叉树的根节点
    */
    TreeNode* build(vector<int>& inorder, int inStart, int inEnd,
                    vector<int>& postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return nullptr;
        }
        // root 节点对应的值就是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex[rootVal];
        // 左子树的节点个数
        int leftSize = index - inStart;
        TreeNode* root = new TreeNode(rootVal);/**<extend up -200>![](https://labuladong.github.io/pictures/二叉树系列2/6.jpeg) */
        // 递归构造左右子树
        root->left = build(inorder, inStart, index - 1,
                            postorder, postStart, postStart + leftSize - 1);

        root->right = build(inorder, index + 1, inEnd,
                            postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def __init__(self):
        # 存储 inorder 中值到索引的映射
        self.valToIndex = {}

    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        for i in range(len(inorder)):
            self.valToIndex[inorder[i]] = i
        return self.build(inorder, 0, len(inorder) - 1,
                          postorder, 0, len(postorder) - 1)

    '''
    定义：
    中序遍历数组为 inorder[inStart..inEnd]，
    后序遍历数组为 postorder[postStart..postEnd]，
    构造这个二叉树并返回该二叉树的根节点
    '''
    def build(self, inorder: List[int], inStart: int, inEnd: int,
              postorder: List[int], postStart: int, postEnd: int) -> TreeNode:

        if inStart > inEnd:
            return None
        # root 节点对应的值就是后序遍历数组的最后一个元素
        rootVal = postorder[postEnd]
        # rootVal 在中序遍历数组中的索引
        index = self.valToIndex[rootVal]
        # 左子树的节点个数
        leftSize = index - inStart
        root = TreeNode(rootVal) # <extend up -200>![](https://labuladong.github.io/pictures/二叉树系列2/6.jpeg) #
        # 递归构造左右子树
        root.left = self.build(inorder, inStart, index - 1,
                               postorder, postStart, postStart + leftSize - 1)

        root.right = self.build(inorder, index + 1, inEnd,
                                postorder, postStart + leftSize, postEnd - 1)
        return root
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 存储 inorder 中值到索引的映射
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1,
                    postorder, 0, postorder.length - 1);
    }

    /*
       定义：
       中序遍历数组为 inorder[inStart..inEnd]，
       后序遍历数组为 postorder[postStart..postEnd]，
       构造这个二叉树并返回该二叉树的根节点
    */
    TreeNode build(int[] inorder, int inStart, int inEnd,
                int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }
        // root 节点对应的值就是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);
        // 左子树的节点个数
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);/**<extend up -200>![](https://labuladong.github.io/pictures/二叉树系列2/6.jpeg) */
        // 递归构造左右子树
        root.left = build(inorder, inStart, index - 1,
                         postorder, postStart, postStart + leftSize - 1);
        
        root.right = build(inorder, index + 1, inEnd,
                          postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func buildTree(inorder []int, postorder []int) *TreeNode {
    // 存储 inorder 中值到索引的映射
    valToIndex := make(map[int]int)
    for i, val := range inorder {
        valToIndex[val] = i
    }
    return build(inorder, 0, len(inorder)-1,
                 postorder, 0, len(postorder)-1, valToIndex)
}

/*
   定义：
   中序遍历数组为 inorder[inStart..inEnd]，
   后序遍历数组为 postorder[postStart..postEnd]，
   构造这个二叉树并返回该二叉树的根节点
*/
func build(inorder []int, inStart int, inEnd int,
           postorder []int, postStart int, postEnd int,
           valToIndex map[int]int) *TreeNode {
    if inStart > inEnd {
        return nil
    }
    // root 节点对应的值就是后序遍历数组的最后一个元素
    rootVal := postorder[postEnd]
    // rootVal 在中序遍历数组中的索引
    index := valToIndex[rootVal]
    // 左子树的节点个数
    leftSize := index - inStart
    root := &TreeNode{Val: rootVal}
    // 递归构造左右子树
    root.Left = build(inorder, inStart, index-1,
                      postorder, postStart, postStart+leftSize-1, valToIndex)
    root.Right = build(inorder, index+1, inEnd,
                       postorder, postStart+leftSize, postEnd-1, valToIndex)
    return root
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[]} inorder
 * @param {number[]} postorder
 * @return {TreeNode}
 */
var buildTree = function(inorder, postorder) {
    // 存储 inorder 中值到索引的映射
    const valToIndex = new Map();
    for (let i = 0; i < inorder.length; i++) {
        valToIndex.set(inorder[i], i);
    }
    return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, valToIndex);
};

/**
* 定义：
* 中序遍历数组为 inorder[inStart..inEnd]，
* 后序遍历数组为 postorder[postStart..postEnd]，
* 构造这个二叉树并返回该二叉树的根节点
*/
function build(inorder, inStart, inEnd, postorder, postStart, postEnd, valToIndex) {
    if (inStart > inEnd) {
        return null;
    }
    // root 节点对应的值就是后序遍历数组的最后一个元素
    const rootVal = postorder[postEnd];
    // rootVal 在中序遍历数组中的索引
    const index = valToIndex.get(rootVal);
    // 左子树的节点个数
    const leftSize = index - inStart;
    const root = new TreeNode(rootVal);/**<extend up -200>![](https://labuladong.github.io/pictures/二叉树系列2/6.jpeg) */
    // 递归构造左右子树
    root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1, valToIndex);
    root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1, valToIndex);
    return root;
}
```

</div></div>
</div></div>

**类似题目**：
  - [105. 从前序与中序遍历序列构造二叉树 🟠](/problems/construct-binary-tree-from-preorder-and-inorder-traversal)
  - [654. 最大二叉树 🟠](/problems/maximum-binary-tree)
  - [889. 根据前序和后序遍历构造二叉树 🟠](/problems/construct-binary-tree-from-preorder-and-postorder-traversal)
  - [剑指 Offer 07. 重建二叉树 🟠](/problems/zhong-jian-er-cha-shu-lcof/)

</details>
</div>



