package 面试整理.动态规划;

public class climbStairs_70 {
    public int climbStairs(int n) {
        int[] climbs = new int[n + 1];
        climbs[0] = 1;
        climbs[1] = 1;
        for (int i = 2; i <= n; i++)
            climbs[i] = climbs[i - 1] + climbs[i - 2];
        return climbs[n];
    }
}
