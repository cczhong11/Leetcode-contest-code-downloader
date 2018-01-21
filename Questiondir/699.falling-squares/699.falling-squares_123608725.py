class Solution(object):
    def fallingSquares(self, positions):
        """
        :type positions: List[List[int]]
        :rtype: List[int]
        """
        ans, lrh = [], []
        for pl, ps in positions:
            pr, ph = pl + ps, 0
            for l, r, h in lrh:
                if pl < r and l < pr:
                    ph = max(ph, h)
            lrh.append([pl, pr, ph + ps])
            if ans:
                ans.append(max(ans[-1], lrh[-1][-1]))
            else:
                ans.append(lrh[-1][-1])
        return ans