/**
 * <p>Given an array of integers <code>arr</code>, sort the array by performing a series of <strong>pancake flips</strong>.</p>
 *
 * <p>In one pancake flip we do the following steps:</p>
 *
 * <ul>
 * <li>Choose an integer <code>k</code> where <code>1 &lt;= k &lt;= arr.length</code>.</li>
 * <li>Reverse the sub-array <code>arr[0...k-1]</code> (<strong>0-indexed</strong>).</li>
 * </ul>
 *
 * <p>For example, if <code>arr = [3,2,1,4]</code> and we performed a pancake flip choosing <code>k = 3</code>, we reverse the sub-array <code>[3,2,1]</code>, so <code>arr = [<u>1</u>,<u>2</u>,<u>3</u>,4]</code> after the pancake flip at <code>k = 3</code>.</p>
 *
 * <p>Return <em>an array of the </em><code>k</code><em>-values corresponding to a sequence of pancake flips that sort </em><code>arr</code>. Any valid answer that sorts the array within <code>10 * arr.length</code> flips will be judged as correct.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> arr = [3,2,4,1]
 * <strong>Output:</strong> [4,2,4,3]
 * <strong>Explanation: </strong>
 * We perform 4 pancake flips, with k values 4, 2, 4, and 3.
 * Starting state: arr = [3, 2, 4, 1]
 * After 1st flip (k = 4): arr = [<u>1</u>, <u>4</u>, <u>2</u>, <u>3</u>]
 * After 2nd flip (k = 2): arr = [<u>4</u>, <u>1</u>, 2, 3]
 * After 3rd flip (k = 4): arr = [<u>3</u>, <u>2</u>, <u>1</u>, <u>4</u>]
 * After 4th flip (k = 3): arr = [<u>1</u>, <u>2</u>, <u>3</u>, 4], which is sorted.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> arr = [1,2,3]
 * <strong>Output:</strong> []
 * <strong>Explanation: </strong>The input is already sorted, so there is no need to flip anything.
 * Note that other answers, such as [3, 3], would also be accepted.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= arr.length &lt;= 100</code></li>
 * <li><code>1 &lt;= arr[i] &lt;= arr.length</code></li>
 * <li>All integers in <code>arr</code> are unique (i.e. <code>arr</code> is a permutation of the integers from <code>1</code> to <code>arr.length</code>).</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 双指针 | 排序</details><br>
 *
 * <div>👍 306, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * Pancake Sorting
 *
 * @author DY
 * @date 2023-06-28 15:21:59
 */
public class PNine69_PancakeSorting {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PNine69_PancakeSorting().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> pancakeSort(int[] arr) {
            List<Integer> res = new LinkedList<>();
            sort(arr, arr.length, res);
            return res;
        }

        private void sort(int[] arr, int n, List<Integer> res) {
            if (n == 1) return;
            int max = arr[0], index = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    index = i;
                }
            }
            reverse(arr, 0, index);
            res.add(index + 1);
            reverse(arr, 0, n - 1);
            res.add(n);

            sort(arr, n - 1, res);
        }

        private void reverse(int[] arr, int i, int j) {
            while (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                ++i;
                --j;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
