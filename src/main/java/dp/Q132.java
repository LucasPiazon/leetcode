package dp;

/**
 * @author chelsea
 * @date 2019-12-24
 * 分割回文串 II
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回符合要求的最少分割次数。
 * 1.最后一段：j~i是回文串，则求0-(i-j)的回文最小切割数
 * 2.转移方程：f(i)表示前i个字符的回文最小切割数，f(i)=f(j-1)&&isPalindrome(j,i)+1,这里我们不知道j的位置，我们枚举1<=j<=i
 * 3.f(0)=0
 */
public class Q132 {

    class Solution {
        public int minCut(String s) {
            if (s.length() == 0) {
                return 0;
            }
            boolean[][] isPalindrome = isPalindrome(s);
            int[] f = new int[s.length() + 1];
            f[0] = 0;
            for (int i = 1; i < f.length; i++) {
                f[i] = Integer.MAX_VALUE;
                for (int j = 1; j <= i; j++) {
                    if (isPalindrome[j-1][i-1]) {
                        f[i] = Math.min(f[i], f[j - 1] + 1);
                    }
                }
            }
            return f[f.length - 1] - 1;
        }

        private boolean[][] isPalindrome(String s) {
            boolean[][] palindrome = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                palindrome[i][i] = true;
            }
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    palindrome[i][i + 1] = true;
                }
            }
            for (int length = 3; length <= s.length(); length++) {
                for (int i = 0; i <= s.length() - length; i++) {
                    palindrome[i][i + length - 1] = palindrome[i + 1][i + length - 1 - 1] && (s.charAt(i) == s.charAt(i + length - 1));
                }
            }
            return palindrome;
        }
    }
}
