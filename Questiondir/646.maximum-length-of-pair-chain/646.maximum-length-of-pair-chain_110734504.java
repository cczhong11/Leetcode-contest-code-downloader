public class Solution {
    public int findLongestChain(int[][] e) {
        Arrays.sort(e, (a, b) -> a[0] - b[0]);
        int n = e.length;
        int[] dp = new int[n];
        int max = 0;
		Arrays.fill(dp, 1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(e[i][0] > e[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}