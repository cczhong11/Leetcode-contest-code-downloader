class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        costa = 0
        costb = 0
        for i in xrange(len(cost)):
            nextCost = min(costa, costb) + cost[i]
            costa, costb = costb, nextCost
        return min(costa, costb)
        