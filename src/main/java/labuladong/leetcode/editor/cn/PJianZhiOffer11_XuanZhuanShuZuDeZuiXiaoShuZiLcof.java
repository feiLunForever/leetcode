/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>
 *
 * <div>👍 771, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/7uUsXJpFJ8wzuMMxBmS7NQ' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 旋转数组的最小数字  LCOF
 *
 * @author DY
 * @date 2023-03-02 12:39:24
 */
public class PJianZhiOffer11_XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer11_XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
        solution.minArray(new int[]{2, 2, 2, 0, 1});
//        solution.minArray(new int[]{1, 3, 5});
//        solution.minArray(new int[]{10, 1, 10, 10, 10});
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 为什么要一直跟numbers[right]比较？
         * 如果是numbers[mid] 与 numbers[left]比较，当numbers[mid] > numbers[left] 不知道最小值在哪边
         * [3,4,5,1,2] 最小值在mid右边；[1,2,3,4,5] 最小值在mid左边
         * @param numbers
         * @return
         */
        public int minArray(int[] numbers) {
            if (numbers.length == 1) return numbers[0];
            int left = 0, right = numbers.length - 1;
            while (left <= right) { // 终止条件: left = right + 1
                int mid = left + ((right - left) >> 1);
                if (numbers[mid] > numbers[right]) { // 说明最小数字一定在当前middle的右边
                    left = mid + 1; // 左指针移到middle+1位置，搜索空间是[middle+1, right]
                } else if (numbers[mid] < numbers[right]) { // 说明最小数字一定在当前middle的左边
                    right = mid; // 这种情况middle可能正好是最小值，所以右指针不能移动到middle-1，需要移动到middle位置, 搜索空间是[left, middle]
                } else {
                    --right; // 比如4 3 4 4 4，middle在中间的4，和left、right都相等, 没法判断最小值具体在哪一边, 所以right左移一位，从右向左暴力缩小查找范围
                }
            }
            return numbers[left];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}