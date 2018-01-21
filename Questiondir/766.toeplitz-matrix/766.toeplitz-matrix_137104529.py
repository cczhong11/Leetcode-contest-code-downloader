class Solution(object):
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        for i in xrange(1,len(matrix)):
            for j in xrange(1,len(matrix[i])):
                if matrix[i][j]!=matrix[i-1][j-1]:
                    return False
        return True