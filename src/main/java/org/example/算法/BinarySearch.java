package org.example.算法;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) >>> 1;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}
