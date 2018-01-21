class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        n = len(cost)
        cost += [0]
        mncost = [1e9 for i in xrange(n+1)]
        mncost[0] = cost[0]
        mncost[1] = cost[1]
        for i in xrange(2, n+1):
            mncost[i] = cost[i] + min(mncost[i-1], mncost[i-2])
        return mncost[n]
        