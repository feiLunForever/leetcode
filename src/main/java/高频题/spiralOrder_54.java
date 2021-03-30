package 高频题;

import java.util.LinkedList;
import java.util.List;

public class spiralOrder_54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        circle(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, res);
        return res;
    }

    /**
     * 循环外圈
     * 以x1,y1为左上角线；x2,y2为右下角
     *
     * @param matrix
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param res
     */
    private static void circle(int[][] matrix, int x1, int y1, int x2, int y2, List<Integer> res) {
        if (x1 > x2 || y1 > y2)
            return;
        if (x1 == x2) { //只剩下一行
            for (int i = y1; i <= y2; i++)
                res.add(matrix[x1][i]);
            return;
        }
        if (y1 == y2) { //只剩下一列
            for (int i = x1; i <= x2; i++)
                res.add(matrix[i][y1]);
            return;
        }

        // 遍历当前圈
        for (int i = y1; i < y2; i++) res.add(matrix[x1][i]);
        for (int i = x1; i < x2; i++) res.add(matrix[i][y2]);
        for (int i = y2; i > y1; i--) res.add(matrix[x2][i]);
        for (int i = x2; i > x1; i--) res.add(matrix[i][y1]);

        //递归,缩小圈
        circle(matrix, x1 + 1, y1 + 1, x2 - 1, y2 - 1, res);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> list = spiralOrder(matrix);
        System.out.println();

    }
}
