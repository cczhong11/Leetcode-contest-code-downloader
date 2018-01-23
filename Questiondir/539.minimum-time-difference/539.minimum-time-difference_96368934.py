class Solution(object):

    def findMinDifference(self, timePoints):
        """
        :type timePoints: List[str]
        :rtype: int
        """
        def get(x):
            return int(x[:2])*60+int(x[3:])
        tp = sorted(map(get, timePoints))
        ans = 2 ** 31
        for i in xrange(len(tp)-1):
            ans = min(ans, tp[i+1]-tp[i])
        ans = min(ans, get('24:00')-tp[-1]+tp[0])
        return ans
