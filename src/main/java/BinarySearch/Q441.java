package BinarySearch;

/**
 * @author chelsea
 * @date 2019-11-27
 * <p>
 * 排列硬币
 */
public class Q441 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.arrangeCoins(1804289383);
    }

    static class Solution {
        //寻找小于h+h*h<2*n的第一个h
        public int arrangeCoins(int n) {
            if (n <= 0) {
                return 0;
            }

            long start = 1;
            long end = n;
            while (start + 1 < end) {
                long mid = start + (end - start) / 2;
                if (mid + mid * mid == 2L * n) {
                    return (int) mid;
                } else if (mid + mid * mid < 2L * n) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (end * end + end < 2L * n) {
                return (int) end;
            } else {
                return (int) start;
            }
        }
    }
}
