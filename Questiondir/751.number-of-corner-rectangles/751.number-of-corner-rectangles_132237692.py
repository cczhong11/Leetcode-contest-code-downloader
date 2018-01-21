class Solution(object):
    def countCornerRectangles(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m,n = len(grid), len(grid[0])
        if m < n:
            m,n = n,m
            G = [[0] * n for _ in range(m)]
            for x in xrange(m):
                for y in xrange(n):
                    G[x][y] = grid[y][x]
            grid = G
        D = dict()
        ans = 0
        for z in xrange(m):
            row = grid[z]
            for x in xrange(n):
                if row[x] != 1: continue
                for y in xrange(x+1, n):
                    if row[y] != 1: continue
                    ret = D.get((x,y), 0)
                    ans += ret
                    D[(x,y)] = ret + 1
        return ans

