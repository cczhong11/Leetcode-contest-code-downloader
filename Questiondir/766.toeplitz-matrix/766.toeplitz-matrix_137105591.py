class Solution(object):
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        if not matrix or not matrix[0]:
            return True
        m,n=len(matrix),len(matrix[0])
        save={i:matrix[i][0] for i in xrange(m)}
        for j in xrange(n):
            save[-j]=matrix[0][j]
        for i in xrange(1,m):
            for j in xrange(1,n):
                if save[i-j]!=matrix[i][j]:
                    return False
        return True