package review;

import java.util.Arrays;
import java.util.Stack;

public class largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        // 哨兵机制
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.empty() && newHeights[i] < newHeights[stack.peek()]) {
                int height = newHeights[stack.pop()];
                max = Math.max(max, (i - stack.peek() - 1) * height);
            }
            stack.push(i);
        }
        return max;
    }
}
