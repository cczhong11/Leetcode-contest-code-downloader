class Solution(object):
    def findMinDifference(self, timePoints):
        """
        :type timePoints: List[str]
        :rtype: int
        """
        def f(s):
            l = s.split(':')
            h, m = int(l[0]), int(l[1])
            return h*60+m
        l = map(f, timePoints)
        l.sort()
        minD = float('inf')
        for i in range(len(l)-1):
            minD = min(minD, abs(l[i+1]-l[i]))
        minD = min(minD, abs(l[0]+24*60-l[-1]))
        return minD