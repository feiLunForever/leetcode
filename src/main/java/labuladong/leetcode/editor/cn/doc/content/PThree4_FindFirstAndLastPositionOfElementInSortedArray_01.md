<p>Given an array of integers <code>nums</code> sorted in non-decreasing order, find the starting and ending position of a given <code>target</code> value.</p>

<p>If <code>target</code> is not found in the array, return <code>[-1, -1]</code>.</p>

<p>You must&nbsp;write an algorithm with&nbsp;<code>O(log n)</code> runtime complexity.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 8
<strong>Output:</strong> [3,4]
</pre>
<p><strong class="example">Example 2:</strong></p> 
<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 6
<strong>Output:</strong> [-1,-1]
</pre>
<p><strong class="example">Example 3:</strong></p> 
<pre><strong>Input:</strong> nums = [], target = 0
<strong>Output:</strong> [-1,-1]
</pre> 
<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>0 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>9</sup>&nbsp;&lt;= nums[i]&nbsp;&lt;= 10<sup>9</sup></code></li> 
 <li><code>nums</code> is a non-decreasing array.</li> 
 <li><code>-10<sup>9</sup>&nbsp;&lt;= target&nbsp;&lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>

<div>👍 2399, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 最后一天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=find-first-and-last-position-of-element-in-sorted-array" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[二分搜索核心框架套路](https://www.bilibili.com/video/BV1Gt4y1b79Q)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 71 页。

二分搜索的难点就在于如何搜索左侧边界和右侧边界，代码的边界的控制非常考验你的微操，这也是很多人知道二分搜索原理但是很难写对代码的原因。

[二分搜索框架详解](https://labuladong.github.io/article/fname.html?fname=二分查找详解) 专门花了很大篇幅讨论如何写对二分搜索算法，总结来说：

写对二分搜索的关键在于搞清楚搜索边界，到底是开区间还是闭区间？到底应该往左侧收敛还是应该往右侧收敛？

深入的探讨请看详细题解。

**详细题解：[我写了首诗，把二分搜索算法变成了默写题](https://labuladong.github.io/article/fname.html?fname=二分查找详解)**

**标签：[二分搜索](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    vector<int> searchRange(vector<int>& nums, int target) {
        int left = left_bound(nums, target);
        int right = right_bound(nums, target);
        return {left, right};
    }

    int left_bound(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.size() || nums[left] != target) {
            /* <extend up -300>
            ![](https://labuladong.github.io/pictures/二分查找/2.jpg)
            */
            return -1;
        }
        return left;
    }

    int right_bound(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 这里改为检查 right 越界的情况，见下图
        if (right < 0 || nums[right] != target) {
            /* <extend up -300>
            ![](https://labuladong.github.io/pictures/二分查找/4.jpg)
            */
            return -1;
        }
        return right;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        return [self.left_bound(nums, target), self.right_bound(nums, target)]
    
    def left_bound(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        # 搜索区间为 [left, right]
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] < target:
                # 搜索区间变为 [mid+1, right]
                left = mid + 1
            elif nums[mid] > target:
                # 搜索区间变为 [left, mid-1]
                right = mid - 1
            elif nums[mid] == target:
                # 收缩右侧边界
                right = mid - 1
        # 检查出界情况
        if left >= len(nums) or nums[left] != target: # <extend up -300>![](https://labuladong.github.io/pictures/二分查找/2.jpg) #f
            return -1
        return left
    
    def right_bound(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            elif nums[mid] == target:
                # 这里改成收缩左侧边界即可
                left = mid + 1
        # 这里改为检查 right 越界的情况，见下图
        if right < 0 or nums[right] != target: # <extend up -300>![](https://labuladong.github.io/pictures/二分查找/4.jpg) #
            return -1
        return right
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{left_bound(nums, target), right_bound(nums, target)};
    }

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.length || nums[left] != target) {/**<extend up -300>![](https://labuladong.github.io/pictures/二分查找/2.jpg) */
            return -1;
        }
        return left;
    }

    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 这里改为检查 right 越界的情况，见下图
        if (right < 0 || nums[right] != target) {/**<extend up -300>![](https://labuladong.github.io/pictures/二分查找/4.jpg) */
            return -1;
        }
        return right;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

func searchRange(nums []int, target int) []int {
    return []int{leftBound(nums, target), rightBound(nums, target)}
}

func leftBound(nums []int, target int) int {
    left, right := 0, len(nums)-1
    // 搜索区间为 [left, right]
    for left <= right {
        mid := left + (right-left)/2
        if nums[mid] < target {
            // 搜索区间变为 [mid+1, right]
            left = mid + 1
        } else if nums[mid] > target {
            // 搜索区间变为 [left, mid-1]
            right = mid - 1
        } else if nums[mid] == target {
            // 收缩右侧边界
            right = mid - 1
        }
    }
    // 检查出界情况
    if left >= len(nums) || nums[left] != target {/**<extend up -300>![](https://labuladong.github.io/pictures/二分查找/2.jpg) */
        return -1
    }
    return left
}

func rightBound(nums []int, target int) int {
    left, right := 0, len(nums)-1
    for left <= right {
        mid := left + (right-left)/2
        if nums[mid] < target {
            left = mid + 1
        } else if nums[mid] > target {
            right = mid - 1
        } else if nums[mid] == target {
            // 这里改成收缩左侧边界即可
            left = mid + 1
        }
    }
    // 这里改为检查 right 越界的情况，见下图
    if right < 0 || nums[right] != target {/**<extend up -300>![](https://labuladong.github.io/pictures/二分查找/4.jpg) */
        return -1
    }
    return right
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var searchRange = function(nums, target) {
  return [left_bound(nums, target), right_bound(nums, target)];
};

var left_bound = function(nums, target) {
  let left = 0,
    right = nums.length - 1;
  // 搜索区间为 [left, right]
  while (left <= right) {
    let mid = left + Math.floor((right - left) / 2);
    if (nums[mid] < target) {
      // 搜索区间变为 [mid+1, right]
      left = mid + 1;
    } else if (nums[mid] > target) {
      // 搜索区间变为 [left, mid-1]
      right = mid - 1;
    } else if (nums[mid] === target) {
      // 收缩右侧边界
      right = mid - 1;
    }
  }
  // 检查出界情况
  if (left >= nums.length || nums[left] !== target) {/**<extend up -300>![](https://labuladong.github.io/pictures/二分查找/2.jpg) */
    return -1;
  }
  return left;
};

var right_bound = function(nums, target) {
  let left = 0,right = nums.length - 1;
  while (left <= right) {
    let mid = left + Math.floor((right - left) / 2);
    if (nums[mid] < target) {
      left = mid + 1;
    } else if (nums[mid] > target) {
      right = mid - 1;
    } else if (nums[mid] === target) {
      // 这里改成收缩左侧边界即可
      left = mid + 1;
    }
  }
  // 这里改为检查 right 越界的情况，见下图
  if (right < 0 || nums[right] !== target) {/**<extend up -300>![](https://labuladong.github.io/pictures/二分查找/4.jpg) */
    return -1;
  }
  return right;
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_find-first-and-last-position-of-element-in-sorted-array" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_find-first-and-last-position-of-element-in-sorted-array"></div></div>
</details><hr /><br />

**类似题目**：
  - [704. 二分查找 🟢](/problems/binary-search)
  - [剑指 Offer 53 - I. 在排序数组中查找数字 I 🟢](/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof)

</details>
</div>



