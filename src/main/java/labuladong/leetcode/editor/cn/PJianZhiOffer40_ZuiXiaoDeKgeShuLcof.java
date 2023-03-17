/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>数组 | 分治 | 快速选择 | 排序 | 堆（优先队列）</details><br>
 *
 * <div>👍 537, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最小的k个数  LCOF
 *
 * @author DY
 * @date 2023-03-16 21:13:49
 */
public class PJianZhiOffer40_ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer40_ZuiXiaoDeKgeShuLcof().new Solution();
        System.out.println(Arrays.toString(solution.getLeastNumbers(new int[]{0, 1, 2, 1}, 1)));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k >= arr.length) return arr;
            quickSortK(arr, k, 0, arr.length - 1);
            return Arrays.copyOf(arr, k);
        }

		private void quickSortK(int[] arr, int k, int start, int end) {
			if (start >= end) return;
			int l = start, r = end;
			int target = arr[start];
			while (l < r) {
				while (l < r && arr[r] >= target) --r;
				while (l < r && arr[l] <= target) ++l;
				swap(arr, l, r);
			}
			swap(arr, start, l);
			if (l > k)
				quickSortK(arr, k, start, l - 1);
			else if (l < k)
				quickSortK(arr, k, l + 1, end);
		}

		private void swap(int[] arr, int l, int r) {
			if (l != r) {
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
			}
		}

        private void quickSort(int[] arr, int start, int end) {
            if (start >= end) return;
            int l = start, r = end;
            int target = arr[start];
            while (l < r) {
				while (l < r && arr[r] >= target) --r;
				while (l < r && arr[l] <= target) ++l;
                swap(arr, l, r);
            }
            swap(arr, start, l);
            quickSort(arr, start, l - 1);
            quickSort(arr, l + 1, end);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
