package 中级.回溯算法;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list, n, n, "");
        return list;
    }

    private void dfs(List<String> list, int left, int right, String cur) {
        // 左右括号都不剩余了，递归终止
        if (left == 0 && right == 0) {
            list.add(cur);
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(list, left - 1, right, cur + "(");
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(list, left, right - 1, cur + ")");
        }
    }
}
