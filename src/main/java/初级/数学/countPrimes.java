package 初级.数学;

import java.util.Arrays;

public class countPrimes {

    public static int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                ans += 1;
                for (long j = (long) i * i; j < n; j += i) {
                    isPrime[(int) j] = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 499979;
        System.out.println(countPrimes(n));
    }

}
