package review;

public class myPow {
    public double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        // terminator
        if (n == 0)
            return 1.0;
        // process
        double half = fastPow(x, n / 2);
        // drill down
        return (n % 2) == 0 ? half * half : half * half * x;
        // reverse status
    }
}
