package 面试整理.递归和回溯;

import java.util.*;

public class solveNQueens_51 {
    boolean[] cols; // 标记某个列是否存在皇后
    Map<Integer, Boolean> diaLeft; // 左对角线是否存在皇后
    Map<Integer, Boolean> diaRight; // 右对角线是否存在皇后

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0)
            return res;
        List<Integer> deque = new LinkedList<>();
        cols = new boolean[n];
        diaLeft = new HashMap<>(2 * n - 1);
        diaRight = new HashMap<>(2 * n - 1);
        dfs(n, 0, deque, res);
        return res;
    }


    private void dfs(int n, int index, List<Integer> deque, List<List<String>> res) {
        if (index == n) {
            res.add(buildBoard(deque));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!cols[i]
                    && !diaLeft.getOrDefault(index + i, false)
                    && !diaRight.getOrDefault(index - i, false)) {
                deque.add(i);
                cols[i] = true;
                diaLeft.put(index + i, true);
                diaRight.put(index - i, true);
                dfs(n, index + 1, deque, res);
                deque.remove(deque.size() - 1);
                cols[i] = false;
                diaLeft.put(index + i, false);
                diaRight.put(index - i, false);
            }
        }
    }

    private List<String> buildBoard(List<Integer> deque) {
        int n = deque.size();
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[deque.get(i)] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        solveNQueens_51 test = new solveNQueens_51();
        List<List<String>> lists = test.solveNQueens(4);
        System.out.println();
    }
}
