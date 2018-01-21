class Solution:
    def candyCrush(self, board):
        """
        :type board: List[List[int]]
        :rtype: List[List[int]]
        """
        
        xlen = len(board[0])
        ylen = len(board)
        
        while True:
            crushed_some = False
            crushed = [[False for i in range(xlen)] for j in range(ylen)]
            for j in range(ylen):
                typ = -1
                nliketyp = 0
                for i in range(xlen):
                    if board[j][i] == typ:
                        nliketyp += 1
                    else:
                        if nliketyp >= 3 and typ > 0:
                            #print(nliketyp)
                            for di in range(nliketyp):
                                crushed[j][i-di-1] = True
                            crushed_some = True
                        typ = board[j][i]
                        nliketyp = 1
                if nliketyp >= 3 and typ > 0:
                    #print(nliketyp)
                    for di in range(nliketyp):
                        crushed[j][xlen-di-1] = True
                    crushed_some = True

            for i in range(xlen):
                typ = -1
                nliketyp = 0
                for j in range(ylen):
                    if board[j][i] == typ:
                        nliketyp += 1
                    else:
                        if nliketyp >= 3 and typ > 0:
                            #print(nliketyp)
                            for dj in range(nliketyp):
                                crushed[j-dj-1][i] = True
                            crushed_some = True
                        typ = board[j][i]
                        nliketyp = 1
                if nliketyp >= 3 and typ > 0:
                    #print(nliketyp)
                    for dj in range(nliketyp):
                        crushed[ylen-dj-1][i] = True
                    crushed_some = True

            #print(crushed)
            if not crushed_some:
                break

            for i in range(xlen):
                wj = ylen-1
                for j in range(ylen-1, -1, -1):
                    if crushed[j][i]:
                        continue
                    board[wj][i] = board[j][i]
                    wj -= 1
                for j in range(wj, -1, -1):
                    board[j][i] = 0

            #break
        
        return board
        