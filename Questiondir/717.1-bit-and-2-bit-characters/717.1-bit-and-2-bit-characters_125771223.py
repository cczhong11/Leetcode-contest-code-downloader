class Solution(object):
    def isOneBitCharacter(self, bits):
        """
        :type bits: List[int]
        :rtype: bool
        """
        can = [False]*(len(bits)+1)
        can[0] = True
        for i in range(len(bits)-1):
            if can[i]:
                if bits[i] == 0:
                    can[i+1] = True
                else:
                    can[i+2] = True
        return can[len(bits)-1]
        