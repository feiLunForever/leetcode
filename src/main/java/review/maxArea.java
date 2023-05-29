package review;

public class maxArea {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int minHeight = height[left] < height[right] ? height[left++] : height[right--];
            max = Math.max(max, (right - left + 1) * minHeight);
        }
        return max;
    }
}
