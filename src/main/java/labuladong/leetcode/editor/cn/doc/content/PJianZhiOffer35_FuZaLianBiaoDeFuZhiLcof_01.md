English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>哈希表 | 链表</details><br>

<div>👍 773, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [138. 复制带随机指针的链表](/problems/copy-list-with-random-pointer) 相同。

最简单的方式，就是借助哈希表把原始节点和克隆节点的映射存储起来，然后把克隆节点的结构连接起来即可。

另外，你可以认为这道题和 [133. 克隆图](/problems/clone-graph) 是一模一样的，因为链表加一个随机指针本质上就变成了一幅图。你可以去看下我在 133 题写的思路，我直接把 133 题的解法代码稍作修改复制过来即可解决这道题。

**标签：哈希表，[链表](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
    Node* copyRandomList(Node* head) {
        unordered_map<Node*, Node*> originToClone;
        // 第一次遍历，先把所有节点克隆出来
        for (Node* p = head; p != nullptr; p = p->next) {
            if (originToClone.find(p) == originToClone.end()) {
                originToClone[p] = new Node(p->val);
            }
        }
        // 第二次遍历，把克隆节点的结构连接好
        for (Node* p = head; p != nullptr; p = p->next) {
            if (p->next != nullptr) {
                originToClone[p]->next = originToClone[p->next];
            }
            if (p->random != nullptr) {
                originToClone[p]->random = originToClone[p->random];
            }
        }
        // 返回克隆之后的头结点
        return originToClone[head];
    }
};

// 用递归的方式进行遍历
class Solution2 {
public:
    Node* copyRandomList(Node* head) {
        traverse(head);
        return originToClone[head];
    }

private:
    // 记录 DFS 遍历过的节点，防止走回头路
    unordered_set<Node*> visited;
    // 记录原节点到克隆节点的映射
    unordered_map<Node*, Node*> originToClone;

    // DFS 图遍历框架
    void traverse(Node* node) {
        if (node == nullptr) {
            return;
        }
        if (visited.find(node) != visited.end()) {
            return;
        }
        // 前序位置，标记为已访问
        visited.insert(node);
        // 前序位置，克隆节点
        if (originToClone.find(node) == originToClone.end()) {
            originToClone[node] = new Node(node->val);
        }
        Node* cloneNode = originToClone[node];

        // 递归遍历邻居节点，并构建克隆图
        // 递归之后，邻居节点一定存在 originToClone 中

        traverse(node->next);
        cloneNode->next = originToClone[node->next];

        traverse(node->random);
        cloneNode->random = originToClone[node->random];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        originToClone = {}
        # 第一次遍历，先把所有节点克隆出来
        for p in [head]:
            while p:
                if p not in originToClone:
                    originToClone[p] = Node(p.val)
                p = p.next
        # 第二次遍历，把克隆节点的结构连接好
        for p in [head]:
            while p:
                if p.next:
                    originToClone[p].next = originToClone[p.next]
                if p.random:
                    originToClone[p].random = originToClone[p.random]
                p = p.next
        # 返回克隆之后的头结点
        return originToClone.get(head)

class Solution2:
    def copyRandomList(self, head: 'Node') -> 'Node':
        self.visited = set()
        self.originToClone = {}
        self.traverse(head)
        return self.originToClone.get(head)

    # DFS 图遍历框架
    def traverse(self, node):
        if not node:
            return
        if node in self.visited:
            return
        # 前序位置，标记为已访问
        self.visited.add(node)
        # 前序位置，克隆节点
        if node not in self.originToClone:
            self.originToClone[node] = Node(node.val)
        cloneNode = self.originToClone[node]

        # 递归遍历邻居节点，并构建克隆图
        # 递归之后，邻居节点一定存在 originToClone 中

        self.traverse(node.next)
        cloneNode.next = self.originToClone.get(node.next)

        self.traverse(node.random)
        cloneNode.random = self.originToClone.get(node.random)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> originToClone = new HashMap<>();
        // 第一次遍历，先把所有节点克隆出来
        for (Node p = head; p != null; p = p.next) {
            if (!originToClone.containsKey(p)) {
                originToClone.put(p, new Node(p.val));
            }
        }
        // 第二次遍历，把克隆节点的结构连接好
        for (Node p = head; p != null; p = p.next) {
            if (p.next != null) {
                originToClone.get(p).next = originToClone.get(p.next);
            }
            if (p.random != null) {
                originToClone.get(p).random = originToClone.get(p.random);
            }
        }
        // 返回克隆之后的头结点
        return originToClone.get(head);
    }
}

