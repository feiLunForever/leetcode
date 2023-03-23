package org.example.算法.排序;

/**
 * 归并排序
 */
public class MergeSort {
    public void sort(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        sort(nums, temp, 0, n - 1);
    }

    private void sort(int[] nums, int[] temp, int l, int r) {
        if (l == r) return; // 单个元素不用排序
        int mid = l + (r - l) / 2;
        sort(nums, temp, l, mid); // 先对左半部分数组 nums[l..mid] 排序
        sort(nums, temp, mid + 1, r); // 再对右半部分数组 nums[mid+1..r] 排序
        merge(nums, temp, l, mid, r); // 将两部分有序数组合并成一个有序数组
    }

    /**
     * 将 nums[l..mid] 和 nums[mid+1,r] 合并成有序数组
     *
     * @param nums
     * @param temp
     * @param l
     * @param mid
     * @param r
     */
    private void merge(int[] nums, int[] temp, int l, int mid, int r) {
        for (int i = l; i <= r; i++) { // 先把 nums[l..r] 复制到辅助数组中, 以便合并后的结果能够直接存入 nums
            temp[i] = nums[i];
        }
        int i = l, j = mid + 1; // i,j 分别代表 两个数组的下标
        for (int k = l; k <= r; k++) {
            if (i == mid + 1) { // 左半边数组已全部被合并
                nums[k] = temp[j++];
            } else if (j == r + 1) { // 右半边数组已全部被合并
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
        }
    }
}
