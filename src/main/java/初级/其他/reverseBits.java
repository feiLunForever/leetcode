package 初级.其他;

public class reverseBits {

    public int reverseBits(int n) {
        int res = 0;
        for (int bitSize = 31; n != 0; bitSize--, n >>>= 1) {
            res += (n & 1) << bitSize;
        }
        return res;
    }

}
