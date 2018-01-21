class Solution(object):
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        lAB = len(A)
        hmB = {}
        for i in range(lAB):
            if B[i] in hmB:
                hmB[B[i]].append(i)
            else:
                hmB[B[i]] = [i]
                
        result = [0 for _ in range(lAB)]
        for i in range(lAB):
            result[i] = hmB[A[i]].pop()
            
        return result
        
        