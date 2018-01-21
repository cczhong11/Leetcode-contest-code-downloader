class Solution(object):
    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """
        i = 0
        squares = set([])
        while i*i <= c:
            squares.add(i*i)
            if (c-i*i) in squares:
                return True
            i += 1
        return False