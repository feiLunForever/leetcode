English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 动态规划</details><br>

<div>👍 650, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 最后一天报名！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

用一个标准的 DFS 遍历就可以了，类似的题目可以参见 [DFS 算法秒杀岛屿系列题目](https://labuladong.github.io/article/fname.html?fname=岛屿题目)。

**标签：[DFS 算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)，二维矩阵**

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
    int movingCount(int m, int n, int k) {
        vector<vector<bool>> visited(m, vector<bool>(n, false)); // 初始化 visited 矩阵为 false
        dfs(m, n, k, 0, 0, visited);
        return res;
    }
    
    // 记录合法坐标数
    int res = 0;
    
    void dfs(int m, int n, int k, int i, int j, vector<vector<bool>>& visited) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }
        
        if (i / 10 + i % 10 + j / 10 + j % 10 > k) {
            // 坐标和超出 k 的限制
            return;
        }
        
        if (visited[i][j]) {
            // 之前已经访问过当前坐标
            return;
        }
        
        // 走到一个合法坐标
        res++;
        visited[i][j] = true;
        
        // DFS 遍历上下左右
        dfs(m, n, k, i + 1, j, visited);
        dfs(m, n, k, i, j + 1, visited);
        dfs(m, n, k, i - 1, j, visited);
        dfs(m, n, k, i, j - 1, visited);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def movingCount(self, m: int, n: int, k: int) -> int:
        def dfs(i: int, j: int, visited: List[List[bool]]):
            nonlocal res
            if i < 0 or j < 0 or i >= m or j >= n:
                # 超出索引边界
                return

            if i // 10 + i % 10 + j // 10 + j % 10 > k:
                # 坐标和超出 k 的限制
                return

            if visited[i][j]:
                # 之前已经访问过当前坐标
                return

            # 走到一个合法坐标
            res += 1
            visited[i][j] = True

            # DFS 遍历上下左右
            dfs(i + 1, j, visited)
            dfs(i, j + 1, visited)
            dfs(i - 1, j, visited)
            dfs(i, j - 1, visited)

        # 记录合法坐标数
        res = 0
        visited = [[False] * n for _ in range(m)]
        dfs(0, 0, visited)
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        dfs(m, n, k, 0, 0, visited);
        return res;
    }

    // 记录合法坐标数
    int res = 0;

    public void dfs(int m, int n, int k, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }

        if (i / 10 + i % 10 + j / 10 + j % 10 > k) {
            // 坐标和超出 k 的限制
            return;
        }

        if (visited[i][j]) {
            // 之前已经访问过当前坐标
            return;
        }

        // 走到一个合法坐标
        res++;
        visited[i][j] = true;

        // DFS 遍历上下左右
        dfs(m, n, k, i + 1, j, visited);
        dfs(m, n, k, i, j + 1, visited);
        dfs(m, n, k, i - 1, j, visited);
        dfs(m, n, k, i, j - 1, visited);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func movingCount(m int, n int, k int) int {
    visited := make([][]bool, m)
    for i := 0; i < m; i++ {
        visited[i] = make([]bool, n)
    }
    res := 0
    dfs(m, n, k, 0, 0, visited, &res)
    return res
}

