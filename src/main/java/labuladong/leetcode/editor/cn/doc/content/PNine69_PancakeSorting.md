<p>Given an array of integers <code>arr</code>, sort the array by performing a series of <strong>pancake flips</strong>.</p>

<p>In one pancake flip we do the following steps:</p>

<ul> 
 <li>Choose an integer <code>k</code> where <code>1 &lt;= k &lt;= arr.length</code>.</li> 
 <li>Reverse the sub-array <code>arr[0...k-1]</code> (<strong>0-indexed</strong>).</li> 
</ul>

<p>For example, if <code>arr = [3,2,1,4]</code> and we performed a pancake flip choosing <code>k = 3</code>, we reverse the sub-array <code>[3,2,1]</code>, so <code>arr = [<u>1</u>,<u>2</u>,<u>3</u>,4]</code> after the pancake flip at <code>k = 3</code>.</p>

<p>Return <em>an array of the </em><code>k</code><em>-values corresponding to a sequence of pancake flips that sort </em><code>arr</code>. Any valid answer that sorts the array within <code>10 * arr.length</code> flips will be judged as correct.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [3,2,4,1]
<strong>Output:</strong> [4,2,4,3]
<strong>Explanation: </strong>
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: arr = [3, 2, 4, 1]
After 1st flip (k = 4): arr = [<u>1</u>, <u>4</u>, <u>2</u>, <u>3</u>]
After 2nd flip (k = 2): arr = [<u>4</u>, <u>1</u>, 2, 3]
After 3rd flip (k = 4): arr = [<u>3</u>, <u>2</u>, <u>1</u>, <u>4</u>]
After 4th flip (k = 3): arr = [<u>1</u>, <u>2</u>, <u>3</u>, 4], which is sorted.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,2,3]
<strong>Output:</strong> []
<strong>Explanation: </strong>The input is already sorted, so there is no need to flip anything.
Note that other answers, such as [3, 3], would also be accepted.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= arr.length &lt;= 100</code></li> 
 <li><code>1 &lt;= arr[i] &lt;= arr.length</code></li> 
 <li>All integers in <code>arr</code> are unique (i.e. <code>arr</code> is a permutation of the integers from <code>1</code> to <code>arr.length</code>).</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 双指针 | 排序</details><br>

<div>👍 306, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=pancake-sorting" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 337 页。

这个问题具有递归性质，你想把 `n` 个烧饼排序，可以按如下步骤操作：

1、先把 `n` 个烧饼中最大的那个烧饼找出来。

2、把这个最大的烧饼放在最下面。

3、对剩下 `n - 1` 个烧饼排序。

