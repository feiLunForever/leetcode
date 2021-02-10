package 面试整理.数组;

import java.util.HashSet;
import java.util.Set;

public class intersection_349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> tempSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums1)
            tempSet.add(num);
        for (int num : nums2) {
            if (tempSet.contains(num))
                set.add(num);
        }
        int[] results = new int[set.size()];
        int i = 0;
        for (Integer num : set)
            results[i++] = num;
        return results;
    }

    public static void main(String[] args) {
        int[] intersection = intersection(new int[]{1, 2, 3}, new int[]{2, 3, 4});
        System.out.println();
    }
}
