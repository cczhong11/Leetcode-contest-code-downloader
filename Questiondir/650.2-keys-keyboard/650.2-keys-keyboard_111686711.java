public class Solution {
    public int minSteps(int n) {
    		int dp[] = new int[1010];
    		Arrays.fill(dp, 2000);
    		dp[1] = 0;
    		for(int i = 1; i <= n; i++) {
    			int getHereAndCopy = dp[i] + 1;
    			int start = 2 * i;
    			int cnt = 1;
    			while(start <= n) {
    				dp[start] = Integer.min(dp[start], getHereAndCopy + cnt);
    				
    				start += i;
    				cnt++;
    			}
    		}
    		return dp[n];
    }
}