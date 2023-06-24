<p>You are given an <code>m x n</code> binary matrix <code>grid</code>, where <code>0</code> represents a sea cell and <code>1</code> represents a land cell.</p>

<p>A <strong>move</strong> consists of walking from one land cell to another adjacent (<strong>4-directionally</strong>) land cell or walking off the boundary of the <code>grid</code>.</p>

<p>Return <em>the number of land cells in</em> <code>grid</code> <em>for which we cannot walk off the boundary of the grid in any number of <strong>moves</strong></em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/enclaves1.jpg" style="width: 333px; height: 333px;" /> 
<pre>
<strong>Input:</strong> grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
<strong>Output:</strong> 3
<strong>Explanation:</strong> There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/enclaves2.jpg" style="width: 333px; height: 333px;" /> 
<pre>
<strong>Input:</strong> grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
<strong>Output:</strong> 0
<strong>Explanation:</strong> All 1s are either on the boundary or can reach the boundary.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>m == grid.length</code></li> 
 <li><code>n == grid[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 500</code></li> 
 <li><code>grid[i][j]</code> is either <code>0</code> or <code>1</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵</details><br>

<div>👍 217, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=number-of-enclaves" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题属于岛屿系列问题，岛屿系列问题的基本思路框架是 [200. 岛屿数量](/problems/number-of-islands) 这道题，没看过的先看这篇。

这道题和 [1254. 统计封闭岛屿的数目](/problems/number-of-closed-islands) 基本一样，只是后者让你算封闭岛屿的数量，这题让你算这些封闭岛屿的陆地总数，稍微改改代码就行了。

注意这题中 `1` 代表陆地，`0` 代表海水。

**详细题解：[一文秒杀所有岛屿题目](https://labuladong.github.io/article/fname.html?fname=岛屿题目)**

**标签：[DFS 算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)，二维矩阵**

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
    int numEnclaves(vector<vector<int>>& grid) {

        int m = grid.size(), n = grid[0].size();
        
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += 1;
                }
            }
        }
        return res;
    }

    void dfs(vector<vector<int>>& grid, int i, int j) {
        int m = grid.size(), n = grid[0].size();
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;

        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        for i in range(m):
            self.dfs(grid, i, 0)
            self.dfs(grid, i, n - 1)

        for j in range(n):
            self.dfs(grid, 0, j)
            self.dfs(grid, m - 1, j)

        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    res += 1
        return res

    def dfs(self, grid: List[List[int]], i: int, j: int) -> None:
        m, n = len(grid), len(grid[0])
        if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] == 0:
            return

        grid[i][j] = 0

        self.dfs(grid, i + 1, j)
        self.dfs(grid, i, j + 1)
        self.dfs(grid, i - 1, j)
        self.dfs(grid, i, j - 1)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += 1;
                }
            }
        }
        return res;
    }

    void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;

        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// LeetCode 题目链接 https://leetcode-cn.com/problems/number-of-enclaves/
func numEnclaves(grid [][]int) int {
    m, n := len(grid), len(grid[0])

    for i := 0; i < m; i++ {
        dfs(grid, i, 0)
        dfs(grid, i, n-1)
    }

    for j := 0; j < n; j++ {
        dfs(grid, 0, j)
        dfs(grid, m-1, j)
    }

    var res int
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if grid[i][j] == 1 {
                res += 1
            }
        }
    }
    return res
}

func dfs(grid [][]int, i, j int) {
    m, n := len(grid), len(grid[0])
    if i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 {
        return
    }

    grid[i][j] = 0

    dfs(grid, i+1, j)
    dfs(grid, i, j+1)
    dfs(grid, i-1, j)
    dfs(grid, i, j-1)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[][]} grid
 * @return {number}
 */
var numEnclaves = function(grid) {
    var m = grid.length, n = grid[0].length;

    for (var i = 0; i < m; i++) {
        dfs(grid, i, 0);
        dfs(grid, i, n - 1);
    }

    for (var j = 0; j < n; j++) {
        dfs(grid, 0, j);
        dfs(grid, m - 1, j);
    }

    var res = 0;
    for (var row = 0; row < m; row++) {
        for (var col = 0; col < n; col++) {
            if (grid[row][col] === 1) {
                res += 1;
            }
        }
    }
    return res;
};

