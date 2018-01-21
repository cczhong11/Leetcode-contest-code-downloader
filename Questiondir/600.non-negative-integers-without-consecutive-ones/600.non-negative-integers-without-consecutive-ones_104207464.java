public class Solution {
    public int findIntegers(int num) {
    	if(num == 0)	return 1;
    	if(num == 1)	return 2;
    	if(num == 2)	return 3;
    	if(num == 3)	return 3;
        String s = Integer.toBinaryString(num);
        int n = s.length();
        
        int[][] dp = new int[n+1][2];
        dp[1][0] = 1;	dp[1][1] = 1;
        for(int i=2; i<=n; i++) {
        	dp[i][0] = dp[i-1][0]+dp[i-1][1];
        	dp[i][1] = dp[i-1][0];
        }
        
//        int ret = 0;
//        for(int i=0; i<n; i++) {
//        	if(s.charAt(i) == '1') {
//        		ret += dp[n-1][0];
//        		i++;
//        	}
//        }
        
        if(s.charAt(1) == '1')
        	return dp[n-1][0] + dp[n-1][1] + dp[n-2][0] + dp[n-2][1];
        else
        	return dp[n-1][0] + dp[n-1][1] + findIntegers(Integer.valueOf(s.substring(2), 2));
    }
}