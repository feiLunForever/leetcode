package labuladong.template;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {


    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> trace = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrace(nums, trace, used, res);
        return res;
    }

    private static void backTrace(int[] nums, LinkedList<Integer> trace, boolean[] used, List<List<Integer>> res) {
        if (nums.length == trace.size()) {
            res.add(new LinkedList<>(trace));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            trace.add(nums[i]);
            used[i] = true;
            backTrace(nums,trace,used,res);

            trace.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4};

        System.out.println(permute(arr));

    }

}
