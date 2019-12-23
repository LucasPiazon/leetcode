package backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chelsea
 * @date 2019-11-23
 * <p>
 * 括号生成
 */
public class Q22 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateParenthesis(3);
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {
            if (n <= 0) {
                return new ArrayList<>();
            }
            List<String> res = new ArrayList<>();
            generateParenthesisHelper(res, "", 0, 0, n);
            return res;
        }

        private void generateParenthesisHelper(List<String> res, String str, int pos, int sum, int n) {
            if (pos == n * 2 && sum == 0) {
                res.add(str);
                return;
            }
            if (pos >= n * 2 || sum < 0 || sum > n) {
                return;
            }
            generateParenthesisHelper(res, str + "(", pos + 1, sum + 1, n);
            generateParenthesisHelper(res, str + ")", pos + 1, sum - 1, n);
        }

    }
}
