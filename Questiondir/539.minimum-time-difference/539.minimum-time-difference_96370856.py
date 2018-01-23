class Solution(object):
    def findMinDifference(self, timePoints):
        """
        :type timePoints: List[str]
        :rtype: int
        """
        mins = []
        for t in timePoints:
            h, m = t.split(':')
            mins.append(int(h)*60+int(m))
        mins.sort()
        diff = [mins[i]-mins[i-1] for i in xrange(1, len(mins))]
        return min(min(diff), mins[0]+24*60-mins[-1])