class Solution(object):
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        ni, nj = len(matrix), len(matrix[0])
        
        for j in xrange(nj):
            x = matrix[0][j]
            for i in xrange(ni):
                if i+j < nj:
                    if matrix[i][i+j] != x:
                        return False
                else:
                    break
                    
        for i in xrange(ni):
            x = matrix[i][0]
            for j in xrange(nj):
                if i+j<ni:
                    if matrix[i+j][j] != x:
                        return False
                else:
                    break
        
        return True
                