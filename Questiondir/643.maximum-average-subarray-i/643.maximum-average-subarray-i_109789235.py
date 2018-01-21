class Solution(object):
    def findMaxAverage(self, A, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
        cand = sum(A[:k])
        ret = cand
        for i in xrange(k, len(A)):
            cand = cand + A[i] - A[i-k]
            ret = max(ret, cand)
        return float(ret) / k

