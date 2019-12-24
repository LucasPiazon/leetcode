package dp;

/**
 * @author chelsea
 * @date 2019-12-24
 * <p>
 * 粉刷房子：m个房子，n种颜色，相邻两个不能相同颜色，问需要的最小花费
 * 1.最后一步：最后一个房子m只能涂n种颜色的某一个，m-1的房子不能染成m的颜色，则m染成k色的最小花费=m-1房子然后！k色的最小花费
 * 2.转移方程：f(m,n)第m个房子染成n色的所有需要的最小花费
 * f(m,n)=min{f(m-1,k)}(n!=k)+costs[m-1,n-1]
 * 3.边界条件f[0][n],f[m][0]=0;表示没有花费
 * 4.计算顺序，返回结果为f(m,...)的最小值
 */
public class Q265 {

    static class Solution {

        public int minCostII(int[][] costs) {
            if (costs.length == 0 || costs[0].length == 0) {
                return 0;
            }
            int m = costs.length;
            int n = costs[0].length;
            int[][] res = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 || j == 0) {
                        res[i][j] = 0;
                        continue;
                    }
                    res[i][j] = Integer.MAX_VALUE;
                    for (int k = 1; k <= n; k++) {
                        if (k == j && i != 1) {
                            continue;
                        }
                        res[i][j] = Math.min(res[i][j], res[i - 1][k] + costs[i - 1][j - 1]);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                min = Math.min(res[m][i], min);
            }
            return min;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] costs = {{1, 3}};
        solution.minCostII(costs);
    }
}
