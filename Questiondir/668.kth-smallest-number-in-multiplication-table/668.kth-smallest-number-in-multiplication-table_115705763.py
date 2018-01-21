class Solution(object):
    def findKthNumber(self, m, n, k):
        def accepted(x):
            #is there at least k numbers <= x?
            ans = 0
            for i in xrange(1, m+1):
                ans += min( (x-1) / i, n )
            return ans < k
        
        lo, hi = 1, m*n + 1
        while lo < hi:
            mi = (lo + hi) / 2
            ami = accepted(mi)
            if ami:
                lo = mi + 1
            else:
                hi = mi
                
        return lo - 1