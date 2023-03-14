English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>栈 | 树 | 二叉搜索树 | 递归 | 二叉树 | 单调栈</details><br>

<div>👍 678, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。[第 18 期每日打卡](https://aep.xet.tech/s/2PLO1n) 开始报名。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.github.io/article/fname.html?fname=二叉树总结) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「分解问题」的思维模式。

建议你先看一下 [东哥手把手带你刷二叉树（构造篇）](https://labuladong.github.io/article/fname.html?fname=二叉树系列2) 了解二叉树前中后序遍历结果的特点，再看一下 [手把手带你刷二叉搜索树（第二期）](https://labuladong.github.io/article/fname.html?fname=BST2) 了解 BST 的特性和基本操作方法，再来看这道题，解法就呼之欲出了。

后序遍历结果的特点是：左边一部分是左子树，右边一部分是右子树，最后一个元素是根节点。

![](https://labuladong.gitee.io/pictures/二叉树系列2/5.jpeg)

而 BST 的特点是左子树元素都小于根节点，右子树元素都大于根节点。

所以结合上述规律，就可以得到解决本题的思路：

1、先找到根节点元素

2、根据根节点元素找到左子树元素，递归检查左子树是否是 BST

3、根据根节点元素找到右子树元素，递归检查右子树是否是 BST

**标签：[二叉搜索树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121995456690946054)，[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)**

## 解法代码

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
// 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

class Solution {
public:
    bool verifyPostorder(vector<int>& postorder) {
        return check(postorder, 0, postorder.size() - 1);
    }

    // 定义：检查 postorder[i..j] 是否是一个合法的 BST
    bool check(vector<int>& postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        // 根节点的值是后序遍历结果的最后一个元素
        int root = postorder[j];

        // postorder[i..left) 是左子树，应该都小于 root
        int left = i;
        while (left < j && postorder[left] < root) {
            left++;
        }

        // postorder[left..j) 是右子树，应该都大于 root
        int right = left;
        while (right < j && postorder[right] > root) {
            right++;
        }
        if (right != j) {
            return false;
        }
        // 递归检查左子树 [i..left) 和右子树 [left..j) 也符合 BST 的性质
        return check(postorder, i, left - 1) && check(postorder, left, j - 1);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

class Solution:
    def verifyPostorder(self, postorder: List[int]) -> bool:
        return self.check(postorder, 0, len(postorder)-1)

    def check(self, postorder: List[int], i: int, j: int) -> bool:
        if i >= j:
            return True
        # 根节点的值是后序遍历结果的最后一个元素
        root = postorder[j]

        # postorder[i..left) 是左子树，应该都小于 root
        left = i
        while left < j and postorder[left] < root:
            left += 1

        # postorder[left..j) 是右子树，应该都大于 root
        right = left
        while right < j and postorder[right] > root:
            right += 1

        if right != j:
            return False

        # 递归检查左子树 [i..left) 和右子树 [left..j) 也符合 BST 的性质
        return self.check(postorder, i, left-1) and self.check(postorder, left, j-1)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return check(postorder, 0, postorder.length - 1);
    }

    // 定义：检查 postorder[i..j] 是否是一个合法的 BST
    boolean check(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        // 根节点的值是后序遍历结果的最后一个元素
        int root = postorder[j];/**<extend up -200>![](https://labuladong.gitee.io/pictures/二叉树系列2/5.jpeg) */

        // postorder[i..left) 是左子树，应该都小于 root
        int left = i;
        while (left < j && postorder[left] < root) {
            left++;
        }

        // postorder[left..j) 是右子树，应该都大于 root
        int right = left;
        while (right < j && postorder[right] > root) {
            right++;
        }
        if (right != j) {
            return false;
        }
        // 递归检查左子树 [i..left) 和右子树 [left..j) 也符合 BST 的性质
        return check(postorder, i, left - 1) && check(postorder, left, j - 1);
    }

}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

func verifyPostorder(postorder []int) bool {
    return check(postorder, 0, len(postorder) - 1)
}

// 定义：检查 postorder[i..j] 是否是一个合法的 BST
func check(postorder []int, i int, j int) bool {
    if i >= j {
        return true
    }
    // 根节点的值是后序遍历结果的最后一个元素
    root := postorder[j]/**<extend up -200>![](https://labuladong.gitee.io/pictures/二叉树系列2/5.jpeg) */

    // postorder[i..left) 是左子树，应该都小于 root
    left := i
    for left < j && postorder[left] < root {
        left++
    }

    // postorder[left..j) 是右子树，应该都大于 root
    right := left
    for right < j && postorder[right] > root {
        right++
    }
    if right != j {
        return false
    }
    // 递归检查左子树 [i..left) 和右子树 [left..j) 也符合 BST 的性质
    return check(postorder, i, left - 1) && check(postorder, left, j - 1)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

var verifyPostorder = function(postorder) {
    return check(postorder, 0, postorder.length - 1);
};

// 定义：检查 postorder[i..j] 是否是一个合法的 BST
function check(postorder, i, j) {
    if (i >= j) {
        return true;
    }
    // 根节点的值是后序遍历结果的最后一个元素
    let root = postorder[j];

    // postorder[i..left) 是左子树，应该都小于 root
    let left = i;
    while (left < j && postorder[left] < root) {
        left++;
    }

    // postorder[left..j) 是右子树，应该都大于 root
    let right = left;
    while (right < j && postorder[right] > root) {
        right++;
    }
    if (right != j) {
        return false;
    }
    // 递归检查左子树 [i..left) 和右子树 [left..j) 也符合 BST 的性质
    return check(postorder, i, left - 1) && check(postorder, left, j - 1);
}
```

</div></div>
</div></div>

</details>
</div>



