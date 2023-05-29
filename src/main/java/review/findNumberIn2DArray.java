package review;

public class findNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0, column = matrix[0].length - 1;
        while (row < matrix.length - 1 && column >= 0) {
            if (target == matrix[row][column]) {
                return true;
            } else if (target < matrix[row][column]) {//左移
                column--;
            } else {// 下移
                row++;
            }
        }
        return false;
    }
}
