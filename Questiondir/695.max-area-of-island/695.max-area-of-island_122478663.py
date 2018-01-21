class Solution(object):
    def maxAreaOfIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        
        def dfs(i, j, m, n, grid, visited):
            visited[i][j] = True
            area = 1
            
            dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
            for d in dirs:
                x, y = i+d[0], j+d[1]
                if 0 <= x < m and 0 <= y < n and grid[x][y] == 1 and not visited[x][y]:
                    area += dfs(x, y, m, n, grid, visited)
            return area
            
        if not grid or not grid[0]:
            return 0
        
        m, n = len(grid), len(grid[0])
        visited = [[False for _ in range(n)] for _ in range(m)]
        max_area = 0
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1 and not visited[i][j]:
                    max_area = max(max_area, dfs(i, j, m, n, grid, visited))
        return max_area