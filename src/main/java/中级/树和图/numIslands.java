package 中级.树和图;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class numIslands {
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int ri = grid.length;
        int rj = grid[0].length;
        int num = 0;
        for (int i = 0; i < ri; i++) {
            for (int j = 0; j < rj; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int i, int j) {
        int ri = grid.length;
        int rj = grid[0].length;
        if (i < 0 || j < 0 || i >= ri || j >= rj || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }


    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int ri = grid.length;
        int rj = grid[0].length;
        int num = 0;
        for (int i = 0; i < ri; i++) {
            for (int j = 0; j < rj; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    bfs(grid, i, j);
                }
            }
        }
        return num;
    }

    private void bfs(char[][] grid, int i, int j) {
        int ri = grid.length;
        int rj = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            i = poll[0];
            j = poll[1];
            if (i < 0 || j < 0 || i >= ri || j >= rj || grid[i][j] == '0')
                continue;
            grid[i][j] = '0';
            queue.offer(new int[]{i - 1, j});
            queue.offer(new int[]{i + 1, j});
            queue.offer(new int[]{i, j - 1});
            queue.offer(new int[]{i, j + 1});
        }
    }

    public int numIslands3(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int x = grid.length;
        int y = grid[0].length;

        QuickUnion union = new QuickUnion(grid);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == '1') {
                    // 下侧
                    if (i + 1 < x && grid[i + 1][j] == '1')
                        union.union(i * y + j, (i + 1) * y + j);
                    // 右侧
                    if (j + 1 < y && grid[i][j + 1] == '1')
                        union.union(i * y + j, i * y + j + 1);
                }
            }
        }
        return union.count;
    }

    public class QuickUnion {
        private int[] parents;
        private int count = 0;

        QuickUnion(char[][] grid) {
            int x = grid.length;
            int y = grid[0].length;
            parents = new int[x * y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (grid[i][j] == '1') {
                        // 初始化指向自己
                        parents[i * y + j] = i * y + j;
                        count++;
                    }
                }
            }
        }

        private void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot)
                return;
            parents[xRoot] = yRoot;
            count--;
        }

        public int find(int i) {
            while (parents[i] != i) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }
    }


    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        numIslands islands = new numIslands();
        System.out.println(islands.numIslands3(grid));
    }


}
