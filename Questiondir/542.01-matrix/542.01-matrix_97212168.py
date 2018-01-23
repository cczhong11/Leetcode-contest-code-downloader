class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        n = len(matrix)
        m = len(matrix[0])
        res = [[-1 for j in range(m)] for i in range(n)]
        cur = []
        for i in range(n):
            for j in range(m):
                if matrix[i][j] == 0:
                    res[i][j] = 0
                    cur.append((i, j))
        dist = 0
        while cur:
            dist += 1
            pre = cur
            cur = []
            for x, y in pre:
                for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                    xx = x + dx
                    yy = y + dy
                    if 0 <= xx < n and 0 <= yy < m and res[xx][yy] == -1:
                        res[xx][yy] = dist
                        cur.append((xx, yy))
        return res