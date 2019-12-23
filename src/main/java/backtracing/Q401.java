package backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chelsea
 * @date 2019-11-22
 */
public class Q401 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readBinaryWatch(1);

    }

    static class Solution {
        public List<String> readBinaryWatch(int num) {
            if (num < 0 || num > 8) {
                return new ArrayList<>();
            }
            int[] watchs = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
            int[] flags = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            List<String> res = new ArrayList<>();
            readBinaryWatchHelper(res, watchs, flags, 0, num, 0);
            return res;
        }

        private void readBinaryWatchHelper(List<String> res, int[] watchs, int[] flags, int pos, int num, int deep) {
            if (deep == num) {
                String str = getClock(watchs, flags);
                if (str == null) {
                    return;
                }
                res.add(str);
                return;
            }
            for (int i = pos; i < watchs.length; i++) {
                flags[i] = 1;
                readBinaryWatchHelper(res, watchs, flags, i + 1, num, deep + 1);
                flags[i] = 0;
            }

        }

        private String getClock(int[] watchs, int[] flags) {
            int hours = 0;
            int minutes = 0;
            for (int i = 0; i < watchs.length; i++) {
                if (i < 4 && flags[i] == 1) {
                    hours += watchs[i];
                }
                if (i >= 4 && flags[i] == 1) {
                    minutes += watchs[i];
                }
            }
            if (hours > 11 || minutes > 59) {
                return null;
            }
            String minuteStr = minutes + "";
            if (minutes < 10) {
                minuteStr = "0" + minutes;
            }
            return hours + ":" + minuteStr;
        }
    }
}
