class Solution(object):
    def minSteps(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 0
        memo = {}
        return self.memMemoMin(n, memo)
        
    def memMemoMin(self, n, memo):
        if n in memo:
            return memo[n]
        res = self.memoMin(n, memo)
        memo[n] = res
        return res
        
    def memoMin(self, n, memo):
        bestCount = n
        for i in range(2, n):
            if n % i == 0:
                count = n // i + self.memMemoMin(i, memo)
                bestCount = min(bestCount, count)
        return bestCount