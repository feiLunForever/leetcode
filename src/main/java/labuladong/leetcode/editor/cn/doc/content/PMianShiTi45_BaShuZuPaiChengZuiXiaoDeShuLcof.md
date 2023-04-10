English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>贪心 | 字符串 | 排序</details><br>

<div>👍 627, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 19 期刷题打卡](https://aep.xet.tech/s/32wqt4) 开始报名。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这个题比较简单，想让结果最小，肯定是让最高位的数字尽可能小嘛。所以我们只要按照特殊规则对整个数组排序就可以了：

1、最高位最小的那个数字排在前面。

2、如果最高位的数字相同，那么次高位的数字较小的排在前面，如果次高位数字也相同，就比较次次高位，以此类推。

一个取巧的办法是把 `nums` 中的元素转换成字符串，然后通过字符串拼接的方式进行大小比较，具体看代码吧。

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

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
    string minNumber(vector<int>& nums) {
        int n = nums.size();
        vector<string> strs(n);
        for (int i = 0; i < n; i++) {
            strs[i] = to_string(nums[i]);
        }
        sort(strs.begin(), strs.end(), [](const string& s1, const string& s2) {
            // 看看那种拼接方式得到的数字更小，排前面
            // 不用转成 int 类型，因为字符串的比较算法和正整数的比较算法是一样的
            // 而且拼接字符串比较长，会导致 int 类型溢出
            return (s1 + s2) < (s2 + s1);
        });

        return accumulate(strs.begin(), strs.end(), string(""));
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def minNumber(self, nums: List[int]) -> str:
        n = len(nums)
        strs = [str(num) for num in nums]

        def compare(s1: str, s2: str) -> int:
            # 看看那种拼接方式得到的数字更小，排前面
            # 不用转成 int 类型，因为字符串的比较算法和正整数的比较算法是一样的
            # 而且拼接字符串比较长，会导致 int 类型溢出
            return -1 if s1 + s2 < s2 + s1 else 1

        strs.sort(key=functools.cmp_to_key(compare))

        return ''.join(strs)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, (s1, s2) -> {
            // 看看那种拼接方式得到的数字更小，排前面
            // 不用转成 int 类型，因为字符串的比较算法和正整数的比较算法是一样的
            // 而且拼接字符串比较长，会导致 int 类型溢出
            return (s1 + s2).compareTo(s2 + s1);
        });

        return String.join("", strs);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func minNumber(nums []int) string {
    n := len(nums)
    strs := make([]string, n)
    for i := 0; i < n; i++ {
        strs[i] = strconv.Itoa(nums[i])
    }
    sort.Slice(strs, func(i, j int) bool {
        // 看看那种拼接方式得到的数字更小，排前面
        // 不用转成 int 类型，因为字符串的比较算法和正整数的比较算法是一样的
        // 而且拼接字符串比较长，会导致 int 类型溢出
        return strs[i]+strs[j] < strs[j]+strs[i]
    })

    return strings.Join(strs, "")
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var minNumber = function(nums) {
    const n = nums.length;
    const strs = new Array(n);
    for (let i = 0; i < n; i++) {
        strs[i] = nums[i].toString();
    }
    strs.sort((s1, s2) => {
        // 看看那种拼接方式得到的数字更小，排前面
        // 不用转成 int 类型，因为字符串的比较算法和正整数的比较算法是一样的
        // 而且拼接字符串比较长，会导致 int 类型溢出
        return (s1 + s2).localeCompare(s2 + s1);
    });

    return strs.join("");
}
```

</div></div>
</div></div>

</details>
</div>



