package 初级.其他;

public class hammingDistance {
    public static int hammingDistance(int x, int y) {
        int ans = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask & x) != (mask & y))
                ans++;
            mask <<= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
