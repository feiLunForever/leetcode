package 面试整理.查找表;

import java.util.HashMap;
import java.util.Map;

public class fourSumCount_454 {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                count += map.getOrDefault(0 - C[i] - D[j], 0);
            }
        }
        return count;
    }
}
