package dto;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;

public class Test {
    private static int min = Integer.MAX_VALUE;
    private static int[][] fx = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 0, 0, 0, 0}, {0, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int n = grid.length;
        LinkedList<List<Integer>> trace = new LinkedList<>();
        boolean[][] used = new boolean[n][n];

        backTrace(grid, 0, 0, 4, 4, trace, used);
        System.out.println(res);
    }

    public static void backTrace(int[][] grid, int startI, int startJ, int endI, int endJ,
                                 LinkedList<List<Integer>> trace, boolean[][] used) {

        if (startI == endI && startJ == endJ) {
            if (min > trace.size()) {
                res = new LinkedList<>(trace);
                min = trace.size();
            }
        }
        if(used[startI][startJ]) return;
        for (int[] next : buildNeighbor(grid, startI, startJ)) {
            if (grid[next[0]][next[1]] == 0 && !used[next[0]][next[1]]) {
                trace.add(Lists.newArrayList(next[0], next[1]));
                used[next[0]][next[1]] = true;

                backTrace(grid, next[0], next[1], endI, endJ, trace, used);

                trace.removeLast();
                used[next[0]][next[1]] = false;
            }
        }

    }

    private static List<int[]> buildNeighbor(int[][] grid, int i, int j) {
        List<int[]> res = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        for (int[] item : fx) {
            int nextI = i + item[0];
            int nextJ = j + item[1];
            if (nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n) {
                continue;
            }
            res.add(new int[]{nextI, nextJ});
        }
        return res;
    }
}
