package dp;

/**
 * @author chelsea
 * @date 2019-12-24
 * <p>
 * 完全平方数n的完全平方数和最小
 * 1.最后一步：最后一段j2，则求n-j2的最小平方数和的个数
 * 2.f(i)表示最少分为几个平方数之和 f(i)=min(1<=j*j<=i){f(i-j2)}+1
 * 3.f(0)=0;f(1)=1;
 */
public class Q279 {

    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                f[i] = Math.min(f[i - j * j] + 1, f[i]);
            }
        }
        return f[n];
    }
}
