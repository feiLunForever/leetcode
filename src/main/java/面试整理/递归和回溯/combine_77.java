package 面试整理.递归和回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 */
public class combine_77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0 || k > n)
            return res;
        List<Integer> deque = new LinkedList<>();
        dfs(n, k, 1, deque, res);
        return res;
    }

    private void dfs(int n, int k, int index, List<Integer> deque, List<List<Integer>> res) {
        if (deque.size() == k) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = index; i <= n; i++) {
            deque.add(i);
            dfs(n, k, i + 1, deque, res);
            deque.remove(deque.size() - 1);
        }
    }

}
