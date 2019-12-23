package binarysearch;

/**
 * @author chelsea
 * @date 2019-11-25
 */
public class Q34 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        solution.searchRange(nums, 8);

    }

    static class Solution {
        //寻找first/last
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[2];
            }
            int[] res = new int[2];
            res[0] = getFirstOfRange(nums, target);
            res[1] = getLastOfRange(nums, target);
            return res;
        }

        private int getFirstOfRange(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] >= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            if (nums[start] == target) {
                return start;
            }

            if (nums[end] == target) {
                return end;
            }
            return -1;
        }

        private int getLastOfRange(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] >= target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (nums[end] == target) {
                return end;
            }
            if (nums[start] == target) {
                return start;
            }

            return -1;
        }
    }
}
