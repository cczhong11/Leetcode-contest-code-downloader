class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int f[]=new int[n+3];
        f[0]=0;
        f[1]=cost[0];
        for (int i=2;i<=n;i++) f[i]=Math.min(f[i-1],f[i-2])+cost[i-1];
        return (Math.min(f[n],f[n-1]));
    }
}