class Solution(object):
    def candyCrush(self, board):
        """
        :type board: List[List[int]]
        :rtype: List[List[int]]
        """
        def BFS(i,j):
            que=collections.deque([(i,j)])
            val=board[i][j]
            visit.add((i,j))
            locs=[]
            while que:
                u,v=que.popleft()
                locs.append((u,v))
                for uu,vv in [(u,v-1),(u,v+1),(u-1,v),(u+1,v)]:
                    if 0<=uu<M and 0<=vv<N and board[uu][vv]==val and (uu,vv) not in visit:
                        visit.add((uu,vv))
                        que.append((uu,vv))
            return locs
            
        def crush():
            vert=set()
            hori=set()
            for i in range(M):
                for j in range(N):
                    if board[i][j]!=0:
                        if (i,j) not in vert:
                            k=i
                            locs=[]
                            while k<M and board[k][j]==board[i][j]:
                                locs.append((k,j))
                                k+=1
                            if len(locs)>=3:
                                vert.update(locs)
                                
                        if (i,j) not in hori:
                            k=j
                            locs=[]
                            while k<N and board[i][k]==board[i][j]:
                                locs.append((i,k))
                                k+=1
                            if len(locs)>=3:
                                hori.update(locs)       
            for i,j in list(vert):
                board[i][j]=0
            for i,j in list(hori):
                board[i][j]=0
            return
        
        def drop():
            flag=False
            for j in range(N):
                end=M-1
                for i in range(M)[::-1]:
                    if board[i][j]!=0:
                        if i!=end:
                            flag=True
                        board[i][j],board[end][j]=board[end][j],board[i][j]
                        end-=1
            return flag
        
        if not board:
            return board
        M,N=len(board),len(board[0])
        can_play=True
        while can_play:
            crush()
            can_play=drop()
            
        return board
            
                    