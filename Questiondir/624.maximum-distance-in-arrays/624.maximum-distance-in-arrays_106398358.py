class Solution(object):
    def maxDistance(self, arrays):
        """
        :type arrays: List[List[int]]
        :rtype: int
        """
        max_dist = 0
        min_start = arrays[0][0]
        for i in xrange(1,len(arrays)):
            max_dist = max(max_dist, abs(arrays[i][-1] - min_start))
            min_start = min(min_start, arrays[i][0])
        max_end = arrays[0][-1]
        for i in xrange(1,len(arrays)):
            max_dist = max(max_dist, abs(arrays[i][0] - max_end))
            max_end = max(max_end, arrays[i][-1])
        return max_dist