func dfs(m, n, k, i, j int, visited [][]bool, res *int) {
    if i < 0 || j < 0 || i >= m || j >= n {
        return // 超出索引边界
    }
    if i/10+i%10+j/10+j%10 > k {
        return // 坐标和超出 k 的限制
    }
    if visited[i][j] {
        return // 之前已经访问过当前坐标
    }
    *res++
    visited[i][j] = true
    dfs(m, n, k, i+1, j, visited, res)
    dfs(m, n, k, i, j+1, visited, res)
    dfs(m, n, k, i-1, j, visited, res)
    dfs(m, n, k, i, j-1, visited, res)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var movingCount = function(m, n, k) {
    let visited = new Array(m).fill(false).map(() => new Array(n).fill(false));
    let res = 0;
    
    function dfs(m, n, k, i, j, visited) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }

        if (Math.floor(i / 10) + i % 10 + Math.floor(j / 10) + j % 10 > k) {
            // 坐标和超出 k 的限制
            return;
        }

        if (visited[i][j]) {
            // 之前已经访问过当前坐标
            return;
        }

        // 走到一个合法坐标
        res++;
        visited[i][j] = true;

        // DFS 遍历上下左右
        dfs(m, n, k, i + 1, j, visited);
        dfs(m, n, k, i, j + 1, visited);
        dfs(m, n, k, i - 1, j, visited);
        dfs(m, n, k, i, j - 1, visited);
    }
    
    dfs(m, n, k, 0, 0, visited);
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_ji-qi-ren-de-yun-dong-fan-wei-lcof" data="G2iMI5JLziwRRZwRanHAk+GNrljJC0ODC5rG/SceTlMdb98s4TOO2NfvBS03AFaDiEx1HbSrqjYnB8OD/O9oAq7eW3TlC3E6qUjW4eRR7m6154uF+SMouKZ+L/Szdg7zrODi6VMGymKYfuDLwv+uZV3Vxm0dP18lcVIix2h3J5n+V8WKQLgKM2moQAcMQpjTboly6MT5z++Hi2Y/z/RMSxSPC2ml7r77dmaWxHFrzzBPJo1VGgkPjdZJmIwlclRs/72ACVLQ+M3odvt/k9/d9vvJ9fe0M8Jvfa1zgoGzVpdvMjfsOORLX8jnS2iRuD/wKYTM9fvJMSi4dSL2OdLJXv+ahivtPVJkhDiQnslyitPaTcbO3/YGdAr2fZKw+S9ovZXRIdf98pTjp+uD20qBN1bTA5Fk0fDls0Mmu7p2sYVMtd/+zog/Db0f934yZ87ru3KTCtlB6oSreUMLPZxTeVkWe3WhadFa53K61CAcAsDb1ojZB/f9rQ7ySsh3/NTX1FVu9eHoEbTWcrqjtdfv5kLbKZo3fwxSZTvnr1fr9OqAhF3MSQ8qqlItEz0zALv6CmzaGcGgxCsQw00id776CFa7j8YsDbEYQHe6AaRY6EeZVZ9nDUrT0+msvyTwWdM+UV2S0xdmyKQznYTuNINLCo/AB7ALJgBr5QP3e5Hpk4dWwn8pyxEElY2AP/EEbuYPrS8HjL9EBdRdzy21tmzdXXSD7+lFv1eJCXG7yzdp/oAs5GOgCXdtJTRPu1tLO3lu3tQF5y0P1Ly3PCw0KKXWolhoc64RtqCQKeOZuzrt1VUONUiOS4t80gDZUc5QFQzQ1dLLVw3Wg8QFCPLExk0AfnqQ8Co7QDBa16HpU4YWf7T2Ft1DuwtIchCRtF0gUY0to764yaDcFu75HXQ2r+duvW0DBpxCLTeZAINGFkci+LxfN2amGflMVE8pKu5zSN5ZgsW9HRTEytXRNTh86Pw+Kq5zZTVgOJo78PCik8dTwSYcWvUATEYLF5HoaJMnSLL5zcsyloqyL46Va6IC5FZTkPlb/Fzx86QdTGphkp6pDJj1KAmIHX4Ah3LI5jGAj9AIQ6AmA11jlx2dD/3k4CE74CUHVXVAjXhAYdaBgqWL2ib+WT4lsmUUnecnq42WGqTtIqg+F0dLiCTGgaV2ScIYTUxYOwPkn+Pnip8He9WLW6nTxjv+bTbmv0oAgDtszRpSMDNP70M1UmfMNH7BcrNH22nsPKNnXDo5jvaFNhvpWY4z3tVi/aS3b4vKWwhlCsbYbZgzYyT0I7XEpEHeaYBVcFNTtxwzChmjiYmGXHcq4NdTN3kKg7vmn+PXa8axa6lHIaxHlPbONoERxFV/AnOtz/hvAMA2RSF8xXL5ze2ju+ZlmFIxUQhznu1nVPLmqw9S4FTSNFjjlbTvdho4H93kw/6yJX7kvd5b4d3DH91huMReumEgCly9ejX0zH1OwezAHfr7b6Ues/BPhPZtN4n+RvdjTqc5XNt0CHd0Eu4eLfyD7JrQpIQbZSZBDh2GDTf5PURVttX6NGnuOUM66TGonRTFNmrVQR8rt03QLIYq1dR0QyUIE+5jKVVIjo81KpFqkjR4n5lNoTizA35zY/3NXeeu/s23pvKZCZOSoN5wHLXN5jW9bjBoSl4sn0UCm2b43UE7rtF9VsIkwZsdDJ3p/vdp0WssRjvP5setPuMiWQUD+ESSEBHVCYAWQ4tbPKkoJK/43vDUGt0mvVtdFZJXjQZoIZytkVES4YNjnygvyNLFRA2Gc+q/SZSv30/JSxqviKQuhGqnkANGqKR6tCS0GJaiqkWrSbawWBltjzKFd9CmoEEPnIUW/ahlaRSiZIPOGxuoU2ckDmzR1Vp06owEY6hcaoyClhGHnq9KTlWhY/as0ZHgHv9EHNJvH/hcxyhKJMTaOihc+Yqn+7MG/VYTIdozMAQjwkwpmnzmgAXe6aazOPSwQcBoios9T4J+2QC3Na8PeTJx2JQo6M7reP+z4PNeGy27fQ6qXFvP20onws9/KUiiz1EIbhuykF0C0G0mjSnF0fe4oS2yeF5VJLuJOd9+RXPgachSREPXao7X9426R+mcG3RZ0zgPOGugkm4LUclT1IxgKDJDgu9c0RxwXKBcMQ3rXx0WOD/1IC1yIxgU5UgDWue/uKxsYNDZOc8FttXs7m95UicZa+0xAXmZWd/gpts2kaphYY+pxx/mHIdYJK5V97KD07xuXSF5EvLp/gwwJaaYwdTZlPGgSxnpc2WkgVg5qWkTwI/SwE51uuANgnolnzeKoTBBsVqU7vCo1XWQtOtmcDwq8N5ndctkcdFxin7wpbahtXpy8IKkbBv0WHCSNRMKtcSItq47hg9uMG0Vm+0XyXRO1atqTmHswruxxuL6kW1qPApq4fiD8k8YQhkoibFLmCkWEaH0E4JCTgjKMnFQZCECySQEBZA4KGcQi2NR1ujhqkLFTCn5BvklAu9i429yS7GG6JhZioLmQ5GR40ORFc2HIqseH4qsFh+TDBcrp1ZDsm0Ii+xhQlGB0xIzH7JHapiuF/ci7YMpnFDXwL8Ky+IytwB+vn8fAQDAy6HeYhFN9VfCwn/8ij3a2X9cDTTPzy+Are1YPePTCxtEr+3LAdgC0Ff/xIQcA6IbJObaZWaZXX4xbXIXNRP/YMAmgH79AvbPlxiwvSW4fHuf2Jm8rlhbA//UnbPktb3OdvMh7/5tjKJZ1ej9gOnxK8bfV//k+8YaVAuWGDN/mWj8CCW20L5+m0va5u/JZ095rVIa/+vA+Tvs/86/ocbm3Be+M3/2A0/Vzl91p1Eldjb//aBejSbndnFm/p458huiO83mb8Z5WiY1vl8aLC01YWLt8QfEiX/j8Hj+m/y7eDcV73NJZSDvEys9H1uCSpDPNFHQtIObvJHw4K30uXKfcekPO8yF94MdMe8l76SdH2ePrVCfjfwQbNXrG+YxEEAUzCDTqh1jGuPXvT+KQxPk/s04"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_ji-qi-ren-de-yun-dong-fan-wei-lcof"></div></div>
</details><hr /><br />

</details>
</div>



