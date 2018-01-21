class Solution(object):
    def pourWater(self, heights, V, K):
        """
        :type heights: List[int]
        :type V: int
        :type K: int
        :rtype: List[int]
        """
        res = heights
        n = len(heights)
        def test(st, ed, dire):
            ref = res[st]
            ans = -1
            for j in xrange(st+dire, ed, dire):
                if res[j] > ref:
                    break
                if res[j] < ref:
                    ref = res[j]
                    ans = j
            return ans
        for ii in range(V):
            pos = K
            jj = test(K, -1, -1)
            if jj == -1:
                jj = test(K, n, 1)
            if jj == -1:
                res[K] += 1
            else:
                res[jj] += 1
        return res

