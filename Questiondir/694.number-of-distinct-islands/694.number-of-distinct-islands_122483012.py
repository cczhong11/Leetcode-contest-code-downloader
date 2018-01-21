class Solution(object):
    def numDistinctIslands(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        ret = set()
        m = len(grid)
        if m == 0:
            return 0
        n = len(grid[0])
        for i in xrange(m):
            for j in xrange(n):
                if grid[i][j] == 1:
                    ret.add(self.helper(grid, i, j, [(0,-1), (0,1), (-1,0), (1,0)]))
        return len(ret)
    def helper(self, grid, i, j, offsets):
        m = len(grid)
        n = len(grid[0])
        q = collections.deque()
        q.append((i, j))
        grid[i][j] = 0
        ret = []
        while q:
            x, y = q.pop()
            for dx, dy in offsets:
                xx = x + dx
                yy = y + dy
                if xx >= 0 and yy >= 0 and xx < m and yy < n and grid[xx][yy] == 1:
                    ret.append((xx-i, yy-j))
                    q.append((xx,yy))
                    grid[xx][yy] = 0
        return tuple(ret)

                
                
                