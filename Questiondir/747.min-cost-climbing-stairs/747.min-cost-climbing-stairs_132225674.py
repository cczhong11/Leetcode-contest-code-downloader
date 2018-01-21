class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        curcost = []
        if len(cost) <= 2:
            return min(cost)
        curcost.append(cost[0])
        curcost.append(cost[1])
        for i in xrange(2, len(cost)):
            curcost.append(cost[i] + min(curcost[-1], curcost[-2]))
        return min(curcost[-1], curcost[-2])