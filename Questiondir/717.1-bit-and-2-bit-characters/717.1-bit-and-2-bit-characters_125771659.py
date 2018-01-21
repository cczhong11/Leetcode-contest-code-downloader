class Solution(object):
    def isOneBitCharacter(self, bits):
        """
        :type bits: List[int]
        :rtype: bool
        """
        h = 0
        while h < len(bits) - 2:
            if bits[h] == 1:
                h += 2
            elif bits[h] == 0:
                h += 1
        if h == len(bits):
            return False
        elif h == len(bits) - 1:
            return True
        elif h == len(bits) - 2 and bits[h] == 1:
            return False
        return True