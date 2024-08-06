package org.example.算法.排序;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 7, 4};
        int[] nums1 = new int[]{3, 2, 1, 5, 6, 4};
        int[] nums2 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] nums3 = new int[]{0,0,2,3,2,1,1,2,0,4};
        int[] nums4 = new int[]{0,0,1,2,4,2,2,3,1,4};
//        sort(nums);
//        sort(nums1);
//        sort(nums2);
//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(nums1));
//        System.out.println(Arrays.toString(nums2));
//        System.out.println(Arrays.toString(topKFrequent(nums2, 6)));
//        System.out.println(Arrays.toString(topKFrequent(nums3, 10)));
        System.out.println(Arrays.toString(topKFrequent(nums4, 8)));
//        System.out.println(findKthLargest(new int[]{1}, 1));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];
        quickSortK(nums, 0, nums.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    public static int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        k = nums.length - k; // 转化成「排名第 k 的元素」
        while (lo <= hi) {
            int p = partition(nums, lo, hi);
            if (p < k) {
                lo = p + 1;
            } else if (p > k) {
                hi = p - 1;
            } else {
                return nums[p];
            }
        }
        return -1;
    }

    public static void sort(int[] nums) {
        // 为了避免出现耗时的极端情况，先随机打乱
        shuffle(nums);
        // 排序整个数组（原地修改）
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        // 对 nums[lo..hi] 进行切分
        // 使得 nums[lo..p-1] <= nums[p] < nums[p+1..hi]
        int p = partition(nums, lo, hi);

        if (p != -1) {
            quickSort(nums, lo, p - 1);
            quickSort(nums, p + 1, hi);
        }
    }

    private static void quickSortK(int[] nums, int lo, int hi, int k) {
        if (lo >= hi) {
            return;
        }
        // 对 nums[lo..hi] 进行切分
        // 使得 nums[lo..p-1] <= nums[p] < nums[p+1..hi]
        int p = partition(nums, lo, hi);

        if (p < k) {
            quickSortK(nums, p + 1, hi, k);
        } else if (p > k) {
            quickSortK(nums, lo,p - 1, k);
        }
    }

    // 对 nums[lo..hi] 进行切分
    private static int partition(int[] arr, int lo, int hi) {
        // 子数组长度为 1 时终止递归
        if (lo > hi) return -1;
        int target = arr[lo]; // 以起点作为基准
        int i = lo;
        int j = hi;
        while (i < j) {
            while (i < j && arr[j] >= target) // 从后往前找 比基准值 小
                --j;
            while (i < j && arr[i] <= target) // 从前往后找 比基准值 大
                ++i;
            swap(arr, i, j); // 交换位置
        }
        // 此时，i和j是一样的
        swap(arr, lo, i); // 最后将 target 放到合适的位置，即 target 左边元素较小，右边元素较大
        return i;
    }


    // 洗牌算法，将输入的数组随机打乱
    private static void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 生成 [i, n - 1] 的随机数
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    // 原地交换数组中的两个元素
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
