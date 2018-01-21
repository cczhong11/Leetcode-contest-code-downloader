class Solution(object):
    def judgeSquareSum(self, c):
        for x in xrange(int(c**.5) + 1):
            t = c - x*x
            if t >= 0:
                y = int(t**.5)
                if x*x + y*y == c:
                    return True
                if x*x + (y+1)**2 == c:
                    return True
        return False