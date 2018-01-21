import math

class Solution(object):
    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """
        t=int(math.sqrt(c))
        d={}
        for i in range(t+1):
            d.setdefault(i*i,c-i*i)
        for i in range(t+1):
            if i*i in d:
                if c-i*i in d:
                    return True
        return False