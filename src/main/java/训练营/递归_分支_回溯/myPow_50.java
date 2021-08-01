package 训练营.递归_分支_回溯;

public class myPow_50 {
    public static double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }

    private static double fastPow(double x, int n) {
        // terminator
        if (n == 0)
            return 1.0;
        // process
        double half = fastPow(x, n / 2);
        // drill down
        return (n % 2) == 0 ? half * half : half * half * x;
        // reverse status
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 3));
    }
}
