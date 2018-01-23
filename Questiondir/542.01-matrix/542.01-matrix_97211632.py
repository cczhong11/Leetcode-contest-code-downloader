class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        r, c = len(matrix), len(matrix[0])
        def inrange(i, j):
            if 0 <= i < r and 0 <= j < c:
                return True
            else:
                return False
        result = [[-1 for j in range(c)] for i in range(r)]
        Front = set()
        for i in range(r):
            for j in range(c):
                if matrix[i][j] == 0:
                    Front.add((i, j))
                    result[i][j] = 0
        cur_dis = 1
        while len(Front) > 0:
            newFront = set()
            for i, j in Front:
                for x, y in [(i+1, j), (i-1, j), (i, j+1), (i, j-1)]:
                    if inrange(x, y):
                        if result[x][y] == -1:
                            result[x][y] = cur_dis
                            newFront.add((x, y))
            Front = newFront
            cur_dis += 1
        return result
                        