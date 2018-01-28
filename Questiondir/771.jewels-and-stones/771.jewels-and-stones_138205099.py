class Solution(object):
    def slidingPuzzle(self, board):
        """
        :type board: List[List[int]]
        :rtype: int
        """
        moves=[[1,3],[0,2,4],[1,5],[0,4],[1,3,5],[2,4]]
        initial=(board[0]+board[1])
        if initial==[1,2,3,4,5,0]:
            return 0
        d={tuple(initial)}
        b=[[initial,0]]
        i=0
        while i<len(b):
            state=b[i][0]
            pos=state.index(0)
            for j in moves[pos]:
                ns=state[:]
                ns[pos]=ns[j]
                ns[j]=0
                if ns==[1,2,3,4,5,0]: 
                    return b[i][1]+1
                if tuple(ns) not in d:
                    d.add(tuple(ns))
                    b.append([ns,b[i][1]+1])
            i+=1        
        return -1
        
        