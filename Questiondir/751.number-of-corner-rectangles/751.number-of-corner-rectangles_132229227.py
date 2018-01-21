class Solution(object):
    def countCornerRectangles(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        N = len(grid)
        M = len(grid[0])

        rowOnes = []
        rowSets = []
        for row in grid:
            res = []
            for i, val in enumerate(row):
                if val:
                    res.append(i)
            rowOnes.append(res)
            #rowSets.append(set(res))

        columnSets = [set() for _ in xrange(M)]

        for i in xrange(N):
            for j in xrange(M):
                if grid[i][j]:
                    columnSets[j].add(i)

        result = 0
        for i in xrange(N):
            row = rowOnes[i]
            for val in row:
                columnSets[val].remove(i)
            for j in xrange(len(row)):
                idx1 = row[j]
                for j2 in xrange(j+1, len(row)):
                    idx2 = row[j2]

                    cs = columnSets[idx1] & columnSets[idx2]
                    result += len(cs)

        return result
                    
                    
        
        
        