class Solution(object):
    def maxDistance(self, arrays):
        """
        :type arrays: List[List[int]]
        :rtype: int
        """
        tops = [(max(arrays[i]), i) for i in range(len(arrays))]
        bots = [(min(arrays[i]), i) for i in range(len(arrays))]
        tops.sort()
        bots.sort()
        if tops[-1][1] == bots[0][1]:
            x0 = tops[-1][0] - bots[1][0]
            x1 = tops[-2][0] - bots[0][0]
            return max(x0, x1)
        else:
            return tops[-1][0] - bots[0][0]