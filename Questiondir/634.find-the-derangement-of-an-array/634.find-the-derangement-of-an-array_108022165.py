class Solution(object):
    def findDerangement(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 0
        if n == 2:
            return 1
        OPT = [0] * (n+1)
        OPT[0] = 1
        OPT[1] = 0
        OPT[2] = 1
        OPT[3] = 2
        for i in xrange(4, n+1):
            OPT[i] = (OPT[i-1] * (i-1) + (i - 1) * OPT[i-2]) % 1000000007
        return OPT[n]
        