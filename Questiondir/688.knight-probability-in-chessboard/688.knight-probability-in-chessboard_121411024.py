class Solution(object):
    
    def knightProbability(self, N, K, r, c):
        """
        :type N: int
        :type K: int
        :type r: int
        :type c: int
        :rtype: float
        """
        movedir = [(1, 2), (2, 1), (-1, 2), (2, -1), (1, -2), (-2, 1), (-1, -2), (-2, -1)]
        def genNext(pA):
            pB = [[0.0]*N for _ in range(N)]
            for i in range(N):
                for j in range(N):
                    for dx, dy in movedir:
                        if 0<=i+dx<N and 0<=j+dy<N:
                            pB[i+dx][j+dy] += pA[i][j]*1.0/8
            return pB
        pA = [[0.0]*N for _ in range(N)]
        pA[r][c] = 1.0
        for __ in range(K):
            pA = genNext(pA)
        # print pA
        # print sum(pA)
        # print sum(pA[:])
        # return sum(pA)
        return sum(map(sum, pA))