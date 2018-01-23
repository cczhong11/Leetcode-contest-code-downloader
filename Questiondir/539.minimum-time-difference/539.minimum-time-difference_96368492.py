class Solution(object):
    def findMinDifference(self, timePoints):
        """
        :type timePoints: List[str]
        :rtype: int
        """
        def parse(val):
            ff = val.split(':')
            return int(ff[1])+int(ff[0])*60
        lst = sorted([parse(v) for v in timePoints])
        lst.append(lst[0]+24*60)
        return min(lst[i]-lst[i-1] for i in xrange(1, len(lst)))

