class Solution(object):
    def findLongestChain(self, pairs):
        """
        :type pairs: List[List[int]]
        :rtype: int
        """
        if not pairs:
            return 0
        pairs.sort(key = lambda x: x[1])
        ret = 1
        pre = pairs[0]
        for i in range(1, len(pairs)):
            if pairs[i][0] > pre[1]:
                ret += 1
                pre = pairs[i]
        return ret