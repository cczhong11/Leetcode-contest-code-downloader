class Solution(object):
    def pourWater(self, heights, V, K):
        """
        :type heights: List[int]
        :type V: int
        :type K: int
        :rtype: List[int]
        """
        for n in xrange(V):
            h = heights[K]
            # Try left
            i = K
            while i > 0 and heights[i - 1] <= heights[i]:
                i -= 1
            if heights[i] < h:
                targetHeight = heights[i]
                while i < len(heights) - 1 and heights[i + 1] == targetHeight:
                    i += 1
                heights[i] += 1
                continue
            # Try right
            i = K
            while i < (len(heights) - 1) and heights[i + 1] <= heights[i]:
                i += 1
            if heights[i] < h:
                targetHeight = heights[i]
                while i > 0 and heights[i - 1] == targetHeight:
                    i -= 1
                heights[i] += 1
                continue
            # Center
            heights[K] += 1
        return heights
        