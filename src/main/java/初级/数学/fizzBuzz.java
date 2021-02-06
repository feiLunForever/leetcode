package 初级.数学;

import java.util.ArrayList;
import java.util.List;

public class fizzBuzz {

    public List<String> fizzBuzz(int n) {
        if (n <= 0) {
            return null;
        }

        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }

        return res;
    }


}
