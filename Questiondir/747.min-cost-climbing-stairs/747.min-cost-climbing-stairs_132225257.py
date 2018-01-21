class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        total = [0 for c in cost]
        total[0] = cost[0]
        total[1] = cost[1]
        for i in range(2,len(cost)):
            total[i] = cost[i] + min(total[i-1], total[i-2])
        return min(total[-1], total[-2])
        