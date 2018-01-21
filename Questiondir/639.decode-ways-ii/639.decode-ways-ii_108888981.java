public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s == null || s.charAt(0) == '0')  return 0;
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        
        if(s.charAt(0) == '*') {
            dp[1] = 9;
        } else {
            dp[1] = 1;
        }
        
        for(int i = 2; i <= s.length(); i++) {
            
            
            if(s.charAt(i - 1) == '*')  dp[i] = 9 * dp[i - 1];
            else if(s.charAt(i - 1) != '0')  dp[i] = dp[i - 1];
            
            if(s.charAt(i - 1) != '*') { // 0,1,2,3,4...
                
                if(s.charAt(i - 2) != '*') {
                    int num = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                    if(num >= 10 && num < 27)  dp[i] += dp[i - 2];
                } else {
                    if(s.charAt(i - 1) - '0' >= 7)  dp[i] += dp[i - 2];
                    else dp[i] += 2 * dp[i - 2];
                }
            }
            
            else if(s.charAt(i - 1) == '*') {  // "*"
                
                if(s.charAt(i - 2) - '0' == 1)  dp[i] += 9 * dp[i - 2];
                if(s.charAt(i - 2) - '0' == 2)  dp[i] += 6 * dp[i - 2];
                
                if(s.charAt(i - 2) == '*') {
                    dp[i] += 15 * dp[i - 2];
                }
            }
            
            
            dp[i] = dp[i] % 1000000007;
        }
        return (int)dp[s.length()];
    }
}