![](https://labuladong.github.io/pictures/pancakeSort/4.jpg)

**详细题解：[烧饼排序算法](https://labuladong.github.io/article/fname.html?fname=烧饼排序)**

**标签：递归**

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
    vector<int> res; 
    
public:
    vector<int> pancakeSort(vector<int>& cakes) {
        sort(cakes, cakes.size());
        return res;
    }

    void sort(vector<int>& cakes, int n) {
        // base case
        if (n == 1) return;

        // 寻找最大饼的索引
        int maxCake = 0;
        int maxCakeIndex = 0;
        for (int i = 0; i < n; i++)
            if (cakes[i] > maxCake) {
                maxCakeIndex = i;
                maxCake = cakes[i];
            }

        // 第一次翻转，将最大饼翻到最上面
        reverse(cakes, 0, maxCakeIndex);
        res.push_back(maxCakeIndex + 1);
        // 第二次翻转，将最大饼翻到最下面
        reverse(cakes, 0, n - 1);
        res.push_back(n);
        //递归调用
        sort(cakes, n - 1);
    }

    void reverse(vector<int>& arr, int i, int j) {
        while (i < j) {
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
    def __init__(self):
        self.res = [] #记录反转操作序列
    def pancakeSort(self, cakes: List[int]) -> List[int]:
        self.sort(cakes, len(cakes))
        return self.res

    def sort(self, cakes: List[int], n: int) -> None:
        # base case
        if n == 1:
            return

        # 寻找最大饼的索引
        maxCake = 0
        maxCakeIndex = 0
        for i in range(n):
            if cakes[i] > maxCake:
                maxCakeIndex = i
                maxCake = cakes[i]

        # 第一次翻转，将最大饼翻到最上面
        self.reverse(cakes, 0, maxCakeIndex)
        self.res.append(maxCakeIndex + 1)
        # 第二次翻转，将最大饼翻到最下面
        self.reverse(cakes, 0, n - 1)
        self.res.append(n)

        #递归调用
        self.sort(cakes, n - 1)

    def reverse(self, arr: List[int], i: int, j: int) -> None:
        while i < j:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 记录反转操作序列
    LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> pancakeSort(int[] cakes) {
        sort(cakes, cakes.length);
        return res;
    }

    void sort(int[] cakes, int n) {
        // base case
        if (n == 1) return;

        // 寻找最大饼的索引
        int maxCake = 0;
        int maxCakeIndex = 0;
        for (int i = 0; i < n; i++)
            if (cakes[i] > maxCake) {
                maxCakeIndex = i;
                maxCake = cakes[i];
            }

        // 第一次翻转，将最大饼翻到最上面
        reverse(cakes, 0, maxCakeIndex);
        res.add(maxCakeIndex + 1);
        // 第二次翻转，将最大饼翻到最下面
        reverse(cakes, 0, n - 1);
        res.add(n);/**<extend up -150>![](https://labuladong.github.io/pictures/pancakeSort/3.jpg) */
        // 递归调用
        sort(cakes, n - 1);/**<extend up -150>![](https://labuladong.github.io/pictures/pancakeSort/4.jpg) */
    }

    void reverse(int[] arr, int i, int j) {
        while (i < j) {
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

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func pancakeSort(cakes []int) []int {
    // 记录反转操作序列
    res := []int{}
    sort(cakes, len(cakes), &res)
    return res
}

func sort(cakes []int, n int, res *[]int) {
    // base case
    if n == 1 {
        return
    }

    // 寻找最大饼的索引
    maxCake := 0
    maxCakeIndex := 0
    for i := 0; i < n; i++ {
        if cakes[i] > maxCake {
            maxCakeIndex = i
            maxCake = cakes[i]
        }
    }

    // 第一次翻转，将最大饼翻到最上面
    reverse(cakes, 0, maxCakeIndex)
    *res = append(*res, maxCakeIndex+1)
    // 第二次翻转，将最大饼翻到最下面
    reverse(cakes, 0, n-1)
    *res = append(*res, n)

    // 递归调用
    sort(cakes, n-1, res)
}

func reverse(arr []int, i int, j int) {
    for i < j {
        temp := arr[i]
        arr[i] = arr[j];
        arr[j] = temp;
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

var pancakeSort = function(cakes) {
    // Record the flip sequence 
    // 记录反转操作序列
    const res = [];

    // Sort the cakes array and record the flipping sequence
    // 对蛋糕数组进行排序，并记录翻转序列
    sort(cakes, cakes.length);

    // Return the flipping sequence 
    // 返回翻转序列
    return res;

    /**
     * Sort the cakes array in decreasing order recursively
     * 递归以递减的顺序对蛋糕数组排序
     * @param {number[]} cakes - The array for sorting
     * @param {number} n - The length of the array
     */
    function sort(cakes, n) {
        // Base case
        // 基本情况
        if (n == 1) return;

        // Find the index of max cake
        // 找到最大蛋糕的索引
        let maxCake = 0;
        let maxCakeIndex = 0;

        for (let i = 0; i < n; i++) {
            if (cakes[i] > maxCake) {
                maxCakeIndex = i;
                maxCake = cakes[i];
            }
        }

        // First flip to bring the max cake to the top
        // 第一次翻转，将最大饼翻到最上面
        reverse(cakes, 0, maxCakeIndex);

        res.push(maxCakeIndex + 1);

        // Second flip the max cake to bring it to the bottom
        // 第二次翻转，将最大饼翻到最下面
        reverse(cakes, 0, n - 1);

        res.push(n);

        // Recursively call the sort function with length-1
        // 递归调用长度减1的 sort 函数
        sort(cakes, n - 1);
    }

    /**
     * Flip the cake array from index i to index j
     * 翻转蛋糕数组从 i 到 j 索引
     * @param {number[]} arr - The array for flipping
     * @param {number} i - The start index
     * @param {number} j - The end index
     */
    function reverse(arr, i, j) {
        while (i < j) {
            let temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
};
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_pancake-sorting" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_pancake-sorting"></div></div>
</details><hr /><br />

</details>
</div>



