class Solution(object):
    def smallestFactorization(self, a):
        """
        :type a: int
        :rtype: int
        """
        if a < 10:
            return a
        fact = [0] * 10
        for i in xrange(9, 1, -1):
            while a % i == 0:
                fact[i] += 1
                a /= i
        if a >= 10:
            return 0
        #print fact
        ans = 0
        for i in xrange(2, 10):
            for j in xrange(fact[i]):
                ans *= 10
                ans += i
        
        INT_MAX =  2147483647
        if ans > INT_MAX:
            return 0
        else:
            return ans