English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>位运算 | 数学</details><br>

<div>👍 409, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这是位运算的经典场景，也是计算机执行加法运算的逻辑。十进制加法中我们先把每一位对齐，然后每一位相加，和大于等于 10 的话给下一位进一。

二进制的加法运算和十进制类似，也是每一位相加，和大于等于 2 的话进一位，只不过二进制数求和及进位的操作是用位运算来实现的。

异或运算 `^` 的结果可以理解为对应位相加，且运算 `&` 的结果左移一位可以理解为进位的结果，看代码中的示例比较好理解。

**标签：[位运算](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

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
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution {
public:
    int add(int a, int b) {
        if (a == 0 || b == 0) {
            return a == 0 ? b : a;
        }
        // 设 a = 1001
        // 设 b = 0101
        // 求和 1100
        int sum = a ^ b;
        // 进位 0001 << 1 = 0010
        int carry = (a & b) << 1;
        // add(1100, 0010)
        return add(sum, carry);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution:
    def add(self, a: int, b: int) -> int:
        if a == 0 or b == 0:
            return b if a == 0 else a
        # 设 a = 1001
        # 设 b = 0101
        # 求和 1100
        sum = a ^ b
        # 进位 0001 << 1 = 0010
        carry = (a & b) << 1
        # add(1100, 0010)
        return self.add(sum, carry)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int add(int a, int b) {
        if(a == 0 || b == 0) {
            return a == 0 ? b : a;
        }
        // 设 a = 1001
        // 设 b = 0101
        // 求和 1100
        int sum = a ^ b;
        // 进位 0001 << 1 = 0010
        int carry = (a & b) << 1;
        // add(1100, 0010)
        return add(sum, carry);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func add(a int, b int) int {
    if a == 0 || b == 0 {
        if a == 0 {
            return b
        } else {
            return a
        }
    }

    // 设 a = 1001
    // 设 b = 0101
    // 求和 1100
    sum := a ^ b

    // 进位 0001 << 1 = 0010
    carry := (a & b) << 1

    // add(1100, 0010)
    return add(sum, carry)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var add = function(a, b) {
    if (a == 0 || b == 0) {
        return a == 0 ? b : a;
    }
    // 设 a = 1001
    // 设 b = 0101
    // 求和 1100
    let sum = a ^ b;
    // 进位 0001 << 1 = 0010
    let carry = (a & b) << 1;
    // add(1100, 0010)
    return add(sum, carry);
};
```

</div></div>
</div></div>

</details>
</div>



