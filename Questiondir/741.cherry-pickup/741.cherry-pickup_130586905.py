class Solution:
    def cherryPickup(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        # dynamic programming
        # dp[i1][j1][i2][j2] stores the maximum cherry can pick
        # by starting from (i1, j1), (i2, j2) and goes to (n - 1, n - 1)
        # base case dp[n-1,n-1,n-1,n-1] = R[n-1]
        # R = -inf if R = 0
        N = len(grid)
        for i in range(N):
            for j in range(N):
                if grid[i][j] == -1:
                    grid[i][j] = float('-inf')
        cache = dict()
        def helper(i1, j1, i2, j2):
            if (i1, j1, i2, j2) in cache:
                return cache[(i1, j1, i2, j2)]
            if (i1, j1, i2, j2) == (N - 1, N - 1, N - 1, N - 1):
                rtn = grid[N - 1][N - 1]
                cache[(i1, j1, i2, j2)] = rtn
                return rtn
            if i1 >= N or j1 >= N or i2 >= N or j2 >= N or grid[i1][j1] < 0 or grid[i2][j2] < 0:
                rtn = float('-inf')
                cache[(i1, j1, i2, j2)] = rtn
                return rtn
            # Need to consider different cases
            if i1 == i2 and j1 == j2:
                rtn = grid[i1][j1]
                rtn += max(helper(i1 + 1, j1, i2 + 1, j2), helper(i1 + 1, j1, i2, j2 + 1),
                          helper(i1, j1 + 1, i2 + 1, j2), helper(i1, j1 + 1, i2, j2 + 1))
                cache[(i1, j1, i2, j2)] = rtn
                return rtn
            if i1 <= i2 and j1 <= j2:
                # i1, j1 might cross i2, j2
                rtn = grid[i1][j1] + max(helper(i1 + 1, j1, i2, j2), helper(i1, j1 + 1, i2, j2))
                cache[(i1, j1, i2, j2)] = rtn
                return rtn
            if i1 >= i2 and j1 >= j2:
                # i2, j2 might cross i1, j1
                rtn = grid[i2][j2] + max(helper(i1, j1, i2 + 1, j2), helper(i1, j1, i2, j2 + 1))
                cache[(i1, j1, i2, j2)] = rtn
                return rtn
            rtn = grid[i1][j1] + grid[i2][j2]
            rtn += max(helper(i1 + 1, j1, i2 + 1, j2), helper(i1 + 1, j1, i2, j2 + 1),
                       helper(i1, j1 + 1, i2 + 1, j2), helper(i1, j1 + 1, i2, j2 + 1))
            cache[(i1, j1, i2, j2)] = rtn
            return rtn
        rtn = helper(0, 0, 0, 0)
        return max(rtn, 0)
