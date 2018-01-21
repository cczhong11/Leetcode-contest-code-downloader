class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n1 = 0, n2 = 0;
        for (int i=2;i<cost.length;i++){
            int n = Math.min(cost[i-2]+n1,cost[i-1]+n2);
            n1 = n2;
            n2 = n;
        }
        return Math.min(cost[cost.length-2]+n1,cost[cost.length-1]+n2);
    }
}