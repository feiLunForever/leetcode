English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>树状数组 | 线段树 | 数组 | 二分查找 | 分治 | 有序集合 | 归并排序</details><br>

<div>👍 970, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。[第 18 期每日打卡](https://aep.xet.tech/s/2PLO1n) 开始报名。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [归并排序详解及运用](https://labuladong.github.io/article/fname.html?fname=归并排序) 中讲的 [493. 翻转对](/problems/reverse-pairs/) 基本相同，只要把 493 题解法中的 `nums[end] * 2` 改成 `nums[end]` 即可。

**标签：归并排序**

## 解法代码

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
// 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

class Solution {
public:
    int reversePairs(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
        // 执行归并排序
        sort(nums);
        return count;
    }

    void sort(vector<int>& nums) {
        temp.resize(nums.size());
        sort(nums, 0, nums.size() - 1);
    }

    // 归并排序
    void sort(vector<int>& nums, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    // 记录「翻转对」的个数
    int count = 0;

    void merge(vector<int>& nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }

        // 进行效率优化，维护左闭右开区间 [mid+1, end) 中的元素乘 2 小于 nums[i]
        // 为什么 end 是开区间？因为这样的话可以保证初始区间 [mid+1, mid+1) 是一个空区间
        int end = mid + 1;
        for (int i = lo; i <= mid; i++) {
            // nums 中的元素可能较大，乘 2 可能溢出，所以转化成 long
            while (end <= hi && nums[i] > nums[end]) {
                end++;
            }
            count += end - (mid + 1);
        }

        // 数组双指针技巧，合并两个有序数组
        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                nums[p] = temp[j++];
            } else if (j == hi + 1) {
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }

private:
    vector<int> temp;
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

class Solution:
    def __init__(self):
        self.count = 0
        self.tmp = []

    # 包装方法
    def reversePairs(self, nums: List[int]) -> int:
        if not nums:
            return 0
        # 执行归并排序
        self.ms(nums, 0, len(nums) - 1)
        return self.count

    # 归并排序
    def ms(self, nums, left, right):
        if left >= right:
            return
        mid = (left + right) >> 1
        self.ms(nums, left, mid)
        self.ms(nums, mid + 1, right)
        self.merge(nums, left, mid, right)

    # 合并两个有序数组
    def merge(self, nums, left, mid, right):
        i, j = left, mid + 1
        t = []
        # 进行效率优化，维护左闭右开区间 [mid+1, end) 中的元素乘 2 小于 nums[i]
        # 为什么 end 是开区间？因为这样的话可以保证初始区间 [mid+1, mid+1) 是一个空区间
        end = mid + 1
        while i <= mid and j <= right:
            if nums[i] <= nums[j]:
                t.append(nums[i])
                i += 1
            else:
                t.append(nums[j])
                j += 1
                self.count += (mid - i + 1)

        while i <= mid:
            t.append(nums[i])
            i += 1

        while j <= right:
            t.append(nums[j])
            j += 1

        nums[left:right + 1] = t
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 执行归并排序
        sort(nums);
        return count;
    }

    private int[] temp;

    public void sort(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    // 归并排序
    private void sort(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    // 记录「翻转对」的个数
    private int count = 0;

    private void merge(int[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }

        // 进行效率优化，维护左闭右开区间 [mid+1, end) 中的元素乘 2 小于 nums[i]
        // 为什么 end 是开区间？因为这样的话可以保证初始区间 [mid+1, mid+1) 是一个空区间
        int end = mid + 1;
        for (int i = lo; i <= mid; i++) {
            // nums 中的元素可能较大，乘 2 可能溢出，所以转化成 long
            while (end <= hi && nums[i] > nums[end]) {
                end++;
            }
            count += end - (mid + 1);
        }

        // 数组双指针技巧，合并两个有序数组
        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                nums[p] = temp[j++];
            } else if (j == hi + 1) {
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

func reversePairs(nums []int) int {
    if len(nums) == 0 {
        return 0
    }
    // 执行归并排序并统计「翻转对」的个数
    return sort(nums)
}

func sort(nums []int) int {
    var temp = make([]int, len(nums))
    var count = 0 // 统计翻转对个数
    sortHelper(nums, 0, len(nums) - 1, temp, &count)
    return count
}

// 归并排序
func sortHelper(nums []int, lo, hi int, temp []int, count *int) {
    if lo == hi {
        return
    }
    mid := lo + (hi - lo) / 2
    sortHelper(nums, lo, mid, temp, count)
    sortHelper(nums, mid + 1, hi, temp, count)
    merge(nums, lo, mid, hi, temp, count)
}

func merge(nums []int, lo, mid, hi int, temp []int, count *int) {
    // 先将 nums 中 [lo, hi] 的数复制到 temp 中
    for i := lo; i <= hi; i++ {
        temp[i] = nums[i]
    }

    // 进行效率优化，维护左闭右开区间 [mid+1, end) 中的元素乘 2 小于 nums[i]
    // 为什么 end 是开区间？因为这样的话可以保证初始区间 [mid+1, mid+1) 是一个空区间
    end := mid + 1
    for i := lo; i <= mid; i++ {
        // nums 中的元素可能较大，乘 2 可能溢出，所以转化成 int64
        for end <= hi && int64(nums[i]) > int64(nums[end]) * 2 {
            end++
        }
        *count += end - (mid + 1)
    }

    // 数组双指针技巧，合并两个有序数组
    i, j := lo, mid + 1
    for p := lo; p <= hi; p++ {
        if i == mid + 1 {
            nums[p] = temp[j]
            j++
        } else if j == hi + 1 {
            nums[p] = temp[i]
            i++
        } else if temp[i] > temp[j] {
            nums[p] = temp[j]
            j++
        } else {
            nums[p] = temp[i]
            i++
        }
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

var reversePairs = function(nums) {
    if (nums.length == 0) {
        return 0;
    }
    // 执行归并排序
    sort(nums);
    return count;
};

function sort(nums) {
    var temp = new Array(nums.length);
    var count = new Array(1);
    sortUtil(nums, 0, nums.length - 1, temp, count);
}

// 归并排序
function sortUtil(nums, lo, hi, temp, count) {
    if (lo == hi) {
        return;
    }
    var mid = parseInt(lo + (hi - lo) / 2);
    sortUtil(nums, lo, mid, temp, count);
    sortUtil(nums, mid + 1, hi, temp, count);
    merge(nums, lo, mid, hi, temp, count);
}

// 记录「翻转对」的个数
function merge(nums, lo, mid, hi, temp, count) {
    for (var i = lo; i <= hi; i++) {
        temp[i] = nums[i];
    }

    // 进行效率优化，维护左闭右开区间 [mid+1, end) 中的元素乘 2 小于 nums[i]
    // 为什么 end 是开区间？因为这样的话可以保证初始区间 [mid+1, mid+1) 是一个空区间
    var end = mid + 1;
    for (var i = lo; i <= mid; i++) {
        // nums 中的元素可能较大，乘 2 可能溢出，所以转化成 long
        while (end <= hi && nums[i] > nums[end]) {
            end++;
        }
        count[0] += end - (mid + 1);
    }

    // 数组双指针技巧，合并两个有序数组
    var i = lo, j = mid + 1;
    for (var p = lo; p <= hi; p++) {
        if (i == mid + 1) {
            nums[p] = temp[j++];
        } else if (j == hi + 1) {
            nums[p] = temp[i++];
        } else if (temp[i] > temp[j]) {
            nums[p] = temp[j++];
        } else {
            nums[p] = temp[i++];
        }
    }
}
```

</div></div>
</div></div>

</details>
</div>



