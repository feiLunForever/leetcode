<p>English description is not available for the problem. Please switch to Chinese.</p>

<details><summary><strong>Related Topics</strong></summary>双指针 | 字符串</details><br>

<div>👍 279, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 开始报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=fan-zhuan-dan-ci-shun-xu-lcof" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [151. 颠倒字符串中的单词](/problems/reverse-words-in-a-string) 相同。

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
    string reverseWords(string s) {
        // 先清洗一下数据，把多于的空格都删掉
        string sb;
        for (int i = 0; i < s.length(); i++) {
            char c = s[i];
            if (c != ' ') {
                // 单词中的字母/数字
                sb += c;
            } else if (!sb.empty() && sb[sb.length() - 1] != ' ') {
                // 单词之间保留一个空格
                sb += ' ';
            }
        }
        if (sb.empty()) {
            return "";
        }
        // 末尾如果有空格，清除之
        if (sb[sb.length() - 1] == ' ') {
            sb.erase(sb.length() - 1, 1);
        }

        // 清洗之后的字符串
        char* chars = new char[sb.length() + 1];
        strcpy(chars, sb.c_str());
        int n = strlen(chars);
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
        string res(chars);
        delete[] chars;
        return res;
    }

    // 翻转 arr[i..j]
    void reverse(char* arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def reverseWords(self, s: str) -> str:
        # 先清洗一下数据，把多于的空格都删掉
        sb = []
        for c in s:
            if c != ' ':
                # 单词中的字母/数字
                sb.append(c)
            elif sb and sb[-1] != ' ':
                # 单词之间保留一个空格
                sb.append(' ')
        if not sb:
            return ""
        # 末尾如果有空格，清除之
        if sb[-1] == ' ':
            sb.pop()

        # 清洗之后的字符串
        chars = ''.join(sb)
        chars = list(chars)
        n = len(chars)
        # 进行单词的翻转，先整体翻转
        self.reverse(chars, 0, n - 1)
        # 再把每个单词翻转
        i = 0
        while i < n:
            j = i
            while j < n:
                if j + 1 == n or chars[j + 1] == ' ':
                    # chars[i..j] 是一个单词，翻转之
                    self.reverse(chars, i, j)
                    # 把 i 置为下一个单词的首字母
                    i = j + 2
                    break
                j += 1
        # 最后得到题目想要的结果
        return ''.join(chars)

    # 翻转 arr[i..j]
    def reverse(self, arr, i, j):
        while i < j:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

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
        if (sb.isEmpty()) {
            return "";
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

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

func reverseWords(s string) string {
    var sb strings.Builder
    // 先清洗一下数据，把多余的空格都删掉
    for i := 0; i < len(s); i++ {
        c := s[i]
        if c != ' ' {
            // 单词中的字母/数字
            sb.WriteByte(c)
        } else if sb.Len() > 0 && sb.String()[sb.Len()-1] != ' ' {
            // 单词之间保留一个空格
            sb.WriteByte(' ')
        }
    }
    // 末尾如果有空格，清除之
    if sb.Len() > 0 && sb.String()[sb.Len()-1] == ' ' {
        sb.Truncate(sb.Len() - 1)
    }

    // 清洗之后的字符串
    chars := []byte(sb.String())
    n := len(chars)
    // 进行单词的翻转，先整体翻转
    reverse := func(arr []byte, i int, j int) {
        for i < j {
            arr[i], arr[j] = arr[j], arr[i]
            i++
            j--
        }
    }
    reverse(chars, 0, n-1)
    // 再把每个单词翻转
    for i := 0; i < n; {
        for j := i; j < n; j++ {
            if j+1 == n || chars[j+1] == ' ' {
                // chars[i..j] 是一个单词，翻转之
                reverse(chars, i, j)
                // 把 i 置为下一个单词的首字母
                i = j + 2
                break
            }
        }
    }
    // 最后得到题目想要的结果
    return string(chars)
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
var reverseWords = function(s) {
  let sb = "";
  // 先清洗一下数据，把多于的空格都删掉
  for (let i = 0; i < s.length; i++) {
    let c = s.charAt(i);
    if (c !== ' ') {
      // 单词中的字母/数字
      sb += c;
    } else if (sb.length > 0 && sb.charAt(sb.length - 1) !== ' ') {
      // 单词之间保留一个空格
      sb += ' ';
    }
  }
  // 末尾如果有空格，清除之
  if (sb.charAt(sb.length - 1) === ' ') {
    sb = sb.slice(0, sb.length - 1);
  }

  // 清洗之后的字符串
  let chars = sb.split('');
  let n = chars.length;
  // 进行单词的翻转，先整体翻转
  reverse(chars, 0, n - 1);
  // 再把每个单词翻转
  for (let i = 0; i < n; ) {
    for (let j = i; j < n; j++) {
      if (j + 1 === n || chars[j + 1] === ' ') {
        // chars[i..j] 是一个单词，翻转之
        reverse(chars, i, j);
        // 把 i 置为下一个单词的首字母
        i = j + 2;
        break;
      }
    }
  }
  // 最后得到题目想要的结果
  return chars.join('');
};

// 翻转 arr[i..j]
function reverse(arr, i, j) {
  while (i < j) {
    let temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    i++;
    j--;
  }
}
```

</div></div>
</div></div>

<details open><summary><strong>👉 算法可视化 👈</strong></summary><div class="resizable aspect-ratio-container" style="height: 70vh;">
    <iframe src="https://labuladong.github.io/algo-visualize/" width="100%"
    height="100%" scrolling="auto" frameborder="0"
    style="overflow: auto;" id="iframe_reverse-words-in-a-string"></iframe>
</div>
<div id="data_reverse-words-in-a-string" data="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"></div></details><hr /><br />

**类似题目**：
  - [1260. 二维网格迁移 🟢](/problems/shift-2d-grid)
  - [48. 旋转图像 🟠](/problems/rotate-image)
  - [54. 螺旋矩阵 🟠](/problems/spiral-matrix)
  - [59. 螺旋矩阵 II 🟠](/problems/spiral-matrix-ii)
  - [剑指 Offer 29. 顺时针打印矩阵 🟢](/problems/shun-shi-zhen-da-yin-ju-zhen-lcof)
  - [剑指 Offer 58 - I. 翻转单词顺序 🟢](/problems/fan-zhuan-dan-ci-shun-xu-lcof)

</details>
</div>





