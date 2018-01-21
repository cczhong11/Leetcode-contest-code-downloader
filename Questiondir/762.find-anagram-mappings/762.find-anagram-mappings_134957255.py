class Solution(object):
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        ret = []
        d = {}
        n = len(B)
        for j in xrange(n):
            d[B[j]] = j
        return [d[x] for x in A]