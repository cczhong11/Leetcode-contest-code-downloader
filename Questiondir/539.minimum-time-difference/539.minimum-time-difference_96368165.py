class Solution(object):
    def findMinDifference(self, A):
        """
        :type timePoints: List[str]
        :rtype: int
        """
        def cvt(x):
            a, b = x.split(':')
            return 60*int(a) + int(b)
        A = map(cvt, A)
        A.sort()
        ans = (A[0] - A[-1])%(24*60)
        for i in xrange(len(A)-1):
            ans = min(ans, A[i+1] - A[i])
        return ans