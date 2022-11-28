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

<div>👍 284, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0，第 14 期打卡训练营 [开始报名](https://aep.xet.tech/s/3ts7sQ)。**



<p><strong><a href="https://labuladong.github.io/article?qno=969" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 337 页。

这个问题具有递归性质，你想把 `n` 个烧饼排序，可以按如下步骤操作：

1、先把 `n` 个烧饼中最大的那个烧饼找出来。

2、把这个最大的烧饼放在最下面。

3、对剩下 `n - 1` 个烧饼排序。

![](https://labuladong.github.io/algo/images/pancakeSort/4.jpg)

**详细题解：[烧饼排序算法](https://labuladong.github.io/article/fname.html?fname=烧饼排序)**

**标签：递归**

## 解法代码

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
        res.add(n);/**<extend up -150>

![](https://labuladong.github.io/algo/images/pancakeSort/3.jpg)
*/
        // 递归调用
        sort(cakes, n - 1);/**<extend up -150>

![](https://labuladong.github.io/algo/images/pancakeSort/4.jpg)
*/
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

</details>
</div>



