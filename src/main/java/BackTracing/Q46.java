package BackTracing;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chelsea
 * @date 2019-11-26
 * <p>
 * 全排列
 */
public class Q46 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 1, 2, 4};
        solution.permute(nums);
    }

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            Collections.sort(list);
            permuteHelper(res, 0, list);
            return res;
        }

        private void permuteHelper(List<List<Integer>> res, int pos, List<Integer> list) {
            if (pos == list.size()) {
                System.out.println(list);
                res.add(new ArrayList<>(list));
            }
            for (int i = pos; i < list.size(); i++) {
                Collections.swap(list, i, pos);
                permuteHelper(res, pos + 1, list);
                Collections.swap(list, i, pos);
            }
        }
    }
}
