package org.example.算法;

import java.util.*;

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

    /**
     * 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
     *
     * @param originArray
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition(int[] originArray, int startIndex, int endIndex) {
        int pivot = originArray[startIndex];
        int start = startIndex;
        int end = endIndex;
        // 以起点作为基准
        while (start < end) {
            while (start < end && originArray[start] < pivot) // 找到比基准值大的值为止
                start++;
            while (end > start && originArray[end] > pivot) // 找到比基准值小的值为止
                end--;
            if (start < end)
                swap(originArray, start, end); // 交换位置
        }
        originArray[startIndex] = originArray[start];
        originArray[start] = pivot;
        return start;
    }


    private static void swap(int[] originArray, int start, int end) {
        int temp = originArray[start];
        originArray[start] = originArray[end];
        originArray[end] = temp;
    }

}
