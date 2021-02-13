package 面试整理.查找表;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class intersect_350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums2.length];
        int index = 0;
        for (int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                res[index++] = num;
                if (--count > 0)
                    map.put(num, count);
                else
                    map.remove(num);
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }

    public static void main(String[] args) {
        int[] intersect = intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        System.out.println();
    }
}
