class Solution(object):
    def containVirus(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m = len(grid)
        n = len(grid[0])
        res = 0

        while(True):
            visited = []
            for i in range(m):
                visited.append([0]*n)
            _loc = {}
            c = []
            w = []
            _n = []
            for i in range(m):
                for j in range(n):
                    if(grid[i][j] == 1 and visited[i][j] == 0):
                        visited[i][j] = 1
                        stack = [(i,j)]
                
                        neig = set([])
                        cand = [(i,j)]
                        wall = 0
                        while(stack):
                            newi,newj = stack.pop()
                            if(newi+1 < m):
                                if(grid[newi+1][newj] == 0):
                                    wall += 1
                                    neig.add((newi+1,newj))
                      
                                if(grid[newi+1][newj] == 1):
                                    cand.append((newi+1,newj))
                                    if(visited[newi+1][newj] == 0):
                                        visited[newi+1][newj] = 1
                                        stack.append((newi+1,newj))
                                
                            if(newi-1 >= 0):
                                if(grid[newi-1][newj] == 0):
                                    wall += 1
                                    neig.add((newi-1,newj))
        
                                if(grid[newi-1][newj] == 1):
                                    cand.append((newi-1,newj))
                                    if(visited[newi-1][newj] == 0):
                                        visited[newi-1][newj] = 1
                                        stack.append((newi-1,newj))
                                
                            if(newj+1 < n):
                                if(grid[newi][newj+1] == 0):
                                    wall += 1
                                    neig.add((newi,newj+1))
            
                                if(grid[newi][newj+1] == 1):
                                    cand.append((newi,newj+1))
                                    if(visited[newi][newj+1] == 0):
                            
                                        visited[newi][newj+1] = 1
                                        stack.append((newi,newj+1))
                                
                            if(newj-1 >=0):
                                if(grid[newi][newj-1] == 0):
                                    wall += 1
                                    neig.add((newi,newj-1))                   
                                if(grid[newi][newj-1] == 1):
                                    cand.append((newi,newj-1))
                                    if(visited[newi][newj-1] == 0):
                                        visited[newi][newj-1] = 1
                                        stack.append((newi,newj-1))
                                
                        total = len(_loc.keys())
                        _loc[total] = cand
                        c.append(len(neig))
                        w.append(wall)
                        _n.append(neig)
            if(not c):
                break
            max_index = 0
            _max = -float('inf')
            for i in range(len(c)):
                if(c[i] > _max):
                    _max = c[i]
                    max_index = i
            for x in _loc[max_index]:
                grid[x[0]][x[1]] = 2
            res += w[max_index]
            for i in range(len(c)):
                if(i == max_index):
                    continue
                for x in _n[i]:
                    grid[x[0]][x[1]] = 1
            #print grid
    
        return res