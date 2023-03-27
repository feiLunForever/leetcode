English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉搜索树 | 二叉树</details><br>

<div>👍 373, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。[第 18 期每日打卡](https://aep.xet.tech/s/2PLO1n) 最后一天报名。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题很像 [230. 二叉搜索树中第 K 小的元素](/problems/kth-smallest-element-in-a-bst)，只不过 230 题求第 `k` 小的值，这里求第 `k` 大的值。

你可以看下我在写的 230 题的思路，本题也可以利用 BST 的中序遍历计算第 `k` 大的元素。只不过常规的中序遍历得到的顺序是从小到大的，而我们想得到从大到小的顺序。

这也很简单，只要把中序遍历框架反过来，先递归遍历右子树，再递归遍历左子树，即可获得降序结果：

```java
void traverse(TreeNode root) {
    if (root == null) {
        return;
    }
    traverse(root.right);
    // 中序位置
    traverse(root.left);
}
```

所以只要把 230 题的解法稍加修改即可解决本题。

**标签：[二叉搜索树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121995456690946054)**

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
    int kthLargest(TreeNode* root, int k) {
        // 利用 BST 的中序遍历特性
        traverse(root, k);
        return res;
    }

    // 记录结果
    int res = 0;
    // 记录当前元素的排名
    int rank = 0;
    void traverse(TreeNode* root, int k) {
        if (root == nullptr) {
            return;
        }
        traverse(root->right, k);
        /* 中序遍历代码位置 */
        rank++;
        if (k == rank) {
            // 找到第 k 大的元素
            res = root->val;
            return;
        }
        /*****************/
        traverse(root->left, k);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution:
    def kthLargest(self, root: TreeNode, k: int) -> int:
        # 利用 BST 的中序遍历特性
        self.rank = 0
        self.traverse(root, k)
        return self.res
    
    # 记录结果
    res = 0
    # 记录当前元素的排名
    rank = 0
    
    def traverse(self, root: TreeNode, k: int) -> None:
        if not root:
            return
        
        self.traverse(root.right, k)
        """ 中序遍历代码位置 """
        self.rank += 1
        if self.rank == k:
            # 找到第 k 大的元素
            self.res = root.val
            return
        /*****************/
        self.traverse(root.left, k)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int kthLargest(TreeNode root, int k) {
        // 利用 BST 的中序遍历特性
        traverse(root, k);
        return res;
    }

    // 记录结果
    int res = 0;
    // 记录当前元素的排名
    int rank = 0;
    void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.right, k);
        /* 中序遍历代码位置 */
        rank++;
        if (k == rank) {
            // 找到第 k 大的元素
            res = root.val;
            return;
        }
        /*****************/
        traverse(root.left, k);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func kthLargest(root *TreeNode, k int) int {
    // 利用 BST 的中序遍历特性
    traverse := func(node *TreeNode, k int) {}
    res, rank := 0, 0

    traverse = func(node *TreeNode, k int) {
        if node == nil {
            return
        }
        traverse(node.Right, k)
        /* 中序遍历代码位置 */
        rank++
        if k == rank {
            // 找到第 k 大的元素
            res = node.Val
            return
        }
        /*****************/
        traverse(node.Left, k)
    }

    traverse(root, k)
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var kthLargest = function(root, k) {
    let res = 0, rank = 0;

    const traverse = function(root, k) {
        if (root === null) {
            return;
        }
        traverse(root.right, k);
        /* 中序遍历代码位置 */
        rank++;
        if (k === rank) {
            // 找到第 k 大的元素
            res = root.val;
            return;
        }
        /*****************/
        traverse(root.left, k);
    }

    traverse(root, k);
    return res;
};
```

</div></div>
</div></div>

</details>
</div>



