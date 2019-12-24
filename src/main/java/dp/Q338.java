package dp;

/**
 * @author chelsea
 * @date 2019-12-23
 * <p>
 * 比特位计数:计算1~n的2进制1的个数
 * 1.最后一步：n去除最后一位后，n的二进制位数为n>>2的个数+最后一位是0或者1
 * 2.转移方程：f(n)=f(n/2)+n%2;
 */
public class Q338 {

    class Solution {

        public int[] countBits(int n) {
            int[] res = new int[n + 1];
            res[0] = 0;
            for (int i = 1; i <= n; i++) {
                res[i] = res[i >> 1] + i % 2;
            }
            return res;
        }
    }
}
