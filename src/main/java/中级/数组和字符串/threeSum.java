package 中级.数组和字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || len < 3) {
            return lists;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (nums[i] > 0)
                break;
            // 去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int res = nums[i] + nums[l] + nums[r];
                if (res == 0) {
                    lists.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 去重
                    while (l < r && nums[l] == nums[l + 1])
                        l++;
                    // 去重
                    while (l < r && nums[r] == nums[r - 1])
                        r--;
                    l++;
                    r--;
                } else if (res < 0)
                    l++;
                else
                    r--;
            }
        }
        return lists;
    }
}
