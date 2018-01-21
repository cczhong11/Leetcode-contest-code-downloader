from math import sqrt

class Solution(object):
    def maxA(self, n):
        if n < 5:
            return n
        
        
        dp = range(1, n+1)
        for i in xrange(5, len(dp)):
            #for j in xrange(2, int(sqrt(i+1) + 0.5)+1):
            for j in xrange( (i+1) - 3, 0, -1):
                #print i, '->', 'j', j, dp[j-1], (i-j)
                dp[i] = max(dp[i], dp[j-1] * ( i-j ) )
                    
            #print 'num', (i+1)
        #print dp
        return dp[-1]