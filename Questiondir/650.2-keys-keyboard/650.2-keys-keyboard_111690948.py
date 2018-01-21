from math import sqrt
class Solution(object):
    def minSteps(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 0
        elif n <= 5:
            return n
        
        
        dp = range(1, n+1)
        dp[0] = 0
        for i in xrange(5, len(dp)):
            for j in xrange(2, int(sqrt(i+1) + 0.5)+1):
                if (i+1) % j == 0:
                    #print 'j=', j, 'i+1/j=', (i+1) / j
                    dp[i] = min(dp[i], dp[j-1] +  (i+1)/j)
                    dp[i] = min(dp[i], dp[(i+1)/j-1] + j)
                    
            #print 'num', (i+1)
        #print dp
        return dp[-1]