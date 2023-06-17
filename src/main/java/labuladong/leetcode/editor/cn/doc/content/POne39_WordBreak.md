<p>Given a string <code>s</code> and a dictionary of strings <code>wordDict</code>, return <code>true</code> if <code>s</code> can be segmented into a space-separated sequence of one or more dictionary words.</p>

<p><strong>Note</strong> that the same word in the dictionary may be reused multiple times in the segmentation.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = "leetcode", wordDict = ["leet","code"]
<strong>Output:</strong> true
<strong>Explanation:</strong> Return true because "leetcode" can be segmented as "leet code".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = "applepenapple", wordDict = ["apple","pen"]
<strong>Output:</strong> true
<strong>Explanation:</strong> Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 300</code></li> 
 <li><code>1 &lt;= wordDict.length &lt;= 1000</code></li> 
 <li><code>1 &lt;= wordDict[i].length &lt;= 20</code></li> 
 <li><code>s</code> and <code>wordDict[i]</code> consist of only lowercase English letters.</li> 
 <li>All the strings of <code>wordDict</code> are <strong>unique</strong>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字典树 | 记忆化搜索 | 数组 | 哈希表 | 字符串 | 动态规划</details><br>

<div>👍 2165, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=word-break" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

关于动态规划的解题步骤和思维方法见前文 [动态规划核心套路](https://labuladong.github.io/article/fname.html?fname=动态规划详解进阶) 和 [动态规划答疑篇](https://labuladong.github.io/article/fname.html?fname=最优子结构)，这里就不赘述了，直接说说状态转移方程怎么找。

让你判断 `s` 是否能被分解成 `wordDict` 中的单词，反过来想就是判断 `wordDict` 中的单词是否能拼出 `s`，那么暴力穷举的思路就是：

```js
function 拼凑(s, wordDict) {
    for (word in wordDict) {
        if (word 是 s 的前缀) {
            拼凑(去掉 word 前缀的 s, wordDict)
        }
    }
}
```

于是，我们可以定义一个 `dp` 函数：

```java
// 定义：返回 s[i..] 是否能够被 wordDict 拼出
boolean dp(String s, int i, List<String> wordDict)
```

解法框架就出来了：

```java
boolean dp(String s, int i, List<String> wordDict) {
    // 遍历所有单词，尝试匹配 s[i..] 的前缀
    for (String word : wordDict) {
        int len = word.length();
        String subStr = s.substring(i, i + len);
        if (subStr.equals(word)) {
            // s[i..] 的前缀被匹配，去尝试拼出 s[i+len..]
            if (dp(s, i + len, wordDict)) {
                // s[i..] 可以被拼出
                return true;
            }
        }
    }
    // s[i..] 无法被拼出
    return false;
}
```

索引 `i` 显然是「状态」，加个备忘录消除一下重叠子问题，自顶向下带备忘录的动态规划就 OK 了，当然你也可以改写成自底向上的动态规划。

**详细题解：[动态规划和回溯算法的思维转换](https://labuladong.github.io/article/fname.html?fname=单词拼接)**

**标签：[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

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
    // 备忘录
    vector<int> memo;

    bool wordBreak(string s, vector<string>& wordDict) {
        // 备忘录，-1 代表未计算，0 代表 false，1 代表 true
        memo = vector<int>(s.size(), -1);
        // 根据函数定义，判断 s[0..] 是否能够被拼出
        return dp(s, 0, wordDict);
    }

    // 定义：返回 s[i..] 是否能够被 wordDict 拼出
    bool dp(string s, int i, vector<string>& wordDict) {
        // base case，整个 s 都被拼出来了
        if (i == s.length()) {
            return true;
        }
        // 防止冗余计算
        if (memo[i] != -1) {
            return memo[i] == 1 ? true : false;
        }
        // 遍历所有单词，尝试匹配 s[i..] 的前缀
        for (string word : wordDict) {
            int len = word.length();
            if (i + len > s.length()) {
                continue;
            }
            string subStr = s.substr(i, len);
            if (subStr != word) {
                continue;
            }
            // s[i..] 的前缀被匹配，去尝试匹配 s[i+len..]
            if (dp(s, i + len, wordDict)) {
                // s[i..] 可以被拼出，将结果记入备忘录
                memo[i] = 1;
                return true;
            }
        }
        // s[i..] 不能被拼出，结果记入备忘录
        memo[i] = 0;
        return false;
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
        # 备忘录
        self.memo = []
    
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # 备忘录，-1 代表未计算，0 代表 false，1 代表 true
        self.memo = [-1] * len(s)
        
        # 根据函数定义，判断 s[0..] 是否能够被拼出
        return self.dp(s, 0, wordDict)
    
    # 定义：返回 s[i..] 是否能够被 wordDict 拼出
    def dp(self, s: str, i: int, wordDict: List[str]) -> bool:
        # base case，整个 s 都被拼出来了
        if i == len(s):
            return True
        
        # 防止冗余计算
        if self.memo[i] != -1:
            return True if self.memo[i] == 1 else False
        
        # 遍历所有单词，尝试匹配 s[i..] 的前缀
        for word in wordDict:
            length = len(word)
            if i + length > len(s):
                continue
            sub_str = s[i:i+length]
            
            if sub_str != word:
                continue
                
            # s[i..] 的前缀被匹配，去尝试匹配 s[i+len..]
            if self.dp(s, i+length, wordDict):
                # s[i..] 可以被拼出，将结果记入备忘录
                self.memo[i] = 1
                return True
        
        # s[i..] 不能被拼出，结果记入备忘录
        self.memo[i] = 0
        return False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 备忘录
    int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        // 备忘录，-1 代表未计算，0 代表 false，1 代表 true
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        // 根据函数定义，判断 s[0..] 是否能够被拼出
        return dp(s, 0, wordDict);
    }

    // 定义：返回 s[i..] 是否能够被 wordDict 拼出
    boolean dp(String s, int i, List<String> wordDict) {
        // base case，整个 s 都被拼出来了
        if (i == s.length()) {
            return true;
        }
        // 防止冗余计算
        if (memo[i] != -1) {
            return memo[i] == 1 ? true : false;
        }
        // 遍历所有单词，尝试匹配 s[i..] 的前缀
        for (String word : wordDict) {
            int len = word.length();
            if (i + len > s.length()) {
                continue;
            }
            String subStr = s.substring(i, i + len);
            if (!subStr.equals(word)) {
                continue;
            }
            // s[i..] 的前缀被匹配，去尝试匹配 s[i+len..]
            if (dp(s, i + len, wordDict)) {
                // s[i..] 可以被拼出，将结果记入备忘录
                memo[i] = 1;
                return true;
            }
        }
        // s[i..] 不能被拼出，结果记入备忘录
        memo[i] = 0;
        return false;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

func wordBreak(s string, wordDict []string) bool {
    memo := make([]int, len(s))
    for i := range memo {
        memo[i] = -1
    }
    return dp(s, 0, wordDict, memo)
}

// dp：返回 s[i..] 是否能够被 wordDict 拼出
func dp(s string, i int, wordDict []string, memo []int) bool {
    // base case: 整个 s 都被拼出来了
    if i == len(s) {
        return true
    }
    // 防止冗余计算
    if memo[i] != -1 {
        return memo[i] == 1
    }
    // 遍历所有单词，尝试匹配 s[i..] 的前缀
    for _, word := range wordDict {
        len := len(word)
        if i+len > len(s) {
            continue
        }
        subStr := s[i : i+len]
        if subStr != word {
            continue
        }
        // s[i..] 的前缀被匹配，去尝试匹配 s[i+len..]
        if dp(s, i+len, wordDict, memo) {
            // s[i..] 可以被拼出，将结果记入备忘录
            memo[i] = 1
            return true
        }
    }
    // s[i..] 不能被拼出，结果记入备忘录
    memo[i] = 0
    return false
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function(s, wordDict) {
    // 备忘录，-1 代表未计算，0 代表 false，1 代表 true
    let memo = new Array(s.length).fill(-1);
    // 根据函数定义，判断 s[0..] 是否能够被拼出
    return dp(s, 0, wordDict, memo);
};

// 定义：返回 s[i..] 是否能够被 wordDict 拼出
function dp(s, i, wordDict, memo) {
    // base case，整个 s 都被拼出来了
    if (i === s.length) {
        return true;
    }
    // 防止冗余计算
    if (memo[i] !== -1) {
        return memo[i] === 1;
    }
    // 遍历所有单词，尝试匹配 s[i..] 的前缀
    for (let word of wordDict) {
        let len = word.length;
        if (i + len > s.length) {
            continue;
        }
        let subStr = s.substring(i, i + len);
        if (subStr !== word) {
            continue;
        }
        // s[i..] 的前缀被匹配，去尝试匹配 s[i+len..]
        if (dp(s, i + len, wordDict, memo)) {
            // s[i..] 可以被拼出，将结果记入备忘录
            memo[i] = 1;
            return true;
        }
    }
    // s[i..] 不能被拼出，结果记入备忘录
    memo[i] = 0;
    return false;
}
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_word-break" data="G+1bEdWjyQBodcAbok99Cmrz+jnTPlj9RKyIGJMjXl4vhELkmO7faX9T61isY/2bTgrhCIdHv/ufmyr7WsUYy7iOJKqTrqG4COf4FFTNvfzcZiHKXXL5TbPPQXAQtB2W0mLpGpwXcp3wv0Fut9+/rtf9FRhDUAKNm8adrJ8TBRj77Lx5ukYAzZNWWusbNwBQArZUVC6bnNTNlwGoqAKPsfeL0lbv81cBUctaQ283rju7xBtz8+P+ypIojwPO7hkGfgUavhhxsCeT6tPwcHbIjOe/cK96dOzmHYpop4gNmqGbnNLVuDNb5sqnRARMXEo2Nw0/uxT6W91HtsHBjPtJGGFj8YGrSBeK2QDvryWaRmJxz3MvTbTo/xuVXHorpE/4e3X8axkK46K7kBAfX3Huv/ebyDgrOk1IK34denazgwmr+6vwWm4kvo7e8mdWlaA5x2iZ9E6bfYpLmS3t6SU2IpIaDw3jQ6SIfLjRgSHuJLMjhb91l3Fzfopjh8ENu/hzaaQoxwSUIl221UD+xV/pP0SBM3APPAJX4Bl4Bd6BT+Bbg7Dreqm6Cw6ltoEI+9Kb3sbhjNrX0EE8xU21v9fWZRv9ELfeVnn40v1LpFreJvua+hnht374G7hD4o3Tya5n7B2SUz0j6A0NWea+5MQb9SYrs33P+9aCh2JOl6Inrl6BzjOGg/DmDdUFtxZFxdWmRWPKBMxhbc3B6Lr6tx8F+guU0Wm9wVc6Alt+Q6Jthek/u8O+Z7eo7qYfei0LCrlag7uQv1E30bkrYbUOF9yYuCYsOy8kE5YpYT8lwu8cIEUn8csZ49ebzFEeutthdUbxZCgHstrBzJg+wjMab0iTs/id+E+xZqzJlPmRzau6WKaVqtcqhnT60jjDs0HZi/b5J8pGsbWnUrGnpyF+N4F9OMC4hed2Sk7sTzi1Og/+F/DuBDmppOf1QYS54O8fuZJShyH7OhMYLT7sE6Nh9zND4MNH2AUDkM4ehGpK5eJkKpsDGz9unucCzcF73e6nhp2gCmnx5i2F2c9PtzLMK/gv0GfwWbf72WGn2P3oroh2TwFtbsRw8/oK7gv0GnzU7X56CLxLux7Y3RGcGtzb08MeaA84VZUSPN2nTGQD79kDECYH6oU1IoX3ggEYLT7sE9PD4Ye0bzppcd1NMQCktxWALZUzD8VbsGwjML3pdJt+ptq72CexDj+EPRiIalkBzZaCyVeNczM7gf1tE46dWs7Z5qM9pD0CJS3Of6YED9u3voP37AEIkwMlLpmr/L1gAEYzh/TrFfeKmxABp+jkgfEd6dxVANwt5J6ARBKV/3yg7B6IqFPujXxfNf4JTsCmapXXwq7zi7sszljebl0JdoA6kyfnch0wayL1KgTcwVYA3FmOgC1p2MU1IPUqBzwcpAC4sxwBW9Kwi2NA6lUO/zP8MEiRge4GjC+/a807wHPGqmSSsw6BJv/8tYTKSOKWUjqKiqHYtEyu9OVXRxuheEQEmZBzW9XfwZH8JYc8HLoHfTVzHrtweXV+fWSOOJMlNXi5clcVwpAQR8MQwa8e5uEe4ak8tafxtJ6umpIEZ/1JK4+AE4CH7jBSNgSGeXiO40KbEdg/5g/z57d/wCW/4AXHbs5H26GM65ItdL+iHTVaVCOUYd6mQiS6u5FLdeIBeycFLyC/rKvk/mpSoKcBssL7M1AodIADwHhAtU/DC1jgOfbCv5ts0NMAaQGeqal0rjxpbnRT4XhKwwtwZgow1SZtbdIqigr0wRi/MpgyjjzGHqGHzWCQfagBLiHyd0JhKzH8WB4bCgqK77OXpuG4PFuC3OSS89Wx/GVazMoZd1GOhpGgrfgddY0vCy3OsmK1v+GVXkJp6CBdXmh1hP+IFjdMlIT47cOmHSPhLjGsUNMaJQw90WSi6KCL8nWxFtmo9fvI35AlMTIeuEKb8/WE0WhY9GfOAWS6Uayw0aJPsJ5mk3gn/dvCG/UwhMDtUEaQXRKKU7ZfYBF7SeM4l66O1dNaHO1ME5aw9IzeC7SC6vBEY2bkya2gOtzphVf7Nk1qOiz1PqsGyh0dIy20/pJvcfGcFvm0UOFkPqz2zzERDgjwDlfne4Y2ga1lfYdwotJi3XDbq/VktLXVFXtpCV9xUZQ2v9hntkNljktCqsk3XGFa2ixF3hGG/D33WTklHgPXoLXtINFiiPHwEaAhvt4AZx1yNITEAGkbnOJs7H5/DDIV/Q3U4isTJC0i/O1+BRkLaCqXSOfZ0J84eHUimjRW3ctTM3uG5tgWxY2osmLIaGEboQtNvF7FfPUpxtQgxTsZDkpvcAEupCoZEjdnq5Bd4otmxlWFmznWrhblrPopkS+pbeK2F3cRxkbgYKQ5EpNUnGl7QRcV+iQXDJC9zTmYS5JhbFUNfdZwdb7n3lBuwA1oZRceaehE7bmQAI/1NRYTj4SWin9a0cKJhTanFdRakzM968ZQVpMKJ5IpRDYU5787iPYwwzWqKyPvaYDtElG/nNVsipUeq0Sl9N4ttmiSK5VtuH3lUdjPC+k2yzKSX4BqJZhvUHbJY0+22+iV9UXaekQlWe9AUK3VTqjqaUBNKdz9dbXajBZX1Pt0IFS5tBPqK7G4UPsCqEqWBtQZ4gB1IA2ofChQtRwNveSRhmlcWWojLOvVmEx7iIp9FXsTh+6ud0hOS9d6k8AQoYDHF1FpcYq31g2ZicvZCSEbLT/rrXVBSJaXXmFDaWiJdRWvXOiMlH7D1jTOb9DQqCrv3inRfVeJt9MkJiTuBBM/VvNu/07VL7rJqYv9E6vYxUGtbodu0NvAM1RFt24SANsGVZx+j177/xim2wmUUUM09Pe67NDDMaYVvvLSzuWDSYvs11x2H1x31zv6Q4P+eXRVn2Xkj5juJactyq2HE3+fo7NNW4L+lP/HIFENzow3c27W3q+ICu4Vx2Ic9EP8wmKF0Hf7iFyVs3YzWDHEusofyjNH1BLpHrSYUWqqBaJeIBeK0L75tlqcrDWc1QXXSYst09+Y8Mu/KPUe3l8sELeyuAiiLEvIKkTIq2rB0DpVSXq/O3nHMBfE3P71kyuKmrn7m1krMCtLmC6E3hrLZl0a06FJFlOoPReZ9riaSfRnWzyuNhnnRE05LvsLCEnz94Dw5r/Xj7MEN5Ack/PCTDPksrsZ9oOuu4QWIuqme2y2EpOsYbuR4azeQ2Jy6VFXSDuifnpEa4BGrkpbwrAIDYcpEhYhukU0fCxG4bEsa1r3OkYPu1sYFzOc88CqO/9FbAxtUX+OD5OA3ZmWeXmS2AbRuuw70CBzROeEuRKRx8+aEVH33lGyRVNv52jV21ysxXC6SpMbJWzx3q5wrqKT/zTdALvhLgJi1FwOE5nKwSNv/TdtyGFCzbfoVvu32YqbP873+t4+7VWjVtc5"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_word-break"></div></div>
</details><hr /><br />

**类似题目**：
  - [140. 单词拆分 II 🔴](/problems/word-break-ii)

</details>
</div>



