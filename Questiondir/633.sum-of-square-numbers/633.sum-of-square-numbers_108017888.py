class Solution(object):
    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """
        sq = set()
        i = 0
        while i*i <= c:
            sq.add(i*i)
            i += 1
        for a in sq:
            if c-a in sq:
                return True
        return False