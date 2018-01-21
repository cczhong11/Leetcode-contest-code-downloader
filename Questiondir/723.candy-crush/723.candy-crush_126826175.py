class Solution(object):
    def candyCrush(self, board):
        """
        :type board: List[List[int]]
        :rtype: List[List[int]]
        """
        if not board: return []
        h,w=len(board),len(board[0])
        def findzero(board):
            rt = set()
            for i in xrange(h):
                for j in xrange(1,w-1):
#                     print i,j
#                     print board[i][j-1],board[i][j],board[i][j+1]
                    if board[i][j]==board[i][j-1] and board[i][j]==board[i][j+1] and board[i][j]:
                        rt.add((i,j))
                        rt.add((i,j-1))
                        rt.add((i,j+1))
                        
            for j in xrange(w):
                for i in xrange(1,h-1):
                    if board[i][j]==board[i+1][j]==board[i-1][j] and board[i][j]:
                        rt.add((i,j))
                        rt.add((i+1,j))
                        rt.add((i-1,j))
            return rt
        def removezero(board):
            for j in xrange(w):
                l,r=h-1,h-1
                while r>=0:
                    if board[r][j]!=0:
                        if r!=l:
                            board[l][j]=board[r][j]
                            board[r][j]=0
                        r-=1
                        l-=1
                    else:
                        r-=1
                        
        ss = findzero(board)
        while ss:
            for i,j in ss:
                board[i][j]=0
            removezero(board)
            ss = findzero(board)
            
        return board