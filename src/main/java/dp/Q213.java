package dp;

/**
 * @author chelsea
 * @date 2019-12-24
 * <p>
 * 打家劫舍，头和尾不能同时偷
 * 1.要么只偷头，要么只偷尾
 * 只偷头：0..n-2,只偷尾：1..n-1
 * 2.转移方程：f(i,0)=max{f(i-1,0),f(i-1,1)}
 * f(i,1)=f(i-1,0)+nums[i-1]
 */
public class Q213 {

    public int rob(int[] nums) {
        int m = nums.length;
        if (m == 0) {
            return 0;
        }
        if (m == 1) {
            return nums[0];
        }
        //1.只偷第一个房间0~n-2
        int[][] f1 = new int[m + 1][2];
        for (int i = 1; i < m; i++) {
            f1[i][0] = Math.max(f1[i - 1][0], f1[i - 1][1]);
            f1[i][1] = f1[i - 1][0] + nums[i - 1];
        }
        //2.只偷最后一个房间1~n-1
        int[][] f2 = new int[m + 1][2];
        for (int i = 2; i <= m; i++) {
            f2[i][0] = Math.max(f2[i - 1][0], f2[i - 1][1]);
            f2[i][1] = f2[i - 1][0] + nums[i - 1];
        }
        return Math.max(Math.max(f1[m - 1][0], f1[m - 1][1]), Math.max(f2[m][0], f2[m][1]));
    }
}
