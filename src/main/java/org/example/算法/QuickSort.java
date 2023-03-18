package org.example.算法;

import java.util.Arrays;

public class QuickSort {

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];
        return quickSort(nums, 0, nums.length - 1, k - 1);
    }

    /**
     * 快速排序
     *
     * @param originArray 原数组
     * @param start       开始下标
     * @param end         结束下标
     * @param target      目标下标
     * @return
     */
    private static int[] quickSort(int[] originArray, int start, int end, int target) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数
        int k = partition(originArray, start, end);
        if (k == target)
            return Arrays.copyOfRange(originArray, 0, k + 1);
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return k > target ? quickSort(originArray, start, k - 1, target)
                : quickSort(originArray, k + 1, end, target);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{2, 3, 4, 2, 4, 5}, 0, 5)));
    }

    public void sort(int[] nums) {
        // 排序整个数组（原地修改）
        quickSort(nums, 0, nums.length - 1);
    }

    private static int[] quickSort(int[] arr, int l, int r) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数
        int k = partition(arr, l, r);
        if (k != -1) {
            quickSort(arr, l, k - 1);
            quickSort(arr, k + 1, r);
        }
        return arr;
    }

    /**
     * 快排切分，返回下标k，使得比nums[k]小的数都在k的左边，比nums[k]大的数都在k的右边。
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition(int[] arr, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return -1;
        int target = arr[l]; // 以起点作为基准
        int i = l;
        int j = r;
        while (i < j) {
            while (i < j && arr[j] >= target) // 找到比基准值小的值为止
                --j;
            while (i < j && arr[i] <= target) // 找到比基准值大的值为止
                ++i;
            swap(arr, i, j); // 交换位置
        }
        swap(arr, l, i); // 最后将 target 放到合适的位置，即 target 左边元素较小，右边元素较大
        return i;
    }


    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}
