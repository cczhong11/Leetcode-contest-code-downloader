class Solution(object):
    def containVirus(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        def visit(i,j, mgrid, spread):
            if mgrid[i][j] <= 0:
                return 0
            mgrid[i][j] = -1
            total = 1
            neighbors = [(i+x, j+y) for x,y in [(1,0), (0,1), (-1,0), (0,-1)]]
            for a,b in neighbors:
                if 0 <= a < len(grid) and 0 <= b < len(grid[0]):
                    if(mgrid[a][b] == 0):
                        spread.add((a,b))
                    else:
                        visit(a,b, mgrid, spread)
        
        def fence(i, j, mgrid):
            if mgrid[i][j] != 1:
                return 0
            mgrid[i][j] = -2 # Fence erected
            neighbors = [(i+x, j+y) for x,y in [(1,0), (0,1), (-1,0), (0,-1)]]
            total = 0
            for a,b in neighbors:
                if 0 <= a < len(mgrid) and 0 <= b < len(mgrid[0]):
                    if mgrid[a][b] == 0:
                        total += 1
                    else:
                        total += fence(a,b,mgrid)
            return total
        
        def virusspread(i,j,mgrid):
            if mgrid[i][j] != 1:
                return 
            grid[i][j] = 3 # spreading
            neighbors = [(i+x, j+y) for x,y in [(1,0), (0,1), (-1,0), (0,-1)]]
            for a,b in neighbors:
                if 0 <= a < len(mgrid) and 0 <= b < len(mgrid[0]):
                    if mgrid[a][b] == 0:
                        mgrid[a][b] = 3
                    else:
                        virusspread(a,b,mgrid)
        fencesused = 0
        
        maxval = 0
        maxpos = 0,0
        while True:
            maxval = 0
            maxpos = -1,-1
            curgrid = copy.deepcopy(grid)
            for i in range(len(grid)):
                for j in range(len(grid[0])):
                    spread = set()
                    visit(i,j,curgrid, spread)
                    if len(spread) > maxval:
                        maxval = len(spread)
                        maxpos = i,j
            # Erect the fence
            if maxpos == (-1,-1):
                return fencesused
            px,py = maxpos
            fencesused += fence(px, py, grid)
            # Spread the virus
            for i in range(len(grid)):
                for j in range(len(grid[0])):
                    virusspread(i,j,grid)
            for i in range(len(grid)):
                for j in range(len(grid[0])):
                    if grid[i][j] == 3:
                        grid[i][j] = 1
            #print(grid, fencesused)
