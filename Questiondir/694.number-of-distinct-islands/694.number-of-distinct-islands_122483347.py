class Solution(object):
    def numDistinctIslands(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        def dfs(i, j, m, n, grid, visited):
            visited[i][j] = True
            island = ''
            
            dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
            symbol = ['a', 'b', 'c', 'd']
            for index, d in enumerate(dirs):
                x, y = i+d[0], j+d[1]
                if 0 <= x < m and 0 <= y < n and grid[x][y] == 1 and not visited[x][y]:
                    island += str(index) + dfs(x, y, m, n, grid, visited) + symbol[index]
            return island
            
        if not grid or not grid[0]:
            return 0
        
        m, n = len(grid), len(grid[0])
        visited = [[False for _ in range(n)] for _ in range(m)]
        islands = set()
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1 and not visited[i][j]:
                    islands.add(dfs(i, j, m, n, grid, visited))
        return len(islands)