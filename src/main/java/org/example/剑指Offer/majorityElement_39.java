package org.example.剑指Offer;

import java.util.HashMap;
import java.util.Map;

public class majorityElement_39 {

    public static int majorityElement(int[] nums) {
        if (nums == null) return 0;
        if(nums.length == 1) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
                if (map.get(i) > nums.length / 2) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static int majorityElement1(int[] nums) {
        int x = 0, votes = 0;
        for (int i : nums) {
            if (votes == 0)
                x = i;
            votes += x == i ? 1 : -1;
        }
        return x;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        System.out.println(majorityElement(nums));
    }

}
