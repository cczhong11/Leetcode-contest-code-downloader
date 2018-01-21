class Solution(object):
    def candyCrush(self, board):
        """
        :type board: List[List[int]]
        :rtype: List[List[int]]
        """
        n = len(board)
        m = len(board[0])
        def eliminate():
            ans = set()
            for i in xrange(n):
                for j in xrange(m):
                    if board[i][j] == 0:
                        continue
                    tmp = []
                    k = j
                    while k < m and board[i][j] == board[i][k]:
                        tmp.append((i, k))
                        k += 1
                    if len(tmp) >= 3:
                        ans |= set(tmp)
                    tmp = []
                    k = i
                    while k < n and board[i][j] == board[k][j]:
                        tmp.append((k, j))
                        k += 1
                    if len(tmp) >= 3:
                        ans |= set(tmp)
            if len(ans) == 0:
                return False
            for i, j in ans:
                board[i][j] = 0
            return True
        def fall():
            for j in xrange(m):
                k = n-1
                for i in xrange(n-1, -1, -1):
                    if board[i][j] != 0:
                        board[k][j] = board[i][j]
                        k -= 1
                for i in xrange(k, -1, -1):
                    board[i][j] = 0
        while eliminate():
            fall()
        return board