package 初级.排序和搜索;

public class merge {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, max = m + n - 1;
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[max--] = nums1[p1--];
            } else {
                nums1[max--] = nums2[p2--];
            }
        }
    }

}
