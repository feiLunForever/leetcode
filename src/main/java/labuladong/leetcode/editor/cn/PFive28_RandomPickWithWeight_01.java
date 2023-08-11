/**
 * <p>You are given a <strong>0-indexed</strong> array of positive integers <code>w</code> where <code>w[i]</code> describes the <strong>weight</strong> of the <code>i<sup>th</sup></code> index.</p>
 *
 * <p>You need to implement the function <code>pickIndex()</code>, which <strong>randomly</strong> picks an index in the range <code>[0, w.length - 1]</code> (<strong>inclusive</strong>) and returns it. The <strong>probability</strong> of picking an index <code>i</code> is <code>w[i] / sum(w)</code>.</p>
 *
 * <ul>
 * <li>For example, if <code>w = [1, 3]</code>, the probability of picking index <code>0</code> is <code>1 / (1 + 3) = 0.25</code> (i.e., <code>25%</code>), and the probability of picking index <code>1</code> is <code>3 / (1 + 3) = 0.75</code> (i.e., <code>75%</code>).</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * <strong>Output</strong>
 * [null,0]
 *
 * <strong>Explanation</strong>
 * Solution solution = new Solution([1]);
 * solution.pickIndex(); // return 0. The only option is to return 0 since there is only one element in w.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * <strong>Output</strong>
 * [null,1,1,1,1,0]
 *
 * <strong>Explanation</strong>
 * Solution solution = new Solution([1, 3]);
 * solution.pickIndex(); // return 1. It is returning the second element (index = 1) that has a probability of 3/4.
 * solution.pickIndex(); // return 1
 * solution.pickIndex(); // return 1
 * solution.pickIndex(); // return 1
 * solution.pickIndex(); // return 0. It is returning the first element (index = 0) that has a probability of 1/4.
 *
 * Since this is a randomization problem, multiple answers are allowed.
 * All of the following outputs can be considered correct:
 * [null,1,1,1,1,0]
 * [null,1,1,1,1,1]
 * [null,1,1,1,0,0]
 * [null,1,1,1,0,1]
 * [null,1,0,1,0,0]
 * ......
 * and so on.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= w.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>1 &lt;= w[i] &lt;= 10<sup>5</sup></code></li>
 * <li><code>pickIndex</code> will be called at most <code>10<sup>4</sup></code> times.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 数学 | 二分查找 | 前缀和 | 随机化</details><br>
 *
 * <div>👍 299, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Random;

/**
 * Random Pick with Weight
 *
 * @author DY
 * @date 2023-08-11 16:29:45
 */
public class PFive28_RandomPickWithWeight_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFive28_RandomPickWithWeight_01().new Solution(null);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final int[] preSum;

        private final Random random;

        public Solution(int[] w) {
            preSum = new int[w.length + 1]; // 构建前缀和数组，偏移一位留给 preSum[0]
            for (int i = 1; i <= w.length; i++) {
                preSum[i] = preSum[i - 1] + w[i - 1]; // preSum[i] = sum(w[0..i-1])
            }
            random = new Random();
        }

        public int pickIndex() {
            // Java 的 nextInt(n) 方法在 [0, n) 中生成一个随机整数
            // 再加一就是在闭区间 [1, preSum[n - 1]] 中随机选择一个数字
            int target = random.nextInt(preSum[preSum.length - 1]) + 1;
            return leftBound(preSum, target) - 1; // 别忘了前缀和数组 preSum 和原始数组 w 有一位索引偏移
        }

        private int leftBound(int[] nums, int target) {
            if(nums.length == 0) return -1;
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] > target) {
                    r = mid - 1;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
