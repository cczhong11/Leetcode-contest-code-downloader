class Solution(object):
    def intersectionSizeTwo(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        intervals.sort(key=lambda x: x[1])
        s = [intervals[0][1] - 1, intervals[0][1]]
        for i in xrange(1, len(intervals)):
            st, e = intervals[i]
            if s[-1] >= st and s[-2] >= st:
                continue
            if s[-1] >= st:
                s += [e]
            else:
                s += [e - 1, e]
        return len(s)
        