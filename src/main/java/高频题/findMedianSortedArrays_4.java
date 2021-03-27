package 高频题;

public class findMedianSortedArrays_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if ((len & 1) == 1) { // 奇数个，则直接返回中间位置即可
            return find(nums1, 0, nums2, 0, (len >>> 1) + 1);
        } else {
            return (find(nums1, 0, nums2, 0, len >>> 1) + find(nums1, 0, nums2, 0, (len >>> 1) + 1)) / 2;
        }
    }

    /**
     * 找到两个数组合并后的第k大的值
     *
     * @param nums1
     * @param i
     * @param nums2
     * @param j
     * @param k
     * @return
     */
    private static double find(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) // nums1数组已经删除完了，所以直接返回nums2的j+k-1的值即可
            return nums2[j + k - 1];
        if (j >= nums2.length)
            return nums1[i + k - 1];
        if (k == 1)
            return Math.min(nums1[i], nums2[j]);
        int delNum = k >>> 1; // 每次删除一半的值
        // 计算两个数组第delNum个值，比较大小，来决定删除哪边的数据（值小的那一边）
        int mid1 = (i + delNum - 1) < nums1.length ? nums1[i + delNum - 1] : Integer.MAX_VALUE;
        int mid2 = (j + delNum - 1) < nums2.length ? nums2[j + delNum - 1] : Integer.MAX_VALUE;
        if (mid1 < mid2) {
            return find(nums1, i + delNum, nums2, j, k - delNum);
        }
        return find(nums1, i, nums2, j + delNum, k - delNum);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2};
        int[] arr2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

}
