class Solution:
    def mark(self, board, should_crash):
        for i in range(0, len(board)):
            for j in range(0, len(board[i])):
                if board[i][j] == 0:
                    continue
                
                if j > 0 and j < len(board[i]) - 1 and board[i][j - 1] == board[i][j] and board[i][j] == board[i][j + 1]:
                    should_crash[i][j - 1] = 1
                    should_crash[i][j] = 1
                    should_crash[i][j + 1] = 1
                if i > 0 and i < len(board) - 1 and board[i - 1][j] == board[i][j] and board[i][j] == board[i + 1][j]:
                    should_crash[i - 1][j] = 1
                    should_crash[i][j] = 1
                    should_crash[i + 1][j] = 1
                    
                    
    def crash(self, board, should_crash):
        if sum(sum(row) for row in should_crash) == 0:
            return False
                
        #print("\n".join(str(row) for row in should_crash))
        #print("+" * 80)

        for j in range(len(board[0])):
            k = len(board) - 1
            for i in range(len(board) - 1, -1, -1):
                if not should_crash[i][j]:
                    board[k][j] = board[i][j]
                    k -= 1
                    
            for i in range(k, -1, -1):
                board[i][j] = 0
                    
        for row in should_crash:
            for j in range(len(row)):
                row[j] = 0
        
        return True
            
    def candyCrush(self, board):
        """
        :type board: List[List[int]]
        :rtype: List[List[int]]
        """
        
        should_crash = [[0] * len(board[0]) for _ in board]
        
        should_continue = True
        
        #print("\n".join(str(row) for row in board))
        #print("=" * 80)

        while should_continue:
            self.mark(board, should_crash)
            should_continue &= self.crash(board, should_crash)
            #print("\n".join(str(row) for row in board))
            #print("=" * 80)
            
        return board
        