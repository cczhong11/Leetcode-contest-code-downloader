class Solution(object):
    def candyCrush(self, board):
        """
        :type board: List[List[int]]
        :rtype: List[List[int]]
        """
        
        l1 = len(board)
        l2 = len(board[0])
        #print(l1,l2)
        
        ongoing = True
        while ongoing:
            to_crush = set()
            for i in range(l1):
                for j in range(l2):
                    if board[i][j] > 0:
                        if 1 <= i < l1-1:
                            if board[i-1][j] == board[i][j] == board[i+1][j]:
                                to_crush.add((i-1,j))
                                to_crush.add((i,j))
                                to_crush.add((i+1,j))
                        if 1 <= j < l2-1:
                            if board[i][j-1] == board[i][j] == board[i][j+1]:
                                to_crush.add((i,j-1))
                                to_crush.add((i,j))
                                to_crush.add((i,j+1))
            
            if len(to_crush) > 0:
                for (a,b) in to_crush:
                    #print(a,b)
                    board[a][b] = 0
            else:
                ongoing = False
                
            #print(board)
            
            for j in range(l2):
                i = l1 - 1
                while i >= 0:
                    if board[i][j] == 0:
                        k = i-1
                        while k >= 0 and board[k][j] == 0:
                            k -= 1
                        if k >= 0:
                            board[i][j] = board[k][j]
                            board[k][j] = 0
                    i -= 1
        return board
            #print("!!!", len(to_crush), to_crush)