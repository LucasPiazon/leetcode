package binarysearch;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chelsea
 * @date 2019-11-25
 */
public class Q349 {

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
                return null;
            }
            Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
            int index = 0;
            int res[] = new int[set1.size()];
            for (Integer i : set1) {
                if (set2.contains(i)) {
                    res[index++] = i;
                }
            }
            return Arrays.copyOf(res, index);


        }
    }
}
