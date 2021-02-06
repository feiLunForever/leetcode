package 中级.回溯算法;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null | digits.length() == 0) {
            return res;
        }
        String[] mappings = {
                " ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            String letter = mappings[digits.charAt(i) - '0'];
            int size = res.size();
            for (int j = 0; j < size; j++) {
                String poll = res.remove(0);
                for (int k = 0; k < letter.length(); k++) {
                    res.add(poll + letter.charAt(k));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
