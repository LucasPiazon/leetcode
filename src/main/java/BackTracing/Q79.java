package BackTracing;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author chelsea
 * @date 2019-11-23
 * <p>
 * 单词搜索
 */
public class Q79 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{{'a'}};
        solution.exist(board, "ab");
        IntStream.range(1, 9).boxed().collect(Collectors.toList());

    }

    static class Solution {
        public boolean exist(char[][] board, String word) {
            if (board.length == 0 || word == null) {
                return false;
            }
            char[] cha = word.toCharArray();
            char[][] flags = new char[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; i < board[i].length; j++) {
                    if (board[i][j] == word.charAt(0) && existHelper(board, flags, cha, 0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean existHelper(char[][] board, char[][] flags, char[] cha, int pos, int x, int y) {
            if (x == board.length || y == board[0].length || x < 0 || y < 0 || flags[x][y] == 1) {
                return false;
            }
            if (cha[pos] != board[x][y]) {
                return false;
            }
            if (pos == cha.length - 1 && cha[pos] == board[x][y]) {
                return true;
            }
            if (pos == cha.length) {
                return false;
            }
            //上、下、左、右
            flags[x][y] = 1;
            boolean res = existHelper(board, flags, cha, pos + 1, x - 1, y) || existHelper(board, flags, cha, pos + 1, x + 1, y) || existHelper(board, flags, cha, pos + 1, x, y - 1) || existHelper(board, flags, cha, pos + 1, x, y + 1);
            flags[x][y] = 0;
            return res;
        }
    }
}
