class Solution(object):
    def newInteger(self, n):
        """
        :type n: int
        :rtype: int
        """
        digs = [1]
        for d in xrange(12):
            digs.append(9*digs[-1])
        d = 0
        while digs[d+1] <= n:
            d += 1
        val = 0
        while d > -1:
            val *= 10
            val += n / digs[d]
            n -= (n/digs[d]) * digs[d]
            d -= 1
        return val
        