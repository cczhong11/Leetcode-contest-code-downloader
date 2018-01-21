import java.util.Arrays;

class Solution {
    public int minStickers(String[] stickers, String target) {
    	int n = target.length();
        int[] dp = new int[1 << n];
        int[] count = new int[26];
        
        Arrays.fill(dp, 10000);
        dp[0] = 0;
        for (int i = 0; i < stickers.length; ++i) {
        	boolean out = false;
        	while (!out) {
        		out = true;
	        	for (int mask = (1 << n) - 1; mask >= 0; --mask) {
		        	Arrays.fill(count, 0);
		        	for (int j = 0; j < stickers[i].length(); ++j) {
		        		count[stickers[i].charAt(j) - 'a']++;
		        	}
	        		int nmask = mask;
	        		for (int k = 0; k < n; ++k) {
	        			int v = target.charAt(k) - 'a';
	        			if ((1 << k & mask) == 0 && count[v] > 0) {
	        				count[v]--;
	        				nmask |= 1 << k;
	        			}
	        		}
	        		if (dp[mask] + 1 < dp[nmask]) {
	        			dp[nmask] = dp[mask] + 1;
	        			out = false;
	        		}
	        	}
        	}
        }
        int res = dp[(1 << n) - 1];
        if (res == 10000) res = -1;
        return res;
    }
}