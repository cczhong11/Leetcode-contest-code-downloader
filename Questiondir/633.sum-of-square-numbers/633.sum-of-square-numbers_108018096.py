import math
class Solution(object):
    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """
        for i in range(0, int(math.sqrt(c)+2)):
            if c-i*i < 0:
                continue
            p = int(math.sqrt(c - i*i))
            if p * p == c - i*i:
                return True
        return False