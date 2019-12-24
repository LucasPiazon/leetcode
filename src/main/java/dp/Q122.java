package dp;

/**
 * @author chelsea
 * @date 2019-12-24
 * <p>
 * 买卖股票的最佳时机 II，可以买卖多次，如果第二天比前一天高，就卖
 */
public class Q122 {
    public int maxProfit(int[] prices) {
        int m = prices.length;
        int profit = 0;
        for (int i = 0; i < m - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

}
