package 训练营.二分;

public class mySqrt_69 {
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 0, r = x / 2;
        while (l <= r) { // 在区间 [left..right] 查找目标元素
            int mid = l + (r - l + 1) / 2;
            int temp = x / mid; // 注意：这里为了避免乘法溢出，改用除法
            if (temp == mid) {
                return mid;
            } else if (temp > mid) { // 下一轮搜索区间是 [mid+1..right]
                l = mid + 1;
            } else {
                r = mid - 1; // 下一轮搜索区间是 [left..mid-1]
            }
        }
        return r; // 向下取整，所以返回右边界
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
    }

}
