class Solution(object):
    def containVirus(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        res = 0
        self.aaaa = {}
    
        while True:
            lst = self.findRegions(grid)
            if not lst: return res
            
            for i, j in lst:
                for ii, jj in [(i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1)]:
                    if (i, j, ii, jj) not in self.aaaa and 0 <= ii < len(grid) and 0 <= jj < len(grid[0]) and grid[ii][jj] == 0:
                        res += 1
                        self.aaaa[(i, j, ii, jj)] = 1
                        self.aaaa[(ii, jj, i, j)] = 1
            for i, j in lst:
                grid[i][j] = 2

            self.spread(grid)
    
    def findRegions(self, grid):
        tmp = []
        num = -1
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    lst, affect = self.findRegion(grid, i, j)
                    num1 = len(set(affect))
                    
                    if num1 > num:
                        tmp = lst
                        num = num1
                        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                grid[i][j] %= 10
                
        return tmp
    
    def findRegion(self, grid, i, j):
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]): return [], []
        
        if grid[i][j] == 0: return [], [(i, j)]
        
        if grid[i][j] != 1: return [], []
        
        res = [(i, j)]
        affect = []
        grid[i][j] += 10
        
        for ii, jj in [(i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1)]:
            if (i, j, ii, jj) not in self.aaaa:
                res1, a1 = self.findRegion(grid, ii, jj)
                res += res1
                affect += a1
        
        return res, affect
        
    
    def spread(self, grid):
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    for ii, jj in [(i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1)]:
                        if (i, j, ii, jj) not in self.aaaa and 0 <= ii < len(grid) and 0 <= jj < len(grid[0]) and grid[ii][jj] == 0:
                            grid[ii][jj] = 11
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                grid[i][j] %= 10

        