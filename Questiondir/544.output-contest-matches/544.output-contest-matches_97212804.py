class Solution(object):

    def findContestMatch(self, n):
        """
        :type n: int
        :rtype: str
        """
        cur = [i for i in xrange(1, n+1)]
        while len(cur) != 1:
            next = []
            for i in xrange(len(cur)/2):
                next.append('({},{})'.format(cur[i], cur[len(cur)-i-1]))
            cur = next
        return cur[0]
