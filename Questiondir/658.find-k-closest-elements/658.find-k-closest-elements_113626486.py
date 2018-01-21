class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        g = []
        for i in arr:
            g.append((i - x, i))
        def comp(a, b):
            if abs(a[0]) == abs(b[0]):
                return a[1] - b[1]
            return abs(a[0]) - abs(b[0])
        g = sorted(g, cmp=comp)
        res = []
        for i in range(k):
            res.append(g[i][1])
        res.sort()
        return res