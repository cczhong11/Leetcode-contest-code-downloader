class Solution(object):
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        M = matrix
        m,n = len(M), len(M[0])
        for x,y in list((i,0) for i in range(m-1,0,-1)) + list((0,j) for j in range(n)):
            val = M[x][y]
            x,y = x+1, y+1
            while 0<=x<m and 0<=y<n:
                if val != M[x][y]:
                    return False
                x,y = x+1, y+1
        return True
        
