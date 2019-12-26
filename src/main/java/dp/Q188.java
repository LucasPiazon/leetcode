package dp;

/**
 * @author chelsea
 * @date 2019-12-24
 * 买卖股票的最佳时机 IV
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易
 * 1.如果k>length/2,变成II
 * 2.则变为k*2+1段,f(i,j)代表第i-1天第j阶段的最大收银
 * 持有股票的时候：f(i,j)=max{f(i-1,j-1),f(i-1,j)+prices[i-1]-prices[i-2]}
 * 未持有股票的时候:f(i,j)=max{f(i-1,j),f(i-1,j-1)+prices[i-1]-prices[i-2]}
 */
public class Q188 {

    static class Solution {
        public int maxProfit(int k, int[] prices) {
            int m = prices.length;
            if (k <= 0 || m == 0) {
                return 0;
            }
            if (k > (prices.length / 2)) {
                //1.如果第二天的价格比第一天的价格高就前一天买第二天卖
                int profit = 0;
                for (int i = 0; i < prices.length - 1; i++) {
                    if (prices[i] < prices[i + 1]) {
                        profit += (prices[i + 1] - prices[i]);
                    }
                }
                return profit;
            } else {
                int[][] dp = new int[m + 1][2 * k + 1 + 1];
                for (int i = 2; i <= m; i++) {
                    for (int j = 2; j <= 2 * k + 1; j++) {
                        //持有股票的时候
                        if (j % 2 == 0) {
                            dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j] + prices[i - 1] - prices[i - 2]);
                        } else {
                            dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i - 1] + prices[i - 2]);
                        }
                        System.out.println("i=" + i + "," + "j=" + j + ":" + dp[i][j]);
                    }
                }
                int res = 0;
                for (int i = 1; i < dp[m].length; i++) {
                    res = Math.max(res, dp[m][i]);
                }
                return res;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = {1, 2};
        solution.maxProfit(1, num);
    }

}
