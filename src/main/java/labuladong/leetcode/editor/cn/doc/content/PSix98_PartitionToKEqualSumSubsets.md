<p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <code>true</code> if it is possible to divide this array into <code>k</code> non-empty subsets whose sums are all equal.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [4,3,2,3,5,2,1], k = 4
<strong>Output:</strong> true
<strong>Explanation:</strong> It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4], k = 3
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= k &lt;= nums.length &lt;= 16</code></li> 
 <li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
 <li>The frequency of each element is in the range <code>[1, 4]</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>位运算 | 记忆化搜索 | 数组 | 动态规划 | 回溯 | 状态压缩</details><br>

<div>👍 945, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=partition-to-k-equal-sum-subsets" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

回溯算法是笔试中最好用的算法，只要你没什么思路，就用回溯算法暴力求解，即便不能通过所有测试用例，多少能过一点。

这道题的解法其实就是暴力穷举所有的子集划分方式，看看有没有符合题意的划分方法。详细题解讲解了两种穷举思路，分别是以数字的角度和子集的角度进行穷举，这里只讲后者，因为效率较高。

以桶的视角进行穷举，每个桶需要遍历 `nums` 中的所有数字，决定是否把当前数字装进桶中；当装满一个桶之后，还要装下一个桶，直到所有桶都装满为止。

