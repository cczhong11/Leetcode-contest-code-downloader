class Solution(object):
    def imageSmoother(self, M):
        """
        :type M: List[List[int]]
        :rtype: List[List[int]]
        """
        m, n = map(len, [M, M[0]])
        ans = [[M[i][j] for j in xrange(n)] for i in xrange(m)]
        for i in xrange(m):
            for j in xrange(n):
                cnt = 1
                for dx, dy in zip([1, 1, 1, 0, 0, -1, -1, -1], [1, 0, -1, 1, -1, 1, 0, -1]):
                    x, y = i + dx, j + dy
                    if 0 <= x < m and 0 <= y < n:
                        ans[i][j] += M[x][y]
                        cnt += 1
                ans[i][j] /= cnt
        return ans