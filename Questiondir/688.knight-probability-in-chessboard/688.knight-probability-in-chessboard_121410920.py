class Solution(object):
    def knightProbability(self, N, K, r, c):
        """
        :type N: int
        :type K: int
        :type r: int
        :type c: int
        :rtype: float
        """
        moves = [[-1,-2],[-1,2],[1,-2],[1,2],
                 [-2,-1],[-2,1],[2,-1],[2,1]]
        
        board = [[0] * N for _ in xrange(N)]
        board[r][c] = 1.0
        
        for _ in xrange(K):
            newBoard = [[0] * N for _ in xrange(N)]
            for i in xrange(N):
                for j in xrange(N):
                    if board[i][j] == 0:
                        continue
                        
                    for di,dj in moves:
                        ni,nj = i+di, j+dj
                        if (0<=ni<N) and (0<=nj<N):
                            newBoard[ni][nj] += board[i][j] * 0.125
            
            board = newBoard
            
        rv = sum([sum(x) for x in board])
        return rv
                        