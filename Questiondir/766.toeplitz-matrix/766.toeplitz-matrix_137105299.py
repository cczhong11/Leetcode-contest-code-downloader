class Solution:
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        flag = True
        M = len(matrix)
        N = len(matrix[0])

        def inBrd(x, y):
            return x<M and y<N

        for i in range(0, M):
            x = i
            y = 0
            s = matrix[x][y]
            x += 1
            y += 1
            while inBrd(x, y):
                if s != matrix[x][y]:
                    flag = False
                    break
                else:
                    x += 1
                    y += 1
            if not flag:
                break

        for j in range(1, N):
            x = 0
            y = j
            s = matrix[x][y]
            x += 1
            y += 1
            while inBrd(x, y):
                if s != matrix[x][y]:
                    flag = False
                    break
                else:
                    x += 1
                    y += 1
            if not flag:
                break

        return flag
