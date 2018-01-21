class Solution(object):
    def cherryPickup(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        cache = dict()
        point =self.twoPoint(grid, 0, 0, 0, 0, cache)
        return point if point > -1 else 0
        
    def twoPoint(self, grid, x1, y1, x2, y2, cache):
        m = len(grid)
        n = len(grid[0])
        
        if x1 >= n or y1 >= m or x2 >= n or y2 >= m or grid[x1][y1] == -1 or grid[x2][y2] == -1:
            return -1
        
        if x1 == n-1 and y1 == m-1:
            return grid[x1][y1]
        
        key = tuple(sorted([(x1, y1), (x2, y2)]))
        if key in cache:
            return cache[key]
        
        ret = -1
        mPoint = -1
        for p1 in [(x1+1,y1), (x1,y1+1)]:
            for p2 in [(x2+1,y2), (x2,y2+1)]:
                point = self.twoPoint(grid, p1[0], p1[1], p2[0],p2[1], cache)
                mPoint = max(mPoint, point)
        if mPoint > -1:
            ret = grid[x1][y1] + grid[x2][y2] + mPoint
            if (x1,y1) == (x2,y2):
                ret -= grid[x1][y1]
        cache[key] = ret
        return ret
        
    
 