class Solution(object):
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        m = len(matrix)
        n = len(matrix[0]) if m else 0
        if m * n == 0:
            return True
        alls = set()
        for i in range(m-1, -1, -1):
            alls.add((i, 0))
        for i in range(n):
            alls.add((0, i))
        for x, y in alls:
            t = matrix[x][y]
            i, j = x, y
            while i < m and j < n:
                if matrix[i][j] != t:
                    return False
                i += 1
                j += 1
        return True