package 初级.数组;

public class isValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        int row[][] = new int[9][9];
        int col[][] = new int[9][9];
        int sbox[][] = new int[9][9];
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {

                    int num = board[i][j] - '1';

                    int index = (i / 3) * 3 + j / 3;

                    if (row[i][num] == 1) {
                        return false;
                    } else {
                        row[i][num] = 1;
                    }

                    if (col[j][num] == 1) {
                        return false;
                    } else {
                        col[j][num] = 1;
                    }

                    if (sbox[index][num] == 1) {
                        return false;
                    } else {
                        sbox[index][num] = 1;
                    }

                }

            }
        }
        return true;
    }

}
