package review;

public class minArray {
    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] < numbers[high]) {// m 一定在 左排序数组 中，即旋转点 xx 一定在 [m + 1, j][m+1,j] 闭区间内
                high = mid;
            } else if (numbers[mid] > numbers[high]) { //mm 一定在 右排序数组 中，即旋转点 xx 一定在[i, m][i,m] 闭区间内
                low = mid;
            } else {
                high--;
            }
        }
        return numbers[low];
    }
}
