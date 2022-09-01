<p>Given a string <code>s</code>, remove duplicate letters so that every letter appears once and only once. You must make sure your result is <strong>the smallest in lexicographical order</strong> among all possible results.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;bcabc&quot;
<strong>Output:</strong> &quot;abc&quot;
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;cbacdcbc&quot;
<strong>Output:</strong> &quot;acdb&quot;
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

<div>👍 801, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.8](https://aep.h5.xeknow.com/s/1XJHEO) 持续更新中。**



<p><strong><a href="https://labuladong.github.io/article?qno=316" target="_blank">⭐️labuladong 题解</a></strong></p>
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

**类似题目**：
  - [1081. 不同字符的最小子序列 🟠](/problems/smallest-subsequence-of-distinct-characters)

</details>
</div>



