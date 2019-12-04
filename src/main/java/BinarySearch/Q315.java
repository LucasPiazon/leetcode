package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chelsea
 * @date 2019-11-29
 * <p>
 * 计算右侧小于当前元素的个数
 */
public class Q315 {

    public static void main(String[] args) {

    }


    static class Solution {

        public List<Integer> countSmaller(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }
            int[] temps = Arrays.copyOf(nums, nums.length);
            Arrays.sort(temps);
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                res.add(search(temps, nums[i]));
            }
            return res;
        }

        //寻找第一个==target的数
        private int search(int[] temps, int target) {
            int start = 0;
            int end = temps.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (target <= temps[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            if (temps[start] == target) {
                return start;
            } else {
                return end;
            }
        }
    }
}
