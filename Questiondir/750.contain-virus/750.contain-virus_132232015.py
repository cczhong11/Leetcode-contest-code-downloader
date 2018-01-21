from collections import deque

class Solution(object):
    def get_regs(self, grid):
        n = len(grid)
        m = len(grid[0])
        for i in xrange(n):
            for j in xrange(m):
                if grid[i][j] > 0:
                    grid[i][j] = 1
        r = 2
        mvs = [(-1,0),(1,0),(0,1),(0,-1)]
        regs = []
        for i in xrange(n):
            for j in xrange(m):
                if grid[i][j] == 1:
                    grid[i][j] = r
                    new_reg = [(i, j)]
                    q = deque([(i, j)])
                    while q:
                        y, x = q.pop()
                        for dy, dx in mvs:
                            ny, nx = y+dy, x+dx
                            if ny >= 0 and ny < n and nx >= 0 and nx < m:
                                if grid[ny][nx] == 1:
                                    grid[ny][nx] = r
                                    new_reg.append((ny, nx))
                                    q.appendleft((ny, nx))
                    regs.append(new_reg)
                    r += 1
        if not regs:
            return 0
        ctwalls = 0
        ctat = 0
        bestr = 0
        atts = []
        for reg_n, r in enumerate(regs):
            curwalls = 0
            at = set([])
            for i,j in r:
                for dy, dx in mvs:
                    ni, nj = i+dy, j+dx
                    if ni >= 0 and ni < n and nj >= 0 and nj < m:
                        if grid[ni][nj] == 0:
                            curwalls += 1
                            if (ni, nj) not in at:
                                at.add((ni, nj))
            if len(at) > ctat:
                ctat = len(at)
                ctwalls = curwalls
                bestr = reg_n
            atts.append(at)
        #print bestr, len(regs)
        for i,j in regs[bestr]:
            grid[i][j] = -1
        for reg_n, r in enumerate(atts):
            if reg_n != bestr:
                for i, j in atts[reg_n]:
                    grid[i][j] = 1
        return ctwalls
        
                            
            
        
                    
                    
                
        
        
    def containVirus(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        total = 0
        while True:
            walls = self.get_regs(grid)
            #print walls
            #print '\n'.join(map(str,grid))
            if walls == 0:
                return total
            total += walls
        