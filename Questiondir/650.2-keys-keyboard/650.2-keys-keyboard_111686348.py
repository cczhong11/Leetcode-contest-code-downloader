class Solution(object):
    def minSteps(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 0
        self.dp = {1:0}
        return self.solve(n)
        
        
    def solve(self, n):
        if n in self.dp:
            return self.dp[n]
        
        for i in xrange(2, n/2+1):
            if n % i == 0:
                self.dp[n] = self.solve(i) + self.solve(n/i)
                break
        else:
            self.dp[n] = n
        
        return self.dp[n]