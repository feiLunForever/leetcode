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

<div>👍 969, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=remove-duplicate-letters" target="_blank">⭐️labuladong 题解</a></strong></p>
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
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

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

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_remove-duplicate-letters" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-duplicate-letters"></div></div>
</details><hr /><br />

**类似题目**：
  - [1081. 不同字符的最小子序列 🟠](/problems/smallest-subsequence-of-distinct-characters)

</details>
</div>



