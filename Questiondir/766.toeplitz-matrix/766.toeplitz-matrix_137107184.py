class Solution(object):
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        M = len(matrix)
        N = len(matrix[0])
        for i in range(M):
            for j in range(1, min(N, M-i)):
                if matrix[i+j][j] != matrix[i+j-1][j-1]:
                    return False
        for j in range(N):
            for i in range(1, min(N-j, M)):
                if matrix[i][j+i] != matrix[i-1][j+i-1]:
                    return False
        return True