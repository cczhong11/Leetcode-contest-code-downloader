class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        l = len(cost)
        dp = [0]*l
        dp[0] = cost[0]
        dp[1] = cost[1]
        for i in range(2,l):
            dp[i] = min(dp[i-1],dp[i-2]) + cost[i]
        return min(dp[-1],dp[-2])