class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] allcost=new int[cost.length];
        allcost[0]=cost[0];
        allcost[1]=cost[1];
        for (int i=2;i<cost.length;i++)
        {
            allcost[i]=Math.min(allcost[i-1],allcost[i-2])+cost[i];
        }
        return Math.min(allcost[cost.length-1],allcost[cost.length-2]);
    }
}