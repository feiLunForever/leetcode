English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>树 | 广度优先搜索 | 二叉树</details><br>

<div>👍 305, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 最后一天报名！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [103. 二叉树的锯齿形层序遍历](/problems/binary-tree-zigzag-level-order-traversal) 相同。

这题和 [102. 二叉树的层序遍历](/problems/binary-tree-level-order-traversal) 几乎是一样的，只要用一个布尔变量 `flag` 控制遍历方向即可。

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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> res;
        if (root == nullptr) {
            return res;
        }

        queue<TreeNode*> q;
        q.push(root);
        // 为 true 时向右，false 时向左
        bool flag = true;

        // while 循环控制从上向下一层层遍历
        while (!q.empty()) {
            int sz = q.size();
            // 记录这一层的节点值
            deque<int> level;
            // for 循环控制每一层从左向右遍历
            for (int i = 0; i < sz; i++) {
                TreeNode* cur = q.front();
                q.pop();
                // 实现 z 字形遍历
                if (flag) {
                    level.push_back(cur->val);
                } else {
                    level.push_front(cur->val);
                }
                if (cur->left != nullptr)
                    q.push(cur->left);
                if (cur->right != nullptr)
                    q.push(cur->right);
            }
            // 切换方向
            flag = !flag;
            res.emplace_back(vector<int>(level.begin(), level.end()));
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
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        if root is None:
            return res
        
        q = deque([root])
        # 为 True 时向右，False 时向左
        flag = True
        
        # while 循环控制从上向下一层层遍历
        while q:
            sz = len(q)
            # 记录这一层的节点值
            level = deque()
            # for 循环控制每一层从左向右遍历
            for i in range(sz):
                cur = q.popleft()
                # 实现 z 字形遍历
                if flag:
                    level.append(cur.val)
                else:
                    level.appendleft(cur.val)
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
            # 切换方向
            flag = not flag
            res.append(list(level))
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // 为 true 时向右，false 时向左
        boolean flag = true;

        // while 循环控制从上向下一层层遍历
        while (!q.isEmpty()) {
            int sz = q.size();
            // 记录这一层的节点值
            LinkedList<Integer> level = new LinkedList<>();
            // for 循环控制每一层从左向右遍历
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 实现 z 字形遍历
                if (flag) {
                    level.addLast(cur.val);
                } else {
                    level.addFirst(cur.val);
                }
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            // 切换方向
            flag = !flag;
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

func zigzagLevelOrder(root *TreeNode) [][]int {
    res := [][]int{}
    if root == nil {
        return res
    }

    q := []*TreeNode{root}
    // 为 true 时向右，false 时向左
    flag := true

    // while 循环控制从上向下一层层遍历
    for len(q) > 0 {
        sz := len(q)
        // 记录这一层的节点值
        level := []int{}
        // for 循环控制每一层从左向右遍历
        for i := 0; i < sz; i++ {
            cur := q[0]
            q = q[1:]
            // 实现 z 字形遍历
            if flag {
                level = append(level, cur.Val)
            } else {
                level = append([]int{cur.Val}, level...)
            }
            if cur.Left != nil {
                q = append(q, cur.Left)
            }
            if cur.Right != nil {
                q = append(q, cur.Right)
            }
        }
        // 切换方向
        flag = !flag
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

var zigzagLevelOrder = function(root) {
    let res = [];
    if (root === null) {
        return res;
    }

    let q = [];
    q.push(root);
    // 为 true 时向右，false 时向左
    let flag = true;

    // while 循环控制从上向下一层层遍历
    while (q.length !== 0) {
        let sz = q.length;
        // 记录这一层的节点值
        let level = [];
        // for 循环控制每一层从左向右遍历
        for (let i = 0; i < sz; i++) {
            let cur = q.shift();
            // 实现 z 字形遍历
            if (flag) {
                level.push(cur.val);
            } else {
                level.unshift(cur.val);
            }
            if (cur.left !== null)
                q.push(cur.left);
            if (cur.right !== null)
                q.push(cur.right);
        }
        // 切换方向
        flag = !flag;
        res.push(level);
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_binary-tree-zigzag-level-order-traversal" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_binary-tree-zigzag-level-order-traversal"></div></div>
</details><hr /><br />

**类似题目**：
  - [1609. 奇偶树 🟠](/problems/even-odd-tree)
  - [剑指 Offer 32 - III. 从上到下打印二叉树 III 🟠](/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof)

</details>
</div>