// 用递归的方式进行遍历
class Solution2 {
    public Node copyRandomList(Node head) {
        traverse(head);
        return originToClone.get(head);
    }

    // 记录 DFS 遍历过的节点，防止走回头路
    HashSet<Node> visited = new HashSet<>();
    // 记录原节点到克隆节点的映射
    HashMap<Node, Node> originToClone = new HashMap<>();

    // DFS 图遍历框架
    void traverse(Node node) {
        if (node == null) {
            return;
        }
        if (visited.contains(node)) {
            return;
        }
        // 前序位置，标记为已访问
        visited.add(node);
        // 前序位置，克隆节点
        if (!originToClone.containsKey(node)) {
            originToClone.put(node, new Node(node.val));
        }
        Node cloneNode = originToClone.get(node);

        // 递归遍历邻居节点，并构建克隆图
        // 递归之后，邻居节点一定存在 originToClone 中

        traverse(node.next);
        cloneNode.next = originToClone.get(node.next);

        traverse(node.random);
        cloneNode.random = originToClone.get(node.random);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Next *Node
 *	   Random *Node
 * }
 */

func copyRandomList(head *Node) *Node {
    originToClone := make(map[*Node]*Node)
    // 第一次遍历，先把所有节点克隆出来
    for p := head; p != nil; p = p.Next {
        if _, ok := originToClone[p]; !ok {
            originToClone[p] = &Node{Val:p.Val}
        }
    }
    // 第二次遍历，把克隆节点的结构连接好
    for p := head; p != nil; p = p.Next {
        if p.Next != nil {
            originToClone[p].Next = originToClone[p.Next]
        }
        if p.Random != nil {
            originToClone[p].Random = originToClone[p.Random]
        }
    }
    // 返回克隆之后的头结点
    return originToClone[head]
}

// 用递归的方式进行遍历
func copyRandomList2(head *Node) *Node {
    if head == nil {
        return nil
    }
    visited := make(map[*Node]bool)
    originToClone := make(map[*Node]*Node)
    traverse(head, visited, originToClone)
    return originToClone[head]
}

// DFS 图遍历框架
func traverse(node *Node, visited map[*Node]bool, originToClone map[*Node]*Node) {
    if visited[node] {
        return
    }
    // 前序位置，标记为已访问
    visited[node] = true
    // 前序位置，克隆节点
    if _, ok := originToClone[node]; !ok {
        originToClone[node] = &Node{Val:node.Val}
    }
    cloneNode := originToClone[node]

    // 递归遍历邻居节点，并构建克隆图
    // 递归之后，邻居节点一定存在 originToClone 中
    if node.Next != nil {
        traverse(node.Next, visited, originToClone)
        cloneNode.Next = originToClone[node.Next]
    }
    if node.Random != nil {
        traverse(node.Random, visited, originToClone)
        cloneNode.Random = originToClone[node.Random]
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var copyRandomList = function(head) {
    const originToClone = new Map();

    // 第一次遍历，先把所有节点克隆出来
    for (let p = head; p != null; p = p.next) {
        if (!originToClone.has(p)) {
            originToClone.set(p, new Node(p.val));
        }
    }

    // 第二次遍历，把克隆节点的结构连接好
    for (let p = head; p != null; p = p.next) {
        if (p.next != null) {
            originToClone.get(p).next = originToClone.get(p.next);
        }
        if (p.random != null) {
            originToClone.get(p).random = originToClone.get(p.random);
        }
    }

    // 返回克隆之后的头结点
    return originToClone.get(head);
};

// 用递归的方式进行遍历
var copyRandomList2 = function(head) {
    const visited = new Set();
    const originToClone = new Map();

    // DFS 图遍历框架
    const traverse = (node) => {
        if (node == null) {
            return;
        }
        if (visited.has(node)) {
            return;
        }

        // 前序位置，标记为已访问
        visited.add(node);

        // 前序位置，克隆节点
        if (!originToClone.has(node)) {
            originToClone.set(node, new Node(node.val));
        }

        const cloneNode = originToClone.get(node);

        // 递归遍历邻居节点，并构建克隆图
        // 递归之后，邻居节点一定存在 originToClone 中

        traverse(node.next);
        cloneNode.next = originToClone.get(node.next);

        traverse(node.random);
        cloneNode.random = originToClone.get(node.random);
    };

    traverse(head);
    return originToClone.get(head);
};
```

</div></div>
</div></div>

**类似题目**：
  - [剑指 Offer 35. 复杂链表的复制 🟠](/problems/fu-za-lian-biao-de-fu-zhi-lcof)

</details>
</div>



