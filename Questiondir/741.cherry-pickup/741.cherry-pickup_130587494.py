class Solution(object):
    def cherryPickup(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        n = len(grid)
        cur = [[grid[0][0]]]
        for l in range(1, n):
            pre, cur = cur, [[-1 for j in range(l + 1)] for i in range(l + 1)]
            for i in range(l + 1):
                for j in range(i, l + 1):
                    m = -1
                    for ii in [i - 1, i]:
                        for jj in [j - 1, j]:
                            if 0 <= ii < l and 0 <= jj < l:
                                m = max(m, pre[ii][jj])
                    if m >= 0 and grid[l - i][i] >= 0 and grid[l - j][j] >= 0:
                        cur[i][j] = m + grid[l - i][i] + grid[l - j][j] if i != j else m + grid[l - i][i]
                    else:
                        cur[i][j] = -1
            #print cur
        for l in range(n - 2, -1, -1):
            pre, cur = cur, [[-1 for j in range(l + 1)] for i in range(l + 1)]
            for i in range(l + 1):
                for j in range(i, l + 1):
                    m = -1
                    for ii in [i + 1, i]:
                        for jj in [j + 1, j]:
                            m = max(m, pre[ii][jj])
                    if m >= 0 and grid[n - 1 - i][n - 1 - l + i] >= 0 and grid[n - 1 - j][n - 1 - l + j] >= 0:
                        cur[i][j] = m + grid[n - 1 - i][n - 1 - l + i] + grid[n - 1 - j][n - 1 - l + j] if i != j else m + grid[n - 1 - i][n - 1 - l + i]
                    else:
                        cur[i][j] = -1
            #print cur
        return max(cur[0][0], 0)