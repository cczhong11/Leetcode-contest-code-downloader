class Solution:
    def pourWater(self, heights, V, K):
        """
        :type heights: List[int]
        :type V: int
        :type K: int
        :rtype: List[int]
        """
        W = len(heights)
        # def pourOneUnit():
            # ind = K
            # while ind > 0 
        while V > 0:
            lcap = 0
            llim = K
            while llim > 0 and heights[llim-1] <= heights[K]:
                lcap += heights[K] - heights[llim-1]
                llim -= 1
            if lcap <= V:
                for i in range(llim, K):
                    heights[i] = heights[K]
                V -= lcap
            else:
                for i in range(V):
                    min_ind = K-1
                    for ind in reversed(range(llim, K)):
                        if heights[ind] > heights[ind+1]:
                            break
                        if heights[ind] < heights[min_ind]:
                            min_ind = ind
                    heights[min_ind] += 1
                return heights

            rlim = K
            rcap = 0
            while rlim < W-1 and heights[rlim+1] <= heights[K]:
                rcap += heights[K] - heights[rlim+1]
                rlim += 1
            if rcap <= V:
                for i in range(K+1, rlim+1):
                    heights[i] = heights[K]
                V -= rcap
            else:
                for i in range(V):
                    min_ind = K+1
                    for ind in range(K+1, rlim+1):
                        if heights[ind] > heights[ind-1]:
                            break
                        if heights[ind] < heights[min_ind]:
                            min_ind = ind
                    heights[min_ind] += 1
                return heights
            
            if lcap == 0 and rcap == 0:
                heights[K] += 1
                V -= 1
        return heights
        