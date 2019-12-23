package dp;

/**
 * @author chelsea
 * @date 2019-12-23
 * <p>
 * 不同的路径:到达右下角的不通路径数
 * 1.最后一步：(m,n)只能是由(m-1,n)或者(m,n-1)过来
 * 2.转移方程：f(m,n)=f(m-1,n)+f(m,n-1)
 * 3.边界条件:f(0,n)=1,f(m,0)=1
 * 4.一行一行的计算
 */
public class Q62 {

    class Solution {

        public int uniquePaths(int m, int n) {
            if (m == 0 || n == 0) {
                return 0;
            }
            int[][] f = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        f[i][j] = 1;
                    }
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
            return f[m - 1][n - 1];
        }

        public int uniquePaths1(int m, int n) {
            if (m == 0 || n == 0) {
                return 0;
            }
            int[][] f = new int[2][n];
            int old = 0, now = 0;
            for (int i = 0; i < m; i++) {
                old = now;
                now = 1 - old;
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        f[now][j] = 1;
                    }
                    f[now][j] = f[old][j] + f[now][j - 1];
                }
            }
            return f[now][n - 1];
        }

    }
}
