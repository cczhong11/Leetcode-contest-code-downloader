class Solution(object):
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        N = len(A)
        result = [0 for _ in xrange(N)]
        ind1 = range(N)
        ind2 = range(N)
        ind1.sort(key=lambda x: A[x])
        ind2.sort(key=lambda x: B[x])
        for i1, i2 in zip(ind1, ind2):
            result[i1] = i2
        return result