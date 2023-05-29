package review;

public class findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return find(nums1, 0, nums2, 0, len / 2 + 1);
        }
        return (find(nums1, 0, nums2, 0, len / 2) + find(nums1, 0, nums2, 0, len / 2 + 1)) / 2;
    }

    private double find(int[] nums1, int x, int[] nums2, int y, int k) {
        if (x >= nums1.length)
            return nums2[y + k - 1];
        if (y >= nums2.length)
            return nums1[x + k - 1];
        if (k == 1)
            return Math.min(nums1[x], nums2[y]);
        int delNum = k / 2;
        int mid1 = (x + k - 1) < nums1.length ? nums1[x + k - 1] : Integer.MAX_VALUE;
        int mid2 = (y + k - 1) < nums2.length ? nums2[y + k - 1] : Integer.MAX_VALUE;
        if (mid1 < mid2) {// 删除左边
            return find(nums1, x + delNum, nums2, y, k - delNum);
        }
        return find(nums2, x, nums2, y + delNum, k - delNum);

    }
}
