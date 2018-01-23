class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        if not matrix:
            return [[]]
        m = len(matrix)
        n = len(matrix[0])
        ans = [[-1]*n for _ in xrange(m)]
        cnt = 0
        for i in xrange(m):
            for j in xrange(n):
                if matrix[i][j] == 0:
                    ans[i][j] = 0
                else:
                    cnt += 1
        x = 0
        while cnt > 0:
            for i in xrange(m):
                for j in xrange(n):
                    if ans[i][j] == x:
                        if i > 0 and ans[i-1][j] == -1:
                            ans[i-1][j] = x+1
                            cnt -= 1
                        if j > 0 and ans[i][j-1] == -1:
                            ans[i][j-1] = x+1
                            cnt -= 1
                        if i < m - 1 and ans[i+1][j] == -1:
                            ans[i+1][j] = x+1
                            cnt -= 1
                        if j < n - 1 and ans[i][j+1] == -1:
                            ans[i][j+1] = x+1
                            cnt -= 1
            x += 1
        return ans
            
        