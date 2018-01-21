class Solution(object):
    def findLength(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: int
        """
        table = [[0 for i in xrange(len(A) + 1)] for j in xrange(len(B) + 1)]
        res = 0
        for i in xrange(len(A)):
            for j in xrange(len(B)):
                if A[i] == B[j]:
                    table[i+1][j+1] = table[i][j] + 1
                    res = max(res, table[i+1][j+1])
        return res