class Solution(object):
    def checkPossibility(self, A):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(A) == 1: return True
        checks = [x<=y for x,y in zip(A, A[1:])]
        if all(checks): return True
        
        B = A[:]
        
        mistakes = 0
        for i, x in enumerate(A):
            if i+1 >= len(A) or x <= A[i+1]: continue
            A[i+1] = A[i]
            mistakes += 1
        if mistakes <= 1:
            return True
            
        mistakes = 0
        for i, x in enumerate(B):
            if i+1 >= len(B) or x <= B[i+1]: continue
            B[i] = B[i+1]
            mistakes += 1
            if i > 0 and B[i-1] > B[i]: return False
        return mistakes <= 1