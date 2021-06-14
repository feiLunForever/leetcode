package 训练营.栈队列;

import java.util.Stack;

public class largestRectangleArea_89 {
    public int largestRectangleArea(int[] heights) {
        // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < newHeights.length; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积🌶️ ～
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int height = newHeights[stack.pop()];
                max = Math.max(max, (i - stack.peek() - 1) * height);
            }
            stack.push(i);
        }
        return max;
    }
}
