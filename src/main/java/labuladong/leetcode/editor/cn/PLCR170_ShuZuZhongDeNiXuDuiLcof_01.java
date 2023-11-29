/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>树状数组 | 线段树 | 数组 | 二分查找 | 分治 | 有序集合 | 归并排序</details><br>
 *
 * <div>👍 1079, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 交易逆序对的总数
 *
 * @author DY
 * @date 2023-11-29 14:59:44
 */
public class PLCR170_ShuZuZhongDeNiXuDuiLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PLCR170_ShuZuZhongDeNiXuDuiLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] temp;
        private int count;

        public int reversePairs(int[] record) {
        	if(record.length == 0) return 0;
            temp = new int[record.length];
            sort(record, 0, record.length - 1);
            return count;
        }

        private void sort(int[] record, int lo, int hi) {
            if (lo == hi) return;
            int mid = lo + (hi - lo) / 2;
            sort(record, lo, mid);
            sort(record, mid + 1, hi);
            merge(record, lo, mid, hi);
        }

        private void merge(int[] record, int lo, int mid, int hi) {
            for (int i = lo; i <= hi; i++) {
                temp[i] = record[i];
            }

            int end = mid + 1;
            for (int i = lo; i <= mid; i++) {
                while (end <= hi && record[i] > record[end]) {
                    ++end;
                }
                count += end - (mid + 1);
            }

            int i = lo, j = mid + 1;
            for (int p = lo; p <= hi; p++) {
                if (i == mid + 1) {
                    record[p] = temp[j++];
                } else if (j == hi + 1) {
                    record[p] = temp[i++];
                } else if (temp[i] <= temp[j]) {
                    record[p] = temp[i++];
                } else {
                    record[p] = temp[j++];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
