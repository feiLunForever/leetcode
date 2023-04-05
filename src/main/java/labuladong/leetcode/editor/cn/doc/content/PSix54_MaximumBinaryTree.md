<p>You are given an integer array <code>nums</code> with no duplicates. A <strong>maximum binary tree</strong> can be built recursively from <code>nums</code> using the following algorithm:</p>

<ol> 
 <li>Create a root node whose value is the maximum value in <code>nums</code>.</li> 
 <li>Recursively build the left subtree on the <strong>subarray prefix</strong> to the <strong>left</strong> of the maximum value.</li> 
 <li>Recursively build the right subtree on the <strong>subarray suffix</strong> to the <strong>right</strong> of the maximum value.</li> 
</ol>

<p>Return <em>the <strong>maximum binary tree</strong> built from </em><code>nums</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/tree1.jpg" style="width: 302px; height: 421px;" /> 
<pre>
<strong>Input:</strong> nums = [3,2,1,6,0,5]
<strong>Output:</strong> [6,3,5,null,2,0,null,null,1]
<strong>Explanation:</strong> The recursive calls are as follow:
- The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5].
    - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1].
        - Empty array, so no child.
        - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
            - Empty array, so no child.
            - Only one element, so child is a node with value 1.
    - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
        - Only one element, so child is a node with value 0.
        - Empty array, so no child.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/tree2.jpg" style="width: 182px; height: 301px;" /> 
<pre>
<strong>Input:</strong> nums = [3,2,1]
<strong>Output:</strong> [3,null,2,null,1]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 1000</code></li> 
 <li><code>0 &lt;= nums[i] &lt;= 1000</code></li> 
 <li>All integers in <code>nums</code> are <strong>unique</strong>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>栈 | 树 | 数组 | 分治 | 二叉树 | 单调栈</details><br>

<div>👍 661, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=maximum-binary-tree" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.github.io/article/fname.html?fname=二叉树总结) 说过二叉树的递归算法可以分两类，一类是遍历二叉树的类型，一类是分解子问题的类型。

前者较简单，只要运用二叉树的递归遍历框架即可；后者的关键在于明确递归函数的定义，然后利用这个定义。

这题是后者，函数 `build` 的定义是根据输入的数组构造最大二叉树，那么只要我先要找到根节点，然后让 `build` 函数递归生成左右子树即可。

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
public:
    /* 主函数 */
    TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
        return build(nums, 0, nums.size() - 1);
    }

    /* 定义：将 nums[lo..hi] 构造成符合条件的树，返回根节点 */
    TreeNode* build(vector<int>& nums, int lo, int hi) {
        /* base case */
        if (lo > hi) {
            return nullptr;
        }

        /* 找到数组中的最大值和对应的索引 */
        int index = -1, maxVal = INT_MIN;
        for (int i = lo; i <= hi; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }

        TreeNode* root = new TreeNode(maxVal);
        /* 递归调用构造左右子树 */
        root->left = build(nums, lo, index - 1);
        root->right = build(nums, index + 1, hi);

        return root;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> TreeNode:
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        def build(nums, lo, hi):
            # base case
            if lo > hi:
                return None

            # 找到数组中的最大值和对应的索引
            index, maxVal = lo, nums[lo]
            for i in range(lo, hi+1):
                if nums[i] > maxVal:
                    index, maxVal = i, nums[i]

            # 创建根节点
            root = TreeNode(maxVal)
            # 递归构建左右子树
            root.left = build(nums, lo, index - 1)
            root.right = build(nums, index + 1, hi)

            return root

        # 调用 build 函数
        return build(nums, 0, len(nums)-1)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    /* 主函数 */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    /* 定义：将 nums[lo..hi] 构造成符合条件的树，返回根节点 */
    TreeNode build(int[] nums, int lo, int hi) {
        // base case
        if (lo > hi) {
            return null;
        }

        // 找到数组中的最大值和对应的索引
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxVal);
        // 递归调用构造左右子树
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);

        return root;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func constructMaximumBinaryTree(nums []int) *TreeNode {
    return build(nums, 0, len(nums)-1)
}

func build(nums []int, lo int, hi int) *TreeNode {
    // base case
    if lo > hi {
        return nil
    }

    // 找到数组中的最大值和对应的索引
    index, maxVal := -1, math.MinInt32
    for i := lo; i <= hi; i++ {
        if maxVal < nums[i] {
            index = i
            maxVal = nums[i]
        }
    }

    root := &TreeNode{Val: maxVal}
    // 递归调用构造左右子树
    root.Left = build(nums, lo, index-1)
    root.Right = build(nums, index+1, hi)

    return root
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
var constructMaximumBinaryTree = function(nums) {
  return build(nums, 0, nums.length - 1);
}

/**
 * Define: 将 nums[lo..hi] 构造成符合条件的树，返回根节点 
 */
var build = function(nums, lo, hi) {
  // base case
  if (lo > hi) {
    return null;
  }

  // 找到数组中的最大值和对应的索引
  var index = -1, maxVal = -Infinity;
  for (var i = lo; i <= hi; i++) {
    if (maxVal < nums[i]) {
      index = i;
      maxVal = nums[i];
    }
  }

  var root = new TreeNode(maxVal);
  // 递归调用构造左右子树
  root.left = build(nums, lo, index - 1);
  root.right = build(nums, index + 1, hi);

  return root;
}
```

</div></div>
</div></div>

**类似题目**：
  - [105. 从前序与中序遍历序列构造二叉树 🟠](/problems/construct-binary-tree-from-preorder-and-inorder-traversal)
  - [106. 从中序与后序遍历序列构造二叉树 🟠](/problems/construct-binary-tree-from-inorder-and-postorder-traversal)
  - [889. 根据前序和后序遍历构造二叉树 🟠](/problems/construct-binary-tree-from-preorder-and-postorder-traversal)
  - [998. 最大二叉树 II 🟠](/problems/maximum-binary-tree-ii)
  - [剑指 Offer 07. 重建二叉树 🟠](/problems/zhong-jian-er-cha-shu-lcof/)

</details>
</div>



