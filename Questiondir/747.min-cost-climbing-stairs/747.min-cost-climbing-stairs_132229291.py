class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        last, secondlast = 0,0
        for c in cost:
            newcost = min(last+c, secondlast+c)
            secondlast, last = last, newcost
        return min(last,secondlast)