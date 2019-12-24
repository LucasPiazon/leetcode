package dp;

/**
 * @author chelsea
 * @date 2019-12-24
 * <p>
 * 整数拆分：给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 1.一定存在最后一个数k，使得乘积最大，则转化为(n-k)的拆分后的最大乘积
 * 2.f(i)为正整数n的拆分的最大乘积f(i)=max{max{f(i-k)*k,(i-k)*k}}(0<k<i)枚举k
 * 3.f(0)=0,f(1)=1,f(2)=1;
 */
public class Q343 {

    static class Solution {
        public int integerBreak(int n) {
            if (n == 0) {
                return 0;
            }
            int[] f = new int[n + 1];
            f[0] = 0;
            f[1] = 1;
            f[2] = 1;
            for (int i = 3; i <= n; i++) {
                f[i] = Integer.MIN_VALUE;
                for (int j = 1; j < i; j++) {
                    f[i] = Math.max(f[i], Math.max(f[i - j] * j, (i - j) * j));
                }
                System.out.println(f[i]);
            }
            return f[n];
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.integerBreak(10);
    }
}
