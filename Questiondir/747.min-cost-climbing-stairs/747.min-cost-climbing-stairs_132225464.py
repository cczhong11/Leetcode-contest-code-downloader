class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        n=len(cost)
        if n==0:
            return 0
        if n==1:
            return 0
        a=[None]*(n+1)
        a[0]=0
        for i in xrange(1,n+1):
            if i==1:
                a[i]=cost[0]
                continue
            a[i]=min(a[i-1],a[i-2])+cost[i-1]
        return min(a[n-1],a[n]) if n>=1 else a[n]