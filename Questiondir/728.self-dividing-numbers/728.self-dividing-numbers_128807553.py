class Solution(object):
    def selfDividingNumbers(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: List[int]
        """
        def test(n):
            fuln = n
            while n > 0:
                a, b = divmod(n, 10)
                if b == 0: return False
                if (fuln % b) != 0: return False
                n = n // 10
            return True
        return [x for x in xrange(left, right+1) if test(x)]

