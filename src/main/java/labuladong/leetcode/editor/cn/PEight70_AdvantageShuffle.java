/**
 * You are given two integer arrays nums1 and nums2 both of the same length. The
 * advantage of nums1 with respect to nums2 is the number of indices i for which
 * nums1[i] > nums2[i].
 * <p>
 * Return any permutation of nums1 that maximizes its advantage with respect to
 * nums2.
 * <p>
 * <p>
 * Example 1:
 * Input: nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * Output: [2,11,7,15]
 * <p>
 * Example 2:
 * Input: nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * Output: [24,32,8,12]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums1.length <= 10⁵
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics贪心 | 数组 | 双指针 | 排序
 * <p>
 * 👍 386, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Advantage Shuffle
 *
 * @author DY
 * @date 2023-07-18 20:49:04
 */
public class PEight70_AdvantageShuffle {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PEight70_AdvantageShuffle().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
            for (int i = 0; i < nums2.length; i++) {
                queue.offer(new int[]{i, nums2[i]});
            }
            Arrays.sort(nums1);
            int[] res = new int[nums1.length];
            int l = 0, r = nums1.length - 1;
            while (!queue.isEmpty()) {
                int[] item = queue.poll();
                if (item[1] < nums1[r]) {
                    res[item[0]] = nums1[r];
                    --r;
                } else {
                    res[item[0]] = nums1[l];
                    ++l;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
