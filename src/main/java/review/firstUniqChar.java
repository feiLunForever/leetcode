package review;

import java.util.HashMap;
import java.util.Map;

public class firstUniqChar {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.containsKey(s.charAt(i)));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (!entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
