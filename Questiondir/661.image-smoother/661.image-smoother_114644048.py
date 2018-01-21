class Solution(object):
    def imageSmoother(self, M):
        """
        :type M: List[List[int]]
        :rtype: List[List[int]]
        """
        if len(M) == 0 or len(M[0]) == 0:
            return M
        n = len(M)
        m = len(M[0])
        r = [[0 for j in xrange(m)] for i in xrange(n)]
        b = [-1, 0, 1]
        for i in xrange(n):
            for j in xrange(m):
                s = 0
                cnt = 0
                for k in b:
                    for l in b:
                        ti = i + k
                        tj = j + l
                        if 0 <= ti < n and 0 <= tj < m:
                            s += M[ti][tj]
                            cnt += 1
                r[i][j] = s / cnt
        return r
        