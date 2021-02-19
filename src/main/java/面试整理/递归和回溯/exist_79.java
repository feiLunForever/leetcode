package 面试整理.递归和回溯;

public class exist_79 {
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    /**
     * dfs 从 board[x][y]开始，寻找word[index ... word.size()]
     *
     * @param board
     * @param word
     * @param x
     * @param y
     * @param index
     * @return
     */
    private static boolean dfs(char[][] board, String word, int x, int y, int index) {
        // 边界值判断
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index))
            return false;
        if (index == word.length() - 1) // 最后一位，则直接比较数值是否相等
            return true;
        // 标记是否已经访问过，有两种方法，一种是用一个visit[]标记，
        // 另一种是直接修改二维数组的值，标识已经访问过，递归回来的时候在修改回去
        char temp = board[x][y];
        board[x][y] = '#';
        // 递归遍历四个方向
        boolean res = dfs(board, word, x - 1, y, index + 1)
                || dfs(board, word, x + 1, y, index + 1)
                || dfs(board, word, x, y - 1, index + 1)
                || dfs(board, word, x, y + 1, index + 1);
        //递归之后再把当前的坐标复原
        board[x][y] = temp;
        return res;
    }

    public static void main(String[] args) {
        boolean abcb = exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB");
        System.out.println(abcb);
    }
}
