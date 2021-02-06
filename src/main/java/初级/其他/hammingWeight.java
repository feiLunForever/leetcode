package 初级.其他;

public class hammingWeight {
    public static int hammingWeight(int n) {
        int ans = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if((mask & n) != 0)
                ans++;
            mask <<= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(1));
    }
}
