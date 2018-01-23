class Solution(object):
    def findMinDifference(self, timePoints):
        """
        :type timePoints: List[str]
        :rtype: int
        """
        mytimes = [self.convertToMinute(s) for s in timePoints]
        mytimes.sort()
        newtimes = mytimes[1:] + [mytimes[0] + 60 * 24]
        timediff = [i-j for i, j in zip(newtimes, mytimes)]
        return min(timediff)
        
    def convertToMinute(self, s):
        h= int(s.split(":")[0])
        m= int(s.split(":")[1])
        return h * 60 + m