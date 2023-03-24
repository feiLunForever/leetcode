/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>
 *
 * <div>👍 410, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 在排序数组中查找数字  LCOF
 *
 * @author DY
 * @date 2023-03-24 18:53:08
 */
public class PJianZhiOffer53I_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer53I_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
		System.out.println(solution.search(new int[]{}, 0));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if(nums == null || nums.length == 0) return 0;
            int left = leftBounds(nums, target);
            if (left == -1) return 0;
            return rightBounds(nums, target) - left + 1;
        }

        private int leftBounds(int[] nums, int target) {
			if (target < nums[0] || target > nums[nums.length - 1]) {
				return -1;
			}
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (nums[mid] < target) {
                    l = mid + 1;
                } else if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    r = mid - 1;
                }
            }
            return nums[l] == target ? l : -1;
        }

        private int rightBounds(int[] nums, int target) {
			if (target < nums[0] || target > nums[nums.length - 1]) {
				return -1;
			}
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (nums[mid] < target) {
                    l = mid + 1;
                } else if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return nums[r] == target ? r : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
