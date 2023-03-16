English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>字符串 | 回溯</details><br>

<div>👍 656, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。[第 18 期每日打卡](https://aep.xet.tech/s/2PLO1n) 开始报名。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这就是 [一文秒杀所有排列组合子集问题](https://labuladong.github.io/article/fname.html?fname=子集排列组合) 中讲的「元素可重不可复选」的排列问题，前文我使用 [47. 全排列 II（中等）](/problems/permutations-ii) 举的例子，你把 47 题的解法代码稍微改一改就可以解决这道题了。

**标签：[回溯算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)，排列组合**

## 解法代码

```java
class Solution {
    public String[] permutation(String s) {
        permuteUnique(s.toCharArray());
        String[] arr = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    List<String> res = new ArrayList<>();
    StringBuilder track = new StringBuilder();
    boolean[] used;

    public List<String> permuteUnique(char[] nums) {
        // 先排序，让相同的元素靠在一起
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    void backtrack(char[] nums) {
        if (track.length() == nums.length) {
            res.add(track.toString());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            track.append(nums[i]);
            used[i] = true;
            backtrack(nums);
            track.deleteCharAt(track.length() - 1);
            used[i] = false;
        }
    }
}
```

</details>
</div>



