class Solution(object):
    def fallingSquares(self, p):
        """
        :type positions: List[List[int]]
        :rtype: List[int]
        """
        n = len(p)
        h = [0] * n
        h[0] = p[0][1]
        maxH = h[0]
        res = [maxH]
        for i in range(1,n):
            for j in range(i):
                if p[i][0]>=p[j][0]+p[j][1] or p[i][0]+p[i][1]<=p[j][0]:
                    continue
                h[i] = max(h[i], h[j])
            h[i] += p[i][1]
            maxH = max(maxH, h[i])
            res.append(maxH)
        return res