class Solution(object):
    def imageSmoother(self, M):
        """
        :type M: List[List[int]]
        :rtype: List[List[int]]
        """
        n = len(M)
        if n==0: return M
        m = len(M[0])
        dx = [-1,-1,-1,0,0,0,1,1,1]
        dy = [-1,0,1,-1,0,1,-1,0,1]
        t = [[0] * m for i in range(n)]
        for i in range(n):
            for j in range(m):
                total = 0
                sumT = 0
                for k in range(9):
                    x,y = i + dx[k], j + dy[k]
                    if x<0 or y<0 or x==n or y==m: continue
                    total +=1
                    sumT += M[x][y]
                t[i][j] = int(sumT/total)
        return t