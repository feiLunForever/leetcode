package 中级.回溯算法;

public class exist {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int index) {
        // 边界值判断
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[index])
            return false;
        //如果word的每个字符都查找完了，直接返回true
        if (index == words.length - 1)
            return true;
        //然后修改当前坐标的值
        char temp = board[i][j];
        board[i][j] = '#';
        boolean res = (dfs(board, words, i - 1, j, index + 1) || dfs(board, words, i + 1, j, index + 1)
                || dfs(board, words, i, j - 1, index + 1) || dfs(board, words, i, j + 1, index + 1));
        //递归之后再把当前的坐标复原
        board[i][j] = temp;
        return res;
    }

}
