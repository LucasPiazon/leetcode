package dp;

/**
 * @author chelsea
 * @date 2019-12-24
 * <p>
 * 买卖股票的最佳时机 III
 * <p>
 * 将买卖分为5个阶段
 * f(i,j)表示在前i天(第i天)结束或，在j阶段获得的最大利润
 * 1.f(i,j)=max{f(i-1,j),f(i-1,j-1)+prices[i-1]-prices[i-2]} 阶段1，3，5
 * 2.f(i,j)=max{f(i-1,j-1),f(i-1,j)+prices[i-1]-price[i-2]}  阶段2，4
 */
public class Q123 {
    static class Solution {
        public int maxProfit(int[] prices) {
            int m = prices.length;
            if (m == 0) {
                return 0;
            }
            int[][] f = new int[m + 1][5 + 1];
            //1.第一天只能处于1，2阶段都没有收益，处于第一阶段也都没有收益
            for (int i = 2; i <= m; i++) {
                for (int j = 1; j <= 5; j++) {
                    if (j == 2 || j == 4) {
                        f[i][j] = Math.max(f[i - 1][j - 1], f[i - 1][j] + prices[i - 1] - prices[i - 2]);
                    }
                    if (j == 3 || j == 5) {
                        f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                    }
                    //System.out.println("i=" + i + "," + "j=" + j + ":" + f[i][j]);
                }
            }
            int max = 0;
            for (int i = 1; i <= 5; i++) {
                max = Math.max(max, f[m][i]);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(solution.maxProfit(num));
    }
}
