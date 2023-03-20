English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>数学 | 二分查找</details><br>

<div>👍 327, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。[第 18 期每日打卡](https://aep.xet.tech/s/2PLO1n) 开始报名。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [400. 第 N 位数字](/problems/nth-digit) 基本相同，只是这里的 `n` 是从 0 开始的，但数字序列也是从 0 开始的，所以只要特殊处理一下 0 就可以。具体的思路可以看我在第 400 题中写的思路提示，这里就不多说了。

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

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
    int findNthDigit(int n) {
        if (n == 0) {
            return 0;
        }
        return findNthDigit_100(n);
    }

    // 第 400 题的解法代码
    int findNthDigit_400(int n) {
        // 位数（一位数，两位数...）
        int digit = 1;
        // 1,10,100, 1000 这样的后缀
        long base = 1;

        while (n > 9 * base * digit) {
            n -= 9 * base * digit;
            base *= 10;
            digit++;
        }

        // 此时假设 base = 1000，那么说明 n 是 100~999 中的某个三位数的某一位
        // 哪个三位数呢？这样算：
        long val = base + (n - 1) / digit;
        // 是这个三位数的第几位呢？这样算：
        int index = (n - 1) % digit;

        // 怎么把 val 的第 index 这一位数字抠出来呢？这样算：
        return (to_string(val))[index] - '0';
    }

    int findNthDigit_100(int n) {
        // 按位计数是从 0 开始的，故需先 -1
        n--;

        for (int bit = 1; bit <= 11; bit++) {
            int firstNum = pow(10, bit - 1);
            int lastNum = pow(10, bit) - 1;
            int bitNums = lastNum - firstNum + 1;
            int totalNums = bitNums * bit;
            if (n < totalNums) {
                int numTimes = n / bit;
                int numIndex = n % bit;
                int targetNum = firstNum + numTimes;
                string targetStr = to_string(targetNum);
                return targetStr[numIndex] - '0';
            }
            n -= totalNums;
        }
        return -1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

class Solution:
    def findNthDigit(self, n: int) -> int:
        if n == 0:
            return 0
        return self.findNthDigit_400(n)

    # 第 400 题的解法代码
    def findNthDigit_400(self, n: int) -> int:
        # 位数（一位数，两位数...）
        digit = 1
        # 1,10,100, 1000 这样的后缀
        base = 1

        while n > 9 * base * digit:
            n -= 9 * base * digit
            base *= 10
            digit += 1

        # 此时假设 base = 1000，那么说明 n 是 100~999 中的某个三位数的某一位
        # 哪个三位数呢？这样算：
        val = base + (n - 1) // digit
        # 是这个三位数的第几位呢？这样算：
        index = (n - 1) % digit

        # 怎么把 val 的第 index 这一位数字抠出来呢？这样算：
        return int(str(val)[index])
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int findNthDigit(int n) {
        if (n == 0) {
            return 0;
        }
        return findNthDigit_100(n);
    }

    // 第 400 题的解法代码
    int findNthDigit_400(int n) {
        // 位数（一位数，两位数...）
        int digit = 1;
        // 1,10,100, 1000 这样的后缀
        long base = 1;

        while (n > 9 * base * digit) {
            n -= 9 * base * digit;
            base *= 10;
            digit++;
        }

        // 此时假设 base = 1000，那么说明 n 是 100~999 中的某个三位数的某一位
        // 哪个三位数呢？这样算：
        long val = base + (n - 1) / digit;
        // 是这个三位数的第几位呢？这样算：
        int index = (n - 1) % digit;

        // 怎么把 val 的第 index 这一位数字抠出来呢？这样算：
        return ("" + val).charAt(index) - '0';
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

import "strconv"

func findNthDigit(n int) int {
	if n == 0 {
		return 0
	}
	return findNthDigit400(n)
}

// 第 400 题的解法代码
func findNthDigit400(n int) int {
	// 位数（一位数，两位数...）
	digit := 1
	// 1,10,100, 1000 这样的后缀
	base := 1
	for n > 9*base*digit {
		n -= 9 * base * digit
		base *= 10
		digit++
	}

	// 此时假设 base = 1000，那么说明 n 是 100~999 中的某个三位数的某一位
	// 哪个三位数呢？这样算：
	val := base + (n-1)/digit
	// 是这个三位数的第几位呢？这样算：
	index := (n - 1) % digit
	// 怎么把 val 的第 index 这一位数字抠出来呢？这样算：
	return int(strconv.Itoa(val)[index] - '0')
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

/**
 * @param {number} n
 * @return {number}
 */
var findNthDigit = function(n) {
    if (n == 0) {
        return 0;
    }
    return findNthDigit_100(n);
};

// 第 400 题的解法代码
var findNthDigit_400 = function(n) {
    // 位数（一位数，两位数...）
    var digit = 1;
    // 1,10,100, 1000 这样的后缀
    var base = 1;

    while (n > 9 * base * digit) {
        n -= 9 * base * digit;
        base *= 10;
        digit++;
    }

    // 此时假设 base = 1000，那么说明 n 是 100~999 中的某个三位数的某一位
    // 哪个三位数呢？这样算：
    var val = base + Math.floor((n - 1) / digit);
    // 是这个三位数的第几位呢？这样算：
    var index = (n - 1) % digit;

    // 怎么把 val 的第 index 这一位数字抠出来呢？这样算：
    return parseInt(("" + val).charAt(index));
};
```

</div></div>
</div></div>

</details>
</div>



