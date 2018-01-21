class Solution(object):
    def countCornerRectangles(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if len(grid) == 1 or len(grid[0]) == 1:
            return 0
        
        repo = {}
        for j in xrange(len(grid[0])):
            for i in xrange(len(grid)):
                if grid[i][j]:
                    for k in xrange(i+1, len(grid)):
                        if grid[k][j]:
                            repo[(i,k)] = repo.get((i,k), 0) + 1
                            
        rv = 0
        for k,v in repo.iteritems():
            if v>=2:
                rv += v*(v-1)/2
                
        return rv
            
                    
                    