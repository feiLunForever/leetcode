<p>You are given a series of video clips from a sporting event that lasted <code>time</code> seconds. These video clips can be overlapping with each other and have varying lengths.</p>

<p>Each video clip is described by an array <code>clips</code> where <code>clips[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> indicates that the ith clip started at <code>start<sub>i</sub></code> and ended at <code>end<sub>i</sub></code>.</p>

<p>We can cut these clips into segments freely.</p>

<ul> 
 <li>For example, a clip <code>[0, 7]</code> can be cut into segments <code>[0, 1] + [1, 3] + [3, 7]</code>.</li> 
</ul>

<p>Return <em>the minimum number of clips needed so that we can cut the clips into segments that cover the entire sporting event</em> <code>[0, time]</code>. If the task is impossible, return <code>-1</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], time = 10
<strong>Output:</strong> 3
<strong>Explanation:</strong> We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.
Then, we can reconstruct the sporting event as follows:
We cut [1,9] into segments [1,2] + [2,8] + [8,9].
Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0, 10].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> clips = [[0,1],[1,2]], time = 5
<strong>Output:</strong> -1
<strong>Explanation:</strong> We cannot cover [0,5] with only [0,1] and [1,2].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], time = 9
<strong>Output:</strong> 3
<strong>Explanation:</strong> We can take clips [0,4], [4,7], and [6,9].
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= clips.length &lt;= 100</code></li> 
 <li><code>0 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 100</code></li> 
 <li><code>1 &lt;= time &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 动态规划</details><br>

<div>👍 303, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0；第 13 期刷题打卡 [开始报名](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q)。**



<p><strong><a href="https://labuladong.github.io/article?qno=1024" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

我做这道题的思路是先按照起点升序排序，如果起点相同的话按照终点降序排序，主要考虑到这道题的以下两个特点：

1、要用若干短视频凑出完成视频 `[0, T]`，至少得有一个短视频的起点是 0。

2、如果有几个短视频的起点都相同，那么一定应该选择那个最长（终点最大）的视频。

![](https://labuladong.github.io/algo/images/剪视频/4.jpeg)

排序之后，从第一个区间开始选，每当选中一个区间 `x`（图中红色的区间），我们会比较所有起点小于 `x.start` 的区间，根据贪心策略，它们中终点最大的那个区间就是下一个会被选中的区间，以此类推。

**详细题解：[剪视频剪出一个贪心算法](https://labuladong.github.io/article/fname.html?fname=剪视频)**

**标签：[区间问题](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122021012031569922)，排序，贪心算法**

## 解法代码

```java
class Solution {
    public int videoStitching(int[][] clips, int T) {
        if (T == 0) return 0;
        // 按起点升序排列，起点相同的降序排列
        // PS：其实起点相同的不用降序排列也可以，不过我觉得这样更清晰
        Arrays.sort(clips, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        // 记录选择的短视频个数
        int res = 0;

        int curEnd = 0, nextEnd = 0;
        int i = 0, n = clips.length;
        while (i < n && clips[i][0] <= curEnd) {
            // 在第 res 个视频的区间内贪心选择下一个视频
            while (i < n && clips[i][0] <= curEnd) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            // 找到下一个视频，更新 curEnd
            res++;
            curEnd = nextEnd;
            if (curEnd >= T) {
                // 已经可以拼出区间 [0, T]
                return res;
            }
        }
        // 无法连续拼出区间 [0, T]
        return -1;
    }
}
```

</details>
</div>



