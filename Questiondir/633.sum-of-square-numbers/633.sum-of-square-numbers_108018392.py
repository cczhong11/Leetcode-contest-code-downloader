class Solution(object):
    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """
        from math import sqrt
        if int(sqrt(c)) ** 2 == c:
            return True
        for a in range(int(sqrt(c)) + 1):
           if int(sqrt(c - a * a)) ** 2 == c - a * a:
               return True
        return False