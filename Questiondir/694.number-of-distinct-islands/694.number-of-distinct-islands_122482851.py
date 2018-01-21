class Solution:
  def numDistinctIslands(self, grid):
    """
        :type grid: List[List[int]]
        :rtype: int
        """
    if len(grid) == 0:
      return 0
    m, n = len(grid), len(grid[0])
    dx, dy = (1, -1, 0, 0), (0, 0, 1, -1)
    distinct_set = set()

    def bfs(u, v):
      q = [(u, v)]
      shape = []
      for x, y in q:
        if grid[x][y] != 1:
          continue
        grid[x][y] = -1
        shape.append((x-u, y-v))
        for i in range(4):
          nx, ny = x + dx[i], y + dy[i]
          if 0<=nx<m and 0<=ny<n and grid[nx][ny]==1:
            q.append((nx, ny))
      distinct_set.add(tuple(shape))

    for i in range(m):
      for j in range(n):
        if grid[i][j] == 1:
          bfs(i, j)
    return len(distinct_set)
