public class Solution {
	public int findLongestChain(int[][] pairs) {
		if (pairs.length == 0) return 0;
		int n = pairs.length;
		int[] dp = new int[n];
		Arrays.sort(pairs, (a, b)->(a[1] - b[1]));
		
		int res = 1;
		for (int i = 0; i < n; i++) {
			//System.out.println(pairs[i][0] + " " + pairs[i][1]);
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (pairs[j][1] < pairs[i][0]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
		
	}
}