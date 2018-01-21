class Solution:
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """     
        m = len(matrix)
        n = len(matrix[0])
        # for j in range(n):
        #     orig = matrix[0][j]
        #     for i in range(1, m-j):
        #         if matrix[i][j+i] != orig: return False
        #         
        orig = matrix[0]
        for i in range(1, m):
            for j in range(n-1):
                if orig[j] != matrix[i][j+1]: return False
            orig = matrix[i]        
        return True