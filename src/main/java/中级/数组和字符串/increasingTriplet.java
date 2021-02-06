package 中级.数组和字符串;

public class increasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int three : nums) {
            if (three > second)
                return true;
            else if (three <= first)
                first = three;
            else
                second = three;
        }
        return false;
    }
}
