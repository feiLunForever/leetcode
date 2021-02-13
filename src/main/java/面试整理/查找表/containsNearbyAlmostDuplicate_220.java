package 面试整理.查找表;

import java.util.TreeSet;

public class containsNearbyAlmostDuplicate_220 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long low = set.ceiling((long) nums[i] - t);
            if (low != null && low <= (long) nums[i] + t)  // nums[i] - t ~ nums[i] + t
                return true;
            set.add((long) nums[i]);
            if (set.size() > k)
                set.remove((long) nums[i - k]);
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = containsNearbyAlmostDuplicate(new int[]{2147483640, 2147483641}, 1, 100);
        System.out.println(b);
    }
}
