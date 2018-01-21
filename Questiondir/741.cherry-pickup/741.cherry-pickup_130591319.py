class Solution(object):
    def cherryPickup(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        N = len(grid)

        self.memo = {(0, 0, 0, 0):grid[0][0]}

        def dp(x1, y1, x2, y2):
            if not (0 <= x1 < N and 0 <= y1 < N and 0 <= x2 < N and 0 <= y2 < N):
                return -float("inf")
            if grid[x1][y1] == -1 or grid[x2][y2] == -1:
                return -float("inf")
            if (x1, y1, x2, y2) in self.memo:
                return self.memo[x1, y1, x2, y2]
            res = max(dp(x1 - 1, y1, x2 - 1, y2), dp(x1, y1 - 1, x2 - 1, y2), dp(x1 - 1, y1, x2, y2 - 1), dp(x1, y1 - 1, x2, y2 - 1))
            if (x1, y1) == (x2, y2):
                bonus = grid[x1][y1]
            else:
                bonus = grid[x1][y1] + grid[x2][y2]
            self.memo[x1, y1, x2, y2] = res + bonus
            return self.memo[x1, y1, x2, y2]

        ans = dp(N - 1, N - 1, N - 1, N - 1)
        if ans == -float("inf"):
            return 0
        else:
            return ans