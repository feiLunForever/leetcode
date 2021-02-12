package 面试整理.数组;

import java.util.HashMap;
import java.util.Map;

public class numberOfBoomerangs_447 {
    public static int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Long, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    Long distance = distance(points[i], points[j]);
                    map.put(distance, map.getOrDefault(distance, 0) + 1);
                }
            }
            for (Integer c : map.values()) {
                count += c * (c - 1);
            }
        }
        return count;
    }

    private static Long distance(int[] x, int[] y) {
        return Long.valueOf((x[0] - y[0]) * (x[0] - y[0])) +
                Long.valueOf((x[1] - y[1]) * (x[1] - y[1]));
    }

    public static void main(String[] args) {
        int i = numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}});
        System.out.println(i);
    }


}
