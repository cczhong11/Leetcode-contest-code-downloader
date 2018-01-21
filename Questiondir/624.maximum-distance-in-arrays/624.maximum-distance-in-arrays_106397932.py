class Solution(object):
    def maxDistance(self, arrays):
        """
        :type arrays: List[List[int]]
        :rtype: int
        """
        res = 0
        l = 10001
        r = -10001
        for ar in arrays:
            if ar:
                res = max(res, r - ar[0], ar[-1] - l)
                l = min(l, ar[0])
                r = max(r, ar[-1])
        return res