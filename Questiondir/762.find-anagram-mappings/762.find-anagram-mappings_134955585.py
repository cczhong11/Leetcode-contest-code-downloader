class Solution(object):
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        parsed_B = dict()
        for index in range(len(B)):
            parsed_B[B[index]] = index
        res = list()
        for i in A:
            res.append(parsed_B[i])
        return res