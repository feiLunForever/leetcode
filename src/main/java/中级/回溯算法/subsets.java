package 中级.回溯算法;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, int start) {
        // 走过的所有路径都是子集的一部分，所以都要加入到集合中
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            // 做出选择
            tempList.add(nums[i]);
            // 递归
            backtrack(list, tempList, nums, i + 1);
            // 撤销
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }
}
