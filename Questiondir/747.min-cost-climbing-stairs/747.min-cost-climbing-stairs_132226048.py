class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        opt = [0] * (len(cost) + 5)
        for i in range(len(cost)-1, -1, -1):
            opt[i] = cost[i] + min(opt[i+1], opt[i+2])
        return min(opt[0], opt[1])