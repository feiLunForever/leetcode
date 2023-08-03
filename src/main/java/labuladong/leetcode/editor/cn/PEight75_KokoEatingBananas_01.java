/**
 * <p>Koko loves to eat bananas. There are <code>n</code> piles of bananas, the <code>i<sup>th</sup></code> pile has <code>piles[i]</code> bananas. The guards have gone and will come back in <code>h</code> hours.</p>
 *
 * <p>Koko can decide her bananas-per-hour eating speed of <code>k</code>. Each hour, she chooses some pile of bananas and eats <code>k</code> bananas from that pile. If the pile has less than <code>k</code> bananas, she eats all of them instead and will not eat any more bananas during this hour.</p>
 *
 * <p>Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.</p>
 *
 * <p>Return <em>the minimum integer</em> <code>k</code> <em>such that she can eat all the bananas within</em> <code>h</code> <em>hours</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> piles = [3,6,7,11], h = 8
 * <strong>Output:</strong> 4
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> piles = [30,11,23,4,20], h = 5
 * <strong>Output:</strong> 30
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> piles = [30,11,23,4,20], h = 6
 * <strong>Output:</strong> 23
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= piles.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>piles.length &lt;= h &lt;= 10<sup>9</sup></code></li>
 * <li><code>1 &lt;= piles[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>
 *
 * <div>👍 522, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Koko Eating Bananas
 *
 * @author DY
 * @date 2023-08-03 11:30:27
 */
public class PEight75_KokoEatingBananas_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PEight75_KokoEatingBananas_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1, right = 1000000001;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long hours = calculate(piles, mid);
                if (hours > h) { // 吃的太慢了
                    left = mid + 1;
                } else if (hours < h) { // 吃的快了
                    right = mid - 1;
                } else { // 找左边界，缩小右边界
                    right = mid - 1;
                }
            }
            return left;
        }

        private long calculate(int[] piles, int x) {
            long hours = 0;
            for (int pile : piles) {
                hours += pile / x;
                if (pile % x > 0) {
                    ++hours;
                }
            }
            return hours;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
