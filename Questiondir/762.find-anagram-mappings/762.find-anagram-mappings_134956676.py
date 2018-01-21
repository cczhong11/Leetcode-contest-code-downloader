class Solution(object):
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        n = len(A)
        d = collections.defaultdict(list)
        for i in range(n):
            d[B[i]].append(i)
        
        res = []
        for i in range(n):
            res.append(d[A[i]].pop())
        return res
        