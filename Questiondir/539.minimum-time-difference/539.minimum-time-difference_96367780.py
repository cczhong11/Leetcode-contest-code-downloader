class Solution(object):
    def findMinDifference(self, timePoints):
        """
        :type timePoints: List[str]
        :rtype: int
        """
        visited = set()
        for ts in timePoints:
            mins = int(ts[:2]) * 60 + int(ts[3:])
            if mins in visited:
                return 0
            visited.add(mins)
        arr = list(visited)
        arr.sort()
        res = 24 * 60 + arr[0] - arr[-1]
        for i in range(1, len(arr)):
            res = min(res, arr[i] - arr[i - 1])
        return res