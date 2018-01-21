class Solution(object):
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        index = {}
        for i,n in enumerate(B):
            index[n] = i
        return [index[x] for x in A]