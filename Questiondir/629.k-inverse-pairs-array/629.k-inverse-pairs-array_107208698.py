MODULUS = 10**9 + 7
class Solution(object):
    def kInversePairs(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        # f(n, k) := sum of f(n-1, k-i) for i in xrange(n)
        def computeNext(w, n):
            r = [0] * len(w)
            s = 0
            for i, v in enumerate(w):
                s = (s + v) % MODULUS
                if i-n >= 0: s = (s - w[i-n]) % MODULUS
                r[i] = s
            return r
        # f(0, k) := 1 if k==0 else 0
        ways = [1] + [0]*k
        for m in xrange(n): ways = computeNext(ways, m+1)
        return ways[-1]