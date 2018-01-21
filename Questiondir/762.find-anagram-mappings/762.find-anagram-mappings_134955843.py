class Solution:
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        ind = {}
        for i, v in enumerate(B):
            ind.setdefault(v, []).append(i)
        
        answer = []
        for i in A:
            answer.append(ind[i].pop())
            
        return answer