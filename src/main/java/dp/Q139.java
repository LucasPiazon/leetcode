package dp;

import java.util.ArrayList;
import java.util.List;

public class Q139 {
    static class Solution {
        //拆解成子问题
        //
        public boolean wordBreak(String s, List<String> wordDict) {
            int m = s.length();
            //apple
            boolean[] dp = new boolean[m + 1];
            dp[0]=true;
            for (int i = 1; i <= m; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[m];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        solution.wordBreak("applepenapple", list);
    }
}
