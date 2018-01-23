class Solution(object):
    def findMinDifference(self, timePoints):
        """
        :type timePoints: List[str]
        :rtype: int
        """
        timePoints = sorted(timePoints, key=lambda x: x.split(':'))
        minDiff = 24 * 60
        for i in range(len(timePoints)):
            h1, m1 = timePoints[i].split(":")
            h2, m2 = timePoints[(i - 1 + len(timePoints)) % len(timePoints)].split(":")
            diff = ((int(h1) - int(h2) + 24) % 24) * 60 + int(m1) - int(m2)
            minDiff = min(abs(diff), minDiff)
        return minDiff