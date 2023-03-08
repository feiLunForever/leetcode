<p>English description is not available for the problem. Please switch to Chinese.</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 排序</details><br>

<div>👍 284, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题是前文 [数组双指针技巧汇总](https://labuladong.github.io/article/fname.html?fname=双指针技巧) 讲到的快慢指针技巧，可以复用 [27. 移除元素（简单）](/problems/remove-element) 解法中的函数，只要稍微修改一下逻辑即可。

**标签：[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

## 解法代码

```java
class Solution {
    public int[] exchange(int[] nums) {
        // 维护 nums[0..slow) 都是奇数
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] % 2 == 1) {
                // fast 遇到奇数，把 nums[fast] 换到 nums[slow]
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
}
```

</details>
</div>



