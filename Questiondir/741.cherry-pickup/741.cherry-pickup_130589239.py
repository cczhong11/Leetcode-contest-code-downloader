from collections import deque

class Solution(object):
    def solve(self, grid, dp, steps, i1, i2):
        n = len(grid)
        j1 = steps-i1
        j2 = steps-i2
        if steps == 2*(n-1) and i1 == n-1 and i2 == n-1:
            return grid[n-1][n-1]
        if i1 == n or j1 == n or i2 == n or j2 == n or grid[i1][j1] == -1 or grid[i2][j2] == -1:
            return -1000000
        if (steps,i1,i2) in dp:
            return dp[(steps, i1, i2)]
        val = -1000000
        if i1 == i2 and j1 == j2:
            cur = grid[i1][j1]
        else:
            cur = grid[i1][j1] + grid[i2][j2]
        val = max(val, cur + self.solve(grid, dp, steps+1, i1+1, i2))
        val = max(val, cur + self.solve(grid, dp, steps+1, i1, i2+1))
        val = max(val, cur + self.solve(grid, dp, steps+1, i1, i2))
        val = max(val, cur + self.solve(grid, dp, steps+1, i1+1, i2+1))
        dp[(steps, i1, i2)] = val
        return val
        
    
    def cherryPickup(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        n = len(grid)
        return max(self.solve(grid, {}, 0, 0, 0), 0)
      