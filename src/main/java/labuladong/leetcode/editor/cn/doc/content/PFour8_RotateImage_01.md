<p>You are given an <code>n x n</code> 2D <code>matrix</code> representing an image, rotate the image by <strong>90</strong> degrees (clockwise).</p>

<p>You have to rotate the image <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a>, which means you have to modify the input 2D matrix directly. <strong>DO NOT</strong> allocate another 2D matrix and do the rotation.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat1.jpg" style="width: 500px; height: 188px;" /> 
<pre>
<strong>Input:</strong> matrix = [[1,2,3],[4,5,6],[7,8,9]]
<strong>Output:</strong> [[7,4,1],[8,5,2],[9,6,3]]
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat2.jpg" style="width: 500px; height: 201px;" /> 
<pre>
<strong>Input:</strong> matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
<strong>Output:</strong> [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>n == matrix.length == matrix[i].length</code></li> 
 <li><code>1 &lt;= n &lt;= 20</code></li> 
 <li><code>-1000 &lt;= matrix[i][j] &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 数学 | 矩阵</details><br>

<div>👍 1729, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=rotate-image" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题看起来复杂，但只要掌握了规律就很简单。

先把二维矩阵沿对角线反转，然后反转矩阵的每一行，结果就是顺时针反转整个矩阵。

**详细题解：[二维数组的花式遍历技巧](https://labuladong.github.io/article/fname.html?fname=花式遍历)**

**标签：[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        // 先沿对角线反转二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // swap(matrix[i][j], matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (auto& row : matrix) {
            ::reverse(row.begin(), row.end());
        }
    }

    // 反转一维数组
    void reverse(vector<int>& arr) {
        int i = 0, j = arr.size() - 1;
        while (j > i) {
            // swap(arr[i], arr[j]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        # 先沿对角线反转二维矩阵
        for i in range(n):
            for j in range(i, n):
                # swap(matrix[i][j], matrix[j][i]);
                temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
        # 然后反转二维矩阵的每一行
        for row in matrix:
            self.reverse(row)
    
    # 反转一维数组
    def reverse(self, arr: List[int]) -> None:
        i, j = 0, len(arr) - 1
        while j > i:
            # swap(arr[i], arr[j]);
            temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
            i += 1
            j -= 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先沿对角线反转二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // swap(matrix[i][j], matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    // 反转一维数组
    void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (j > i) {
            // swap(arr[i], arr[j]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func rotate(matrix [][]int) {
    n := len(matrix)
    // 先沿对角线反转二维矩阵
    for i := 0; i < n; i++ {
        for j := i; j < n; j++ {
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        }
    }
    // 然后反转二维矩阵的每一行
    for _, row := range matrix {
        reverse(row)
    }
}

// 反转一维数组
func reverse(arr []int) {
    i, j := 0, len(arr) - 1
    for j > i {
        arr[i], arr[j] = arr[j], arr[i]
        i++
        j--
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function(matrix) {
    var n = matrix.length;
    // 先沿对角线反转二维矩阵
    for (var i = 0; i < n; i++) {
        for (var j = i; j < n; j++) {
            // swap(matrix[i][j], matrix[j][i]);
            var temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    // 然后反转二维矩阵的每一行
    for (var row of matrix) {
        reverse(row);
    }
}

// 反转一维数组
function reverse(arr) {
    var i = 0, j = arr.length - 1;
    while (j > i) {
        // swap(arr[i], arr[j]);
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
    }
}
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_rotate-image" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_rotate-image"></div></div>
</details><hr /><br />

**类似题目**：
  - [151. 反转字符串中的单词 🟠](/problems/reverse-words-in-a-string)
  - [54. 螺旋矩阵 🟠](/problems/spiral-matrix)
  - [59. 螺旋矩阵 II 🟠](/problems/spiral-matrix-ii)
  - [剑指 Offer 29. 顺时针打印矩阵 🟢](/problems/shun-shi-zhen-da-yin-ju-zhen-lcof)
  - [剑指 Offer 58 - I. 翻转单词顺序 🟢](/problems/fan-zhuan-dan-ci-shun-xu-lcof)

</details>
</div>



