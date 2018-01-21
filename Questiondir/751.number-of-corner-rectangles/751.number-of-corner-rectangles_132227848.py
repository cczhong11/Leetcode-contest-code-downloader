class Solution(object):
    def countCornerRectangles(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m=len(grid)
        n=len(grid[0])
        save={}
        for x in xrange(n):
            for y in xrange(x+1,n):
                save[(x,y)]=[]
        for i in xrange(m):
            for x in xrange(n):
                if grid[i][x]:
                    for y in xrange(x+1,n):
                        if grid[i][y]:
                            save[(x,y)].append(i)
        count=0
        for i in save:
            count+=len(save[i])*(len(save[i])-1)/2
        return count