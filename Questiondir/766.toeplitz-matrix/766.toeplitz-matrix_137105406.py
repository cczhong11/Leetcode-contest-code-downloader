class Solution:
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        ROW, COL = len(matrix), len(matrix[0])
        def good(r, c):
            n = matrix[r][c]
            while True:
                r += 1
                c += 1
                if r >= ROW or c >= COL: break
                if matrix[r][c] != n: return False
            return True
                
        return all(good(r, 0) for r in range(ROW)) and all(good(0, c) for c in range(1, COL))