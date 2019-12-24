package dp;

/**
 * @author chelsea
 * @date 2019-12-24
 * <p>
 * 轰炸敌人：请你计算一个炸弹最多炸死多少个敌人
 * 分别计算一个炸弹向上、下、左、右的最多的敌人
 * 向上：f(i,i)=f(i-1,j)|0|f(i-1,j)+1
 * 向下：f(i,j)=f(i+1,j)|0|f(i+1,j)+1
 * 向左：f(i,j)=f(i,j-1)|0|f(i,j-1)+1
 * 向右：f(i,j)=f(i,j+1)|0|f(i,j+1)+1
 * i分别是空地，墙，炸弹
 */
public class Q361 {

    static class Solution {

        public int maxKilledEnemies(char[][] grid) {
            int m = grid.length;
            if (m == 0) {
                return 0;
            }
            int n = grid[0].length;
            if (n == 0) {
                return 0;
            }
            //向上
            int[][] up = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 'W') {
                        up[i][j] = 0;
                    }
                    if (grid[i][j] == '0') {
                        up[i][j] = i > 0 ? up[i - 1][j] : 0;
                    }
                    if (grid[i][j] == 'E') {
                        up[i][j] = 1 + (i > 0 ? up[i - 1][j] : 0);
                    }
                }
            }
            //向下
            int[][] down = new int[m][n];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 'W') {
                        down[i][j] = 0;
                    }
                    if (grid[i][j] == '0') {
                        down[i][j] = i < m - 1 ? down[i + 1][j] : 0;
                    }
                    if (grid[i][j] == 'E') {
                        down[i][j] = 1 + (i < m - 1 ? down[i + 1][j] : 0);
                    }
                }
            }
            //向左
            int[][] left = new int[m][n];
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    if (grid[i][j] == 'W') {
                        left[i][j] = 0;
                    }
                    if (grid[i][j] == '0') {
                        left[i][j] = j > 0 ? left[i][j - 1] : 0;
                    }
                    if (grid[i][j] == 'E') {
                        left[i][j] = 1 + (j > 0 ? left[i][j - 1] : 0);
                    }
                }
            }
            //向右
            int[][] right = new int[m][n];
            for (int j = n - 1; j >= 0; j--) {
                for (int i = 0; i < m; i++) {
                    if (grid[i][j] == 'W') {
                        right[i][j] = 0;
                    }
                    if (grid[i][j] == '0') {
                        right[i][j] = j < n - 1 ? right[i][j + 1] : 0;
                    }
                    if (grid[i][j] == 'E') {
                        right[i][j] = 1 + (j < n - 1 ? right[i][j + 1] : 0);
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '0') {
                        int val = up[i][j] + down[i][j] + left[i][j] + right[i][j];
                        max = Math.max(max, val);
                    }
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = {{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}};
        solution.maxKilledEnemies(grid);
    }
}
