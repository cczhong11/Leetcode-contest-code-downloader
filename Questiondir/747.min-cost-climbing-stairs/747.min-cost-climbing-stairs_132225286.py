class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        
        
        dp = [0 for _ in range(len(cost))]
        
        for i in range(len(cost)):
            if i == 0 or i == 1:
                dp[i] = cost[i]
            else:
                dp[i] = min(dp[i-2],dp[i-1]) + cost[i]
        
        return min(dp[-1],dp[-2])