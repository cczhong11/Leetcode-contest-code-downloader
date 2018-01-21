class Solution(object):
    def candyCrush(self, board):
        """
        :type board: List[List[int]]
        :rtype: List[List[int]]
        """
        from numpy import array,zeros_like
        board=array(board)
        while True:
        	mask=zeros_like(board,dtype=bool)
        	heng=(board[:,:-2]==board[:,1:-1])*((board[:,2:]==board[:,1:-1]))*(board[:,1:-1]!=0)
        	ids=heng.nonzero()
        	mask[ids[0],ids[1]]=mask[ids[0],ids[1]+1]=mask[ids[0],ids[1]+2]=True
        	shu=(board[:-2]==board[1:-1])*((board[2:]==board[1:-1]))*(board[1:-1]!=0)
        	ids=shu.nonzero()
        	mask[ids[0],ids[1]]=mask[ids[0]+1,ids[1]]=mask[ids[0]+2,ids[1]]=True
        	if mask.sum()==0:
        		return [[int(j) for j in i] for i in board]
        	board[mask]=False
        	for i in range(board.shape[1]):
        		t=len(board[board[:,i]!=0,i])
        		if t==0:
        			board[:,i]=0
        			continue
        		board[-t:,i]=board[board[:,i]!=0,i]
        		board[:-t,i]=0