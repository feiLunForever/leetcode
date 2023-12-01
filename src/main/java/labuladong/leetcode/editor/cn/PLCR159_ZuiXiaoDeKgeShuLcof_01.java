/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>数组 | 分治 | 快速选择 | 排序 | 堆（优先队列）</details><br>
 *
 * <div>👍 590, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 库存管理 III
 *
 * @author DY
 * @date 2023-11-29 17:43:14
 */
public class PLCR159_ZuiXiaoDeKgeShuLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PLCR159_ZuiXiaoDeKgeShuLcof_01().new Solution();
        System.out.println(Arrays.toString(solution.inventoryManagement(new int[]{2, 5, 7, 4}, 1)));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] inventoryManagement(int[] stock, int cnt) {
            if (cnt >= stock.length) return stock;
            quickSort(stock, 0, stock.length - 1, cnt);
            return Arrays.copyOf(stock, cnt);
        }

        public void quickSort(int[] nums, int lo, int hi, int k) {
            if (lo >= hi) return;
            int p = partition(nums, lo, hi);
            if (p > k) {
                quickSort(nums, lo, p - 1, k);
            } else if (p < k) {
                quickSort(nums, p + 1, hi, k);
            }
        }

        public int partition(int[] nums, int lo, int hi) {
            int target = nums[lo]; // 将第一位设置成基准
            int i = lo, j = hi;
            while (i < j) {
                while (i < j && nums[i] <= target) { // 从前往后找比基准大的
                    ++i;
                }
                while (i < j && nums[j] >= target) { // 从后往前找比基准小的
                    --j;
                }
                swap(nums, i, j);
            }
            swap(nums, lo, i);
            return i;
        }

        public void swap(int[] nums, int lo, int hi) {
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
