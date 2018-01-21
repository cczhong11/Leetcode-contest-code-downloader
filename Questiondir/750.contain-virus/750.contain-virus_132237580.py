import collections
class Solution(object):
    def containVirus(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        ni, nj = len(grid), len(grid[0])
        self.ni, self.nj = ni, nj
        self.vWalls = [[False]*(nj-1) for _ in xrange(ni)]
        self.hWalls = [[False]*nj for _ in xrange(ni-1)]
        
        self.grid = grid
        
        rv = 0
        
        while True:
            self.visited = [[False] * nj for _ in xrange(ni)]
            repo = {}
            cnt = 0
            maxCR, maxCnt = -1, -1
            #p(self.grid)
            #print ""
            for i in xrange(ni):
                for j in xrange(nj):
                    if (not self.visited[i][j]) and (self.grid[i][j] == 1):
                        region, nextRegion, vWallsNeeded, hWallsNeeded = self.detectRegion(i,j)
                        if len(nextRegion) > maxCR:
                            maxCR, maxCnt = len(nextRegion), cnt
                        repo[cnt] = region, nextRegion, vWallsNeeded, hWallsNeeded
                        cnt += 1
            
            if cnt == 0:
                return rv
            
            region, nextRegion, vWallsNeeded, hWallsNeeded = repo[maxCnt]
            rv += len(vWallsNeeded) + len(hWallsNeeded)
            
            #print region
            #print nextRegion
            #print vWallsNeeded
            #print hWallsNeeded
            
            for ii, jj in vWallsNeeded:
                self.vWalls[ii][jj] = True
            for ii, jj in hWallsNeeded:
                self.hWalls[ii][jj] = True
            for ii, jj in region:
                self.grid[ii][jj] = 0
                
            for k, v in repo.iteritems():
                if k==maxCnt:
                    continue
                   
                _, nextRegion, _, _ = v
                #print nextRegion
                for ii, jj in nextRegion:
                    self.grid[ii][jj] = 1
        
                        
    
    def detectRegion(self, i, j):
        region, nextRegion, vWallsNeeded, hWallsNeeded = set(), set(), set(), set()
        queue = collections.deque([(i,j)])
        
        while len(queue) > 0:
            i, j = queue.popleft()
            
            if (i<0) or (i>self.ni) or (j<0) or (j>self.nj) or self.visited[i][j]:
                continue
            
            self.visited[i][j] = True
            region.add((i,j))
            
            if i>0:
                ii, jj = i-1, j
                if not self.hWalls[ii][jj]:
                    if self.grid[ii][jj] == 0:
                        nextRegion.add((ii,jj))
                        hWallsNeeded.add((ii,jj))
                    elif not self.visited[ii][jj]:
                        queue.append((ii, jj))
            
            if i<self.ni-1:
                ii, jj = i+1, j
                if not self.hWalls[ii-1][jj]:
                    if self.grid[ii][jj] == 0:
                        nextRegion.add((ii,jj))
                        hWallsNeeded.add((ii-1,jj))
                    elif not self.visited[ii][jj]:
                        queue.append((ii, jj))
        
            if j>0:
                ii, jj = i, j-1
                if not self.vWalls[ii][jj]:
                    if self.grid[ii][jj] == 0:
                        nextRegion.add((ii,jj))
                        vWallsNeeded.add((ii,jj))
                    elif not self.visited[ii][jj]:
                        queue.append((ii,jj))
            
            if j<self.nj-1:
                ii, jj = i, j+1
                if not self.vWalls[ii][jj-1]:
                    if self.grid[ii][jj] == 0:
                        nextRegion.add((ii, jj))
                        vWallsNeeded.add((ii,jj-1))
                    elif not self.visited[ii][jj]:
                        queue.append((ii,jj))
                        
        return region, nextRegion, vWallsNeeded, hWallsNeeded
                    