function dfs(grid, i, j) {
    var m = grid.length, n = grid[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] === 0) {
        return;
    }

    grid[i][j] = 0;

    dfs(grid, i + 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i - 1, j);
    dfs(grid, i, j - 1);
}
```

</div></div>
</div></div>

<details open><summary><strong>👉 算法可视化 👈</strong></summary><div class="resizable aspect-ratio-container" style="height: 70vh;">
    <iframe src="https://labuladong.github.io/algo-visualize/" width="100%"
    height="100%" scrolling="auto" frameborder="0"
    style="overflow: auto;" id="iframe_number-of-enclaves"></iframe>
</div>
<div id="data_number-of-enclaves" data="W2ltMTIQbBwQKPBkZCDYOFAgsJeNolRyngGoxYHdvOMDOICboAo9br3MzI/ZUbYQ8bhM/JqsAbGOUa43S2dVu3OVQTFUIW5dpdMpBJpYF/xnWMlEqZoA93VqU67LbGDT3tng8G7i74onQAI1e50N0wwhV6j4eKcNTJoTLUBpld+bJTPvf62VZydnOiztMbqAPCA7MwvPhRWBI9KZ7entAJEi1tEy2v2a+73Y2yoyFaERnr5hOJkyG9qCqm2iJN2oagTZ29mfUoqjVIkk/47WJSoPFQvCwtPXDSjNTim8mXDnSw8x9ETCNRnLyqCoXXf/A8Ij+LbUxqNqGIsSTJZLJVemP/s97vNu4u3yrsNjmBKB8ruMhIHrtpB3yRFaSk319YX8c4pZyvJ3rC7aPJ13/8Ti1JMi9nXKzV6tIvf77M1zK+jnZV6kYlOXyU/BmHb/QWwGUy8dhgP/fZyMWsoP4cqIWjjTgu+Hrf121Pt6rKrCf/GmmYzVsFibXprZsYqpa3vb3K2uFT+z0Gra+z5qWsn2C1N8ZciAT3n8S/Vg2Fyvh+jpOcTISxkLm5499GZP/VIeUBLCccPnxtzJR5xcfFGkz/KShBK5NyyIkcR4Lr5Nlyevz4sGeYl5z93rKn2W827Lk0cLpulZlmQCpWddPi6/C+fP1ajXSJlBKJU+wfdM4iJdyrSe4Z/o6dyJlRlTZ1WdQz/ifshCZ0e+8UMtXJ3ca0lqMFGGcJYPkFfzkwIjwfOFUSGW6GuUVnpXMAfxXXMz/UpzlOTY+mu28zzdX0T0euGwkS4S/rXl8KY90nJC7sYocqW1sykx1UdTahqMS6QRXwtfFz4dQRfQclzWQx0cBdm/XISPDIRQKgIZCKNUDDm0Fx8x6NGcki+wLgHmKDriLQb1iSy/dCVifXQsDF+7+zX6tOi5NfZRnw69K2Tmsi7n0hl+hyeMn2MFQOQWnyQcJZ1iSk6EzgNwxgamXCuo7R/ZntH0ovQAwv2Gez+99oxnfPOo+nnvhXzzFh9i1GlidSVXgNQqcdhNDbBuWMIVIJFbK+BhWN3IFRC1Jty3VxGwbljCFRCRWyvgYVjdkStg1Oqt5IqfQWNYwhUwItfwMNr9UJ7zV+VHO7PJ0WJOP+QHTas5t2A8OL+i5hsaBd/MBKKHPfBTxv9BrHtsUWG5Azqj4BuBe4TsRZNsPCaG72FgTOy/qO2XGtp+ak9FjPQwG1L30tNmP8EXoeoknxfHIKJpIEksLeuQmKCsUk25K8BlP9GKPQDmQHRWJh+nJ6wXXf6z9kSZfQktaBWV1/ZH1X37A2otIqN52U8O8yi0UqSiHDIkH6xK5AqIyFWQNY9Ca0KjCCD5YFVGroAR0colACY9/s81T1JeWK6ybNX7BArb13QgrjqdLY3kCpDI3TeAnfYVeFs6R2L7Z9CC6wWugB47SE5xE9ZtoSeLnFv45HZ10H/oI9Md/igsd44TiQBLA7kCIHJncWlcotBetYlGC1wB0I8+3qnpJgJszbOvw9o/j/3QeOrvUIC2t5IRwwrvM5w3FfaPuwIgch+mAQyCbWFWfH5kYwMcet/xwlev/omWMpXOZogVt4ONB/DKzv1EQs1EZDQ/kzH/PWzfnDgTQ6N5rYD/nuswkVTNxKjw1UvENSf2XxjNawX89wIgEkm1+wF5Whrd9WV99vHbiUg/ci8eLzeinXXXl/uzb7Gmn87jVKs1tzjzGI5SL3LXjzhvU+/ueV85x8Z0qPqpBCaqmFvqeuqMZN9datnK+z1JejKpWRAlpTeE7RqjQq4+M0K+AZAL4Inoa4xq2alceaVqOaq8UbU8qryjdjsNocUaHID1MWAixo9bttf1rWbVWVk/I4HcVGYkkAMjgRwYBbY3aia954TASCDXMBLIgZFADowC2ztqZnrr42AkkGsYCeTASCAHRkG7H454KlQJqV0yY9HDyhcg4iWT12gphFtxU1dxWg5qCsJHk4lwLNB34f0FH6MAHHmFH32H0ce/nBAH6U/IHcgnrt9PKLMpqLU5DbVbeKv7VwSbOd81KLbfEC8PZipA6VCsFL3iqlCXBwrMTr8kBwuHfi2m7qfl5mjS3vl9oi6RAaS017vcvqfh6uJYoq4psZ1y06aHds51OaE1RLp6mFQqO3t1mghOcTFSq3PVIVR0yVzqZQxBlVm6UlnHwwr8EVsNB9Wo4eUBZQ16VKGZnJQKmkddyBepIbVQamkblGrugqmY1nKqemuCgtNcUV3V5RXE6Fasck+qdjBSzbCjUJJC2yqeg6BeRy3HmS6HlQrbtK253U7MQ1Nz664msovqhty2ynGDVc8JY1rsd7JpGvv0QdUUnaPqYIWtbDeKOCjp+kj1N5xOqTbmUg1BJNXOKk1tu3EqWSvvlvZYPZSn3oh9FPf56yQTGjU6p6UWbkOqs+CmBkFu6mLauSW1QA+TKqynVG0b0OpSmk5hdMEpRI6kgtoH1b+7RxZCkzWlmVkJYfXKbJ2k/GDd6ihyqTX90MqPGhAkmKektBZdbYG7qQNbmNZRQXqodlp3LW/SmTgr6iNHVUIpo1aXu2aeixVRXMr3oXrQbeIycJfJrXZHU6dMpoJeQR22w9QyHCvClMLkrLrQONw39FTdROWH69ivJemtrFpdqtHcKLPsveoR0lHHk5tqaalRiTZ6qmhFjwrN0Kzsaj2rN5rg2F7LqZhxaYU+bFS0rpyfL+Px6nOG3khAcwzUGDD2+iJrzaF5QNzmMML5tf49XaYwbnwbvm2fdlPoM8+Yw3V8/UFn6ifFn7hlOFL8+slhT/MUgObt6uGgx61f8eOQMVphS8KbjEnqJHWrtFdIBG9gimqTJrcIti/5jdPnI7n1RuTkDGmqujQFzYnKdtrkjew+73hMO3qW2vUBBMu/JzULx1+9P/eqkfvcBD5PoYHuSWlmw7yILaicFeUawianS+gOTV38F26ZUpLXvJ4xqJQQ/djIqZw2/+IYEHX6FkvZF0Eeok7fYp7qll4buZlv0Ym5ACHB0S3qc7rIr5j/A7+O7z/zWxRoyPZzS5cWk8G/+eXHZ212JNuHUEMxyglF+SFg9T3ptmN4/hm/XneF3mDml/rv63B75sitbJmf/oL82lsDmWCG/dPPzL9kj7k5/gtp9UFe0o4dFr4cwNGMb6Kug4Cu0g4kbS/9Jhtv/XjLGiOfN7H6LlNUfYT/24MV6dQS76eJZrh6H7vVrYy+aGWBtvQzz9ovmLKcWf1olP4oxkmBT7j1TTi4myFfhynIS6WYP/wEJinV0xgyaxezL2kmD6Zy98Vn1+Rydun9hy41wul1qXZocia5+YPHyFE6pnWpczytL83g7eM/QktXo/PXS8271F9+fGb+DsKKHaJ0x2Lm6iA/VBm8Ne2weTeTjDN3OUVtypALi11/9YaN8wiHbchCFaPUnHq8iq8eLyHurZ+zSZPUWNRQfp9OBnSJL5VbrqPkmJfoZmfRzHtNcQ0hyt/C/GrI5RLam79BEgX86JFn6VAny/612Dh194KjlUWWL818gSgi+yNqqzn9GlXXiLBGazUnVaOcGoHU6KDm3GlUTSNeGo3SnCKN4miERaMfmjOhUQON6Ge0PXPCM0qdEeSM7mbktR2oaEYsM5qYkb7MhcsIWUavMrKUuT4ZkcloSUYyMpchIwAZncfIOeZqY8QZo8EYqcVcVIxwYvQRI4OYa4cRNYx2YSQKc4kwgoPRFYx8YK4ERgwwNn9j2hct+MZQb+zxOzC7G+u6MaIbW7l5EjeWb2PgNnZsY67egVXaGJ+NjdmYks2LsTEMG/uvMfOa11xjtDW2WWOCNS+txqBq7KbGPGpeQY2x09g0jenSvFAaQ6SxNxqzonk9NEZCYws0Jj/zsmcMeMZOZ8xx5tXNGNeMDc2YysyLmDF8GfuWMWMZa9UOjFLG9mRMTMaSJKe+/Fnl5j9dMGejYetHv9++n/5D/xvqA54pNM8UhmcKyzOF55ki8EznZN783C2x3NQubuoqXInlpqa5qRmuxHFTs9zU3XIljpua56YWuOmarHrzKq2xxKF0FEojShOWaJQwlj6FJRqlBaUvsYRQ2mF6+CpiCaG0RmnAEkZpxBKH0iUsYZRmlD7CEkZpwRKH0ldYwijtsMRheliVsIRRWmOJQ+kQljBKI0qXsIRRmlH6CEsYpQWlr7CEUdph6rpkikFpjdJhLDEojShdxhKD0ozSBksEpQWl72CJYHrYVGGJRmmN0oAlgNJpLDEoTSjNWCIobVBasMSitEXpFyyxmB60hdIaSxxKA0rnYolDaULp01hiUHoaSwxKX6P0KyxhTA+7KixxKL2FJQ6lQyidxBKL0kUssThkwGu211fvQt7C/Z88Sbw3JBiJAPzcrx3ru8zCdse1MygbJbjq0sf+TY7kn3d+bBSPs/J1HBgcrsb4vV0FYPlajT7fus69J+wfb3Eh1yLnEMrVfcdwNHJ6m8C8z9ZdKahPzvPbtf3x6d9hMn5PhCLufmlooLTyc/+eNd2ne+1l6t7i5ejRekChSIdrj4M18n9j1oNv/hiRHdCHXTy8C7RR7+OYQajbuDIJm1T++BFcWP2boN/vo7QNNgE8ktpQ9FY89Ld+n7ljOB8uT/xPxJUTdjkmw8XXPJGNS5gJTirw9wf946gLBn3UeoF6luax9yKssW1YIMSS6RNxmvlK3yKRuBLp5M0Vv9BGZIDLFjeQMTPh2Xo9bNnon9EvXd+MmAuSJIT+ah6PjRJv02YEr51qU/94zOM9Xheu6XVz898B"></div></details><hr /><br />

**类似题目**：
  - [1254. 统计封闭岛屿的数目 🟠](/problems/number-of-closed-islands)
  - [1905. 统计子岛屿 🟠](/problems/count-sub-islands)
  - [200. 岛屿数量 🟠](/problems/number-of-islands)
  - [694. 不同岛屿的数量 🟠](/problems/number-of-distinct-islands)
  - [695. 岛屿的最大面积 🟠](/problems/max-area-of-island)
  - [剑指 Offer II 105. 岛屿的最大面积 🟠](/problems/ZL6zAn)

</details>
</div>



