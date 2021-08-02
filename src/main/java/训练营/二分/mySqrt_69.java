package 训练营.二分;

public class mySqrt_69 {
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 0, r = (x + 1) / 2;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            int temp = x / mid;
            if (temp == mid) {
                return mid;
            } else if (temp > mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r; // 向下取整，所以返回右边界
    }

}
