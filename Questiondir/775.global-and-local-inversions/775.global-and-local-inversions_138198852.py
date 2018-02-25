class Solution(object):
    def isIdealPermutation(self, A):
        """
        :type A: List[int]
        :rtype: bool
        """
        lA = len(A)
        i = 0
        
        while i < len(A) - 1:
            if A[i] == i:
                i += 1
            elif A[i] == (i+1) and A[i+1] == i:
                i += 2
            else:
                return False
            
        return True
        