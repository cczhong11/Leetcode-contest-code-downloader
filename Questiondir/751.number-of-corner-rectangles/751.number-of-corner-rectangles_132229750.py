class Solution(object):
    def countCornerRectangles(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if not grid:
            return 0
        count = 0
        ones = collections.defaultdict(lambda:0)
        
        for i in range(len(grid)):
            currentones = []
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    for x in currentones:
                        count += ones[(x,j)]
                        ones[(x,j)] += 1
                    currentones.append(j)
        return count
                
                    
                