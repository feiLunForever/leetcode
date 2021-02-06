package org.example.美团;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    public static int[] twoSums(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer result = map.get(target - nums[i]);
            if (null != result)
                return new int[]{result, i};
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = twoSums(nums, 9);
        System.out.println();
    }
}
