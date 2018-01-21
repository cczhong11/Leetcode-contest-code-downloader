class Solution(object):
	def knightProbability(self, N, K, r, c):
		dirs = [[2,1], [2,-1], [1,2], [1,-2], [-1,2], [-1,-2], [-2,1], [-2,-1]]

		board = [[0] * N for _ in range(N)]
		board[r][c] = 1
		for k in range(K):
			newBoard = [[0] * N for _ in range(N)]
			for i in range(N):
				for j in range(N):
					for di, dj in dirs:
						ni, nj = i + di, j + dj
						if ni >= 0 and ni < N and nj >= 0 and nj < N:
							newBoard[ni][nj] += board[i][j]
			board = newBoard[:]

		s = 0
		for i in range(N):
			for j in range(N):
				s += board[i][j]

		return (s + 0.0)/ (8**K)
        