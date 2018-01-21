class Solution(object):
    def knightProbability(self, N, K, r, c):
        """
        :type N: int
        :type K: int
        :type r: int
        :type c: int
        :rtype: float
        """
        # 0-th stage, probability of staying on the board for K == 0
        board = [[1]*N for _ in xrange(N)]
        moves = [(1,2), (2,1), (-1, 2), (-2, 1), (2, -1), (1, -2), (-1, -2), (-2, -1)]
        for k in xrange(K):
            nextboard = [[0]*N for _ in xrange(N)]
            for x in xrange(N):
                for y in xrange(N):
                    total = 8
                    alive = 8
                    for (dx, dy) in moves:
                        newX = x + dx
                        newY = y + dy
                        if newX < 0 or newY < 0 or newX >= N or newY >= N:
                            alive -= 1
                        else:
                            alive -= 1-board[newX][newY]
                    nextboard[x][y] = alive/8.
            board = nextboard
        return board[r][c]
                        
                    
                    
                
        