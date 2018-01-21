class Solution(object):
    def cherryPickup(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        n = len(grid)
        if n == 1:
            return grid[0][0] if grid[0][0] == 1 else 0
        s = [[0, 0, 0, 0]]
        dp = collections.defaultdict(int)
        dp[(0, 0, 0, 0)] = grid[0][0]
        while s:
            ns = set()
            for x1, y1, x2, y2 in s:
                if x1 + 1 < n and x2 + 1 < n:
                    if grid[x1 + 1][y1] != -1 and grid[x2 + 1][y2] != -1:
                        ns.add((x1 + 1, y1, x2 + 1, y2))
                        tmp = dp[(x1, y1, x2, y2)] + grid[x1 + 1][y1] + grid[x2 + 1][y2]
                        if (x1 + 1, y1) == (x2 + 1, y2) and grid[x1 + 1][y1] == 1:
                            tmp -= 1
                        dp[(x1 + 1, y1, x2 + 1, y2)] = max(dp[(x1 + 1, y1, x2 + 1, y2)], tmp) 
                                                           
                if x1 + 1 < n and y2 + 1 < n:
                    if grid[x1 + 1][y1] != -1 and grid[x2][y2 + 1] != -1:
                        ns.add((x1 + 1, y1, x2, y2 + 1))
                        tmp = dp[(x1, y1, x2, y2)] + grid[x1 + 1][y1] + grid[x2][y2 + 1]
                        if (x1 + 1, y1) == (x2, y2 + 1) and grid[x1 + 1][y1] == 1:
                            tmp -= 1
                        dp[(x1 + 1, y1, x2, y2 + 1)] = max(dp[(x1 + 1, y1, x2, y2 + 1)], tmp) 
                        
                if y1 + 1 < n and y2 + 1 < n:
                    if grid[x1][y1 + 1] != -1 and grid[x2][y2 + 1] != -1:
                        ns.add((x1, y1 + 1, x2, y2 + 1))
                        tmp = dp[(x1, y1, x2, y2)] + grid[x1][y1 + 1] + grid[x2][y2 + 1]
                        if (x1, y1 + 1) == (x2, y2 + 1) and grid[x1][y1 + 1] == 1:
                            tmp -= 1
                        dp[(x1, y1 + 1, x2, y2 + 1)] = max(dp[(x1, y1 + 1, x2, y2 + 1)], tmp) 
                
                if y1 + 1 < n and x2 + 1 < n:
                    if grid[x1][y1 + 1] != -1 and grid[x2 + 1][y2] != -1:
                        ns.add((x1, y1 + 1, x2 + 1, y2))
                        tmp = dp[(x1, y1, x2, y2)] + grid[x1][y1 + 1] + grid[x2 + 1][y2]
                        if (x1, y1 + 1) == (x2 + 1, y2) and grid[x1][y1 + 1] == 1:
                            tmp -= 1
                        dp[(x1, y1 + 1, x2 + 1, y2)] = max(dp[(x1, y1 + 1, x2 + 1, y2)], tmp)
            s = ns
        return dp[(n -1 , n -1, n - 1, n - 1)]