/**
 * <p>Given an integer array <code>nums</code>, return <em>the number of <strong>reverse pairs</strong> in the array</em>.</p>
 *
 * <p>A <strong>reverse pair</strong> is a pair <code>(i, j)</code> where:</p>
 *
 * <ul>
 * <li><code>0 &lt;= i &lt; j &lt; nums.length</code> and</li>
 * <li><code>nums[i] &gt; 2 * nums[j]</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,3,2,3,1]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The reverse pairs are:
 * (1, 4) --&gt; nums[1] = 3, nums[4] = 1, 3 &gt; 2 * 1
 * (3, 4) --&gt; nums[3] = 3, nums[4] = 1, 3 &gt; 2 * 1
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [2,4,3,5,1]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The reverse pairs are:
 * (1, 4) --&gt; nums[1] = 4, nums[4] = 1, 4 &gt; 2 * 1
 * (2, 4) --&gt; nums[2] = 3, nums[4] = 1, 3 &gt; 2 * 1
 * (3, 4) --&gt; nums[3] = 5, nums[4] = 1, 5 &gt; 2 * 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 5 * 10<sup>4</sup></code></li>
 * <li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>树状数组 | 线段树 | 数组 | 二分查找 | 分治 | 有序集合 | 归并排序</details><br>
 *
 * <div>👍 430, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Reverse Pairs
 *
 * @author DY
 * @date 2023-11-22 19:39:25
 */
public class PFour93_ReversePairs_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFour93_ReversePairs_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] temp;
        private int count;

        public int reversePairs(int[] nums) {
            temp = new int[nums.length];
            sort(nums, 0, nums.length - 1);
            return count;
        }

        private void sort(int[] nums, int l, int r) {
            if (l == r) return;
            int mid = l + (r - l) / 2;
            sort(nums, l, mid);
            sort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }

        private void merge(int[] nums, int l, int mid, int r) {
            for (int i = l; i <= r; i++) {
                temp[i] = nums[i];
            }

            count(nums,l,mid,r);

            int i = l, j = mid + 1;
            for (int p = l; p <= r; p++) {
                if (i == mid + 1) {
                    nums[p] = temp[j++];
                } else if (j == r + 1) {
                    nums[p] = temp[i++];
                } else if (temp[i] <= temp[j]) {
                    nums[p] = temp[i++];
                } else {
                    nums[p] = temp[j++];
                }
            }
        }

		private void count(int[] nums, int l, int mid, int r) {
        	int j = mid + 1;
			for (int i = l; i <= mid; i++) {
				while (j <= r && (long) nums[i] > (long) nums[j] * 2) {
					++j;
				}
				count += j - (mid + 1);
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
