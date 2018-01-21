class Solution(object):
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        m, n = len(matrix), len(matrix[0])
        for k in range(m - 1, -1, -1):
            i, j = k, 0
            num = matrix[i][j]
            i += 1
            j += 1
            while i < m and j < n:
                if matrix[i][j] != num:
                    return False
                i += 1
                j += 1
        for k in range(1, n):
            i, j = 0, k
            num = matrix[i][j]
            i += 1
            j += 1
            while i < m and j < n:
                if matrix[i][j] != num:
                    return False
                i += 1
                j += 1
        return True
                