/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>树状数组 | 线段树 | 数组 | 二分查找 | 分治 | 有序集合 | 归并排序</details><br>
 *
 * <div>👍 970, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 数组中的逆序对  LCOF
 *
 * @author DY
 * @date 2023-03-23 21:39:35
 */
public class PJianZhiOffer51_ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer51_ShuZuZhongDeNiXuDuiLcof().new Solution();
		System.out.println(solution.reversePairs(new int[]{7, 5, 6, 4}));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int count = 0;

        public int reversePairs(int[] nums) {
            int n = nums.length;
            int[] temp = new int[n];
            sort(nums, temp, 0, n - 1);
            return count;
        }

        private void sort(int[] nums, int[] temp, int l, int r) {
            if (l >= r) return; // 单个元素不用排序
            int mid = l + (r - l) / 2;
            sort(nums, temp, l, mid); // 先对左半部分数组 nums[l..mid] 排序
            sort(nums, temp, mid + 1, r); // 再对右半部分数组 nums[mid+1..r] 排序
            merge(nums, temp, l, mid, r); // 将两部分有序数组合并成一个有序数组
        }

        /**
         * 将 nums[l..mid] 和 nums[mid+1,r] 合并成有序数组
         *
         * @param nums
         * @param temp
         * @param l
         * @param mid
         * @param r
         */
        private void merge(int[] nums, int[] temp, int l, int mid, int r) {
            for (int i = l; i <= r; i++) { // 先把 nums[l..r] 复制到辅助数组中, 以便合并后的结果能够直接存入 nums
                temp[i] = nums[i];
            }
            int i = l, j = mid + 1; // i,j 分别代表 两个数组的下标
            for (int k = l; k <= r; k++) {
                if (i == mid + 1) { // 左半边数组已全部被合并
                    nums[k] = temp[j++];
                } else if (j == r + 1) { // 右半边数组已全部被合并
                    nums[k] = temp[i++];
                } else if (temp[i] <= temp[j]) {
                    nums[k] = temp[i++];
                } else { //当左边数组的大与右边数组的元素时，就对当前元素以及后面的元素的个数进行统计
                    count += (mid + 1 - i);
                    nums[k] = temp[j++];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
