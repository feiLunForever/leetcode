<p>Given a string <code>s</code>, remove duplicate letters so that every letter appears once and only once. You must make sure your result is <span data-keyword="lexicographically-smaller-string"><strong>the smallest in lexicographical order</strong></span> among all possible results.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = "bcabc"
<strong>Output:</strong> "abc"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = "cbacdcbc"
<strong>Output:</strong> "acdb"
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>s</code> consists of lowercase English letters.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Note:</strong> This question is the same as 1081: <a href="https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/" target="_blank">https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/</a></p>

<details><summary><strong>Related Topics</strong></summary>栈 | 贪心 | 字符串 | 单调栈</details><br>

<div>👍 910, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。[第 18 期每日打卡](https://aep.xet.tech/s/2PLO1n) 最后一天报名。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=remove-duplicate-letters" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

要求一、**要去重**。

要求二、去重字符串中的字符顺序**不能打乱 `s` 中字符出现的相对顺序**。

要求三、在所有符合上一条要求的去重字符串中，**字典序最小**的作为最终结果。

要利用 `stack` 结构和一个 `inStack` 布尔数组来满足上述三个条件，具体思路如下：

通过 `inStack` 这个布尔数组做到栈 `stk` 中不存在重复元素，满足要求一。

我们顺序遍历字符串 `s`，通过「栈」这种顺序结构的 push/pop 操作记录结果字符串，保证了字符出现的顺序和 `s` 中出现的顺序一致，满足要求二。

我们用类似单调栈的思路，配合计数器 `count` 不断 pop 掉不符合最小字典序的字符，保证了最终得到的结果字典序最小，满足要求三。

**详细题解：[一道数组去重的算法题把我整不会了](https://labuladong.github.io/article/fname.html?fname=单调栈去重)**

**标签：字符串，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)**

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
    string removeDuplicateLetters(string s) {
        stack<char> stk;

        // 维护一个计数器记录字符串中字符的数量
        // 因为输入为 ASCII 字符，大小 256 够用了
        int count[256] = {0};
        for (int i = 0; i < s.length(); i++) {
            count[s[i]]++;
        }

        bool inStack[256] = {false};
        for (char c : s) {
            // 每遍历过一个字符，都将对应的计数减一
            count[c]--;

            if (inStack[c]) continue;

            while (!stk.empty() && stk.top() > c) {
                // 若之后不存在栈顶元素了，则停止 pop
                if (count[stk.top()] == 0) {
                    break;
                }
                // 若之后还有，则可以 pop
                inStack[stk.top()] = false;
                stk.pop();
            }
            stk.push(c);
            inStack[c] = true;
        }

        string res;
        while (!stk.empty()) {
            res.push_back(stk.top());
            stk.pop();
        }
        reverse(res.begin(), res.end());
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        stk = []

        # 维护一个计数器记录字符串中字符的数量
        # 因为输入为 ASCII 字符，大小 256 够用了
        count = [0] * 256
        for i in range(len(s)):
            count[ord(s[i])] += 1

        inStack = [False] * 256
        for c in s:
            # 每遍历过一个字符，都将对应的计数减一
            count[ord(c)] -= 1

            if inStack[ord(c)]:
                continue

            while len(stk) > 0 and stk[-1] > c:
                # 若之后不存在栈顶元素了，则停止 pop
                if count[ord(stk[-1])] == 0:
                    break
                # 若之后还有，则可以 pop
                inStack[ord(stk.pop())] = False
            stk.append(c)
            inStack[ord(c)] = True

        sb = []
        while len(stk) > 0:
            sb.append(stk.pop())
        return "".join(sb)[::-1]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stk = new Stack<>();

        // 维护一个计数器记录字符串中字符的数量
        // 因为输入为 ASCII 字符，大小 256 够用了
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            // 每遍历过一个字符，都将对应的计数减一
            count[c]--;

            if (inStack[c]) continue;

            while (!stk.isEmpty() && stk.peek() > c) {
                // 若之后不存在栈顶元素了，则停止 pop
                if (count[stk.peek()] == 0) {
                    break;
                }
                // 若之后还有，则可以 pop
                inStack[stk.pop()] = false;
            }
            stk.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.empty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func removeDuplicateLetters(s string) string {
    stk := []rune{}

    // 维护一个计数器记录字符串中字符的数量
    // 因为输入为 ASCII 字符，大小 256 够用了
    count := [256]int{}
    for _, c := range s {
        count[c]++
    }

    inStack := [256]bool{}
    for _, c := range s {
        // 每遍历过一个字符，都将对应的计数减一
        count[c]--

        if inStack[c] {
            continue
        }

        for len(stk) > 0 && stk[len(stk)-1] > c {
            // 若之后不存在栈顶元素了，则停止 pop
            if count[stk[len(stk)-1]] == 0 {
                break
            }
            // 若之后还有，则可以 pop
            inStack[stk[len(stk)-1]] = false
            stk = stk[:len(stk)-1]
        }
        stk = append(stk, c)
        inStack[c] = true
    }

    sb := strings.Builder{}
    for i := len(stk) - 1; i >= 0; i-- {
        sb.WriteRune(stk[i])
    }
    return sb.String()
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

/**
 * @param {string} s
 * @return {string}
 */
var removeDuplicateLetters = function(s) {
    let stk = [];

    // 维护一个计数器记录字符串中字符的数量
    // 因为输入为 ASCII 字符，大小 256 够用了
    let count = Array(256).fill(0);
    for (let i = 0; i < s.length; i++) {
        count[s.charCodeAt(i)]++;
    }

    let inStack = Array(256).fill(false);
    for (let i = 0; i < s.length; i++) {
        let c = s.charAt(i);
        // 每遍历过一个字符，都将对应的计数减一
        count[c.charCodeAt(0)]--;

        if (inStack[c.charCodeAt(0)]) continue;

        while (stk.length > 0 && stk[stk.length - 1] > c) {
            // 若之后不存在栈顶元素了，则停止 pop
            if (count[stk[stk.length - 1].charCodeAt(0)] == 0) {
                break;
            }
            // 若之后还有，则可以 pop
            inStack[stk.pop().charCodeAt(0)] = false;
        }
        stk.push(c);
        inStack[c.charCodeAt(0)] = true;
    }

    let sb = "";
    while (stk.length > 0) {
        sb += stk.pop();
    }
    return sb.split("").reverse().join("");
};
```

</div></div>
</div></div>

**类似题目**：
  - [1081. 不同字符的最小子序列 🟠](/problems/smallest-subsequence-of-distinct-characters)

</details>
</div>



