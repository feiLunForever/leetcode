package review;

public class mySqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int l = 2, r = x / 2;
        while (l <= r) {
            int mid = l + (r - l + 1) / 2;
            int temp = x / mid;
            if (temp == mid) {
                return mid;
            } else if (temp < mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
