class Solution:
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        
        if not matrix:
            return true
        
        N, M = len(matrix), len(matrix[0])
        
        for i in range(N):
            x = i
            j = 0
            s = set([matrix[x][j]])
            while x + 1 < N and j + 1 < M:
                x += 1
                j += 1
                s.add(matrix[x][j])
                
            if len(s) > 1:
                return False
        
        for i in range(1, M):
            x = 0
            j = i
            s = set([matrix[x][j]])
            while x + 1 < N and j + 1 < M:
                x += 1
                j += 1
                s.add(matrix[x][j])
                
            if len(s) > 1:
                return False
            
        return True