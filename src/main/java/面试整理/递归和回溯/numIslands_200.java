package 面试整理.递归和回溯;

import java.util.LinkedList;
import java.util.Queue;

public class numIslands_200 {
    public int numIslands1(char[][] grid) {
        // 判断 base case
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

    void dfs(char[][] grid, int r, int c) {
        // 判断 base case
        if (!inArea(grid, r, c)) {
            return;
        }
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != 1) {
            return;
        }
        grid[r][c] = 2; // 将格子标记为「已遍历过」

        // 访问上、下、左、右四个相邻结点
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    // 判断坐标 (r, c) 是否在网格中
    boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
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

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();  // 存放x，y的坐标
        queue.offer(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            r = poll[0]; // x坐标
            c = poll[1]; // y坐标

            // 判断 base case
            if (!inArea(grid, r, c)) {
                continue;
            }
            // 如果这个格子不是岛屿，直接continue，开始下次循环
            if (grid[r][c] != 1) {
                continue;
            }
            grid[r][c] = 2; // 将格子标记为「已遍历过」

            queue.offer(new int[]{r - 1, c});
            queue.offer(new int[]{r + 1, c});
            queue.offer(new int[]{r, c - 1});
            queue.offer(new int[]{r, c + 1});
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

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot)
                return;
            parents[xRoot] = yRoot;
            count--;
        }

        public int find(int element) {
            while (parents[element] != element) {
                parents[element] = parents[parents[element]];
                element = parents[element];
            }
            return element;
        }
    }


    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        numIslands_200 islands = new numIslands_200();
        System.out.println(islands.numIslands3(grid));
    }


}