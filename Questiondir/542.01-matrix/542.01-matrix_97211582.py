class Solution(object):

    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        n, m = len(matrix), len(matrix[0])
        ans = [[0] * m for _ in xrange(n)]
        cur = []
        visited = set()
        k = 0
        for i in xrange(n):
            for j in xrange(m):
                if matrix[i][j] == 0:
                    cur.append((i, j))
                    visited.add((i, j))
        while cur:
            next = []
            for i, j in cur:
                ans[i][j] = k
                for di, dj in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                    x, y = i+di, j+dj
                    if 0 <= x < n and 0 <= y < m and (x, y) not in visited:
                        next.append((x, y))
                        visited.add((x, y))
            k += 1
            cur = next

        return ans
