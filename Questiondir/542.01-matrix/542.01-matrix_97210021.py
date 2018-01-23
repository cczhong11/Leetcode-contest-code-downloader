class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        n = len(matrix)
        if n==0:
            return []
        m = len(matrix[0])
        
        q = [(i,j,0) for i in range(n) for j in range(m) if matrix[i][j] == 0]
        visited = {(i,j) for i in range(n) for j in range(m) if matrix[i][j] == 0}
        ret = [[0 for _ in range(m)] for _ in range(n)]
        for i,j,k in q:
            for ii,jj in [(i+1,j), (i-1,j), (i,j+1), (i,j-1)]:
                if 0<=ii<n and 0<=jj<m and (ii,jj) not in visited:
                    ret[ii][jj] = k+1
                    q.append((ii,jj,k+1))
                    visited.add((ii,jj))
        return ret