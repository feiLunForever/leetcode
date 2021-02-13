package 面试整理.数组;

import java.util.HashSet;
import java.util.Set;

/**
 * 滑动窗口+查找表
 */
public class containsNearbyDuplicate_219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if (set.size() > k)
                set.remove(nums[i - k]);
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3);
        System.out.println(b);
    }
}
