class Solution(object):
  def maxAreaOfIsland(self, grid):
    """
        :type grid: List[List[int]]
        :rtype: int
        """
    if len(grid) == 0:
      return 0
    m, n = len(grid), len(grid[0])
    max_area = 0
    dx, dy = (1, -1, 0, 0), (0, 0, 1, -1)

    def bfs(x, y):
      nonlocal max_area
      q = [(x, y)]
      area = 0
      for x, y in q:
        if grid[x][y] != 1:
          continue
        grid[x][y] = -1
        area += 1
        for i in range(4):
          nx, ny = x + dx[i], y + dy[i]
          if 0<=nx<m and 0<=ny<n and grid[nx][ny]==1:
            q.append((nx, ny))
      max_area = max(area, max_area)

    for i in range(m):
      for j in range(n):
        if grid[i][j] == 1:
          bfs(i, j)
    return max_area
