class Solution(object):
    def maxDistance(self, A):
        """
        :type arrays: List[List[int]]
        :rtype: int
        """
        minA = A[0][0]
        maxA = A[0][-1]
        res = -1
        for i in range(1,len(A)):
            res = max(res, abs(A[i][-1]-minA))
            res = max(res, abs(A[i][0]-maxA))
            minA = min(minA,A[i][0])
            maxA = max(maxA,A[i][-1])
        return res