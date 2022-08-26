<p>Given an input string <code>s</code>, reverse the order of the <strong>words</strong>.</p>

<p>A <strong>word</strong> is defined as a sequence of non-space characters. The <strong>words</strong> in <code>s</code> will be separated by at least one space.</p>

<p>Return <em>a string of the words in reverse order concatenated by a single space.</em></p>

<p><b>Note</b> that <code>s</code> may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;the sky is blue&quot;
<strong>Output:</strong> &quot;blue is sky the&quot;
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;  hello world  &quot;
<strong>Output:</strong> &quot;world hello&quot;
<strong>Explanation:</strong> Your reversed string should not contain leading or trailing spaces.
</pre>

<p><strong>Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;a good   example&quot;
<strong>Output:</strong> &quot;example good a&quot;
<strong>Explanation:</strong> You need to reduce multiple spaces between two words to a single space in the reversed string.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> contains English letters (upper-case and lower-case), digits, and spaces <code>&#39; &#39;</code>.</li>
	<li>There is <strong>at least one</strong> word in <code>s</code>.</li>
</ul>

<p>&nbsp;</p>
<p><b data-stringify-type="bold">Follow-up:&nbsp;</b>If the string data type is mutable in your language, can&nbsp;you solve it&nbsp;<b data-stringify-type="bold">in-place</b>&nbsp;with&nbsp;<code data-stringify-type="code">O(1)</code>&nbsp;extra space?</p>
<details><summary><strong>Related Topics</strong></summary>双指针 | 字符串</details><br>

<div>👍 635, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.8](https://aep.h5.xeknow.com/s/1XJHEO) 持续更新中。**



<p><strong><a href="https://labuladong.github.io/article?qno=151" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

常规方法是用类似 `split` 再 `reverse` 最后 `join` 的方法得到结果，但更巧妙的方法是我在 [二维数组的花式遍历](https://labuladong.github.io/article/fname.html?fname=花式遍历) 中讲到的：**先把整个字符串进行翻转，再把每个单词中的字母翻转**。

比如说，给你输入这样一个字符串：

```shell
s = "hello world labuladong"
```

那么我们先将整个字符串 `s` 反转：

```shell
s = "gnodalubal dlrow olleh"
```

**然后将每个单词分别反转**：

```shell
s = "labuladong world hello"
```

这样，就实现了原地反转所有单词顺序的目的。

整体的思路应该不难，就是细节比较恶心，直接看我写的代码吧。

**详细题解：[二维数组的花式遍历技巧](https://labuladong.github.io/article/fname.html?fname=花式遍历)**

**标签：字符串，[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

## 解法代码

```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        // 先清洗一下数据，把多于的空格都删掉
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                // 单词中的字母/数字
                sb.append(c);
            } else if (!sb.isEmpty() && sb.charAt(sb.length() - 1) != ' ') {
                // 单词之间保留一个空格
                sb.append(' ');
            }
        }
        // 末尾如果有空格，清除之
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // 清洗之后的字符串
        char[] chars = sb.toString().toCharArray();
        int n = chars.length;
        // 进行单词的翻转，先整体翻转
        reverse(chars, 0, n - 1);
        // 再把每个单词翻转
        for (int i = 0; i < n; ) {
            for (int j = i; j < n; j++) {
                if (j + 1 == n || chars[j + 1] == ' ') {
                    // chars[i..j] 是一个单词，翻转之
                    reverse(chars, i, j);
                    // 把 i 置为下一个单词的首字母
                    i = j + 2;
                    break;
                }
            }
        }
        // 最后得到题目想要的结果
        return new String(chars);
    }

    // 翻转 arr[i..j]
    void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
```

**类似题目**：
  - [1260. 二维网格迁移 🟢](/problems/shift-2d-grid)
  - [48. 旋转图像 🟠](/problems/rotate-image)
  - [54. 螺旋矩阵 🟠](/problems/spiral-matrix)
  - [59. 螺旋矩阵 II 🟠](/problems/spiral-matrix-ii)
  - [剑指 Offer 29. 顺时针打印矩阵 🟢](/problems/shun-shi-zhen-da-yin-ju-zhen-lcof)

</details>
</div>



