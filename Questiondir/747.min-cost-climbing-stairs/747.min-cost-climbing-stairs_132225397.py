class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        cost.append(0)
        n = len(cost)
        D = [0] * n
        D[0] = cost[0]
        D[1] = min(cost[1], cost[1]+cost[0])
        for i in xrange(2, n):
            D[i] = cost[i] + min(D[i-1], D[i-2])
        return D[-1]

