class Solution(object):
    def newInteger(self, n):
        """
        :type n: int
        :rtype: int
        """
        a = []
        while n > 0:
            a.append(n % 9)
            n /= 9
        r = 0
        for x in a[::-1]:
            r = r * 10 + x
        return r
        