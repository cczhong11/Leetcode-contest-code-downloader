import bisect
class Solution(object):
    def findLongestChain(self, pairs):
        """
        :type pairs: List[List[int]]
        :rtype: int
        """
        q = []
        pairs.sort()
        for x,y in pairs:
            i = bisect.bisect_left(q, x)
            if i == len(q):
                q.append(y)
            else:
                q[i] = min(q[i], y)
        return len(q)

