class Solution(object):
    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """
        m = int(c**(0.5))
        dic = set()
        for i in xrange(0, m+1):
            target = i * i
            if target in dic or (target << 1) == c:
                return True
            else:
                dic.add(c-target)
        return False