按照这个逻辑，结合 [回溯算法框架](https://labuladong.github.io/article/fname.html?fname=回溯算法详解修订版)，就能写出 `backtrack` 函数了。

当然，单纯暴力穷举会出现冗余计算，所以我们需要借助备忘录进行剪枝。如果你想进一步提高算法效率，还需要运用位图技巧优化空间复杂度，建议看详细题解。

**详细题解：[经典回溯算法：集合划分问题](https://labuladong.github.io/article/fname.html?fname=集合划分)**

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
    bool canPartitionKSubsets(vector<int>& nums, int k) {
        // 排除一些基本情况
        if (k > nums.size()) return false;
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if (sum % k != 0) return false;

        int used = 0;
        int target = sum / k;
        return backtrack(k, 0, nums, 0, used, target);
    }
    
private:
    unordered_map<int, bool> memo;

    bool backtrack(int k, int bucket, vector<int>& nums, int start, int used, int target) {
        if (k == 0) {
            return true;
        }
        if (bucket == target) {
            bool res = backtrack(k - 1, 0, nums, 0, used, target);
            memo[used] = res;
            return res;
        }

        if (memo.count(used)) {
            return memo[used];
        }

        for (int i = start; i < nums.size(); i++) {
            if ((used >> i) & 1) {
                continue;
            }
            if (nums[i] + bucket > target) {
                continue;
            }
            used |= 1 << i;
            bucket += nums[i];
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            used ^= 1 << i;
            bucket -= nums[i];
        }

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
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        # 排除一些基本情况
        if k > len(nums):
            return False
        _sum = sum(nums)
        if _sum % k != 0:
            return False
        
        used = 0 # 使用位图技巧
        target = _sum // k
        # k 号桶初始什么都没装，从 nums[0] 开始做选择
        return self.backtrack(k, 0, nums, 0, used, target, {})
        
    def backtrack(self, k: int, bucket: int, nums: List[int], start: int, used: int, target: int, memo: Dict[int, bool]) -> bool:        
        # base case
        if k == 0:
            # 所有桶都被装满了，而且 nums 一定全部用完了
            return True
        if bucket == target:
            # 装满了当前桶，递归穷举下一个桶的选择
            # 让下一个桶从 nums[0] 开始选数字
            if used in memo:
                return memo[used]
            res = self.backtrack(k - 1, 0, nums, 0, used, target, memo)
            # 缓存结果
            memo[used] = res
            return res
        
        for i in range(start, len(nums)):
            # 剪枝
            if used >> i & 1 == 1:
                # nums[i] 已经被装入别的桶中
                continue
            if nums[i] + bucket > target:
                continue
            # 做选择
            used |= 1 << i # 将第 i 位置为 1
            bucket += nums[i]
            # 递归穷举下一个数字是否装入当前桶
            if self.backtrack(k, bucket, nums, i + 1, used, target, memo):
                return True
            # 撤销选择
            used ^= 1 << i # 将第 i 位置为 0
            bucket -= nums[i]
            
        return False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 排除一些基本情况
        if (k > nums.length) return false;
        int sum = 0;
        for (int v : nums) sum += v;
        if (sum % k != 0) return false;
        
        int used = 0; // 使用位图技巧
        int target = sum / k;
        // k 号桶初始什么都没装，从 nums[0] 开始做选择
        return backtrack(k, 0, nums, 0, used, target);
    }

    HashMap<Integer, Boolean> memo = new HashMap<>();

    boolean backtrack(int k, int bucket,
                    int[] nums, int start, int used, int target) {        
        // base case
        if (k == 0) {
            // 所有桶都被装满了，而且 nums 一定全部用完了
            return true;
        }
        if (bucket == target) {
            // 装满了当前桶，递归穷举下一个桶的选择
            // 让下一个桶从 nums[0] 开始选数字
            boolean res = backtrack(k - 1, 0, nums, 0, used, target);
            // 缓存结果
            memo.put(used, res);
            return res;
        }
        
        if (memo.containsKey(used)) {
            // 避免冗余计算
            return memo.get(used);
        }

        for (int i = start; i < nums.length; i++) {
            // 剪枝
            if (((used >> i) & 1) == 1) { // 判断第 i 位是否是 1
                // nums[i] 已经被装入别的桶中
                continue;
            }
            if (nums[i] + bucket > target) {
                continue;
            }
            // 做选择
            used |= 1 << i; // 将第 i 位置为 1
            bucket += nums[i];/**<extend down -200>![](https://labuladong.github.io/pictures/集合划分/5.jpeg) */
            // 递归穷举下一个数字是否装入当前桶
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            // 撤销选择
            used ^= 1 << i; // 将第 i 位置为 0
            bucket -= nums[i];
        }

        return false;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func canPartitionKSubsets(nums []int, k int) bool {
    memo := make(map[int]bool)
    // 排除一些基本情况
    if k > len(nums) {
        return false
    }
    sum := 0
    for _, v := range nums {
        sum += v
    }
    if sum%k != 0 {
        return false
    }

    var backtrack func(k, bucket int, nums []int, start, used, target int) bool
    backtrack = func(k, bucket int, nums []int, start, used, target int) bool {
        // base case
        if k == 0 {
            // 所有桶都被装满了，而且 nums 一定全部用完了
            return true
        }
        if bucket == target {
            // 装满了当前桶，递归穷举下一个桶的选择
            // 让下一个桶从 nums[0] 开始选数字
            if res, ok := memo[used]; ok {
                return res
            }
            res := backtrack(k-1, 0, nums, 0, used, target)
            // 缓存结果
            memo[used] = res
            return res
        }

        if res, ok := memo[used]; ok {
            // 避免冗余计算
            return res
        }

        for i := start; i < len(nums); i++ {
            // 剪枝
            if (used>>i)&1 == 1 { // 判断第 i 位是否是 1
                // nums[i] 已经被装入别的桶中
                continue
            }
            if nums[i]+bucket > target {
                continue
            }
            // 做选择
            newUsed := used | 1<<i // 将第 i 位置为 1
            newBucket := bucket + nums[i]
            // 递归穷举下一个数字是否装入当前桶
            if backtrack(k, newBucket, nums, i+1, newUsed, target) {
                return true
            }
            // 撤销选择
        }

        memo[used] = false
        return false
    }

    used := 0 // 使用位图技巧
    target := sum / k
    // k 号桶初始什么都没装，从 nums[0] 开始做选择
    return backtrack(k, 0, nums, 0, used, target)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var canPartitionKSubsets = function(nums, k) {
    let memo = new Map();
    
    function backtrack(k, bucket, nums, start, used, target) {  
        // base case
        if (k == 0) {
            // 所有桶都被装满了，而且 nums 一定全部用完了
            return true;
        }
        if (bucket == target) {
            // 装满了当前桶，递归穷举下一个桶的选择
            // 让下一个桶从 nums[0] 开始选数字
            let res = backtrack(k - 1, 0, nums, 0, used, target);
            // 缓存结果
            memo.set(used, res);
            return res;
        }

        if (memo.has(used)) {
            // 避免冗余计算
            return memo.get(used);
        }

        for (let i = start; i < nums.length; i++) {
            // 剪枝
            if (((used >> i) & 1) == 1) { // 判断第 i 位是否是 1
                // nums[i] 已经被装入别的桶中
                continue;
            }
            if (nums[i] + bucket > target) {
                continue;
            }
            // 做选择
            let newUsed = used | (1 << i); // 将第 i 位置为 1
            let newBucket = bucket + nums[i];/**<extend down -200>![](https://labuladong.github.io/pictures/集合划分/5.jpeg) */
            // 递归穷举下一个数字是否装入当前桶
            if (backtrack(k, newBucket, nums, i + 1, newUsed, target)) {
                return true;
            }
            // 撤销选择
            newUsed ^= (1 << i); // 将第 i 位置为 0
            newBucket -= nums[i];
        }

        memo.set(used, false);
        return false;
    }

    // 排除一些基本情况
    if (k > nums.length) return false;
    let sum = 0;
    for (let v of nums) sum += v;
    if (sum % k != 0) return false;

    let used = 0; // 使用位图技巧
    let target = sum / k;
    // k 号桶初始什么都没装，从 nums[0] 开始做选择
    return backtrack(k, 0, nums, 0, used, target);
};
```

</div></div>
</div></div>

<details open><summary><strong>👉 算法可视化 👈</strong></summary><div class="resizable aspect-ratio-container" style="height: 70vh;">
    <iframe src="https://labuladong.github.io/algo-visualize/" width="100%"
    height="100%" scrolling="auto" frameborder="0"
    style="overflow: auto;" id="iframe_partition-to-k-equal-sum-subsets"></iframe>
</div>
<div id="data_partition-to-k-equal-sum-subsets" data="G83nIxHmjIv5SISwcRDQzGszA8HGAWFPZwG1PtCOsOJ4WxUxm5+e1kdU0PqIvnXy9tBy+tIVzn6fAglh5HO0hDPAncTW0McdIsvmUieXywx1v1zzlX3l7NwekAoUbYUiThmEc+2H++XIv10raR8aoLcvKoMlw8DASrau2iBluFJAbMdODuF+WaWhaeIDJxzpxaFV0Qe2G/tGIkD8yl/twp3DLSVKTzzCras4i2Fm/j7ELYPKt+/tb8R9MMkzgiADnn/XPkmtK5DwVYpyRpZtOSVhF67wderTS8okgYwxyczsOUleStMtCUfw/99+j8bRJCnMiirCjVKVEaqrsrLC/Zl7ZweYVQn+ebdArMiVPbBspSr822jv39NZ6lS+MCHrEJ7Bv4nTe27SjkgKkHX9Q3km4dyAmmye+Be8NyBkuNx1qtlDwPNQmex/fpTz9v794vveW2Jx2fhRzzDwIgpbMIe/U/D6luCHCcTCnf/hv90ztL/fM4nSnSIOZLY9wK1fw+3bEvD3NIVs2PfVT1d0ZFm8gloVWWDtaCsm9K7vKY4spzwuj33VlBzky55y4awC2b9FcoXco33SA6ec4f7vjHCfTnM949Nfvv2o29aFTu9MQh7Ns3tu/KJhz+3o/Q1woCd54qP4Gg94EPrbBZem04KiFlpZPORfSfVBSk1bxoj1JaOu97CKVo1vQUEvfv+YtUvfHdZCcLHLRdniLr+a9R9slx9rTSx/bA7WYpQuxZww0uSR3V2j2oqB09UDJ1xQ50DY9egu6gdEqaSwfTQP8u2fffLzSyxuSbrGYjfKruxZvS/VKPeaVWASnvtB7/Id0kesqnMMw3Uf/LRr2M/75pNvfxaZxoPm0WfU1Aj6MLgRSisHlbLUxBqxtFTKVBNP3dq6HweYjKa0VtJe4k2sun0wuS1IRiktlDL0GNgNaDF9JmNM7vSZu12rtri/rm6Yer973G7OwlbLb1XnEtn9GEewexlipqoukXvSY0fRCxchtNJ193mah1DG0gfjlWgO0AP26lD4Z6wazOhp3quqpVrzGY3Cir4kUx3mz67OwjRBX4YOIeT/7ANe1mSsNLPaC9eEugy9w+avsQ/dAA+bn1XuLdwO7T696r+HrrANJ39fZI5YX7bSxO48T4891rQKvRjyH+G+elM4Hp7tDXYuror3eBTqG8xXnlOG1Rn+MbNmOjfaLZelqVZl4uec8WYNjPUeNfFl1ZksgPGeOl04t1e9t8dY8HK0MccG3wLOw63kdEe73nVKXRTV1k8Y+x9MXTuYYXuDC3u+epnLgSfXVW11OryrvPzlTIHaCajUTdPZ0x7dHNy4x9X0yoK5lvqZLZhzfNgsyZ1/7beF7szCYLTHALp5ahSanhoa5QPlC00/iNHEg+X/WxuOXhxfVaclMY927Z+sU3wiK+Pg48+3Awav2f79STPnSAquZY2/fRNVDDJAElLD676r9VJX6CQL7LL9T+938r0pvWeqGGXAJCg9RVVMqg86A1SxkcEkYenpqYpZ9cENoCoWGSQJqDweVPoiMumritPjiJNREoFysxKxatRKQ1Y+q0GJEyMcjrAcacRKce9gUIJlKFNrcpTgb7vgvhf4wqxM44XFXl1MzzXdGtbJov7pcq8tA0ctRxwHitDWivsFgyJ2L4vWyHO04O901iFcrveLiFPjcB+YzuxNSoEGVST+C6WUR5G5NDjltWpijdCwMBcbiUg1iv0tDUkZUYVZ0fB3giWvQYPi3sGgBEvHOylylOBv34RSqEFFWtfxX961PCaJ0Ve10IFYGFFtHPLuv0YyOhH5SIOyEM08R1iuxUFR3DsYlGDJfvpJjhL87cZomKp/VMucLDhqOcJyrtAdxb2DQQmW0bAY5FjB3+msQxjy3lheqPTeKvqDWyUYeiz9wRX1FXhq/0vFpHGx+7yemnhKFjVqQjKdiIyGojwRG3CEJcnqJsW9g0EJlv7MpZCjBH/7JpQyUsA0rmO6CaAqeFIg1f6XCfsixPR1AemxAEnJVo1K97ITkU80LECio+MIyy95/Y/i3sGghOMwcyBydOBvR0bDUP2D2uZswWHLEZYWTIkU9w4GJVi6Xf4hcozgb+90LyxKaW0sA5cMq8tWXaa+vaHLCiplpIAopiHN8pgvAkm/DbiJat1/GI0OPaZToxyp60RkZA0KV4SMHGEZ5m7/Utw7GJTw2igu7V+U4G83RsOtCthqmbMFhy1HWLrexElx72BQgqWz4beQ4wR//eOeZQV/m3yQbAQAlmUrRyi4LJnaLgbpdsjN+UwRu/LPIOC9oRpPR1EDyzHC0LQu3VbumFtuYuZet6W7f7SsfED7SvlPWO44hj1YqRdH3b/UCWqux5JBHj/Tj5zvNnQqxOmZcLyfHaTb4Y4mx525j2HqLqM3vvAYeTvnNYDYkpInHZMjgnQ75GlofUZdNxDABQkvh/mhAbod4IIXnReiSw6bqArR7XC3rNV5swTRJYdNW4bvtv8FL/qNpq8Ye0W6y2FnCOG77X/BC/UqiC457IcwfLf9L3ihXgPRJYf9F4fvtv8FL6qGZiDiC9JdDrtDD9DtABe86LwQXXI4osbw3fa/4IV2PUSXnP8aI+ZKCXcsXdjl16YZVz6U4zsXhINIlryqGZLZ2/c0enTfq9+nLx1Dgt99dP1mdECQP5feccb/SWTxKyvFTMyVcuONK9WOIlbqrznjvNLK3O4QB3bj0U6UNKDebva1N1aPvvlzEFrfPwVdXHHEIdl5SuWukZMjO6i8TtzD+1VEiQo3+x9N9dsr/JWiVIrReHI4eMWCqotn+L43rMtlhmpnZq/uG9/Vk19IORZ2nnJ13xtdvWlZQY+1kY0bR9M43ggCGg9NK2N73NyHKOYxGzZAyoH/GqQWnqXWSNFI7ZQ0pTpm+uWHVILJQyqMkLVUMKMtKW6Th5TWyTWpRPk8pCAACKkYpA1SjEWUJN/haJULHFoBB/1rTSv18La7b/C2W+w1xOwRGlDQWVe7JCV6wrbVtMLiG81zuWo0DsQcaKBBDIFXtgqb3JlqHEqdp0kVDwchN8ykKBti91QUnKGkaUU4b1aD0dq0sSYHMQcaaJDGIJk7d8p1wMxKBfc0WFLOMYd9tVBwrqymldVVeuBWedO2UosZ0ICBs3jVBkyJnhgR0bTi9rp1PixnQeFAzIEGGsQQSMUgHKbuI6TVc8OrEsqm00gJ4azJOiiiHszMaXt32FQQB8OcOiXnqq05cLC2qSlAzIEGGuQhILWiPXwyBwyujzGzBKGROkEH84qAjasDsFkOCuYiaFoBV37z6pXjc7NBXms5eYQOGuSKCFZLYGAqkKYVb9601agbuKaQc6ADIYsl1AMzq+oOM61m2aQOIi0praLgdNe6vdUbE6slnEkpYsAkYwpmBGq+Ul/2zRuZ9oO9uUXlIOd8cXRQyHfwtY3tsTRlQq5yD6iSY+EWa04B7DnMQwJf39vG9uKqQFzX7Y7kWNPH4LpXp30Wwj9uUM2J+7+Fbzs7Dkve8gWf9uP9695+NH08zzPj7MU5012vdk98hmLTq9wP/YpvbqyPFWRkdsP9jSzS8mRsKDahjjgyNOZiWqjIPalkbuxr9aieSg7FWk8UenY+n/q0T5jYjZQUkDr+QiPGUzzwwzl7Ab7YgMOxpwW00Ar22b2ZWigWoEjb4CRjsogDezTvC7emlwneWyyGYmFfoHsmynQGxupAMtMTTjYpydTATE/YzY+IomfGPNHb2kFVcjSaKBesbHYs+efwPbzysLhIrobeZ8p+gxbdvM8vP37RmRUlYIMthMnyOFZqEKoXmvTZ2y1f8H3/QghVHPtL/IM65ncO06Xa/BW/IN/7XeqC4WXmWLGzOg/tww78OnLvVx6vmg8Hub9FBrdWodVKHYukBPtBtNLCOHm8E2Y2q9jNF5zsBAv8TT7qMFbJfgack937IR795IguNmFjdHqBL7qLwQvKu/pawHeE2WqmsQ59A4sv2hN0GilYVLn7V/1ULOYLIDdU2jKyT10dnFWGuwjUWB9nz3o1v8Z9RRmNscPpRFoRVvZBZMh/KRozZ35bn6IdabLX/Fiq7TAs/FQuaebyy49f2O8i1hZIlnvO8QbXqK0oDHezUHDIRnKDrrZ7Mk3cWKi54s6LzUz4yhXtsx/qdcNgY92Ld59uCy4pF/4cG5w8qLjNhNYUkaAUFzvKnNEb4SY9NA1Mhb3BJD+E6Y6TuFi1r/WNMdlv9/BMlbp9419hY9OLJkULRxR0CSCI4OygqoSrP5KzmtBPR/hb+xwPeljRn2UgZGYxiZqsINsq6FPZlFFwFYRaBT1WUdlVQV1VEyKqglaqqCSqoHwqCJwKOqaicqWCKqkg/inoasn6RYlTkIiSgRDlFLQ3NanEpqCkKQhWCspLMkNoV4JKVApKlILgo6ClpFNG+wGRfbKBEGIU9BY1IasoqCeKiiQKWoiC5KBwzTabfdQHBZFBQUtQVDJQUAYUYua3gl2b6IklrGAQJSfCKBbU9kWkJq6CJatgsCpqlyqYnwo2noLxlIYKc0/B0tMTbXo/Gtt/VHy3v9aqEVxpWtr3OmvfQGBxigNnm0FPAJEgM9wYOCJJp1i565ay3Dl1P+KFxhR3qy4EDrdU39wFZbgLynHn1EDughLunP2yu6cEZWBQDoIKwqAEgsqGQQkEVUtw0AASftUgHmjMGKU8IkOYagYG5SCoOxDUMyFAw0T41SeCwTCVBecK1YKgYqj1NTKEX+VR0WswiFIVqvww1QEMSiCoBgyKIagBBHVJ3a71f/jVa2r5YSoDg3IQ1EcYlAPnCt2P6lyr/PCrFDW41vJRqkBdPkwlENQBDEogqAYMiiGoAQR1SaWtFXv4rbhQT2tdvvafcUea9XcDHJh+DZEm6P3f4zU+OvKS8Gy3NwCwmpywnqy3yQfepwlZkLTHm6T+x1dWHRdL/iEqW7nbxjdbudvON/sJz9HEi62+DzS8IQyfMzX85fdaQutgxhwG8ywX/53DbfDbqG6M+g51Yf8w+UH2mfAmPPHkG/0/k7elY/wmxihZks+X53vPkC9ck4plSWaNefHsHv/I4fYPM0DilVLuHP900Ak5zsz7YyEpQGbjek1Xeu/TzS3T/lbQaUyU2cCe16Xc3ofvthwm21c8c3+4CDmoni9wimge471+H5nWAGQ5cY8eGee84+Qk6DSGfUms2m6eHKb6Tu+K+eD4wjT97j/4g7Jgul7z6RfMGbpoy2ZIlfDu//vIZqr9FjpGz0kLZR/QUzrQyESib/AlK3vubV2bdYL3X8AYWEIRIUHrc+uej/wHIrHWpmnO4vOyiDZnvOZCanBydy+yDgfTQ/zhoClEHQsJiTc42gcP8PDojw0SkQeXHQ5C+9mmevrJY6XXBa3AJjjjlzXug4bBfu4FEUIpWJKP3j5gZnJUnPt1XF1CaEMtHYcCGx2rZdGcJ6Cnj/vC7UvOZgaTMg4RWNdYdoasH4mVGFPLm6e+fssfKZkC9AxvrasNeUcBWnwQXG08cibP+Q5DX1uFhukv0AldznPSzAQsqSModUykPkZx/xyThc9LlNkw7Tme193G4Goy+tgF2ymVdXS31U5afIFHu/5MYYnM8AmD+bemaR+b8I6r9F56WewPvuvcvcPZs8dGf5H/LKn0Pyzx5XeHG4RLTqM1/V8Gv57Cxug/TJkuqYNhdfP6VArxDW9dmnSOxHdBuul/pGglHHN0bl3anw87nHwlLtB99qpfea963pzs+tdGrc0C"></div></details><hr /><br />

</details>
</div>



