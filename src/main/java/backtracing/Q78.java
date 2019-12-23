package backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chelsea
 * @date 2019-11-21
 */
public class Q78 {

    public static void main(String[] args) {
        int[] num = new int[]{3, 1, 5, 2};
        Solution solution = new Solution();
        solution.subsets(num);
    }

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            List<Integer> list = new ArrayList<Integer>();
            subsetsHelper(result, list, nums, 0);
            return result;
        }

        private void subsetsHelper(List<List<Integer>> result, List<Integer> temp, int[] nums, int pos) {
            result.add(new ArrayList<Integer>(temp));
            System.out.println("-----------------" + temp);
            for (int i = pos; i < nums.length; i++) {
                System.out.println(nums[i]);
                temp.add(nums[i]);
                subsetsHelper(result, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
