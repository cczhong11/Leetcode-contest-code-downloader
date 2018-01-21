class Solution(object):
    def smallestFactorization(self, a):
        """
        :type a: int
        :rtype: int
        """
        divs = []
        for d in xrange(9, 1, -1):
            while a % d == 0:
                divs.append(d)
                a /= d
        if a > 1:
            return 0
        if not divs:
            return 1
        mx = 2147483647
        if len(divs) > 10:
            return 0
        divs.reverse()
        res = int(''.join(map(str,divs)))
        if res > mx:
            return 0
        return res
            