//<p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <code>true</code> if it is possible to divide this array into <code>k</code> non-empty subsets whose sums are all equal.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [4,3,2,3,5,2,1], k = 4
//<strong>Output:</strong> true
//<strong>Explanation:</strong> It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,2,3,4], k = 3
//<strong>Output:</strong> false
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= k &lt;= nums.length &lt;= 16</code></li> 
// <li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
// <li>The frequency of each element is in the range <code>[1, 4]</code>.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>位运算 | 记忆化搜索 | 数组 | 动态规划 | 回溯 | 状态压缩</details><br>
//
//<div>👍 853, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Partition to K Equal Sum Subsets
 *
 * @author DY
 * @date 2022-11-03 09:47:35
 */
public class P698_PartitionToKEqualSumSubsets {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P698_PartitionToKEqualSumSubsets().new Solution();
        System.out.println(solution.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            if (k > nums.length) return false;
            int sum = 0;
            for (int it : nums) {
                sum += it;
            }
            if (sum % k != 0) return false;
            int used = 0; // 位图技巧
//            Arrays.sort(nums);
//            int[] bucket = new int[k];
            Map<Integer, Boolean> cache = new HashMap<>();
            return backtrack(nums, k, 0, 0, used, sum / k, cache);
        }

        /**
         * @param nums
         * @param k      第k个桶
         * @param curSum 当前桶的值
         * @param index  num对应的序号
         * @param used   记录num数组的使用情况
         * @param target 目标值
         * @param cache
         * @return
         */
        private boolean backtrack(int[] nums, int k, int curSum, int index, int used, int target, Map<Integer, Boolean> cache) {
            if (k == 0) return true; // 所有桶都被装满了，而且 nums 一定全部用完了

            if (curSum == target) { // 当前桶已经装满了，递归下一个桶
                boolean res = backtrack(nums, k - 1, 0, 0, used, target, cache);
                cache.put(used, res);
                return res;
            }

            if (cache.containsKey(used)) {
                return cache.get(used);
            }

            for (int i = index; i < nums.length; i++) {
                if (((used >> i) & 1) == 1) { // 判断第i位是否为1
                    continue; // 第i位用过了
                }
                if (nums[i] + curSum > target) {
                    continue;
                }
                curSum += nums[i]; // 做选择
                used |= (1 << i); // 将第 i 位置为 1
                if (backtrack(nums, k, curSum, i + 1, used, target, cache)) { // 递归穷举下一个数字是否装入当前桶
                    return true;
                }

                curSum -= nums[i]; // 撤销选择
                used ^= (1 << i); // 将第 i 位置为 0
            }

            return false;
        }


        private boolean backtrack1(int[] nums, int index, int[] bucket, int target) {  // 超时
            if (index == -1) {
                for (int it : bucket) {
                    if (it != target) {
                        return false;
                    }
                }
                return true;
            }
            // 穷举num[index] 放入每个桶中
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] + nums[index] > target) {
                    continue;
                }
                bucket[i] += nums[index];
                if (backtrack1(nums, index - 1, bucket, target)) {
                    return true;
                }
                bucket[i] -= nums[index];
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}