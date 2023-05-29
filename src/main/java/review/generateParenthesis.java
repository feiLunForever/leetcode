package review;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, n, n, "");
        return res;
    }

    private void dfs(List<String> res, int left, int right, String cur) {
        if (left == 0 && right == 0) {
            res.add(cur);
            return;
        }
        if (left > 0) {
            dfs(res, left - 1, right, cur + "(");
        }
        if (right > left) {
            dfs(res, left, right - 1, cur + ")");
        }

    }
}
