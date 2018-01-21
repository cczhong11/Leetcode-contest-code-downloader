class Solution(object):
    def repeatedStringMatch(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: int
        """
        if not A: return 0
        t = (len(B)-1)/len(A) + 1
        s = A * t
        if B in s:
            return t
        if B in s+A:
            return t+1
        return -1