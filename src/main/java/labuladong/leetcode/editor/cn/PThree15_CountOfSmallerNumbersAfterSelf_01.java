/**
 * <p>Given an integer array <code>nums</code>, return<em> an integer array </em><code>counts</code><em> where </em><code>counts[i]</code><em> is the number of smaller elements to the right of </em><code>nums[i]</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [5,2,6,1]
 * <strong>Output:</strong> [2,1,1,0]
 * <strong>Explanation:</strong>
 * To the right of 5 there are <b>2</b> smaller elements (2 and 1).
 * To the right of 2 there is only <b>1</b> smaller element (1).
 * To the right of 6 there is <b>1</b> smaller element (1).
 * To the right of 1 there is <b>0</b> smaller element.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [-1]
 * <strong>Output:</strong> [0]
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [-1,-1]
 * <strong>Output:</strong> [0,0]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>树状数组 | 线段树 | 数组 | 二分查找 | 分治 | 有序集合 | 归并排序</details><br>
 *
 * <div>👍 1028, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Count of Smaller Numbers After Self
 *
 * @author DY
 * @date 2023-11-17 17:24:28
 */
public class PThree15_CountOfSmallerNumbersAfterSelf_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PThree15_CountOfSmallerNumbersAfterSelf_01().new Solution();
        solution.countSmaller(new int[]{5, 2, 6, 1});
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] temp;

        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            temp = new int[n][2];
            List<Integer> res = new ArrayList<>(n);
            int[] result = new int[n];
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i] = new int[]{nums[i], i};
            }
            sort(arr, 0, n - 1, result);
            for (int item : result) {
                res.add(item);
            }
            return res;
        }

        private void sort(int[][] arr, int l, int r, int[] res) {
            if (l == r) return;
            int mid = l + (r - l) / 2;
            sort(arr, l, mid, res);
            sort(arr, mid + 1, r, res);
            merge(arr, l, mid, r, res);
        }

        private void merge(int[][] arr, int l, int mid, int r, int[] res) {
            for (int i = l; i <= r; i++) {
                temp[i] = arr[i];
            }
            int i = l, j = mid + 1;
            for (int k = l; k <= r; k++) {
                if (i == mid + 1) {
                    arr[k] = temp[j++];
                } else if (j == r + 1) {
                    arr[k] = temp[i++];
                    res[arr[k][1]] += j - (mid + 1);
                } else if (temp[i][0] > temp[j][0]) {
                    arr[k] = temp[j++];
                } else {
                    arr[k] = temp[i++];
                    res[arr[k][1]] += j - (mid + 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
