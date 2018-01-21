class Solution(object):
    def findDerangement(self, n):
        if n==1: return 0
        if n==2: return 1
        if n==3: return 2
        a,b = 1,2
        for i in range(4,n+1):
            a,b = b, (a+b)*(i-1)%(10**9+7)
        return b        