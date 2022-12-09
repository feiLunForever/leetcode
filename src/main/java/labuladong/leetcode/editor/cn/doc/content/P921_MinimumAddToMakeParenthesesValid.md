<p>A parentheses string is valid if and only if:</p>

<ul> 
 <li>It is the empty string,</li> 
 <li>It can be written as <code>AB</code> (<code>A</code> concatenated with <code>B</code>), where <code>A</code> and <code>B</code> are valid strings, or</li> 
 <li>It can be written as <code>(A)</code>, where <code>A</code> is a valid string.</li> 
</ul>

<p>You are given a parentheses string <code>s</code>. In one move, you can insert a parenthesis at any position of the string.</p>

<ul> 
 <li>For example, if <code>s = "()))"</code>, you can insert an opening parenthesis to be <code>"(<strong>(</strong>)))"</code> or a closing parenthesis to be <code>"())<strong>)</strong>)"</code>.</li> 
</ul>

<p>Return <em>the minimum number of moves required to make </em><code>s</code><em> valid</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = "())"
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = "((("
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 1000</code></li> 
 <li><code>s[i]</code> is either <code>'('</code> or <code>')'</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>栈 | 贪心 | 字符串</details><br>

<div>👍 234, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0。**



<p><strong><a href="https://labuladong.github.io/article?qno=921" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

核心思路是以左括号为基准，通过维护对右括号的需求数 `need`，来计算最小的插入次数。

**详细题解：[如何解决括号相关的问题](https://labuladong.github.io/article/fname.html?fname=括号插入)**

**标签：括号问题**

## 解法代码

```java
class Solution {
    public int minAddToMakeValid(String s) {
        // res 记录插入次数
        int res = 0;
        // need 变量记录右括号的需求量
        int need = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 对右括号的需求 + 1
                need++;
            }

            if (s.charAt(i) == ')') {
                // 对右括号的需求 - 1
                need--;

                if (need == -1) {
                    need = 0;
                    // 需插入一个左括号
                    res++;
                }
            }
        }

        return res + need;
    }
}
```

**类似题目**：
  - [1541. 平衡括号字符串的最少插入次数 🟠](/problems/minimum-insertions-to-balance-a-parentheses-string)
  - [20. 有效的括号 🟢](/problems/valid-parentheses)

</details>
</div>



