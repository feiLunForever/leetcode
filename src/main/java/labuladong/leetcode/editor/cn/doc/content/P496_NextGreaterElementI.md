<p>The <strong>next greater element</strong> of some element <code>x</code> in an array is the <strong>first greater</strong> element that is <strong>to the right</strong> of <code>x</code> in the same array.</p>

<p>You are given two <strong>distinct 0-indexed</strong> integer arrays <code>nums1</code> and <code>nums2</code>, where <code>nums1</code> is a subset of <code>nums2</code>.</p>

<p>For each <code>0 &lt;= i &lt; nums1.length</code>, find the index <code>j</code> such that <code>nums1[i] == nums2[j]</code> and determine the <strong>next greater element</strong> of <code>nums2[j]</code> in <code>nums2</code>. If there is no next greater element, then the answer for this query is <code>-1</code>.</p>

<p>Return <em>an array </em><code>ans</code><em> of length </em><code>nums1.length</code><em> such that </em><code>ans[i]</code><em> is the <strong>next greater element</strong> as described above.</em></p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [4,1,2], nums2 = [1,3,4,2]
<strong>Output:</strong> [-1,3,-1]
<strong>Explanation:</strong> The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,<u>4</u>,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [<u>1</u>,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,<u>2</u>]. There is no next greater element, so the answer is -1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [2,4], nums2 = [1,2,3,4]
<strong>Output:</strong> [3,-1]
<strong>Explanation:</strong> The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,<u>2</u>,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,<u>4</u>]. There is no next greater element, so the answer is -1.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums1.length &lt;= nums2.length &lt;= 1000</code></li> 
 <li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>4</sup></code></li> 
 <li>All integers in <code>nums1</code> and <code>nums2</code> are <strong>unique</strong>.</li> 
 <li>All the integers of <code>nums1</code> also appear in <code>nums2</code>.</li> 
</ul>

<p>&nbsp;</p> 
<strong>Follow up:</strong> Could you find an 
<code>O(nums1.length + nums2.length)</code> solution?

<details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 哈希表 | 单调栈</details><br>

<div>👍 854, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0，第 12 期刷题打卡 [开始报名](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q)，点击这里体验 [刷题全家桶](https://labuladong.gitee.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg)。**



<p><strong><a href="https://labuladong.github.io/article?qno=496" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

[单调栈模板](https://labuladong.github.io/article/fname.html?fname=单调栈) 实现了一个计算下一个更大元素的函数，这里可以直接复用。因为题目说 `nums1` 是 `nums2` 的子集，那么我们先把 `nums2` 中每个元素的下一个更大元素算出来存到一个映射里，然后再让 `nums1` 中的元素去查表即可。

**详细题解：[单调栈结构解决三道算法题](https://labuladong.github.io/article/fname.html?fname=单调栈)**

**标签：单调栈，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)**

## 解法代码

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 记录 nums2 中每个元素的下一个更大元素
        int[] greater = nextGreaterElement(nums2);
        // 转化成映射：元素 x -> x 的下一个最大元素
        HashMap<Integer, Integer> greaterMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            greaterMap.put(nums2[i], greater[i]);
        }
        // nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = greaterMap.get(nums1[i]);
        }
        return res;
    }

    // 计算 nums 中每个元素的下一个更大元素
    int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        // 存放答案的数组
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                s.pop();
            }
            // nums[i] 身后的下一个更大元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }
}
```

**类似题目**：
  - [503. 下一个更大元素 II 🟠](/problems/next-greater-element-ii)
  - [739. 每日温度 🟠](/problems/daily-temperatures)

</details>
</div>



