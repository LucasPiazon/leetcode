import java.util.ArrayList;
import java.util.List;

/**
 * @author chelsea
 * @date 2019-11-21
 */
public class Q39 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates=new int[]{2,3,6,7};
        solution.combinationSum(candidates,7);

    }

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates == null || candidates.length == 0) {
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            combinationSumHelper(res, list, 0, candidates, target);
            return res;
        }

        private void combinationSumHelper(List<List<Integer>> res, List<Integer> list, int pos, int[] candidates, int target) {
            int sum = list.stream().reduce(Integer::sum).orElse(0);
            if (sum == target) {
                res.add(new ArrayList<>(list));
                return;
            }
            if (sum > target) {
                return;
            }
            for (int i = pos; i < candidates.length; i++) {
                list.add(candidates[i]);
                combinationSumHelper(res, list, pos, candidates, target);
                list.remove(list.size() - 1);
            }
        }
    }
}


