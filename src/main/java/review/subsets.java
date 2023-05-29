package review;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrace(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private void backtrace(List<List<Integer>> res, ArrayList<Integer> tempList, int[] nums, int start) {
        res.add(tempList);
        for (int i = 0; i < nums.length; i++) {
            // 选择
            tempList.add(nums[i]);
            // 递归
            backtrace(res, tempList, nums, start++);
            // 撤销
            tempList.remove(tempList.size() - 1);
        }
    }
}
