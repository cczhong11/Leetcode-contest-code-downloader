class Solution:
    def isToeplitzMatrix(self, matrix):
        m = len(matrix)
        n = len(matrix[0])
        if m==1 or n==1:
            return True
        for i in range(n-1):
            s = matrix[0][i]
            for j in range(1, m):
                if j+i<n and matrix[j][i+j]!=s:
                    return False
        for i in range(1,m-1):
            s = matrix[i][0]
            for j in range(1, n):
                if j+i<m and matrix[i+j][j]!=s:
                    return False
        return True
            
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        