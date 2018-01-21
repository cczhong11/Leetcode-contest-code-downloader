class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] buckets = new int[10001], dp = new int[10001], ep = new int[10001];
        for (int n : nums) {
            buckets[n] += n;
        }
     //   ep[0] = 0;
        dp[0] = 0;
   //     ep[1] = 0;
        dp[1] = buckets[1];
        for (int x = 1; x < 10000; x++) {
         //   ep[x+1] = Math.max(dp[x], ep[x-1] + buckets[x]);
            dp[x+1] = Math.max(dp[x-1] + buckets[x+1], dp[x]);
        }
       // for (int i = 0; i < 9; i++) {
           // System.out.println(dp[i] + " " + ep[i]);
      //  }
        return dp[10000];
    }
}