class Solution(object):
    def countCornerRectangles(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        n = len(grid)
        m = len(grid[0])
        res = 0
        for i in xrange(n):
            for i2 in xrange(i+1, n):
                ctsame = 0
                for j in xrange(m):
                    if grid[i][j] == 1 and grid[i2][j] == 1:
                        ctsame += 1
                res += ctsame*(ctsame-1)/2
        return res
        
            
        