package labuladong.template;

import java.util.Stack;

public class MonotonicStack {

    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) { // 倒着往栈里放
            while (!stack.isEmpty() && stack.peek() <= nums[i]) { // 判定个子高矮
                stack.pop(); // 矮个子的起开，反正也被挡住了
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]); // 放入栈中
        }
        return res;
    }
}
