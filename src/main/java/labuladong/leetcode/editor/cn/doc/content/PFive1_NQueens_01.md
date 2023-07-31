<p>The <strong>n-queens</strong> puzzle is the problem of placing <code>n</code> queens on an <code>n x n</code> chessboard such that no two queens attack each other.</p>

<p>Given an integer <code>n</code>, return <em>all distinct solutions to the <strong>n-queens puzzle</strong></em>. You may return the answer in <strong>any order</strong>.</p>

<p>Each solution contains a distinct board configuration of the n-queens' placement, where <code>'Q'</code> and <code>'.'</code> both indicate a queen and an empty space, respectively.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/queens.jpg" style="width: 600px; height: 268px;" /> 
<pre>
<strong>Input:</strong> n = 4
<strong>Output:</strong> [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
<strong>Explanation:</strong> There exist two distinct solutions to the 4-queens puzzle as shown above
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> [["Q"]]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 9</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 回溯</details><br>

<div>👍 1838, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 最后一天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=n-queens" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 43 页。

视频讲解回溯算法原理：[回溯算法框架套路详解](https://www.bilibili.com/video/BV1P5411N7Xc)

N 皇后问题就是一个决策问题：对于每一行，我应该选择在哪一列防止皇后呢？

这就是典型的回溯算法题目，回溯算法的框架如下：

```python
result = []
def backtrack(路径，选择列表):
    if 满足结束条件:
        result.add(路径)
        return

    for 选择 in 选择列表:
        做选择
        backtrack(路径，选择列表)
        撤销选择
```

回溯算法框架就是遍历决策树的过程：

![](https://labuladong.github.io/pictures/backtracking/7.jpg)

关于回溯算法的详细讲解可以看 [46. 全排列](/problems/permutations) 或者详细题解。

**详细题解：[回溯算法解题套路框架](https://labuladong.github.io/article/fname.html?fname=回溯算法详解修订版)**

**标签：[回溯算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">cpp🟢</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">java🤖</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item active" data-tab-group="default"><div class="highlight">

```cpp
class Solution {
    public:
    vector<vector<string>> res;

    /* 输入棋盘边长 n，返回所有合法的放置 */
    vector<vector<string>> solveNQueens(int n) {
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
        vector<string> board(n, string(n, '.'));
        backtrack(board, 0);
        return res;
    }

    // 路径：board 中小于 row 的那些行都已经成功放置了皇后
    // 选择列表：第 row 行的所有列都是放置皇后的选择
    // 结束条件：row 超过 board 的最后一行
    void backtrack(vector<string>& board, int row) {
        // 触发结束条件
        if (row == board.size()) {
            res.push_back(board);
            return;
        }

        int n = board[row].size();
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col)) {/**<extend up -200>![](https://labuladong.github.io/pictures/backtracking/7.jpg) */
                continue;
            }
            // 做选择
            board[row][col] = 'Q';
            // 进入下一行决策
            backtrack(board, row + 1);
            // 撤销选择
            board[row][col] = '.';
        }
    }

    /* 是否可以在 board[row][col] 放置皇后？*/
    bool isValid(vector<string>& board, int row, int col) {
        int n = board.size();
        // 检查列是否有皇后互相冲突
        for (int i = 0; i <= row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def __init__(self):
        self.res = []

    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [['.' for j in range(n)] for i in range(n)]  # 初始化空棋盘
        self.backtrack(board, 0)
        return self.res

    def backtrack(self, board: List[List[str]], row: int):
        if row == len(board):  # 触发结束条件
            self.res.append([''.join(board[i]) for i in range(len(board))])
            return

        for col in range(len(board[row])):
            if not self.isValid(board, row, col):  # 排除不合法选择
                continue
            board[row][col] = 'Q'  # 做选择
            self.backtrack(board, row + 1)  # 进入下一行决策
            board[row][col] = '.'  # 撤销选择

    def isValid(self, board: List[List[str]], row: int, col: int) -> bool:
        n = len(board)
        # 检查列是否有皇后互相冲突
        for i in range(row + 1):
            if board[i][col] == 'Q':
                return False
        # 检查右上方是否有皇后互相冲突
        for i, j in zip(range(row - 1, -1, -1), range(col + 1, n)):
            if board[i][j] == 'Q':
                return False
        # 检查左上方是否有皇后互相冲突
        for i, j in zip(range(row - 1, -1, -1), range(col - 1, -1, -1)):
            if board[i][j] == 'Q':
                return False
        return True
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
// 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    List<List<String>> res = new ArrayList<>();

    /**
     * 输入棋盘边长 n，返回所有合法的放置
     */
    public List<List<String>> solveNQueens(int n) {
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        for (int i = 0; i < n; i++) {
            board.add(sb.toString());
        }
        backtrack(board, 0);
        return res;
    }

    /**
     * *路径：board 中小于 row 的那些行都已经成功放置了皇后
     * *选择列表：第 row 行的所有列都是放置皇后的选择
     * *结束条件：row 超过 board 的最后一行
     */
    private void backtrack(List<String> board, int row) {
        if (row == board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }

        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col)) {/**<extend up -200>![](https://labuladong.github.io/pictures/backtracking/7.jpg) */
                continue;
            }
            // 做选择
            char[] arr = board.get(row).toCharArray();
            arr[col] = 'Q';
            board.set(row, String.valueOf(arr));
            // 进入下一行决策
            backtrack(board, row + 1);
            // 撤销选择
            arr[col] = '.';
            board.set(row, String.valueOf(arr));
        }
    }

    /* 是否可以在 board[row][col] 放置皇后？*/
    private boolean isValid(List<String> board, int row, int col) {
        int n = board.size();

        // 检查列是否有皇后互相冲突
        for (int i = 0; i <= row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 cpp 代码对比查看。

type backtracking struct {
    res [][]string
}

func (b *backtracking) solveNQueens(n int) [][]string {
    board := make([]string, n)
    for i := 0; i < n; i++ {
        board[i] = strings.Repeat(".", n)
    }
    b.backtrack(board, 0)
    return b.res
}

func (b *backtracking) backtrack(board []string, row int) {
    if row == len(board) {
        temp := make([]string, len(board))
        copy(temp, board)
        b.res = append(b.res, temp)
        return
    }

    n := len(board[row])
    for col := 0; col < n; col++ {
        if !b.isValid(board, row, col) {
            // 排除不合法选择
            continue
        }
        // 做选择
        board[row] = board[row][:col] + "Q" + board[row][col+1:]
        // 进入下一行决策
        b.backtrack(board, row+1)
        // 撤销选择
        board[row] = board[row][:col] + "." + board[row][col+1:]
    }
}

func (b *backtracking) isValid(board []string, row, col int) bool {
    n := len(board)
    // 检查列是否有皇后互相冲突
    for i := 0; i <= row; i++ {
        if board[i][col] == 'Q' {
            return false
        }
    }
    // 检查右上方是否有皇后互相冲突
    for i, j := row-1, col+1; i >= 0 && j < n; i, j = i-1, j+1 {
        if board[i][j] == 'Q' {
            return false
        }
    }
    // 检查左上方是否有皇后互相冲突
    for i, j := row-1, col-1; i >= 0 && j >= 0; i, j = i-1, j-1 {
        if board[i][j] == 'Q' {
            return false
        }
    }
    return true
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var solveNQueens = function(n) {
  var res = [];

  // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
  var board = new Array(n);
  for (var i = 0; i < n; i++) {
    board[i] = new Array(n).fill('.');
  }

  backtrack(board, 0);

  return res;

  // 路径：board 中小于 row 的那些行都已经成功放置了皇后
  // 选择列表：第 row 行的所有列都是放置皇后的选择
  // 结束条件：row 超过 board 的最后一行
  function backtrack(board, row) {
    // 触发结束条件
    if (row === board.length) {
      res.push(Array.from(board, row => row.join('')));
      return;
    }

    var n = board.length;
    for (var col = 0; col < n; col++) {
      // 排除不合法选择
      if (!isValid(board, row, col)) {
        continue;
      }
      // 做选择
      board[row][col] = 'Q';
      // 进入下一行决策
      backtrack(board, row + 1);
      // 撤销选择
      board[row][col] = '.';
    }
  }

  /* 是否可以在 board[row][col] 放置皇后？*/
  function isValid(board, row, col) {
    var n = board.length;
    // 检查列是否有皇后互相冲突
    for (var i = 0; i <= row; i++) {
      if (board[i][col] === 'Q') {
        return false;
      }
    }
    // 检查右上方是否有皇后互相冲突
    for (var i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
      if (board[i][j] === 'Q') {
        return false;
      }
    }
    // 检查左上方是否有皇后互相冲突
    for (var i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] === 'Q') {
        return false;
      }
    }
    return true;
  }
};
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_n-queens" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_n-queens"></div></div>
</details><hr /><br />

**类似题目**：
  - [46. 全排列 🟠](/problems/permutations)
  - [52. N皇后 II 🔴](/problems/n-queens-ii)
  - [剑指 Offer II 083. 没有重复元素集合的全排列 🟠](/problems/VvJkup)

</details>
</div>



