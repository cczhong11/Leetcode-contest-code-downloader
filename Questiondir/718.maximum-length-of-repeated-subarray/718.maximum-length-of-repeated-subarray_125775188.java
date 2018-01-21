class Solution {
    public int findLength(int[] A, int[] B) {
                int[][] dp=new int[A.length+1][B.length+1];
        int ans=0;
        for (int ai=1;ai<=A.length;++ai){
            for (int bi=1;bi<=B.length;++bi){
                if (A[ai-1]!=B[bi-1])dp[ai][bi]=0;
                else dp[ai][bi]=dp[ai-1][bi-1]+1;
                ans=Math.max(ans, dp[ai][bi]);
            }
        }
        return ans;
    }
}