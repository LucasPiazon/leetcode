package binarysearch;

/**
 * @author chelsea
 * @date 2019-11-26
 * <p>
 * 搜索旋转排序数组
 */
public class Q33 {

    static class Solution {
        //
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int index = getRotatedIndex(nums);
            if (index == -1) {
                return searchIndex(nums, 0, nums.length - 1, target);
            } else {
                int leftIndex = searchIndex(nums, 0, index, target);
                if (leftIndex == -1) {
                    return searchIndex(nums, index + 1, nums.length - 1, target);
                } else {
                    return leftIndex;
                }
            }
        }

        private int getRotatedIndex(int[] nums) {
            if (nums[nums.length - 1] > nums[0]) {
                return -1;
            }
            int start = 0;
            int end = nums.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] >= nums[mid + 1]) {
                    return mid;
                } else {
                    if (nums[mid] > nums[0]) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                }
            }
            if (nums[start] >= nums[end]) {
                return start;
            } else {
                return end;
            }
        }

        private int searchIndex(int[] nums, int start, int end, int target) {
            if (start > end) {
                return -1;
            }
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
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

    }
}
