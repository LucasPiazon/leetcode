package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chelsea
 * @date 2019-12-24
 * <p>
 * 分割回文串:给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 */
public class Q131 {

    static class Solution {
        public List<List<String>> partition(String s) {
            if (s.length() == 0) {
                return new ArrayList<>();
            }
            List<List<String>> res = new ArrayList<>();
            boolean[][] isPalindrome = new boolean[s.length()][s.length()];
            setPalindrome(s, isPalindrome);
            partitionHelper(0, s, res, new ArrayList<>(), 0, isPalindrome);
            return res;
        }

        //next代表下一个开始的字符串下标
        private void partitionHelper(int pos, String s, List<List<String>> res, List<String> temp, int next, boolean[][] isPalindrome) {
            //System.out.println(next + "," + pos);
            if (pos == s.length()) {
                if (next == s.length()) {
                    res.add(new ArrayList<>(temp));
                }
                return;
            }
            //1.包含当前字符串
            if (isPalindrome[next][pos]) {
                temp.add(s.substring(next, pos + 1));
                partitionHelper(pos + 1, s, res, new ArrayList<>(temp), pos + 1, isPalindrome);
                temp.remove(temp.size() - 1);
            }
            //2.不包含当前字符串
            partitionHelper(pos + 1, s, res, new ArrayList<>(temp), next, isPalindrome);
        }

        private void setPalindrome(String s, boolean[][] isPalindrome) {
            for (int i = 0; i < s.length(); i++) {
                isPalindrome[i][i] = true;
            }
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    isPalindrome[i][i + 1] = true;
                }
            }
            for (int length = 3; length <= s.length(); length++) {
                for (int i = 0; i <= s.length() - length; i++) {
                    isPalindrome[i][i + length - 1] = isPalindrome[i + 1][i + length - 1 - 1] && (s.charAt(i) == s.charAt(i + length - 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "efe";
        solution.partition(s);
    }
}
