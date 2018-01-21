class Solution(object):
    def imageSmoother(self, M):
        """
        :type M: List[List[int]]
        :rtype: List[List[int]]
        """
        n = len(M)
        m = len(M[0])
        R = [[0 for j in range(m)] for i in range(n)]
        for i in range(n):
            for j in range(m):
                acc = 0
                cnt = 0
                for di in [-1, 0, 1]:
                    for dj in [-1, 0, 1]:
                        ii = i + di
                        jj = j + dj
                        if 0 <= ii < n and 0 <= jj < m:
                            acc += M[ii][jj]
                            cnt += 1
                R[i][j] = acc / cnt
        return R