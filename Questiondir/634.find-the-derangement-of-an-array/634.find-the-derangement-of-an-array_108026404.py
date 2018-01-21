class Solution(object):
    def findDerangement(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 0
        a = 1
        b = 0
        for i in range(1, n):
            c = i * (a + b) % 1000000007
            a = b
            b = c
        return c