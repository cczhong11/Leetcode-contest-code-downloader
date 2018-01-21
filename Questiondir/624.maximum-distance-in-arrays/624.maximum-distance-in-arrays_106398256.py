class Solution(object):
    def maxDistance(self, arrays):
        """
        :type arrays: List[List[int]]
        :rtype: int
        """
        smalls = sorted(enumerate(arrays), key = lambda x: x[1][0])
        bigs = sorted(enumerate(arrays), key = lambda x: -x[1][-1])
        if smalls[0][0] != bigs[0][0]:
            return bigs[0][1][-1] - smalls[0][1][0]
        else:
            return max(bigs[0][1][-1] - smalls[1][1][0], bigs[1][1][-1] - smalls[0][1][0])