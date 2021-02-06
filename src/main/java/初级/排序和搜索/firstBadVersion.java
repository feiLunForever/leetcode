package 初级.排序和搜索;

public class firstBadVersion {

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    boolean isBadVersion(int version) {
        return true;
    }

}
