/**
 * <p>You are given two integer arrays <code>nums1</code> and <code>nums2</code> both of the same length. The <strong>advantage</strong> of <code>nums1</code> with respect to <code>nums2</code> is the number of indices <code>i</code> for which <code>nums1[i] &gt; nums2[i]</code>.</p>
 *
 * <p>Return <em>any permutation of </em><code>nums1</code><em> that maximizes its <strong>advantage</strong> with respect to </em><code>nums2</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * <strong>Output:</strong> [2,11,7,15]
 * </pre>
 * <p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * <strong>Output:</strong> [24,32,8,12]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums1.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>nums2.length == nums1.length</code></li>
 * <li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 双指针 | 排序</details><br>
 *
 * <div>👍 395, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Advantage Shuffle
 *
 * @author DY
 * @date 2023-09-19 18:34:45
 */
public class PEight70_AdvantageShuffle_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PEight70_AdvantageShuffle_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            PriorityQueue<int[]> q = new PriorityQueue<>(
                    (o1, o2) -> o2[1] - o1[1]
            );
            for (int i = 0; i < nums2.length; i++) {
                q.offer(new int[]{i, nums2[i]});
            }
            Arrays.sort(nums1);
            int l = 0, r = nums1.length - 1;
            int[] res = new int[nums1.length];
            while (!q.isEmpty()) {
                int[] item = q.poll();
                int i = item[0];
                int maxV = item[1];
                if (maxV < nums1[r]) {
                    res[i] = nums1[r];
                    --r;
                } else {
                    res[i] = nums1[l];
                    ++l;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
