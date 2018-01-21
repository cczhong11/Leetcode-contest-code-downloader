class Solution(object):
    def findLines(self, board):
        pos = set([])
        i = 0
        while i < len(board):
            j = 0
            while j < len(board[0]):
                if board[i][j] == 0:
                    j += 1
                    continue
                dj = j+1
                while dj < len(board[0]) and board[i][dj] == board[i][j]:
                    dj += 1
                if dj-j >= 3:
                    pos |= set([(i, x) for x in xrange(j, dj)])
                j = dj
            i += 1
        j = 0
        while j < len(board[0]):
            i = 0
            while i < len(board):
                if board[i][j] == 0:
                    i += 1
                    continue
                di = i+1
                while di < len(board) and board[di][j] == board[i][j]:
                    di += 1
                if di-i >= 3:
                    pos |= set([(x, j) for x in xrange(i, di)])
                i = di
            j += 1
        return pos
    
    def modifyBoard(self, board, pos):
        for i, j in pos:
            board[i][j] = 0
        for j in xrange(len(board[0])):        
            cur_pos = len(board)-1
            for i in xrange(len(board)-1, -1, -1):
                if board[i][j] != 0:
                    aux = board[i][j]
                    board[i][j] = 0
                    board[cur_pos][j] = aux
                    cur_pos -= 1
        return board
    
    def candyCrush(self, board):
        """
        :type board: List[List[int]]
        :rtype: List[List[int]]
        """
        pos = self.findLines(board)
        while pos:
            self.modifyBoard(board, pos)
            pos = self.findLines(board)
        return board
            
            
            
        