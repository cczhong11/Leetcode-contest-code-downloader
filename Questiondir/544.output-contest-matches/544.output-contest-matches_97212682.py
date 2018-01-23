class Solution(object):
    def findContestMatch(self, n):
        """
        :type n: int
        :rtype: str
        """
        ret = [str(x) for x in range(1,n+1)]
        m = len(ret)
        while m > 1:
            ret = ['({0},{1})'.format(ret[i], ret[m-1-i]) for i in range(m//2)]
            m //= 2
        return ret[0]
