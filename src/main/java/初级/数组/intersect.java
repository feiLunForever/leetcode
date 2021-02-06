package 初级.数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class intersect {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        int[] results = new int[nums1.length];
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            int count = map.getOrDefault(nums2[i], 0);
            if (count > 0) {
                count--;
                if (count > 0) {
                    map.put(nums2[i], count);
                } else {
                    map.remove(nums2[i]);
                }
                results[index++] = nums2[i];
            }
        }
        return Arrays.copyOfRange(results, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        int[] intersect = intersect(nums1, nums2);
        System.out.println();
    }

}
