English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>树 | 广度优先搜索 | 二叉树</details><br>

<div>👍 293, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 最后一天报名！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [102. 二叉树的层序遍历](/problems/binary-tree-level-order-traversal) 相同。

前文 [BFS 算法框架](https://labuladong.github.io/article/fname.html?fname=BFS框架) 就是由二叉树的层序遍历演变出来的。

下面是层序遍历的一般写法，通过一个 while 循环控制从上向下一层层遍历，for 循环控制每一层从左向右遍历：

![](https://labuladong.github.io/pictures/dijkstra/1.jpeg)

**标签：[BFS 算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)，[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)**

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
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        if (root == nullptr) {
            return res;
        }

        queue<TreeNode*> q;
        q.push(root);
        // while 循环控制从上向下一层层遍历
        while (!q.empty()) {
            int sz = q.size();
            // 记录这一层的节点值
            vector<int> level;
            // for 循环控制每一层从左向右遍历
            for (int i = 0; i < sz; i++) {
                TreeNode* cur = q.front();
                q.pop();
                level.push_back(cur->val);
                if (cur->left != nullptr)
                    q.push(cur->left);
                if (cur->right != nullptr)
                    q.push(cur->right);
            }
            res.push_back(level);
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        if root is None:
            return res
        
        q = collections.deque()
        q.append(root)
        # while 循环控制从上向下一层层遍历
        while q:
            sz = len(q)
            # 记录这一层的节点值
            level = []
            # for 循环控制每一层从左向右遍历
            for i in range(sz):
                cur = q.popleft()
                level.append(cur.val)
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
            res.append(level)
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // while 循环控制从上向下一层层遍历
        while (!q.isEmpty()) {
            int sz = q.size();
            // 记录这一层的节点值
            List<Integer> level = new LinkedList<>();
            // for 循环控制每一层从左向右遍历
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                level.add(cur.val);
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            res.add(level);
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

func levelOrder(root *TreeNode) [][]int {
    res := [][]int{}
    if root == nil {
        return res
    }

    q := []*TreeNode{}
    q = append(q, root)
    // while 循环控制从上向下一层层遍历
    for len(q) > 0 {
        sz := len(q)
        // 记录这一层的节点值
        level := []int{}
        // for 循环控制每一层从左向右遍历
        for i := 0; i < sz; i++ {
            cur := q[0]
            q = q[1:]
            level = append(level, cur.Val)
            if cur.Left != nil {
                q = append(q, cur.Left)
            }
            if cur.Right != nil {
                q = append(q, cur.Right)
            }
        }
        res = append(res, level)
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

var levelOrder = function(root) {
    let res = [];
    if (!root) {
        return res;
    }

    let q = [];
    q.push(root);
    // while 循环控制从上向下一层层遍历
    while (q.length > 0) {
        let sz = q.length;
        // 记录这一层的节点值
        let level = [];
        // for 循环控制每一层从左向右遍历
        for (let i = 0; i < sz; i++) {
            let cur = q.shift();
            level.push(cur.val);
            if (cur.left !== null) {
                q.push(cur.left);
            }
            if (cur.right !== null) {
                q.push(cur.right);
            }
        }
        res.push(level);
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_binary-tree-level-order-traversal" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_binary-tree-level-order-traversal"></div></div>
</details><hr /><br />

**类似题目**：
  - [103. 二叉树的锯齿形层序遍历 🟠](/problems/binary-tree-zigzag-level-order-traversal)
  - [107. 二叉树的层序遍历 II 🟠](/problems/binary-tree-level-order-traversal-ii)
  - [1161. 最大层内元素和 🟠](/problems/maximum-level-sum-of-a-binary-tree)
  - [1302. 层数最深叶子节点的和 🟠](/problems/deepest-leaves-sum)
  - [1609. 奇偶树 🟠](/problems/even-odd-tree)
  - [637. 二叉树的层平均值 🟢](/problems/average-of-levels-in-binary-tree)
  - [919. 完全二叉树插入器 🟠](/problems/complete-binary-tree-inserter)
  - [958. 二叉树的完全性检验 🟠](/problems/check-completeness-of-a-binary-tree)
  - [剑指 Offer 32 - I. 从上到下打印二叉树 🟠](/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof)
  - [剑指 Offer 32 - II. 从上到下打印二叉树 II 🟢](/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof)
  - [剑指 Offer 32 - III. 从上到下打印二叉树 III 🟠](/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof)

</details>
</div>



