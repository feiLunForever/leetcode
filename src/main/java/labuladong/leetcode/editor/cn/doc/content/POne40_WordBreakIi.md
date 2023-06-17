<p>Given a string <code>s</code> and a dictionary of strings <code>wordDict</code>, add spaces in <code>s</code> to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in <strong>any order</strong>.</p>

<p><strong>Note</strong> that the same word in the dictionary may be reused multiple times in the segmentation.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
<strong>Output:</strong> ["cats and dog","cat sand dog"]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
<strong>Output:</strong> ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
<strong>Explanation:</strong> Note that you are allowed to reuse a dictionary word.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 20</code></li> 
 <li><code>1 &lt;= wordDict.length &lt;= 1000</code></li> 
 <li><code>1 &lt;= wordDict[i].length &lt;= 10</code></li> 
 <li><code>s</code> and <code>wordDict[i]</code> consist of only lowercase English letters.</li> 
 <li>All the strings of <code>wordDict</code> are <strong>unique</strong>.</li> 
 <li>Input is generated in a way that the length of the answer doesn't exceed&nbsp;10<sup>5</sup>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字典树 | 记忆化搜索 | 数组 | 哈希表 | 字符串 | 动态规划 | 回溯</details><br>

<div>👍 694, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=word-break-ii" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

上一题 [139. 单词拆分](/problems/word-break) 可以被归为动态规划类问题，因为可以把原问题分解成规模更小的问题，且存在重叠子问题，需要动态规划技巧去优化。

而这道题就是一道纯粹的回溯算法问题了，你直接穷举所有可能的拼接方式，把能够拼出 `s` 的拼接方式存下来即可。

穷举思路和上一题类似，根据 [回溯算法详解](https://labuladong.github.io/article/fname.html?fname=回溯算法详解修订版) 给出框架稍作修改即可：

```js
function 拼凑(s, wordDict) {
    for (word in wordDict) {
        if (word 是 s 的前缀) {
            // 做选择
            拼凑(去掉 word 前缀的 s, wordDict)
            // 撤销选择
        }
    }
}
```

直接看解法代码吧。

**详细题解：[动态规划和回溯算法的思维转换](https://labuladong.github.io/article/fname.html?fname=单词拼接)**

**标签：[回溯算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)**

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
    vector<string> res;
    // 记录回溯路径
    deque<string> track;

    vector<string> wordBreak(string s, vector<string>& wordDict) {
        // 根据函数定义，判断 s[0..] 是否能够被拼出
        backtrack(s, 0, wordDict);
        return res;
    }

    // 回溯算法框架
    void backtrack(string s, int i, vector<string>& wordDict) {
        // base case，整个 s 都被拼出来了
        if (i == s.length()) {
            res.emplace_back(track[0]);
            for (int j = 1; j < track.size(); ++j) {
                res.back() += " " + track[j];
            }
            return;
        }
        if (i > s.length()) {
            return;
        }

        // 遍历所有单词，尝试匹配 s[i..] 的前缀
        for (const string& word : wordDict) {
            int len = word.length();
            // 单词太长，跳过
            if (i + len > s.length()) {
                continue;
            }
            // 无法匹配，跳过
            string subStr = s.substr(i, len);
            if (subStr != word) {
                continue;
            }
            // s[i..] 的前缀被 word 匹配，做选择
            track.emplace_back(word);
            backtrack(s, i + len, wordDict);
            // 撤销选择
            track.pop_back();
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
    def __init__(self):
        self.res = []
        # 记录回溯路径
        self.track = []

    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        # 根据函数定义，判断 s[0..] 是否能够被拼出
        self.backtrack(s, 0, wordDict)
        return self.res

    # 回溯算法框架
    def backtrack(self, s: str, i: int, wordDict: List[str]) -> None:
        # base case，整个 s 都被拼出来了
        if i == len(s):
            self.res.append(" ".join(self.track))
            return
        if i > len(s):
            return

        # 遍历所有单词，尝试匹配 s[i..] 的前缀
        for word in wordDict:
            length = len(word)
            # 单词太长，跳过
            if i + length > len(s):
                continue
            # 无法匹配，跳过
            sub_str = s[i:i + length]
            if sub_str != word:
                continue
            # s[i..] 的前缀被 word 匹配，做选择
            self.track.append(word)
            self.backtrack(s, i + length, wordDict)
            # 撤销选择
            self.track.pop()
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    List<String> res = new LinkedList<>();
    // 记录回溯路径
    LinkedList<String> track = new LinkedList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        // 根据函数定义，判断 s[0..] 是否能够被拼出
        backtrack(s, 0, wordDict);
        return res;
    }

    // 回溯算法框架
    void backtrack(String s, int i, List<String> wordDict) {
        // base case，整个 s 都被拼出来了
        if (i == s.length()) {
            res.add(String.join(" ", track));
            return;
        }
        if (i > s.length()) {
            return;
        }

        // 遍历所有单词，尝试匹配 s[i..] 的前缀
        for (String word : wordDict) {
            int len = word.length();
            // 单词太长，跳过
            if (i + len > s.length()) {
                continue;
            }
            // 无法匹配，跳过
            String subStr = s.substring(i, i + len);
            if (!subStr.equals(word)) {
                continue;
            }
            // s[i..] 的前缀被 word 匹配，做选择
            track.addLast(word);
            backtrack(s, i + len, wordDict);
            // 撤销选择
            track.removeLast();
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

func wordBreak(s string, wordDict []string) []string {
    res := []string{}
    // 记录回溯路径
    track := []string{}
    // 根据函数定义，判断 s[0..] 是否能够被拼出
    backtrack(s, 0, wordDict, &track, &res)
    return res
}

// 回溯算法框架
func backtrack(s string, i int, wordDict []string, track *[]string, res *[]string) {
    // base case，整个 s 都被拼出来了
    if i == len(s) {
        *res = append(*res, strings.Join(*track, " "))
        return
    }
    if i > len(s) {
        return
    }

    // 遍历所有单词，尝试匹配 s[i..] 的前缀
    for _, word := range(wordDict) {
        len := len(word)
        // 单词太长，跳过
        if i + len > len(s) {
            continue
        }
        // 无法匹配，跳过
        subStr := s[i:i+len]
        if subStr != word {
            continue
        }
        // s[i..] 的前缀被 word 匹配，做选择
        *track = append(*track, word)
        backtrack(s, i + len, wordDict, track, res)
        // 撤销选择
        *track = (*track)[:len(*track)-1]
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var wordBreak = function(s, wordDict) {
  let res = [];  // 记录结果
  let track = []; // 记录回溯路径

  // 回溯算法框架
  function backtrack(s, i, wordDict) {
    // base case，整个 s 都被拼出来了
    if (i === s.length) {
      res.push(track.join(" "));
      return;
    }
    if (i > s.length) {
      return;
    }

    // 遍历所有单词，尝试匹配 s[i..] 的前缀
    for (let word of wordDict) {
      let len = word.length;
      // 单词太长，跳过
      if (i + len > s.length) {
        continue;
      }
      // 无法匹配，跳过
      let subStr = s.substring(i, i + len);
      if (subStr !== word) {
        continue;
      }
      // s[i..] 的前缀被 word 匹配，做选择
      track.push(word);
      backtrack(s, i + len, wordDict);
      // 撤销选择
      track.pop();
    }
  }

  backtrack(s, 0, wordDict);
  return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_word-break-ii" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_word-break-ii"></div></div>
</details><hr /><br />

**类似题目**：
  - [139. 单词拆分 🟠](/problems/word-break)

</details>
</div>



