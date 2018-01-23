class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        m,n = len(matrix), len(matrix[0])
        ret = [[0]*n for i in range(m)]
        visited = [[0]*n for i in range(m)]
        q = [(i,j,0)  for i in range(m)
                    for j in range(n)
                    if matrix[i][j] == 0]
        for i,j,t in q:
            visited[i][j] = 1
            ret[i][j] = 0
        while len(q) > 0:
            i,j,t = q.pop(0)
            for x,y in [(i+1,j), (i-1,j), (i,j+1), (i,j-1)]:
                if not 0<=x<m or not 0<=y<n:
                    continue
                if visited[x][y]:
                    continue
                ret[x][y] = t+1
                visited[x][y] = 1
                q.append((x,y,t+1))
        return ret

