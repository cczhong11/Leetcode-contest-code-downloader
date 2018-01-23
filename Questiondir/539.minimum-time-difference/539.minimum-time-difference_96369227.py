class Solution(object):
    def findMinDifference(self, timePoints):
        """
        :type timePoints: List[str]
        :rtype: int
        """
        tp = sorted([ int(s[:2])*60+int(s[3:]) for s in timePoints ])
        mn = min( tp[i]-tp[i-1] for i in xrange(1,len(tp)) )
        return min(mn, tp[0]+1440-tp[-1])
        