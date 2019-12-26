package dp;

/**
 * @author chelsea
 * @date 2019-12-24
 * <p>
 * 买卖股票的最佳时机
 */
public class Q121 {

    static class Solution {

        public int maxProfit(int[] prices) {
            int m = prices.length;
            if (m == 0 || m == 1) {
                return 0;
            }
            int[] num = new int[m];
            int max = 0;
            num[0] = prices[0];
            for (int i = 1; i < prices.length; i++) {
                num[i] = Math.min(prices[i], num[i - 1]);
                if (prices[i] >= num[i - 1]) {
                    max = Math.max(prices[i] - num[i - 1], max);
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] profile = {7, 1, 5, 3, 6, 4};
        solution.maxProfit(profile);
    }
}
