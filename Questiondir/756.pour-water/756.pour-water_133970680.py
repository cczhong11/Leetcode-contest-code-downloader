class Solution(object):
    def to_left(self, heights, k):
        p = k - 1
        while True:
            if p < 0:
                return None
            if heights[k] < heights[p]:
                return None
            elif heights[k] > heights[p]:
                nxt = self.to_left(heights, p)
                if nxt is None:
                    return p
                else:
                    return nxt
            else:
                p -= 1
    
    def to_right(self, heights, k):
        n = len(heights)
        p = k + 1
        while True:
            if p >= n:
                return None
            if heights[k] < heights[p]:
                return None
            elif heights[k] > heights[p]:
                nxt = self.to_right(heights, p)
                if nxt is None:
                    return p
                else:
                    return nxt
            else:
                p += 1

    def pourWater(self, heights, V, K):
        """
        :type heights: List[int]
        :type V: int
        :type K: int
        :rtype: List[int]
        """
        n = len(heights)
        res = heights[:]
        for i in range(V):
            water = self.to_left(res, K)
            if water is None:
                water = self.to_right(res, K)
                if water is None:
                    res[K] += 1
                else:
                    res[water] += 1
            else:
                res[water] += 1
        return res
    