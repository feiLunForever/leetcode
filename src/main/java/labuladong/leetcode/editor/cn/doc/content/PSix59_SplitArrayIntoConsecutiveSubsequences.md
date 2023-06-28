<p>You are given an integer array <code>nums</code> that is <strong>sorted in non-decreasing order</strong>.</p>

<p>Determine if it is possible to split <code>nums</code> into <strong>one or more subsequences</strong> such that <strong>both</strong> of the following conditions are true:</p>

<ul> 
 <li>Each subsequence is a <strong>consecutive increasing sequence</strong> (i.e. each integer is <strong>exactly one</strong> more than the previous integer).</li> 
 <li>All subsequences have a length of <code>3</code><strong> or more</strong>.</li> 
</ul>

<p>Return <code>true</code><em> if you can split </em><code>nums</code><em> according to the above conditions, or </em><code>false</code><em> otherwise</em>.</p>

<p>A <strong>subsequence</strong> of an array is a new array that is formed from the original array by deleting some (can be none) of the elements without disturbing the relative positions of the remaining elements. (i.e., <code>[1,3,5]</code> is a subsequence of <code>[<u>1</u>,2,<u>3</u>,4,<u>5</u>]</code> while <code>[1,3,2]</code> is not).</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,3,4,5]
<strong>Output:</strong> true
<strong>Explanation:</strong> nums can be split into the following subsequences:
[<strong><u>1</u></strong>,<strong><u>2</u></strong>,<strong><u>3</u></strong>,3,4,5] --&gt; 1, 2, 3
[1,2,3,<strong><u>3</u></strong>,<strong><u>4</u></strong>,<strong><u>5</u></strong>] --&gt; 3, 4, 5
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,3,4,4,5,5]
<strong>Output:</strong> true
<strong>Explanation:</strong> nums can be split into the following subsequences:
[<strong><u>1</u></strong>,<strong><u>2</u></strong>,<strong><u>3</u></strong>,3,<strong><u>4</u></strong>,4,<strong><u>5</u></strong>,5] --&gt; 1, 2, 3, 4, 5
[1,2,3,<strong><u>3</u></strong>,4,<strong><u>4</u></strong>,5,<strong><u>5</u></strong>] --&gt; 3, 4, 5
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4,4,5]
<strong>Output:</strong> false
<strong>Explanation:</strong> It is impossible to split nums into consecutive increasing subsequences of length 3 or more.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li> 
 <li><code>nums</code> is sorted in <strong>non-decreasing</strong> order.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 哈希表 | 堆（优先队列）</details><br>

<div>👍 439, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=split-array-into-consecutive-subsequences" target="_blank">⭐️labuladong 题解</a></strong></p>
</div>



