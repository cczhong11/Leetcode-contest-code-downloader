class Solution(object):
    def findMinDifference(self, timePoints):
        """
        :type timePoints: List[str]
        :rtype: int
        """
        
        tims = []
        for c in timePoints:
            ls = c.split(":")
            tims.append(int(ls[0])*60+int(ls[1]))
        
        tims.sort()
        
        min = -tims[len(tims)-1]+tims[0]+24*60
        for i in range(len(tims)-1):
            if (tims[i+1] - tims[i] < min):
                min = tims[i+1] - tims[i]
        return min