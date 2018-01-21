class Solution(object):
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        if not matrix or not matrix[0]: return False
        
        for i in range(len(matrix)):
            r, c = i+1, 1
            while r<len(matrix) and c<len(matrix[0]):
                if matrix[r][c] != matrix[r-1][c-1]:
                    return False
                r += 1
                c += 1
        
        for j in range(len(matrix[0])):
            r, c = 1, j+1
            while r<len(matrix) and c<len(matrix[0]):
                if matrix[r][c] != matrix[r-1][c-1]:
                    return False
                r += 1
                c += 1
            
        return True
        