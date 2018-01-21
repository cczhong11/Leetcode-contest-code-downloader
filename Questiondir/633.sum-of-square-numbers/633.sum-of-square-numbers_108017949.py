class Solution(object):
    def judgeSquareSum(self, c):
        p = int(c**0.5)
        for i in range(p+1):
            a = c - i**2
            q = int(a**0.5)
            if q**2 == a:
                return True
        return False