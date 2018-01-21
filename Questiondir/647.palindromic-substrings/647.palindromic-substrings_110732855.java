public class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=1; i<s.length(); ++i)
            dp[i][i-1]=true;
        for(int i=0; i<s.length(); ++i)
            dp[i][i]=true;
        for(int length=2; length<=s.length(); ++length) {
            for(int i=0; i+length-1<s.length(); ++i) {
                dp[i][i+length-1]=dp[i+1][i+length-2]&s.charAt(i)==s.charAt(i+length-1);
            }
        }
        int count=0;
        for(int i=0; i<s.length(); ++i)
            for(int j=i; j<s.length(); ++j)
                if(dp[i][j])
                    ++count;
        return count;
    }
}