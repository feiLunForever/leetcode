package 面试整理.递归和回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 */
public class permute_17 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null)
            return res;
        boolean[] used = new boolean[nums.length]; // 标记是否已经使用
        List<Integer> deque = new LinkedList<>(); // 记录当前路径上的节点
        dfs(nums, 0, deque, used, res);
        return res;
    }

    private static void dfs(int[] nums, int index, List<Integer> deque, boolean[] used, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(deque)); // 一定要注意新建立数组，地址引用
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) { // 未使用当前节点
                deque.add(nums[i]);
                used[i] = true; // 标记已使用
                dfs(nums, index + 1, deque, used, res); // 递归
                deque.remove(deque.size() - 1); // 精髓就是撤销上一个节点
                used[i] = false; // 标记上一个节点未使用
                // 精髓来了！！！由于i++，加上此时已经撤销了上一个节点，所以会用下一个节点填充到路径中，
                // 然后递归调用，找到未使用个节点，放到路径中这样就形成了全排列
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println();
    }
}
