from collections import deque
class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        if len(matrix) == 0:
            return matrix
        q = deque()
        for y in range(len(matrix)):
            for x in range(len(matrix[0])):
                if matrix[y][x] == 0:
                    q.append((y, x))
                else:
                    matrix[y][x] = 10000
        
        while len(q):
            y, x = q.popleft()
            for j, i in [(y,x+1), (y,x-1), (y+1,x), (y-1,x)]:
                if 0 <= j < len(matrix) and 0 <= i < len(matrix[0]) and matrix[j][i] > matrix[y][x]+1:
                    matrix[j][i] = matrix[y][x]+1
                    q.append((j, i))
        
        return matrix
                    