package backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chelsea
 * @date 2019-11-21
 */
public class Q77 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combine(4, 2);
    }

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            if (n < 0 || k < 0) {
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            combineHelper(res, list, n, 0, k);
            return res;
        }

        private void combineHelper(List<List<Integer>> res, List<Integer> list, int n, int pos, int k) {
            if (list.size() == k) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = pos; i < n; i++) {
                list.add(i + 1);
                combineHelper(res, list, n, i + 1, k);
                list.remove(list.size() - 1);
            }

        }
    }
}
