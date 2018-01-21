class Solution(object):
    def maxAreaOfIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        ret = 0
        m = len(grid)
        if m == 0:
            return 0
        n = len(grid[0])
        for i in xrange(m):
            for j in xrange(n):
                if grid[i][j] == 1:
                    ret = max(ret, self.helper(grid, i, j))
        return ret
    def helper(self, grid, i, j):
        m = len(grid)
        n = len(grid[0])
        if i < 0 or j < 0 or i >= m or j >= n:
            return 0
        ret = 0
        if grid[i][j] == 1:
            ret += 1
            grid[i][j] = 0
            ret += self.helper(grid, i-1, j)
            ret += self.helper(grid, i+1, j)
            ret += self.helper(grid, i, j-1)
            ret += self.helper(grid, i, j+1)
        return ret
        