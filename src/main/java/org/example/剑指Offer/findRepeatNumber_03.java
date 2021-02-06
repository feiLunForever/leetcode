package org.example.剑指Offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class findRepeatNumber_03 {
    public static int findRepeatNumber(int[] nums) {
        Map map = new HashMap();
        for (int i : nums) {
            if (map.containsKey(i)) {
                return i;
            }
            map.put(i, 0);
        }
        return -1;
    }

    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }
}
