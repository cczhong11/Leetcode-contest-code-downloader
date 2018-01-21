class Solution(object):
    def pourWater(self, heights, V, K):
        """
        :type heights: List[int]
        :type V: int
        :type K: int
        :rtype: List[int]
        """
        
        for v in range(V):
#            print v
            i = K
            fill = K
            done = False
            while i > 0 and heights[i] >= heights[i - 1]:
                if heights[i] > heights[i - 1]:
                    fill = i - 1
                i -= 1
#            print fill
            if fill == K:
                i = K
                while i < len(heights) - 1 and heights[i] >= heights[i + 1]:
                    if heights[i] > heights[i + 1]:
                        fill = i + 1
                    i += 1
            heights[fill] += 1
#            print fill
#            print heights
        
        return heights