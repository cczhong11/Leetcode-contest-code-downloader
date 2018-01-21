class Solution(object):
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        nRow = len(matrix)
        nCol = len(matrix[0])
        startList = []
        for i in range(nRow):
            startList.append((i, 0))
        for i in range(nCol):
            startList.append((0, i))
        
        for iStart, jStart in startList:
            i, j = iStart, jStart
            want = matrix[iStart][jStart]
            fail = False
            while i<nRow and j<nCol:
                if matrix[i][j] != want:
                    fail = True
                    break
                i+=1
                j+=1
            if fail:
                return False
        return True