class Solution:
    def isOneBitCharacter(self, bits):
        """
        :type bits: List[int]
        :rtype: bool
        """
        n = len(bits)
        i = 0
        while i<n:
            if bits[i]:
                if i+1<n: i += 2
            else:
                if i==n-1: return True
                i += 1
        return False