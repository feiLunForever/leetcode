<p>English description is not available for the problem. Please switch to Chinese.</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 分治 | 矩阵</details><br>

<div>👍 1006, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [240. 搜索二维矩阵 II](/problems/search-a-2d-matrix-ii) 相同。

作为 [74. 搜索二维矩阵](/problems/search-a-2d-matrix) 的进阶题目，这道题不算 [二分搜索算法](https://labuladong.github.io/article/fname.html?fname=二分查找详解)，更像 [一个方法秒杀所有 N 数之和问题](https://labuladong.github.io/article/fname.html?fname=nSum)，因为它们的思想上有些类似。

这道题说 `matrix` 从上到下递增，从左到右递增，显然左上角是最小元素，右下角是最大元素。**我们如果想高效在 `matrix` 中搜索一个元素，肯定需要从某个角开始**，比如说从左上角开始，然后每次只能向右或向下移动，不要走回头路。

如果真从左上角开始的话，就会发现无论向右还是向下走，元素大小都会增加，那么到底向右还是向下？不确定，那只好用类似 [动态规划算法](https://labuladong.github.io/article/fname.html?fname=动态规划详解进阶) 的思路穷举了。

但实际上不用这么麻烦，我们不要从左上角开始，而是从右上角开始，规定只能向左或向下移动。

你注意，如果向左移动，元素在减小，如果向下移动，元素在增大，这样的话我们就可以根据当前位置的元素和 `target` 的相对大小来判断应该往哪移动，不断接近从而找到 `target` 的位置。

当然，如果你想从左下角开始，规定只能向右或向上移动也可以，具体看代码吧。

**标签：[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size(), n = matrix[0].size();
        // 初始化在右上角
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                // 需要大一点，往下移动
                i++;
            } else {
                // 需要小一点，往左移动
                j--;
            }
        }
        // while 循环中没有找到，则 target 不存在
        return false;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        # 初始化在右上角
        i, j = 0, n - 1
        while i < m and j >= 0:
            if matrix[i][j] == target:
                return True
            if matrix[i][j] < target:
                # 需要大一点，往下移动
                i += 1
            else:
                # 需要小一点，往左移动
                j -= 1
        # while 循环中没有找到，则 target 不存在
        return False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 初始化在右上角
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                // 需要大一点，往下移动
                i++;
            } else {
                // 需要小一点，往左移动
                j--;
            }
        }
        // while 循环中没有找到，则 target 不存在
        return false;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

func searchMatrix(matrix [][]int, target int) bool {
    m, n := len(matrix), len(matrix[0])
    // 初始化在右上角
    i, j := 0, n-1
    for i < m && j >= 0 {
        if matrix[i][j] == target {
            return true
        }
        if matrix[i][j] < target {
            // 需要大一点，往下移动
            i++
        } else {
            // 需要小一点，往左移动
            j--
        }
    }
    // while 循环中没有找到，则 target 不存在
    return false
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

var searchMatrix = function(matrix, target) {
    const m = matrix.length;
    const n = matrix[0].length;
    // 初始化在右上角
    let i = 0;
    let j = n - 1;
    while (i < m && j >= 0) {
        if (matrix[i][j] === target) {
            return true;
        }
        if (matrix[i][j] < target) {
            // 需要大一点，往下移动
            i++;
        } else {
            // 需要小一点，往左移动
            j--;
        }
    }
    // while 循环中没有找到，则 target 不存在
    return false;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_search-a-2d-matrix-ii" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_search-a-2d-matrix-ii"></div></div>
</details><hr /><br />

**类似题目**：
  - [剑指 Offer 04. 二维数组中的查找 🟠](/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof)

</details>
</div>



