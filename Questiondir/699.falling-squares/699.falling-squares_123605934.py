class Solution(object):
    def fallingSquares(self, positions):
        """
        :type positions: List[List[int]]
        :rtype: List[int]
        """
        n = len(positions)
        height = []
        ans = []
        for i in range(n):
            sq = positions[i]
            h = 0
            for j in range(i):
                if (sq[0] < positions[j][0] and sq[0] + sq[1] - 1 >= positions[j][0]) or (sq[0] >= positions[j][0] and sq[0] <= positions[j][0] + positions[j][1] - 1):
                    h = max(h, height[j])
            h += sq[1]
            height.append(h)
            if i == 0:
                ans.append(h)
            else:
                ans.append(max(ans[i - 1], h))
        return ans