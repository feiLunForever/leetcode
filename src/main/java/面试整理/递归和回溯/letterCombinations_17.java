package 面试整理.递归和回溯;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations_17 {
    private static final String[] mappings = {
            " ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        dfs(digits, 0, "", res);
        return res;
    }

    private static void dfs(String digits, int index, String tempStr, List<String> res) {
        if (index == digits.length()) {
            res.add(tempStr);
            return;
        }
        String letters = mappings[digits.charAt(index) - '0'];
        for (Character ch : letters.toCharArray()) {
            dfs(digits, index + 1, tempStr + ch, res);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
