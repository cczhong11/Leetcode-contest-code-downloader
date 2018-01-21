class Solution(object):
    def repeatedStringMatch(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: int
        """
        
        i = 1
        A0 = A
        while len(A) < 2*len(B):
            if B in A:
                return i
            i += 1
            A += A0
        if B in A:
            return i
        else:
            return -1
        